package org.woehlke.btw17.kandidaten;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17KandidatFlatServiceTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17StrukturdatenServiceTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17WahlbewerberServiceTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17WahlkreisServiceTest;

@Suite.SuiteClasses({
    Btw17KandidatFlatServiceTest.class,
    Btw17WahlkreisServiceTest.class,
    Btw17StrukturdatenServiceTest.class,
    Btw17WahlbewerberServiceTest.class
})
@RunWith(Suite.class)
public class Btw17WahlleiterDatenimport {
}
