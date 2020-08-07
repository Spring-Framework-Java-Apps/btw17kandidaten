package org.woehlke.btw17.kandidaten.oodm.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.frontend.controller.open.data.WahlkreisController;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

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
public class WahlkreisServiceTest {

    @Autowired
    private WahlkreisService wahlkreisService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WahlkreisController controller;

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
        assertThat(wahlkreisService).isNotNull();
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
    public void test002findByWahlkreisIdTest() throws Exception {
        log.info("test002findByWahlkreisIdTest");
        int page = FIRST_PAGE_NUMBER;
        int size = PAGE_SIZE;
        Pageable pageable = PageRequest.of(page,size);
        Page<Wahlkreis> wahlkreise = wahlkreisService.getAll(pageable);
        long resultSize = wahlkreise.getTotalElements();
        log.debug("found: # "+resultSize);
        long resultSizeExpected = kandidatenProperties.getTableContent().getCountWahlkreis();
        Assert.assertTrue("Page<Wahlkreis> wahlkreise : is "+resultSize+"  expected "+resultSizeExpected,resultSize==resultSizeExpected);
        boolean goOn = true;
        while(goOn) {
            for (Wahlkreis wahlkreis : wahlkreise.getContent()) {
                Wahlkreis found = wahlkreisService.findByWahlkreisId(wahlkreis.getWahlkreisId());
                Assert.assertEquals(wahlkreis.getId(), found.getId());
                log.debug("found: " + found.toString());
            }
            if (wahlkreise.hasNext()) {
                pageable = wahlkreise.nextPageable();
                wahlkreise = wahlkreisService.getAll(pageable);
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
