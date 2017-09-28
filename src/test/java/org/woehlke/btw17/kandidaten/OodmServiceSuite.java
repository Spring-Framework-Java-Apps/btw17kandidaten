package org.woehlke.btw17.kandidaten;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.oodm.service.*;

@Suite.SuiteClasses({
        SucheServiceTest.class,
        AusschussServiceTest.class,
        BerufServiceTest.class,
        BerufsgruppeServiceTest.class,
        BundeslandServiceTest.class,
        FraktionServiceTest.class,
        GeburtsortServiceTest.class,
        ListeParteiServiceTest.class,
        MinisteriumServiceTest.class,
        ParteiServiceTest.class,
        WahlkreisServiceTest.class,
        WohnortServiceTest.class,
        WebseiteAgenturServiceTest.class,
        WebseiteCmsServiceTest.class,
        KandidatFlatServiceTest.class,
        KandidatServiceTest.class
})
@RunWith(Suite.class)
public class OodmServiceSuite {
}
