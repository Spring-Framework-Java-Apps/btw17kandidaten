package org.woehlke.btw17.kandidaten.oodm.bundestag.file2db;


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
import org.woehlke.btw17.kandidaten.oodm.bundestag.model.Mdb;
import org.woehlke.btw17.kandidaten.oodm.bundestag.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.bundestag.service.MdbService;
import org.woehlke.btw17.kandidaten.oodm.bundestag.service.WahlperiodeService;
import org.woehlke.btw17.kandidaten.oodm.bundestag.xml.*;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.file2db.Btw17ErgebnisImporter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
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
public class MdbStammdatenImporter {


    private static final Logger log = LoggerFactory.getLogger(MdbStammdatenImporter.class);

    private final String dtdFile = "etc/etc/mdb-stammdaten-data/MDB_STAMMDATEN.DTD";

    private final String xmlFile = "etc/mdb-stammdaten-data/MDB_STAMMDATEN.xml";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KandidatenProperties kandidatenProperties;

    @Autowired
    private MdbService mdbService;

    @Autowired
    private WahlperiodeService wahlperiodeService;

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
        mdbService.deleteAll();
        Assert.assertTrue(true);
        try {
            File file = new File(xmlFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(DOCUMENT.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DOCUMENT document = (DOCUMENT) jaxbUnmarshaller.unmarshal(file);
            for(MDB mdb:document.getMDB()){
                Mdb o = new Mdb();
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
                List<Wahlperiode> wahlperioden = new ArrayList();
                for(WAHLPERIODE wahlperiode :mdb.getWAHLPERIODEN().getWAHLPERIODE()){
                    Wahlperiode p = new Wahlperiode();
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
                    wahlperiodeService.create(p);
                    wahlperioden.add(p);
                    log.info(p.toString());
                }
                o.setWahlperioden(wahlperioden);
                log.info(o.toString());
                log.info("----------------------------------------------");
                mdbService.create(o);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(true);
    }
}
