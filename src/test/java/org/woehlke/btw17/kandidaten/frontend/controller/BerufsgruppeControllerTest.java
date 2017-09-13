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
import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.service.BerufsgruppeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={KandidatenApplication.class},webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BerufsgruppeControllerTest {


    private static final Logger log = LoggerFactory.getLogger(BerufsgruppeControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BerufsgruppeController controller;

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

    @WithAnonymousUser
    @Commit
    @Test
    public void test010getAll()throws Exception {
        String msg ="test010getAll: ";

        MvcResult result = this.mockMvc.perform(get("/berufsgruppe/all"))
                .andExpect(status().isOk())
                .andExpect(view().name( "berufsgruppe/all"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("suchformularFreitext"))
                .andExpect(model().attributeExists("berufsgruppen"))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        log.info(msg+"#######################################");
        log.info(msg+"#######################################");
        log.info(msg+content);
        log.info(msg+"#######################################");
        log.info(msg+"#######################################");
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
        Page<Berufsgruppe> berufsgruppen = berufsgruppeService.getAll(pageable);
        for(Berufsgruppe berufsgruppe:berufsgruppen){
            MvcResult result = this.mockMvc.perform(get("/berufsgruppe/"+berufsgruppe.getId()))
                    .andExpect(status().isOk())
                    .andExpect(view().name( "berufsgruppe/id"))
                    .andExpect(model().attributeExists("pageContent"))
                    .andExpect(model().attributeExists("berufsgruppe"))
                    .andExpect(model().attributeExists("kandidaten"))
                    .andExpect(model().attributeExists("suchformularFreitext"))
                    .andReturn();

            String content = result.getResponse().getContentAsString();

            log.info(msg+"#######################################");
            log.info(msg+"#######################################");
            log.info(msg+content);
            log.info(msg+"#######################################");
            log.info(msg+"#######################################");
        }
        Assert.assertTrue(true);
    }
}
