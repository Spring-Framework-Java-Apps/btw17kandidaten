package org.woehlke.btw17.kandidaten;

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
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.service.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KandidatenApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KandidatenNormalizedTableBuilder {

    private static final Logger log = LoggerFactory.getLogger(KandidatenNormalizedTableBuilder.class);

    private final static String sqlFileUpdateFotoUrls = "etc/3nf/data/update_foto_url.sql";

    private final static String sqlFileUpdateKandidatUrls = "etc/3nf/data/update-kandidat-urls.sql";

    private final static String sqlFileDataKandidat = "etc/3nf/data/insert-data-kandidat.sql";

    private final static String sqlFileDataLandesliste = "etc/3nf/data/insert-data-landesliste.sql";

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
    private LandesListeService landesListeService;

    @Autowired
    private WahlkreisService wahlkreisService;

    @Autowired
    private WohnortService wohnortService;

    @Autowired
    private JdbcService jdbcService;

    @Commit
    @Test
    public void build1LandesListe() throws IOException {
        kandidatService.deleteAll();
        landesListeService.deleteAll();
        int page = 0;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<KandidatFlat> allKandidatenPage = kandidatFlatService.getAll(pageable);
        boolean goOn = true;
        List<LandesListe> landesListen = new ArrayList<>();
        while(goOn) {
            for (KandidatFlat in : allKandidatenPage.getContent()) {
                ListePartei listePartei = listeParteiService.findByListePartei(in.getListePartei(),in.getListeParteiLang());
                Bundesland listeBundeslandLand = bundeslandService.findByBundesland(in.getListeBundeslandLand());
                if((listePartei!=null)&&(listeBundeslandLand!=null)){
                    LandesListe landesListe = landesListeService.fetchOrCreateByBundeslandAndListePartei(listeBundeslandLand,listePartei);
                    if(!landesListen.contains(landesListe)){
                        landesListen.add(landesListe);
                    }
                }
            }
            if(allKandidatenPage.hasNext()){
                pageable = allKandidatenPage.nextPageable();
                allKandidatenPage = kandidatFlatService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }

    @Commit
    @Test
    public void build2Kandidat() throws Exception {
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
                if((in.getMdb()!=null)&&(!in.getMdb().isEmpty())){
                    out.setMdb("1");
                }
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
                Partei partei = parteiService.findByPartei(in.getPartei(),in.getParteiLang());
                Wahlkreis wahlkreis = wahlkreisService.findByWahlkreisId(in.getWahlkreisId());
                Wohnort wohnort = wohnortService.findByWohnort(in.getWohnort());

                ListePartei listePartei = listeParteiService.findByListePartei(in.getListePartei(),in.getListeParteiLang());
                Bundesland listeBundeslandLand = bundeslandService.findByBundesland(in.getListeBundeslandLand());

                if((listePartei!=null)&&(listeBundeslandLand!=null)){
                    LandesListe landesListe = landesListeService.findByBundeslandAndListePartei(listeBundeslandLand,listePartei);
                    out.setLandesListe(landesListe);
                }

                out.setBeruf(beruf);
                out.setBerufsgruppe(berufsgruppe);
                out.setBundesland(bundesland);
                out.setGeburtsort(geburtsort);
                out.setPartei(partei);
                out.setWahlkreis(wahlkreis);
                out.setWohnort(wohnort);
                out.setKandidatFlat(in);

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
    }

    @Commit
    @Test
    public void build3LandesListeSql() throws IOException {
        File landesliste = new File(sqlFileDataLandesliste);
        landesliste.delete();
        BufferedWriter bw = new BufferedWriter(new FileWriter(landesliste));
        for(LandesListe landesListe:landesListeService.getAll()){
            String sql = landesListe.getSqlInsert();
            bw.write(sql);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    @Commit
    @Test
    public void build4UpdateFotoUrls() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileUpdateFotoUrls));
        while (br.ready()){
            String sqlStatement = br.readLine();
            jdbcService.executeSqlStatemen(sqlStatement);
        }
        br.close();
    }

    @Commit
    @Test
    public void build5UpdateKandidatUrls() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileUpdateKandidatUrls));
        while (br.ready()){
            String sqlStatement = br.readLine();
            jdbcService.executeSqlStatemen(sqlStatement);
        }
        br.close();
    }

    @Commit
    @Test
    public void build6KandidatSql() throws IOException {
        File dataOut = new File(sqlFileDataKandidat);
        dataOut.delete();
        BufferedWriter bw = new BufferedWriter(new FileWriter(dataOut));
        bw.write("DELETE FROM kandidat;");
        bw.newLine();
        long id = 0;
        for(Kandidat k :kandidatService.getAll()) {
            id++;
            bw.write(k.getSqlInsert(id));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    @Commit
    @Test
    public void build7CheckResults() throws IOException {
        long countKandidatenFlat = kandidatFlatService.count();
        long countKandidaten = kandidatService.count();
        Assert.assertEquals(countKandidatenFlat,countKandidaten);
    }

    @Commit
    @Test
    public void build8BuildDataSql() throws IOException,InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c", "./build-db-data-import-file.sh");
        }
        builder.directory(new File("etc"));
        Process process = builder.start();
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }
}
