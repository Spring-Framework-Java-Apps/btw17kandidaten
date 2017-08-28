package org.woehlke.btw17.kandidaten.oodm.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GeburtsortServiceTest {

    private static final Logger log = LoggerFactory.getLogger(GeburtsortServiceTest.class);

    @Autowired
    private GeburtsortService geburtsortService;

    @Commit
    @Test
    public  void  findByGeburtsortTest() throws Exception {
        int page = 1;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<Geburtsort> geburtsorte = geburtsortService.getAll(pageable);
        int resultSize = geburtsorte.getNumber();
        log.info("found: # "+resultSize);
        Assert.assertTrue(resultSize>0);
        for(Geburtsort geburtsort:geburtsorte.getContent()){
            Geburtsort found = geburtsortService.findByGeburtsort(geburtsort.getGeburtsort());
            Assert.assertEquals(geburtsort.getId(),found.getId());
            log.info("found: "+found.toString());
        }
    }

}