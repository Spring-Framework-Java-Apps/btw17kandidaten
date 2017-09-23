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
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = { KandidatenApplication.class },
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BerufServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BerufServiceTest.class);

    @Autowired
    private BerufService berufService;

    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(berufService).isNotNull();
    }

    @Commit
    @Test
    public void test001getAll() throws Exception {

    }

    @Commit
    @Test
    public void test002findByBeruf() throws Exception {
        int page = 1;
        int size = 20;
        Pageable pageable = new PageRequest(page,size);
        Page<Beruf> berufe = berufService.getAll(pageable);
        int resultSize = berufe.getNumber();
        log.debug("found: # "+resultSize);
        Assert.assertTrue(resultSize>0);
        boolean goOn = true;
        while(goOn) {
            for (Beruf beruf : berufe.getContent()) {
                Beruf found = berufService.findByBeruf(beruf.getBeruf());
                Assert.assertEquals(beruf.getId(), found.getId());
                log.debug("found: " + found.toString());
            }
            if (berufe.hasNext()) {
                pageable = berufe.nextPageable();
                berufe = berufService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }

    @Commit
    @Test
    public void test003count() throws Exception {

    }
}
