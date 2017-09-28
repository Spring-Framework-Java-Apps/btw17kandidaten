package org.woehlke.btw17;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.importer.ImporterDimensionsSuite;
import org.woehlke.btw17.importer.ImporterSuite;
import org.woehlke.btw17.kandidaten.PrivateControllerSuite;
import org.woehlke.btw17.kandidaten.PublicControllerSuite;
import org.woehlke.btw17.kandidaten.OodmServiceSuite;

@Suite.SuiteClasses({
        PublicControllerSuite.class,
        PrivateControllerSuite.class,
        OodmServiceSuite.class,
        ImporterSuite.class,
        ImporterDimensionsSuite.class
})
@RunWith(Suite.class)
public class TopLevelSuite {
}
