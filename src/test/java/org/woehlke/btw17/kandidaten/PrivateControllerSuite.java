package org.woehlke.btw17.kandidaten;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.woehlke.btw17.kandidaten.frontend.controller.redaktion.data.*;
import org.woehlke.btw17.kandidaten.frontend.controller.redaktion.report.ReportControllerTest;
import org.woehlke.btw17.kandidaten.frontend.controller.useraccess.pages.LoginControllerTest;

@Suite.SuiteClasses({
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
    WohnortRedaktionControllerTest.class
})
@RunWith(Suite.class)
public class PrivateControllerSuite {
}
