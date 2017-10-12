package org.woehlke.btw17.kandidaten;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.oodm.importer.enrich.*;

@Suite.SuiteClasses({

        BerufEnricher.class,
        //BundeslandEnricher.class,
        //GeburtsortEnricher.class,
        //ParteiEnricher.class,
        //WahlkreisEnricher.class,
        //WahlperiodeEnricher.class,
        //WohnortEnricher.class,
        //KandidatEnricher.class

})
@RunWith(Suite.class)
public class Btw17WahlleiterDatenimport {
}
