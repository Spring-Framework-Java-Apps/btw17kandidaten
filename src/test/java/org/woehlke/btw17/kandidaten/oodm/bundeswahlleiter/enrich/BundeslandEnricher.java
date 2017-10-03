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
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17StrukturdatenService;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17WahlkreisService;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.model.parts.Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.service.BundeslandService;
import org.woehlke.btw17.kandidaten.oodm.service.WahlkreisService;

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
    private Btw17WahlkreisService btw17WahlkreisService;

    @Autowired
    private Btw17StrukturdatenService btw17StrukturdatenService;

    @Autowired
    private WahlkreisService wahlkreisService;

    @Autowired
    private BundeslandService bundeslandService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KandidatenProperties kandidatenProperties;


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
    }

    @WithMockUser
    @Commit
    @Test
    public void test010updateBundeslandByBtw17Strukturdaten() throws Exception {
        log.info("test010updateBundeslandByBtw17Strukturdaten");
        List<Btw17Strukturdaten> bundeslaenderBtw17Strukturdaten = btw17StrukturdatenService.getStrukturdatenOfBundeslaender();
        for(Btw17Strukturdaten btw17Strukturdaten:bundeslaenderBtw17Strukturdaten){
            log.info(btw17Strukturdaten.getUniqueId());
            Bundesland bundesland = bundeslandService.findByBundesland(btw17Strukturdaten.getBundesland());
            Strukturdaten strukturdaten = btw17StrukturdatenService.getStrukturdatenFromBtw17Strukturdaten(btw17Strukturdaten);
            bundesland.setStrukturdaten(strukturdaten);
            bundeslandService.update(bundesland);
        }
    }
}
