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
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.*;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KandidatenApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExportKandidatTable {

    private static final Logger log = LoggerFactory.getLogger(ExportKandidatTable.class);

    private final static String sqlFileKandidatData = "etc/3nf/data/insert-data-kandidat.sql";

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



    @Commit
    @Test
    public void build101KandidatSql() throws IOException {
        File dataOut = new File(sqlFileKandidatData);
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
        ExportKandidatTable.StreamGobbler streamGobbler =
                new ExportKandidatTable.StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

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
