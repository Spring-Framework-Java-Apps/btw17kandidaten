package org.woehlke.btw17.importer;


import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.support.oodm.service.UrlService;

import java.net.URL;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KandidatenApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class KandidatenFotoUrlUdpate {

    private static final Logger log = LoggerFactory.getLogger(KandidatenFotoUrlUdpate.class);

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @Autowired
    private KandidatService kandidatService;

    @Autowired
    private UrlService urlService;

    @Ignore
    @Commit
    @Test
    public void updateKandidatenFotoUrl() throws Exception {
        int page = 0;
        int size = 250;
        Pageable pageable = PageRequest.of(page, size);
        Page<Kandidat> allKandidatenPage = kandidatService.getAll(pageable);
        boolean goOn = true;
        while(goOn) {
            for (Kandidat in : allKandidatenPage.getContent()) {
                log.info(in.toString());
                if(kandidatenProperties.getCheckFotoUrl()){
                    if(in.getFoto() != null){
                        URL fotoUrl = urlService.getFotoUrl(in.getFoto());
                        if(fotoUrl != null){
                            in.setFotoUrl(fotoUrl.toExternalForm());
                            in = kandidatService.create(in);
                            log.info(in.toString());
                        }
                    }
                }
            }
            if(allKandidatenPage.hasNext()){
                pageable = allKandidatenPage.nextPageable();
                allKandidatenPage = kandidatService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }
}
