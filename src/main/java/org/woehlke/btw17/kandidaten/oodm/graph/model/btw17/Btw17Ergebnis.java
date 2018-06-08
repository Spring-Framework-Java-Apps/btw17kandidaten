package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;


/**
 * Wahlergebnis in einem Wahlkreis oder in einem Bundesland
 */
@NodeEntity
public class Btw17Ergebnis extends GraphDomainObjectImpl implements GraphDomainObject {

    /**
     *  Nr;
     */
    @Index(unique=true)
    @Property(name="wahlkreis_nummer")
    private Long wahlkreisNummer;

    /**
     * Gebiet;
     */
    @Index
    @Property(name="wahlkreis_name")
    private String wahlkreisName;

    @Relationship(type=LOCATION)
    private Btw17Wahlkreis btw17Wahlkreis;

    /**
     * gehört zu;
     */
    @Property(name="bundesland_nummer")
    private Long bundeslandNummer;

    /**
     * Land
     */
    @Property(name="bundesland_kurz")
    private BundeslandEnum bundeslandKurz;

    @Relationship(type=LOCATION)
    private Bundesland bundesland;


    // Wahlberechtigte

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorläufig
     */
    @Property(name="wahlberechtigte_erststimmen_vorlaeufig")
    private Long wahlberechtigteErststimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorperiode
     */
    @Property(name="wahlberechtigte_erststimmen_vorperiode")
    private Long wahlberechtigteErststimmenVorperiode;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorläufig
     */
    @Property(name="wahlberechtigte_zweitstimmen_vorlaeufig")
    private Long wahlberechtigteZweitstimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorperiode
     */
    @Property(name="wahlberechtigte_zweitstimmen_vorperiode")
    private Long wahlberechtigteZweitstimmenVorperiode;


    // Wähler

    /**
     * Wähler;;;;Erststimmen;;;Vorläufig
     */
    @Property(name="waehler_erststimmen_vorlaeufig")
    private Long waehlerErststimmenVorlaeufig;

    /**
     * Wähler;;;;Erststimmen;;;Vorperiode
     */
    @Property(name="waehler_erststimmen_vorperiode")
    private Long waehlerErststimmenVorperiode;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorläufig
     */
    @Property(name="waehler_zweitstimmen_vorlaeufig")
    private Long waehlerZweitstimmenVorlaeufig;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorperiode
     */
    @Property(name="waehler_zweitstimmen_vorperiode")
    private Long waehlerZweitstimmenVorperiode;


    // Ungültige

    /**
     * Ungültige;;;;Erststimmen;;;Vorläufig
     */
    @Property(name="ungueltige_erststimmen_vorlaeufig")
    private Long ungueltigeErststimmenVorlaeufig;

    /**
     * Ungültige;;;;Erststimmen;;;Vorperiode
     */
    @Property(name="ungueltige_erststimmen_vorperiode")
    private Long ungueltigeErststimmenVorperiode;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorläufig
     */
    @Property(name="ungueltige_zweitstimmen_vorlaeufig")
    private Long ungueltigeZweitstimmenVorlaeufig;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorperiode
     */
    @Property(name="ungueltige_zweitstimmen_vorperiode")
    private Long ungueltigeZweitstimmenVorperiode;


    // Gültige

    /**
     * Gültige;;;;Erststimmen;;;Vorläufig
     */
    @Property(name="gueltige_erststimmen_vorlaeufig")
    private Long gueltigeErststimmenVorlaeufig;

    /**
     * Gültige;;;;Erststimmen;;;Vorperiode
     */
    @Property(name="gueltige_erststimmen_vorperiode")
    private Long gueltigeErststimmenVorperiode;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorläufig
     */
    @Property(name="gueltige_zweitstimmen_vorlaeufig")
    private Long gueltigeZweitstimmenVorlaeufig;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorperiode
     */
    @Property(name="ueltige_zweitstimmen_vorperiode")
    private Long gueltigeZweitstimmenVorperiode;


    // Christlich Demokratische Union Deutschlands

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    @Property(name="cdu_erststimmen_vorlaeufig")
    private Long cduErststimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    @Property(name="cdu_erststimmen_vorperiode")
    private Long cduErststimmenVorperiode;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    @Property(name="cdu_zweitstimmen_vorlaeufig")
    private Long cduZweitstimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    @Property(name="cdu_zweitstimmen_vorperiode")
    private Long cduZweitstimmenVorperiode;


