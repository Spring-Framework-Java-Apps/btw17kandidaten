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
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class WahlkreisServiceTest {

    private static final Logger log = LoggerFactory.getLogger(WahlkreisServiceTest.class);

    @Autowired
    private WahlkreisService wahlkreisService;

    @Commit
    @Test
    public void findByWahlkreisIdTest() throws Exception {
        int page = 1;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<Wahlkreis> wahlkreise = wahlkreisService.getAll(pageable);
        int resultSize = wahlkreise.getNumber();
        log.info("found: # "+resultSize);
        Assert.assertTrue(resultSize>0);
        for(Wahlkreis wahlkreis:wahlkreise.getContent()){
            Wahlkreis found = wahlkreisService.findByWahlkreisId(wahlkreis.getWahlkreisId());
            Assert.assertEquals(wahlkreis.getId(),found.getId());
            log.info("found: "+found.toString());
        }
    }
}
