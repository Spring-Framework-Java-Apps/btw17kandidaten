package org.woehlke.btw17.kandidaten.oodm.graph.model.parts;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;

import javax.validation.constraints.Digits;

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
    @Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_erststimmen_vorlaeufig")
    private Long wahlberechtigteErststimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_erststimmen_vorperiode")
    private Long wahlberechtigteErststimmenVorperiode;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_zweitstimmen_vorlaeufig")
    private Long wahlberechtigteZweitstimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "wahlberechtigte_zweitstimmen_vorperiode")
    private Long wahlberechtigteZweitstimmenVorperiode;


    // Wähler

    /**
     * Wähler;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "waehler_erststimmen_vorlaeufig")
    private Long waehlerErststimmenVorlaeufig;

    /**
     * Wähler;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "waehler_erststimmen_vorperiode")
    private Long waehlerErststimmenVorperiode;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "waehler_zweitstimmen_vorlaeufig")
    private Long waehlerZweitstimmenVorlaeufig;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "waehler_zweitstimmen_vorperiode")
    private Long waehlerZweitstimmenVorperiode;


    // Ungültige

    /**
     * Ungültige;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_erststimmen_vorlaeufig")
    private Long ungueltigeErststimmenVorlaeufig;

    /**
     * Ungültige;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_erststimmen_vorperiode")
    private Long ungueltigeErststimmenVorperiode;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_zweitstimmen_vorlaeufig")
    private Long ungueltigeZweitstimmenVorlaeufig;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "ungueltige_zweitstimmen_vorperiode")
    private Long ungueltigeZweitstimmenVorperiode;


    // Gültige

    /**
     * Gültige;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "gueltige_erststimmen_vorlaeufig")
    private Long gueltigeErststimmenVorlaeufig;

    /**
     * Gültige;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "gueltige_erststimmen_vorperiode")
    private Long gueltigeErststimmenVorperiode;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "gueltige_zweitstimmen_vorlaeufig")
    private Long gueltigeZweitstimmenVorlaeufig;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "ueltige_zweitstimmen_vorperiode")
    private Long gueltigeZweitstimmenVorperiode;


    // Christlich Demokratische Union Deutschlands

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "cdu_erststimmen_vorlaeufig")
    private Long cduErststimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "cdu_erststimmen_vorperiode")
    private Long cduErststimmenVorperiode;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "cdu_zweitstimmen_vorlaeufig")
    private Long cduZweitstimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "cdu_zweitstimmen_vorperiode")
    private Long cduZweitstimmenVorperiode;


    // Sozialdemokratische Partei Deutschlands

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "spd_erststimmen_vorlaeufig")
    private Long spdErststimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "spd_erststimmen_vorperiode")
    private Long spdErststimmenVorperiode;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "spd_zweitstimmen_vorlaeufig")
    private Long spdZweitstimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "spd_zweitstimmen_vorperiode")
    private Long spdZweitstimmenVorperiode;


    // DIE LINKE

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dielinke_erststimmen_vorlaeufig")
    private Long dielinkeErststimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dielinke_erststimmen_vorperiode")
    private Long dielinkeErststimmenVorperiode;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dielinke_zweitstimmen_vorlaeufig")
    private Long dielinkeZweitstimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dielinke_zweitstimmen_vorperiode")
    private Long dielinkeZweitstimmenVorperiode;


    // BÜNDNIS 90/DIE GRÜNEN

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_erststimmen_vorlaeufig")
    private Long diegruenenErststimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_erststimmen_vorperiode")
    private Long diegruenenErststimmenVorperiode;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_zweitstimmen_vorlaeufig")
    private Long diegruenenZweitstimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegruenen_zweitstimmen_vorperiode")
    private Long diegruenenZweitstimmenVorperiode;


    // Christlich-Soziale Union in Bayern e.V.

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "csu_erststimmen_vorlaeufig")
    private Long csuErststimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "csu_erststimmen_vorperiode")
    private Long csuErststimmenVorperiode;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "csu_zweitstimmen_vorlaeufig")
    private Long csuZweitstimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "csu_zweitstimmen_vorperiode")
    private Long csuZweitstimmenVorperiode;


    // Freie Demokratische Partei

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "fdp_erststimmen_vorlaeufig")
    private Long fdpErststimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "fdp_erststimmen_vorperiode")
    private Long fdpErststimmenVorperiode;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "fdp_zweitstimmen_vorlaeufig")
    private Long fdpZweitstimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "fdp_zweitstimmen_vorperiode")
    private Long fdpZweitstimmenVorperiode;


    // Alternative für Deutschland

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "afd_erststimmen_vorlaeufig")
    private Long afdErststimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "afd_erststimmen_vorperiode")
    private Long afdErststimmenVorperiode;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "afd_zweitstimmen_vorlaeufig")
    private Long afdZweitstimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "afd_zweitstimmen_vorperiode")
    private Long afdZweitstimmenVorperiode;


    // Piratenpartei Deutschland

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_erststimmen_vorlaeufig")
    private Long piratenparteiErststimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_erststimmen_vorperiode")
    private Long piratenparteiErststimmenVorperiode;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_zweitstimmen_vorlaeufig")
    private Long piratenparteiZweitstimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "piratenpartei_zweitstimmen_vorperiode")
    private Long piratenparteiZweitstimmenVorperiode;


    // Nationaldemokratische Partei Deutschlands

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "npd_erststimmen_vorlaeufig")
    private Long npdErststimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "npd_erststimmen_vorperiode")
    private Long npdErststimmenVorperiode;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "npd_zweitstimmen_vorlaeufig")
    private Long npdZweitstimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "npd_zweitstimmen_vorperiode")
    private Long npdZweitstimmenVorperiode;


    // FREIE WÄHLER

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_erststimmen_vorlaeufig")
    private Long freieWaehlerErststimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_erststimmen_vorperiode")
    private Long freieWaehlerErststimmenVorperiode;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_zweitstimmen_vorlaeufig")
    private Long freieWaehlerZweitstimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "freiewaehler_zweitstimmen_vorperiode")
    private Long freieWaehlerZweitstimmenVorperiode;


    // PARTEI MENSCH UMWELT TIERSCHUTZ

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_erststimmen_vorlaeufig")
    private Long tierschutzparteiErststimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_erststimmen_vorperiode")
    private Long tierschutzparteiErststimmenVorperiode;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_zweitstimmen_vorlaeufig")
    private Long tierschutzparteiZweitstimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzpartei_zweitstimmen_vorperiode")
    private Long tierschutzparteiZweitstimmenVorperiode;



    // Ökologisch-Demokratische Partei

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "oedp_erststimmen_vorlaeufig")
    private Long oedpErststimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "oedp_erststimmen_vorperiode")
    private Long oedpErststimmenVorperiode;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "oedp_zweitstimmen_vorlaeufig")
    private Long oedpZweitstimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "oedp_zweitstimmen_vorperiode")
    private Long oedpZweitstimmenVorperiode;



    // Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diepartei_erststimmen_vorlaeufig")
    private Long dieparteiErststimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diepartei_erststimmen_vorperiode")
    private Long dieparteiErststimmenVorperiode;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diepartei_zweitstimmen_vorlaeufig")
    private Long dieparteiZweitstimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diepartei_zweitstimmen_vorperiode")
    private Long dieparteiZweitstimmenVorperiode;



    // Bayernpartei

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_erststimmen_vorlaeufig")
    private Long bayernparteiErststimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_erststimmen_vorperiode")
    private Long bayernparteiErststimmenVorperiode;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_zweitstimmen_vorlaeufig")
    private Long bayernparteiZweitstimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bayernpartei_zweitstimmen_vorperiode")
    private Long bayernparteiZweitstimmenVorperiode;



    // Ab jetzt...Demokratie durch Volksabstimmung

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_erststimmen_vorlaeufig")
    private Long volksabstimmungErststimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_erststimmen_vorperiode")
    private Long volksabstimmungErststimmenVorperiode;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_zweitstimmen_vorlaeufig")
    private Long volksabstimmungZweitstimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "volksabstimmung_zweitstimmen_vorperiode")
    private Long volksabstimmungZweitstimmenVorperiode;


    // Partei der Vernunft

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "pdv_erststimmen_vorlaeufig")
    private Long pdvErststimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "pdv_erststimmen_vorperiode")
    private Long pdvErststimmenVorperiode;

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "pdv_zweitstimmen_vorlaeufig")
    private Long pdvZweitstimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "pdv_zweitstimmen_vorperiode")
    private Long pdvZweitstimmenVorperiode;


    // Marxistisch-Leninistische Partei Deutschlands

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mlpd_erststimmen_vorlaeufig")
    private Long mlpdErststimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mlpd_erststimmen_vorperiode")
    private Long mlpdErststimmenVorperiode;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mlpd_zweitstimmen_vorlaeufig")
    private Long mlpdZweitstimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mlpd_zweitstimmen_vorperiode")
    private Long mlpdZweitstimmenVorperiode;


    // Bürgerrechtsbewegung Solidarität

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bueso_erststimmen_vorlaeufig")
    private Long buesoErststimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bueso_erststimmen_vorperiode")
    private Long buesoErststimmenVorperiode;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bueso_zweitstimmen_vorlaeufig")
    private Long buesoZweitstimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bueso_zweitstimmen_vorperiode")
    private Long buesoZweitstimmenVorperiode;


    // Sozialistische Gleichheitspartei, Vierte Internationale

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "sgp_erststimmen_vorlaeufig")
    private Long sgpErststimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "sgp_erststimmen_vorperiode")
    private Long sgpErststimmenVorperiode;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "sgp_zweitstimmen_vorlaeufig")
    private Long sgpZweitstimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "sgp_zweitstimmen_vorperiode")
    private Long sgpZweitstimmenVorperiode;


    // DIE RECHTE

    /**
     * DIE RECHTE;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dierechte_erststimmen_vorlaeufig")
    private Long dierechteErststimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dierechte_erststimmen_vorperiode")
    private Long dierechteErststimmenVorperiode;

    /**
     * DIE RECHTE;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dierechte_zweitstimmen_vorlaeufig")
    private Long dierechteZweitstimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dierechte_zweitstimmen_vorperiode")
    private Long dierechteZweitstimmenVorperiode;


    // Allianz Deutscher Demokraten

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "add_erststimmen_vorlaeufig")
    private Long addErststimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "add_erststimmen_vorperiode")
    private Long addErststimmenVorperiode;

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "add_zweitstimmen_vorlaeufig")
    private Long addZweitstimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "add_zweitstimmen_vorperiode")
    private Long addZweitstimmenVorperiode;


    // Allianz für Menschenrechte, Tier- und Naturschutz

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_erststimmen_vorlaeufig")
    private Long tierschutzallianzErststimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_erststimmen_vorperiode")
    private Long tierschutzallianzErststimmenVorperiode;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_zweitstimmen_vorlaeufig")
    private Long tierschutzallianzZweitstimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "tierschutzallianz_zweitstimmen_vorperiode")
    private Long tierschutzallianzZweitstimmenVorperiode;


    // bergpartei, die überpartei

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bergpartei_erststimmen_vorlaeufig")
    private Long bergparteiErststimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bergpartei_erststimmen_vorperiode")
    private Long bergparteiErststimmenVorperiode;

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    @Property(name = "bergpartei_zweitstimmen_vorlaeufig")
    private Long bergparteiZweitstimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bergpartei_zweitstimmen_vorperiode")
    private Long bergparteiZweitstimmenVorperiode;


    // Bündnis Grundeinkommen

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bge_erststimmen_vorlaeufig")
    private Long bgeErststimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    @Property(name = "bge_erststimmen_vorperiode")
    private Long bgeErststimmenVorperiode;

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bge_zweitstimmen_vorlaeufig")
    private Long bgeZweitstimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "bge_zweitstimmen_vorperiode")
    private Long bgeZweitstimmenVorperiode;


    // DEMOKRATIE IN BEWEGUNG

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dib_erststimmen_vorlaeufig")
    private Long dibErststimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dib_erststimmen_vorperiode")
    private Long dibErststimmenVorperiode;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dib_zweitstimmen_vorlaeufig")
    private Long dibZweitstimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dib_zweitstimmen_vorperiode")
    private Long dibZweitstimmenVorperiode;


    // Deutsche Kommunistische Partei

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dkp_erststimmen_vorlaeufig")
    private Long dkpErststimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dkp_erststimmen_vorperiode")
    private Long dkpErststimmenVorperiode;

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dkp_zweitstimmen_vorlaeufig")
    private Long dkpZweitstimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dkp_zweitstimmen_vorperiode")
    private Long dkpZweitstimmenVorperiode;


    // Deutsche Mitte

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dm_erststimmen_vorlaeufig")
    private Long dmErststimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dm_erststimmen_vorperiode")
    private Long dmErststimmenVorperiode;

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dm_zweitstimmen_vorlaeufig")
    private Long dmZweitstimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dm_zweitstimmen_vorperiode")
    private Long dmZweitstimmenVorperiode;



    // Die Grauen – Für alle Generationen

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_erststimmen_vorlaeufig")
    private Long diegrauenErststimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_erststimmen_vorperiode")
    private Long diegrauenErststimmenVorperiode;

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_zweitstimmen_vorlaeufig")
    private Long diegrauenZweitstimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diegrauen_zweitstimmen_vorperiode")
    private Long  diegrauenZweitstimmenVorperiode;



    // Die Urbane. Eine HipHop Partei

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "du_erststimmen_vorlaeufig")
    private Long duErststimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "du_erststimmen_vorperiode")
    private Long duErststimmenVorperiode;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "du_zweitstimmen_vorlaeufig")
    private Long duZweitstimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "du_zweitstimmen_vorperiode")
    private Long duZweitstimmenVorperiode;



    // Madgeburger Gartenpartei

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mg_erststimmen_vorlaeufig")
    private Long mgErststimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mg_erststimmen_vorperiode")
    private Long mgErststimmenVorperiode;

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mg_zweitstimmen_vorlaeufig")
    private Long mgZweitstimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mg_zweitstimmen_vorperiode")
    private Long mgZweitstimmenVorperiode;



    // Menschliche Welt

    /**
     * Menschliche Welt;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_erststimmen_vorlaeufig")
    private Long menschlicheweltErststimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_erststimmen_vorperiode")
    private Long menschlicheweltErststimmenVorperiode;

    /**
     * Menschliche Welt;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_zweitstimmen_vorlaeufig")
    private Long menschlicheweltZweitstimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "menschlichewelt_zweitstimmen_vorperiode")
    private Long menschlicheweltZweitstimmenVorperiode;



    // Partei der Humanisten

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_erststimmen_vorlaeufig")
    private Long diehumanistenErststimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_erststimmen_vorperiode")
    private Long diehumanistenErststimmenVorperiode;

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_zweitstimmen_vorlaeufig")
    private Long diehumanistenZweitstimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diehumanisten_zweitstimmen_vorperiode")
    private Long diehumanistenZweitstimmenVorperiode;



    // Partei für Gesundheitsforschung

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_erststimmen_vorlaeufig")
    private Long gesundheitsforschungErststimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_erststimmen_vorperiode")
    private Long gesundheitsforschungErststimmenVorperiode;

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_zweitstimmen_vorlaeufig")
    private Long gesundheitsforschungZweitstimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "gesundheitsforschung_zweitstimmen_vorperiode")
    private Long gesundheitsforschungZweitstimmenVorperiode;



    // V-Partei³ - Partei für Veränderung, Vegetarier und Veganer

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "vpartei_erststimmen_vorlaeufig")
    private Long vparteiErststimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "vpartei_erststimmen_vorperiode")
    private Long vparteiErststimmenVorperiode;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "vpartei_zweitstimmen_vorlaeufig")
    private Long vparteiZweitstimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "vpartei_zweitstimmen_vorperiode")
    private Long vparteiZweitstimmenVorperiode;



    // Bündnis C - Christen für Deutschland

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "buendnisc_erststimmen_vorlaeufig")
    private Long buendniscErststimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "buendnisc_erststimmen_vorperiode")
    private Long buendniscErststimmenVorperiode;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    @Property(name = "buendnisc_zweitstimmen_vorlaeufig")
    private Long buendniscZweitstimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "buendnisc_zweitstimmen_vorperiode")
    private Long buendniscZweitstimmenVorperiode;



    // DIE EINHEIT

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_erststimmen_vorlaeufig")
    private Long dieeinheitErststimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_erststimmen_vorperiode")
    private Long dieeinheitErststimmenVorperiode;

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_zweitstimmen_vorlaeufig")
    private Long dieeinheitZweitstimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dieeinheit_zweitstimmen_vorperiode")
    private Long dieeinheitZweitstimmenVorperiode;



    // Die Violetten

    /**
     * Die Violetten;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_erststimmen_vorlaeufig")
    private Long dieviolettenErststimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_erststimmen_vorperiode")
    private Long dieviolettenErststimmenVorperiode;

    /**
     * Die Violetten;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_zweitstimmen_vorlaeufig")
    private Long dieviolettenZweitstimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "dievioletten_zweitstimmen_vorperiode")
    private Long dieviolettenZweitstimmenVorperiode;



    // Familien-Partei Deutschlands

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "familie_erststimmen_vorlaeufig")
    private Long familieErststimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "familie_erststimmen_vorperiode")
    private Long familieErststimmenVorperiode;

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "familie_zweitstimmen_vorlaeufig")
    private Long familieZweitstimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "familie_zweitstimmen_vorperiode")
    private Long familieZweitstimmenVorperiode;



    // Feministische Partei DIE FRAUEN

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_erststimmen_vorlaeufig")
    private Long diefrauenErststimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_erststimmen_vorperiode")
    private Long diefrauenErststimmenVorperiode;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_zweitstimmen_vorlaeufig")
    private Long diefrauenZweitstimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "diefrauen_zweitstimmen_vorperiode")
    private Long diefrauenZweitstimmenVorperiode;



    // Mieterpartei

    /**
     * Mieterpartei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_erststimmen_vorlaeufig")
    private Long mieterparteiErststimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_erststimmen_vorperiode")
    private Long mieterparteiErststimmenVorperiode;

    /**
     * Mieterpartei;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_zweitstimmen_vorlaeufig")
    private Long mieterparteiZweitstimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "mieterpartei_zweitstimmen_vorperiode")
    private Long mieterparteiZweitstimmenVorperiode;



    // Neue Liberale – Die Sozialliberalen

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_erststimmen_vorlaeufig")
    private Long neueliberaleErststimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_erststimmen_vorperiode")
    private Long neueliberaleErststimmenVorperiode;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_zweitstimmen_vorlaeufig")
    private Long neueliberaleZweitstimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "neueliberale_zweitstimmen_vorperiode")
    private Long neueliberaleZweitstimmenVorperiode;



    // UNABHÄNGIGE für bürgernahe Demokratie

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_erststimmen_vorlaeufig")
    private Long unabhaengigeErststimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_erststimmen_vorperiode")
    private Long unabhaengigeErststimmenVorperiode;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_zweitstimmen_vorlaeufig")
    private Long unabhaengigeZweitstimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "unabhaengige_zweitstimmen_vorperiode")
    private Long unabhaengigeZweitstimmenVorperiode;



    // Übrige

    /**
     * Übrige;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "uebrige_erststimmen_vorlaeufig")
    private Long uebrigeErststimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "uebrige_erststimmen_vorperiode")
    private Long uebrigeErststimmenVorperiode;

    /**
     * Übrige;;;Vorläufig
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "uebrige_zweitstimmen_vorlaeufig")
    private Long uebrigeZweitstimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    @Digits(integer=10, fraction=0)
    @Property(name = "uebrige_zweitstimmen_vorperiode")
    private Long uebrigeZweitstimmenVorperiode;

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
