package org.woehlke.btw17.kandidaten.oodm.service;

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
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.BerufsgruppeController;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.BundeslandController;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;

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
        webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BundeslandServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BundeslandServiceTest.class);

    @Autowired
    private BundeslandService bundeslandService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BundeslandController controller;

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
        assertThat(bundeslandService).isNotNull();
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test001getAll() throws Exception {

    }


    @WithAnonymousUser
    @Commit
    @Test
    public void test002findByBundeslandTest() throws Exception {
        log.info("test002findByBundeslandTest");
        int page = FIRST_PAGE_NUMBER;
        int size = PAGE_SIZE;
        Pageable pageable = new PageRequest(page,size);
        Page<Bundesland> bundeslaender = bundeslandService.getAll(pageable);
        int resultSize = bundeslaender.getNumber();
        log.debug("found: # "+resultSize);
        Assert.assertTrue("Page<Bundesland> bundeslaender : "+resultSize,resultSize>0);
        boolean goOn = true;
        while(goOn) {
            for (Bundesland bundesland : bundeslaender.getContent()) {
                Bundesland found = bundeslandService.findByBundesland(bundesland.getBundesland());
                Assert.assertEquals(bundesland.getId(), found.getId());
                log.debug("found: " + found.toString());
            }
            if (bundeslaender.hasNext()) {
                pageable = bundeslaender.nextPageable();
                bundeslaender = bundeslandService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test003count() throws Exception {

    }
}
