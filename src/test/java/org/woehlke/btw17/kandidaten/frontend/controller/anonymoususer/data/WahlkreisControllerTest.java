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
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.service.WahlkreisService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes={KandidatenApplication.class},
    webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WahlkreisControllerTest {

    private static final Logger log = LoggerFactory.getLogger(WahlkreisControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WahlkreisController controller;

    @Autowired
    private WahlkreisService wahlkreisService;

    @Autowired
    private KandidatenProperties kandidatenProperties;

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
        String msg ="test010getAll: ";

        MvcResult result = this.mockMvc.perform(get("/wahlkreis/all"))
                .andExpect(status().isOk())
                .andExpect(view().name( "wahlkreis/all"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("wahlkreise"))
                .andExpect(model().attributeExists("suchformularFreitext"))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        log.debug(msg+"#######################################");
        log.debug(msg+"#######################################");
        log.debug(msg+content);
        log.debug(msg+"#######################################");
        log.debug(msg+"#######################################");
        Assert.assertTrue(true);
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test020getUserForId()  throws Exception {
        String msg ="test020getUserForId: ";
        int page=0;
        int size=10;
        Pageable pageable = new PageRequest(page,size);
        Page<Wahlkreis> wahlkreise = wahlkreisService.getAll(pageable);
        for(Wahlkreis wahlkreis:wahlkreise){
            MvcResult result = this.mockMvc.perform(get("/wahlkreis/"+wahlkreis.getId()))
                    .andExpect(status().isOk())
                    .andExpect(view().name( "wahlkreis/id"))
                    .andExpect(model().attributeExists("pageContent"))
                    .andExpect(model().attributeExists("wahlkreis"))
                    .andExpect(model().attributeExists("kandidaten"))
                    .andExpect(model().attributeExists("suchformularFreitext"))
                    .andReturn();

            String content = result.getResponse().getContentAsString();

            log.debug(msg+"#######################################");
            log.debug(msg+"#######################################");
            log.debug(msg+content);
            log.debug(msg+"#######################################");
            log.debug(msg+"#######################################");
        }
        Assert.assertTrue(true);
    }

}
