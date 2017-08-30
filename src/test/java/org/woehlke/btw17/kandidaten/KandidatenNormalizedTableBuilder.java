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
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.service.*;

import java.io.BufferedReader;
import java.io.FileReader;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KandidatenApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class KandidatenNormalizedTableBuilder {

    private static final Logger log = LoggerFactory.getLogger(KandidatenNormalizedTableBuilder.class);

    private final static String sqlFileUpdateFotoUrls = "etc/3nf/data/update_foto_url.sql";

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

    @Autowired
    private JdbcService jdbcService;

    @Commit
    @Test
    public void buildNormalizedTData() throws Exception {
        kandidatService.deleteAll();
        int page = 0;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<KandidatFlat> allKandidatenPage = kandidatFlatService.getAll(pageable);
        boolean goOn = true;
        while(goOn){
            for(KandidatFlat in :allKandidatenPage.getContent()){
                log.info(in.toString());
                Kandidat out = new Kandidat();
                out.setAlter(in.getAlter());
                out.setColor(in.getColor());
                out.setFoto(in.getFoto());
                out.setGeburtsjahr(in.getGeburtsjahr());
                out.setGeschlecht(in.getGeschlecht());
                out.setLat(in.getLat());
                out.setLng(in.getLng());
                out.setMdb(in.getMdb());
                out.setListePlatz(in.getListePlatz());
                out.setNachname(in.getNachname());
                out.setNachnameOhne(in.getNachnameOhne());
                out.setNamenszusatz(in.getNamenszusatz());
                out.setScatterX(in.getScatterX());
                out.setScatterY(in.getScatterY());
                out.setVorname(in.getVorname());
                out.setTitel(in.getTitel());
                out.setRemoteKey(in.getKey());
                out.setIdEigen(in.getIdEigen());
                out.setKey(in.getTransientKey());

                Beruf beruf = berufService.findByBeruf(in.getBeruf());
                Berufsgruppe berufsgruppe = berufsgruppeService.findByBerufsgruppe(in.getBerufsgruppe());
                Bundesland bundesland =  bundeslandService.findByBundesland(in.getBundesland());
                Geburtsort geburtsort = geburtsortService.findByGeburtsort(in.getGeburtsort());
                ListePartei listePartei = listeParteiService.findByListePartei(in.getListePartei(),in.getListeParteiLang());
                Partei partei = parteiService.findByPartei(in.getPartei(),in.getParteiLang());
                Wahlkreis wahlkreis = wahlkreisService.findByWahlkreisId(in.getWahlkreisId());
                Wohnort wohnort = wohnortService.findByWohnort(in.getWohnort());
                Bundesland listeBundeslandLand = bundeslandService.findByBundesland(in.getListeBundeslandLand());

                out.setBeruf(beruf);
                out.setBerufsgruppe(berufsgruppe);
                out.setBundesland(bundesland);
                out.setGeburtsort(geburtsort);
                out.setListePartei(listePartei);
                out.setPartei(partei);
                out.setWahlkreis(wahlkreis);
                out.setWohnort(wohnort);
                out.setListeBundeslandLand(listeBundeslandLand);

                out = kandidatService.create(out);

                log.info(out.toString());
            }
            if(allKandidatenPage.hasNext()){
                pageable = allKandidatenPage.nextPageable();
                allKandidatenPage = kandidatFlatService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
        BufferedReader br = new BufferedReader(new FileReader(sqlFileUpdateFotoUrls));
        long id = 0;
        while (br.ready()){
            id++;
            String sqlStatement = br.readLine();
            jdbcService.executeSqlStatemen(sqlStatement);
        }
        br.close();
    }
}
