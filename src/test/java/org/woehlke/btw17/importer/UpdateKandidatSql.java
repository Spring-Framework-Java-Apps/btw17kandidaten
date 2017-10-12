package org.woehlke.btw17.importer;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateKandidatSql {

    private static final Logger log = LoggerFactory.getLogger(UpdateKandidatSql.class);

    @Test
    public void updateSqlFile() throws Exception {
        String tabellen[] = {
                "agentur",
                "ausschuss",
                "bundesland",
                "cms",
                "fraktion",
                "geburtsort",
                "kandidat",
                "listepartei",
                "ministerium",
                "partei",
                "wahlkreis",
                "wohnort"
        };
        for(String tabelle:tabellen) {
            File file = new File("etc/3nf/data/insert-data-"+tabelle+".sql");
            File fileOut = new File("etc/3nf/data/insert-data-"+tabelle+".sql.txt.sql");
            if (fileOut.canRead()) {
                fileOut.delete();
            }
            BufferedReader in = new BufferedReader(new FileReader(file));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
            while (in.ready()) {
                String line = in.readLine();
                line = line.replace(");", "");
                line = line.replace("INSERT INTO "+tabelle+" (", "");
                String data[] = line.split("\\) VALUES \\(");
                String columns[] = data[0].split(",");
                String fields[] = data[1].split(",");
                String removeCols[] = {
                        "xing", "linked_in", "stackoverflow", "github", "whatsapp", "wordpress", "spotify", "snapchat", "skype", "slack", "slideshare",
                        "pinterest", "paypal", "meetup", "lastfm", "imdb", "foursquare", "digg", "delicious", "url500px", "amazon", "hacker_news", "scribd",
                        "tumblr", "viadeo", "yahoo", "yoast", "yelp"
                };
                List<String> colums2remove = new ArrayList<>();
                for (String col : removeCols) {
                    colums2remove.add(col);
                }
                StringBuilder cols = new StringBuilder();
                StringBuilder datacells = new StringBuilder();
                for (int i = 0; i < columns.length; i++) {
                    if (!colums2remove.contains(columns[i].trim())) {
                        cols.append(columns[i]);
                        datacells.append(fields[i]);
                        cols.append(",");
                        datacells.append(",");
                    }
                }
                String x = cols.toString();
                String y = datacells.toString();
                int xlen = x.length();
                int ylen = y.length();
                x = x.substring(0, xlen - 2);
                y = y.substring(0, ylen - 2);
                String sqlOutput = "INSERT INTO "+tabelle+" (" + x + ") VALUES (" + y + ");";
                out.println(sqlOutput);
                log.info(sqlOutput);
            }
            in.close();
            out.close();
            fileOut.renameTo(file);
        }
    }
}
