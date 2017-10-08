package org.woehlke.btw17.kandidaten;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.enrich.BundeslandEnricher;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.enrich.WahlkreisEnricher;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.file2db.Btw17ErgebnisImporter;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.file2db.Btw17StrukturdatenImporter;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.file2db.Btw17WahlbewerberImporter;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.file2db.Btw17WahlkreisImporter;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17KandidatFlatServiceTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17StrukturdatenServiceTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17WahlbewerberServiceTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17WahlkreisServiceTest;

@Suite.SuiteClasses({

    Btw17ErgebnisImporter.class,
    BundeslandEnricher.class

    /*
    Btw17KandidatFlatServiceTest.class,
    Btw17WahlkreisServiceTest.class,
    Btw17StrukturdatenServiceTest.class,
    Btw17WahlbewerberServiceTest.class,

    Btw17ErgebnisImporter.class,
    Btw17StrukturdatenImporter.class,
    Btw17WahlbewerberImporter.class,
    Btw17WahlkreisImporter.class
    */
})
@RunWith(Suite.class)
public class Btw17WahlleiterDatenimport {
}
