package org.woehlke.btw17.importer.dimensions;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;


@Slf4j
public class ParteiImporter {

    private final static String dateiName = "etc/3nf/SELECT_partei_partei_lang_FROM_kandidat_.csv";
    private final static String dateiNameOut = "etc/3nf/insert-data-partei.sql";
    private final static String sqlStart = "INSERT INTO partei (id,partei,partei_lang) VALUES (";

    @Ignore
    @Test
    public void createSql() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(dateiNameOut));
        BufferedReader br = new BufferedReader(new FileReader(dateiName));
        long id = 0;
        while (br.ready()){
            id++;
            String line = br.readLine();
            String output = sqlStart + id + ", "+line+" );\n";
            bw.write(output);
        }
        bw.close();
        br.close();
    }
}
