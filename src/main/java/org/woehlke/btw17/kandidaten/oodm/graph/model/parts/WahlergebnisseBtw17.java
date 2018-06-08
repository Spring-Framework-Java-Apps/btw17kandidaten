package org.woehlke.btw17.kandidaten.oodm.graph.model.parts;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

@NodeEntity
public class WahlergebnisseBtw17 extends GraphDomainObjectImpl implements GraphDomainObject {

    // Wahlberechtigte

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_erststimmen_vorlaeufig")
    private String wahlberechtigteErststimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_erststimmen_vorperiode")
    private String wahlberechtigteErststimmenVorperiode;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_zweitstimmen_vorlaeufig")
    private String wahlberechtigteZweitstimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_zweitstimmen_vorperiode")
    private String wahlberechtigteZweitstimmenVorperiode;


    // Wähler

    /**
     * Wähler;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "waehler_erststimmen_vorlaeufig")
    private String waehlerErststimmenVorlaeufig;

    /**
     * Wähler;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "waehler_erststimmen_vorperiode")
    private String waehlerErststimmenVorperiode;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "waehler_zweitstimmen_vorlaeufig")
    private String waehlerZweitstimmenVorlaeufig;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "waehler_zweitstimmen_vorperiode")
    private String waehlerZweitstimmenVorperiode;


    // Ungültige

    /**
     * Ungültige;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_erststimmen_vorlaeufig")
    private String ungueltigeErststimmenVorlaeufig;

    /**
     * Ungültige;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_erststimmen_vorperiode")
    private String ungueltigeErststimmenVorperiode;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_zweitstimmen_vorlaeufig")
    private String ungueltigeZweitstimmenVorlaeufig;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_zweitstimmen_vorperiode")
    private String ungueltigeZweitstimmenVorperiode;


    // Gültige

    /**
     * Gültige;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "gueltige_erststimmen_vorlaeufig")
    private String gueltigeErststimmenVorlaeufig;

    /**
     * Gültige;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "gueltige_erststimmen_vorperiode")
    private String gueltigeErststimmenVorperiode;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "gueltige_zweitstimmen_vorlaeufig")
    private String gueltigeZweitstimmenVorlaeufig;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "ueltige_zweitstimmen_vorperiode")
    private String gueltigeZweitstimmenVorperiode;


    // Christlich Demokratische Union Deutschlands

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "cdu_erststimmen_vorlaeufig")
    private String cduErststimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "cdu_erststimmen_vorperiode")
    private String cduErststimmenVorperiode;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "cdu_zweitstimmen_vorlaeufig")
    private String cduZweitstimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "cdu_zweitstimmen_vorperiode")
    private String cduZweitstimmenVorperiode;


    // Sozialdemokratische Partei Deutschlands

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "spd_erststimmen_vorlaeufig")
    private String spdErststimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "spd_erststimmen_vorperiode")
    private String spdErststimmenVorperiode;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "spd_zweitstimmen_vorlaeufig")
    private String spdZweitstimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "spd_zweitstimmen_vorperiode")
    private String spdZweitstimmenVorperiode;


    // DIE LINKE

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dielinke_erststimmen_vorlaeufig")
    private String dielinkeErststimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dielinke_erststimmen_vorperiode")
    private String dielinkeErststimmenVorperiode;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dielinke_zweitstimmen_vorlaeufig")
    private String dielinkeZweitstimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dielinke_zweitstimmen_vorperiode")
    private String dielinkeZweitstimmenVorperiode;


    // BÜNDNIS 90/DIE GRÜNEN

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_erststimmen_vorlaeufig")
    private String diegruenenErststimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_erststimmen_vorperiode")
    private String diegruenenErststimmenVorperiode;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_zweitstimmen_vorlaeufig")
    private String diegruenenZweitstimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_zweitstimmen_vorperiode")
    private String diegruenenZweitstimmenVorperiode;


    // Christlich-Soziale Union in Bayern e.V.

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "csu_erststimmen_vorlaeufig")
    private String csuErststimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "csu_erststimmen_vorperiode")
    private String csuErststimmenVorperiode;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "csu_zweitstimmen_vorlaeufig")
    private String csuZweitstimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "csu_zweitstimmen_vorperiode")
    private String csuZweitstimmenVorperiode;


    // Freie Demokratische Partei

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "fdp_erststimmen_vorlaeufig")
    private String fdpErststimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "fdp_erststimmen_vorperiode")
    private String fdpErststimmenVorperiode;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "fdp_zweitstimmen_vorlaeufig")
    private String fdpZweitstimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "fdp_zweitstimmen_vorperiode")
    private String fdpZweitstimmenVorperiode;


    // Alternative für Deutschland

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "afd_erststimmen_vorlaeufig")
    private String afdErststimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "afd_erststimmen_vorperiode")
    private String afdErststimmenVorperiode;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "afd_zweitstimmen_vorlaeufig")
    private String afdZweitstimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "afd_zweitstimmen_vorperiode")
    private String afdZweitstimmenVorperiode;


    // Piratenpartei Deutschland

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_erststimmen_vorlaeufig")
    private String piratenparteiErststimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_erststimmen_vorperiode")
    private String piratenparteiErststimmenVorperiode;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_zweitstimmen_vorlaeufig")
    private String piratenparteiZweitstimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_zweitstimmen_vorperiode")
    private String piratenparteiZweitstimmenVorperiode;


    // Nationaldemokratische Partei Deutschlands

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "npd_erststimmen_vorlaeufig")
    private String npdErststimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "npd_erststimmen_vorperiode")
    private String npdErststimmenVorperiode;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "npd_zweitstimmen_vorlaeufig")
    private String npdZweitstimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "npd_zweitstimmen_vorperiode")
    private String npdZweitstimmenVorperiode;


    // FREIE WÄHLER

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_erststimmen_vorlaeufig")
    private String freieWaehlerErststimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_erststimmen_vorperiode")
    private String freieWaehlerErststimmenVorperiode;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_zweitstimmen_vorlaeufig")
    private String freieWaehlerZweitstimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_zweitstimmen_vorperiode")
    private String freieWaehlerZweitstimmenVorperiode;


    // PARTEI MENSCH UMWELT TIERSCHUTZ

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_erststimmen_vorlaeufig")
    private String tierschutzparteiErststimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_erststimmen_vorperiode")
    private String tierschutzparteiErststimmenVorperiode;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_zweitstimmen_vorlaeufig")
    private String tierschutzparteiZweitstimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_zweitstimmen_vorperiode")
    private String tierschutzparteiZweitstimmenVorperiode;



    // Ökologisch-Demokratische Partei

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "oedp_erststimmen_vorlaeufig")
    private String oedpErststimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "oedp_erststimmen_vorperiode")
    private String oedpErststimmenVorperiode;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "oedp_zweitstimmen_vorlaeufig")
    private String oedpZweitstimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "oedp_zweitstimmen_vorperiode")
    private String oedpZweitstimmenVorperiode;



    // Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diepartei_erststimmen_vorlaeufig")
    private String dieparteiErststimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diepartei_erststimmen_vorperiode")
    private String dieparteiErststimmenVorperiode;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diepartei_zweitstimmen_vorlaeufig")
    private String dieparteiZweitstimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diepartei_zweitstimmen_vorperiode")
    private String dieparteiZweitstimmenVorperiode;



    // Bayernpartei

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_erststimmen_vorlaeufig")
    private String bayernparteiErststimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_erststimmen_vorperiode")
    private String bayernparteiErststimmenVorperiode;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_zweitstimmen_vorlaeufig")
    private String bayernparteiZweitstimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_zweitstimmen_vorperiode")
    private String bayernparteiZweitstimmenVorperiode;



    // Ab jetzt...Demokratie durch Volksabstimmung

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_erststimmen_vorlaeufig")
    private String volksabstimmungErststimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_erststimmen_vorperiode")
    private String volksabstimmungErststimmenVorperiode;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_zweitstimmen_vorlaeufig")
    private String volksabstimmungZweitstimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_zweitstimmen_vorperiode")
    private String volksabstimmungZweitstimmenVorperiode;


    // Partei der Vernunft

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "pdv_erststimmen_vorlaeufig")
    private String pdvErststimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "pdv_erststimmen_vorperiode")
    private String pdvErststimmenVorperiode;

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "pdv_zweitstimmen_vorlaeufig")
    private String pdvZweitstimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "pdv_zweitstimmen_vorperiode")
    private String pdvZweitstimmenVorperiode;


    // Marxistisch-Leninistische Partei Deutschlands

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mlpd_erststimmen_vorlaeufig")
    private String mlpdErststimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mlpd_erststimmen_vorperiode")
    private String mlpdErststimmenVorperiode;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mlpd_zweitstimmen_vorlaeufig")
    private String mlpdZweitstimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mlpd_zweitstimmen_vorperiode")
    private String mlpdZweitstimmenVorperiode;


    // Bürgerrechtsbewegung Solidarität

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bueso_erststimmen_vorlaeufig")
    private String buesoErststimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bueso_erststimmen_vorperiode")
    private String buesoErststimmenVorperiode;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bueso_zweitstimmen_vorlaeufig")
    private String buesoZweitstimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bueso_zweitstimmen_vorperiode")
    private String buesoZweitstimmenVorperiode;


    // Sozialistische Gleichheitspartei, Vierte Internationale

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "sgp_erststimmen_vorlaeufig")
    private String sgpErststimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "sgp_erststimmen_vorperiode")
    private String sgpErststimmenVorperiode;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "sgp_zweitstimmen_vorlaeufig")
    private String sgpZweitstimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "sgp_zweitstimmen_vorperiode")
    private String sgpZweitstimmenVorperiode;


    // DIE RECHTE

    /**
     * DIE RECHTE;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dierechte_erststimmen_vorlaeufig")
    private String dierechteErststimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dierechte_erststimmen_vorperiode")
    private String dierechteErststimmenVorperiode;

    /**
     * DIE RECHTE;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dierechte_zweitstimmen_vorlaeufig")
    private String dierechteZweitstimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dierechte_zweitstimmen_vorperiode")
    private String dierechteZweitstimmenVorperiode;


    // Allianz Deutscher Demokraten

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "add_erststimmen_vorlaeufig")
    private String addErststimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "add_erststimmen_vorperiode")
    private String addErststimmenVorperiode;

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "add_zweitstimmen_vorlaeufig")
    private String addZweitstimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "add_zweitstimmen_vorperiode")
    private String addZweitstimmenVorperiode;


    // Allianz für Menschenrechte, Tier- und Naturschutz

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_erststimmen_vorlaeufig")
    private String tierschutzallianzErststimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_erststimmen_vorperiode")
    private String tierschutzallianzErststimmenVorperiode;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_zweitstimmen_vorlaeufig")
    private String tierschutzallianzZweitstimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_zweitstimmen_vorperiode")
    private String tierschutzallianzZweitstimmenVorperiode;


    // bergpartei, die überpartei

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bergpartei_erststimmen_vorlaeufig")
    private String bergparteiErststimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bergpartei_erststimmen_vorperiode")
    private String bergparteiErststimmenVorperiode;

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    @Property(name = "bergpartei_zweitstimmen_vorlaeufig")
    private String bergparteiZweitstimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bergpartei_zweitstimmen_vorperiode")
    private String bergparteiZweitstimmenVorperiode;


    // Bündnis Grundeinkommen

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bge_erststimmen_vorlaeufig")
    private String bgeErststimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    @Property(name = "bge_erststimmen_vorperiode")
    private String bgeErststimmenVorperiode;

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bge_zweitstimmen_vorlaeufig")
    private String bgeZweitstimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "bge_zweitstimmen_vorperiode")
    private String bgeZweitstimmenVorperiode;


    // DEMOKRATIE IN BEWEGUNG

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dib_erststimmen_vorlaeufig")
    private String dibErststimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dib_erststimmen_vorperiode")
    private String dibErststimmenVorperiode;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dib_zweitstimmen_vorlaeufig")
    private String dibZweitstimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dib_zweitstimmen_vorperiode")
    private String dibZweitstimmenVorperiode;


    // Deutsche Kommunistische Partei

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dkp_erststimmen_vorlaeufig")
    private String dkpErststimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dkp_erststimmen_vorperiode")
    private String dkpErststimmenVorperiode;

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dkp_zweitstimmen_vorlaeufig")
    private String dkpZweitstimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dkp_zweitstimmen_vorperiode")
    private String dkpZweitstimmenVorperiode;


    // Deutsche Mitte

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dm_erststimmen_vorlaeufig")
    private String dmErststimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dm_erststimmen_vorperiode")
    private String dmErststimmenVorperiode;

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dm_zweitstimmen_vorlaeufig")
    private String dmZweitstimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dm_zweitstimmen_vorperiode")
    private String dmZweitstimmenVorperiode;



    // Die Grauen – Für alle Generationen

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_erststimmen_vorlaeufig")
    private String diegrauenErststimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_erststimmen_vorperiode")
    private String diegrauenErststimmenVorperiode;

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_zweitstimmen_vorlaeufig")
    private String diegrauenZweitstimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_zweitstimmen_vorperiode")
    private String  diegrauenZweitstimmenVorperiode;



    // Die Urbane. Eine HipHop Partei

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "du_erststimmen_vorlaeufig")
    private String duErststimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "du_erststimmen_vorperiode")
    private String duErststimmenVorperiode;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "du_zweitstimmen_vorlaeufig")
    private String duZweitstimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "du_zweitstimmen_vorperiode")
    private String duZweitstimmenVorperiode;



    // Madgeburger Gartenpartei

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mg_erststimmen_vorlaeufig")
    private String mgErststimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mg_erststimmen_vorperiode")
    private String mgErststimmenVorperiode;

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mg_zweitstimmen_vorlaeufig")
    private String mgZweitstimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mg_zweitstimmen_vorperiode")
    private String mgZweitstimmenVorperiode;



    // Menschliche Welt

    /**
     * Menschliche Welt;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_erststimmen_vorlaeufig")
    private String menschlicheweltErststimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_erststimmen_vorperiode")
    private String menschlicheweltErststimmenVorperiode;

    /**
     * Menschliche Welt;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_zweitstimmen_vorlaeufig")
    private String menschlicheweltZweitstimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_zweitstimmen_vorperiode")
    private String menschlicheweltZweitstimmenVorperiode;



    // Partei der Humanisten

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_erststimmen_vorlaeufig")
    private String diehumanistenErststimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_erststimmen_vorperiode")
    private String diehumanistenErststimmenVorperiode;

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_zweitstimmen_vorlaeufig")
    private String diehumanistenZweitstimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_zweitstimmen_vorperiode")
    private String diehumanistenZweitstimmenVorperiode;



    // Partei für Gesundheitsforschung

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_erststimmen_vorlaeufig")
    private String gesundheitsforschungErststimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_erststimmen_vorperiode")
    private String gesundheitsforschungErststimmenVorperiode;

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_zweitstimmen_vorlaeufig")
    private String gesundheitsforschungZweitstimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_zweitstimmen_vorperiode")
    private String gesundheitsforschungZweitstimmenVorperiode;



    // V-Partei³ - Partei für Veränderung, Vegetarier und Veganer

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "vpartei_erststimmen_vorlaeufig")
    private String vparteiErststimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "vpartei_erststimmen_vorperiode")
    private String vparteiErststimmenVorperiode;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "vpartei_zweitstimmen_vorlaeufig")
    private String vparteiZweitstimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "vpartei_zweitstimmen_vorperiode")
    private String vparteiZweitstimmenVorperiode;



    // Bündnis C - Christen für Deutschland

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "buendnisc_erststimmen_vorlaeufig")
    private String buendniscErststimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "buendnisc_erststimmen_vorperiode")
    private String buendniscErststimmenVorperiode;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    @Property(name = "buendnisc_zweitstimmen_vorlaeufig")
    private String buendniscZweitstimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "buendnisc_zweitstimmen_vorperiode")
    private String buendniscZweitstimmenVorperiode;



    // DIE EINHEIT

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_erststimmen_vorlaeufig")
    private String dieeinheitErststimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_erststimmen_vorperiode")
    private String dieeinheitErststimmenVorperiode;

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_zweitstimmen_vorlaeufig")
    private String dieeinheitZweitstimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_zweitstimmen_vorperiode")
    private String dieeinheitZweitstimmenVorperiode;



    // Die Violetten

    /**
     * Die Violetten;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_erststimmen_vorlaeufig")
    private String dieviolettenErststimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_erststimmen_vorperiode")
    private String dieviolettenErststimmenVorperiode;

    /**
     * Die Violetten;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_zweitstimmen_vorlaeufig")
    private String dieviolettenZweitstimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_zweitstimmen_vorperiode")
    private String dieviolettenZweitstimmenVorperiode;



    // Familien-Partei Deutschlands

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "familie_erststimmen_vorlaeufig")
    private String familieErststimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "familie_erststimmen_vorperiode")
    private String familieErststimmenVorperiode;

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "familie_zweitstimmen_vorlaeufig")
    private String familieZweitstimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "familie_zweitstimmen_vorperiode")
    private String familieZweitstimmenVorperiode;



    // Feministische Partei DIE FRAUEN

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_erststimmen_vorlaeufig")
    private String diefrauenErststimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_erststimmen_vorperiode")
    private String diefrauenErststimmenVorperiode;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_zweitstimmen_vorlaeufig")
    private String diefrauenZweitstimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_zweitstimmen_vorperiode")
    private String diefrauenZweitstimmenVorperiode;



    // Mieterpartei

    /**
     * Mieterpartei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_erststimmen_vorlaeufig")
    private String mieterparteiErststimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_erststimmen_vorperiode")
    private String mieterparteiErststimmenVorperiode;

    /**
     * Mieterpartei;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_zweitstimmen_vorlaeufig")
    private String mieterparteiZweitstimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_zweitstimmen_vorperiode")
    private String mieterparteiZweitstimmenVorperiode;



    // Neue Liberale – Die Sozialliberalen

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_erststimmen_vorlaeufig")
    private String neueliberaleErststimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_erststimmen_vorperiode")
    private String neueliberaleErststimmenVorperiode;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_zweitstimmen_vorlaeufig")
    private String neueliberaleZweitstimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_zweitstimmen_vorperiode")
    private String neueliberaleZweitstimmenVorperiode;



    // UNABHÄNGIGE für bürgernahe Demokratie

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_erststimmen_vorlaeufig")
    private String unabhaengigeErststimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_erststimmen_vorperiode")
    private String unabhaengigeErststimmenVorperiode;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_zweitstimmen_vorlaeufig")
    private String unabhaengigeZweitstimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_zweitstimmen_vorperiode")
    private String unabhaengigeZweitstimmenVorperiode;



    // Übrige

    /**
     * Übrige;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "uebrige_erststimmen_vorlaeufig")
    private String uebrigeErststimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "uebrige_erststimmen_vorperiode")
    private String uebrigeErststimmenVorperiode;

    /**
     * Übrige;;;Vorläufig
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "uebrige_zweitstimmen_vorlaeufig")
    private String uebrigeZweitstimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    //@Digits(integer=10, fraction=0)
    @Property(name = "uebrige_zweitstimmen_vorperiode")
    private String uebrigeZweitstimmenVorperiode;

    public WahlergebnisseBtw17() {
    }

    public String getWahlberechtigteErststimmenVorlaeufig() {
        return wahlberechtigteErststimmenVorlaeufig;
    }

    public void setWahlberechtigteErststimmenVorlaeufig(String wahlberechtigteErststimmenVorlaeufig) {
        this.wahlberechtigteErststimmenVorlaeufig = wahlberechtigteErststimmenVorlaeufig;
    }

    public String getWahlberechtigteErststimmenVorperiode() {
        return wahlberechtigteErststimmenVorperiode;
    }

    public void setWahlberechtigteErststimmenVorperiode(String wahlberechtigteErststimmenVorperiode) {
        this.wahlberechtigteErststimmenVorperiode = wahlberechtigteErststimmenVorperiode;
    }

    public String getWahlberechtigteZweitstimmenVorlaeufig() {
        return wahlberechtigteZweitstimmenVorlaeufig;
    }

    public void setWahlberechtigteZweitstimmenVorlaeufig(String wahlberechtigteZweitstimmenVorlaeufig) {
        this.wahlberechtigteZweitstimmenVorlaeufig = wahlberechtigteZweitstimmenVorlaeufig;
    }

    public String getWahlberechtigteZweitstimmenVorperiode() {
        return wahlberechtigteZweitstimmenVorperiode;
    }

    public void setWahlberechtigteZweitstimmenVorperiode(String wahlberechtigteZweitstimmenVorperiode) {
        this.wahlberechtigteZweitstimmenVorperiode = wahlberechtigteZweitstimmenVorperiode;
    }

    public String getWaehlerErststimmenVorlaeufig() {
        return waehlerErststimmenVorlaeufig;
    }

    public void setWaehlerErststimmenVorlaeufig(String waehlerErststimmenVorlaeufig) {
        this.waehlerErststimmenVorlaeufig = waehlerErststimmenVorlaeufig;
    }

    public String getWaehlerErststimmenVorperiode() {
        return waehlerErststimmenVorperiode;
    }

    public void setWaehlerErststimmenVorperiode(String waehlerErststimmenVorperiode) {
        this.waehlerErststimmenVorperiode = waehlerErststimmenVorperiode;
    }

    public String getWaehlerZweitstimmenVorlaeufig() {
        return waehlerZweitstimmenVorlaeufig;
    }

    public void setWaehlerZweitstimmenVorlaeufig(String waehlerZweitstimmenVorlaeufig) {
        this.waehlerZweitstimmenVorlaeufig = waehlerZweitstimmenVorlaeufig;
    }

    public String getWaehlerZweitstimmenVorperiode() {
        return waehlerZweitstimmenVorperiode;
    }

    public void setWaehlerZweitstimmenVorperiode(String waehlerZweitstimmenVorperiode) {
        this.waehlerZweitstimmenVorperiode = waehlerZweitstimmenVorperiode;
    }

    public String getUngueltigeErststimmenVorlaeufig() {
        return ungueltigeErststimmenVorlaeufig;
    }

    public void setUngueltigeErststimmenVorlaeufig(String ungueltigeErststimmenVorlaeufig) {
        this.ungueltigeErststimmenVorlaeufig = ungueltigeErststimmenVorlaeufig;
    }

    public String getUngueltigeErststimmenVorperiode() {
        return ungueltigeErststimmenVorperiode;
    }

    public void setUngueltigeErststimmenVorperiode(String ungueltigeErststimmenVorperiode) {
        this.ungueltigeErststimmenVorperiode = ungueltigeErststimmenVorperiode;
    }

    public String getUngueltigeZweitstimmenVorlaeufig() {
        return ungueltigeZweitstimmenVorlaeufig;
    }

    public void setUngueltigeZweitstimmenVorlaeufig(String ungueltigeZweitstimmenVorlaeufig) {
        this.ungueltigeZweitstimmenVorlaeufig = ungueltigeZweitstimmenVorlaeufig;
    }

    public String getUngueltigeZweitstimmenVorperiode() {
        return ungueltigeZweitstimmenVorperiode;
    }

    public void setUngueltigeZweitstimmenVorperiode(String ungueltigeZweitstimmenVorperiode) {
        this.ungueltigeZweitstimmenVorperiode = ungueltigeZweitstimmenVorperiode;
    }

    public String getGueltigeErststimmenVorlaeufig() {
        return gueltigeErststimmenVorlaeufig;
    }

    public void setGueltigeErststimmenVorlaeufig(String gueltigeErststimmenVorlaeufig) {
        this.gueltigeErststimmenVorlaeufig = gueltigeErststimmenVorlaeufig;
    }

    public String getGueltigeErststimmenVorperiode() {
        return gueltigeErststimmenVorperiode;
    }

    public void setGueltigeErststimmenVorperiode(String gueltigeErststimmenVorperiode) {
        this.gueltigeErststimmenVorperiode = gueltigeErststimmenVorperiode;
    }

    public String getGueltigeZweitstimmenVorlaeufig() {
        return gueltigeZweitstimmenVorlaeufig;
    }

    public void setGueltigeZweitstimmenVorlaeufig(String gueltigeZweitstimmenVorlaeufig) {
        this.gueltigeZweitstimmenVorlaeufig = gueltigeZweitstimmenVorlaeufig;
    }

    public String getGueltigeZweitstimmenVorperiode() {
        return gueltigeZweitstimmenVorperiode;
    }

    public void setGueltigeZweitstimmenVorperiode(String gueltigeZweitstimmenVorperiode) {
        this.gueltigeZweitstimmenVorperiode = gueltigeZweitstimmenVorperiode;
    }

    public String getCduErststimmenVorlaeufig() {
        return cduErststimmenVorlaeufig;
    }

    public void setCduErststimmenVorlaeufig(String cduErststimmenVorlaeufig) {
        this.cduErststimmenVorlaeufig = cduErststimmenVorlaeufig;
    }

    public String getCduErststimmenVorperiode() {
        return cduErststimmenVorperiode;
    }

    public void setCduErststimmenVorperiode(String cduErststimmenVorperiode) {
        this.cduErststimmenVorperiode = cduErststimmenVorperiode;
    }

    public String getCduZweitstimmenVorlaeufig() {
        return cduZweitstimmenVorlaeufig;
    }

    public void setCduZweitstimmenVorlaeufig(String cduZweitstimmenVorlaeufig) {
        this.cduZweitstimmenVorlaeufig = cduZweitstimmenVorlaeufig;
    }

    public String getCduZweitstimmenVorperiode() {
        return cduZweitstimmenVorperiode;
    }

    public void setCduZweitstimmenVorperiode(String cduZweitstimmenVorperiode) {
        this.cduZweitstimmenVorperiode = cduZweitstimmenVorperiode;
    }

    public String getSpdErststimmenVorlaeufig() {
        return spdErststimmenVorlaeufig;
    }

    public void setSpdErststimmenVorlaeufig(String spdErststimmenVorlaeufig) {
        this.spdErststimmenVorlaeufig = spdErststimmenVorlaeufig;
    }

    public String getSpdErststimmenVorperiode() {
        return spdErststimmenVorperiode;
    }

    public void setSpdErststimmenVorperiode(String spdErststimmenVorperiode) {
        this.spdErststimmenVorperiode = spdErststimmenVorperiode;
    }

    public String getSpdZweitstimmenVorlaeufig() {
        return spdZweitstimmenVorlaeufig;
    }

    public void setSpdZweitstimmenVorlaeufig(String spdZweitstimmenVorlaeufig) {
        this.spdZweitstimmenVorlaeufig = spdZweitstimmenVorlaeufig;
    }

    public String getSpdZweitstimmenVorperiode() {
        return spdZweitstimmenVorperiode;
    }

    public void setSpdZweitstimmenVorperiode(String spdZweitstimmenVorperiode) {
        this.spdZweitstimmenVorperiode = spdZweitstimmenVorperiode;
    }

    public String getDielinkeErststimmenVorlaeufig() {
        return dielinkeErststimmenVorlaeufig;
    }

    public void setDielinkeErststimmenVorlaeufig(String dielinkeErststimmenVorlaeufig) {
        this.dielinkeErststimmenVorlaeufig = dielinkeErststimmenVorlaeufig;
    }

    public String getDielinkeErststimmenVorperiode() {
        return dielinkeErststimmenVorperiode;
    }

    public void setDielinkeErststimmenVorperiode(String dielinkeErststimmenVorperiode) {
        this.dielinkeErststimmenVorperiode = dielinkeErststimmenVorperiode;
    }

    public String getDielinkeZweitstimmenVorlaeufig() {
        return dielinkeZweitstimmenVorlaeufig;
    }

    public void setDielinkeZweitstimmenVorlaeufig(String dielinkeZweitstimmenVorlaeufig) {
        this.dielinkeZweitstimmenVorlaeufig = dielinkeZweitstimmenVorlaeufig;
    }

    public String getDielinkeZweitstimmenVorperiode() {
        return dielinkeZweitstimmenVorperiode;
    }

    public void setDielinkeZweitstimmenVorperiode(String dielinkeZweitstimmenVorperiode) {
        this.dielinkeZweitstimmenVorperiode = dielinkeZweitstimmenVorperiode;
    }

    public String getDiegruenenErststimmenVorlaeufig() {
        return diegruenenErststimmenVorlaeufig;
    }

    public void setDiegruenenErststimmenVorlaeufig(String diegruenenErststimmenVorlaeufig) {
        this.diegruenenErststimmenVorlaeufig = diegruenenErststimmenVorlaeufig;
    }

    public String getDiegruenenErststimmenVorperiode() {
        return diegruenenErststimmenVorperiode;
    }

    public void setDiegruenenErststimmenVorperiode(String diegruenenErststimmenVorperiode) {
        this.diegruenenErststimmenVorperiode = diegruenenErststimmenVorperiode;
    }

    public String getDiegruenenZweitstimmenVorlaeufig() {
        return diegruenenZweitstimmenVorlaeufig;
    }

    public void setDiegruenenZweitstimmenVorlaeufig(String diegruenenZweitstimmenVorlaeufig) {
        this.diegruenenZweitstimmenVorlaeufig = diegruenenZweitstimmenVorlaeufig;
    }

    public String getDiegruenenZweitstimmenVorperiode() {
        return diegruenenZweitstimmenVorperiode;
    }

    public void setDiegruenenZweitstimmenVorperiode(String diegruenenZweitstimmenVorperiode) {
        this.diegruenenZweitstimmenVorperiode = diegruenenZweitstimmenVorperiode;
    }

    public String getCsuErststimmenVorlaeufig() {
        return csuErststimmenVorlaeufig;
    }

    public void setCsuErststimmenVorlaeufig(String csuErststimmenVorlaeufig) {
        this.csuErststimmenVorlaeufig = csuErststimmenVorlaeufig;
    }

    public String getCsuErststimmenVorperiode() {
        return csuErststimmenVorperiode;
    }

    public void setCsuErststimmenVorperiode(String csuErststimmenVorperiode) {
        this.csuErststimmenVorperiode = csuErststimmenVorperiode;
    }

    public String getCsuZweitstimmenVorlaeufig() {
        return csuZweitstimmenVorlaeufig;
    }

    public void setCsuZweitstimmenVorlaeufig(String csuZweitstimmenVorlaeufig) {
        this.csuZweitstimmenVorlaeufig = csuZweitstimmenVorlaeufig;
    }

    public String getCsuZweitstimmenVorperiode() {
        return csuZweitstimmenVorperiode;
    }

    public void setCsuZweitstimmenVorperiode(String csuZweitstimmenVorperiode) {
        this.csuZweitstimmenVorperiode = csuZweitstimmenVorperiode;
    }

    public String getFdpErststimmenVorlaeufig() {
        return fdpErststimmenVorlaeufig;
    }

    public void setFdpErststimmenVorlaeufig(String fdpErststimmenVorlaeufig) {
        this.fdpErststimmenVorlaeufig = fdpErststimmenVorlaeufig;
    }

    public String getFdpErststimmenVorperiode() {
        return fdpErststimmenVorperiode;
    }

    public void setFdpErststimmenVorperiode(String fdpErststimmenVorperiode) {
        this.fdpErststimmenVorperiode = fdpErststimmenVorperiode;
    }

    public String getFdpZweitstimmenVorlaeufig() {
        return fdpZweitstimmenVorlaeufig;
    }

    public void setFdpZweitstimmenVorlaeufig(String fdpZweitstimmenVorlaeufig) {
        this.fdpZweitstimmenVorlaeufig = fdpZweitstimmenVorlaeufig;
    }

    public String getFdpZweitstimmenVorperiode() {
        return fdpZweitstimmenVorperiode;
    }

    public void setFdpZweitstimmenVorperiode(String fdpZweitstimmenVorperiode) {
        this.fdpZweitstimmenVorperiode = fdpZweitstimmenVorperiode;
    }

    public String getAfdErststimmenVorlaeufig() {
        return afdErststimmenVorlaeufig;
    }

    public void setAfdErststimmenVorlaeufig(String afdErststimmenVorlaeufig) {
        this.afdErststimmenVorlaeufig = afdErststimmenVorlaeufig;
    }

    public String getAfdErststimmenVorperiode() {
        return afdErststimmenVorperiode;
    }

    public void setAfdErststimmenVorperiode(String afdErststimmenVorperiode) {
        this.afdErststimmenVorperiode = afdErststimmenVorperiode;
    }

    public String getAfdZweitstimmenVorlaeufig() {
        return afdZweitstimmenVorlaeufig;
    }

    public void setAfdZweitstimmenVorlaeufig(String afdZweitstimmenVorlaeufig) {
        this.afdZweitstimmenVorlaeufig = afdZweitstimmenVorlaeufig;
    }

    public String getAfdZweitstimmenVorperiode() {
        return afdZweitstimmenVorperiode;
    }

    public void setAfdZweitstimmenVorperiode(String afdZweitstimmenVorperiode) {
        this.afdZweitstimmenVorperiode = afdZweitstimmenVorperiode;
    }

    public String getPiratenparteiErststimmenVorlaeufig() {
        return piratenparteiErststimmenVorlaeufig;
    }

    public void setPiratenparteiErststimmenVorlaeufig(String piratenparteiErststimmenVorlaeufig) {
        this.piratenparteiErststimmenVorlaeufig = piratenparteiErststimmenVorlaeufig;
    }

    public String getPiratenparteiErststimmenVorperiode() {
        return piratenparteiErststimmenVorperiode;
    }

    public void setPiratenparteiErststimmenVorperiode(String piratenparteiErststimmenVorperiode) {
        this.piratenparteiErststimmenVorperiode = piratenparteiErststimmenVorperiode;
    }

    public String getPiratenparteiZweitstimmenVorlaeufig() {
        return piratenparteiZweitstimmenVorlaeufig;
    }

    public void setPiratenparteiZweitstimmenVorlaeufig(String piratenparteiZweitstimmenVorlaeufig) {
        this.piratenparteiZweitstimmenVorlaeufig = piratenparteiZweitstimmenVorlaeufig;
    }

    public String getPiratenparteiZweitstimmenVorperiode() {
        return piratenparteiZweitstimmenVorperiode;
    }

    public void setPiratenparteiZweitstimmenVorperiode(String piratenparteiZweitstimmenVorperiode) {
        this.piratenparteiZweitstimmenVorperiode = piratenparteiZweitstimmenVorperiode;
    }

    public String getNpdErststimmenVorlaeufig() {
        return npdErststimmenVorlaeufig;
    }

    public void setNpdErststimmenVorlaeufig(String npdErststimmenVorlaeufig) {
        this.npdErststimmenVorlaeufig = npdErststimmenVorlaeufig;
    }

    public String getNpdErststimmenVorperiode() {
        return npdErststimmenVorperiode;
    }

    public void setNpdErststimmenVorperiode(String npdErststimmenVorperiode) {
        this.npdErststimmenVorperiode = npdErststimmenVorperiode;
    }

    public String getNpdZweitstimmenVorlaeufig() {
        return npdZweitstimmenVorlaeufig;
    }

    public void setNpdZweitstimmenVorlaeufig(String npdZweitstimmenVorlaeufig) {
        this.npdZweitstimmenVorlaeufig = npdZweitstimmenVorlaeufig;
    }

    public String getNpdZweitstimmenVorperiode() {
        return npdZweitstimmenVorperiode;
    }

    public void setNpdZweitstimmenVorperiode(String npdZweitstimmenVorperiode) {
        this.npdZweitstimmenVorperiode = npdZweitstimmenVorperiode;
    }

    public String getFreieWaehlerErststimmenVorlaeufig() {
        return freieWaehlerErststimmenVorlaeufig;
    }

    public void setFreieWaehlerErststimmenVorlaeufig(String freieWaehlerErststimmenVorlaeufig) {
        this.freieWaehlerErststimmenVorlaeufig = freieWaehlerErststimmenVorlaeufig;
    }

    public String getFreieWaehlerErststimmenVorperiode() {
        return freieWaehlerErststimmenVorperiode;
    }

    public void setFreieWaehlerErststimmenVorperiode(String freieWaehlerErststimmenVorperiode) {
        this.freieWaehlerErststimmenVorperiode = freieWaehlerErststimmenVorperiode;
    }

    public String getFreieWaehlerZweitstimmenVorlaeufig() {
        return freieWaehlerZweitstimmenVorlaeufig;
    }

    public void setFreieWaehlerZweitstimmenVorlaeufig(String freieWaehlerZweitstimmenVorlaeufig) {
        this.freieWaehlerZweitstimmenVorlaeufig = freieWaehlerZweitstimmenVorlaeufig;
    }

    public String getFreieWaehlerZweitstimmenVorperiode() {
        return freieWaehlerZweitstimmenVorperiode;
    }

    public void setFreieWaehlerZweitstimmenVorperiode(String freieWaehlerZweitstimmenVorperiode) {
        this.freieWaehlerZweitstimmenVorperiode = freieWaehlerZweitstimmenVorperiode;
    }

    public String getTierschutzparteiErststimmenVorlaeufig() {
        return tierschutzparteiErststimmenVorlaeufig;
    }

    public void setTierschutzparteiErststimmenVorlaeufig(String tierschutzparteiErststimmenVorlaeufig) {
        this.tierschutzparteiErststimmenVorlaeufig = tierschutzparteiErststimmenVorlaeufig;
    }

    public String getTierschutzparteiErststimmenVorperiode() {
        return tierschutzparteiErststimmenVorperiode;
    }

    public void setTierschutzparteiErststimmenVorperiode(String tierschutzparteiErststimmenVorperiode) {
        this.tierschutzparteiErststimmenVorperiode = tierschutzparteiErststimmenVorperiode;
    }

    public String getTierschutzparteiZweitstimmenVorlaeufig() {
        return tierschutzparteiZweitstimmenVorlaeufig;
    }

    public void setTierschutzparteiZweitstimmenVorlaeufig(String tierschutzparteiZweitstimmenVorlaeufig) {
        this.tierschutzparteiZweitstimmenVorlaeufig = tierschutzparteiZweitstimmenVorlaeufig;
    }

    public String getTierschutzparteiZweitstimmenVorperiode() {
        return tierschutzparteiZweitstimmenVorperiode;
    }

    public void setTierschutzparteiZweitstimmenVorperiode(String tierschutzparteiZweitstimmenVorperiode) {
        this.tierschutzparteiZweitstimmenVorperiode = tierschutzparteiZweitstimmenVorperiode;
    }

    public String getOedpErststimmenVorlaeufig() {
        return oedpErststimmenVorlaeufig;
    }

    public void setOedpErststimmenVorlaeufig(String oedpErststimmenVorlaeufig) {
        this.oedpErststimmenVorlaeufig = oedpErststimmenVorlaeufig;
    }

    public String getOedpErststimmenVorperiode() {
        return oedpErststimmenVorperiode;
    }

    public void setOedpErststimmenVorperiode(String oedpErststimmenVorperiode) {
        this.oedpErststimmenVorperiode = oedpErststimmenVorperiode;
    }

    public String getOedpZweitstimmenVorlaeufig() {
        return oedpZweitstimmenVorlaeufig;
    }

    public void setOedpZweitstimmenVorlaeufig(String oedpZweitstimmenVorlaeufig) {
        this.oedpZweitstimmenVorlaeufig = oedpZweitstimmenVorlaeufig;
    }

    public String getOedpZweitstimmenVorperiode() {
        return oedpZweitstimmenVorperiode;
    }

    public void setOedpZweitstimmenVorperiode(String oedpZweitstimmenVorperiode) {
        this.oedpZweitstimmenVorperiode = oedpZweitstimmenVorperiode;
    }

    public String getDieparteiErststimmenVorlaeufig() {
        return dieparteiErststimmenVorlaeufig;
    }

    public void setDieparteiErststimmenVorlaeufig(String dieparteiErststimmenVorlaeufig) {
        this.dieparteiErststimmenVorlaeufig = dieparteiErststimmenVorlaeufig;
    }

    public String getDieparteiErststimmenVorperiode() {
        return dieparteiErststimmenVorperiode;
    }

    public void setDieparteiErststimmenVorperiode(String dieparteiErststimmenVorperiode) {
        this.dieparteiErststimmenVorperiode = dieparteiErststimmenVorperiode;
    }

    public String getDieparteiZweitstimmenVorlaeufig() {
        return dieparteiZweitstimmenVorlaeufig;
    }

    public void setDieparteiZweitstimmenVorlaeufig(String dieparteiZweitstimmenVorlaeufig) {
        this.dieparteiZweitstimmenVorlaeufig = dieparteiZweitstimmenVorlaeufig;
    }

    public String getDieparteiZweitstimmenVorperiode() {
        return dieparteiZweitstimmenVorperiode;
    }

    public void setDieparteiZweitstimmenVorperiode(String dieparteiZweitstimmenVorperiode) {
        this.dieparteiZweitstimmenVorperiode = dieparteiZweitstimmenVorperiode;
    }

    public String getBayernparteiErststimmenVorlaeufig() {
        return bayernparteiErststimmenVorlaeufig;
    }

    public void setBayernparteiErststimmenVorlaeufig(String bayernparteiErststimmenVorlaeufig) {
        this.bayernparteiErststimmenVorlaeufig = bayernparteiErststimmenVorlaeufig;
    }

    public String getBayernparteiErststimmenVorperiode() {
        return bayernparteiErststimmenVorperiode;
    }

    public void setBayernparteiErststimmenVorperiode(String bayernparteiErststimmenVorperiode) {
        this.bayernparteiErststimmenVorperiode = bayernparteiErststimmenVorperiode;
    }

    public String getBayernparteiZweitstimmenVorlaeufig() {
        return bayernparteiZweitstimmenVorlaeufig;
    }

    public void setBayernparteiZweitstimmenVorlaeufig(String bayernparteiZweitstimmenVorlaeufig) {
        this.bayernparteiZweitstimmenVorlaeufig = bayernparteiZweitstimmenVorlaeufig;
    }

    public String getBayernparteiZweitstimmenVorperiode() {
        return bayernparteiZweitstimmenVorperiode;
    }

    public void setBayernparteiZweitstimmenVorperiode(String bayernparteiZweitstimmenVorperiode) {
        this.bayernparteiZweitstimmenVorperiode = bayernparteiZweitstimmenVorperiode;
    }

    public String getVolksabstimmungErststimmenVorlaeufig() {
        return volksabstimmungErststimmenVorlaeufig;
    }

    public void setVolksabstimmungErststimmenVorlaeufig(String volksabstimmungErststimmenVorlaeufig) {
        this.volksabstimmungErststimmenVorlaeufig = volksabstimmungErststimmenVorlaeufig;
    }

    public String getVolksabstimmungErststimmenVorperiode() {
        return volksabstimmungErststimmenVorperiode;
    }

    public void setVolksabstimmungErststimmenVorperiode(String volksabstimmungErststimmenVorperiode) {
        this.volksabstimmungErststimmenVorperiode = volksabstimmungErststimmenVorperiode;
    }

    public String getVolksabstimmungZweitstimmenVorlaeufig() {
        return volksabstimmungZweitstimmenVorlaeufig;
    }

    public void setVolksabstimmungZweitstimmenVorlaeufig(String volksabstimmungZweitstimmenVorlaeufig) {
        this.volksabstimmungZweitstimmenVorlaeufig = volksabstimmungZweitstimmenVorlaeufig;
    }

    public String getVolksabstimmungZweitstimmenVorperiode() {
        return volksabstimmungZweitstimmenVorperiode;
    }

    public void setVolksabstimmungZweitstimmenVorperiode(String volksabstimmungZweitstimmenVorperiode) {
        this.volksabstimmungZweitstimmenVorperiode = volksabstimmungZweitstimmenVorperiode;
    }

    public String getPdvErststimmenVorlaeufig() {
        return pdvErststimmenVorlaeufig;
    }

    public void setPdvErststimmenVorlaeufig(String pdvErststimmenVorlaeufig) {
        this.pdvErststimmenVorlaeufig = pdvErststimmenVorlaeufig;
    }

    public String getPdvErststimmenVorperiode() {
        return pdvErststimmenVorperiode;
    }

    public void setPdvErststimmenVorperiode(String pdvErststimmenVorperiode) {
        this.pdvErststimmenVorperiode = pdvErststimmenVorperiode;
    }

    public String getPdvZweitstimmenVorlaeufig() {
        return pdvZweitstimmenVorlaeufig;
    }

    public void setPdvZweitstimmenVorlaeufig(String pdvZweitstimmenVorlaeufig) {
        this.pdvZweitstimmenVorlaeufig = pdvZweitstimmenVorlaeufig;
    }

    public String getPdvZweitstimmenVorperiode() {
        return pdvZweitstimmenVorperiode;
    }

    public void setPdvZweitstimmenVorperiode(String pdvZweitstimmenVorperiode) {
        this.pdvZweitstimmenVorperiode = pdvZweitstimmenVorperiode;
    }

    public String getMlpdErststimmenVorlaeufig() {
        return mlpdErststimmenVorlaeufig;
    }

    public void setMlpdErststimmenVorlaeufig(String mlpdErststimmenVorlaeufig) {
        this.mlpdErststimmenVorlaeufig = mlpdErststimmenVorlaeufig;
    }

    public String getMlpdErststimmenVorperiode() {
        return mlpdErststimmenVorperiode;
    }

    public void setMlpdErststimmenVorperiode(String mlpdErststimmenVorperiode) {
        this.mlpdErststimmenVorperiode = mlpdErststimmenVorperiode;
    }

    public String getMlpdZweitstimmenVorlaeufig() {
        return mlpdZweitstimmenVorlaeufig;
    }

    public void setMlpdZweitstimmenVorlaeufig(String mlpdZweitstimmenVorlaeufig) {
        this.mlpdZweitstimmenVorlaeufig = mlpdZweitstimmenVorlaeufig;
    }

    public String getMlpdZweitstimmenVorperiode() {
        return mlpdZweitstimmenVorperiode;
    }

    public void setMlpdZweitstimmenVorperiode(String mlpdZweitstimmenVorperiode) {
        this.mlpdZweitstimmenVorperiode = mlpdZweitstimmenVorperiode;
    }

    public String getBuesoErststimmenVorlaeufig() {
        return buesoErststimmenVorlaeufig;
    }

    public void setBuesoErststimmenVorlaeufig(String buesoErststimmenVorlaeufig) {
        this.buesoErststimmenVorlaeufig = buesoErststimmenVorlaeufig;
    }

    public String getBuesoErststimmenVorperiode() {
        return buesoErststimmenVorperiode;
    }

    public void setBuesoErststimmenVorperiode(String buesoErststimmenVorperiode) {
        this.buesoErststimmenVorperiode = buesoErststimmenVorperiode;
    }

    public String getBuesoZweitstimmenVorlaeufig() {
        return buesoZweitstimmenVorlaeufig;
    }

    public void setBuesoZweitstimmenVorlaeufig(String buesoZweitstimmenVorlaeufig) {
        this.buesoZweitstimmenVorlaeufig = buesoZweitstimmenVorlaeufig;
    }

    public String getBuesoZweitstimmenVorperiode() {
        return buesoZweitstimmenVorperiode;
    }

    public void setBuesoZweitstimmenVorperiode(String buesoZweitstimmenVorperiode) {
        this.buesoZweitstimmenVorperiode = buesoZweitstimmenVorperiode;
    }

    public String getSgpErststimmenVorlaeufig() {
        return sgpErststimmenVorlaeufig;
    }

    public void setSgpErststimmenVorlaeufig(String sgpErststimmenVorlaeufig) {
        this.sgpErststimmenVorlaeufig = sgpErststimmenVorlaeufig;
    }

    public String getSgpErststimmenVorperiode() {
        return sgpErststimmenVorperiode;
    }

    public void setSgpErststimmenVorperiode(String sgpErststimmenVorperiode) {
        this.sgpErststimmenVorperiode = sgpErststimmenVorperiode;
    }

    public String getSgpZweitstimmenVorlaeufig() {
        return sgpZweitstimmenVorlaeufig;
    }

    public void setSgpZweitstimmenVorlaeufig(String sgpZweitstimmenVorlaeufig) {
        this.sgpZweitstimmenVorlaeufig = sgpZweitstimmenVorlaeufig;
    }

    public String getSgpZweitstimmenVorperiode() {
        return sgpZweitstimmenVorperiode;
    }

    public void setSgpZweitstimmenVorperiode(String sgpZweitstimmenVorperiode) {
        this.sgpZweitstimmenVorperiode = sgpZweitstimmenVorperiode;
    }

    public String getDierechteErststimmenVorlaeufig() {
        return dierechteErststimmenVorlaeufig;
    }

    public void setDierechteErststimmenVorlaeufig(String dierechteErststimmenVorlaeufig) {
        this.dierechteErststimmenVorlaeufig = dierechteErststimmenVorlaeufig;
    }

    public String getDierechteErststimmenVorperiode() {
        return dierechteErststimmenVorperiode;
    }

    public void setDierechteErststimmenVorperiode(String dierechteErststimmenVorperiode) {
        this.dierechteErststimmenVorperiode = dierechteErststimmenVorperiode;
    }

    public String getDierechteZweitstimmenVorlaeufig() {
        return dierechteZweitstimmenVorlaeufig;
    }

    public void setDierechteZweitstimmenVorlaeufig(String dierechteZweitstimmenVorlaeufig) {
        this.dierechteZweitstimmenVorlaeufig = dierechteZweitstimmenVorlaeufig;
    }

    public String getDierechteZweitstimmenVorperiode() {
        return dierechteZweitstimmenVorperiode;
    }

    public void setDierechteZweitstimmenVorperiode(String dierechteZweitstimmenVorperiode) {
        this.dierechteZweitstimmenVorperiode = dierechteZweitstimmenVorperiode;
    }

    public String getAddErststimmenVorlaeufig() {
        return addErststimmenVorlaeufig;
    }

    public void setAddErststimmenVorlaeufig(String addErststimmenVorlaeufig) {
        this.addErststimmenVorlaeufig = addErststimmenVorlaeufig;
    }

    public String getAddErststimmenVorperiode() {
        return addErststimmenVorperiode;
    }

    public void setAddErststimmenVorperiode(String addErststimmenVorperiode) {
        this.addErststimmenVorperiode = addErststimmenVorperiode;
    }

    public String getAddZweitstimmenVorlaeufig() {
        return addZweitstimmenVorlaeufig;
    }

    public void setAddZweitstimmenVorlaeufig(String addZweitstimmenVorlaeufig) {
        this.addZweitstimmenVorlaeufig = addZweitstimmenVorlaeufig;
    }

    public String getAddZweitstimmenVorperiode() {
        return addZweitstimmenVorperiode;
    }

    public void setAddZweitstimmenVorperiode(String addZweitstimmenVorperiode) {
        this.addZweitstimmenVorperiode = addZweitstimmenVorperiode;
    }

    public String getTierschutzallianzErststimmenVorlaeufig() {
        return tierschutzallianzErststimmenVorlaeufig;
    }

    public void setTierschutzallianzErststimmenVorlaeufig(String tierschutzallianzErststimmenVorlaeufig) {
        this.tierschutzallianzErststimmenVorlaeufig = tierschutzallianzErststimmenVorlaeufig;
    }

    public String getTierschutzallianzErststimmenVorperiode() {
        return tierschutzallianzErststimmenVorperiode;
    }

    public void setTierschutzallianzErststimmenVorperiode(String tierschutzallianzErststimmenVorperiode) {
        this.tierschutzallianzErststimmenVorperiode = tierschutzallianzErststimmenVorperiode;
    }

    public String getTierschutzallianzZweitstimmenVorlaeufig() {
        return tierschutzallianzZweitstimmenVorlaeufig;
    }

    public void setTierschutzallianzZweitstimmenVorlaeufig(String tierschutzallianzZweitstimmenVorlaeufig) {
        this.tierschutzallianzZweitstimmenVorlaeufig = tierschutzallianzZweitstimmenVorlaeufig;
    }

    public String getTierschutzallianzZweitstimmenVorperiode() {
        return tierschutzallianzZweitstimmenVorperiode;
    }

    public void setTierschutzallianzZweitstimmenVorperiode(String tierschutzallianzZweitstimmenVorperiode) {
        this.tierschutzallianzZweitstimmenVorperiode = tierschutzallianzZweitstimmenVorperiode;
    }

    public String getBergparteiErststimmenVorlaeufig() {
        return bergparteiErststimmenVorlaeufig;
    }

    public void setBergparteiErststimmenVorlaeufig(String bergparteiErststimmenVorlaeufig) {
        this.bergparteiErststimmenVorlaeufig = bergparteiErststimmenVorlaeufig;
    }

    public String getBergparteiErststimmenVorperiode() {
        return bergparteiErststimmenVorperiode;
    }

    public void setBergparteiErststimmenVorperiode(String bergparteiErststimmenVorperiode) {
        this.bergparteiErststimmenVorperiode = bergparteiErststimmenVorperiode;
    }

    public String getBergparteiZweitstimmenVorlaeufig() {
        return bergparteiZweitstimmenVorlaeufig;
    }

    public void setBergparteiZweitstimmenVorlaeufig(String bergparteiZweitstimmenVorlaeufig) {
        this.bergparteiZweitstimmenVorlaeufig = bergparteiZweitstimmenVorlaeufig;
    }

    public String getBergparteiZweitstimmenVorperiode() {
        return bergparteiZweitstimmenVorperiode;
    }

    public void setBergparteiZweitstimmenVorperiode(String bergparteiZweitstimmenVorperiode) {
        this.bergparteiZweitstimmenVorperiode = bergparteiZweitstimmenVorperiode;
    }

    public String getBgeErststimmenVorlaeufig() {
        return bgeErststimmenVorlaeufig;
    }

    public void setBgeErststimmenVorlaeufig(String bgeErststimmenVorlaeufig) {
        this.bgeErststimmenVorlaeufig = bgeErststimmenVorlaeufig;
    }

    public String getBgeErststimmenVorperiode() {
        return bgeErststimmenVorperiode;
    }

    public void setBgeErststimmenVorperiode(String bgeErststimmenVorperiode) {
        this.bgeErststimmenVorperiode = bgeErststimmenVorperiode;
    }

    public String getBgeZweitstimmenVorlaeufig() {
        return bgeZweitstimmenVorlaeufig;
    }

    public void setBgeZweitstimmenVorlaeufig(String bgeZweitstimmenVorlaeufig) {
        this.bgeZweitstimmenVorlaeufig = bgeZweitstimmenVorlaeufig;
    }

    public String getBgeZweitstimmenVorperiode() {
        return bgeZweitstimmenVorperiode;
    }

    public void setBgeZweitstimmenVorperiode(String bgeZweitstimmenVorperiode) {
        this.bgeZweitstimmenVorperiode = bgeZweitstimmenVorperiode;
    }

    public String getDibErststimmenVorlaeufig() {
        return dibErststimmenVorlaeufig;
    }

    public void setDibErststimmenVorlaeufig(String dibErststimmenVorlaeufig) {
        this.dibErststimmenVorlaeufig = dibErststimmenVorlaeufig;
    }

    public String getDibErststimmenVorperiode() {
        return dibErststimmenVorperiode;
    }

    public void setDibErststimmenVorperiode(String dibErststimmenVorperiode) {
        this.dibErststimmenVorperiode = dibErststimmenVorperiode;
    }

    public String getDibZweitstimmenVorlaeufig() {
        return dibZweitstimmenVorlaeufig;
    }

    public void setDibZweitstimmenVorlaeufig(String dibZweitstimmenVorlaeufig) {
        this.dibZweitstimmenVorlaeufig = dibZweitstimmenVorlaeufig;
    }

    public String getDibZweitstimmenVorperiode() {
        return dibZweitstimmenVorperiode;
    }

    public void setDibZweitstimmenVorperiode(String dibZweitstimmenVorperiode) {
        this.dibZweitstimmenVorperiode = dibZweitstimmenVorperiode;
    }

    public String getDkpErststimmenVorlaeufig() {
        return dkpErststimmenVorlaeufig;
    }

    public void setDkpErststimmenVorlaeufig(String dkpErststimmenVorlaeufig) {
        this.dkpErststimmenVorlaeufig = dkpErststimmenVorlaeufig;
    }

    public String getDkpErststimmenVorperiode() {
        return dkpErststimmenVorperiode;
    }

    public void setDkpErststimmenVorperiode(String dkpErststimmenVorperiode) {
        this.dkpErststimmenVorperiode = dkpErststimmenVorperiode;
    }

    public String getDkpZweitstimmenVorlaeufig() {
        return dkpZweitstimmenVorlaeufig;
    }

    public void setDkpZweitstimmenVorlaeufig(String dkpZweitstimmenVorlaeufig) {
        this.dkpZweitstimmenVorlaeufig = dkpZweitstimmenVorlaeufig;
    }

    public String getDkpZweitstimmenVorperiode() {
        return dkpZweitstimmenVorperiode;
    }

    public void setDkpZweitstimmenVorperiode(String dkpZweitstimmenVorperiode) {
        this.dkpZweitstimmenVorperiode = dkpZweitstimmenVorperiode;
    }

    public String getDmErststimmenVorlaeufig() {
        return dmErststimmenVorlaeufig;
    }

    public void setDmErststimmenVorlaeufig(String dmErststimmenVorlaeufig) {
        this.dmErststimmenVorlaeufig = dmErststimmenVorlaeufig;
    }

    public String getDmErststimmenVorperiode() {
        return dmErststimmenVorperiode;
    }

    public void setDmErststimmenVorperiode(String dmErststimmenVorperiode) {
        this.dmErststimmenVorperiode = dmErststimmenVorperiode;
    }

    public String getDmZweitstimmenVorlaeufig() {
        return dmZweitstimmenVorlaeufig;
    }

    public void setDmZweitstimmenVorlaeufig(String dmZweitstimmenVorlaeufig) {
        this.dmZweitstimmenVorlaeufig = dmZweitstimmenVorlaeufig;
    }

    public String getDmZweitstimmenVorperiode() {
        return dmZweitstimmenVorperiode;
    }

    public void setDmZweitstimmenVorperiode(String dmZweitstimmenVorperiode) {
        this.dmZweitstimmenVorperiode = dmZweitstimmenVorperiode;
    }

    public String getDiegrauenErststimmenVorlaeufig() {
        return diegrauenErststimmenVorlaeufig;
    }

    public void setDiegrauenErststimmenVorlaeufig(String diegrauenErststimmenVorlaeufig) {
        this.diegrauenErststimmenVorlaeufig = diegrauenErststimmenVorlaeufig;
    }

    public String getDiegrauenErststimmenVorperiode() {
        return diegrauenErststimmenVorperiode;
    }

    public void setDiegrauenErststimmenVorperiode(String diegrauenErststimmenVorperiode) {
        this.diegrauenErststimmenVorperiode = diegrauenErststimmenVorperiode;
    }

    public String getDiegrauenZweitstimmenVorlaeufig() {
        return diegrauenZweitstimmenVorlaeufig;
    }

    public void setDiegrauenZweitstimmenVorlaeufig(String diegrauenZweitstimmenVorlaeufig) {
        this.diegrauenZweitstimmenVorlaeufig = diegrauenZweitstimmenVorlaeufig;
    }

    public String getDiegrauenZweitstimmenVorperiode() {
        return diegrauenZweitstimmenVorperiode;
    }

    public void setDiegrauenZweitstimmenVorperiode(String diegrauenZweitstimmenVorperiode) {
        this.diegrauenZweitstimmenVorperiode = diegrauenZweitstimmenVorperiode;
    }

    public String getDuErststimmenVorlaeufig() {
        return duErststimmenVorlaeufig;
    }

    public void setDuErststimmenVorlaeufig(String duErststimmenVorlaeufig) {
        this.duErststimmenVorlaeufig = duErststimmenVorlaeufig;
    }

    public String getDuErststimmenVorperiode() {
        return duErststimmenVorperiode;
    }

    public void setDuErststimmenVorperiode(String duErststimmenVorperiode) {
        this.duErststimmenVorperiode = duErststimmenVorperiode;
    }

    public String getDuZweitstimmenVorlaeufig() {
        return duZweitstimmenVorlaeufig;
    }

    public void setDuZweitstimmenVorlaeufig(String duZweitstimmenVorlaeufig) {
        this.duZweitstimmenVorlaeufig = duZweitstimmenVorlaeufig;
    }

    public String getDuZweitstimmenVorperiode() {
        return duZweitstimmenVorperiode;
    }

    public void setDuZweitstimmenVorperiode(String duZweitstimmenVorperiode) {
        this.duZweitstimmenVorperiode = duZweitstimmenVorperiode;
    }

    public String getMgErststimmenVorlaeufig() {
        return mgErststimmenVorlaeufig;
    }

    public void setMgErststimmenVorlaeufig(String mgErststimmenVorlaeufig) {
        this.mgErststimmenVorlaeufig = mgErststimmenVorlaeufig;
    }

    public String getMgErststimmenVorperiode() {
        return mgErststimmenVorperiode;
    }

    public void setMgErststimmenVorperiode(String mgErststimmenVorperiode) {
        this.mgErststimmenVorperiode = mgErststimmenVorperiode;
    }

    public String getMgZweitstimmenVorlaeufig() {
        return mgZweitstimmenVorlaeufig;
    }

    public void setMgZweitstimmenVorlaeufig(String mgZweitstimmenVorlaeufig) {
        this.mgZweitstimmenVorlaeufig = mgZweitstimmenVorlaeufig;
    }

    public String getMgZweitstimmenVorperiode() {
        return mgZweitstimmenVorperiode;
    }

    public void setMgZweitstimmenVorperiode(String mgZweitstimmenVorperiode) {
        this.mgZweitstimmenVorperiode = mgZweitstimmenVorperiode;
    }

    public String getMenschlicheweltErststimmenVorlaeufig() {
        return menschlicheweltErststimmenVorlaeufig;
    }

    public void setMenschlicheweltErststimmenVorlaeufig(String menschlicheweltErststimmenVorlaeufig) {
        this.menschlicheweltErststimmenVorlaeufig = menschlicheweltErststimmenVorlaeufig;
    }

    public String getMenschlicheweltErststimmenVorperiode() {
        return menschlicheweltErststimmenVorperiode;
    }

    public void setMenschlicheweltErststimmenVorperiode(String menschlicheweltErststimmenVorperiode) {
        this.menschlicheweltErststimmenVorperiode = menschlicheweltErststimmenVorperiode;
    }

    public String getMenschlicheweltZweitstimmenVorlaeufig() {
        return menschlicheweltZweitstimmenVorlaeufig;
    }

    public void setMenschlicheweltZweitstimmenVorlaeufig(String menschlicheweltZweitstimmenVorlaeufig) {
        this.menschlicheweltZweitstimmenVorlaeufig = menschlicheweltZweitstimmenVorlaeufig;
    }

    public String getMenschlicheweltZweitstimmenVorperiode() {
        return menschlicheweltZweitstimmenVorperiode;
    }

    public void setMenschlicheweltZweitstimmenVorperiode(String menschlicheweltZweitstimmenVorperiode) {
        this.menschlicheweltZweitstimmenVorperiode = menschlicheweltZweitstimmenVorperiode;
    }

    public String getDiehumanistenErststimmenVorlaeufig() {
        return diehumanistenErststimmenVorlaeufig;
    }

    public void setDiehumanistenErststimmenVorlaeufig(String diehumanistenErststimmenVorlaeufig) {
        this.diehumanistenErststimmenVorlaeufig = diehumanistenErststimmenVorlaeufig;
    }

    public String getDiehumanistenErststimmenVorperiode() {
        return diehumanistenErststimmenVorperiode;
    }

    public void setDiehumanistenErststimmenVorperiode(String diehumanistenErststimmenVorperiode) {
        this.diehumanistenErststimmenVorperiode = diehumanistenErststimmenVorperiode;
    }

    public String getDiehumanistenZweitstimmenVorlaeufig() {
        return diehumanistenZweitstimmenVorlaeufig;
    }

    public void setDiehumanistenZweitstimmenVorlaeufig(String diehumanistenZweitstimmenVorlaeufig) {
        this.diehumanistenZweitstimmenVorlaeufig = diehumanistenZweitstimmenVorlaeufig;
    }

    public String getDiehumanistenZweitstimmenVorperiode() {
        return diehumanistenZweitstimmenVorperiode;
    }

    public void setDiehumanistenZweitstimmenVorperiode(String diehumanistenZweitstimmenVorperiode) {
        this.diehumanistenZweitstimmenVorperiode = diehumanistenZweitstimmenVorperiode;
    }

    public String getGesundheitsforschungErststimmenVorlaeufig() {
        return gesundheitsforschungErststimmenVorlaeufig;
    }

    public void setGesundheitsforschungErststimmenVorlaeufig(String gesundheitsforschungErststimmenVorlaeufig) {
        this.gesundheitsforschungErststimmenVorlaeufig = gesundheitsforschungErststimmenVorlaeufig;
    }

    public String getGesundheitsforschungErststimmenVorperiode() {
        return gesundheitsforschungErststimmenVorperiode;
    }

    public void setGesundheitsforschungErststimmenVorperiode(String gesundheitsforschungErststimmenVorperiode) {
        this.gesundheitsforschungErststimmenVorperiode = gesundheitsforschungErststimmenVorperiode;
    }

    public String getGesundheitsforschungZweitstimmenVorlaeufig() {
        return gesundheitsforschungZweitstimmenVorlaeufig;
    }

    public void setGesundheitsforschungZweitstimmenVorlaeufig(String gesundheitsforschungZweitstimmenVorlaeufig) {
        this.gesundheitsforschungZweitstimmenVorlaeufig = gesundheitsforschungZweitstimmenVorlaeufig;
    }

    public String getGesundheitsforschungZweitstimmenVorperiode() {
        return gesundheitsforschungZweitstimmenVorperiode;
    }

    public void setGesundheitsforschungZweitstimmenVorperiode(String gesundheitsforschungZweitstimmenVorperiode) {
        this.gesundheitsforschungZweitstimmenVorperiode = gesundheitsforschungZweitstimmenVorperiode;
    }

    public String getVparteiErststimmenVorlaeufig() {
        return vparteiErststimmenVorlaeufig;
    }

    public void setVparteiErststimmenVorlaeufig(String vparteiErststimmenVorlaeufig) {
        this.vparteiErststimmenVorlaeufig = vparteiErststimmenVorlaeufig;
    }

    public String getVparteiErststimmenVorperiode() {
        return vparteiErststimmenVorperiode;
    }

    public void setVparteiErststimmenVorperiode(String vparteiErststimmenVorperiode) {
        this.vparteiErststimmenVorperiode = vparteiErststimmenVorperiode;
    }

    public String getVparteiZweitstimmenVorlaeufig() {
        return vparteiZweitstimmenVorlaeufig;
    }

    public void setVparteiZweitstimmenVorlaeufig(String vparteiZweitstimmenVorlaeufig) {
        this.vparteiZweitstimmenVorlaeufig = vparteiZweitstimmenVorlaeufig;
    }

    public String getVparteiZweitstimmenVorperiode() {
        return vparteiZweitstimmenVorperiode;
    }

    public void setVparteiZweitstimmenVorperiode(String vparteiZweitstimmenVorperiode) {
        this.vparteiZweitstimmenVorperiode = vparteiZweitstimmenVorperiode;
    }

    public String getBuendniscErststimmenVorlaeufig() {
        return buendniscErststimmenVorlaeufig;
    }

    public void setBuendniscErststimmenVorlaeufig(String buendniscErststimmenVorlaeufig) {
        this.buendniscErststimmenVorlaeufig = buendniscErststimmenVorlaeufig;
    }

    public String getBuendniscErststimmenVorperiode() {
        return buendniscErststimmenVorperiode;
    }

    public void setBuendniscErststimmenVorperiode(String buendniscErststimmenVorperiode) {
        this.buendniscErststimmenVorperiode = buendniscErststimmenVorperiode;
    }

    public String getBuendniscZweitstimmenVorlaeufig() {
        return buendniscZweitstimmenVorlaeufig;
    }

    public void setBuendniscZweitstimmenVorlaeufig(String buendniscZweitstimmenVorlaeufig) {
        this.buendniscZweitstimmenVorlaeufig = buendniscZweitstimmenVorlaeufig;
    }

    public String getBuendniscZweitstimmenVorperiode() {
        return buendniscZweitstimmenVorperiode;
    }

    public void setBuendniscZweitstimmenVorperiode(String buendniscZweitstimmenVorperiode) {
        this.buendniscZweitstimmenVorperiode = buendniscZweitstimmenVorperiode;
    }

    public String getDieeinheitErststimmenVorlaeufig() {
        return dieeinheitErststimmenVorlaeufig;
    }

    public void setDieeinheitErststimmenVorlaeufig(String dieeinheitErststimmenVorlaeufig) {
        this.dieeinheitErststimmenVorlaeufig = dieeinheitErststimmenVorlaeufig;
    }

    public String getDieeinheitErststimmenVorperiode() {
        return dieeinheitErststimmenVorperiode;
    }

    public void setDieeinheitErststimmenVorperiode(String dieeinheitErststimmenVorperiode) {
        this.dieeinheitErststimmenVorperiode = dieeinheitErststimmenVorperiode;
    }

    public String getDieeinheitZweitstimmenVorlaeufig() {
        return dieeinheitZweitstimmenVorlaeufig;
    }

    public void setDieeinheitZweitstimmenVorlaeufig(String dieeinheitZweitstimmenVorlaeufig) {
        this.dieeinheitZweitstimmenVorlaeufig = dieeinheitZweitstimmenVorlaeufig;
    }

    public String getDieeinheitZweitstimmenVorperiode() {
        return dieeinheitZweitstimmenVorperiode;
    }

    public void setDieeinheitZweitstimmenVorperiode(String dieeinheitZweitstimmenVorperiode) {
        this.dieeinheitZweitstimmenVorperiode = dieeinheitZweitstimmenVorperiode;
    }

    public String getDieviolettenErststimmenVorlaeufig() {
        return dieviolettenErststimmenVorlaeufig;
    }

    public void setDieviolettenErststimmenVorlaeufig(String dieviolettenErststimmenVorlaeufig) {
        this.dieviolettenErststimmenVorlaeufig = dieviolettenErststimmenVorlaeufig;
    }

    public String getDieviolettenErststimmenVorperiode() {
        return dieviolettenErststimmenVorperiode;
    }

    public void setDieviolettenErststimmenVorperiode(String dieviolettenErststimmenVorperiode) {
        this.dieviolettenErststimmenVorperiode = dieviolettenErststimmenVorperiode;
    }

    public String getDieviolettenZweitstimmenVorlaeufig() {
        return dieviolettenZweitstimmenVorlaeufig;
    }

    public void setDieviolettenZweitstimmenVorlaeufig(String dieviolettenZweitstimmenVorlaeufig) {
        this.dieviolettenZweitstimmenVorlaeufig = dieviolettenZweitstimmenVorlaeufig;
    }

    public String getDieviolettenZweitstimmenVorperiode() {
        return dieviolettenZweitstimmenVorperiode;
    }

    public void setDieviolettenZweitstimmenVorperiode(String dieviolettenZweitstimmenVorperiode) {
        this.dieviolettenZweitstimmenVorperiode = dieviolettenZweitstimmenVorperiode;
    }

    public String getFamilieErststimmenVorlaeufig() {
        return familieErststimmenVorlaeufig;
    }

    public void setFamilieErststimmenVorlaeufig(String familieErststimmenVorlaeufig) {
        this.familieErststimmenVorlaeufig = familieErststimmenVorlaeufig;
    }

    public String getFamilieErststimmenVorperiode() {
        return familieErststimmenVorperiode;
    }

    public void setFamilieErststimmenVorperiode(String familieErststimmenVorperiode) {
        this.familieErststimmenVorperiode = familieErststimmenVorperiode;
    }

    public String getFamilieZweitstimmenVorlaeufig() {
        return familieZweitstimmenVorlaeufig;
    }

    public void setFamilieZweitstimmenVorlaeufig(String familieZweitstimmenVorlaeufig) {
        this.familieZweitstimmenVorlaeufig = familieZweitstimmenVorlaeufig;
    }

    public String getFamilieZweitstimmenVorperiode() {
        return familieZweitstimmenVorperiode;
    }

    public void setFamilieZweitstimmenVorperiode(String familieZweitstimmenVorperiode) {
        this.familieZweitstimmenVorperiode = familieZweitstimmenVorperiode;
    }

    public String getDiefrauenErststimmenVorlaeufig() {
        return diefrauenErststimmenVorlaeufig;
    }

    public void setDiefrauenErststimmenVorlaeufig(String diefrauenErststimmenVorlaeufig) {
        this.diefrauenErststimmenVorlaeufig = diefrauenErststimmenVorlaeufig;
    }

    public String getDiefrauenErststimmenVorperiode() {
        return diefrauenErststimmenVorperiode;
    }

    public void setDiefrauenErststimmenVorperiode(String diefrauenErststimmenVorperiode) {
        this.diefrauenErststimmenVorperiode = diefrauenErststimmenVorperiode;
    }

    public String getDiefrauenZweitstimmenVorlaeufig() {
        return diefrauenZweitstimmenVorlaeufig;
    }

    public void setDiefrauenZweitstimmenVorlaeufig(String diefrauenZweitstimmenVorlaeufig) {
        this.diefrauenZweitstimmenVorlaeufig = diefrauenZweitstimmenVorlaeufig;
    }

    public String getDiefrauenZweitstimmenVorperiode() {
        return diefrauenZweitstimmenVorperiode;
    }

    public void setDiefrauenZweitstimmenVorperiode(String diefrauenZweitstimmenVorperiode) {
        this.diefrauenZweitstimmenVorperiode = diefrauenZweitstimmenVorperiode;
    }

    public String getMieterparteiErststimmenVorlaeufig() {
        return mieterparteiErststimmenVorlaeufig;
    }

    public void setMieterparteiErststimmenVorlaeufig(String mieterparteiErststimmenVorlaeufig) {
        this.mieterparteiErststimmenVorlaeufig = mieterparteiErststimmenVorlaeufig;
    }

    public String getMieterparteiErststimmenVorperiode() {
        return mieterparteiErststimmenVorperiode;
    }

    public void setMieterparteiErststimmenVorperiode(String mieterparteiErststimmenVorperiode) {
        this.mieterparteiErststimmenVorperiode = mieterparteiErststimmenVorperiode;
    }

    public String getMieterparteiZweitstimmenVorlaeufig() {
        return mieterparteiZweitstimmenVorlaeufig;
    }

    public void setMieterparteiZweitstimmenVorlaeufig(String mieterparteiZweitstimmenVorlaeufig) {
        this.mieterparteiZweitstimmenVorlaeufig = mieterparteiZweitstimmenVorlaeufig;
    }

    public String getMieterparteiZweitstimmenVorperiode() {
        return mieterparteiZweitstimmenVorperiode;
    }

    public void setMieterparteiZweitstimmenVorperiode(String mieterparteiZweitstimmenVorperiode) {
        this.mieterparteiZweitstimmenVorperiode = mieterparteiZweitstimmenVorperiode;
    }

    public String getNeueliberaleErststimmenVorlaeufig() {
        return neueliberaleErststimmenVorlaeufig;
    }

    public void setNeueliberaleErststimmenVorlaeufig(String neueliberaleErststimmenVorlaeufig) {
        this.neueliberaleErststimmenVorlaeufig = neueliberaleErststimmenVorlaeufig;
    }

    public String getNeueliberaleErststimmenVorperiode() {
        return neueliberaleErststimmenVorperiode;
    }

    public void setNeueliberaleErststimmenVorperiode(String neueliberaleErststimmenVorperiode) {
        this.neueliberaleErststimmenVorperiode = neueliberaleErststimmenVorperiode;
    }

    public String getNeueliberaleZweitstimmenVorlaeufig() {
        return neueliberaleZweitstimmenVorlaeufig;
    }

    public void setNeueliberaleZweitstimmenVorlaeufig(String neueliberaleZweitstimmenVorlaeufig) {
        this.neueliberaleZweitstimmenVorlaeufig = neueliberaleZweitstimmenVorlaeufig;
    }

    public String getNeueliberaleZweitstimmenVorperiode() {
        return neueliberaleZweitstimmenVorperiode;
    }

    public void setNeueliberaleZweitstimmenVorperiode(String neueliberaleZweitstimmenVorperiode) {
        this.neueliberaleZweitstimmenVorperiode = neueliberaleZweitstimmenVorperiode;
    }

    public String getUnabhaengigeErststimmenVorlaeufig() {
        return unabhaengigeErststimmenVorlaeufig;
    }

    public void setUnabhaengigeErststimmenVorlaeufig(String unabhaengigeErststimmenVorlaeufig) {
        this.unabhaengigeErststimmenVorlaeufig = unabhaengigeErststimmenVorlaeufig;
    }

    public String getUnabhaengigeErststimmenVorperiode() {
        return unabhaengigeErststimmenVorperiode;
    }

    public void setUnabhaengigeErststimmenVorperiode(String unabhaengigeErststimmenVorperiode) {
        this.unabhaengigeErststimmenVorperiode = unabhaengigeErststimmenVorperiode;
    }

    public String getUnabhaengigeZweitstimmenVorlaeufig() {
        return unabhaengigeZweitstimmenVorlaeufig;
    }

    public void setUnabhaengigeZweitstimmenVorlaeufig(String unabhaengigeZweitstimmenVorlaeufig) {
        this.unabhaengigeZweitstimmenVorlaeufig = unabhaengigeZweitstimmenVorlaeufig;
    }

    public String getUnabhaengigeZweitstimmenVorperiode() {
        return unabhaengigeZweitstimmenVorperiode;
    }

    public void setUnabhaengigeZweitstimmenVorperiode(String unabhaengigeZweitstimmenVorperiode) {
        this.unabhaengigeZweitstimmenVorperiode = unabhaengigeZweitstimmenVorperiode;
    }

    public String getUebrigeErststimmenVorlaeufig() {
        return uebrigeErststimmenVorlaeufig;
    }

    public void setUebrigeErststimmenVorlaeufig(String uebrigeErststimmenVorlaeufig) {
        this.uebrigeErststimmenVorlaeufig = uebrigeErststimmenVorlaeufig;
    }

    public String getUebrigeErststimmenVorperiode() {
        return uebrigeErststimmenVorperiode;
    }

    public void setUebrigeErststimmenVorperiode(String uebrigeErststimmenVorperiode) {
        this.uebrigeErststimmenVorperiode = uebrigeErststimmenVorperiode;
    }

    public String getUebrigeZweitstimmenVorlaeufig() {
        return uebrigeZweitstimmenVorlaeufig;
    }

    public void setUebrigeZweitstimmenVorlaeufig(String uebrigeZweitstimmenVorlaeufig) {
        this.uebrigeZweitstimmenVorlaeufig = uebrigeZweitstimmenVorlaeufig;
    }

    public String getUebrigeZweitstimmenVorperiode() {
        return uebrigeZweitstimmenVorperiode;
    }

    public void setUebrigeZweitstimmenVorperiode(String uebrigeZweitstimmenVorperiode) {
        this.uebrigeZweitstimmenVorperiode = uebrigeZweitstimmenVorperiode;
    }
}
