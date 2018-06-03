package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

@Setter
@Getter
@NodeEntity
public class Btw17Ergebnis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;



    /**
     *  Nr;
     */
    @Column(name = "wahlkreis_nummer", nullable=false)
    private Long wahlkreisNummer;

    /**
     * Gebiet;
     */
    @Column(name = "wahlkreis_name", nullable=false)
    private String wahlkreisName;

    /**
     * gehört zu;
     */
    @Column(name = "bundesland_nummer", nullable=false)
    private Long bundeslandNummer;

    /**
     * Land
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "bundesland_kurz")
    private BundeslandEnum bundesland;


    // Wahlberechtigte

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "wahlberechtigte_erststimmen_vorlaeufig", nullable=false)
    private Long wahlberechtigteErststimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "wahlberechtigte_erststimmen_vorperiode", nullable=false)
    private Long wahlberechtigteErststimmenVorperiode;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "wahlberechtigte_zweitstimmen_vorlaeufig", nullable=false)
    private Long wahlberechtigteZweitstimmenVorlaeufig;

    /**
     * Wahlberechtigte;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "wahlberechtigte_zweitstimmen_vorperiode", nullable=false)
    private Long wahlberechtigteZweitstimmenVorperiode;


    // Wähler

    /**
     * Wähler;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "waehler_erststimmen_vorlaeufig", nullable=false)
    private Long waehlerErststimmenVorlaeufig;

    /**
     * Wähler;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "waehler_erststimmen_vorperiode", nullable=false)
    private Long waehlerErststimmenVorperiode;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "waehler_zweitstimmen_vorlaeufig", nullable=false)
    private Long waehlerZweitstimmenVorlaeufig;

    /**
     * Wähler;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "waehler_zweitstimmen_vorperiode", nullable=false)
    private Long waehlerZweitstimmenVorperiode;


    // Ungültige

    /**
     * Ungültige;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "ungueltige_erststimmen_vorlaeufig", nullable=false)
    private Long ungueltigeErststimmenVorlaeufig;

    /**
     * Ungültige;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "ungueltige_erststimmen_vorperiode", nullable=false)
    private Long ungueltigeErststimmenVorperiode;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "ungueltige_zweitstimmen_vorlaeufig", nullable=false)
    private Long ungueltigeZweitstimmenVorlaeufig;

    /**
     * Ungültige;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "ungueltige_zweitstimmen_vorperiode", nullable=false)
    private Long ungueltigeZweitstimmenVorperiode;


    // Gültige

    /**
     * Gültige;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "gueltige_erststimmen_vorlaeufig", nullable=false)
    private Long gueltigeErststimmenVorlaeufig;

    /**
     * Gültige;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "gueltige_erststimmen_vorperiode", nullable=false)
    private Long gueltigeErststimmenVorperiode;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "gueltige_zweitstimmen_vorlaeufig", nullable=false)
    private Long gueltigeZweitstimmenVorlaeufig;

    /**
     * Gültige;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "ueltige_zweitstimmen_vorperiode", nullable=false)
    private Long gueltigeZweitstimmenVorperiode;


    // Christlich Demokratische Union Deutschlands

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "cdu_erststimmen_vorlaeufig", nullable=false)
    private Long cduErststimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "cdu_erststimmen_vorperiode", nullable=false)
    private Long cduErststimmenVorperiode;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "cdu_zweitstimmen_vorlaeufig", nullable=false)
    private Long cduZweitstimmenVorlaeufig;

    /**
     * Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "cdu_zweitstimmen_vorperiode", nullable=false)
    private Long cduZweitstimmenVorperiode;


    // Sozialdemokratische Partei Deutschlands

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "spd_erststimmen_vorlaeufig", nullable=false)
    private Long spdErststimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "spd_erststimmen_vorperiode", nullable=false)
    private Long spdErststimmenVorperiode;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "spd_zweitstimmen_vorlaeufig", nullable=false)
    private Long spdZweitstimmenVorlaeufig;

    /**
     * Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "spd_zweitstimmen_vorperiode", nullable=false)
    private Long spdZweitstimmenVorperiode;


    // DIE LINKE

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "dielinke_erststimmen_vorlaeufig", nullable=false)
    private Long dielinkeErststimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "dielinke_erststimmen_vorperiode", nullable=false)
    private Long dielinkeErststimmenVorperiode;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "dielinke_zweitstimmen_vorlaeufig", nullable=false)
    private Long dielinkeZweitstimmenVorlaeufig;

    /**
     * DIE LINKE;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "dielinke_zweitstimmen_vorperiode", nullable=false)
    private Long dielinkeZweitstimmenVorperiode;


    // BÜNDNIS 90/DIE GRÜNEN

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "diegruenen_erststimmen_vorlaeufig", nullable=false)
    private Long diegruenenErststimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "diegruenen_erststimmen_vorperiode", nullable=false)
    private Long diegruenenErststimmenVorperiode;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "diegruenen_zweitstimmen_vorlaeufig", nullable=false)
    private Long diegruenenZweitstimmenVorlaeufig;

    /**
     * BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "diegruenen_zweitstimmen_vorperiode", nullable=false)
    private Long diegruenenZweitstimmenVorperiode;


    // Christlich-Soziale Union in Bayern e.V.

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "csu_erststimmen_vorlaeufig", nullable=false)
    private Long csuErststimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "csu_erststimmen_vorperiode", nullable=false)
    private Long csuErststimmenVorperiode;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "csu_zweitstimmen_vorlaeufig", nullable=false)
    private Long csuZweitstimmenVorlaeufig;

    /**
     * Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "csu_zweitstimmen_vorperiode", nullable=false)
    private Long csuZweitstimmenVorperiode;


    // Freie Demokratische Partei

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "fdp_erststimmen_vorlaeufig", nullable=false)
    private Long fdpErststimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "fdp_erststimmen_vorperiode", nullable=false)
    private Long fdpErststimmenVorperiode;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "fdp_zweitstimmen_vorlaeufig", nullable=false)
    private Long fdpZweitstimmenVorlaeufig;

    /**
     * Freie Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "fdp_zweitstimmen_vorperiode", nullable=false)
    private Long fdpZweitstimmenVorperiode;


    // Alternative für Deutschland

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "afd_erststimmen_vorlaeufig", nullable=false)
    private Long afdErststimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "afd_erststimmen_vorperiode", nullable=false)
    private Long afdErststimmenVorperiode;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "afd_zweitstimmen_vorlaeufig", nullable=false)
    private Long afdZweitstimmenVorlaeufig;

    /**
     * Alternative für Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "afd_zweitstimmen_vorperiode", nullable=false)
    private Long afdZweitstimmenVorperiode;


    // Piratenpartei Deutschland

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "piratenpartei_erststimmen_vorlaeufig", nullable=false)
    private Long piratenparteiErststimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "piratenpartei_erststimmen_vorperiode", nullable=false)
    private Long piratenparteiErststimmenVorperiode;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "piratenpartei_zweitstimmen_vorlaeufig", nullable=false)
    private Long piratenparteiZweitstimmenVorlaeufig;

    /**
     * Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "piratenpartei_zweitstimmen_vorperiode", nullable=false)
    private Long piratenparteiZweitstimmenVorperiode;


    // Nationaldemokratische Partei Deutschlands

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "npd_erststimmen_vorlaeufig", nullable=false)
    private Long npdErststimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "npd_erststimmen_vorperiode", nullable=false)
    private Long npdErststimmenVorperiode;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "npd_zweitstimmen_vorlaeufig", nullable=false)
    private Long npdZweitstimmenVorlaeufig;

    /**
     * Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "npd_zweitstimmen_vorperiode", nullable=false)
    private Long npdZweitstimmenVorperiode;


    // FREIE WÄHLER

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "freiewaehler_erststimmen_vorlaeufig", nullable=false)
    private Long freieWaehlerErststimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "freiewaehler_erststimmen_vorperiode", nullable=false)
    private Long freieWaehlerErststimmenVorperiode;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "freiewaehler_zweitstimmen_vorlaeufig", nullable=false)
    private Long freieWaehlerZweitstimmenVorlaeufig;

    /**
     * FREIE WÄHLER;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "freiewaehler_zweitstimmen_vorperiode", nullable=false)
    private Long freieWaehlerZweitstimmenVorperiode;


    // PARTEI MENSCH UMWELT TIERSCHUTZ

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "tierschutzpartei_erststimmen_vorlaeufig", nullable=false)
    private Long tierschutzparteiErststimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "tierschutzpartei_erststimmen_vorperiode", nullable=false)
    private Long tierschutzparteiErststimmenVorperiode;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "tierschutzpartei_zweitstimmen_vorlaeufig", nullable=false)
    private Long tierschutzparteiZweitstimmenVorlaeufig;

    /**
     * PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "tierschutzpartei_zweitstimmen_vorperiode", nullable=false)
    private Long tierschutzparteiZweitstimmenVorperiode;



    // Ökologisch-Demokratische Partei

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "oedp_erststimmen_vorlaeufig", nullable=false)
    private Long oedpErststimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "oedp_erststimmen_vorperiode", nullable=false)
    private Long oedpErststimmenVorperiode;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "oedp_zweitstimmen_vorlaeufig", nullable=false)
    private Long oedpZweitstimmenVorlaeufig;

    /**
     * Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "oedp_zweitstimmen_vorperiode", nullable=false)
    private Long oedpZweitstimmenVorperiode;



    // Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "diepartei_erststimmen_vorlaeufig", nullable=false)
    private Long dieparteiErststimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "diepartei_erststimmen_vorperiode", nullable=false)
    private Long dieparteiErststimmenVorperiode;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "diepartei_zweitstimmen_vorlaeufig", nullable=false)
    private Long dieparteiZweitstimmenVorlaeufig;

    /**
     * Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "diepartei_zweitstimmen_vorperiode", nullable=false)
    private Long dieparteiZweitstimmenVorperiode;



    // Bayernpartei

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorläufig
     */
    @Column(name = "bayernpartei_erststimmen_vorlaeufig", nullable=false)
    private Long bayernparteiErststimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Erststimmen;;;Vorperiode
     */
    @Column(name = "bayernpartei_erststimmen_vorperiode", nullable=false)
    private Long bayernparteiErststimmenVorperiode;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorläufig
     */
    @Column(name = "bayernpartei_zweitstimmen_vorlaeufig", nullable=false)
    private Long bayernparteiZweitstimmenVorlaeufig;

    /**
     * Bayernpartei;;;;Zweitstimmen;;;Vorperiode
     */
    @Column(name = "bayernpartei_zweitstimmen_vorperiode", nullable=false)
    private Long bayernparteiZweitstimmenVorperiode;



    // Ab jetzt...Demokratie durch Volksabstimmung

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    @Column(name = "volksabstimmung_erststimmen_vorlaeufig", nullable=false)
    private Long volksabstimmungErststimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    @Column(name = "volksabstimmung_erststimmen_vorperiode", nullable=false)
    private Long volksabstimmungErststimmenVorperiode;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig
     */
    @Column(name = "volksabstimmung_zweitstimmen_vorlaeufig", nullable=false)
    private Long volksabstimmungZweitstimmenVorlaeufig;

    /**
     * Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode
     */
    @Column(name = "volksabstimmung_zweitstimmen_vorperiode", nullable=false)
    private Long volksabstimmungZweitstimmenVorperiode;


    // Partei der Vernunft

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    @Column(name = "pdv_erststimmen_vorlaeufig", nullable=false)
    private Long pdvErststimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    @Column(name = "pdv_erststimmen_vorperiode", nullable=false)
    private Long pdvErststimmenVorperiode;

    /**
     * Partei der Vernunft;;;Vorläufig
     */
    @Column(name = "pdv_zweitstimmen_vorlaeufig", nullable=false)
    private Long pdvZweitstimmenVorlaeufig;

    /**
     * Partei der Vernunft;;;Vorperiode
     */
    @Column(name = "pdv_zweitstimmen_vorperiode", nullable=false)
    private Long pdvZweitstimmenVorperiode;


    // Marxistisch-Leninistische Partei Deutschlands

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    @Column(name = "mlpd_erststimmen_vorlaeufig", nullable=false)
    private Long mlpdErststimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    @Column(name = "mlpd_erststimmen_vorperiode", nullable=false)
    private Long mlpdErststimmenVorperiode;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig
     */
    @Column(name = "mlpd_zweitstimmen_vorlaeufig", nullable=false)
    private Long mlpdZweitstimmenVorlaeufig;

    /**
     * Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode
     */
    @Column(name = "mlpd_zweitstimmen_vorperiode", nullable=false)
    private Long mlpdZweitstimmenVorperiode;


    // Bürgerrechtsbewegung Solidarität

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    @Column(name = "bueso_erststimmen_vorlaeufig", nullable=false)
    private Long buesoErststimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    @Column(name = "bueso_erststimmen_vorperiode", nullable=false)
    private Long buesoErststimmenVorperiode;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorläufig
     */
    @Column(name = "bueso_zweitstimmen_vorlaeufig", nullable=false)
    private Long buesoZweitstimmenVorlaeufig;

    /**
     * Bürgerrechtsbewegung Solidarität;;;Vorperiode
     */
    @Column(name = "bueso_zweitstimmen_vorperiode", nullable=false)
    private Long buesoZweitstimmenVorperiode;


    // Sozialistische Gleichheitspartei, Vierte Internationale

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    @Column(name = "sgp_erststimmen_vorlaeufig", nullable=false)
    private Long sgpErststimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    @Column(name = "sgp_erststimmen_vorperiode", nullable=false)
    private Long sgpErststimmenVorperiode;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig
     */
    @Column(name = "sgp_zweitstimmen_vorlaeufig", nullable=false)
    private Long sgpZweitstimmenVorlaeufig;

    /**
     * Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode
     */
    @Column(name = "sgp_zweitstimmen_vorperiode", nullable=false)
    private Long sgpZweitstimmenVorperiode;


    // DIE RECHTE

    /**
     * DIE RECHTE;;;Vorläufig
     */
    @Column(name = "dierechte_erststimmen_vorlaeufig", nullable=false)
    private Long dierechteErststimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    @Column(name = "dierechte_erststimmen_vorperiode", nullable=false)
    private Long dierechteErststimmenVorperiode;

    /**
     * DIE RECHTE;;;Vorläufig
     */
    @Column(name = "dierechte_zweitstimmen_vorlaeufig", nullable=false)
    private Long dierechteZweitstimmenVorlaeufig;

    /**
     * DIE RECHTE;;;Vorperiode
     */
    @Column(name = "dierechte_zweitstimmen_vorperiode", nullable=false)
    private Long dierechteZweitstimmenVorperiode;


    // Allianz Deutscher Demokraten

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    @Column(name = "add_erststimmen_vorlaeufig", nullable=false)
    private Long addErststimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    @Column(name = "add_erststimmen_vorperiode", nullable=false)
    private Long addErststimmenVorperiode;

    /**
     * Allianz Deutscher Demokraten;;;Vorläufig
     */
    @Column(name = "add_zweitstimmen_vorlaeufig", nullable=false)
    private Long addZweitstimmenVorlaeufig;

    /**
     * Allianz Deutscher Demokraten;;;Vorperiode
     */
    @Column(name = "add_zweitstimmen_vorperiode", nullable=false)
    private Long addZweitstimmenVorperiode;


    // Allianz für Menschenrechte, Tier- und Naturschutz

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    @Column(name = "tierschutzallianz_erststimmen_vorlaeufig", nullable=false)
    private Long tierschutzallianzErststimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    @Column(name = "tierschutzallianz_erststimmen_vorperiode", nullable=false)
    private Long tierschutzallianzErststimmenVorperiode;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig
     */
    @Column(name = "tierschutzallianz_zweitstimmen_vorlaeufig", nullable=false)
    private Long tierschutzallianzZweitstimmenVorlaeufig;

    /**
     * Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode
     */
    @Column(name = "tierschutzallianz_zweitstimmen_vorperiode", nullable=false)
    private Long tierschutzallianzZweitstimmenVorperiode;


    // bergpartei, die überpartei

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    @Column(name = "bergpartei_erststimmen_vorlaeufig", nullable=false)
    private Long bergparteiErststimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    @Column(name = "bergpartei_erststimmen_vorperiode", nullable=false)
    private Long bergparteiErststimmenVorperiode;

    /**
     * bergpartei, die überpartei;;;Vorläufig
     */
    @Column(name = "bergpartei_zweitstimmen_vorlaeufig", nullable=false)
    private Long bergparteiZweitstimmenVorlaeufig;

    /**
     * bergpartei, die überpartei;;;Vorperiode
     */
    @Column(name = "bergpartei_zweitstimmen_vorperiode", nullable=false)
    private Long bergparteiZweitstimmenVorperiode;


    // Bündnis Grundeinkommen

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    @Column(name = "bge_erststimmen_vorlaeufig", nullable=false)
    private Long bgeErststimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    @Column(name = "bge_erststimmen_vorperiode", nullable=false)
    private Long bgeErststimmenVorperiode;

    /**
     * Bündnis Grundeinkommen;;;Vorläufig
     */
    @Column(name = "bge_zweitstimmen_vorlaeufig", nullable=false)
    private Long bgeZweitstimmenVorlaeufig;

    /**
     * Bündnis Grundeinkommen;;;Vorperiode
     */
    @Column(name = "bge_zweitstimmen_vorperiode", nullable=false)
    private Long bgeZweitstimmenVorperiode;


    // DEMOKRATIE IN BEWEGUNG

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    @Column(name = "dib_erststimmen_vorlaeufig", nullable=false)
    private Long dibErststimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    @Column(name = "dib_erststimmen_vorperiode", nullable=false)
    private Long dibErststimmenVorperiode;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorläufig
     */
    @Column(name = "dib_zweitstimmen_vorlaeufig", nullable=false)
    private Long dibZweitstimmenVorlaeufig;

    /**
     * DEMOKRATIE IN BEWEGUNG;;;Vorperiode
     */
    @Column(name = "dib_zweitstimmen_vorperiode", nullable=false)
    private Long dibZweitstimmenVorperiode;


    // Deutsche Kommunistische Partei

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    @Column(name = "dkp_erststimmen_vorlaeufig", nullable=false)
    private Long dkpErststimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    @Column(name = "dkp_erststimmen_vorperiode", nullable=false)
    private Long dkpErststimmenVorperiode;

    /**
     * Deutsche Kommunistische Partei;;;Vorläufig
     */
    @Column(name = "dkp_zweitstimmen_vorlaeufig", nullable=false)
    private Long dkpZweitstimmenVorlaeufig;

    /**
     * Deutsche Kommunistische Partei;;;Vorperiode
     */
    @Column(name = "dkp_zweitstimmen_vorperiode", nullable=false)
    private Long dkpZweitstimmenVorperiode;


    // Deutsche Mitte

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    @Column(name = "dm_erststimmen_vorlaeufig", nullable=false)
    private Long dmErststimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    @Column(name = "dm_erststimmen_vorperiode", nullable=false)
    private Long dmErststimmenVorperiode;

    /**
     * Deutsche Mitte;;;Vorläufig
     */
    @Column(name = "dm_zweitstimmen_vorlaeufig", nullable=false)
    private Long dmZweitstimmenVorlaeufig;

    /**
     * Deutsche Mitte;;;Vorperiode
     */
    @Column(name = "dm_zweitstimmen_vorperiode", nullable=false)
    private Long dmZweitstimmenVorperiode;



    // Die Grauen – Für alle Generationen

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    @Column(name = "diegrauen_erststimmen_vorlaeufig", nullable=false)
    private Long diegrauenErststimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    @Column(name = "diegrauen_erststimmen_vorperiode", nullable=false)
    private Long diegrauenErststimmenVorperiode;

    /**
     * Die Grauen – Für alle Generationen;;;Vorläufig
     */
    @Column(name = "diegrauen_zweitstimmen_vorlaeufig", nullable=false)
    private Long diegrauenZweitstimmenVorlaeufig;

    /**
     * Die Grauen – Für alle Generationen;;;Vorperiode
     */
    @Column(name = "diegrauen_zweitstimmen_vorperiode", nullable=false)
    private Long  diegrauenZweitstimmenVorperiode;



    // Die Urbane. Eine HipHop Partei

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    @Column(name = "du_erststimmen_vorlaeufig", nullable=false)
    private Long duErststimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    @Column(name = "du_erststimmen_vorperiode", nullable=false)
    private Long duErststimmenVorperiode;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorläufig
     */
    @Column(name = "du_zweitstimmen_vorlaeufig", nullable=false)
    private Long duZweitstimmenVorlaeufig;

    /**
     * Die Urbane. Eine HipHop Partei;;;Vorperiode
     */
    @Column(name = "du_zweitstimmen_vorperiode", nullable=false)
    private Long duZweitstimmenVorperiode;



    // Madgeburger Gartenpartei

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    @Column(name = "mg_erststimmen_vorlaeufig", nullable=false)
    private Long mgErststimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    @Column(name = "mg_erststimmen_vorperiode", nullable=false)
    private Long mgErststimmenVorperiode;

    /**
     * Madgeburger Gartenpartei;;;Vorläufig
     */
    @Column(name = "mg_zweitstimmen_vorlaeufig", nullable=false)
    private Long mgZweitstimmenVorlaeufig;

    /**
     * Madgeburger Gartenpartei;;;Vorperiode
     */
    @Column(name = "mg_zweitstimmen_vorperiode", nullable=false)
    private Long mgZweitstimmenVorperiode;



    // Menschliche Welt

    /**
     * Menschliche Welt;;;Vorläufig
     */
    @Column(name = "menschlichewelt_erststimmen_vorlaeufig", nullable=false)
    private Long menschlicheweltErststimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    @Column(name = "menschlichewelt_erststimmen_vorperiode", nullable=false)
    private Long menschlicheweltErststimmenVorperiode;

    /**
     * Menschliche Welt;;;Vorläufig
     */
    @Column(name = "menschlichewelt_zweitstimmen_vorlaeufig", nullable=false)
    private Long menschlicheweltZweitstimmenVorlaeufig;

    /**
     * Menschliche Welt;;;Vorperiode
     */
    @Column(name = "menschlichewelt_zweitstimmen_vorperiode", nullable=false)
    private Long menschlicheweltZweitstimmenVorperiode;



    // Partei der Humanisten

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    @Column(name = "diehumanisten_erststimmen_vorlaeufig", nullable=false)
    private Long diehumanistenErststimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    @Column(name = "diehumanisten_erststimmen_vorperiode", nullable=false)
    private Long diehumanistenErststimmenVorperiode;

    /**
     * Partei der Humanisten;;;Vorläufig
     */
    @Column(name = "diehumanisten_zweitstimmen_vorlaeufig", nullable=false)
    private Long diehumanistenZweitstimmenVorlaeufig;

    /**
     * Partei der Humanisten;;;Vorperiode
     */
    @Column(name = "diehumanisten_zweitstimmen_vorperiode", nullable=false)
    private Long diehumanistenZweitstimmenVorperiode;



    // Partei für Gesundheitsforschung

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    @Column(name = "gesundheitsforschung_erststimmen_vorlaeufig", nullable=false)
    private Long gesundheitsforschungErststimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    @Column(name = "gesundheitsforschung_erststimmen_vorperiode", nullable=false)
    private Long gesundheitsforschungErststimmenVorperiode;

    /**
     * Partei für Gesundheitsforschung;;;Vorläufig
     */
    @Column(name = "gesundheitsforschung_zweitstimmen_vorlaeufig", nullable=false)
    private Long gesundheitsforschungZweitstimmenVorlaeufig;

    /**
     * Partei für Gesundheitsforschung;;;Vorperiode
     */
    @Column(name = "gesundheitsforschung_zweitstimmen_vorperiode", nullable=false)
    private Long gesundheitsforschungZweitstimmenVorperiode;



    // V-Partei³ - Partei für Veränderung, Vegetarier und Veganer

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    @Column(name = "vpartei_erststimmen_vorlaeufig", nullable=false)
    private Long vparteiErststimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    @Column(name = "vpartei_erststimmen_vorperiode", nullable=false)
    private Long vparteiErststimmenVorperiode;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig
     */
    @Column(name = "vpartei_zweitstimmen_vorlaeufig", nullable=false)
    private Long vparteiZweitstimmenVorlaeufig;

    /**
     * V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode
     */
    @Column(name = "vpartei_zweitstimmen_vorperiode", nullable=false)
    private Long vparteiZweitstimmenVorperiode;



    // Bündnis C - Christen für Deutschland

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    @Column(name = "buendnisc_erststimmen_vorlaeufig", nullable=false)
    private Long buendniscErststimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    @Column(name = "buendnisc_erststimmen_vorperiode", nullable=false)
    private Long buendniscErststimmenVorperiode;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorläufig
     */
    @Column(name = "buendnisc_zweitstimmen_vorlaeufig", nullable=false)
    private Long buendniscZweitstimmenVorlaeufig;

    /**
     * Bündnis C - Christen für Deutschland;;;Vorperiode
     */
    @Column(name = "buendnisc_zweitstimmen_vorperiode", nullable=false)
    private Long buendniscZweitstimmenVorperiode;



    // DIE EINHEIT

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    @Column(name = "dieeinheit_erststimmen_vorlaeufig", nullable=false)
    private Long dieeinheitErststimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    @Column(name = "dieeinheit_erststimmen_vorperiode", nullable=false)
    private Long dieeinheitErststimmenVorperiode;

    /**
     * DIE EINHEIT;;;Vorläufig
     */
    @Column(name = "dieeinheit_zweitstimmen_vorlaeufig", nullable=false)
    private Long dieeinheitZweitstimmenVorlaeufig;

    /**
     * DIE EINHEIT;;;Vorperiode
     */
    @Column(name = "dieeinheit_zweitstimmen_vorperiode", nullable=false)
    private Long dieeinheitZweitstimmenVorperiode;



    // Die Violetten

    /**
     * Die Violetten;;;Vorläufig
     */
    @Column(name = "dievioletten_erststimmen_vorlaeufig", nullable=false)
    private Long dieviolettenErststimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    @Column(name = "dievioletten_erststimmen_vorperiode", nullable=false)
    private Long dieviolettenErststimmenVorperiode;

    /**
     * Die Violetten;;;Vorläufig
     */
    @Column(name = "dievioletten_zweitstimmen_vorlaeufig", nullable=false)
    private Long dieviolettenZweitstimmenVorlaeufig;

    /**
     * Die Violetten;;;Vorperiode
     */
    @Column(name = "dievioletten_zweitstimmen_vorperiode", nullable=false)
    private Long dieviolettenZweitstimmenVorperiode;



    // Familien-Partei Deutschlands

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    @Column(name = "familie_erststimmen_vorlaeufig", nullable=false)
    private Long familieErststimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    @Column(name = "familie_erststimmen_vorperiode", nullable=false)
    private Long familieErststimmenVorperiode;

    /**
     * Familien-Partei Deutschlands;;;Vorläufig
     */
    @Column(name = "familie_zweitstimmen_vorlaeufig", nullable=false)
    private Long familieZweitstimmenVorlaeufig;

    /**
     * Familien-Partei Deutschlands;;;Vorperiode
     */
    @Column(name = "familie_zweitstimmen_vorperiode", nullable=false)
    private Long familieZweitstimmenVorperiode;



    // Feministische Partei DIE FRAUEN

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    @Column(name = "diefrauen_erststimmen_vorlaeufig", nullable=false)
    private Long diefrauenErststimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    @Column(name = "diefrauen_erststimmen_vorperiode", nullable=false)
    private Long diefrauenErststimmenVorperiode;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorläufig
     */
    @Column(name = "diefrauen_zweitstimmen_vorlaeufig", nullable=false)
    private Long diefrauenZweitstimmenVorlaeufig;

    /**
     * Feministische Partei DIE FRAUEN;;;Vorperiode
     */
    @Column(name = "diefrauen_zweitstimmen_vorperiode", nullable=false)
    private Long diefrauenZweitstimmenVorperiode;



    // Mieterpartei

    /**
     * Mieterpartei;;;Vorläufig
     */
    @Column(name = "mieterpartei_erststimmen_vorlaeufig", nullable=false)
    private Long mieterparteiErststimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    @Column(name = "mieterpartei_erststimmen_vorperiode", nullable=false)
    private Long mieterparteiErststimmenVorperiode;

    /**
     * Mieterpartei;;;Vorläufig
     */
    @Column(name = "mieterpartei_zweitstimmen_vorlaeufig", nullable=false)
    private Long mieterparteiZweitstimmenVorlaeufig;

    /**
     * Mieterpartei;;;Vorperiode
     */
    @Column(name = "mieterpartei_zweitstimmen_vorperiode", nullable=false)
    private Long mieterparteiZweitstimmenVorperiode;



    // Neue Liberale – Die Sozialliberalen

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    @Column(name = "neueliberale_erststimmen_vorlaeufig", nullable=false)
    private Long neueliberaleErststimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    @Column(name = "neueliberale_erststimmen_vorperiode", nullable=false)
    private Long neueliberaleErststimmenVorperiode;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorläufig
     */
    @Column(name = "neueliberale_zweitstimmen_vorlaeufig", nullable=false)
    private Long neueliberaleZweitstimmenVorlaeufig;

    /**
     * Neue Liberale – Die Sozialliberalen;;;Vorperiode
     */
    @Column(name = "neueliberale_zweitstimmen_vorperiode", nullable=false)
    private Long neueliberaleZweitstimmenVorperiode;



    // UNABHÄNGIGE für bürgernahe Demokratie

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    @Column(name = "unabhaengige_erststimmen_vorlaeufig", nullable=false)
    private Long unabhaengigeErststimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    @Column(name = "unabhaengige_erststimmen_vorperiode", nullable=false)
    private Long unabhaengigeErststimmenVorperiode;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig
     */
    @Column(name = "unabhaengige_zweitstimmen_vorlaeufig", nullable=false)
    private Long unabhaengigeZweitstimmenVorlaeufig;

    /**
     * UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode
     */
    @Column(name = "unabhaengige_zweitstimmen_vorperiode", nullable=false)
    private Long unabhaengigeZweitstimmenVorperiode;



    // Übrige

    /**
     * Übrige;;;Vorläufig
     */
    @Column(name = "uebrige_erststimmen_vorlaeufig", nullable=false)
    private Long uebrigeErststimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    @Column(name = "uebrige_erststimmen_vorperiode", nullable=false)
    private Long uebrigeErststimmenVorperiode;

    /**
     * Übrige;;;Vorläufig
     */
    @Column(name = "uebrige_zweitstimmen_vorlaeufig", nullable=false)
    private Long uebrigeZweitstimmenVorlaeufig;

    /**
     * Übrige;;;Vorperiode
     */
    @Column(name = "uebrige_zweitstimmen_vorperiode", nullable=false)
    private Long uebrigeZweitstimmenVorperiode;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlkreisName+" ("+wahlkreisNummer+")";
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id+":"+wahlkreisNummer+":"+bundeslandNummer+":"+wahlkreisName;
    }

}
