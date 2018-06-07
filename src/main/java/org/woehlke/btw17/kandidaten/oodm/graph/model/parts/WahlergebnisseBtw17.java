package org.woehlke.btw17.kandidaten.oodm.graph.model.parts;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;

//import javax.validation.constraints.Digits;

@Setter
@Getter
@NodeEntity
public class WahlergebnisseBtw17 implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return " name ";
    }

    @Override
    public String getUniqueId() {
        return ""+id;
    }
}
