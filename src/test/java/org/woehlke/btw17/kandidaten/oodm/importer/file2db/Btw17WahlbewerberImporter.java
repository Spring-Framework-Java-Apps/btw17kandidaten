package org.woehlke.btw17.kandidaten.oodm.importer.file2db;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.model.Btw17Wahlbewerber;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlbewerberService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {
                KandidatenApplication.class,
                HttpSessionConfig.class,
                WebMvcConfig.class,
                WebSecurityConfig.class
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Btw17WahlbewerberImporter {

    private static final Logger log = LoggerFactory.getLogger(Btw17WahlbewerberImporter.class);

    private final String srcFileNameWahlbewerber = "etc/ergebnisse/importing/btw17_kandidaten_utf8-korr2.csv";


    @Autowired
    private Btw17WahlbewerberService btw17WahlbewerberService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @WithMockUser
    @Commit
    @Test
    public void test000controllerIsPresentTest(){
        log.info("controllerIsPresentTest");
        assertThat(mockMvc).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(btw17WahlbewerberService).isNotNull();
        assertThat(kandidatenProperties).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test100file2db() throws Exception {
        log.info("test100file2db");
        Assert.assertTrue(true);
        btw17WahlbewerberService.deleteAll();
        Assert.assertTrue(true);
        File input = new File(srcFileNameWahlbewerber);
        BufferedReader br = new BufferedReader(new FileReader(input));
        while (br.ready()){
            String csvDataRow = br.readLine();
            log.info(csvDataRow);
            Btw17Wahlbewerber o = csv2object(csvDataRow);
            o=btw17WahlbewerberService.create(o);
            log.debug(o.getUniqueId());
            log.debug(o.toString());
        }
        br.close();
    }

    private Btw17Wahlbewerber csv2object(String csvDataRow) throws Exception {
        String work = csvDataRow;
        while(work.contains(";;")){
            work = work.replaceAll(";;",";@;");
        }
        work = work.replaceAll("^;","@;");
        work = work.replaceAll(";$",";@");
        log.info(work);
        Btw17Wahlbewerber o = new Btw17Wahlbewerber();
        String cells[] = work.split(";");
        log.info(Integer.toString(cells.length));

        String titel=cells[0];
        String namenszusatz=cells[1];
        String name=cells[2];
        String vorname=cells[3];
        String geschlecht=cells[4];
        String geburtsjahr=cells[5];
        String wohnort=cells[6];
        String geburtsort=cells[7];
        String beruf=cells[8];
        String wahlkreis_Land=cells[9];
        String wahlkreis_Nr=cells[10];
        String wahlkreis_Bez=cells[11];
        String wahlkreis_ParteiKurzBez=cells[12];
        String wahlkreis_ParteiBez=cells[13];
        String liste_Land=cells[14];
        String liste_ParteiKurzBez=cells[15];
        String liste_ParteiBez=cells[16];
        String liste_Platz=cells[17];
        String wiederkandidatur=cells[18];

        log.info("titel                    "+titel);
        log.info("namenszusatz             "+namenszusatz);
        log.info("name                     "+name);
        log.info("vorname                  "+vorname);
        log.info("geschlecht               "+geschlecht);
        log.info("geburtsjahr              "+geburtsjahr);
        log.info("wohnort                  "+wohnort);
        log.info("geburtsort               "+geburtsort);
        log.info("beruf                    "+beruf);
        log.info("wahlkreis_Land           "+wahlkreis_Land);
        log.info("wahlkreis_Nr             "+wahlkreis_Nr);
        log.info("wahlkreis_Bez            "+wahlkreis_Bez);
        log.info("wahlkreis_ParteiKurzBez  "+wahlkreis_ParteiKurzBez);
        log.info("wahlkreis_ParteiBez      "+wahlkreis_ParteiBez);
        log.info("liste_Land               "+liste_Land);
        log.info("liste_ParteiKurzBez      "+liste_ParteiKurzBez);
        log.info("liste_ParteiBez          "+liste_ParteiBez);
        log.info("liste_Platz              "+liste_Platz);
        log.info("wiederkandidatur         "+wiederkandidatur);

        Integer myGeburtsjahr = -1;
        BundeslandEnum myWahlkreisLand = BundeslandEnum.BE;
        Long wahlkreisNr = -1L;
        Integer listePlatz = -1;
        Boolean myWiederkandidatur = false;
        if(geburtsjahr.matches("^\\d{4}$")){
            myGeburtsjahr = Integer.parseInt(geburtsjahr);
        }
        if(wahlkreis_Land.matches("^\\w{2}$")){
            myWahlkreisLand = BundeslandEnum.valueOf(wahlkreis_Land);
        }
        if(wahlkreis_Nr.matches("^\\d*$")){
            wahlkreisNr = Long.parseLong(wahlkreis_Nr);
        }
        if(liste_Platz.matches("^\\d*$")){
            listePlatz = Integer.parseInt(liste_Platz);
        }
        myWiederkandidatur = (wiederkandidatur != null && wiederkandidatur.compareTo("X")==0);

        o.setTitel(titel);
        o.setNamenszusatz(namenszusatz);
        o.setName(name);
        o.setVorname(vorname);
        o.setGeschlecht(geschlecht);
        o.setGeburtsjahr(myGeburtsjahr);
        o.setWohnort(wohnort);
        o.setGeburtsort(geburtsort);
        o.setBeruf(beruf);
        o.setWahlkreisNr(wahlkreisNr);
        o.setWahlkreisBez(wahlkreis_Bez);
        o.setWahlkreisParteiKurzBez(wahlkreis_ParteiKurzBez);
        o.setWahlkreisParteiBez(wahlkreis_ParteiBez);
        o.setListeLand(liste_Land);
        o.setListeParteiKurzBez(liste_ParteiKurzBez);
        o.setListeParteiBez(liste_ParteiBez);
        o.setWahlkreisLand(myWahlkreisLand);
        o.setListePlatz(listePlatz);
        o.setWiederkandidatur(myWiederkandidatur);

        return o;
    }
}
