package org.woehlke.btw17.kandidaten;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

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

    private final static String sqlFileLandeslisteData = "etc/3nf/data/insert-data-landesliste.sql";

    private final static String sqlFileKandidatData = "etc/3nf/data/insert-data-kandidat.sql";

    private final static String sqlFileWohnortData = "etc/3nf/data/insert-data-wohnort.sql";

    private final static String sqlFileKandidatUpdateFotoUrls = "etc/3nf/collect/update_foto_url_from_foto.sql";

    private final static String sqlFileKandidatUpdateBundetagUrls = "etc/3nf/collect/update-kandidat-bundestag.sql";

    private final static String sqlFileKandidatUpdateAbgeordnetenwatchUrls = "etc/3nf/collect/update-kandidat-abgeordnetenwatch.sql";

    private final static String sqlFileKandidatUpdateLobbypediaUrls = "etc/3nf/collect/update-kandidat-lobbypedia.sql";

    private final static String sqlFileKandidatUpdateSoundcloudUrls = "etc/3nf/collect/update-kandidat-soundcloud.sql";

    private final static String sqlFileKandidatUpdateBundestag = "etc/3nf/collect/update-kandidat-bundestag.sql";

    private final static String sqlFileKandidatUpdateFacebook = "etc/3nf/collect/update-kandidat-facebook.sql";

    private final static String sqlFileKandidatUpdateFoto = "etc/3nf/collect/update-kandidat-foto.sql";

    private final static String sqlFileKandidatUpdateTwitter = "etc/3nf/collect/update-kandidat-twitter.sql";

    private final static String sqlFileKandidatUpdateWebseite = "etc/3nf/collect/update-kandidat-webseite.sql";

    private final static String sqlFileKandidatUpdateWikipedia = "etc/3nf/collect/update-kandidat-wikipedia.sql";

    private final static String sqlFileKandidatUpdateYoutube = "etc/3nf/collect/update-kandidat-youtube.sql";


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

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @Ignore
    @Commit
    @Test
    public void build001LandesListe() throws IOException {
        kandidatService.deleteAll();
        landesListeService.deleteAll();
        int page = 0;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<KandidatFlat> allKandidatenPage = kandidatFlatService.getAllOrderByNachname(pageable);
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
                allKandidatenPage = kandidatFlatService.getAllOrderByNachname(pageable);
            } else {
                goOn = false;
            }
        }
    }

    @Ignore
    @Commit
    @Test
    public void build002Kandidat() throws Exception {
        int page = 0;
        int size = 250;
        Pageable pageable = new PageRequest(page,size);
        Page<KandidatFlat> allKandidatenPage = kandidatFlatService.getAllOrderByNachname(pageable);
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
                allKandidatenPage = kandidatFlatService.getAllOrderByNachname(pageable);
            } else {
                goOn = false;
            }
        }
    }

    @Ignore
    @Commit
    @Test
    public void build003WohnortGeoCoordinates() throws Exception {
        for(Wohnort wohnort:wohnortService.getAllOrderById()){
            String myGoogleMapsUrl = wohnort.getGeoPosition().getGoogleMapsUrl();
            if(myGoogleMapsUrl != null){
                String parts[] = myGoogleMapsUrl.split(",");
                Assert.assertTrue(myGoogleMapsUrl,parts.length==3);
                Assert.assertTrue(myGoogleMapsUrl,parts[0].startsWith("@"));
                Assert.assertTrue(myGoogleMapsUrl,parts[2].endsWith("z"));
                String geoLattitude = parts[0].replace("@","");
                String geoLongitude = parts[1];
                String geoZoom = parts[2].replace("z","");
                wohnort.getGeoPosition().setGeoLattitude(geoLattitude);
                wohnort.getGeoPosition().setGeoLongitude(geoLongitude);
                wohnort.getGeoPosition().setGeoZoom(geoZoom);
                wohnortService.update(wohnort);
            }
        }
    }

    @Ignore
    @Commit
    @Test
    public void build004UpdateFotoUrls() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateFotoUrls));
        while (br.ready()){
            String sqlStatement = br.readLine();
            jdbcService.executeSqlStatemen(sqlStatement);
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build011KandidatUpdateBundetagUrls() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateBundetagUrls));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build012KandidatUpdateAbgeordnetenwatchUrls() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateAbgeordnetenwatchUrls));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build014UpdateKandidatBundestag() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateBundestag));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build015UpdateKandidatFacebook() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateFacebook));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build016UpdateKandidatFoto() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateFoto));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build017KandidatUpdateLobbypediaUrls() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateLobbypediaUrls));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build018UpdateKandidatSoundcloud() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateSoundcloudUrls));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build019KandidatUpdateTwitter() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateTwitter));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build020UpdateKandidatWebseite() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateWebseite));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build021UpdateKandidatWikipedia() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateWikipedia));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build022UpdateKandidatYouTube() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(sqlFileKandidatUpdateYoutube));
        while (br.ready()){
            String sqlStatement = br.readLine();
            if(!sqlStatement.contains("NULL")){
                jdbcService.executeSqlStatemen(sqlStatement);
            }
        }
        br.close();
    }

    @Ignore
    @Commit
    @Test
    public void build100LandesListeSql() throws IOException {
        File landesliste = new File(sqlFileLandeslisteData);
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


    @Ignore
    @Commit
    @Test
    public void build200CheckResults() throws IOException {
        long countKandidatenFlat = kandidatFlatService.count();
        long countKandidaten = kandidatService.count();
        Assert.assertEquals(countKandidatenFlat,countKandidaten);
    }

    @Ignore
    @Commit
    @Test
    public void build300CheckCount() throws Exception {
        long countBerufSoll = kandidatenProperties.getTableContent().getCountBeruf();
        long countBerufsgruppeSoll = kandidatenProperties.getTableContent().getCountBerufsgruppe();
        long countBundeslandSoll = kandidatenProperties.getTableContent().getCountBundesland();
        long countGeburtsortSoll = kandidatenProperties.getTableContent().getCountGeburtsort();
        long countParteiSoll = kandidatenProperties.getTableContent().getCountPartei();
        long countWahlkreisSoll = kandidatenProperties.getTableContent().getCountWahlkreis();
        long countWohnortSoll = kandidatenProperties.getTableContent().getCountWohnort();
        long countLandesListeSoll = kandidatenProperties.getTableContent().getCountLandesListe();
        long countKandidatFlatSoll = kandidatenProperties.getTableContent().getCountKandidatFlat();
        long countKandidatSoll = kandidatenProperties.getTableContent().getCountKandidat();

        long countBerufIst = berufService.count();
        long countBerufsgruppeIst = berufsgruppeService.count();
        long countBundeslandIst = bundeslandService.count();
        long countGeburtsortIst = geburtsortService.count();
        long countParteiIst = parteiService.count();
        long countWahlkreisIst = wahlkreisService.count();
        long countWohnortIst = wohnortService.count();
        long countLandesListeIst = landesListeService.count();
        long countKandidatFlatIst = kandidatFlatService.count();
        long countKandidatIst = kandidatService.count();

        Assert.assertEquals(countBerufSoll,countBerufIst);
        Assert.assertEquals(countBerufsgruppeSoll,countBerufsgruppeIst);
        Assert.assertEquals(countBundeslandSoll,countBundeslandIst);
        Assert.assertEquals(countGeburtsortSoll,countGeburtsortIst);
        Assert.assertEquals(countParteiSoll,countParteiIst);
        Assert.assertEquals(countWahlkreisSoll,countWahlkreisIst);
        Assert.assertEquals(countWohnortSoll,countWohnortIst);
        Assert.assertEquals(countLandesListeSoll,countLandesListeIst);
        Assert.assertEquals(countKandidatFlatSoll,countKandidatFlatIst);
        Assert.assertEquals(countKandidatSoll,countKandidatIst);
    }

    @Ignore
    @Commit
    @Test
    public void build300BuildDataSqlFile() throws IOException,InterruptedException {
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
