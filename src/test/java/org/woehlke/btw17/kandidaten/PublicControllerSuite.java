package org.woehlke.btw17.kandidaten;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.*;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.pages.DatenschutzControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.pages.ImprintControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.pages.WelcomeControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.suche.SucheControllerTest;

@Suite.SuiteClasses({
        WelcomeControllerTest.class,
        DatenschutzControllerTest.class,
        ImprintControllerTest.class,
        SucheControllerTest.class,
        AusschussControllerTest.class,
        BerufControllerTest.class,
        BundeslandControllerTest.class,
        FraktionControllerTest.class,
        GeburtsjahrControllerTest.class,
        GeburtsortControllerTest.class,
        LandesListeControllerTest.class,
        ListeParteiControllerTest.class,
        MdBControllerTest.class,
        MinisteriumControllerTest.class,
        ParteiControllerTest.class,
        WahlkreisControllerTest.class,
        WohnortControllerTest.class,
        WebseiteAgenturControllerTest.class,
        WebseiteCmsControllerTest.class,
        KandidatControllerTest.class
})
@RunWith(Suite.class)
public class PublicControllerSuite {
}
