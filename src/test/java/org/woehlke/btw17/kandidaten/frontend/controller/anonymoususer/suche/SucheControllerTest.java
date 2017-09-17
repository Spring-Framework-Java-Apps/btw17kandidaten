package org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.suche;


import org.junit.Assert;
import org.junit.Before;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes={KandidatenApplication.class},
    webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SucheControllerTest {

    private static final Logger log = LoggerFactory.getLogger(SucheControllerTest.class);

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private SucheController controller;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @Commit
    @Test
    public void test001controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(controller).isNotNull();
    }

    @WithAnonymousUser
    @Commit
    @Test
    public void test010suchFreitextFormularGet()throws Exception {
        String msg ="test010suchFreitextFormularGet: ";

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
    public void test020suchFreitextFormularPost()throws Exception {
        String msg ="test020suchFreitextFormularPost: ";

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
    public void test100suchFormularGet()throws Exception {
        String msg ="test100suchFormularGet: ";

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

    //TODO: #111 https://github.com/phasenraum2010/btw17kandidaten/issues/111
    @WithAnonymousUser
    @Commit
    @Test
    public void test110suchFreitextFormularPost()throws Exception {
        String msg ="test100suchFreitextFormularPost: ";
        FreitextSucheFormular suchformularFreitext = new FreitextSucheFormular();
        suchformularFreitext.setSearchTerm("Rauhut");
        BindingResult binding = new BeanPropertyBindingResult(
                suchformularFreitext,
                "suchformularFreitext"
        );
        RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
        MvcResult result =
                this.mockMvc.perform(
                    post(
                        "/suche/formular",
                        suchformularFreitext,
                        binding,
                        redirectAttributes
                    ).with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name( "redirect:/suche/formular"))
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
