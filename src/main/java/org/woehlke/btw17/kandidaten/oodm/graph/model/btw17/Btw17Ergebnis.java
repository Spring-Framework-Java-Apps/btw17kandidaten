package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;


/**
 * Wahlergebnis in einem Wahlkreis oder in einem Bundesland
 */
@Setter
@Getter
@NodeEntity
public class Btw17Ergebnis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    //TODO: Relationship to Wahlkreis
    /**
     *  Nr;
     */
    //@NotNull
    @Index(unique=true)
    @Property(name="wahlkreis_nummer")
    private Long wahlkreisNummer;


    //TODO: Relationship to Wahlkreis
    /**
     * Gebiet;
     */
    //@NotNull
    @Index
    @Property(name="wahlkreis_name")
    private String wahlkreisName;

    @Relationship(type=LOCATION)
    private Btw17Wahlkreis btw17Wahlkreis;

    //TODO: Relationship to Bundesland
    /**
     * gehört zu;
     */
    //@NotNull
    @Property(name="bundesland_nummer")
    private Long bundeslandNummer;

    //TODO: Relationship to Bundesland
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
    //@NotNull
    @Property(name="wahlberechtigte_erststimmen_vorlaeufig")
    private Long wahlberechtigteErststimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="wahlberechtigte_erststimmen_vorperiode")
    private Long wahlberechtigteErststimmenVorperiode;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="wahlberechtigte_zweitstimmen_vorlaeufig")
    private Long wahlberechtigteZweitstimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="wahlberechtigte_zweitstimmen_vorperiode")
    private Long wahlberechtigteZweitstimmenVorperiode;


    // Wähler

    /**
     * Wähler;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="waehler_erststimmen_vorlaeufig")
    private Long waehlerErststimmenVorlaeufig;

    /**
     * Wähler;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="waehler_erststimmen_vorperiode")
    private Long waehlerErststimmenVorperiode;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="waehler_zweitstimmen_vorlaeufig")
    private Long waehlerZweitstimmenVorlaeufig;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="waehler_zweitstimmen_vorperiode")
    private Long waehlerZweitstimmenVorperiode;


    // Ungültige

    /**
     * Ungültige;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="ungueltige_erststimmen_vorlaeufig")
    private Long ungueltigeErststimmenVorlaeufig;

    /**
     * Ungültige;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="ungueltige_erststimmen_vorperiode")
    private Long ungueltigeErststimmenVorperiode;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="ungueltige_zweitstimmen_vorlaeufig")
    private Long ungueltigeZweitstimmenVorlaeufig;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="ungueltige_zweitstimmen_vorperiode")
    private Long ungueltigeZweitstimmenVorperiode;


    // Gültige

    /**
     * Gültige;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="gueltige_erststimmen_vorlaeufig")
    private Long gueltigeErststimmenVorlaeufig;

    /**
     * Gültige;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="gueltige_erststimmen_vorperiode")
    private Long gueltigeErststimmenVorperiode;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="gueltige_zweitstimmen_vorlaeufig")
    private Long gueltigeZweitstimmenVorlaeufig;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="ueltige_zweitstimmen_vorperiode")
    private Long gueltigeZweitstimmenVorperiode;


    // Christlich Demokratische Union Deutschlands

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="cdu_erststimmen_vorlaeufig")
    private Long cduErststimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    //@NotNull
    @Property(name="cdu_erststimmen_vorperiode")
    private Long cduErststimmenVorperiode;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    //@NotNull
    @Property(name="cdu_zweitstimmen_vorlaeufig")
    private Long cduZweitstimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    //@NotNull
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
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlkreisName+" ("+wahlkreisNummer+")";
    }

    //@Transient
    @Override
    public String getUniqueId() {
        return id+":"+wahlkreisNummer+":"+bundeslandNummer+":"+wahlkreisName;
    }

}
