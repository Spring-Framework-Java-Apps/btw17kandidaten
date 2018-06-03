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
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Mdb;
import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.db.model.bundestag.xml.*;
import org.woehlke.btw17.kandidaten.oodm.db.service.Btw17MdbService;
import org.woehlke.btw17.kandidaten.oodm.db.service.Btw17WahlperiodeService;
import org.woehlke.btw17.kandidaten.support.oodm.service.JdbcService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
public class Btw17MdbStammdatenImporter {


    private static final Logger log = LoggerFactory.getLogger(Btw17MdbStammdatenImporter.class);

    private final String dtdFile = "etc/etc/mdb-stammdaten-data/MDB_STAMMDATEN.DTD";

    private final String xmlFile = "etc/mdb-stammdaten-data/MDB_STAMMDATEN.xml";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @Autowired
    private Btw17MdbService btw17MdbService;

    @Autowired
    private Btw17WahlperiodeService btw17WahlperiodeService;

    @Autowired
    private JdbcService jdbcService;

    @WithMockUser
    @Commit
    @Test
    public void test000controllerIsPresentTest(){
        log.info("test000controllerIsPresentTest");
        assertThat(mockMvc).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("test000serviceIsPresentTest");
        assertThat(kandidatenProperties).isNotNull();
    }

    @WithMockUser
    @Commit
    @Test
    public void test100file2db() throws Exception {
        log.info("test100file2db");
        btw17WahlperiodeService.deleteAll();
        btw17MdbService.deleteAll();
        String sql ="ALTER SEQUENCE hibernate_sequence RESTART WITH "+1;
        jdbcService.executeSqlStatemen(sql);
        Assert.assertTrue(true);
        try {
            File file = new File(xmlFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(DOCUMENT.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DOCUMENT document = (DOCUMENT) jaxbUnmarshaller.unmarshal(file);
            for(MDB mdb:document.getMDB()){
                Btw17Mdb o = new Btw17Mdb();
                o.setXmlId(mdb.getID());
                NAMEN namen = mdb.getNAMEN();
                for(NAME name:namen.getNAME()){
                    o.setNachname(name.getNACHNAME());
                    o.setVorname(name.getVORNAME());
                    o.setOrtszusatz(name.getORTSZUSATZ());
                    o.setAdel(name.getADEL());
                    o.setPraefix(name.getPRAEFIX());
                    o.setAnredetitel(name.getANREDETITEL());
                    o.setAkadtitel(name.getAKADTITEL());
                    o.setHistorievon(name.getHISTORIEVON());
                    o.setHistoriebis(name.getHISTORIEBIS());
                }
                BIOGRAFISCHEANGABEN biografischeangaben = mdb.getBIOGRAFISCHEANGABEN();
                o.setGeburtsdatum(biografischeangaben.getGEBURTSDATUM());
                o.setGeburtsort(biografischeangaben.getGEBURTSORT());
                o.setGeburtsland(biografischeangaben.getGEBURTSLAND());
                o.setSterbedatum(biografischeangaben.getSTERBEDATUM());
                o.setGeschlecht(biografischeangaben.getGESCHLECHT());
                o.setFamilienstand(biografischeangaben.getFAMILIENSTAND());
                o.setReligion(biografischeangaben.getRELIGION());
                o.setBeruf(biografischeangaben.getBERUF());
                o.setParteikurz(biografischeangaben.getPARTEIKURZ());
                o.setVitakurz(biografischeangaben.getVITAKURZ().replaceAll("\n","<br/>"));
                o.setVeroeffentlichungspflichtiges(biografischeangaben.getVEROEFFENTLICHUNGSPFLICHTIGES().replaceAll("\n","<br/>"));
                Set<Btw17Wahlperiode> wahlperioden = new LinkedHashSet<>();
                for(WAHLPERIODE wahlperiode :mdb.getWAHLPERIODEN().getWAHLPERIODE()){
                    Btw17Wahlperiode p = btw17WahlperiodeService.findbyWahlperiodeNrAndWkrnummer(wahlperiode.getWP(),wahlperiode.getWKRNUMMER());
                    if(p == null){
                        p = new Btw17Wahlperiode();
                        p.setWp(wahlperiode.getWP());
                        p.setMdbwpvon(wahlperiode.getMDBWPVON());
                        p.setMdbwpbis(wahlperiode.getMDBWPBIS());
                        p.setWkrnummer(wahlperiode.getWKRNUMMER());
                        p.setWkrname(wahlperiode.getWKRNAME());
                        p.setWkrland(wahlperiode.getWKRLAND());
                        p.setListe(wahlperiode.getLISTE());
                        p.setMandatsart(wahlperiode.getMANDATSART());
                        for(INSTITUTION institution:wahlperiode.getINSTITUTIONEN().getINSTITUTION()){
                            p.setInsartlang(institution.getINSARTLANG());
                            p.setInslang(institution.getINSLANG());
                            p.setMdbinsvon(institution.getMDBINSVON());
                            p.setMdbinsbis(institution.getMDBINSBIS());
                            p.setFktlang(institution.getFKTLANG());
                            p.setFktinsvon(institution.getFKTINSVON());
                            p.setFktinsbis(institution.getFKTINSBIS());
                        }
                        btw17WahlperiodeService.create(p);
                    }
                    wahlperioden.add(p);
                    log.info(p.toString());
                }
                o.setWahlperioden(wahlperioden);
                log.info(o.toString());
                log.info("----------------------------------------------");
                btw17MdbService.create(o);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(true);
    }
}
