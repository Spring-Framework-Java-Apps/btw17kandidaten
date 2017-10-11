package org.woehlke.btw17.kandidaten.oodm.bundestag.enrich;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.enums.InstitutionArt;
import org.woehlke.btw17.kandidaten.oodm.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.model.enums.Religion;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17MdbService;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlperiodeService;
import org.woehlke.btw17.kandidaten.oodm.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

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
public class KandidatEnricher {


        private static final Logger log = LoggerFactory.getLogger(AusschussEnricher.class);

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
        private JdbcService jdbcService;

        @Autowired
        private WahlperiodeService wahlperiodeService;

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
            Long maxId = kandidatService.getMaxId();
            log.info("maxId: " + maxId);
            if (maxId == null) {
                maxId = 0L;
            }
            maxId++;
            String sql = "ALTER SEQUENCE hibernate_sequence RESTART WITH " + maxId;
            jdbcService.executeSqlStatemen(sql);

            int page = FIRST_PAGE_NUMBER;
            int size = PAGE_SIZE;
            Pageable pageable = new PageRequest(page, size);

            Page<Btw17Mdb> btw17MdbPage = btw17MdbService.getAll(pageable);
            long resultSize = btw17MdbPage.getTotalElements();
            log.debug("found: # " + resultSize);
            boolean goOn = true;
            while (goOn) {
                for (Btw17Mdb btw17Mdb :btw17MdbPage.getContent()) {
                    boolean ignore = true;
                    Set<Wahlperiode> wahlperioden = new LinkedHashSet<>();

                    for (Btw17Wahlperiode btw17Wahlperiode : btw17Mdb.getWahlperioden()) {
                        String wp = btw17Wahlperiode.getWp();
                        String wkrnummer = btw17Wahlperiode.getWp();
                        String inslang = btw17Wahlperiode.getInslang();
                        String fktlang = btw17Wahlperiode.getFktlang();

                        Long wahlperiodeId = Long.parseLong(wp);
                        Long wahlkreisId = Long.parseLong(wkrnummer);

                        if ((wahlperiodeId == 17) || (wahlperiodeId == 18)) {
                            ignore = false;
                        }

                        if (!ignore) {

                            Wahlkreis wahlkreis = wahlkreisService.findByWahlkreisId(wahlkreisId);

                            BundeslandEnum bundeslandLandesListe = null;

                            String liste = btw17Wahlperiode.getListe();
                            if (liste != null) {
                                switch (liste) {
                                    case "BRA":
                                        bundeslandLandesListe = BundeslandEnum.BB;
                                        break;
                                    case "SWH":
                                        bundeslandLandesListe = BundeslandEnum.SH;
                                        break;
                                    case "BRE":
                                        bundeslandLandesListe = BundeslandEnum.HB;
                                        break;
                                    case "HBG":
                                        bundeslandLandesListe = BundeslandEnum.HH;
                                        break;
                                    case "SAC":
                                        bundeslandLandesListe = BundeslandEnum.SN;
                                        break;
                                    case "NRW":
                                        bundeslandLandesListe = BundeslandEnum.NW;
                                        break;
                                    case "RPF":
                                        bundeslandLandesListe = BundeslandEnum.RP;
                                        break;
                                    case "MBV":
                                        bundeslandLandesListe = BundeslandEnum.MV;
                                        break;
                                    case "HES":
                                        bundeslandLandesListe = BundeslandEnum.HE;
                                        break;
                                    case "BW":
                                        bundeslandLandesListe = BundeslandEnum.BW;
                                        break;
                                    case "NDS":
                                        bundeslandLandesListe = BundeslandEnum.NI;
                                        break;
                                    case "BAY":
                                        bundeslandLandesListe = BundeslandEnum.BY;
                                        break;
                                    case "SLD":
                                        bundeslandLandesListe = BundeslandEnum.SL;
                                        break;
                                    case "THÜ":
                                        bundeslandLandesListe = BundeslandEnum.TH;
                                        break;
                                    case "SAA":
                                        bundeslandLandesListe = BundeslandEnum.ST;
                                        break;
                                    case "NI":
                                        bundeslandLandesListe = BundeslandEnum.NI;
                                        break;
                                    case "BLN":
                                        bundeslandLandesListe = BundeslandEnum.BE;
                                        break;
                                }
                            }
                            Mandatsart mandatsArt = null;
                            String mandatsart = btw17Wahlperiode.getMandatsart();
                            if (mandatsart != null) {
                                switch (mandatsart) {
                                    case "Volkskammer":
                                        mandatsArt = Mandatsart.VOLKSKAMMER;
                                        break;
                                    case "Landesliste":
                                        mandatsArt = Mandatsart.LANDESLISTE;
                                        break;
                                    case "Direktwahl":
                                        mandatsArt = Mandatsart.DIREKTWAHL;
                                        break;
                                }
                            }

                            InstitutionArt institutionArtLang = null;
                            String insartlang = btw17Wahlperiode.getInsartlang();
                            if (insartlang != null) {
                                switch (insartlang) {
                                    case "Ausschuss":
                                        institutionArtLang = InstitutionArt.AUSSCHUSS;
                                        break;
                                    case "Deutscher Bundestag":
                                        institutionArtLang = InstitutionArt.DEUTSCHER_BUNDESTAG;
                                        break;
                                    case "Arbeitsgruppe":
                                        institutionArtLang = InstitutionArt.ARBEITSGRUPPE;
                                        break;
                                    case "Sonstiges Gremium":
                                        institutionArtLang = InstitutionArt.SONSTIGES_GREMIUM;
                                        break;
                                    case "Ministerium":
                                        institutionArtLang = InstitutionArt.MINISTERIUM;
                                        break;
                                    case "Unterausschuss":
                                        institutionArtLang = InstitutionArt.UNTERAUSSCHUSS;
                                        break;
                                    case "Untersuchungsausschuss":
                                        institutionArtLang = InstitutionArt.UNTERSUCHUNGSAUSSCHUSS;
                                        break;
                                    case "Fraktion/Gruppe":
                                        institutionArtLang = InstitutionArt.FRAKTION_GRUPPE;
                                        break;
                                }
                            }

                            Wahlperiode wahlperiode = wahlperiodeService.findByBtw17Wahlperiode(wahlperiodeId, wahlkreis, bundeslandLandesListe, mandatsArt, institutionArtLang, inslang, fktlang);

                            wahlperioden.add(wahlperiode);
                        }
                    }
                    if (!ignore) {

                        String geburtsortStr = btw17Mdb.getGeburtsort();
                        Geburtsort geburtsort = null;
                        if (geburtsortStr != null) {
                            geburtsort = geburtsortService.findByGeburtsort(geburtsortStr);
                            if (geburtsort == null) {
                                log.error("no Geburtsort found for " + geburtsortStr);
                            }
                        }

                        String berufStr = btw17Mdb.getBeruf();
                        Beruf beruf = null;
                        if (berufStr != null) {
                            beruf = berufService.findByBeruf(berufStr);
                            if (beruf == null) {
                                log.error("no Beruf found for " + berufStr);
                            }
                        }

                        String geschlechtStr = btw17Mdb.getGeschlecht();
                        String nachname = btw17Mdb.getNachname();
                        String vorname = btw17Mdb.getVorname();
                        String geburtsdatumStr = btw17Mdb.getGeburtsdatum();
                        Integer geburtsjahr = Integer.parseInt(geburtsdatumStr.split("\\.")[2]);
                        LocalDate now = LocalDate.now();
                        Integer alter = now.getYear() - geburtsjahr;
                        String geschlecht = "M";
                        if (geschlechtStr == "männlich") {
                            geschlecht = "M";
                        }
                        if (geschlechtStr == "weiblich") {
                            geschlecht = "W";
                        }
                        boolean update = true;
                        Kandidat kandidat = kandidatService.findByBtw17Mdb(vorname, nachname, geburtsjahr, geburtsort, geschlecht);
                        if (kandidat != null) {
                            log.info("found Kandidat kandidat = " + kandidat.getUniqueId());
                        } else {
                            update = false;
                            log.info("not found Kandidat kandidat. Will create a new Object.");
                            kandidat = new Kandidat();
                            kandidat.setVorname(vorname);
                            kandidat.setNachname(nachname);
                            kandidat.setGeburtsjahr(geburtsjahr);
                            kandidat.setGeburtsort(geburtsort);
                        }

                        kandidat.setGeschlecht(geschlecht);
                        kandidat.setKey(btw17Mdb.getTransientKey());
                        kandidat.setAlter(alter);
                        kandidat.setAdel(btw17Mdb.getAdel());
                        kandidat.setAkademischeTitel(btw17Mdb.getAkadtitel());
                        kandidat.setAnredeTitel(btw17Mdb.getAnredetitel());
                        kandidat.setPraefix(btw17Mdb.getPraefix());
                        kandidat.setBtw17MdbId(btw17Mdb.getId());
                        kandidat.setXmlIdBundestag(btw17Mdb.getXmlId());
                        kandidat.setGeschlecht(geschlecht);
                        kandidat.setFamilienstand(btw17Mdb.getFamilienstand());
                        kandidat.setBeruf(beruf);
                        kandidat.setParteikurz(btw17Mdb.getParteikurz());
                        kandidat.setOrtszusatz(btw17Mdb.getOrtszusatz());

                        kandidat.setVeroeffentlichungspflichtiges(btw17Mdb.getVeroeffentlichungspflichtiges());
                        kandidat.setVitakurz(btw17Mdb.getVitakurz());

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                        String a = btw17Mdb.getGeburtsdatum();
                        if (a != null) {
                            log.info("Geburtsdatum: " + a);
                            LocalDate geburtsdatum = LocalDate.parse(a, formatter);
                            kandidat.setGeburtsdatum(geburtsdatum);
                        }

                        String b = btw17Mdb.getHistoriebis();
                        if (b != null) {
                            log.info("getHistoriebis: " + b);
                            LocalDate getHistoriebis = LocalDate.parse(b, formatter);
                            kandidat.setHistorieBis(getHistoriebis);
                        }

                        String c = btw17Mdb.getHistorievon();
                        if (c != null) {
                            log.info("getHistorievon: " + c);
                            LocalDate getHistorievon = LocalDate.parse(c, formatter);
                            kandidat.setHistorieVon(getHistorievon);
                        }

                        String d = btw17Mdb.getSterbedatum();
                        if (d != null) {
                            log.info("getSterbedatum: " + d);
                            LocalDate getSterbedatum = LocalDate.parse(d, formatter);
                            kandidat.setSterbedatum(getSterbedatum);
                        }

                        String e = btw17Mdb.getReligion();
                        if (e != null) {

                            switch (e) {
                                case "konfessionslos":
                                    kandidat.setReligion(Religion.KONFESSIONSLOS);
                                    break;
                                case "ohne Angaben":
                                    kandidat.setReligion(Religion.OHNE_ANGABEN);
                                    break;
                                case "neuapostolisch":
                                    kandidat.setReligion(Religion.NEUAPOSTOLISCH);
                                    break;
                                case "evangelisch-reformiert":
                                    kandidat.setReligion(Religion.EVANGELISCH_REFORMIERT);
                                    break;
                                case "evangelisch":
                                    kandidat.setReligion(Religion.EVANGELISCH);
                                    break;
                                case "evangelisch-freikirchlich":
                                    kandidat.setReligion(Religion.EVANGELISCH_FREIKIRCHLICH);
                                    break;
                                case "religionslos":
                                    kandidat.setReligion(Religion.RELIGIONSLOS);
                                    break;
                                case "evangelisch-lutherisch":
                                    kandidat.setReligion(Religion.EVANGELISCH_LUTHERISCH);
                                    break;
                                case "freireligiös":
                                    kandidat.setReligion(Religion.FREIRELIGIOES);
                                    break;
                                case "Islam":
                                    kandidat.setReligion(Religion.ISLAM);
                                    break;
                                case "Atheistin":
                                    kandidat.setReligion(Religion.ATHEISTIN);
                                    break;
                                case "humanistisch":
                                    kandidat.setReligion(Religion.HUMANISTISCH);
                                    break;
                                case "muslimisch":
                                    kandidat.setReligion(Religion.MUSLIMISCH);
                                    break;
                                case "protestantisch":
                                    kandidat.setReligion(Religion.PROTESTANTISCH);
                                    break;
                                case "römisch-katholisch":
                                    kandidat.setReligion(Religion.ROEMISCH_KATHOLISCH);
                                    break;
                                case "Atheist":
                                    kandidat.setReligion(Religion.ATHEIST);
                                    break;
                                case "katholisch":
                                    kandidat.setReligion(Religion.KATHOLISCH);
                                    break;
                            }
                        }
                        //kandidat.setWahlperioden(wahlperioden);
                        if (update) {
                            //kandidat = kandidatService.update(kandidat);
                            log.info("updated Kandidat " + kandidat.getUniqueId());
                        } else {
                            kandidat = kandidatService.create(kandidat);
                            log.info("created Kandidat " + kandidat.getUniqueId());
                        }
                    }
                }
                if (btw17MdbPage.hasNext()) {
                    pageable = btw17MdbPage.nextPageable();
                    btw17MdbPage = btw17MdbService.getAll(pageable);
                } else {
                    goOn = false;
                }
            }
        }
}