    // Sozialdemokratische Partei Deutschlands

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="spd_erststimmen_vorlaeufig")
    private Long spdErststimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="spd_erststimmen_vorperiode")
    private Long spdErststimmenVorperiode;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="spd_zweitstimmen_vorlaeufig")
    private Long spdZweitstimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="spd_zweitstimmen_vorperiode")
    private Long spdZweitstimmenVorperiode;


    // DIE LINKE

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="dielinke_erststimmen_vorlaeufig")
    private Long dielinkeErststimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="dielinke_erststimmen_vorperiode")
    private Long dielinkeErststimmenVorperiode;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="dielinke_zweitstimmen_vorlaeufig")
    private Long dielinkeZweitstimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="dielinke_zweitstimmen_vorperiode")
    private Long dielinkeZweitstimmenVorperiode;


    // BÜNDNIS 90/DIE GRÜNEN

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="diegruenen_erststimmen_vorlaeufig")
    private Long diegruenenErststimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="diegruenen_erststimmen_vorperiode")
    private Long diegruenenErststimmenVorperiode;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorläufig
     */
    ////@NotNull
    //@NotNull
    @Property(name="diegruenen_zweitstimmen_vorlaeufig")
    private Long diegruenenZweitstimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="diegruenen_zweitstimmen_vorperiode")
    private Long diegruenenZweitstimmenVorperiode;


    // Christlich-Soziale Union in Bayern e.V.

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="csu_erststimmen_vorlaeufig")
    private Long csuErststimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="csu_erststimmen_vorperiode")
    private Long csuErststimmenVorperiode;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="csu_zweitstimmen_vorlaeufig")
    private Long csuZweitstimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="csu_zweitstimmen_vorperiode")
    private Long csuZweitstimmenVorperiode;


    // Freie Demokratische Partei

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="fdp_erststimmen_vorlaeufig")
    private Long fdpErststimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="fdp_erststimmen_vorperiode")
    private Long fdpErststimmenVorperiode;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="fdp_zweitstimmen_vorlaeufig")
    private Long fdpZweitstimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="fdp_zweitstimmen_vorperiode")
    private Long fdpZweitstimmenVorperiode;


    // Alternative für Deutschland

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="afd_erststimmen_vorlaeufig")
    private Long afdErststimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="afd_erststimmen_vorperiode")
    private Long afdErststimmenVorperiode;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="afd_zweitstimmen_vorlaeufig")
    private Long afdZweitstimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="afd_zweitstimmen_vorperiode")
    private Long afdZweitstimmenVorperiode;


    // Piratenpartei Deutschland

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="piratenpartei_erststimmen_vorlaeufig")
    private Long piratenparteiErststimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="piratenpartei_erststimmen_vorperiode")
    private Long piratenparteiErststimmenVorperiode;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="piratenpartei_zweitstimmen_vorlaeufig")
    private Long piratenparteiZweitstimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="piratenpartei_zweitstimmen_vorperiode")
    private Long piratenparteiZweitstimmenVorperiode;


    // Nationaldemokratische Partei Deutschlands

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="npd_erststimmen_vorlaeufig")
    private Long npdErststimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="npd_erststimmen_vorperiode")
    private Long npdErststimmenVorperiode;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="npd_zweitstimmen_vorlaeufig")
    private Long npdZweitstimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="npd_zweitstimmen_vorperiode")
    private Long npdZweitstimmenVorperiode;


    // FREIE WÄHLER

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="freiewaehler_erststimmen_vorlaeufig")
    private Long freieWaehlerErststimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="freiewaehler_erststimmen_vorperiode")
    private Long freieWaehlerErststimmenVorperiode;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="freiewaehler_zweitstimmen_vorlaeufig")
    private Long freieWaehlerZweitstimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="freiewaehler_zweitstimmen_vorperiode")
    private Long freieWaehlerZweitstimmenVorperiode;


    // PARTEI MENSCH UMWELT TIERSCHUTZ

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="tierschutzpartei_erststimmen_vorlaeufig")
    private Long tierschutzparteiErststimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="tierschutzpartei_erststimmen_vorperiode")
    private Long tierschutzparteiErststimmenVorperiode;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="tierschutzpartei_zweitstimmen_vorlaeufig")
    private Long tierschutzparteiZweitstimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="tierschutzpartei_zweitstimmen_vorperiode")
    private Long tierschutzparteiZweitstimmenVorperiode;



    // Ökologisch-Demokratische Partei

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="oedp_erststimmen_vorlaeufig")
    private Long oedpErststimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="oedp_erststimmen_vorperiode")
    private Long oedpErststimmenVorperiode;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="oedp_zweitstimmen_vorlaeufig")
    private Long oedpZweitstimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="oedp_zweitstimmen_vorperiode")
    private Long oedpZweitstimmenVorperiode;



    // Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="diepartei_erststimmen_vorlaeufig")
    private Long dieparteiErststimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="diepartei_erststimmen_vorperiode")
    private Long dieparteiErststimmenVorperiode;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="diepartei_zweitstimmen_vorlaeufig")
    private Long dieparteiZweitstimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="diepartei_zweitstimmen_vorperiode")
    private Long dieparteiZweitstimmenVorperiode;



    // Bayernpartei

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="bayernpartei_erststimmen_vorlaeufig")
    private Long bayernparteiErststimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="bayernpartei_erststimmen_vorperiode")
    private Long bayernparteiErststimmenVorperiode;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="bayernpartei_zweitstimmen_vorlaeufig")
    private Long bayernparteiZweitstimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="bayernpartei_zweitstimmen_vorperiode")
    private Long bayernparteiZweitstimmenVorperiode;



    // Ab jetzt...Demokratie durch Volksabstimmung

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    //@NotNull
    @Property(name="volksabstimmung_erststimmen_vorlaeufig")
    private Long volksabstimmungErststimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    //@NotNull
    @Property(name = "volksabstimmung_erststimmen_vorperiode")
    private Long volksabstimmungErststimmenVorperiode;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    //@NotNull
    @Property(name = "volksabstimmung_zweitstimmen_vorlaeufig")
    private Long volksabstimmungZweitstimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    //@NotNull
    @Property(name = "volksabstimmung_zweitstimmen_vorperiode")
    private Long volksabstimmungZweitstimmenVorperiode;


    // Partei der Vernunft

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    //@NotNull
    @Property(name = "pdv_erststimmen_vorlaeufig")
    private Long pdvErststimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    //@NotNull
    @Property(name = "pdv_erststimmen_vorperiode")
    private Long pdvErststimmenVorperiode;

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    //@NotNull
    @Property(name = "pdv_zweitstimmen_vorlaeufig")
    private Long pdvZweitstimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    //@NotNull
    @Property(name = "pdv_zweitstimmen_vorperiode")
    private Long pdvZweitstimmenVorperiode;


    // Marxistisch-Leninistische Partei Deutschlands

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    //@NotNull
    @Property(name = "mlpd_erststimmen_vorlaeufig")
    private Long mlpdErststimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    //@NotNull
    @Property(name = "mlpd_erststimmen_vorperiode")
    private Long mlpdErststimmenVorperiode;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    //@NotNull
    @Property(name = "mlpd_zweitstimmen_vorlaeufig")
    private Long mlpdZweitstimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    //@NotNull
    @Property(name = "mlpd_zweitstimmen_vorperiode")
    private Long mlpdZweitstimmenVorperiode;


    // Bürgerrechtsbewegung Solidarität

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    //@NotNull
    @Property(name = "bueso_erststimmen_vorlaeufig")
    private Long buesoErststimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    //@NotNull
    @Property(name = "bueso_erststimmen_vorperiode")
    private Long buesoErststimmenVorperiode;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    //@NotNull
    @Property(name = "bueso_zweitstimmen_vorlaeufig")
    private Long buesoZweitstimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    //@NotNull
    @Property(name = "bueso_zweitstimmen_vorperiode")
    private Long buesoZweitstimmenVorperiode;


    // Sozialistische Gleichheitspartei, Vierte Internationale

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    //@NotNull
    @Property(name = "sgp_erststimmen_vorlaeufig")
    private Long sgpErststimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    //@NotNull
    @Property(name = "sgp_erststimmen_vorperiode")
    private Long sgpErststimmenVorperiode;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    //@NotNull
    @Property(name = "sgp_zweitstimmen_vorlaeufig")
    private Long sgpZweitstimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    //@NotNull
    @Property(name = "sgp_zweitstimmen_vorperiode")
    private Long sgpZweitstimmenVorperiode;


    // DIE RECHTE

    /**
     * DIE RECHTE;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dierechte_erststimmen_vorlaeufig")
    private Long dierechteErststimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dierechte_erststimmen_vorperiode")
    private Long dierechteErststimmenVorperiode;

    /**
     * DIE RECHTE;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dierechte_zweitstimmen_vorlaeufig")
    private Long dierechteZweitstimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dierechte_zweitstimmen_vorperiode")
    private Long dierechteZweitstimmenVorperiode;


    // Allianz Deutscher Demokraten

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    //@NotNull
    @Property(name = "add_erststimmen_vorlaeufig")
    private Long addErststimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    //@NotNull
    @Property(name = "add_erststimmen_vorperiode")
    private Long addErststimmenVorperiode;

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    //@NotNull
    @Property(name = "add_zweitstimmen_vorlaeufig")
    private Long addZweitstimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    //@NotNull
    @Property(name = "add_zweitstimmen_vorperiode")
    private Long addZweitstimmenVorperiode;


    // Allianz für Menschenrechte, Tier- und Naturschutz

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    //@NotNull
    @Property(name = "tierschutzallianz_erststimmen_vorlaeufig")
    private Long tierschutzallianzErststimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    //@NotNull
    @Property(name = "tierschutzallianz_erststimmen_vorperiode")
    private Long tierschutzallianzErststimmenVorperiode;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    //@NotNull
    @Property(name = "tierschutzallianz_zweitstimmen_vorlaeufig")
    private Long tierschutzallianzZweitstimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    //@NotNull
    @Property(name = "tierschutzallianz_zweitstimmen_vorperiode")
    private Long tierschutzallianzZweitstimmenVorperiode;


    // bergpartei, die überpartei

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "bergpartei_erststimmen_vorlaeufig")
    private Long bergparteiErststimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "bergpartei_erststimmen_vorperiode")
    private Long bergparteiErststimmenVorperiode;

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "bergpartei_zweitstimmen_vorlaeufig")
    private Long bergparteiZweitstimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "bergpartei_zweitstimmen_vorperiode")
    private Long bergparteiZweitstimmenVorperiode;


    // Bündnis Grundeinkommen

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    //@NotNull
    @Property(name = "bge_erststimmen_vorlaeufig")
    private Long bgeErststimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    //@NotNull
    @Property(name = "bge_erststimmen_vorperiode")
    private Long bgeErststimmenVorperiode;

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    //@NotNull
    @Property(name = "bge_zweitstimmen_vorlaeufig")
    private Long bgeZweitstimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    //@NotNull
    @Property(name = "bge_zweitstimmen_vorperiode")
    private Long bgeZweitstimmenVorperiode;


    // DEMOKRATIE IN BEWEGUNG

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dib_erststimmen_vorlaeufig")
    private Long dibErststimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dib_erststimmen_vorperiode")
    private Long dibErststimmenVorperiode;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dib_zweitstimmen_vorlaeufig")
    private Long dibZweitstimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dib_zweitstimmen_vorperiode")
    private Long dibZweitstimmenVorperiode;


    // Deutsche Kommunistische Partei

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dkp_erststimmen_vorlaeufig")
    private Long dkpErststimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dkp_erststimmen_vorperiode")
    private Long dkpErststimmenVorperiode;

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dkp_zweitstimmen_vorlaeufig")
    private Long dkpZweitstimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dkp_zweitstimmen_vorperiode")
    private Long dkpZweitstimmenVorperiode;


    // Deutsche Mitte

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dm_erststimmen_vorlaeufig")
    private Long dmErststimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dm_erststimmen_vorperiode")
    private Long dmErststimmenVorperiode;

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dm_zweitstimmen_vorlaeufig")
    private Long dmZweitstimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dm_zweitstimmen_vorperiode")
    private Long dmZweitstimmenVorperiode;



    // Die Grauen – Für alle Generationen

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    //@NotNull
    @Property(name = "diegrauen_erststimmen_vorlaeufig")
    private Long diegrauenErststimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    //@NotNull
    @Property(name = "diegrauen_erststimmen_vorperiode")
    private Long diegrauenErststimmenVorperiode;

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    //@NotNull
    @Property(name = "diegrauen_zweitstimmen_vorlaeufig")
    private Long diegrauenZweitstimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    //@NotNull
    @Property(name = "diegrauen_zweitstimmen_vorperiode")
    private Long  diegrauenZweitstimmenVorperiode;



    // Die Urbane. Eine HipHop Partei

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "du_erststimmen_vorlaeufig")
    private Long duErststimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "du_erststimmen_vorperiode")
    private Long duErststimmenVorperiode;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "du_zweitstimmen_vorlaeufig")
    private Long duZweitstimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "du_zweitstimmen_vorperiode")
    private Long duZweitstimmenVorperiode;



    // Madgeburger Gartenpartei

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "mg_erststimmen_vorlaeufig")
    private Long mgErststimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "mg_erststimmen_vorperiode")
    private Long mgErststimmenVorperiode;

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "mg_zweitstimmen_vorlaeufig")
    private Long mgZweitstimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "mg_zweitstimmen_vorperiode")
    private Long mgZweitstimmenVorperiode;



    // Menschliche Welt

    /**
     * Menschliche Welt;;;Vorläufig
     */
    //@NotNull
    @Property(name = "menschlichewelt_erststimmen_vorlaeufig")
    private Long menschlicheweltErststimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    //@NotNull
    @Property(name = "menschlichewelt_erststimmen_vorperiode")
    private Long menschlicheweltErststimmenVorperiode;

    /**
     * Menschliche Welt;;;Vorläufig
     */
    //@NotNull
    @Property(name = "menschlichewelt_zweitstimmen_vorlaeufig")
    private Long menschlicheweltZweitstimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    //@NotNull
    @Property(name = "menschlichewelt_zweitstimmen_vorperiode")
    private Long menschlicheweltZweitstimmenVorperiode;



    // Partei der Humanisten

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    //@NotNull
    @Property(name = "diehumanisten_erststimmen_vorlaeufig")
    private Long diehumanistenErststimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    //@NotNull
    @Property(name = "diehumanisten_erststimmen_vorperiode")
    private Long diehumanistenErststimmenVorperiode;

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    //@NotNull
    @Property(name = "diehumanisten_zweitstimmen_vorlaeufig")
    private Long diehumanistenZweitstimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    //@NotNull
    @Property(name = "diehumanisten_zweitstimmen_vorperiode")
    private Long diehumanistenZweitstimmenVorperiode;



    // Partei für Gesundheitsforschung

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    //@NotNull
    @Property(name = "gesundheitsforschung_erststimmen_vorlaeufig")
    private Long gesundheitsforschungErststimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    //@NotNull
    @Property(name = "gesundheitsforschung_erststimmen_vorperiode")
    private Long gesundheitsforschungErststimmenVorperiode;

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    //@NotNull
    @Property(name = "gesundheitsforschung_zweitstimmen_vorlaeufig")
    private Long gesundheitsforschungZweitstimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    //@NotNull
    @Property(name = "gesundheitsforschung_zweitstimmen_vorperiode")
    private Long gesundheitsforschungZweitstimmenVorperiode;



    // V-Partei³ - Partei für Veränderung, Vegetarier und Veganer

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    //@NotNull
    @Property(name = "vpartei_erststimmen_vorlaeufig")
    private Long vparteiErststimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    //@NotNull
    @Property(name = "vpartei_erststimmen_vorperiode")
    private Long vparteiErststimmenVorperiode;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    //@NotNull
    @Property(name = "vpartei_zweitstimmen_vorlaeufig")
    private Long vparteiZweitstimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    //@NotNull
    @Property(name = "vpartei_zweitstimmen_vorperiode")
    private Long vparteiZweitstimmenVorperiode;



    // Bündnis C - Christen für Deutschland

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    //@NotNull
    @Property(name = "buendnisc_erststimmen_vorlaeufig")
    private Long buendniscErststimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    //@NotNull
    @Property(name = "buendnisc_erststimmen_vorperiode")
    private Long buendniscErststimmenVorperiode;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    //@NotNull
    @Property(name = "buendnisc_zweitstimmen_vorlaeufig")
    private Long buendniscZweitstimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    //@NotNull
    @Property(name = "buendnisc_zweitstimmen_vorperiode")
    private Long buendniscZweitstimmenVorperiode;



    // DIE EINHEIT

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dieeinheit_erststimmen_vorlaeufig")
    private Long dieeinheitErststimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dieeinheit_erststimmen_vorperiode")
    private Long dieeinheitErststimmenVorperiode;

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dieeinheit_zweitstimmen_vorlaeufig")
    private Long dieeinheitZweitstimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dieeinheit_zweitstimmen_vorperiode")
    private Long dieeinheitZweitstimmenVorperiode;



    // Die Violetten

    /**
     * Die Violetten;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dievioletten_erststimmen_vorlaeufig")
    private Long dieviolettenErststimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dievioletten_erststimmen_vorperiode")
    private Long dieviolettenErststimmenVorperiode;

    /**
     * Die Violetten;;;Vorläufig
     */
    //@NotNull
    @Property(name = "dievioletten_zweitstimmen_vorlaeufig")
    private Long dieviolettenZweitstimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    //@NotNull
    @Property(name = "dievioletten_zweitstimmen_vorperiode")
    private Long dieviolettenZweitstimmenVorperiode;



    // Familien-Partei Deutschlands

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    //@NotNull
    @Property(name = "familie_erststimmen_vorlaeufig")
    private Long familieErststimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    //@NotNull
    @Property(name = "familie_erststimmen_vorperiode")
    private Long familieErststimmenVorperiode;

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    //@NotNull
    @Property(name = "familie_zweitstimmen_vorlaeufig")
    private Long familieZweitstimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    //@NotNull
    @Property(name = "familie_zweitstimmen_vorperiode")
    private Long familieZweitstimmenVorperiode;



    // Feministische Partei DIE FRAUEN

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    //@NotNull
    @Property(name = "diefrauen_erststimmen_vorlaeufig")
    private Long diefrauenErststimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    //@NotNull
    @Property(name = "diefrauen_erststimmen_vorperiode")
    private Long diefrauenErststimmenVorperiode;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    //@NotNull
    @Property(name = "diefrauen_zweitstimmen_vorlaeufig")
    private Long diefrauenZweitstimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    //@NotNull
    @Property(name = "diefrauen_zweitstimmen_vorperiode")
    private Long diefrauenZweitstimmenVorperiode;



    // Mieterpartei

    /**
     * Mieterpartei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "mieterpartei_erststimmen_vorlaeufig")
    private Long mieterparteiErststimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "mieterpartei_erststimmen_vorperiode")
    private Long mieterparteiErststimmenVorperiode;

    /**
     * Mieterpartei;;;Vorläufig
     */
    //@NotNull
    @Property(name = "mieterpartei_zweitstimmen_vorlaeufig")
    private Long mieterparteiZweitstimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    //@NotNull
    @Property(name = "mieterpartei_zweitstimmen_vorperiode")
    private Long mieterparteiZweitstimmenVorperiode;



    // Neue Liberale – Die Sozialliberalen

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    //@NotNull
    @Property(name = "neueliberale_erststimmen_vorlaeufig")
    private Long neueliberaleErststimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    //@NotNull
    @Property(name = "neueliberale_erststimmen_vorperiode")
    private Long neueliberaleErststimmenVorperiode;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    //@NotNull
    @Property(name = "neueliberale_zweitstimmen_vorlaeufig")
    private Long neueliberaleZweitstimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    //@NotNull
    @Property(name = "neueliberale_zweitstimmen_vorperiode")
    private Long neueliberaleZweitstimmenVorperiode;



    // UNABHÄNGIGE für bürgernahe Demokratie

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    //@NotNull
    @Property(name = "unabhaengige_erststimmen_vorlaeufig")
    private Long unabhaengigeErststimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    //@NotNull
    @Property(name = "unabhaengige_erststimmen_vorperiode")
    private Long unabhaengigeErststimmenVorperiode;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    //@NotNull
    @Property(name = "unabhaengige_zweitstimmen_vorlaeufig")
    private Long unabhaengigeZweitstimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    //@NotNull
    @Property(name = "unabhaengige_zweitstimmen_vorperiode")
    private Long unabhaengigeZweitstimmenVorperiode;



    // Übrige

    /**
     * Übrige;;;Vorläufig
     */
    //@NotNull
    @Property(name = "uebrige_erststimmen_vorlaeufig")
    private Long uebrigeErststimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    //@NotNull
    @Property(name = "uebrige_erststimmen_vorperiode")
    private Long uebrigeErststimmenVorperiode;

    /**
     * Übrige;;;Vorläufig
     */
    //@NotNull
    @Property(name = "uebrige_zweitstimmen_vorlaeufig")
    private Long uebrigeZweitstimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    @Property(name = "uebrige_zweitstimmen_vorperiode")
    private Long uebrigeZweitstimmenVorperiode;

    @Override
    public String getName() {
        return wahlkreisName+" ("+wahlkreisNummer+")";
    }

    //@Transient
    @Override
    public String getUniqueId() {
        return wahlkreisNummer+":"+bundeslandNummer+":"+wahlkreisName+":"+getId();
    }

    public Btw17Ergebnis() {
    }

    public Long getWahlkreisNummer() {
        return wahlkreisNummer;
    }

    public void setWahlkreisNummer(Long wahlkreisNummer) {
        this.wahlkreisNummer = wahlkreisNummer;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
    }

    public Btw17Wahlkreis getBtw17Wahlkreis() {
        return btw17Wahlkreis;
    }

    public void setBtw17Wahlkreis(Btw17Wahlkreis btw17Wahlkreis) {
        this.btw17Wahlkreis = btw17Wahlkreis;
    }

    public Long getBundeslandNummer() {
        return bundeslandNummer;
    }

    public void setBundeslandNummer(Long bundeslandNummer) {
        this.bundeslandNummer = bundeslandNummer;
    }

    public BundeslandEnum getBundeslandKurz() {
        return bundeslandKurz;
    }

    public void setBundeslandKurz(BundeslandEnum bundeslandKurz) {
        this.bundeslandKurz = bundeslandKurz;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public Long getWahlberechtigteErststimmenVorlaeufig() {
        return wahlberechtigteErststimmenVorlaeufig;
    }

    public void setWahlberechtigteErststimmenVorlaeufig(Long wahlberechtigteErststimmenVorlaeufig) {
        this.wahlberechtigteErststimmenVorlaeufig = wahlberechtigteErststimmenVorlaeufig;
    }

    public Long getWahlberechtigteErststimmenVorperiode() {
        return wahlberechtigteErststimmenVorperiode;
    }

    public void setWahlberechtigteErststimmenVorperiode(Long wahlberechtigteErststimmenVorperiode) {
        this.wahlberechtigteErststimmenVorperiode = wahlberechtigteErststimmenVorperiode;
    }

    public Long getWahlberechtigteZweitstimmenVorlaeufig() {
        return wahlberechtigteZweitstimmenVorlaeufig;
    }

    public void setWahlberechtigteZweitstimmenVorlaeufig(Long wahlberechtigteZweitstimmenVorlaeufig) {
        this.wahlberechtigteZweitstimmenVorlaeufig = wahlberechtigteZweitstimmenVorlaeufig;
    }

    public Long getWahlberechtigteZweitstimmenVorperiode() {
        return wahlberechtigteZweitstimmenVorperiode;
    }

    public void setWahlberechtigteZweitstimmenVorperiode(Long wahlberechtigteZweitstimmenVorperiode) {
        this.wahlberechtigteZweitstimmenVorperiode = wahlberechtigteZweitstimmenVorperiode;
    }

    public Long getWaehlerErststimmenVorlaeufig() {
        return waehlerErststimmenVorlaeufig;
    }

    public void setWaehlerErststimmenVorlaeufig(Long waehlerErststimmenVorlaeufig) {
        this.waehlerErststimmenVorlaeufig = waehlerErststimmenVorlaeufig;
    }

    public Long getWaehlerErststimmenVorperiode() {
        return waehlerErststimmenVorperiode;
    }

    public void setWaehlerErststimmenVorperiode(Long waehlerErststimmenVorperiode) {
        this.waehlerErststimmenVorperiode = waehlerErststimmenVorperiode;
    }

    public Long getWaehlerZweitstimmenVorlaeufig() {
        return waehlerZweitstimmenVorlaeufig;
    }

    public void setWaehlerZweitstimmenVorlaeufig(Long waehlerZweitstimmenVorlaeufig) {
        this.waehlerZweitstimmenVorlaeufig = waehlerZweitstimmenVorlaeufig;
    }

    public Long getWaehlerZweitstimmenVorperiode() {
        return waehlerZweitstimmenVorperiode;
    }

    public void setWaehlerZweitstimmenVorperiode(Long waehlerZweitstimmenVorperiode) {
        this.waehlerZweitstimmenVorperiode = waehlerZweitstimmenVorperiode;
    }

    public Long getUngueltigeErststimmenVorlaeufig() {
        return ungueltigeErststimmenVorlaeufig;
    }

    public void setUngueltigeErststimmenVorlaeufig(Long ungueltigeErststimmenVorlaeufig) {
        this.ungueltigeErststimmenVorlaeufig = ungueltigeErststimmenVorlaeufig;
    }

    public Long getUngueltigeErststimmenVorperiode() {
        return ungueltigeErststimmenVorperiode;
    }

    public void setUngueltigeErststimmenVorperiode(Long ungueltigeErststimmenVorperiode) {
        this.ungueltigeErststimmenVorperiode = ungueltigeErststimmenVorperiode;
    }

    public Long getUngueltigeZweitstimmenVorlaeufig() {
        return ungueltigeZweitstimmenVorlaeufig;
    }

    public void setUngueltigeZweitstimmenVorlaeufig(Long ungueltigeZweitstimmenVorlaeufig) {
        this.ungueltigeZweitstimmenVorlaeufig = ungueltigeZweitstimmenVorlaeufig;
    }

    public Long getUngueltigeZweitstimmenVorperiode() {
        return ungueltigeZweitstimmenVorperiode;
    }

    public void setUngueltigeZweitstimmenVorperiode(Long ungueltigeZweitstimmenVorperiode) {
        this.ungueltigeZweitstimmenVorperiode = ungueltigeZweitstimmenVorperiode;
    }

    public Long getGueltigeErststimmenVorlaeufig() {
        return gueltigeErststimmenVorlaeufig;
    }

    public void setGueltigeErststimmenVorlaeufig(Long gueltigeErststimmenVorlaeufig) {
        this.gueltigeErststimmenVorlaeufig = gueltigeErststimmenVorlaeufig;
    }

    public Long getGueltigeErststimmenVorperiode() {
        return gueltigeErststimmenVorperiode;
    }

    public void setGueltigeErststimmenVorperiode(Long gueltigeErststimmenVorperiode) {
        this.gueltigeErststimmenVorperiode = gueltigeErststimmenVorperiode;
    }

    public Long getGueltigeZweitstimmenVorlaeufig() {
        return gueltigeZweitstimmenVorlaeufig;
    }

    public void setGueltigeZweitstimmenVorlaeufig(Long gueltigeZweitstimmenVorlaeufig) {
        this.gueltigeZweitstimmenVorlaeufig = gueltigeZweitstimmenVorlaeufig;
    }

    public Long getGueltigeZweitstimmenVorperiode() {
        return gueltigeZweitstimmenVorperiode;
    }

    public void setGueltigeZweitstimmenVorperiode(Long gueltigeZweitstimmenVorperiode) {
        this.gueltigeZweitstimmenVorperiode = gueltigeZweitstimmenVorperiode;
    }

    public Long getCduErststimmenVorlaeufig() {
        return cduErststimmenVorlaeufig;
    }

    public void setCduErststimmenVorlaeufig(Long cduErststimmenVorlaeufig) {
        this.cduErststimmenVorlaeufig = cduErststimmenVorlaeufig;
    }

    public Long getCduErststimmenVorperiode() {
        return cduErststimmenVorperiode;
    }

    public void setCduErststimmenVorperiode(Long cduErststimmenVorperiode) {
        this.cduErststimmenVorperiode = cduErststimmenVorperiode;
    }

    public Long getCduZweitstimmenVorlaeufig() {
        return cduZweitstimmenVorlaeufig;
    }

    public void setCduZweitstimmenVorlaeufig(Long cduZweitstimmenVorlaeufig) {
        this.cduZweitstimmenVorlaeufig = cduZweitstimmenVorlaeufig;
    }

    public Long getCduZweitstimmenVorperiode() {
        return cduZweitstimmenVorperiode;
    }

    public void setCduZweitstimmenVorperiode(Long cduZweitstimmenVorperiode) {
        this.cduZweitstimmenVorperiode = cduZweitstimmenVorperiode;
    }

    public Long getSpdErststimmenVorlaeufig() {
        return spdErststimmenVorlaeufig;
    }

    public void setSpdErststimmenVorlaeufig(Long spdErststimmenVorlaeufig) {
        this.spdErststimmenVorlaeufig = spdErststimmenVorlaeufig;
    }

    public Long getSpdErststimmenVorperiode() {
        return spdErststimmenVorperiode;
    }

    public void setSpdErststimmenVorperiode(Long spdErststimmenVorperiode) {
        this.spdErststimmenVorperiode = spdErststimmenVorperiode;
    }

    public Long getSpdZweitstimmenVorlaeufig() {
        return spdZweitstimmenVorlaeufig;
    }

    public void setSpdZweitstimmenVorlaeufig(Long spdZweitstimmenVorlaeufig) {
        this.spdZweitstimmenVorlaeufig = spdZweitstimmenVorlaeufig;
    }

    public Long getSpdZweitstimmenVorperiode() {
        return spdZweitstimmenVorperiode;
    }

    public void setSpdZweitstimmenVorperiode(Long spdZweitstimmenVorperiode) {
        this.spdZweitstimmenVorperiode = spdZweitstimmenVorperiode;
    }

    public Long getDielinkeErststimmenVorlaeufig() {
        return dielinkeErststimmenVorlaeufig;
    }

    public void setDielinkeErststimmenVorlaeufig(Long dielinkeErststimmenVorlaeufig) {
        this.dielinkeErststimmenVorlaeufig = dielinkeErststimmenVorlaeufig;
    }

    public Long getDielinkeErststimmenVorperiode() {
        return dielinkeErststimmenVorperiode;
    }

    public void setDielinkeErststimmenVorperiode(Long dielinkeErststimmenVorperiode) {
        this.dielinkeErststimmenVorperiode = dielinkeErststimmenVorperiode;
    }

    public Long getDielinkeZweitstimmenVorlaeufig() {
        return dielinkeZweitstimmenVorlaeufig;
    }

    public void setDielinkeZweitstimmenVorlaeufig(Long dielinkeZweitstimmenVorlaeufig) {
        this.dielinkeZweitstimmenVorlaeufig = dielinkeZweitstimmenVorlaeufig;
    }

    public Long getDielinkeZweitstimmenVorperiode() {
        return dielinkeZweitstimmenVorperiode;
    }

    public void setDielinkeZweitstimmenVorperiode(Long dielinkeZweitstimmenVorperiode) {
        this.dielinkeZweitstimmenVorperiode = dielinkeZweitstimmenVorperiode;
    }

    public Long getDiegruenenErststimmenVorlaeufig() {
        return diegruenenErststimmenVorlaeufig;
    }

    public void setDiegruenenErststimmenVorlaeufig(Long diegruenenErststimmenVorlaeufig) {
        this.diegruenenErststimmenVorlaeufig = diegruenenErststimmenVorlaeufig;
    }

    public Long getDiegruenenErststimmenVorperiode() {
        return diegruenenErststimmenVorperiode;
    }

    public void setDiegruenenErststimmenVorperiode(Long diegruenenErststimmenVorperiode) {
        this.diegruenenErststimmenVorperiode = diegruenenErststimmenVorperiode;
    }

    public Long getDiegruenenZweitstimmenVorlaeufig() {
        return diegruenenZweitstimmenVorlaeufig;
    }

    public void setDiegruenenZweitstimmenVorlaeufig(Long diegruenenZweitstimmenVorlaeufig) {
        this.diegruenenZweitstimmenVorlaeufig = diegruenenZweitstimmenVorlaeufig;
    }

    public Long getDiegruenenZweitstimmenVorperiode() {
        return diegruenenZweitstimmenVorperiode;
    }

    public void setDiegruenenZweitstimmenVorperiode(Long diegruenenZweitstimmenVorperiode) {
        this.diegruenenZweitstimmenVorperiode = diegruenenZweitstimmenVorperiode;
    }

    public Long getCsuErststimmenVorlaeufig() {
        return csuErststimmenVorlaeufig;
    }

    public void setCsuErststimmenVorlaeufig(Long csuErststimmenVorlaeufig) {
        this.csuErststimmenVorlaeufig = csuErststimmenVorlaeufig;
    }

    public Long getCsuErststimmenVorperiode() {
        return csuErststimmenVorperiode;
    }

    public void setCsuErststimmenVorperiode(Long csuErststimmenVorperiode) {
        this.csuErststimmenVorperiode = csuErststimmenVorperiode;
    }

    public Long getCsuZweitstimmenVorlaeufig() {
        return csuZweitstimmenVorlaeufig;
    }

    public void setCsuZweitstimmenVorlaeufig(Long csuZweitstimmenVorlaeufig) {
        this.csuZweitstimmenVorlaeufig = csuZweitstimmenVorlaeufig;
    }

    public Long getCsuZweitstimmenVorperiode() {
        return csuZweitstimmenVorperiode;
    }

    public void setCsuZweitstimmenVorperiode(Long csuZweitstimmenVorperiode) {
        this.csuZweitstimmenVorperiode = csuZweitstimmenVorperiode;
    }

    public Long getFdpErststimmenVorlaeufig() {
        return fdpErststimmenVorlaeufig;
    }

    public void setFdpErststimmenVorlaeufig(Long fdpErststimmenVorlaeufig) {
        this.fdpErststimmenVorlaeufig = fdpErststimmenVorlaeufig;
    }

    public Long getFdpErststimmenVorperiode() {
        return fdpErststimmenVorperiode;
    }

    public void setFdpErststimmenVorperiode(Long fdpErststimmenVorperiode) {
        this.fdpErststimmenVorperiode = fdpErststimmenVorperiode;
    }

    public Long getFdpZweitstimmenVorlaeufig() {
        return fdpZweitstimmenVorlaeufig;
    }

    public void setFdpZweitstimmenVorlaeufig(Long fdpZweitstimmenVorlaeufig) {
        this.fdpZweitstimmenVorlaeufig = fdpZweitstimmenVorlaeufig;
    }

    public Long getFdpZweitstimmenVorperiode() {
        return fdpZweitstimmenVorperiode;
    }

    public void setFdpZweitstimmenVorperiode(Long fdpZweitstimmenVorperiode) {
        this.fdpZweitstimmenVorperiode = fdpZweitstimmenVorperiode;
    }

    public Long getAfdErststimmenVorlaeufig() {
        return afdErststimmenVorlaeufig;
    }

    public void setAfdErststimmenVorlaeufig(Long afdErststimmenVorlaeufig) {
        this.afdErststimmenVorlaeufig = afdErststimmenVorlaeufig;
    }

    public Long getAfdErststimmenVorperiode() {
        return afdErststimmenVorperiode;
    }

    public void setAfdErststimmenVorperiode(Long afdErststimmenVorperiode) {
        this.afdErststimmenVorperiode = afdErststimmenVorperiode;
    }

    public Long getAfdZweitstimmenVorlaeufig() {
        return afdZweitstimmenVorlaeufig;
    }

    public void setAfdZweitstimmenVorlaeufig(Long afdZweitstimmenVorlaeufig) {
        this.afdZweitstimmenVorlaeufig = afdZweitstimmenVorlaeufig;
    }

    public Long getAfdZweitstimmenVorperiode() {
        return afdZweitstimmenVorperiode;
    }

    public void setAfdZweitstimmenVorperiode(Long afdZweitstimmenVorperiode) {
        this.afdZweitstimmenVorperiode = afdZweitstimmenVorperiode;
    }

    public Long getPiratenparteiErststimmenVorlaeufig() {
        return piratenparteiErststimmenVorlaeufig;
    }

    public void setPiratenparteiErststimmenVorlaeufig(Long piratenparteiErststimmenVorlaeufig) {
        this.piratenparteiErststimmenVorlaeufig = piratenparteiErststimmenVorlaeufig;
    }

    public Long getPiratenparteiErststimmenVorperiode() {
        return piratenparteiErststimmenVorperiode;
    }

    public void setPiratenparteiErststimmenVorperiode(Long piratenparteiErststimmenVorperiode) {
        this.piratenparteiErststimmenVorperiode = piratenparteiErststimmenVorperiode;
    }

    public Long getPiratenparteiZweitstimmenVorlaeufig() {
        return piratenparteiZweitstimmenVorlaeufig;
    }

    public void setPiratenparteiZweitstimmenVorlaeufig(Long piratenparteiZweitstimmenVorlaeufig) {
        this.piratenparteiZweitstimmenVorlaeufig = piratenparteiZweitstimmenVorlaeufig;
    }

    public Long getPiratenparteiZweitstimmenVorperiode() {
        return piratenparteiZweitstimmenVorperiode;
    }

    public void setPiratenparteiZweitstimmenVorperiode(Long piratenparteiZweitstimmenVorperiode) {
        this.piratenparteiZweitstimmenVorperiode = piratenparteiZweitstimmenVorperiode;
    }

    public Long getNpdErststimmenVorlaeufig() {
        return npdErststimmenVorlaeufig;
    }

    public void setNpdErststimmenVorlaeufig(Long npdErststimmenVorlaeufig) {
        this.npdErststimmenVorlaeufig = npdErststimmenVorlaeufig;
    }

    public Long getNpdErststimmenVorperiode() {
        return npdErststimmenVorperiode;
    }

    public void setNpdErststimmenVorperiode(Long npdErststimmenVorperiode) {
        this.npdErststimmenVorperiode = npdErststimmenVorperiode;
    }

    public Long getNpdZweitstimmenVorlaeufig() {
        return npdZweitstimmenVorlaeufig;
    }

    public void setNpdZweitstimmenVorlaeufig(Long npdZweitstimmenVorlaeufig) {
        this.npdZweitstimmenVorlaeufig = npdZweitstimmenVorlaeufig;
    }

    public Long getNpdZweitstimmenVorperiode() {
        return npdZweitstimmenVorperiode;
    }

    public void setNpdZweitstimmenVorperiode(Long npdZweitstimmenVorperiode) {
        this.npdZweitstimmenVorperiode = npdZweitstimmenVorperiode;
    }

    public Long getFreieWaehlerErststimmenVorlaeufig() {
        return freieWaehlerErststimmenVorlaeufig;
    }

    public void setFreieWaehlerErststimmenVorlaeufig(Long freieWaehlerErststimmenVorlaeufig) {
        this.freieWaehlerErststimmenVorlaeufig = freieWaehlerErststimmenVorlaeufig;
    }

    public Long getFreieWaehlerErststimmenVorperiode() {
        return freieWaehlerErststimmenVorperiode;
    }

    public void setFreieWaehlerErststimmenVorperiode(Long freieWaehlerErststimmenVorperiode) {
        this.freieWaehlerErststimmenVorperiode = freieWaehlerErststimmenVorperiode;
    }

    public Long getFreieWaehlerZweitstimmenVorlaeufig() {
        return freieWaehlerZweitstimmenVorlaeufig;
    }

    public void setFreieWaehlerZweitstimmenVorlaeufig(Long freieWaehlerZweitstimmenVorlaeufig) {
        this.freieWaehlerZweitstimmenVorlaeufig = freieWaehlerZweitstimmenVorlaeufig;
    }

    public Long getFreieWaehlerZweitstimmenVorperiode() {
        return freieWaehlerZweitstimmenVorperiode;
    }

    public void setFreieWaehlerZweitstimmenVorperiode(Long freieWaehlerZweitstimmenVorperiode) {
        this.freieWaehlerZweitstimmenVorperiode = freieWaehlerZweitstimmenVorperiode;
    }

    public Long getTierschutzparteiErststimmenVorlaeufig() {
        return tierschutzparteiErststimmenVorlaeufig;
    }

    public void setTierschutzparteiErststimmenVorlaeufig(Long tierschutzparteiErststimmenVorlaeufig) {
        this.tierschutzparteiErststimmenVorlaeufig = tierschutzparteiErststimmenVorlaeufig;
    }

    public Long getTierschutzparteiErststimmenVorperiode() {
        return tierschutzparteiErststimmenVorperiode;
    }

    public void setTierschutzparteiErststimmenVorperiode(Long tierschutzparteiErststimmenVorperiode) {
        this.tierschutzparteiErststimmenVorperiode = tierschutzparteiErststimmenVorperiode;
    }

    public Long getTierschutzparteiZweitstimmenVorlaeufig() {
        return tierschutzparteiZweitstimmenVorlaeufig;
    }

    public void setTierschutzparteiZweitstimmenVorlaeufig(Long tierschutzparteiZweitstimmenVorlaeufig) {
        this.tierschutzparteiZweitstimmenVorlaeufig = tierschutzparteiZweitstimmenVorlaeufig;
    }

    public Long getTierschutzparteiZweitstimmenVorperiode() {
        return tierschutzparteiZweitstimmenVorperiode;
    }

    public void setTierschutzparteiZweitstimmenVorperiode(Long tierschutzparteiZweitstimmenVorperiode) {
        this.tierschutzparteiZweitstimmenVorperiode = tierschutzparteiZweitstimmenVorperiode;
    }

    public Long getOedpErststimmenVorlaeufig() {
        return oedpErststimmenVorlaeufig;
    }

    public void setOedpErststimmenVorlaeufig(Long oedpErststimmenVorlaeufig) {
        this.oedpErststimmenVorlaeufig = oedpErststimmenVorlaeufig;
    }

    public Long getOedpErststimmenVorperiode() {
        return oedpErststimmenVorperiode;
    }

    public void setOedpErststimmenVorperiode(Long oedpErststimmenVorperiode) {
        this.oedpErststimmenVorperiode = oedpErststimmenVorperiode;
    }

    public Long getOedpZweitstimmenVorlaeufig() {
        return oedpZweitstimmenVorlaeufig;
    }

    public void setOedpZweitstimmenVorlaeufig(Long oedpZweitstimmenVorlaeufig) {
        this.oedpZweitstimmenVorlaeufig = oedpZweitstimmenVorlaeufig;
    }

    public Long getOedpZweitstimmenVorperiode() {
        return oedpZweitstimmenVorperiode;
    }

    public void setOedpZweitstimmenVorperiode(Long oedpZweitstimmenVorperiode) {
        this.oedpZweitstimmenVorperiode = oedpZweitstimmenVorperiode;
    }

    public Long getDieparteiErststimmenVorlaeufig() {
        return dieparteiErststimmenVorlaeufig;
    }

    public void setDieparteiErststimmenVorlaeufig(Long dieparteiErststimmenVorlaeufig) {
        this.dieparteiErststimmenVorlaeufig = dieparteiErststimmenVorlaeufig;
    }

    public Long getDieparteiErststimmenVorperiode() {
        return dieparteiErststimmenVorperiode;
    }

    public void setDieparteiErststimmenVorperiode(Long dieparteiErststimmenVorperiode) {
        this.dieparteiErststimmenVorperiode = dieparteiErststimmenVorperiode;
    }

    public Long getDieparteiZweitstimmenVorlaeufig() {
        return dieparteiZweitstimmenVorlaeufig;
    }

    public void setDieparteiZweitstimmenVorlaeufig(Long dieparteiZweitstimmenVorlaeufig) {
        this.dieparteiZweitstimmenVorlaeufig = dieparteiZweitstimmenVorlaeufig;
    }

    public Long getDieparteiZweitstimmenVorperiode() {
        return dieparteiZweitstimmenVorperiode;
    }

    public void setDieparteiZweitstimmenVorperiode(Long dieparteiZweitstimmenVorperiode) {
        this.dieparteiZweitstimmenVorperiode = dieparteiZweitstimmenVorperiode;
    }

    public Long getBayernparteiErststimmenVorlaeufig() {
        return bayernparteiErststimmenVorlaeufig;
    }

    public void setBayernparteiErststimmenVorlaeufig(Long bayernparteiErststimmenVorlaeufig) {
        this.bayernparteiErststimmenVorlaeufig = bayernparteiErststimmenVorlaeufig;
    }

    public Long getBayernparteiErststimmenVorperiode() {
        return bayernparteiErststimmenVorperiode;
    }

    public void setBayernparteiErststimmenVorperiode(Long bayernparteiErststimmenVorperiode) {
        this.bayernparteiErststimmenVorperiode = bayernparteiErststimmenVorperiode;
    }

    public Long getBayernparteiZweitstimmenVorlaeufig() {
        return bayernparteiZweitstimmenVorlaeufig;
    }

    public void setBayernparteiZweitstimmenVorlaeufig(Long bayernparteiZweitstimmenVorlaeufig) {
        this.bayernparteiZweitstimmenVorlaeufig = bayernparteiZweitstimmenVorlaeufig;
    }

    public Long getBayernparteiZweitstimmenVorperiode() {
        return bayernparteiZweitstimmenVorperiode;
    }

    public void setBayernparteiZweitstimmenVorperiode(Long bayernparteiZweitstimmenVorperiode) {
        this.bayernparteiZweitstimmenVorperiode = bayernparteiZweitstimmenVorperiode;
    }

    public Long getVolksabstimmungErststimmenVorlaeufig() {
        return volksabstimmungErststimmenVorlaeufig;
    }

    public void setVolksabstimmungErststimmenVorlaeufig(Long volksabstimmungErststimmenVorlaeufig) {
        this.volksabstimmungErststimmenVorlaeufig = volksabstimmungErststimmenVorlaeufig;
    }

    public Long getVolksabstimmungErststimmenVorperiode() {
        return volksabstimmungErststimmenVorperiode;
    }

    public void setVolksabstimmungErststimmenVorperiode(Long volksabstimmungErststimmenVorperiode) {
        this.volksabstimmungErststimmenVorperiode = volksabstimmungErststimmenVorperiode;
    }

    public Long getVolksabstimmungZweitstimmenVorlaeufig() {
        return volksabstimmungZweitstimmenVorlaeufig;
    }

    public void setVolksabstimmungZweitstimmenVorlaeufig(Long volksabstimmungZweitstimmenVorlaeufig) {
        this.volksabstimmungZweitstimmenVorlaeufig = volksabstimmungZweitstimmenVorlaeufig;
    }

    public Long getVolksabstimmungZweitstimmenVorperiode() {
        return volksabstimmungZweitstimmenVorperiode;
    }

    public void setVolksabstimmungZweitstimmenVorperiode(Long volksabstimmungZweitstimmenVorperiode) {
        this.volksabstimmungZweitstimmenVorperiode = volksabstimmungZweitstimmenVorperiode;
    }

    public Long getPdvErststimmenVorlaeufig() {
        return pdvErststimmenVorlaeufig;
    }

    public void setPdvErststimmenVorlaeufig(Long pdvErststimmenVorlaeufig) {
        this.pdvErststimmenVorlaeufig = pdvErststimmenVorlaeufig;
    }

    public Long getPdvErststimmenVorperiode() {
        return pdvErststimmenVorperiode;
    }

    public void setPdvErststimmenVorperiode(Long pdvErststimmenVorperiode) {
        this.pdvErststimmenVorperiode = pdvErststimmenVorperiode;
    }

    public Long getPdvZweitstimmenVorlaeufig() {
        return pdvZweitstimmenVorlaeufig;
    }

    public void setPdvZweitstimmenVorlaeufig(Long pdvZweitstimmenVorlaeufig) {
        this.pdvZweitstimmenVorlaeufig = pdvZweitstimmenVorlaeufig;
    }

    public Long getPdvZweitstimmenVorperiode() {
        return pdvZweitstimmenVorperiode;
    }

    public void setPdvZweitstimmenVorperiode(Long pdvZweitstimmenVorperiode) {
        this.pdvZweitstimmenVorperiode = pdvZweitstimmenVorperiode;
    }

    public Long getMlpdErststimmenVorlaeufig() {
        return mlpdErststimmenVorlaeufig;
    }

    public void setMlpdErststimmenVorlaeufig(Long mlpdErststimmenVorlaeufig) {
        this.mlpdErststimmenVorlaeufig = mlpdErststimmenVorlaeufig;
    }

    public Long getMlpdErststimmenVorperiode() {
        return mlpdErststimmenVorperiode;
    }

    public void setMlpdErststimmenVorperiode(Long mlpdErststimmenVorperiode) {
        this.mlpdErststimmenVorperiode = mlpdErststimmenVorperiode;
    }

    public Long getMlpdZweitstimmenVorlaeufig() {
        return mlpdZweitstimmenVorlaeufig;
    }

    public void setMlpdZweitstimmenVorlaeufig(Long mlpdZweitstimmenVorlaeufig) {
        this.mlpdZweitstimmenVorlaeufig = mlpdZweitstimmenVorlaeufig;
    }

    public Long getMlpdZweitstimmenVorperiode() {
        return mlpdZweitstimmenVorperiode;
    }

    public void setMlpdZweitstimmenVorperiode(Long mlpdZweitstimmenVorperiode) {
        this.mlpdZweitstimmenVorperiode = mlpdZweitstimmenVorperiode;
    }

    public Long getBuesoErststimmenVorlaeufig() {
        return buesoErststimmenVorlaeufig;
    }

    public void setBuesoErststimmenVorlaeufig(Long buesoErststimmenVorlaeufig) {
        this.buesoErststimmenVorlaeufig = buesoErststimmenVorlaeufig;
    }

    public Long getBuesoErststimmenVorperiode() {
        return buesoErststimmenVorperiode;
    }

    public void setBuesoErststimmenVorperiode(Long buesoErststimmenVorperiode) {
        this.buesoErststimmenVorperiode = buesoErststimmenVorperiode;
    }

    public Long getBuesoZweitstimmenVorlaeufig() {
        return buesoZweitstimmenVorlaeufig;
    }

    public void setBuesoZweitstimmenVorlaeufig(Long buesoZweitstimmenVorlaeufig) {
        this.buesoZweitstimmenVorlaeufig = buesoZweitstimmenVorlaeufig;
    }

    public Long getBuesoZweitstimmenVorperiode() {
        return buesoZweitstimmenVorperiode;
    }

    public void setBuesoZweitstimmenVorperiode(Long buesoZweitstimmenVorperiode) {
        this.buesoZweitstimmenVorperiode = buesoZweitstimmenVorperiode;
    }

    public Long getSgpErststimmenVorlaeufig() {
        return sgpErststimmenVorlaeufig;
    }

    public void setSgpErststimmenVorlaeufig(Long sgpErststimmenVorlaeufig) {
        this.sgpErststimmenVorlaeufig = sgpErststimmenVorlaeufig;
    }

    public Long getSgpErststimmenVorperiode() {
        return sgpErststimmenVorperiode;
    }

    public void setSgpErststimmenVorperiode(Long sgpErststimmenVorperiode) {
        this.sgpErststimmenVorperiode = sgpErststimmenVorperiode;
    }

    public Long getSgpZweitstimmenVorlaeufig() {
        return sgpZweitstimmenVorlaeufig;
    }

    public void setSgpZweitstimmenVorlaeufig(Long sgpZweitstimmenVorlaeufig) {
        this.sgpZweitstimmenVorlaeufig = sgpZweitstimmenVorlaeufig;
    }

    public Long getSgpZweitstimmenVorperiode() {
        return sgpZweitstimmenVorperiode;
    }

    public void setSgpZweitstimmenVorperiode(Long sgpZweitstimmenVorperiode) {
        this.sgpZweitstimmenVorperiode = sgpZweitstimmenVorperiode;
    }

    public Long getDierechteErststimmenVorlaeufig() {
        return dierechteErststimmenVorlaeufig;
    }

    public void setDierechteErststimmenVorlaeufig(Long dierechteErststimmenVorlaeufig) {
        this.dierechteErststimmenVorlaeufig = dierechteErststimmenVorlaeufig;
    }

    public Long getDierechteErststimmenVorperiode() {
        return dierechteErststimmenVorperiode;
    }

    public void setDierechteErststimmenVorperiode(Long dierechteErststimmenVorperiode) {
        this.dierechteErststimmenVorperiode = dierechteErststimmenVorperiode;
    }

    public Long getDierechteZweitstimmenVorlaeufig() {
        return dierechteZweitstimmenVorlaeufig;
    }

    public void setDierechteZweitstimmenVorlaeufig(Long dierechteZweitstimmenVorlaeufig) {
        this.dierechteZweitstimmenVorlaeufig = dierechteZweitstimmenVorlaeufig;
    }

    public Long getDierechteZweitstimmenVorperiode() {
        return dierechteZweitstimmenVorperiode;
    }

    public void setDierechteZweitstimmenVorperiode(Long dierechteZweitstimmenVorperiode) {
        this.dierechteZweitstimmenVorperiode = dierechteZweitstimmenVorperiode;
    }

    public Long getAddErststimmenVorlaeufig() {
        return addErststimmenVorlaeufig;
    }

    public void setAddErststimmenVorlaeufig(Long addErststimmenVorlaeufig) {
        this.addErststimmenVorlaeufig = addErststimmenVorlaeufig;
    }

    public Long getAddErststimmenVorperiode() {
        return addErststimmenVorperiode;
    }

    public void setAddErststimmenVorperiode(Long addErststimmenVorperiode) {
        this.addErststimmenVorperiode = addErststimmenVorperiode;
    }

    public Long getAddZweitstimmenVorlaeufig() {
        return addZweitstimmenVorlaeufig;
    }

    public void setAddZweitstimmenVorlaeufig(Long addZweitstimmenVorlaeufig) {
        this.addZweitstimmenVorlaeufig = addZweitstimmenVorlaeufig;
    }

    public Long getAddZweitstimmenVorperiode() {
        return addZweitstimmenVorperiode;
    }

    public void setAddZweitstimmenVorperiode(Long addZweitstimmenVorperiode) {
        this.addZweitstimmenVorperiode = addZweitstimmenVorperiode;
    }

    public Long getTierschutzallianzErststimmenVorlaeufig() {
        return tierschutzallianzErststimmenVorlaeufig;
    }

    public void setTierschutzallianzErststimmenVorlaeufig(Long tierschutzallianzErststimmenVorlaeufig) {
        this.tierschutzallianzErststimmenVorlaeufig = tierschutzallianzErststimmenVorlaeufig;
    }

    public Long getTierschutzallianzErststimmenVorperiode() {
        return tierschutzallianzErststimmenVorperiode;
    }

    public void setTierschutzallianzErststimmenVorperiode(Long tierschutzallianzErststimmenVorperiode) {
        this.tierschutzallianzErststimmenVorperiode = tierschutzallianzErststimmenVorperiode;
    }

    public Long getTierschutzallianzZweitstimmenVorlaeufig() {
        return tierschutzallianzZweitstimmenVorlaeufig;
    }

    public void setTierschutzallianzZweitstimmenVorlaeufig(Long tierschutzallianzZweitstimmenVorlaeufig) {
        this.tierschutzallianzZweitstimmenVorlaeufig = tierschutzallianzZweitstimmenVorlaeufig;
    }

    public Long getTierschutzallianzZweitstimmenVorperiode() {
        return tierschutzallianzZweitstimmenVorperiode;
    }

    public void setTierschutzallianzZweitstimmenVorperiode(Long tierschutzallianzZweitstimmenVorperiode) {
        this.tierschutzallianzZweitstimmenVorperiode = tierschutzallianzZweitstimmenVorperiode;
    }

    public Long getBergparteiErststimmenVorlaeufig() {
        return bergparteiErststimmenVorlaeufig;
    }

    public void setBergparteiErststimmenVorlaeufig(Long bergparteiErststimmenVorlaeufig) {
        this.bergparteiErststimmenVorlaeufig = bergparteiErststimmenVorlaeufig;
    }

    public Long getBergparteiErststimmenVorperiode() {
        return bergparteiErststimmenVorperiode;
    }

    public void setBergparteiErststimmenVorperiode(Long bergparteiErststimmenVorperiode) {
        this.bergparteiErststimmenVorperiode = bergparteiErststimmenVorperiode;
    }

    public Long getBergparteiZweitstimmenVorlaeufig() {
        return bergparteiZweitstimmenVorlaeufig;
    }

    public void setBergparteiZweitstimmenVorlaeufig(Long bergparteiZweitstimmenVorlaeufig) {
        this.bergparteiZweitstimmenVorlaeufig = bergparteiZweitstimmenVorlaeufig;
    }

    public Long getBergparteiZweitstimmenVorperiode() {
        return bergparteiZweitstimmenVorperiode;
    }

    public void setBergparteiZweitstimmenVorperiode(Long bergparteiZweitstimmenVorperiode) {
        this.bergparteiZweitstimmenVorperiode = bergparteiZweitstimmenVorperiode;
    }

    public Long getBgeErststimmenVorlaeufig() {
        return bgeErststimmenVorlaeufig;
    }

    public void setBgeErststimmenVorlaeufig(Long bgeErststimmenVorlaeufig) {
        this.bgeErststimmenVorlaeufig = bgeErststimmenVorlaeufig;
    }

    public Long getBgeErststimmenVorperiode() {
        return bgeErststimmenVorperiode;
    }

    public void setBgeErststimmenVorperiode(Long bgeErststimmenVorperiode) {
        this.bgeErststimmenVorperiode = bgeErststimmenVorperiode;
    }

    public Long getBgeZweitstimmenVorlaeufig() {
        return bgeZweitstimmenVorlaeufig;
    }

    public void setBgeZweitstimmenVorlaeufig(Long bgeZweitstimmenVorlaeufig) {
        this.bgeZweitstimmenVorlaeufig = bgeZweitstimmenVorlaeufig;
    }

    public Long getBgeZweitstimmenVorperiode() {
        return bgeZweitstimmenVorperiode;
    }

    public void setBgeZweitstimmenVorperiode(Long bgeZweitstimmenVorperiode) {
        this.bgeZweitstimmenVorperiode = bgeZweitstimmenVorperiode;
    }

    public Long getDibErststimmenVorlaeufig() {
        return dibErststimmenVorlaeufig;
    }

    public void setDibErststimmenVorlaeufig(Long dibErststimmenVorlaeufig) {
        this.dibErststimmenVorlaeufig = dibErststimmenVorlaeufig;
    }

    public Long getDibErststimmenVorperiode() {
        return dibErststimmenVorperiode;
    }

    public void setDibErststimmenVorperiode(Long dibErststimmenVorperiode) {
        this.dibErststimmenVorperiode = dibErststimmenVorperiode;
    }

    public Long getDibZweitstimmenVorlaeufig() {
        return dibZweitstimmenVorlaeufig;
    }

    public void setDibZweitstimmenVorlaeufig(Long dibZweitstimmenVorlaeufig) {
        this.dibZweitstimmenVorlaeufig = dibZweitstimmenVorlaeufig;
    }

    public Long getDibZweitstimmenVorperiode() {
        return dibZweitstimmenVorperiode;
    }

    public void setDibZweitstimmenVorperiode(Long dibZweitstimmenVorperiode) {
        this.dibZweitstimmenVorperiode = dibZweitstimmenVorperiode;
    }

    public Long getDkpErststimmenVorlaeufig() {
        return dkpErststimmenVorlaeufig;
    }

    public void setDkpErststimmenVorlaeufig(Long dkpErststimmenVorlaeufig) {
        this.dkpErststimmenVorlaeufig = dkpErststimmenVorlaeufig;
    }

    public Long getDkpErststimmenVorperiode() {
        return dkpErststimmenVorperiode;
    }

    public void setDkpErststimmenVorperiode(Long dkpErststimmenVorperiode) {
        this.dkpErststimmenVorperiode = dkpErststimmenVorperiode;
    }

    public Long getDkpZweitstimmenVorlaeufig() {
        return dkpZweitstimmenVorlaeufig;
    }

    public void setDkpZweitstimmenVorlaeufig(Long dkpZweitstimmenVorlaeufig) {
        this.dkpZweitstimmenVorlaeufig = dkpZweitstimmenVorlaeufig;
    }

    public Long getDkpZweitstimmenVorperiode() {
        return dkpZweitstimmenVorperiode;
    }

    public void setDkpZweitstimmenVorperiode(Long dkpZweitstimmenVorperiode) {
        this.dkpZweitstimmenVorperiode = dkpZweitstimmenVorperiode;
    }

    public Long getDmErststimmenVorlaeufig() {
        return dmErststimmenVorlaeufig;
    }

    public void setDmErststimmenVorlaeufig(Long dmErststimmenVorlaeufig) {
        this.dmErststimmenVorlaeufig = dmErststimmenVorlaeufig;
    }

    public Long getDmErststimmenVorperiode() {
        return dmErststimmenVorperiode;
    }

    public void setDmErststimmenVorperiode(Long dmErststimmenVorperiode) {
        this.dmErststimmenVorperiode = dmErststimmenVorperiode;
    }

    public Long getDmZweitstimmenVorlaeufig() {
        return dmZweitstimmenVorlaeufig;
    }

    public void setDmZweitstimmenVorlaeufig(Long dmZweitstimmenVorlaeufig) {
        this.dmZweitstimmenVorlaeufig = dmZweitstimmenVorlaeufig;
    }

    public Long getDmZweitstimmenVorperiode() {
        return dmZweitstimmenVorperiode;
    }

    public void setDmZweitstimmenVorperiode(Long dmZweitstimmenVorperiode) {
        this.dmZweitstimmenVorperiode = dmZweitstimmenVorperiode;
    }

    public Long getDiegrauenErststimmenVorlaeufig() {
        return diegrauenErststimmenVorlaeufig;
    }

    public void setDiegrauenErststimmenVorlaeufig(Long diegrauenErststimmenVorlaeufig) {
        this.diegrauenErststimmenVorlaeufig = diegrauenErststimmenVorlaeufig;
    }

    public Long getDiegrauenErststimmenVorperiode() {
        return diegrauenErststimmenVorperiode;
    }

    public void setDiegrauenErststimmenVorperiode(Long diegrauenErststimmenVorperiode) {
        this.diegrauenErststimmenVorperiode = diegrauenErststimmenVorperiode;
    }

    public Long getDiegrauenZweitstimmenVorlaeufig() {
        return diegrauenZweitstimmenVorlaeufig;
    }

    public void setDiegrauenZweitstimmenVorlaeufig(Long diegrauenZweitstimmenVorlaeufig) {
        this.diegrauenZweitstimmenVorlaeufig = diegrauenZweitstimmenVorlaeufig;
    }

    public Long getDiegrauenZweitstimmenVorperiode() {
        return diegrauenZweitstimmenVorperiode;
    }

    public void setDiegrauenZweitstimmenVorperiode(Long diegrauenZweitstimmenVorperiode) {
        this.diegrauenZweitstimmenVorperiode = diegrauenZweitstimmenVorperiode;
    }

    public Long getDuErststimmenVorlaeufig() {
        return duErststimmenVorlaeufig;
    }

    public void setDuErststimmenVorlaeufig(Long duErststimmenVorlaeufig) {
        this.duErststimmenVorlaeufig = duErststimmenVorlaeufig;
    }

    public Long getDuErststimmenVorperiode() {
        return duErststimmenVorperiode;
    }

    public void setDuErststimmenVorperiode(Long duErststimmenVorperiode) {
        this.duErststimmenVorperiode = duErststimmenVorperiode;
    }

    public Long getDuZweitstimmenVorlaeufig() {
        return duZweitstimmenVorlaeufig;
    }

    public void setDuZweitstimmenVorlaeufig(Long duZweitstimmenVorlaeufig) {
        this.duZweitstimmenVorlaeufig = duZweitstimmenVorlaeufig;
    }

    public Long getDuZweitstimmenVorperiode() {
        return duZweitstimmenVorperiode;
    }

    public void setDuZweitstimmenVorperiode(Long duZweitstimmenVorperiode) {
        this.duZweitstimmenVorperiode = duZweitstimmenVorperiode;
    }

    public Long getMgErststimmenVorlaeufig() {
        return mgErststimmenVorlaeufig;
    }

    public void setMgErststimmenVorlaeufig(Long mgErststimmenVorlaeufig) {
        this.mgErststimmenVorlaeufig = mgErststimmenVorlaeufig;
    }

    public Long getMgErststimmenVorperiode() {
        return mgErststimmenVorperiode;
    }

    public void setMgErststimmenVorperiode(Long mgErststimmenVorperiode) {
        this.mgErststimmenVorperiode = mgErststimmenVorperiode;
    }

    public Long getMgZweitstimmenVorlaeufig() {
        return mgZweitstimmenVorlaeufig;
    }

    public void setMgZweitstimmenVorlaeufig(Long mgZweitstimmenVorlaeufig) {
        this.mgZweitstimmenVorlaeufig = mgZweitstimmenVorlaeufig;
    }

    public Long getMgZweitstimmenVorperiode() {
        return mgZweitstimmenVorperiode;
    }

    public void setMgZweitstimmenVorperiode(Long mgZweitstimmenVorperiode) {
        this.mgZweitstimmenVorperiode = mgZweitstimmenVorperiode;
    }

    public Long getMenschlicheweltErststimmenVorlaeufig() {
        return menschlicheweltErststimmenVorlaeufig;
    }

    public void setMenschlicheweltErststimmenVorlaeufig(Long menschlicheweltErststimmenVorlaeufig) {
        this.menschlicheweltErststimmenVorlaeufig = menschlicheweltErststimmenVorlaeufig;
    }

    public Long getMenschlicheweltErststimmenVorperiode() {
        return menschlicheweltErststimmenVorperiode;
    }

    public void setMenschlicheweltErststimmenVorperiode(Long menschlicheweltErststimmenVorperiode) {
        this.menschlicheweltErststimmenVorperiode = menschlicheweltErststimmenVorperiode;
    }

    public Long getMenschlicheweltZweitstimmenVorlaeufig() {
        return menschlicheweltZweitstimmenVorlaeufig;
    }

    public void setMenschlicheweltZweitstimmenVorlaeufig(Long menschlicheweltZweitstimmenVorlaeufig) {
        this.menschlicheweltZweitstimmenVorlaeufig = menschlicheweltZweitstimmenVorlaeufig;
    }

    public Long getMenschlicheweltZweitstimmenVorperiode() {
        return menschlicheweltZweitstimmenVorperiode;
    }

    public void setMenschlicheweltZweitstimmenVorperiode(Long menschlicheweltZweitstimmenVorperiode) {
        this.menschlicheweltZweitstimmenVorperiode = menschlicheweltZweitstimmenVorperiode;
    }

    public Long getDiehumanistenErststimmenVorlaeufig() {
        return diehumanistenErststimmenVorlaeufig;
    }

    public void setDiehumanistenErststimmenVorlaeufig(Long diehumanistenErststimmenVorlaeufig) {
        this.diehumanistenErststimmenVorlaeufig = diehumanistenErststimmenVorlaeufig;
    }

    public Long getDiehumanistenErststimmenVorperiode() {
        return diehumanistenErststimmenVorperiode;
    }

    public void setDiehumanistenErststimmenVorperiode(Long diehumanistenErststimmenVorperiode) {
        this.diehumanistenErststimmenVorperiode = diehumanistenErststimmenVorperiode;
    }

    public Long getDiehumanistenZweitstimmenVorlaeufig() {
        return diehumanistenZweitstimmenVorlaeufig;
    }

    public void setDiehumanistenZweitstimmenVorlaeufig(Long diehumanistenZweitstimmenVorlaeufig) {
        this.diehumanistenZweitstimmenVorlaeufig = diehumanistenZweitstimmenVorlaeufig;
    }

    public Long getDiehumanistenZweitstimmenVorperiode() {
        return diehumanistenZweitstimmenVorperiode;
    }

    public void setDiehumanistenZweitstimmenVorperiode(Long diehumanistenZweitstimmenVorperiode) {
        this.diehumanistenZweitstimmenVorperiode = diehumanistenZweitstimmenVorperiode;
    }

    public Long getGesundheitsforschungErststimmenVorlaeufig() {
        return gesundheitsforschungErststimmenVorlaeufig;
    }

    public void setGesundheitsforschungErststimmenVorlaeufig(Long gesundheitsforschungErststimmenVorlaeufig) {
        this.gesundheitsforschungErststimmenVorlaeufig = gesundheitsforschungErststimmenVorlaeufig;
    }

    public Long getGesundheitsforschungErststimmenVorperiode() {
        return gesundheitsforschungErststimmenVorperiode;
    }

    public void setGesundheitsforschungErststimmenVorperiode(Long gesundheitsforschungErststimmenVorperiode) {
        this.gesundheitsforschungErststimmenVorperiode = gesundheitsforschungErststimmenVorperiode;
    }

    public Long getGesundheitsforschungZweitstimmenVorlaeufig() {
        return gesundheitsforschungZweitstimmenVorlaeufig;
    }

    public void setGesundheitsforschungZweitstimmenVorlaeufig(Long gesundheitsforschungZweitstimmenVorlaeufig) {
        this.gesundheitsforschungZweitstimmenVorlaeufig = gesundheitsforschungZweitstimmenVorlaeufig;
    }

    public Long getGesundheitsforschungZweitstimmenVorperiode() {
        return gesundheitsforschungZweitstimmenVorperiode;
    }

    public void setGesundheitsforschungZweitstimmenVorperiode(Long gesundheitsforschungZweitstimmenVorperiode) {
        this.gesundheitsforschungZweitstimmenVorperiode = gesundheitsforschungZweitstimmenVorperiode;
    }

    public Long getVparteiErststimmenVorlaeufig() {
        return vparteiErststimmenVorlaeufig;
    }

    public void setVparteiErststimmenVorlaeufig(Long vparteiErststimmenVorlaeufig) {
        this.vparteiErststimmenVorlaeufig = vparteiErststimmenVorlaeufig;
    }

    public Long getVparteiErststimmenVorperiode() {
        return vparteiErststimmenVorperiode;
    }

    public void setVparteiErststimmenVorperiode(Long vparteiErststimmenVorperiode) {
        this.vparteiErststimmenVorperiode = vparteiErststimmenVorperiode;
    }

    public Long getVparteiZweitstimmenVorlaeufig() {
        return vparteiZweitstimmenVorlaeufig;
    }

    public void setVparteiZweitstimmenVorlaeufig(Long vparteiZweitstimmenVorlaeufig) {
        this.vparteiZweitstimmenVorlaeufig = vparteiZweitstimmenVorlaeufig;
    }

    public Long getVparteiZweitstimmenVorperiode() {
        return vparteiZweitstimmenVorperiode;
    }

    public void setVparteiZweitstimmenVorperiode(Long vparteiZweitstimmenVorperiode) {
        this.vparteiZweitstimmenVorperiode = vparteiZweitstimmenVorperiode;
    }

    public Long getBuendniscErststimmenVorlaeufig() {
        return buendniscErststimmenVorlaeufig;
    }

    public void setBuendniscErststimmenVorlaeufig(Long buendniscErststimmenVorlaeufig) {
        this.buendniscErststimmenVorlaeufig = buendniscErststimmenVorlaeufig;
    }

    public Long getBuendniscErststimmenVorperiode() {
        return buendniscErststimmenVorperiode;
    }

    public void setBuendniscErststimmenVorperiode(Long buendniscErststimmenVorperiode) {
        this.buendniscErststimmenVorperiode = buendniscErststimmenVorperiode;
    }

    public Long getBuendniscZweitstimmenVorlaeufig() {
        return buendniscZweitstimmenVorlaeufig;
    }

    public void setBuendniscZweitstimmenVorlaeufig(Long buendniscZweitstimmenVorlaeufig) {
        this.buendniscZweitstimmenVorlaeufig = buendniscZweitstimmenVorlaeufig;
    }

    public Long getBuendniscZweitstimmenVorperiode() {
        return buendniscZweitstimmenVorperiode;
    }

    public void setBuendniscZweitstimmenVorperiode(Long buendniscZweitstimmenVorperiode) {
        this.buendniscZweitstimmenVorperiode = buendniscZweitstimmenVorperiode;
    }

    public Long getDieeinheitErststimmenVorlaeufig() {
        return dieeinheitErststimmenVorlaeufig;
    }

    public void setDieeinheitErststimmenVorlaeufig(Long dieeinheitErststimmenVorlaeufig) {
        this.dieeinheitErststimmenVorlaeufig = dieeinheitErststimmenVorlaeufig;
    }

    public Long getDieeinheitErststimmenVorperiode() {
        return dieeinheitErststimmenVorperiode;
    }

    public void setDieeinheitErststimmenVorperiode(Long dieeinheitErststimmenVorperiode) {
        this.dieeinheitErststimmenVorperiode = dieeinheitErststimmenVorperiode;
    }

    public Long getDieeinheitZweitstimmenVorlaeufig() {
        return dieeinheitZweitstimmenVorlaeufig;
    }

    public void setDieeinheitZweitstimmenVorlaeufig(Long dieeinheitZweitstimmenVorlaeufig) {
        this.dieeinheitZweitstimmenVorlaeufig = dieeinheitZweitstimmenVorlaeufig;
    }

    public Long getDieeinheitZweitstimmenVorperiode() {
        return dieeinheitZweitstimmenVorperiode;
    }

    public void setDieeinheitZweitstimmenVorperiode(Long dieeinheitZweitstimmenVorperiode) {
        this.dieeinheitZweitstimmenVorperiode = dieeinheitZweitstimmenVorperiode;
    }

    public Long getDieviolettenErststimmenVorlaeufig() {
        return dieviolettenErststimmenVorlaeufig;
    }

    public void setDieviolettenErststimmenVorlaeufig(Long dieviolettenErststimmenVorlaeufig) {
        this.dieviolettenErststimmenVorlaeufig = dieviolettenErststimmenVorlaeufig;
    }

    public Long getDieviolettenErststimmenVorperiode() {
        return dieviolettenErststimmenVorperiode;
    }

    public void setDieviolettenErststimmenVorperiode(Long dieviolettenErststimmenVorperiode) {
        this.dieviolettenErststimmenVorperiode = dieviolettenErststimmenVorperiode;
    }

    public Long getDieviolettenZweitstimmenVorlaeufig() {
        return dieviolettenZweitstimmenVorlaeufig;
    }

    public void setDieviolettenZweitstimmenVorlaeufig(Long dieviolettenZweitstimmenVorlaeufig) {
        this.dieviolettenZweitstimmenVorlaeufig = dieviolettenZweitstimmenVorlaeufig;
    }

    public Long getDieviolettenZweitstimmenVorperiode() {
        return dieviolettenZweitstimmenVorperiode;
    }

    public void setDieviolettenZweitstimmenVorperiode(Long dieviolettenZweitstimmenVorperiode) {
        this.dieviolettenZweitstimmenVorperiode = dieviolettenZweitstimmenVorperiode;
    }

    public Long getFamilieErststimmenVorlaeufig() {
        return familieErststimmenVorlaeufig;
    }

    public void setFamilieErststimmenVorlaeufig(Long familieErststimmenVorlaeufig) {
        this.familieErststimmenVorlaeufig = familieErststimmenVorlaeufig;
    }

    public Long getFamilieErststimmenVorperiode() {
        return familieErststimmenVorperiode;
    }

    public void setFamilieErststimmenVorperiode(Long familieErststimmenVorperiode) {
        this.familieErststimmenVorperiode = familieErststimmenVorperiode;
    }

    public Long getFamilieZweitstimmenVorlaeufig() {
        return familieZweitstimmenVorlaeufig;
    }

    public void setFamilieZweitstimmenVorlaeufig(Long familieZweitstimmenVorlaeufig) {
        this.familieZweitstimmenVorlaeufig = familieZweitstimmenVorlaeufig;
    }

    public Long getFamilieZweitstimmenVorperiode() {
        return familieZweitstimmenVorperiode;
    }

    public void setFamilieZweitstimmenVorperiode(Long familieZweitstimmenVorperiode) {
        this.familieZweitstimmenVorperiode = familieZweitstimmenVorperiode;
    }

    public Long getDiefrauenErststimmenVorlaeufig() {
        return diefrauenErststimmenVorlaeufig;
    }

    public void setDiefrauenErststimmenVorlaeufig(Long diefrauenErststimmenVorlaeufig) {
        this.diefrauenErststimmenVorlaeufig = diefrauenErststimmenVorlaeufig;
    }

    public Long getDiefrauenErststimmenVorperiode() {
        return diefrauenErststimmenVorperiode;
    }

    public void setDiefrauenErststimmenVorperiode(Long diefrauenErststimmenVorperiode) {
        this.diefrauenErststimmenVorperiode = diefrauenErststimmenVorperiode;
    }

    public Long getDiefrauenZweitstimmenVorlaeufig() {
        return diefrauenZweitstimmenVorlaeufig;
    }

    public void setDiefrauenZweitstimmenVorlaeufig(Long diefrauenZweitstimmenVorlaeufig) {
        this.diefrauenZweitstimmenVorlaeufig = diefrauenZweitstimmenVorlaeufig;
    }

    public Long getDiefrauenZweitstimmenVorperiode() {
        return diefrauenZweitstimmenVorperiode;
    }

    public void setDiefrauenZweitstimmenVorperiode(Long diefrauenZweitstimmenVorperiode) {
        this.diefrauenZweitstimmenVorperiode = diefrauenZweitstimmenVorperiode;
    }

    public Long getMieterparteiErststimmenVorlaeufig() {
        return mieterparteiErststimmenVorlaeufig;
    }

    public void setMieterparteiErststimmenVorlaeufig(Long mieterparteiErststimmenVorlaeufig) {
        this.mieterparteiErststimmenVorlaeufig = mieterparteiErststimmenVorlaeufig;
    }

    public Long getMieterparteiErststimmenVorperiode() {
        return mieterparteiErststimmenVorperiode;
    }

    public void setMieterparteiErststimmenVorperiode(Long mieterparteiErststimmenVorperiode) {
        this.mieterparteiErststimmenVorperiode = mieterparteiErststimmenVorperiode;
    }

    public Long getMieterparteiZweitstimmenVorlaeufig() {
        return mieterparteiZweitstimmenVorlaeufig;
    }

    public void setMieterparteiZweitstimmenVorlaeufig(Long mieterparteiZweitstimmenVorlaeufig) {
        this.mieterparteiZweitstimmenVorlaeufig = mieterparteiZweitstimmenVorlaeufig;
    }

    public Long getMieterparteiZweitstimmenVorperiode() {
        return mieterparteiZweitstimmenVorperiode;
    }

    public void setMieterparteiZweitstimmenVorperiode(Long mieterparteiZweitstimmenVorperiode) {
        this.mieterparteiZweitstimmenVorperiode = mieterparteiZweitstimmenVorperiode;
    }

    public Long getNeueliberaleErststimmenVorlaeufig() {
        return neueliberaleErststimmenVorlaeufig;
    }

    public void setNeueliberaleErststimmenVorlaeufig(Long neueliberaleErststimmenVorlaeufig) {
        this.neueliberaleErststimmenVorlaeufig = neueliberaleErststimmenVorlaeufig;
    }

    public Long getNeueliberaleErststimmenVorperiode() {
        return neueliberaleErststimmenVorperiode;
    }

    public void setNeueliberaleErststimmenVorperiode(Long neueliberaleErststimmenVorperiode) {
        this.neueliberaleErststimmenVorperiode = neueliberaleErststimmenVorperiode;
    }

    public Long getNeueliberaleZweitstimmenVorlaeufig() {
        return neueliberaleZweitstimmenVorlaeufig;
    }

    public void setNeueliberaleZweitstimmenVorlaeufig(Long neueliberaleZweitstimmenVorlaeufig) {
        this.neueliberaleZweitstimmenVorlaeufig = neueliberaleZweitstimmenVorlaeufig;
    }

    public Long getNeueliberaleZweitstimmenVorperiode() {
        return neueliberaleZweitstimmenVorperiode;
    }

    public void setNeueliberaleZweitstimmenVorperiode(Long neueliberaleZweitstimmenVorperiode) {
        this.neueliberaleZweitstimmenVorperiode = neueliberaleZweitstimmenVorperiode;
    }

    public Long getUnabhaengigeErststimmenVorlaeufig() {
        return unabhaengigeErststimmenVorlaeufig;
    }

    public void setUnabhaengigeErststimmenVorlaeufig(Long unabhaengigeErststimmenVorlaeufig) {
        this.unabhaengigeErststimmenVorlaeufig = unabhaengigeErststimmenVorlaeufig;
    }

    public Long getUnabhaengigeErststimmenVorperiode() {
        return unabhaengigeErststimmenVorperiode;
    }

    public void setUnabhaengigeErststimmenVorperiode(Long unabhaengigeErststimmenVorperiode) {
        this.unabhaengigeErststimmenVorperiode = unabhaengigeErststimmenVorperiode;
    }

    public Long getUnabhaengigeZweitstimmenVorlaeufig() {
        return unabhaengigeZweitstimmenVorlaeufig;
    }

    public void setUnabhaengigeZweitstimmenVorlaeufig(Long unabhaengigeZweitstimmenVorlaeufig) {
        this.unabhaengigeZweitstimmenVorlaeufig = unabhaengigeZweitstimmenVorlaeufig;
    }

    public Long getUnabhaengigeZweitstimmenVorperiode() {
        return unabhaengigeZweitstimmenVorperiode;
    }

    public void setUnabhaengigeZweitstimmenVorperiode(Long unabhaengigeZweitstimmenVorperiode) {
        this.unabhaengigeZweitstimmenVorperiode = unabhaengigeZweitstimmenVorperiode;
    }

    public Long getUebrigeErststimmenVorlaeufig() {
        return uebrigeErststimmenVorlaeufig;
    }

    public void setUebrigeErststimmenVorlaeufig(Long uebrigeErststimmenVorlaeufig) {
        this.uebrigeErststimmenVorlaeufig = uebrigeErststimmenVorlaeufig;
    }

    public Long getUebrigeErststimmenVorperiode() {
        return uebrigeErststimmenVorperiode;
    }

    public void setUebrigeErststimmenVorperiode(Long uebrigeErststimmenVorperiode) {
        this.uebrigeErststimmenVorperiode = uebrigeErststimmenVorperiode;
    }

    public Long getUebrigeZweitstimmenVorlaeufig() {
        return uebrigeZweitstimmenVorlaeufig;
    }

    public void setUebrigeZweitstimmenVorlaeufig(Long uebrigeZweitstimmenVorlaeufig) {
        this.uebrigeZweitstimmenVorlaeufig = uebrigeZweitstimmenVorlaeufig;
    }

    public Long getUebrigeZweitstimmenVorperiode() {
        return uebrigeZweitstimmenVorperiode;
    }

    public void setUebrigeZweitstimmenVorperiode(Long uebrigeZweitstimmenVorperiode) {
        this.uebrigeZweitstimmenVorperiode = uebrigeZweitstimmenVorperiode;
    }
}
