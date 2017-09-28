package org.woehlke.btw17.importer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.importer.dimensions.*;

@Suite.SuiteClasses({
    BerufImporter.class,
    BerufsgruppeImporter.class,
    BundeslandImporter.class,
    GeburtsortImporter.class,
    KandidatenImporter.class,
    ListeParteiImporter.class,
    ParteiImporter.class,
    WahlkreisImporter.class,
    WohnortImporter.class,
})
@RunWith(Suite.class)
public class ImporterDimensionsSuite {
}
