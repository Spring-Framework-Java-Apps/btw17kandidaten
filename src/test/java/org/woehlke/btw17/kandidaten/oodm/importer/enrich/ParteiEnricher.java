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
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Partei;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlbewerber;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17MdbService;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17WahlperiodeService;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

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
public class ParteiEnricher {


        private static final Logger log = LoggerFactory.getLogger(ParteiEnricher.class);

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
        public void test010updateParteiByBtw17Wahlbewerber() throws Exception {
                log.info("test010updateParteiByBtw17Wahlbewerber");
                long maxId = parteiService.getMaxId();
                log.info("maxId: "+maxId);
                maxId++;
                String sql ="ALTER SEQUENCE hibernate_sequence RESTART WITH "+maxId;
                jdbcService.executeSqlStatemen(sql);
                for(Btw17Wahlbewerber btw17Wahlbewerber:btw17WahlbewerberService.getAll()){
                        String listeParteiBez = btw17Wahlbewerber.getListeParteiBez();
                        String listeParteiKurzBez = btw17Wahlbewerber.getListeParteiKurzBez();
                        Partei parteiPers = parteiService.findByPartei(listeParteiKurzBez,listeParteiBez);
                        if(parteiPers == null){
                            if((listeParteiKurzBez.compareTo("@")!=0)&&(listeParteiKurzBez.compareTo("@")!=0)) {
                                Partei o = new Partei();
                                o.setPartei(listeParteiKurzBez);
                                o.setParteiLang(listeParteiBez);
                                o = parteiService.create(o);
                                log.info("added: " + o.getUniqueId());
                            } else {
                                log.info("found: "+listeParteiBez);
                                log.info("found: "+listeParteiKurzBez);
                                if(((listeParteiKurzBez.compareTo("@")!=0)&&(listeParteiKurzBez.compareTo("@")==0))||
                                    ((listeParteiKurzBez.compareTo("@")==0)&&(listeParteiKurzBez.compareTo("@")!=0))) {
                                    Partei o = new Partei();
                                    o.setPartei(listeParteiKurzBez);
                                    o.setParteiLang(listeParteiBez);
                                    o = parteiService.create(o);
                                    log.info("added: " + o.getUniqueId());
                                }
                            }
                        }
                }
        }
}
