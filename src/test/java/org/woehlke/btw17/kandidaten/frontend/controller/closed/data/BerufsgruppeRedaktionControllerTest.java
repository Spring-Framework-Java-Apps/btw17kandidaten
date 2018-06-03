package org.woehlke.btw17.kandidaten.frontend.controller.closed.data;


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
import org.springframework.test.web.servlet.MvcResult;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.oodm.db.service.BerufsgruppeService;

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
public class BerufsgruppeRedaktionControllerTest {


    private static final Logger log = LoggerFactory.getLogger(BerufsgruppeRedaktionControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BerufsgruppeRedaktionController controller;

    @Autowired
    private BerufsgruppeService berufsgruppeService;

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @Commit
    @Test
    public void test001controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(controller).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test010getAll()throws Exception {
        String msg ="test010getAll: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/redaktion/berufsgruppe/all"))
                .andExpect(status().isOk())
                .andExpect(view().name( "berufsgruppe/all"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("suchformularFreitext"))
                .andExpect(model().attributeExists("berufsgruppen"))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        log.debug(msg+"#######################################");
        log.debug(msg+"#######################################");
        log.debug(msg+content);
        log.debug(msg+"#######################################");
        log.debug(msg+"#######################################");
        Assert.assertTrue(true);
    }
}
