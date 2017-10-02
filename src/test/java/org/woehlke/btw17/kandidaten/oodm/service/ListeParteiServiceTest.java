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
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.GeburtsortController;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.ListeParteiController;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;

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
public class ListeParteiServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ListeParteiServiceTest.class);

    @Autowired
    private ListeParteiService listeParteiService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ListeParteiController controller;

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
        assertThat(listeParteiService).isNotNull();
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
    public void test002findByListeParteiTest() throws Exception {
        log.info("test002findByListeParteiTest");
        int page = FIRST_PAGE_NUMBER;
        int size = PAGE_SIZE;
        Pageable pageable = new PageRequest(page,size);
        Page<ListePartei> listeParteien = listeParteiService.getAll(pageable);
        long resultSize = listeParteien.getTotalElements();
        log.debug("found: # "+resultSize);
        long resultSizeExpected = kandidatenProperties.getTableContent().getCountListePartei();
        Assert.assertTrue("Page<ListePartei> listeParteien : is "+resultSize+"  expected "+resultSizeExpected,resultSize==resultSizeExpected);
        boolean goOn = true;
        while(goOn) {
            for (ListePartei listePartei : listeParteien.getContent()) {
                ListePartei found = listeParteiService.findByListePartei(listePartei.getListePartei(), listePartei.getListeParteiLang());
                Assert.assertEquals(listePartei.getId(), found.getId());
                log.debug("found: " + found.toString());
            }
            if (listeParteien.hasNext()) {
                pageable = listeParteien.nextPageable();
                listeParteien = listeParteiService.getAll(pageable);
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
