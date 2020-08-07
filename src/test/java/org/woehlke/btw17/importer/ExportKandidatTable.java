package org.woehlke.btw17.importer;

import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Commit;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExportKandidatTable {

    @Ignore
    @Commit
    @Test
    public void build300BuildKandidatSqlFile() throws IOException,InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c", "./export-kandidat.sh");
        }
        builder.directory(new File("etc"));
        Process process = builder.start();
        ExportKandidatTable.StreamGobbler streamGobbler =
                new ExportKandidatTable.StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    @Ignore
    @Commit
    @Test
    public void build301BuildDataSqlFile() throws IOException,InterruptedException {
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
