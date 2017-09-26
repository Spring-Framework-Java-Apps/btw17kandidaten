package org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data;


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
import org.springframework.test.web.servlet.MvcResult;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.service.WebseiteAgenturService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = {KandidatenApplication.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebseiteAgenturControllerTest {

    private static final Logger log = LoggerFactory.getLogger(WebseiteAgenturControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @Autowired
    private WebseiteAgenturController controller;

    @Autowired
    private WebseiteAgenturService webseiteAgenturService;


    @Commit
    @Test
    public void test001controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(controller).isNotNull();
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test010getAll()throws Exception {
        String msg = "test010getAll: ";

        MvcResult result = this.mockMvc.perform(get("/webseite/agentur/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("webseite/agentur/all"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("allWebseiteAgenturPage"))
                .andExpect(model().attributeExists("suchformularFreitext"))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        log.debug(msg + "#######################################");
        log.debug(msg + "#######################################");
        log.debug(msg + content);
        log.debug(msg + "#######################################");
        log.debug(msg + "#######################################");
        Assert.assertTrue(true);
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test020getUserForId()  throws Exception {
        String msg ="test020getUserForId: ";
        int page=0;
        int size=20;
        Pageable pageable = new PageRequest(page,size);
        Page<WebseiteAgentur> wohnorte = webseiteAgenturService.getAll(pageable);
        boolean goOn = true;
        while (goOn) {
            for (WebseiteAgentur wohnort : wohnorte) {
                log.debug(msg + "/wohnort/" + wohnort.getId());
                MvcResult result = this.mockMvc.perform(get("/webseite/agentur/" + wohnort.getId()))
                        .andExpect(status().isOk())
                        .andExpect(view().name("webseite/agentur/id"))
                        .andExpect(model().attributeExists("pageContent"))
                        .andExpect(model().attributeExists("webseiteAgentur"))
                        .andExpect(model().attributeExists("kandidaten"))
                        .andExpect(model().attributeExists("suchformularFreitext"))
                        .andReturn();

                String content = result.getResponse().getContentAsString();

                log.debug(msg + "#######################################");
                log.debug(msg + "#######################################");
                log.debug(msg + content);
                log.debug(msg + "#######################################");
                log.debug(msg + "#######################################");
            }
            Assert.assertTrue(true);
            if (wohnorte.hasNext()) {
                pageable = wohnorte.nextPageable();
                wohnorte = webseiteAgenturService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }
}