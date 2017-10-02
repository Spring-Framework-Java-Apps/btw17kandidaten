package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.file2db;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17ErgebnisService;

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
public class Btw17ErgebnisImporter {

    private static final Logger log = LoggerFactory.getLogger(Btw17ErgebnisImporter.class);

    private final String srcFileNameErgebnisWahlkreise = "etc/ergebnisse/importing/btw17_kerg_wahlkreise.csv";

    private final String srcFileNameErgebnisBundeslaender = "etc/ergebnisse/importing/btw17_kerg_bundeslaender.csv";

    private final String srcFileNameErgebnisDeutschland = "etc/ergebnisse/importing/btw17_kerg_deutschland.csv";

    @Autowired
    private Btw17ErgebnisService btw17ErgebnisService;

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser
    @Commit
    @Test
    public void test000controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(mockMvc).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(btw17ErgebnisService).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test100file2db(){
        log.info("test100file2db");
        Assert.assertTrue(true);
    }
}
