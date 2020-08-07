package org.woehlke.btw17.importer.dimensions;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;


@Slf4j
public class BundeslandImporter {

    private final static String dateiName = "etc/3nf/SELECT_bundesland_FROM_kandidat2_GROUP_B.csv";
    private final static String dateiNameOut = "etc/3nf/insert-data-bundesland.sql";
    private final static String sqlStart = "INSERT INTO bundesland (id,bundesland,bundesland_lang) VALUES (";

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
