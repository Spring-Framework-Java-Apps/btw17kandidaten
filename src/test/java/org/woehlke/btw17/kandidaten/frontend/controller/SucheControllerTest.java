package org.woehlke.btw17.kandidaten.frontend.controller;


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
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.woehlke.btw17.kandidaten.KandidatenApplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={KandidatenApplication.class},webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SucheControllerTest {

    private static final Logger log = LoggerFactory.getLogger(SucheControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SucheController controller;

    @Commit
    @Test
    public void test001controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(controller).isNotNull();
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test010suchFormularAnzeigenGet()throws Exception {
        String msg ="test010suchFormularAnzeigenGet: ";

        MvcResult result = this.mockMvc.perform(get("/suche/freitext/formular"))
                .andExpect(status().isOk())
                .andExpect(view().name( "suche/freitext"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("berufsgruppen"))
                .andExpect(model().attributeExists("bundeslaender"))
                .andExpect(model().attributeExists("landesListen"))
                .andExpect(model().attributeExists("parteien"))
                .andExpect(model().attributeExists("geburtsjahre"))
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
    public void test011suchFormularAnzeigenGet()throws Exception {
        String msg ="test010suchFormularAnzeigenGet: ";

        MvcResult result = this.mockMvc.perform(get("/suche/freitext/formular"))
                .andExpect(status().isOk())
                .andExpect(view().name( "suche/freitext"))
                .andExpect(model().attributeExists("pageContent"))
                //.andExpect(model().attributeExists("kandidaten"))
                .andExpect(model().attributeExists("berufsgruppen"))
                .andExpect(model().attributeExists("bundeslaender"))
                .andExpect(model().attributeExists("landesListen"))
                .andExpect(model().attributeExists("parteien"))
                .andExpect(model().attributeExists("geburtsjahre"))
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
    public void test020tretextsucheFormularAnzeigenGet()throws Exception {
        String msg ="test010tretextsucheFormularAnzeigenGet: ";

        MvcResult result = this.mockMvc.perform(get("/suche/formular"))
                .andExpect(status().isOk())
                .andExpect(view().name( "suche/formular"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("berufsgruppen"))
                .andExpect(model().attributeExists("bundeslaender"))
                .andExpect(model().attributeExists("landesListen"))
                .andExpect(model().attributeExists("parteien"))
                .andExpect(model().attributeExists("geburtsjahre"))
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
    public void test021tretextsucheFormularAnzeigenGet()throws Exception {
        String msg ="test010tretextsucheFormularAnzeigenGet: ";

        MvcResult result = this.mockMvc.perform(get("/suche/formular"))
                .andExpect(status().isOk())
                .andExpect(view().name( "suche/formular"))
                .andExpect(model().attributeExists("pageContent"))
                //.andExpect(model().attributeExists("kandidaten"))
                .andExpect(model().attributeExists("berufsgruppen"))
                .andExpect(model().attributeExists("bundeslaender"))
                .andExpect(model().attributeExists("landesListen"))
                .andExpect(model().attributeExists("parteien"))
                .andExpect(model().attributeExists("geburtsjahre"))
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

}
