package org.woehlke.btw17.importer;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = {KandidatenApplication.class},
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UpdateSearchEngines {

    private static final Logger log = LoggerFactory.getLogger(UpdateSearchEngines.class);

    @Autowired
    private AusschussService ausschussService;

    @Autowired
    private BundeslandService bundeslandService;

    @Autowired
    private FraktionService fraktionService;

    @Autowired
    private GeburtsortService geburtsortService;

    @Autowired
    private KandidatService kandidatService;

    @Autowired
    private ListeParteiService listeParteiService;

    @Autowired
    private MinisteriumService misteriumService;

    @Autowired
    private ParteiService parteiService;

    @Autowired
    private WohnortService wohnortService;

    //@Ignore
    @Commit
    @Test
    public void test001updateAusschuss() throws Exception {
        Assert.assertTrue(true);
    }

    //@Ignore
    @Commit
    @Test
    public void test002updateBundesland() throws Exception {
        Assert.assertTrue(true);
    }

    //@Ignore
    @Commit
    @Test
    public void test003updateFraktion() throws Exception {
        Assert.assertTrue(true);
    }

    @Ignore
    @Commit
    @Test
    public void test004updateGeburtsort() throws Exception {
        Assert.assertTrue(true);
    }

    //@Ignore
    @Commit
    @Test
    public void test005updateKandidat() throws Exception {
        Assert.assertTrue(true);
    }

    //@Ignore
    @Commit
    @Test
    public void test006updateListePartei() throws Exception {
        Assert.assertTrue(true);
    }

    //@Ignore
    @Commit
    @Test
    public void test007updateMinisterium() throws Exception {
        Assert.assertTrue(true);
    }

    //@Ignore
    @Commit
    @Test
    public void test008updatePartei() throws Exception {
        Assert.assertTrue(true);
    }

    //@Ignore
    @Commit
    @Test
    public void test009updateWohnort() throws Exception {
        Assert.assertTrue(true);
    }
}
