package org.woehlke.btw17.kandidaten.oodm.importer.enrich;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.InstitutionArt;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.parts.Institution;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {
                KandidatenApplication.class,
                DataSourceConfig.class,
                HttpSessionConfig.class,
                WebMvcConfig.class,
                WebSecurityConfig.class
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WahlperiodeEnricher {

    private static final Logger log = LoggerFactory.getLogger(WahlperiodeEnricher.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SpringProperties springProperties;

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @Autowired
    private OtherProperties otherProperties;

    @Autowired
    private BerufService berufService;

    @Autowired
    private BerufsgruppeService berufsgruppeService;

    @Autowired
    private BundeslandService bundeslandService;

    @Autowired
    private GeburtsortService geburtsortService;

    @Autowired
    private KandidatService kandidatService;

    @Autowired
    private ListeParteiService listeParteiService;

    @Autowired
    private ParteiService parteiService;

    @Autowired
    private LandesListeService landesListeService;

    @Autowired
    private WahlkreisService wahlkreisService;

    @Autowired
    private WohnortService wohnortService;

    @Autowired
    private MinisteriumService ministeriumService;

    @Autowired
    private FraktionService fraktionService;

    @Autowired
    private AusschussService ausschussService;

    @Autowired
    private KandidatReportService kandidatReportService;

    @Autowired
    private WebseiteAgenturService webseiteAgenturService;

    @Autowired
    private WebseiteCmsService webseiteCmsService;

    @Autowired
    private Btw17ErgebnisService btw17ErgebnisService;

    @Autowired
    private Btw17StrukturdatenService btw17StrukturdatenService;

    @Autowired
    private Btw17WahlbewerberService btw17WahlbewerberService;

    @Autowired
    private Btw17WahlkreisService btw17WahlkreisService;

    @Autowired
    private Btw17KandidatFlatService btw17KandidatFlatService;

    @Autowired
    private Btw17MdbService btw17MdbService;

    @Autowired
    private Btw17WahlperiodeService btw17WahlperiodeService;

    @Autowired
    private WahlperiodeService wahlperiodeService;

    @Autowired
    private JdbcService jdbcService;



    @WithMockUser
    @Commit
    @Test
    public void test000controllerIsPresentTest(){
        log.info("test000controllerIsPresentTest");
        assertThat(mockMvc).isNotNull();
        assertThat(kandidatenProperties).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("test000serviceIsPresentTest");
        assertThat(btw17WahlkreisService).isNotNull();
        assertThat(btw17StrukturdatenService).isNotNull();
        assertThat(wahlkreisService).isNotNull();
        assertThat(bundeslandService).isNotNull();
        assertThat(btw17ErgebnisService).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test010updateWahlperiodeByBtw17Wahlperiode() throws Exception {
        log.info("test010updateWahlperiodeByBtw17Wahlperiode");
        Long maxId = wahlperiodeService.getMaxId();
        log.info("maxId: "+maxId);
        if(maxId == null){
            maxId = 0L;
        }
        maxId++;
        String sql ="ALTER SEQUENCE hibernate_sequence RESTART WITH "+maxId;
        jdbcService.executeSqlStatemen(sql);
        for(Btw17Wahlperiode btw17Wahlperiode : btw17WahlperiodeService.getAll()){
            Wahlperiode o = new Wahlperiode();
            Long wahlperiode = Long.parseLong(btw17Wahlperiode.getWp());
            o.setWahlperiode(wahlperiode);

            if(btw17Wahlperiode.getWkrnummer()!=null){
                Long wkrnummer = Long.parseLong(btw17Wahlperiode.getWkrnummer());
                Wahlkreis wahlkreis = wahlkreisService.findByWahlkreisId(wkrnummer);
                if(wahlkreis == null){
                    log.warn("wahlkreis == null");
                }
                o.setWahlkreis(wahlkreis);
            } else {
                log.warn("wkrnummer == null");
            }

            String liste = btw17Wahlperiode.getListe();
            if(liste != null){
                switch (liste){
                    case "BRA": o.setBundeslandLandesListe(BundeslandEnum.BB); break;
                    case "SWH": o.setBundeslandLandesListe(BundeslandEnum.SH); break;
                    case "BRE": o.setBundeslandLandesListe(BundeslandEnum.HB); break;
                    case "HBG": o.setBundeslandLandesListe(BundeslandEnum.HH); break;
                    case "SAC": o.setBundeslandLandesListe(BundeslandEnum.SN); break;
                    case "NRW": o.setBundeslandLandesListe(BundeslandEnum.NW); break;
                    case "RPF": o.setBundeslandLandesListe(BundeslandEnum.RP); break;
                    case "MBV": o.setBundeslandLandesListe(BundeslandEnum.MV); break;
                    case "BWG": o.setBundeslandLandesListe(BundeslandEnum.BW); break;
                    case "HES": o.setBundeslandLandesListe(BundeslandEnum.HE); break;
                    case "BW":  o.setBundeslandLandesListe(BundeslandEnum.BW); break;
                    case "NDS": o.setBundeslandLandesListe(BundeslandEnum.NI); break;
                    case "BAY": o.setBundeslandLandesListe(BundeslandEnum.BY); break;
                    case "SLD": o.setBundeslandLandesListe(BundeslandEnum.SL); break;
                    case "THÜ": o.setBundeslandLandesListe(BundeslandEnum.TH); break;
                    case "SAA": o.setBundeslandLandesListe(BundeslandEnum.ST); break;
                    case "NI":  o.setBundeslandLandesListe(BundeslandEnum.NI); break;
                    case "BLN": o.setBundeslandLandesListe(BundeslandEnum.BE); break;
                    default:
                        o.setBundeslandLandesListe(null);
                    //case "***": break;
                }
            }
            String mandatsArt = btw17Wahlperiode.getMandatsart();
            switch(mandatsArt){
                case "Volkskammer": o.setMandatsArt(Mandatsart.VOLKSKAMMER); break;
                case "Direktwahl" : o.setMandatsArt(Mandatsart.DIREKTWAHL); break;
                case "Landesliste": o.setMandatsArt(Mandatsart.LANDESLISTE); break;
                default:
                    log.warn("mandatsArt == "+mandatsArt);
                    log.warn(btw17Wahlperiode.toString());
                    break;
            }

            Institution institution = o.getInstitution();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            String a = btw17Wahlperiode.getMdbwpvon();
            if(a != null) {
                log.info("mdbWahlperiodeVon: " + a);
                LocalDate mdbWahlperiodeVon = LocalDate.parse(a, formatter);
                o.setMdbWahlperiodeVon(mdbWahlperiodeVon);
            }

            String b = btw17Wahlperiode.getMdbwpbis();
            if(b!=null) {
                log.info("mdbWahlperiodeBis: " + b);
                LocalDate mdbWahlperiodeBis = LocalDate.parse(b, formatter);
                o.setMdbWahlperiodeBis(mdbWahlperiodeBis);
            }

            String institutionArtLang= btw17Wahlperiode.getInsartlang();
            switch (institutionArtLang){
                case "Ausschuss":
                    institution.setInstitutionArtLang(InstitutionArt.AUSSCHUSS);
                    break;
                case "Deutscher Bundestag":
                    institution.setInstitutionArtLang(InstitutionArt.DEUTSCHER_BUNDESTAG);
                    break;
                case "Arbeitsgruppe":
                    institution.setInstitutionArtLang(InstitutionArt.ARBEITSGRUPPE);
                    break;
                case "Sonstiges Gremium":
                    institution.setInstitutionArtLang(InstitutionArt.SONSTIGES_GREMIUM);
                    break;
                case "Ministerium":
                    institution.setInstitutionArtLang(InstitutionArt.MINISTERIUM);
                    break;
                case "Unterausschuss":
                    institution.setInstitutionArtLang(InstitutionArt.UNTERAUSSCHUSS);
                    break;
                case "Untersuchungsausschuss":
                    institution.setInstitutionArtLang(InstitutionArt.UNTERSUCHUNGSAUSSCHUSS);
                    break;
                case "Fraktion/Gruppe":
                    institution.setInstitutionArtLang(InstitutionArt.FRAKTION_GRUPPE);
                    break;
            }

            String institutionLang = btw17Wahlperiode.getInslang();
            String funktionLang = btw17Wahlperiode.getFktlang();

            institution.setInstitutionLang(institutionLang);
            institution.setFunktionLang(funktionLang);

            String c = btw17Wahlperiode.getMdbinsvon();
            if(c != null){
                log.info("mdbInstitutionVon: " + a);
                LocalDate mdbInstitutionVon = LocalDate.parse(c, formatter);
                institution.setMdbInstitutionVon(mdbInstitutionVon);
            }
            String d = btw17Wahlperiode.getMdbinsbis();
            if(d != null) {
                log.info("mdbInstitutionBis: " + a);
                LocalDate mdbInstitutionBis = LocalDate.parse(d, formatter);
                institution.setMdbInstitutionBis(mdbInstitutionBis);
            }
            String e = btw17Wahlperiode.getFktinsvon();
            if(e != null) {
                log.info("funktionInstitutionVon: " + a);
                LocalDate funktionInstitutionVon = LocalDate.parse(e, formatter);
                institution.setFunktionInstitutionVon(funktionInstitutionVon);
            }
            String f = btw17Wahlperiode.getFktinsbis();
            if(f != null) {
                log.info("funktionInstitutionBis: " + a);
                LocalDate funktionInstitutionBis = LocalDate.parse(f, formatter);
                institution.setFunktionInstitutionBis(funktionInstitutionBis);
            }
            o.setInstitution(institution);
            o = wahlperiodeService.create(o);
            log.info("added: "+o.toString());
            log.info("added: "+o.getUniqueId());
        }
    }
}
