package org.woehlke.btw17.importer.dimensions;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

public class GeburtsortImporter {

    private final static String dateiName = "etc/3nf/SELECT_geburtsort_FROM_kandidat_GROUP_BY.csv";
    private final static String dateiNameOut = "etc/3nf/insert-data-geburtsort.sql";
    private final static String sqlStart = "INSERT INTO geburtsort (id,geburtsort) VALUES (";

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
