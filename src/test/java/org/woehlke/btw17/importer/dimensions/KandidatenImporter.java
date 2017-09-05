package org.woehlke.btw17.importer.dimensions;

import org.junit.Test;

import java.io.*;

public class KandidatenImporter {

    private final static String dateiName = "src/site/btw17-kandidaten.csv";
    private final static String dateiNameOut = "src/site/btw17-kandidaten.sql";
    private final static String sqlStart = "INSERT INTO kandidat (id,kandidat_key,titel,namenszusatz,nachname_ohne,nachname,vorname,geschlecht,geburtsjahr,alter,wohnort,geburtsort,beruf,berufsgruppe,bundesland,wahlkreis_id,wahlkreis_name,partei,partei_lang,liste_bundesland_land,liste_partei,liste_partei_lang,liste_platz,mdb,lat,lng,id_eigen,foto,scatter_x,scatter_y,color) VALUES (";

    @Test
    public void createSql() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(dateiNameOut));
        BufferedReader br = new BufferedReader(new FileReader(dateiName));
        long id = 0;
        while (br.ready()){
            id++;
            String line = br.readLine();
            String output = sqlStart + id + ","+(line.replaceAll("\"","'").replaceAll("\",\"","','").replaceAll(",,",",null,").replaceAll(",,",",null,")  + ");\n");
            output = output.replaceAll(",,",",null,");
            bw.write(output);
        }
        bw.close();
        br.close();
    }
}
