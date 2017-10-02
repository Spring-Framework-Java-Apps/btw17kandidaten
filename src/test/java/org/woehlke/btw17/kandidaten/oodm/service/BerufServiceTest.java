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
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.AusschussController;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.BerufController;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;

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
public class BerufServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BerufServiceTest.class);

    @Autowired
    private BerufService berufService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BerufController controller;

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @WithMockUser
    @Commit
    @Test
    public void test000controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(controller).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(berufService).isNotNull();
        assertThat(kandidatenProperties).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test001getAll() throws Exception {

    }

    @WithMockUser
    @Commit
    @Test
    public void test002findByBeruf() throws Exception {
        log.info("test002findByBeruf");
        int page = FIRST_PAGE_NUMBER;
        int size = PAGE_SIZE;
        Pageable pageable = new PageRequest(page,size);
        Page<Beruf> berufe = berufService.getAll(pageable);
        long resultSize = berufe.getTotalElements();
        log.debug("found: # "+resultSize);
        long resultSizeExpected = kandidatenProperties.getTableContent().getCountBeruf();
        Assert.assertTrue("Page<Beruf> berufe : is "+resultSize+"  expected "+resultSizeExpected,resultSize==resultSizeExpected);
        boolean goOn = true;
        while(goOn) {
            for (Beruf beruf : berufe.getContent()) {
                Beruf found = berufService.findByBeruf(beruf.getBeruf());
                Assert.assertEquals(beruf.getId(), found.getId());
                log.debug("found: " + found.toString());
            }
            if (berufe.hasNext()) {
                pageable = berufe.nextPageable();
                berufe = berufService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }

    @WithMockUser
    @Commit
    @Test
    public void test003count() throws Exception {

    }
}
