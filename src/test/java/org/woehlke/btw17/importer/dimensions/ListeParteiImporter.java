package org.woehlke.btw17.importer.dimensions;

import org.junit.Test;

import java.io.*;

public class ListeParteiImporter {

    private final static String dateiName = "etc/3nf/SELECT_liste_partei_liste_partei_lang_FR.csv";
    private final static String dateiNameOut = "etc/3nf/insert-data-listepartei.sql";
    private final static String sqlStart = "INSERT INTO liste_partei (id,liste_partei,liste_partei_lang) VALUES (";

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
