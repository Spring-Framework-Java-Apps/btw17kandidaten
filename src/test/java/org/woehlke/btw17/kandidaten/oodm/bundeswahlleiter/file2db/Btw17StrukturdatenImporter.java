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
import org.woehlke.btw17.kandidaten.oodm.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17StrukturdatenService;


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
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Btw17StrukturdatenImporter {

    private static final Logger log = LoggerFactory.getLogger(Btw17StrukturdatenImporter.class);

    private final String srcFileNameStrukturdatenWahlkreise = "etc/ergebnisse/importing/btw17_strukturdaten_wahlkreise.csv";

    private final String srcFileNameStrukturdatenBundeslaender = "etc/ergebnisse/importing/btw17_strukturdaten_bundeslaender.csv";

    private final String srcFileNameStrukturdatenDeutschland = "etc/ergebnisse/importing/btw17_strukturdaten_deutschland.csv";


    @Autowired
    private Btw17StrukturdatenService btw17StrukturdatenService;

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
        assertThat(btw17StrukturdatenService).isNotNull();
        assertThat(kandidatenProperties).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test100file2db() throws Exception {
        log.info("test100file2db");
        btw17StrukturdatenService.deleteAll();
        Assert.assertTrue(true);
        File input = new File(srcFileNameStrukturdatenWahlkreise);
        BufferedReader br = new BufferedReader(new FileReader(input));
        log.info("=============================================================");
        while (br.ready()){
            log.info("*************************************************************");
            String csvDataRow = br.readLine();
            log.info(csvDataRow);
            Btw17Strukturdaten o = csv2object(csvDataRow);
            o=btw17StrukturdatenService.create(o);
            log.info(o.getUniqueId());
            log.info("*************************************************************");
        }
        log.info("=============================================================");
        br.close();
        Assert.assertTrue(true);
    }


    private Btw17Strukturdaten csv2object(String csvDataRow) throws Exception {
        Btw17Strukturdaten o = new Btw17Strukturdaten();

        String work = csvDataRow;
        while(work.contains(";.;")){
            work = work.replaceAll(";.;",";0.0;");
        }
        while(work.contains(";;")){
            work = work.replaceAll(";;",";@;");
        }
        work = work.replaceAll("^;","@;");
        work = work.replaceAll(";$",";@");
        log.info(work);
        String cells[] = work.split(";");



        log.info(Integer.toString(cells.length));

        String bundeslandName=cells[0];
        Long wahlkreisNummer = -1L;
        if(cells[1].matches("^\\d*$")) {
            wahlkreisNummer = Long.parseLong(cells[1]);
        }
        String wahlkreisName=cells[2];
        Long anzahlGemeinden = -1L;
        if(cells[3].matches("^\\d*$")) {
            anzahlGemeinden = Long.parseLong(cells[3]);
        }
        BigDecimal flaeche = BigDecimal.valueOf(Double.parseDouble(cells[4].replace(",",".")));
        BigDecimal bevoelkerungInsgesamt = BigDecimal.valueOf(Double.parseDouble(cells[5].replace(",",".")));
        BigDecimal bevoelkerungDeutsche = BigDecimal.valueOf(Double.parseDouble(cells[6].replace(",",".")));
        BigDecimal bevoelkerungAuslaender = BigDecimal.valueOf(Double.parseDouble(cells[7].replace(",",".")));
        BigDecimal bevoelkerungsDichte = BigDecimal.valueOf(Double.parseDouble(cells[8].replace(",",".")));
        BigDecimal bevoelkerungsGeburtensaldo = BigDecimal.valueOf(Double.parseDouble(cells[9].replace(",",".")));
        BigDecimal bevoelkerungWanderungssaldo = BigDecimal.valueOf(Double.parseDouble(cells[10].replace(",",".")));
        BigDecimal alterUnter18 = BigDecimal.valueOf(Double.parseDouble(cells[11].replace(",",".")));
        BigDecimal alter18bis24 = BigDecimal.valueOf(Double.parseDouble(cells[12].replace(",",".")));
        BigDecimal alter25bis34 = BigDecimal.valueOf(Double.parseDouble(cells[13].replace(",",".")));
        BigDecimal alter35bis59 = BigDecimal.valueOf(Double.parseDouble(cells[14].replace(",",".")));
        BigDecimal alter60bis74 = BigDecimal.valueOf(Double.parseDouble(cells[15].replace(",",".")));
        BigDecimal alter75plus = BigDecimal.valueOf(Double.parseDouble(cells[16].replace(",",".")));
        BigDecimal migrationshintergrundOhne = BigDecimal.valueOf(Double.parseDouble(cells[17].replace(",",".")));
        BigDecimal migrationshintergrundMit = BigDecimal.valueOf(Double.parseDouble(cells[18].replace(",",".")));
        BigDecimal religionKatholischeKirche = BigDecimal.valueOf(Double.parseDouble(cells[19].replace(",",".")));
        BigDecimal religionEvangelischeKirche = BigDecimal.valueOf(Double.parseDouble(cells[20].replace(",",".")));
        BigDecimal religionSonstige = BigDecimal.valueOf(Double.parseDouble(cells[21].replace(",",".")));
        BigDecimal wohnungenEigentuemerquote = BigDecimal.valueOf(Double.parseDouble(cells[22].replace(",",".")));
        BigDecimal wohnungenFertiggestellte = BigDecimal.valueOf(Double.parseDouble(cells[23].replace(",",".")));
        BigDecimal wohnungenBestand = BigDecimal.valueOf(Double.parseDouble(cells[24].replace(",",".")));
        BigDecimal einwohnerEinkommen = BigDecimal.valueOf(Double.parseDouble(cells[25].replace(",",".")));
        Long einwohnerBruttoinlandsprodukt = Long.parseLong(cells[26]);
        BigDecimal einwohnerKraftfahrzeugbestand = BigDecimal.valueOf(Double.parseDouble(cells[27].replace(",",".")));
        BigDecimal absolventenBeruflicheSchulen = BigDecimal.valueOf(Double.parseDouble(cells[28].replace(",",".")));
        BigDecimal absolventenAllgemeinbildendeSchulenInsgesamt = BigDecimal.valueOf(Double.parseDouble(cells[29].replace(",",".")));
        BigDecimal absolventenHauptschulabschlussOhne = BigDecimal.valueOf(Double.parseDouble(cells[30].replace(",",".")));
        BigDecimal absolventenHauptschulabschlussMit = BigDecimal.valueOf(Double.parseDouble(cells[31].replace(",",".")));
        BigDecimal absolventenRealschule = BigDecimal.valueOf(Double.parseDouble(cells[32].replace(",",".")));
        BigDecimal absolventenAbitur = BigDecimal.valueOf(Double.parseDouble(cells[33].replace(",",".")));
        BigDecimal kitasBetreuteKinder = BigDecimal.valueOf(Double.parseDouble(cells[34].replace(",",".")));
        BigDecimal unternehmenInsgesamt = BigDecimal.valueOf(Double.parseDouble(cells[35].replace(",",".")));
        BigDecimal unternehmenHandwerk = BigDecimal.valueOf(Double.parseDouble(cells[36].replace(",",".")));
        BigDecimal sozialversicherungBeschaeftigteInsgesamt = BigDecimal.valueOf(Double.parseDouble(cells[37].replace(",",".")));
        BigDecimal sozialversicherungBeschaeftigteLandwirtschaft = BigDecimal.valueOf(Double.parseDouble(cells[38].replace(",",".")));
        BigDecimal sozialversicherungBeschaeftigteProduzierendesGewerbe = BigDecimal.valueOf(Double.parseDouble(cells[39].replace(",",".")));
        BigDecimal sozialversicherungBeschaeftigteHandel = BigDecimal.valueOf(Double.parseDouble(cells[40].replace(",",".")));
        BigDecimal sozialversicherungBeschaeftigteDienstleister = BigDecimal.valueOf(Double.parseDouble(cells[41].replace(",",".")));
        BigDecimal sozialversicherungBeschaeftigteSonstige = BigDecimal.valueOf(Double.parseDouble(cells[42].replace(",",".")));
        BigDecimal sgb2insgesamt = BigDecimal.valueOf(Double.parseDouble(cells[43].replace(",",".")));
        BigDecimal sgb2erwerbsunfaehige = BigDecimal.valueOf(Double.parseDouble(cells[44].replace(",",".")));
        BigDecimal sgb2auslaender = BigDecimal.valueOf(Double.parseDouble(cells[45].replace(",",".")));
        BigDecimal arbeitslosenquoteInsgesamt = BigDecimal.valueOf(Double.parseDouble(cells[46].replace(",",".")));
        BigDecimal arbeitslosenquoteMaenner = BigDecimal.valueOf(Double.parseDouble(cells[47].replace(",",".")));
        BigDecimal arbeitslosenquoteFrauen = BigDecimal.valueOf(Double.parseDouble(cells[48].replace(",",".")));
        BigDecimal arbeitslosenquote12bis20 = BigDecimal.valueOf(Double.parseDouble(cells[49].replace(",",".")));
        BigDecimal arbeitslosenquote55bis65 = BigDecimal.valueOf(Double.parseDouble(cells[50].replace(",",".")));
        String fussnoten = cells[51];

        String fieldnamesSettingNames[] = {
                "bundeslandName",
                "wahlkreisNummer",
                "wahlkreisName",
                "anzahlGemeinden",
                "flaeche",
                "bevoelkerungInsgesamt",
                "bevoelkerungDeutsche",
                "bevoelkerungAuslaender",
                "bevoelkerungsDichte",
                "bevoelkerungsGeburtensaldo",
                "bevoelkerungWanderungssaldo",
                "alterUnter18",
                "alter18bis24",
                "alter25bis34",
                "alter35bis59",
                "alter60bis74",
                "alter75plus",
                "migrationshintergrundOhne",
                "migrationshintergrundMit",
                "religionKatholischeKirche",
                "religionEvangelischeKirche",
                "religionSonstige",
                "wohnungenEigentuemerquote",
                "wohnungenFertiggestellte",
                "wohnungenBestand",
                "einwohnerEinkommen",
                "einwohnerBruttoinlandsprodukt",
                "einwohnerKraftfahrzeugbestand",
                "absolventenBeruflicheSchulen",
                "absolventenAllgemeinbildendeSchulenInsgesamt",
                "absolventenHauptschulabschlussOhne",
                "absolventenHauptschulabschlussMit",
                "absolventenRealschule",
                "absolventenAbitur",
                "kitasBetreuteKinder",
                "unternehmenInsgesamt",
                "unternehmenHandwerk",
                "sozialversicherungBeschaeftigteInsgesamt",
                "sozialversicherungBeschaeftigteLandwirtschaft",
                "sozialversicherungBeschaeftigteProduzierendesGewerbe",
                "sozialversicherungBeschaeftigteHandel",
                "sozialversicherungBeschaeftigteDienstleister",
                "sozialversicherungBeschaeftigteSonstige",
                "sgb2insgesamt",
                "sgb2erwerbsunfaehige",
                "sgb2auslaender",
                "arbeitslosenquoteInsgesamt",
                "arbeitslosenquoteMaenner",
                "arbeitslosenquoteFrauen",
                "arbeitslosenquote12bis20",
                "arbeitslosenquote55bis65",
                "fussnoten"
        };

        Object fieldnamesSetting[] = {
                bundeslandName,
                wahlkreisNummer,
                wahlkreisName,
                anzahlGemeinden,
                flaeche,
                bevoelkerungInsgesamt,
                bevoelkerungDeutsche,
                bevoelkerungAuslaender,
                bevoelkerungsDichte,
                bevoelkerungsGeburtensaldo,
                bevoelkerungWanderungssaldo,
                alterUnter18,
                alter18bis24,
                alter25bis34,
                alter35bis59,
                alter60bis74,
                alter75plus,
                migrationshintergrundOhne,
                migrationshintergrundMit,
                religionKatholischeKirche,
                religionEvangelischeKirche,
                religionSonstige,
                wohnungenEigentuemerquote,
                wohnungenFertiggestellte,
                wohnungenBestand,
                einwohnerEinkommen,
                einwohnerBruttoinlandsprodukt,
                einwohnerKraftfahrzeugbestand,
                absolventenBeruflicheSchulen,
                absolventenAllgemeinbildendeSchulenInsgesamt,
                absolventenHauptschulabschlussOhne,
                absolventenHauptschulabschlussMit,
                absolventenRealschule,
                absolventenAbitur,
                kitasBetreuteKinder,
                unternehmenInsgesamt,
                unternehmenHandwerk,
                sozialversicherungBeschaeftigteInsgesamt,
                sozialversicherungBeschaeftigteLandwirtschaft,
                sozialversicherungBeschaeftigteProduzierendesGewerbe,
                sozialversicherungBeschaeftigteHandel,
                sozialversicherungBeschaeftigteDienstleister,
                sozialversicherungBeschaeftigteSonstige,
                sgb2insgesamt,
                sgb2erwerbsunfaehige,
                sgb2auslaender,
                arbeitslosenquoteInsgesamt,
                arbeitslosenquoteMaenner,
                arbeitslosenquoteFrauen,
                arbeitslosenquote12bis20,
                arbeitslosenquote55bis65,
                fussnoten
        };

        o.setAbsolventenAbitur(absolventenAbitur);
        o.setAbsolventenAllgemeinbildendeSchulenInsgesamt(absolventenAllgemeinbildendeSchulenInsgesamt);
        o.setAbsolventenBeruflicheSchulen(absolventenBeruflicheSchulen);
        o.setAbsolventenHauptschulabschlussMit(absolventenHauptschulabschlussMit);
        o.setAbsolventenHauptschulabschlussOhne(absolventenHauptschulabschlussOhne);
        o.setAbsolventenRealschule(absolventenRealschule);
        o.setAlter18bis24(alter18bis24);
        o.setAlter25bis34(alter25bis34);
        o.setAlter35bis59(alter35bis59);
        o.setAlter60bis74(alter60bis74);
        o.setAlter75plus(alter75plus);
        o.setAlterUnter18(alterUnter18);
        o.setAnzahlGemeinden(anzahlGemeinden);
        o.setArbeitslosenquote12bis20(arbeitslosenquote12bis20);
        o.setArbeitslosenquote55bis65(arbeitslosenquote55bis65);
        o.setArbeitslosenquoteFrauen(arbeitslosenquoteFrauen);
        o.setArbeitslosenquoteInsgesamt(arbeitslosenquoteInsgesamt);
        o.setArbeitslosenquoteMaenner(arbeitslosenquoteMaenner);
        o.setBevoelkerungAuslaender(bevoelkerungAuslaender);
        o.setBevoelkerungInsgesamt(bevoelkerungInsgesamt);
        o.setBevoelkerungDeutsche(bevoelkerungDeutsche);
        o.setBevoelkerungWanderungssaldo(bevoelkerungWanderungssaldo);
        o.setBevoelkerungsDichte(bevoelkerungsDichte);
        o.setBevoelkerungsGeburtensaldo(bevoelkerungsGeburtensaldo);
        o.setBundeslandName(bundeslandName);
        o.setEinwohnerBruttoinlandsprodukt(einwohnerBruttoinlandsprodukt);
        o.setEinwohnerEinkommen(einwohnerEinkommen);
        o.setEinwohnerKraftfahrzeugbestand(einwohnerKraftfahrzeugbestand);
        o.setFlaeche(flaeche);
        o.setFussnoten(fussnoten);
        o.setKitasBetreuteKinder(kitasBetreuteKinder);
        o.setMigrationshintergrundMit(migrationshintergrundMit);
        o.setMigrationshintergrundOhne(migrationshintergrundOhne);
        o.setReligionEvangelischeKirche(religionEvangelischeKirche);
        o.setReligionKatholischeKirche(religionKatholischeKirche);
        o.setReligionSonstige(religionSonstige);
        o.setSgb2auslaender(sgb2auslaender);
        o.setSgb2erwerbsunfaehige(sgb2erwerbsunfaehige);
        o.setSgb2insgesamt(sgb2insgesamt);
        o.setSozialversicherungBeschaeftigteDienstleister(sozialversicherungBeschaeftigteDienstleister);
        o.setSozialversicherungBeschaeftigteHandel(sozialversicherungBeschaeftigteHandel);
        o.setSozialversicherungBeschaeftigteInsgesamt(sozialversicherungBeschaeftigteInsgesamt);
        o.setSozialversicherungBeschaeftigteLandwirtschaft(sozialversicherungBeschaeftigteLandwirtschaft);
        o.setSozialversicherungBeschaeftigteProduzierendesGewerbe(sozialversicherungBeschaeftigteProduzierendesGewerbe);
        o.setSozialversicherungBeschaeftigteSonstige(sozialversicherungBeschaeftigteSonstige);
        o.setUnternehmenHandwerk(unternehmenHandwerk);
        o.setUnternehmenInsgesamt(unternehmenInsgesamt);
        o.setWahlkreisName(wahlkreisName);
        o.setWahlkreisNummer(wahlkreisNummer);
        o.setWohnungenBestand(wohnungenBestand);
        o.setWohnungenEigentuemerquote(wohnungenEigentuemerquote);
        o.setWohnungenFertiggestellte(wohnungenFertiggestellte);

        List<String> outputLinesSoll = new ArrayList<>();
        String spaltenName[] = o.getSpaltenName();

        for(int i=0; i<spaltenName.length; i++){
            outputLinesSoll.add("["+i+"] "+spaltenName[i]+" : "+cells[i]+"   (" + fieldnamesSettingNames[i] + "  "+ fieldnamesSetting[i].getClass().getName() + ")");
        }

        List<String> outputLinesIst = o.logFieldsList();

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<outputLinesSoll.size();i++){
            String comparedOutputLine = "("+i+")\n---------------------------------\n+"+outputLinesSoll.get(i) + "\n <=> \n*"+ outputLinesIst.get(i);
            sb.append(comparedOutputLine);
            sb.append("\n---------------------------------\n\n");
        }
        log.info( sb.toString());
        return o;
    }

}
