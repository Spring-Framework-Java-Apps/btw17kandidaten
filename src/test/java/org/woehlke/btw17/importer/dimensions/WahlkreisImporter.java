package org.woehlke.btw17.importer.dimensions;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;


@Slf4j
public class WahlkreisImporter {

    private final static String dateiName = "etc/3nf/SELECT_wahlkreis_id_wahlkreis_name_FROM_.csv";
    private final static String dateiNameOut = "etc/3nf/insert-data-wahlkreis.sql";
    private final static String sqlStart = "INSERT INTO wahlkreis (id,wahlkreis_id,wahlkreis_name) VALUES (";

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
