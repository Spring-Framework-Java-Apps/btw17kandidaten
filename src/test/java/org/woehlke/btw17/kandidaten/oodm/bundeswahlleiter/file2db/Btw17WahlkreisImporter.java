package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.file2db;


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
import org.woehlke.btw17.kandidaten.configuration.BundeslandEnum;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlkreisService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {
                KandidatenApplication.class,
                DataSourceConfig.class,
                HttpSessionConfig.class,
                WebMvcConfig.class,
                WebSecurityConfig.class
        },
        webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Btw17WahlkreisImporter {

    private static final Logger log = LoggerFactory.getLogger(Btw17WahlkreisImporter.class);

    private final String srcFileNameWahlbewerber = "etc/ergebnisse/importing/btw17_wahlkreisnamen.csv";


    @Autowired
    private Btw17WahlkreisService btw17WahlkreisService;

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
        assertThat(btw17WahlkreisService).isNotNull();
        assertThat(kandidatenProperties).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test050deleteAll() throws Exception {
        log.info("test050deleteAll");
        btw17WahlkreisService.deleteAll();
    }

    @WithMockUser
    @Commit
    @Test
    public void test100file2db() throws Exception {
        log.info("test100file2db");
        btw17WahlkreisService.deleteAll();
        Assert.assertTrue(true);
        File input = new File(srcFileNameWahlbewerber);
        BufferedReader br = new BufferedReader(new FileReader(input));
        while (br.ready()){
            String csvDataRow = br.readLine();
            log.info(csvDataRow);
            Btw17Wahlkreis o = csv2object(csvDataRow);
            o=btw17WahlkreisService.create(o);
            log.debug(o.getUniqueId());
        }
        br.close();
    }

    private Btw17Wahlkreis csv2object(String csvDataRow) throws Exception {
        Btw17Wahlkreis o = new Btw17Wahlkreis();
        String cells[] = csvDataRow.split(";");
        long wahlkreisNr =  Long.parseLong(cells[0]);
        String wahlkreisName = cells[1];
        long bundeslandId =  Long.parseLong(cells[2]);
        String bundeslandName = cells[3];
        String bundeslandKurz = cells[4];
        BundeslandEnum bundesland = BundeslandEnum.valueOf(bundeslandKurz);
        o.setWahlkreisNummer(wahlkreisNr);
        o.setWahlkreisName(wahlkreisName);
        o.setBundeslandNummer(bundeslandId);
        o.setBundeslandName(bundeslandName);
        o.setBundeslandEnumKurz(bundesland);
        return o;
    }
}
