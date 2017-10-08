package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.enrich;


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
import org.woehlke.btw17.kandidaten.configuration.BundeslandEnum;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.model.parts.Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.model.parts.WahlergebnisseBtw17;
import org.woehlke.btw17.kandidaten.oodm.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

import java.util.List;

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
    webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BundeslandEnricher {


    private static final Logger log = LoggerFactory.getLogger(BundeslandEnricher.class);

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
    public void test010updateBundeslandByBtw17Strukturdaten() throws Exception {
        log.info("test010updateBundeslandByBtw17Strukturdaten");
        List<Btw17Strukturdaten> bundeslaenderBtw17Strukturdaten = btw17StrukturdatenService.getStrukturdatenOfBundeslaender();
        for(Btw17Strukturdaten btw17Strukturdaten:bundeslaenderBtw17Strukturdaten){
            log.info("btw17Strukturdaten: "+btw17Strukturdaten.getUniqueId());
            Bundesland bundesland = bundeslandService.findByBundesland(btw17Strukturdaten.getBundesland());
            Strukturdaten strukturdaten = btw17StrukturdatenService.getStrukturdatenFromBtw17Strukturdaten(btw17Strukturdaten);
            bundesland.setStrukturdaten(strukturdaten);
            bundeslandService.update(bundesland);
            log.info("bundesland: "+bundesland.getUniqueId());
        }
    }

    @WithMockUser
    @Commit
    @Test
    public void test040updateBundeslandByBtw17Ergebnis() throws Exception {
        log.info("test040updateBundeslandByBtw17Ergebnis");
        List<Btw17Ergebnis> btw17ErgebnisseOfBundeslaender = btw17ErgebnisService.getErgebnisOfBundeslaender();
        for(Btw17Ergebnis btw17Ergebnisse:btw17ErgebnisseOfBundeslaender){
            log.info("found btw17Ergebnisse: "+btw17Ergebnisse.getUniqueId());
            BundeslandEnum bundeslandEnum = btw17Ergebnisse.getBundesland();
            log.info("bundeslandEnum: "+ bundeslandEnum.name() + " " + bundeslandEnum.getBundeslandName());
            Bundesland bundesland = bundeslandService.findByBundesland(bundeslandEnum);
            if(bundesland!=null){
                WahlergebnisseBtw17 wahlergebnisseBtw17 = btw17ErgebnisService.getWahlergebnisseFromBtw17Ergebnis(btw17Ergebnisse);
                bundesland.setWahlergebnisseBtw17(wahlergebnisseBtw17);
                bundeslandService.update(bundesland);
                log.info("updated bundesland: "+bundesland.getUniqueId());
            }
        }
    }
}
