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
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17ErgebnisService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
public class Btw17ErgebnisImporter {

    private static final Logger log = LoggerFactory.getLogger(Btw17ErgebnisImporter.class);

    private final String srcFileNameErgebnisWahlkreise = "etc/ergebnisse/importing/btw17_kerg_wahlkreise.csv";

    private final String srcFileNameErgebnisBundeslaender = "etc/ergebnisse/importing/btw17_kerg_bundeslaender.csv";

    private final String srcFileNameErgebnisDeutschland = "etc/ergebnisse/importing/btw17_kerg_deutschland.csv";

    @Autowired
    private Btw17ErgebnisService btw17ErgebnisService;

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
        assertThat(btw17ErgebnisService).isNotNull();
        assertThat(kandidatenProperties).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test100file2db() throws Exception {
        log.info("test100file2db");
        Assert.assertTrue(true);

        log.info("test100file2db");
        btw17ErgebnisService.deleteAll();
        Assert.assertTrue(true);
        File input = new File(srcFileNameErgebnisWahlkreise);
        BufferedReader br = new BufferedReader(new FileReader(input));
        log.info("=============================================================");
        while (br.ready()){
            log.info("*************************************************************");
            String csvDataRow = br.readLine();
            log.info(csvDataRow);
            Btw17Ergebnis o = csv2object(csvDataRow);
            o = btw17ErgebnisService.create(o);
            log.info(o.getUniqueId());
            log.info("*************************************************************");
        }
        log.info("=============================================================");
        br.close();
        Assert.assertTrue(true);
    }

