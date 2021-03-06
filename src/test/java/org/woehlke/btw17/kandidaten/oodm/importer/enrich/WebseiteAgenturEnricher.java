package org.woehlke.btw17.kandidaten.oodm.importer.enrich;


import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17MdbService;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlperiodeService;
import org.woehlke.btw17.kandidaten.oodm.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {
                KandidatenApplication.class,
                HttpSessionConfig.class,
                WebMvcConfig.class,
                WebSecurityConfig.class
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebseiteAgenturEnricher {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private KandidatenProperties kandidatenProperties;

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
}
