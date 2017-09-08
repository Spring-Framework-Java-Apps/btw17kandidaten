package org.woehlke.btw17.kandidaten;

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
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

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
    private KandidatService kandidatService;


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
