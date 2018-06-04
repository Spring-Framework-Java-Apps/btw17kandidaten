package org.woehlke.btw17.kandidaten;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.frontend.controller.open.data.*;
import org.woehlke.btw17.kandidaten.frontend.controller.open.pages.DatenschutzControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.open.pages.ImprintControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.open.pages.WelcomeControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.open.suche.SucheControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.closed.data.*;
import org.woehlke.btw17.kandidaten.frontend.controller.closed.reports.ReportControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.open.login.LoginControllerTest;
import org.woehlke.btw17.kandidaten.oodm.importer.service.Btw17KandidatFlatServiceTest;
import org.woehlke.btw17.kandidaten.oodm.importer.service.Btw17WahlkreisServiceTest;
import org.woehlke.btw17.kandidaten.oodm.db.service.*;

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
        OrtControllerTest.class,
        AgenturControllerTest.class,
        CmsControllerTest.class,
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
        AgenturRedaktionControllerTest.class,
        CmsRedaktionControllerTest.class,
        OrtRedaktionControllerTest.class,

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
        OrtServiceTest.class,
        AgenturServiceTest.class,
        CmsServiceTest.class,
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
        OrtImporter.class
        */
})
@RunWith(Suite.class)
public class AlphaTopLevelSuiteIT {
}
