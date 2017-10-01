package org.woehlke.btw17.kandidaten;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.*;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.pages.DatenschutzControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.pages.ImprintControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.pages.WelcomeControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.suche.SucheControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.redaktion.data.*;
import org.woehlke.btw17.kandidaten.frontend.controller.redaktion.report.ReportControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.useraccess.pages.LoginControllerTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17KandidatFlatServiceTest;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17WahlkreisServiceTest;
import org.woehlke.btw17.kandidaten.oodm.service.*;

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
        KandidatControllerTest.class,

        LoginControllerTest.class,
        ReportControllerTest.class,
        AusschussRedaktionControllerTest.class,
        BerufRedaktionControllerTest.class,
        BerufsgruppeRedaktionControllerTest.class,
        BundeslandRedaktionControllerTest.class,
        FraktionRedaktionControllerTest.class,
        GeburtsortRedaktionControllerTest.class,
        LandesListeRedaktionControllerTest.class,
        ListeParteiRedaktionControllerTest.class,
        MinisteriumRedaktionControllerTest.class,
        ParteiRedaktionControllerTest.class,
        WahlkreisRedaktionControllerTest.class,
        WebseiteAgenturRedaktionControllerTest.class,
        WebseiteCmsRedaktionControllerTest.class,
        WohnortRedaktionControllerTest.class,

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
        KandidatServiceTest.class,

        Btw17KandidatFlatServiceTest.class,
        Btw17WahlkreisServiceTest.class
        /*,

        KandidatenNormalizedTableBuilder.class,
        KandidatenFotoUrlUdpate.class,
        UpdatePartei.class,
        UpdateSearchEngines.class,

        BerufImporter.class,
        BerufsgruppeImporter.class,
        BundeslandImporter.class,
        GeburtsortImporter.class,
        KandidatenImporter.class,
        ListeParteiImporter.class,
        ParteiImporter.class,
        WahlkreisImporter.class,
        WohnortImporter.class
        */
})
@RunWith(Suite.class)
public class AlphaTopLevelSuiteIT {
}
