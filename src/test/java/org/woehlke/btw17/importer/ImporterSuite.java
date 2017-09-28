package org.woehlke.btw17.importer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
    KandidatenNormalizedTableBuilder.class,
    KandidatenFotoUrlUdpate.class,
    UpdatePartei.class,
    UpdateSearchEngines.class
})
@RunWith(Suite.class)
public class ImporterSuite {
}
