package org.woehlke.btw17.importer;

import java.io.*;

public class WohnortImporter {


    private final static String dateiName = "src/site/src/site/select_wohnort_FROM_kandidat_group_by_wo.tsv";
    private final static String dateiNameOut = "src/site/btw17-wohnort.sql";
    private final static String sqlStart = "INSERT INTO kandidat (id,kandidat_key,titel,namenszusatz,nachname_ohne,nachname,vorname,geschlecht,geburtsjahr,alter,wohnort,geburtsort,beruf,berufsgruppe,bundesland,wahlkreis_id,wahlkreis_name,partei,partei_lang,liste_bundesland_land,liste_partei,liste_partei_lang,liste_platz,mdb,lat,lng,id_eigen,foto,scatter_x,scatter_y,color) VALUES (";

    public static void main(String[] args) throws IOException {
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
