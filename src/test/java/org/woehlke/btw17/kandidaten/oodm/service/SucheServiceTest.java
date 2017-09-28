package org.woehlke.btw17.kandidaten.oodm.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.GeburtsortController;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.suche.SucheController;

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
public class SucheServiceTest {

    private static final Logger log = LoggerFactory.getLogger(SucheServiceTest.class);

    @Autowired
    private SucheService sucheService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SucheController controller;

    @WithAnonymousUser
    @Commit
    @Test
    public void test000controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(controller).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(sucheService).isNotNull();
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test001getAll() throws Exception {

    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test003count() throws Exception {

    }

}
