package org.woehlke.btw17.kandidaten.oodm.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.oodm.model.Fraktion;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = { KandidatenApplication.class },
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FraktionServiceTest {


    private static final Logger log = LoggerFactory.getLogger(FraktionServiceTest.class);

    @Autowired
    private FraktionService fraktionService;

    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(fraktionService).isNotNull();
    }

    @Commit
    @Test
    public void test001getAll() throws Exception {

    }

    @Commit
    @Test
    public void test002findByFraktion() throws Exception {
        int page = 1;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<Fraktion> fraktionen = fraktionService.getAll(pageable);
        int resultSize = fraktionen.getNumber();
        log.info("found: # "+resultSize);
        Assert.assertTrue(resultSize>0);
        for(Fraktion fraktion:fraktionen.getContent()){
            Fraktion found = fraktionService.findByFraktion(fraktion.getFraktion());
            Assert.assertEquals(fraktion.getId(),found.getId());
            log.info("found: "+found.toString());
        }
    }

    @Commit
    @Test
    public void test003count() throws Exception {

    }
}