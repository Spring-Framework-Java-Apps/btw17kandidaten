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
import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = { KandidatenApplication.class },
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinisteriumServiceTest {



    private static final Logger log = LoggerFactory.getLogger(AusschussServiceTest.class);

    @Autowired
    private MinisteriumService ministeriumService;

    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(ministeriumService).isNotNull();
    }

    @Commit
    @Test
    public void test001getAll() throws Exception {

    }

    @Commit
    @Test
    public void test002findByMinisterium() throws Exception {
        int page = FIRST_PAGE_NUMBER;
        int size = PAGE_SIZE;
        Pageable pageable = new PageRequest(page,size);
        Page<Ministerium> ministerien = ministeriumService.getAll(pageable);
        int resultSize = ministerien.getNumber();
        log.debug("found: # "+resultSize);
        Assert.assertTrue("Page<Ministerium> ministerien : "+resultSize,resultSize>0);
        boolean goOn = true;
        while(goOn) {
            for (Ministerium ministerium : ministerien.getContent()) {
                Ministerium found = ministeriumService.findByMinisterium(ministerium.getMinisterium());
                Assert.assertEquals(ministerium.getId(), found.getId());
                log.debug("found: " + found.toString());
            }
            if (ministerien.hasNext()) {
                pageable = ministerien.nextPageable();
                ministerien = ministeriumService.getAll(pageable);
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
