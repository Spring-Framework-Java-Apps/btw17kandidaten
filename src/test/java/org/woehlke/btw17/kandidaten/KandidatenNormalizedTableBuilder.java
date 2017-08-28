package org.woehlke.btw17.kandidaten;

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
import org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class KandidatenNormalizedTableBuilder {

    private static final Logger log = LoggerFactory.getLogger(KandidatenNormalizedTableBuilder.class);

    @Autowired
    private BerufService berufService;

    @Autowired
    private BerufsgruppeService berufsgruppeService;

    @Autowired
    private BundeslandService bundeslandService;

    @Autowired
    private GeburtsortService geburtsortService;

    @Autowired
    private KandidatFlatService kandidatFlatService;

    @Autowired
    private KandidatService kandidatService;

    @Autowired
    private ListeParteiService listeParteiService;

    @Autowired
    private ParteiService parteiService;

    @Autowired
    private WahlkreisService wahlkreisService;

    @Autowired
    private WohnortService wohnortService;

    @Commit
    @Test
    public void buildNormalizedTData() throws Exception {
        int page = 0;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<KandidatFlat> allKandidatenPage = kandidatFlatService.getAll(pageable);
        boolean goOn = true;
        while(goOn){
            for(KandidatFlat in :allKandidatenPage.getContent()){
                log.info(in.toString());
            }
            if(allKandidatenPage.hasNext()){
                pageable = allKandidatenPage.nextPageable();
                allKandidatenPage = kandidatFlatService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }
}
