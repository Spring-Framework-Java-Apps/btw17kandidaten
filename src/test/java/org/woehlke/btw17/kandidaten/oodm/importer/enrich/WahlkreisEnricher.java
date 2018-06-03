package org.woehlke.btw17.kandidaten.oodm.importer.enrich;


import org.junit.Assert;
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
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.EditStatus;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.WahlergebnisseBtw17;
import org.woehlke.btw17.kandidaten.oodm.db.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.PAGE_SIZE;

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
public class WahlkreisEnricher {


    private static final Logger log = LoggerFactory.getLogger(WahlkreisEnricher.class);

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
    public void test010updateWahlkreisWithBundesland() throws Exception {
        log.info("test010updateWahlkreisWithBundesland");
        int page=FIRST_PAGE_NUMBER;
        int size=PAGE_SIZE;
        Pageable pageable = new PageRequest(page,size);
        Page<Btw17Wahlkreis> btw17WahlkreisPage = btw17WahlkreisService.getAll(pageable);
        boolean goOn = true;
        while(goOn) {
            for (Btw17Wahlkreis btw17Wahlkreis : btw17WahlkreisPage) {
                long wahlkreisNummer = btw17Wahlkreis.getWahlkreisNummer();
                BundeslandEnum bl = btw17Wahlkreis.getBundeslandEnumKurz();
                Bundesland bundesland = bundeslandService.findByBundesland(bl);
                Wahlkreis wahlkreis = wahlkreisService.findByWahlkreisId(wahlkreisNummer);
                log.debug("add wahlkreisNummer: "+btw17Wahlkreis.getUniqueId());
                log.debug("add bundesland:      "+bundesland.getUniqueId());
                if(wahlkreis != null){
                    wahlkreis.setBundesland(bundesland);
                    bundesland = bundeslandService.update(bundesland);
                    wahlkreis = wahlkreisService.update(wahlkreis);
                    log.info("updated wahlkreis: "+wahlkreis.getUniqueId());
                    log.info("updated bundesland: "+bundesland.getUniqueId());
                } else {
                    wahlkreis = new Wahlkreis();
                    wahlkreis.setBundesland(bundesland);
                    wahlkreis.setWahlkreisId(wahlkreisNummer);
                    wahlkreis.setWahlkreisName(btw17Wahlkreis.getWahlkreisName());
                    CommonFields cf = new CommonFields();
                    cf.setEditStatus(EditStatus.UNTOUCHED);
                    wahlkreis.setCommonFields(cf);
                    wahlkreis = wahlkreisService.create(wahlkreis);
                    log.info("created wahlkreis: "+wahlkreis.getUniqueId());
                }
            }
            Assert.assertTrue(true);
            if(btw17WahlkreisPage.hasNext()){
                pageable = btw17WahlkreisPage.nextPageable();
                btw17WahlkreisPage = btw17WahlkreisService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }


    @WithMockUser
    @Commit
    @Test
    public void test020updateWahlkreisByBtw17Strukturdaten() throws Exception {
        log.info("test020updateWahlkreisByBtw17Strukturdaten");
        for(Btw17Strukturdaten btw17Strukturdaten:btw17StrukturdatenService.getAll()){
            log.info("btw17Strukturdaten: "+btw17Strukturdaten.getUniqueId());
            Wahlkreis wahlkreis = wahlkreisService.findByWahlkreisId(btw17Strukturdaten.getWahlkreisNummer());
            if(wahlkreis!=null){
                Strukturdaten strukturdaten = btw17StrukturdatenService.getStrukturdatenFromBtw17Strukturdaten(btw17Strukturdaten);
                wahlkreis.setStrukturdaten(strukturdaten);
                wahlkreisService.update(wahlkreis);
                log.info("updated wahlkreis: "+wahlkreis.getUniqueId());
            }
        }
    }

    @WithMockUser
    @Commit
    @Test
    public void test040updateWahlkreisByBtw17Ergebnis() throws Exception {
        log.info("test040updateWahlkreisByBtw17Ergebnis");
        for(Btw17Ergebnis btw17Ergebnisse:btw17ErgebnisService.getAll()){
            log.info("btw17Ergebnisse: "+btw17Ergebnisse.getUniqueId());
            Wahlkreis wahlkreis = wahlkreisService.findByWahlkreisId(btw17Ergebnisse.getWahlkreisNummer());
            if(wahlkreis!=null){
                WahlergebnisseBtw17 wahlergebnisseBtw17 = btw17ErgebnisService.getWahlergebnisseFromBtw17Ergebnis(btw17Ergebnisse);
                wahlkreis.setWahlergebnisseBtw17(wahlergebnisseBtw17);
                wahlkreisService.update(wahlkreis);
                log.info("updated wahlkreis: "+wahlkreis.getUniqueId());
            }
        }
    }
}