    private Btw17Ergebnis csv2object(String csvDataRow) throws Exception {
        Btw17Ergebnis o = new Btw17Ergebnis();

        String work = csvDataRow;
        /*
        while(work.contains(";.;")){
            work = work.replaceAll(";.;",";0.0;");
        }
        */
        while(work.contains(";;")){
            work = work.replaceAll(";;",";0;");
        }
        //work = work.replaceAll("^;","@;");
        //work = work.replaceAll(";$",";@");
        log.info(work);
        String cells[] = work.split(";");

        log.info("cells.length: "+Integer.toString(cells.length));
        int i = 0;
        Long wahlkreisNummer=Long.parseLong(cells[i]); i++;
        String wahlkreisName=cells[i]; i++;
        Long bundeslandNummer=Long.parseLong(cells[i]); i++;
        Long wahlberechtigteErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long wahlberechtigteErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long wahlberechtigteZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long wahlberechtigteZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long waehlerErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long waehlerErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long waehlerZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long waehlerZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long ungueltigeErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long ungueltigeErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long ungueltigeZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long ungueltigeZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long gueltigeErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long gueltigeErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long gueltigeZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long gueltigeZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long cduErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long cduErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long cduZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long cduZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long spdErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long spdErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long spdZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long spdZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dielinkeErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dielinkeErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dielinkeZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dielinkeZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diegruenenErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diegruenenErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diegruenenZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diegruenenZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long csuErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long csuErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long csuZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long csuZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long fdpErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long fdpErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long fdpZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long fdpZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long afdErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long afdErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long afdZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long afdZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long piratenparteiErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long piratenparteiErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long piratenparteiZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long piratenparteiZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long npdErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long npdErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long npdZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long npdZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long freieWaehlerErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long freieWaehlerErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long freieWaehlerZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long freieWaehlerZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long tierschutzparteiErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long tierschutzparteiErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long tierschutzparteiZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long tierschutzparteiZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long oedpErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long oedpErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long oedpZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long oedpZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dieparteiErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dieparteiErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dieparteiZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dieparteiZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long bayernparteiErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long bayernparteiErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long bayernparteiZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long bayernparteiZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long volksabstimmungErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long volksabstimmungErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long volksabstimmungZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long volksabstimmungZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long pdvErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long pdvErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long pdvZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long pdvZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long mlpdErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long mlpdErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long mlpdZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long mlpdZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long buesoErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long buesoErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long buesoZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long buesoZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long sgpErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long sgpErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long sgpZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long sgpZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dierechteErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dierechteErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dierechteZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dierechteZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long addErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long addErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long addZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long addZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long tierschutzallianzErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long tierschutzallianzErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long tierschutzallianzZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long tierschutzallianzZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long bergparteiErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long bergparteiErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long bergparteiZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long bergparteiZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long bgeErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long bgeErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long bgeZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long bgeZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dibErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dibErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dibZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dibZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dkpErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dkpErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dkpZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dkpZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dmErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dmErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dmZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dmZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diegrauenErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diegrauenErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diegrauenZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diegrauenZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long duErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long duErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long duZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long duZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long mgErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long mgErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long mgZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long mgZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long menschlicheweltErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long menschlicheweltErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long menschlicheweltZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long menschlicheweltZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diehumanistenErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diehumanistenErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diehumanistenZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diehumanistenZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long gesundheitsforschungErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long gesundheitsforschungErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long gesundheitsforschungZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long gesundheitsforschungZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long vparteiErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long vparteiErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long vparteiZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long vparteiZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long buendniscErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long buendniscErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long buendniscZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long buendniscZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dieeinheitErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dieeinheitErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dieeinheitZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dieeinheitZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dieviolettenErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dieviolettenErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long dieviolettenZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long dieviolettenZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long familieErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long familieErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long familieZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long familieZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diefrauenErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diefrauenErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long diefrauenZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long diefrauenZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long mieterparteiErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long mieterparteiErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long mieterparteiZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long mieterparteiZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long neueliberaleErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long neueliberaleErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long neueliberaleZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long neueliberaleZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long unabhaengigeErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long unabhaengigeErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long unabhaengigeZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long unabhaengigeZweitstimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long uebrigeErststimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long uebrigeErststimmenVorperiode=Long.parseLong(cells[i]); i++;
        Long uebrigeZweitstimmenVorlaeufig=Long.parseLong(cells[i]); i++;
        Long uebrigeZweitstimmenVorperiode=Long.parseLong(cells[i]);
        String fieldnamesSettingNames[] = {
                "wahlkreisNummer",
                "wahlkreisName",
                "bundeslandNummer",
                "wahlberechtigteErststimmenVorlaeufig",
                "wahlberechtigteErststimmenVorperiode",
                "wahlberechtigteZweitstimmenVorlaeufig",
                "wahlberechtigteZweitstimmenVorperiode",
                "waehlerErststimmenVorlaeufig",
                "waehlerErststimmenVorperiode",
                "waehlerZweitstimmenVorlaeufig",
                "waehlerZweitstimmenVorperiode",
                "ungueltigeErststimmenVorlaeufig",
                "ungueltigeErststimmenVorperiode",
                "ungueltigeZweitstimmenVorlaeufig",
                "ungueltigeZweitstimmenVorperiode",
                "gueltigeErststimmenVorlaeufig",
                "gueltigeErststimmenVorperiode",
                "gueltigeZweitstimmenVorlaeufig",
                "gueltigeZweitstimmenVorperiode",
                "cduErststimmenVorlaeufig",
                "cduErststimmenVorperiode",
                "cduZweitstimmenVorlaeufig",
                "cduZweitstimmenVorperiode",
                "spdErststimmenVorlaeufig",
                "spdErststimmenVorperiode",
                "spdZweitstimmenVorlaeufig",
                "spdZweitstimmenVorperiode",
                "dielinkeErststimmenVorlaeufig",
                "dielinkeErststimmenVorperiode",
                "dielinkeZweitstimmenVorlaeufig",
                "dielinkeZweitstimmenVorperiode",
                "diegruenenErststimmenVorlaeufig",
                "diegruenenErststimmenVorperiode",
                "diegruenenZweitstimmenVorlaeufig",
                "diegruenenZweitstimmenVorperiode",
                "csuErststimmenVorlaeufig",
                "csuErststimmenVorperiode",
                "csuZweitstimmenVorlaeufig",
                "csuZweitstimmenVorperiode",
                "fdpErststimmenVorlaeufig",
                "fdpErststimmenVorperiode",
                "fdpZweitstimmenVorlaeufig",
                "fdpZweitstimmenVorperiode",
                "afdErststimmenVorlaeufig",
                "afdErststimmenVorperiode",
                "afdZweitstimmenVorlaeufig",
                "afdZweitstimmenVorperiode",
                "piratenparteiErststimmenVorlaeufig",
                "piratenparteiErststimmenVorperiode",
                "piratenparteiZweitstimmenVorlaeufig",
                "piratenparteiZweitstimmenVorperiode",
                "npdErststimmenVorlaeufig",
                "npdErststimmenVorperiode",
                "npdZweitstimmenVorlaeufig",
                "npdZweitstimmenVorperiode",
                "freieWaehlerErststimmenVorlaeufig",
                "freieWaehlerErststimmenVorperiode",
                "freieWaehlerZweitstimmenVorlaeufig",
                "freieWaehlerZweitstimmenVorperiode",
                "tierschutzparteiErststimmenVorlaeufig",
                "tierschutzparteiErststimmenVorperiode",
                "tierschutzparteiZweitstimmenVorlaeufig",
                "tierschutzparteiZweitstimmenVorperiode",
                "oedpErststimmenVorlaeufig",
                "oedpErststimmenVorperiode",
                "oedpZweitstimmenVorlaeufig",
                "oedpZweitstimmenVorperiode",
                "dieparteiErststimmenVorlaeufig",
                "dieparteiErststimmenVorperiode",
                "dieparteiZweitstimmenVorlaeufig",
                "dieparteiZweitstimmenVorperiode",
                "bayernparteiErststimmenVorlaeufig",
                "bayernparteiErststimmenVorperiode",
                "bayernparteiZweitstimmenVorlaeufig",
                "bayernparteiZweitstimmenVorperiode",
                "volksabstimmungErststimmenVorlaeufig",
                "volksabstimmungErststimmenVorperiode",
                "volksabstimmungZweitstimmenVorlaeufig",
                "volksabstimmungZweitstimmenVorperiode",
                "pdvErststimmenVorlaeufig",
                "pdvErststimmenVorperiode",
                "pdvZweitstimmenVorlaeufig",
                "pdvZweitstimmenVorperiode",
                "mlpdErststimmenVorlaeufig",
                "mlpdErststimmenVorperiode",
                "mlpdZweitstimmenVorlaeufig",
                "mlpdZweitstimmenVorperiode",
                "buesoErststimmenVorlaeufig",
                "buesoErststimmenVorperiode",
                "buesoZweitstimmenVorlaeufig",
                "buesoZweitstimmenVorperiode",
                "sgpErststimmenVorlaeufig",
                "sgpErststimmenVorperiode",
                "sgpZweitstimmenVorlaeufig",
                "sgpZweitstimmenVorperiode",
                "dierechteErststimmenVorlaeufig",
                "dierechteErststimmenVorperiode",
                "dierechteZweitstimmenVorlaeufig",
                "dierechteZweitstimmenVorperiode",
                "addErststimmenVorlaeufig",
                "addErststimmenVorperiode",
                "addZweitstimmenVorlaeufig",
                "addZweitstimmenVorperiode",
                "tierschutzallianzErststimmenVorlaeufig",
                "tierschutzallianzErststimmenVorperiode",
                "tierschutzallianzZweitstimmenVorlaeufig",
                "tierschutzallianzZweitstimmenVorperiode",
                "bergparteiErststimmenVorlaeufig",
                "bergparteiErststimmenVorperiode",
                "bergparteiZweitstimmenVorlaeufig",
                "bergparteiZweitstimmenVorperiode",
                "bgeErststimmenVorlaeufig",
                "bgeErststimmenVorperiode",
                "bgeZweitstimmenVorlaeufig",
                "bgeZweitstimmenVorperiode",
                "dibErststimmenVorlaeufig",
                "dibErststimmenVorperiode",
                "dibZweitstimmenVorlaeufig",
                "dibZweitstimmenVorperiode",
                "dkpErststimmenVorlaeufig",
                "dkpErststimmenVorperiode",
                "dkpZweitstimmenVorlaeufig",
                "dkpZweitstimmenVorperiode",
                "dmErststimmenVorlaeufig",
                "dmErststimmenVorperiode",
                "dmZweitstimmenVorlaeufig",
                "dmZweitstimmenVorperiode",
                "diegrauenErststimmenVorlaeufig",
                "diegrauenErststimmenVorperiode",
                "diegrauenZweitstimmenVorlaeufig",
                "diegrauenZweitstimmenVorperiode",
                "duErststimmenVorlaeufig",
                "duErststimmenVorperiode",
                "duZweitstimmenVorlaeufig",
                "duZweitstimmenVorperiode",
                "mgErststimmenVorlaeufig",
                "mgErststimmenVorperiode",
                "mgZweitstimmenVorlaeufig",
                "mgZweitstimmenVorperiode",
                "menschlicheweltErststimmenVorlaeufig",
                "menschlicheweltErststimmenVorperiode",
                "menschlicheweltZweitstimmenVorlaeufig",
                "menschlicheweltZweitstimmenVorperiode",
                "diehumanistenErststimmenVorlaeufig",
                "diehumanistenErststimmenVorperiode",
                "diehumanistenZweitstimmenVorlaeufig",
                "diehumanistenZweitstimmenVorperiode",
                "gesundheitsforschungErststimmenVorlaeufig",
                "gesundheitsforschungErststimmenVorperiode",
                "gesundheitsforschungZweitstimmenVorlaeufig",
                "gesundheitsforschungZweitstimmenVorperiode",
                "vparteiErststimmenVorlaeufig",
                "vparteiErststimmenVorperiode",
                "vparteiZweitstimmenVorlaeufig",
                "vparteiZweitstimmenVorperiode",
                "buendniscErststimmenVorlaeufig",
                "buendniscErststimmenVorperiode",
                "buendniscZweitstimmenVorlaeufig",
                "buendniscZweitstimmenVorperiode",
                "dieeinheitErststimmenVorlaeufig",
                "dieeinheitErststimmenVorperiode",
                "dieeinheitZweitstimmenVorlaeufig",
                "dieeinheitZweitstimmenVorperiode",
                "dieviolettenErststimmenVorlaeufig",
                "dieviolettenErststimmenVorperiode",
                "dieviolettenZweitstimmenVorlaeufig",
                "dieviolettenZweitstimmenVorperiode",
                "familieErststimmenVorlaeufig",
                "familieErststimmenVorperiode",
                "familieZweitstimmenVorlaeufig",
                "familieZweitstimmenVorperiode",
                "diefrauenErststimmenVorlaeufig",
                "diefrauenErststimmenVorperiode",
                "diefrauenZweitstimmenVorlaeufig",
                "diefrauenZweitstimmenVorperiode",
                "mieterparteiErststimmenVorlaeufig",
                "mieterparteiErststimmenVorperiode",
                "mieterparteiZweitstimmenVorlaeufig",
                "mieterparteiZweitstimmenVorperiode",
                "neueliberaleErststimmenVorlaeufig",
                "neueliberaleErststimmenVorperiode",
                "neueliberaleZweitstimmenVorlaeufig",
                "neueliberaleZweitstimmenVorperiode",
                "unabhaengigeErststimmenVorlaeufig",
                "unabhaengigeErststimmenVorperiode",
                "unabhaengigeZweitstimmenVorlaeufig",
                "unabhaengigeZweitstimmenVorperiode",
                "uebrigeErststimmenVorlaeufig",
                "uebrigeErststimmenVorperiode",
                "uebrigeZweitstimmenVorlaeufig",
                "uebrigeZweitstimmenVorperiode"
        };

        Object fieldnamesSetting[] = {
                wahlkreisNummer,
                wahlkreisName,
                bundeslandNummer,
                wahlberechtigteErststimmenVorlaeufig,
                wahlberechtigteErststimmenVorperiode,
                wahlberechtigteZweitstimmenVorlaeufig,
                wahlberechtigteZweitstimmenVorperiode,
                waehlerErststimmenVorlaeufig,
                waehlerErststimmenVorperiode,
                waehlerZweitstimmenVorlaeufig,
                waehlerZweitstimmenVorperiode,
                ungueltigeErststimmenVorlaeufig,
                ungueltigeErststimmenVorperiode,
                ungueltigeZweitstimmenVorlaeufig,
                ungueltigeZweitstimmenVorperiode,
                gueltigeErststimmenVorlaeufig,
                gueltigeErststimmenVorperiode,
                gueltigeZweitstimmenVorlaeufig,
                gueltigeZweitstimmenVorperiode,
                cduErststimmenVorlaeufig,
                cduErststimmenVorperiode,
                cduZweitstimmenVorlaeufig,
                cduZweitstimmenVorperiode,
                spdErststimmenVorlaeufig,
                spdErststimmenVorperiode,
                spdZweitstimmenVorlaeufig,
                spdZweitstimmenVorperiode,
                dielinkeErststimmenVorlaeufig,
                dielinkeErststimmenVorperiode,
                dielinkeZweitstimmenVorlaeufig,
                dielinkeZweitstimmenVorperiode,
                diegruenenErststimmenVorlaeufig,
                diegruenenErststimmenVorperiode,
                diegruenenZweitstimmenVorlaeufig,
                diegruenenZweitstimmenVorperiode,
                csuErststimmenVorlaeufig,
                csuErststimmenVorperiode,
                csuZweitstimmenVorlaeufig,
                csuZweitstimmenVorperiode,
                fdpErststimmenVorlaeufig,
                fdpErststimmenVorperiode,
                fdpZweitstimmenVorlaeufig,
                fdpZweitstimmenVorperiode,
                afdErststimmenVorlaeufig,
                afdErststimmenVorperiode,
                afdZweitstimmenVorlaeufig,
                afdZweitstimmenVorperiode,
                piratenparteiErststimmenVorlaeufig,
                piratenparteiErststimmenVorperiode,
                piratenparteiZweitstimmenVorlaeufig,
                piratenparteiZweitstimmenVorperiode,
                npdErststimmenVorlaeufig,
                npdErststimmenVorperiode,
                npdZweitstimmenVorlaeufig,
                npdZweitstimmenVorperiode,
                freieWaehlerErststimmenVorlaeufig,
                freieWaehlerErststimmenVorperiode,
                freieWaehlerZweitstimmenVorlaeufig,
                freieWaehlerZweitstimmenVorperiode,
                tierschutzparteiErststimmenVorlaeufig,
                tierschutzparteiErststimmenVorperiode,
                tierschutzparteiZweitstimmenVorlaeufig,
                tierschutzparteiZweitstimmenVorperiode,
                oedpErststimmenVorlaeufig,
                oedpErststimmenVorperiode,
                oedpZweitstimmenVorlaeufig,
                oedpZweitstimmenVorperiode,
                dieparteiErststimmenVorlaeufig,
                dieparteiErststimmenVorperiode,
                dieparteiZweitstimmenVorlaeufig,
                dieparteiZweitstimmenVorperiode,
                bayernparteiErststimmenVorlaeufig,
                bayernparteiErststimmenVorperiode,
                bayernparteiZweitstimmenVorlaeufig,
                bayernparteiZweitstimmenVorperiode,
                volksabstimmungErststimmenVorlaeufig,
                volksabstimmungErststimmenVorperiode,
                volksabstimmungZweitstimmenVorlaeufig,
                volksabstimmungZweitstimmenVorperiode,
                pdvErststimmenVorlaeufig,
                pdvErststimmenVorperiode,
                pdvZweitstimmenVorlaeufig,
                pdvZweitstimmenVorperiode,
                mlpdErststimmenVorlaeufig,
                mlpdErststimmenVorperiode,
                mlpdZweitstimmenVorlaeufig,
                mlpdZweitstimmenVorperiode,
                buesoErststimmenVorlaeufig,
                buesoErststimmenVorperiode,
                buesoZweitstimmenVorlaeufig,
                buesoZweitstimmenVorperiode,
                sgpErststimmenVorlaeufig,
                sgpErststimmenVorperiode,
                sgpZweitstimmenVorlaeufig,
                sgpZweitstimmenVorperiode,
                dierechteErststimmenVorlaeufig,
                dierechteErststimmenVorperiode,
                dierechteZweitstimmenVorlaeufig,
                dierechteZweitstimmenVorperiode,
                addErststimmenVorlaeufig,
                addErststimmenVorperiode,
                addZweitstimmenVorlaeufig,
                addZweitstimmenVorperiode,
                tierschutzallianzErststimmenVorlaeufig,
                tierschutzallianzErststimmenVorperiode,
                tierschutzallianzZweitstimmenVorlaeufig,
                tierschutzallianzZweitstimmenVorperiode,
                bergparteiErststimmenVorlaeufig,
                bergparteiErststimmenVorperiode,
                bergparteiZweitstimmenVorlaeufig,
                bergparteiZweitstimmenVorperiode,
                bgeErststimmenVorlaeufig,
                bgeErststimmenVorperiode,
                bgeZweitstimmenVorlaeufig,
                bgeZweitstimmenVorperiode,
                dibErststimmenVorlaeufig,
                dibErststimmenVorperiode,
                dibZweitstimmenVorlaeufig,
                dibZweitstimmenVorperiode,
                dkpErststimmenVorlaeufig,
                dkpErststimmenVorperiode,
                dkpZweitstimmenVorlaeufig,
                dkpZweitstimmenVorperiode,
                dmErststimmenVorlaeufig,
                dmErststimmenVorperiode,
                dmZweitstimmenVorlaeufig,
                dmZweitstimmenVorperiode,
                diegrauenErststimmenVorlaeufig,
                diegrauenErststimmenVorperiode,
                diegrauenZweitstimmenVorlaeufig,
                diegrauenZweitstimmenVorperiode,
                duErststimmenVorlaeufig,
                duErststimmenVorperiode,
                duZweitstimmenVorlaeufig,
                duZweitstimmenVorperiode,
                mgErststimmenVorlaeufig,
                mgErststimmenVorperiode,
                mgZweitstimmenVorlaeufig,
                mgZweitstimmenVorperiode,
                menschlicheweltErststimmenVorlaeufig,
                menschlicheweltErststimmenVorperiode,
                menschlicheweltZweitstimmenVorlaeufig,
                menschlicheweltZweitstimmenVorperiode,
                diehumanistenErststimmenVorlaeufig,
                diehumanistenErststimmenVorperiode,
                diehumanistenZweitstimmenVorlaeufig,
                diehumanistenZweitstimmenVorperiode,
                gesundheitsforschungErststimmenVorlaeufig,
                gesundheitsforschungErststimmenVorperiode,
                gesundheitsforschungZweitstimmenVorlaeufig,
                gesundheitsforschungZweitstimmenVorperiode,
                vparteiErststimmenVorlaeufig,
                vparteiErststimmenVorperiode,
                vparteiZweitstimmenVorlaeufig,
                vparteiZweitstimmenVorperiode,
                buendniscErststimmenVorlaeufig,
                buendniscErststimmenVorperiode,
                buendniscZweitstimmenVorlaeufig,
                buendniscZweitstimmenVorperiode,
                dieeinheitErststimmenVorlaeufig,
                dieeinheitErststimmenVorperiode,
                dieeinheitZweitstimmenVorlaeufig,
                dieeinheitZweitstimmenVorperiode,
                dieviolettenErststimmenVorlaeufig,
                dieviolettenErststimmenVorperiode,
                dieviolettenZweitstimmenVorlaeufig,
                dieviolettenZweitstimmenVorperiode,
                familieErststimmenVorlaeufig,
                familieErststimmenVorperiode,
                familieZweitstimmenVorlaeufig,
                familieZweitstimmenVorperiode,
                diefrauenErststimmenVorlaeufig,
                diefrauenErststimmenVorperiode,
                diefrauenZweitstimmenVorlaeufig,
                diefrauenZweitstimmenVorperiode,
                mieterparteiErststimmenVorlaeufig,
                mieterparteiErststimmenVorperiode,
                mieterparteiZweitstimmenVorlaeufig,
                mieterparteiZweitstimmenVorperiode,
                neueliberaleErststimmenVorlaeufig,
                neueliberaleErststimmenVorperiode,
                neueliberaleZweitstimmenVorlaeufig,
                neueliberaleZweitstimmenVorperiode,
                unabhaengigeErststimmenVorlaeufig,
                unabhaengigeErststimmenVorperiode,
                unabhaengigeZweitstimmenVorlaeufig,
                unabhaengigeZweitstimmenVorperiode,
                uebrigeErststimmenVorlaeufig,
                uebrigeErststimmenVorperiode,
                uebrigeZweitstimmenVorlaeufig,
                uebrigeZweitstimmenVorperiode,
        };

        o.setWahlkreisNummer(wahlkreisNummer);
        o.setWahlkreisName(wahlkreisName);
        o.setBundeslandNummer(bundeslandNummer);
        o.setWahlberechtigteErststimmenVorlaeufig(wahlberechtigteErststimmenVorlaeufig);
        o.setWahlberechtigteErststimmenVorperiode(wahlberechtigteErststimmenVorperiode);
        o.setWahlberechtigteZweitstimmenVorlaeufig(wahlberechtigteZweitstimmenVorlaeufig);
        o.setWahlberechtigteZweitstimmenVorperiode(wahlberechtigteZweitstimmenVorperiode);
        o.setWaehlerErststimmenVorlaeufig(waehlerErststimmenVorlaeufig);
        o.setWaehlerErststimmenVorperiode(waehlerErststimmenVorperiode);
        o.setWaehlerZweitstimmenVorlaeufig(waehlerZweitstimmenVorlaeufig);
        o.setWaehlerZweitstimmenVorperiode(waehlerZweitstimmenVorperiode);
        o.setUngueltigeErststimmenVorlaeufig(ungueltigeErststimmenVorlaeufig);
        o.setUngueltigeErststimmenVorperiode(ungueltigeErststimmenVorperiode);
        o.setUngueltigeZweitstimmenVorlaeufig(ungueltigeZweitstimmenVorlaeufig);
        o.setUngueltigeZweitstimmenVorperiode(ungueltigeZweitstimmenVorperiode);
        o.setGueltigeErststimmenVorlaeufig(gueltigeErststimmenVorlaeufig);
        o.setGueltigeErststimmenVorperiode(gueltigeErststimmenVorperiode);
        o.setGueltigeZweitstimmenVorlaeufig(gueltigeZweitstimmenVorlaeufig);
        o.setGueltigeZweitstimmenVorperiode(gueltigeZweitstimmenVorperiode);
        o.setCduErststimmenVorlaeufig(cduErststimmenVorlaeufig);
        o.setCduErststimmenVorperiode(cduErststimmenVorperiode);
        o.setCduZweitstimmenVorlaeufig(cduZweitstimmenVorlaeufig);
        o.setCduZweitstimmenVorperiode(cduZweitstimmenVorperiode);
        o.setSpdErststimmenVorlaeufig(spdErststimmenVorlaeufig);
        o.setSpdErststimmenVorperiode(spdErststimmenVorperiode);
        o.setSpdZweitstimmenVorlaeufig(spdZweitstimmenVorlaeufig);
        o.setSpdZweitstimmenVorperiode(spdZweitstimmenVorperiode);
        o.setDielinkeErststimmenVorlaeufig(dielinkeErststimmenVorlaeufig);
        o.setDielinkeErststimmenVorperiode(dielinkeErststimmenVorperiode);
        o.setDielinkeZweitstimmenVorlaeufig(dielinkeZweitstimmenVorlaeufig);
        o.setDielinkeZweitstimmenVorperiode(dielinkeZweitstimmenVorperiode);
        o.setDiegruenenErststimmenVorlaeufig(diegruenenErststimmenVorlaeufig);
        o.setDiegruenenErststimmenVorperiode(diegruenenErststimmenVorperiode);
        o.setDiegruenenZweitstimmenVorlaeufig(diegruenenZweitstimmenVorlaeufig);
        o.setDiegruenenZweitstimmenVorperiode(diegruenenZweitstimmenVorperiode);
        o.setCsuErststimmenVorlaeufig(csuErststimmenVorlaeufig);
        o.setCsuErststimmenVorperiode(csuErststimmenVorperiode);
        o.setCsuZweitstimmenVorlaeufig(csuZweitstimmenVorlaeufig);
        o.setCsuZweitstimmenVorperiode(csuZweitstimmenVorperiode);
        o.setFdpErststimmenVorlaeufig(fdpErststimmenVorlaeufig);
        o.setFdpErststimmenVorperiode(fdpErststimmenVorperiode);
        o.setFdpZweitstimmenVorlaeufig(fdpZweitstimmenVorlaeufig);
        o.setFdpZweitstimmenVorperiode(fdpZweitstimmenVorperiode);
        o.setAfdErststimmenVorlaeufig(afdErststimmenVorlaeufig);
        o.setAfdErststimmenVorperiode(afdErststimmenVorperiode);
        o.setAfdZweitstimmenVorlaeufig(afdZweitstimmenVorlaeufig);
        o.setAfdZweitstimmenVorperiode(afdZweitstimmenVorperiode);
        o.setPiratenparteiErststimmenVorlaeufig(piratenparteiErststimmenVorlaeufig);
        o.setPiratenparteiErststimmenVorperiode(piratenparteiErststimmenVorperiode);
        o.setPiratenparteiZweitstimmenVorlaeufig(piratenparteiZweitstimmenVorlaeufig);
        o.setPiratenparteiZweitstimmenVorperiode(piratenparteiZweitstimmenVorperiode);
        o.setNpdErststimmenVorlaeufig(npdErststimmenVorlaeufig);
        o.setNpdErststimmenVorperiode(npdErststimmenVorperiode);
        o.setNpdZweitstimmenVorlaeufig(npdZweitstimmenVorlaeufig);
        o.setNpdZweitstimmenVorperiode(npdZweitstimmenVorperiode);
        o.setFreieWaehlerErststimmenVorlaeufig(freieWaehlerErststimmenVorlaeufig);
        o.setFreieWaehlerErststimmenVorperiode(freieWaehlerErststimmenVorperiode);
        o.setFreieWaehlerZweitstimmenVorlaeufig(freieWaehlerZweitstimmenVorlaeufig);
        o.setFreieWaehlerZweitstimmenVorperiode(freieWaehlerZweitstimmenVorperiode);
        o.setTierschutzparteiErststimmenVorlaeufig(tierschutzparteiErststimmenVorlaeufig);
        o.setTierschutzparteiErststimmenVorperiode(tierschutzparteiErststimmenVorperiode);
        o.setTierschutzparteiZweitstimmenVorlaeufig(tierschutzparteiZweitstimmenVorlaeufig);
        o.setTierschutzparteiZweitstimmenVorperiode(tierschutzparteiZweitstimmenVorperiode);
        o.setOedpErststimmenVorlaeufig(oedpErststimmenVorlaeufig);
        o.setOedpErststimmenVorperiode(oedpErststimmenVorperiode);
        o.setOedpZweitstimmenVorlaeufig(oedpZweitstimmenVorlaeufig);
        o.setOedpZweitstimmenVorperiode(oedpZweitstimmenVorperiode);
        o.setDieparteiErststimmenVorlaeufig(dieparteiErststimmenVorlaeufig);
        o.setDieparteiErststimmenVorperiode(dieparteiErststimmenVorperiode);
        o.setDieparteiZweitstimmenVorlaeufig(dieparteiZweitstimmenVorlaeufig);
        o.setDieparteiZweitstimmenVorperiode(dieparteiZweitstimmenVorperiode);
        o.setBayernparteiErststimmenVorlaeufig(bayernparteiErststimmenVorlaeufig);
        o.setBayernparteiErststimmenVorperiode(bayernparteiErststimmenVorperiode);
        o.setBayernparteiZweitstimmenVorlaeufig(bayernparteiZweitstimmenVorlaeufig);
        o.setBayernparteiZweitstimmenVorperiode(bayernparteiZweitstimmenVorperiode);
        o.setVolksabstimmungErststimmenVorlaeufig(volksabstimmungErststimmenVorlaeufig);
        o.setVolksabstimmungErststimmenVorperiode(volksabstimmungErststimmenVorperiode);
        o.setVolksabstimmungZweitstimmenVorlaeufig(volksabstimmungZweitstimmenVorlaeufig);
        o.setVolksabstimmungZweitstimmenVorperiode(volksabstimmungZweitstimmenVorperiode);
        o.setPdvErststimmenVorlaeufig(pdvErststimmenVorlaeufig);
        o.setPdvErststimmenVorperiode(pdvErststimmenVorperiode);
        o.setPdvZweitstimmenVorlaeufig(pdvZweitstimmenVorlaeufig);
        o.setPdvZweitstimmenVorperiode(pdvZweitstimmenVorperiode);
        o.setMlpdErststimmenVorlaeufig(mlpdErststimmenVorlaeufig);
        o.setMlpdErststimmenVorperiode(mlpdErststimmenVorperiode);
        o.setMlpdZweitstimmenVorlaeufig(mlpdZweitstimmenVorlaeufig);
        o.setMlpdZweitstimmenVorperiode(mlpdZweitstimmenVorperiode);
        o.setBuesoErststimmenVorlaeufig(buesoErststimmenVorlaeufig);
        o.setBuesoErststimmenVorperiode(buesoErststimmenVorperiode);
        o.setBuesoZweitstimmenVorlaeufig(buesoZweitstimmenVorlaeufig);
        o.setBuesoZweitstimmenVorperiode(buesoZweitstimmenVorperiode);
        o.setSgpErststimmenVorlaeufig(sgpErststimmenVorlaeufig);
        o.setSgpErststimmenVorperiode(sgpErststimmenVorperiode);
        o.setSgpZweitstimmenVorlaeufig(sgpZweitstimmenVorlaeufig);
        o.setSgpZweitstimmenVorperiode(sgpZweitstimmenVorperiode);
        o.setDierechteErststimmenVorlaeufig(dierechteErststimmenVorlaeufig);
        o.setDierechteErststimmenVorperiode(dierechteErststimmenVorperiode);
        o.setDierechteZweitstimmenVorlaeufig(dierechteZweitstimmenVorlaeufig);
        o.setDierechteZweitstimmenVorperiode(dierechteZweitstimmenVorperiode);
        o.setAddErststimmenVorlaeufig(addErststimmenVorlaeufig);
        o.setAddErststimmenVorperiode(addErststimmenVorperiode);
        o.setAddZweitstimmenVorlaeufig(addZweitstimmenVorlaeufig);
        o.setAddZweitstimmenVorperiode(addZweitstimmenVorperiode);
        o.setTierschutzallianzErststimmenVorlaeufig(tierschutzallianzErststimmenVorlaeufig);
        o.setTierschutzallianzErststimmenVorperiode(tierschutzallianzErststimmenVorperiode);
        o.setTierschutzallianzZweitstimmenVorlaeufig(tierschutzallianzZweitstimmenVorlaeufig);
        o.setTierschutzallianzZweitstimmenVorperiode(tierschutzallianzZweitstimmenVorperiode);
        o.setBergparteiErststimmenVorlaeufig(bergparteiErststimmenVorlaeufig);
        o.setBergparteiErststimmenVorperiode(bergparteiErststimmenVorperiode);
        o.setBergparteiZweitstimmenVorlaeufig(bergparteiZweitstimmenVorlaeufig);
        o.setBergparteiZweitstimmenVorperiode(bergparteiZweitstimmenVorperiode);
        o.setBgeErststimmenVorlaeufig(bgeErststimmenVorlaeufig);
        o.setBgeErststimmenVorperiode(bgeErststimmenVorperiode);
        o.setBgeZweitstimmenVorlaeufig(bgeZweitstimmenVorlaeufig);
        o.setBgeZweitstimmenVorperiode(bgeZweitstimmenVorperiode);
        o.setDibErststimmenVorlaeufig(dibErststimmenVorlaeufig);
        o.setDibErststimmenVorperiode(dibErststimmenVorperiode);
        o.setDibZweitstimmenVorlaeufig(dibZweitstimmenVorlaeufig);
        o.setDibZweitstimmenVorperiode(dibZweitstimmenVorperiode);
        o.setDkpErststimmenVorlaeufig(dkpErststimmenVorlaeufig);
        o.setDkpErststimmenVorperiode(dkpErststimmenVorperiode);
        o.setDkpZweitstimmenVorlaeufig(dkpZweitstimmenVorlaeufig);
        o.setDkpZweitstimmenVorperiode(dkpZweitstimmenVorperiode);
        o.setDmErststimmenVorlaeufig(dmErststimmenVorlaeufig);
        o.setDmErststimmenVorperiode(dmErststimmenVorperiode);
        o.setDmZweitstimmenVorlaeufig(dmZweitstimmenVorlaeufig);
        o.setDmZweitstimmenVorperiode(dmZweitstimmenVorperiode);
        o.setDiegrauenErststimmenVorlaeufig(diegrauenErststimmenVorlaeufig);
        o.setDiegrauenErststimmenVorperiode(diegrauenErststimmenVorperiode);
        o.setDiegrauenZweitstimmenVorlaeufig(diegrauenZweitstimmenVorlaeufig);
        o.setDiegrauenZweitstimmenVorperiode(diegrauenZweitstimmenVorperiode);
        o.setDuErststimmenVorlaeufig(duErststimmenVorlaeufig);
        o.setDuErststimmenVorperiode(duErststimmenVorperiode);
        o.setDuZweitstimmenVorlaeufig(duZweitstimmenVorlaeufig);
        o.setDuZweitstimmenVorperiode(duZweitstimmenVorperiode);
        o.setMgErststimmenVorlaeufig(mgErststimmenVorlaeufig);
        o.setMgErststimmenVorperiode(mgErststimmenVorperiode);
        o.setMgZweitstimmenVorlaeufig(mgZweitstimmenVorlaeufig);
        o.setMgZweitstimmenVorperiode(mgZweitstimmenVorperiode);
        o.setMenschlicheweltErststimmenVorlaeufig(menschlicheweltErststimmenVorlaeufig);
        o.setMenschlicheweltErststimmenVorperiode(menschlicheweltErststimmenVorperiode);
        o.setMenschlicheweltZweitstimmenVorlaeufig(menschlicheweltZweitstimmenVorlaeufig);
        o.setMenschlicheweltZweitstimmenVorperiode(menschlicheweltZweitstimmenVorperiode);
        o.setDiehumanistenErststimmenVorlaeufig(diehumanistenErststimmenVorlaeufig);
        o.setDiehumanistenErststimmenVorperiode(diehumanistenErststimmenVorperiode);
        o.setDiehumanistenZweitstimmenVorlaeufig(diehumanistenZweitstimmenVorlaeufig);
        o.setDiehumanistenZweitstimmenVorperiode(diehumanistenZweitstimmenVorperiode);
        o.setGesundheitsforschungErststimmenVorlaeufig(gesundheitsforschungErststimmenVorlaeufig);
        o.setGesundheitsforschungErststimmenVorperiode(gesundheitsforschungErststimmenVorperiode);
        o.setGesundheitsforschungZweitstimmenVorlaeufig(gesundheitsforschungZweitstimmenVorlaeufig);
        o.setGesundheitsforschungZweitstimmenVorperiode(gesundheitsforschungZweitstimmenVorperiode);
        o.setVparteiErststimmenVorlaeufig(vparteiErststimmenVorlaeufig);
        o.setVparteiErststimmenVorperiode(vparteiErststimmenVorperiode);
        o.setVparteiZweitstimmenVorlaeufig(vparteiZweitstimmenVorlaeufig);
        o.setVparteiZweitstimmenVorperiode(vparteiZweitstimmenVorperiode);
        o.setBuendniscErststimmenVorlaeufig(buendniscErststimmenVorlaeufig);
        o.setBuendniscErststimmenVorperiode(buendniscErststimmenVorperiode);
        o.setBuendniscZweitstimmenVorlaeufig(buendniscZweitstimmenVorlaeufig);
        o.setBuendniscZweitstimmenVorperiode(buendniscZweitstimmenVorperiode);
        o.setDieeinheitErststimmenVorlaeufig(dieeinheitErststimmenVorlaeufig);
        o.setDieeinheitErststimmenVorperiode(dieeinheitErststimmenVorperiode);
        o.setDieeinheitZweitstimmenVorlaeufig(dieeinheitZweitstimmenVorlaeufig);
        o.setDieeinheitZweitstimmenVorperiode(dieeinheitZweitstimmenVorperiode);
        o.setDieviolettenErststimmenVorlaeufig(dieviolettenErststimmenVorlaeufig);
        o.setDieviolettenErststimmenVorperiode(dieviolettenErststimmenVorperiode);
        o.setDieviolettenZweitstimmenVorlaeufig(dieviolettenZweitstimmenVorlaeufig);
        o.setDieviolettenZweitstimmenVorperiode(dieviolettenZweitstimmenVorperiode);
        o.setFamilieErststimmenVorlaeufig(familieErststimmenVorlaeufig);
        o.setFamilieErststimmenVorperiode(familieErststimmenVorperiode);
        o.setFamilieZweitstimmenVorlaeufig(familieZweitstimmenVorlaeufig);
        o.setFamilieZweitstimmenVorperiode(familieZweitstimmenVorperiode);
        o.setDiefrauenErststimmenVorlaeufig(diefrauenErststimmenVorlaeufig);
        o.setDiefrauenErststimmenVorperiode(diefrauenErststimmenVorperiode);
        o.setDiefrauenZweitstimmenVorlaeufig(diefrauenZweitstimmenVorlaeufig);
        o.setDiefrauenZweitstimmenVorperiode(diefrauenZweitstimmenVorperiode);
        o.setMieterparteiErststimmenVorlaeufig(mieterparteiErststimmenVorlaeufig);
        o.setMieterparteiErststimmenVorperiode(mieterparteiErststimmenVorperiode);
        o.setMieterparteiZweitstimmenVorlaeufig(mieterparteiZweitstimmenVorlaeufig);
        o.setMieterparteiZweitstimmenVorperiode(mieterparteiZweitstimmenVorperiode);
        o.setNeueliberaleErststimmenVorlaeufig(neueliberaleErststimmenVorlaeufig);
        o.setNeueliberaleErststimmenVorperiode(neueliberaleErststimmenVorperiode);
        o.setNeueliberaleZweitstimmenVorlaeufig(neueliberaleZweitstimmenVorlaeufig);
        o.setNeueliberaleZweitstimmenVorperiode(neueliberaleZweitstimmenVorperiode);
        o.setUnabhaengigeErststimmenVorlaeufig(unabhaengigeErststimmenVorlaeufig);
        o.setUnabhaengigeErststimmenVorperiode(unabhaengigeErststimmenVorperiode);
        o.setUnabhaengigeZweitstimmenVorlaeufig(unabhaengigeZweitstimmenVorlaeufig);
        o.setUnabhaengigeZweitstimmenVorperiode(unabhaengigeZweitstimmenVorperiode);
        o.setUebrigeErststimmenVorlaeufig(uebrigeErststimmenVorlaeufig);
        o.setUebrigeErststimmenVorperiode(uebrigeErststimmenVorperiode);
        o.setUebrigeZweitstimmenVorlaeufig(uebrigeZweitstimmenVorlaeufig);
        o.setUebrigeZweitstimmenVorperiode(uebrigeZweitstimmenVorperiode);

        List<String> outputLinesSoll = new ArrayList<>();

        List<String> outputLinesIst = o.logFieldsList();
        log.info("outputLinesIst.size()  "+outputLinesIst.size());

        String spaltenName[] = o.getSpaltenName();
        log.info("spaltenName.length from o.getSpaltenName() "+spaltenName.length);
        for(int k=0; k<spaltenName.length; k++){
            String line = "["+k+"] "+spaltenName[k]+" : "+cells[k]+"   (" + fieldnamesSettingNames[k] + "  "+ fieldnamesSetting[k].getClass().getName() + ")";
            log.info("line "+line);
            outputLinesSoll.add(line);
        }
        log.info("outputLinesSoll.size()  "+outputLinesSoll.size());
        StringBuffer sb = new StringBuffer();
        sb.append("\n\ncsvDataRow\n\n");
        sb.append(csvDataRow);
        sb.append("\n\n");
        for(int k=0; k<outputLinesSoll.size();k++){
            String comparedOutputLine = "("+k+")\n---------------------------------\n+"+outputLinesSoll.get(k) + "\n <=> \n*"+ outputLinesIst.get(k);
            sb.append(comparedOutputLine);
            log.info("comparedOutputLine "+comparedOutputLine);
            sb.append("\n---------------------------------\n\n");
        }
        log.info( sb.toString());
        return o;
    }

}
