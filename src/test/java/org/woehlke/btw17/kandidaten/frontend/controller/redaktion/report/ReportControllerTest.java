package org.woehlke.btw17.kandidaten.frontend.controller.redaktion.report;


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
import org.woehlke.btw17.kandidaten.frontend.controller.closed.reports.ReportController;

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
public class ReportControllerTest {


    private static final Logger log = LoggerFactory.getLogger(ReportControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReportController controller;


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
    public void test0010overview() throws Exception {
        String msg ="test0010overview: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/overview"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/overview"))
                .andExpect(model().attributeExists("pageContent"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0020getMdbWithoutAbgeordnetenwatch() throws Exception {
        String msg ="test0020getMdbWithoutAbgeordnetenwatch: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/mdb/abgeordnetenwatch"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/mdb/abgeordnetenwatch"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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

    @WithMockUser
    @Commit
    @Test
    public void test0030getMdbWithoutBundestagProfile() throws Exception {
        String msg ="test0030getMdbWithoutBundestagProfile: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/mdb/bundestag"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/mdb/bundestag"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0040getMdbWithoutFotoUrl() throws Exception {
        String msg ="test0040getMdbWithoutFotoUrl: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/mdb/foto"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/mdb/foto"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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

    @WithMockUser
    @Commit
    @Test
    public void test0050getMdbWithoutFacebook() throws Exception {
        String msg ="test0050getMdbWithoutFacebook: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/mdb/facebook"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/mdb/facebook"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0060getMdbWithoutTwitter() throws Exception {
        String msg ="test0060getMdbWithoutTwitter: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/mdb/twitter"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/mdb/twitter"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0070getMdbWithoutWebseite() throws Exception {
        String msg ="test0070getMdbWithoutWebseite: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/mdb/webseite"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/mdb/webseite"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0080getMdbWithoutWikipediaArticle() throws Exception {
        String msg ="test0080getMdbWithoutWikipediaArticle: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/mdb/wikipedia"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/mdb/wikipedia"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0090getKandidatWithoutAbgeordnetenwatch() throws Exception {
        String msg ="test0090getKandidatWithoutAbgeordnetenwatch: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/abgeordnetenwatch"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/abgeordnetenwatch"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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

    @WithMockUser
    @Commit
    @Test
    public void test0100getKandidatWithoutFacebook() throws Exception {
        String msg ="test0100getKandidatWithoutFacebook: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/facebook"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/facebook"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0110getKandidatWithoutWebseite() throws Exception {
        String msg ="test0110getKandidatWithoutWebseite: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/webseite"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/webseite"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0120getKandidatWithoutFotoUrl() throws Exception {
        String msg ="test0120getKandidatWithoutFotoUrl: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/foto"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/foto"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0130getKandidatWithoutLobbypediaUrl() throws Exception {
        String msg ="test0130getKandidatWithoutLobbypediaUrl: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/lobbypedia"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/lobbypedia"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0140getKandidatWithoutSoundcloud() throws Exception {
        String msg ="test0140getKandidatWithoutSoundcloud: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/soundcloud"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/soundcloud"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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


    @WithMockUser
    @Commit
    @Test
    public void test0150getKandidatWithoutYoutube() throws Exception {
        String msg ="test0150getKandidatWithoutYoutube: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/youtube"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/youtube"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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

    @WithMockUser
    @Commit
    @Test
    public void test0160getKandidatWithoutTwitter() throws Exception {
        String msg ="test0160getKandidatWithoutTwitter: ";
        log.info(msg);

        MvcResult result = this.mockMvc.perform(get("/report/kandidat/twitter"))
                .andExpect(status().isOk())
                .andExpect(view().name( "report/kandidat/twitter"))
                .andExpect(model().attributeExists("pageContent"))
                .andExpect(model().attributeExists("kandidaten"))
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

/*
    @Commit
    @Test
    public void test0170(){

    }


    @Commit
    @Test
    public void test0180(){

    }


    @Commit
    @Test
    public void test0190(){

    }


    @Commit
    @Test
    public void test0200(){

    }


    @Commit
    @Test
    public void test0210(){

    }


    @Commit
    @Test
    public void test0220(){

    }


    @Commit
    @Test
    public void test0230(){

    }


    @Commit
    @Test
    public void test0240(){

    }


    @Commit
    @Test
    public void test0250(){

    }
*/

}
