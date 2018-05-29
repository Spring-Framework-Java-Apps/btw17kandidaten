package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.listener.Btw17ErgebnisListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "btw17_ergebnis",
    //schema = "public",
    //catalog = "information_//schema",
    uniqueConstraints = {
        @UniqueConstraint(name="uk_btw17_ergebnis", columnNames = {"wahlkreis_nummer","bundesland_nummer"})
    },
    indexes = {
        @Index(name = "idx_btw17_ergebnis_wahlkreis_name", columnList = "wahlkreis_name")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Btw17Ergebnis.findByWahlkreisNummer",
        query = "select o from Btw17Ergebnis as o where o.wahlkreisNummer=:wahlkreisNummer"
    ),
    @NamedQuery(
        name = "Btw17Ergebnis.findBybundeslandNummer",
        query = "select o from Btw17Ergebnis as o where o.bundeslandNummer=:bundeslandNummer"
    ),
    @NamedQuery(
        name = "Btw17Ergebnis.countBybundeslandNummer",
        query = "select count(o) from Btw17Ergebnis as o where o.bundeslandNummer=:bundeslandNummer"
    ),
    @NamedQuery(
        name = "Btw17Ergebnis.getAllIds",
        query = "select o.id from Btw17Ergebnis as o order by o.id"
    ),
    @NamedQuery(
        name = "Btw17Ergebnis.getMaxId",
        query = "select max(o.id) from Btw17Ergebnis as o"
    ),
    @NamedQuery(
        name = "Btw17Ergebnis.getErgebnisOfBundeslaender",
        query = "select o from Btw17Ergebnis as o where o.bundeslandNummer=99"
    )
})
@EntityListeners(Btw17ErgebnisListener.class)
public class Btw17Ergebnis implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

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

    public void setId(Long id) {
        this.id = id;
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

    public Long getBundeslandNummer() {
        return bundeslandNummer;
    }

    public void setBundeslandNummer(Long bundeslandNummer) {
        this.bundeslandNummer = bundeslandNummer;
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

    public BundeslandEnum getBundesland() {
        return bundesland;
    }

    public void setBundesland(BundeslandEnum bundesland) {
        this.bundesland = bundesland;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Btw17Ergebnis)) return false;

        Btw17Ergebnis that = (Btw17Ergebnis) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (wahlkreisNummer != null ? !wahlkreisNummer.equals(that.wahlkreisNummer) : that.wahlkreisNummer != null)
            return false;
        if (wahlkreisName != null ? !wahlkreisName.equals(that.wahlkreisName) : that.wahlkreisName != null)
            return false;
        if (bundeslandNummer != null ? !bundeslandNummer.equals(that.bundeslandNummer) : that.bundeslandNummer != null)
            return false;
        if (wahlberechtigteErststimmenVorlaeufig != null ? !wahlberechtigteErststimmenVorlaeufig.equals(that.wahlberechtigteErststimmenVorlaeufig) : that.wahlberechtigteErststimmenVorlaeufig != null)
            return false;
        if (wahlberechtigteErststimmenVorperiode != null ? !wahlberechtigteErststimmenVorperiode.equals(that.wahlberechtigteErststimmenVorperiode) : that.wahlberechtigteErststimmenVorperiode != null)
            return false;
        if (wahlberechtigteZweitstimmenVorlaeufig != null ? !wahlberechtigteZweitstimmenVorlaeufig.equals(that.wahlberechtigteZweitstimmenVorlaeufig) : that.wahlberechtigteZweitstimmenVorlaeufig != null)
            return false;
        if (wahlberechtigteZweitstimmenVorperiode != null ? !wahlberechtigteZweitstimmenVorperiode.equals(that.wahlberechtigteZweitstimmenVorperiode) : that.wahlberechtigteZweitstimmenVorperiode != null)
            return false;
        if (waehlerErststimmenVorlaeufig != null ? !waehlerErststimmenVorlaeufig.equals(that.waehlerErststimmenVorlaeufig) : that.waehlerErststimmenVorlaeufig != null)
            return false;
        if (waehlerErststimmenVorperiode != null ? !waehlerErststimmenVorperiode.equals(that.waehlerErststimmenVorperiode) : that.waehlerErststimmenVorperiode != null)
            return false;
        if (waehlerZweitstimmenVorlaeufig != null ? !waehlerZweitstimmenVorlaeufig.equals(that.waehlerZweitstimmenVorlaeufig) : that.waehlerZweitstimmenVorlaeufig != null)
            return false;
        if (waehlerZweitstimmenVorperiode != null ? !waehlerZweitstimmenVorperiode.equals(that.waehlerZweitstimmenVorperiode) : that.waehlerZweitstimmenVorperiode != null)
            return false;
        if (ungueltigeErststimmenVorlaeufig != null ? !ungueltigeErststimmenVorlaeufig.equals(that.ungueltigeErststimmenVorlaeufig) : that.ungueltigeErststimmenVorlaeufig != null)
            return false;
        if (ungueltigeErststimmenVorperiode != null ? !ungueltigeErststimmenVorperiode.equals(that.ungueltigeErststimmenVorperiode) : that.ungueltigeErststimmenVorperiode != null)
            return false;
        if (ungueltigeZweitstimmenVorlaeufig != null ? !ungueltigeZweitstimmenVorlaeufig.equals(that.ungueltigeZweitstimmenVorlaeufig) : that.ungueltigeZweitstimmenVorlaeufig != null)
            return false;
        if (ungueltigeZweitstimmenVorperiode != null ? !ungueltigeZweitstimmenVorperiode.equals(that.ungueltigeZweitstimmenVorperiode) : that.ungueltigeZweitstimmenVorperiode != null)
            return false;
        if (gueltigeErststimmenVorlaeufig != null ? !gueltigeErststimmenVorlaeufig.equals(that.gueltigeErststimmenVorlaeufig) : that.gueltigeErststimmenVorlaeufig != null)
            return false;
        if (gueltigeErststimmenVorperiode != null ? !gueltigeErststimmenVorperiode.equals(that.gueltigeErststimmenVorperiode) : that.gueltigeErststimmenVorperiode != null)
            return false;
        if (gueltigeZweitstimmenVorlaeufig != null ? !gueltigeZweitstimmenVorlaeufig.equals(that.gueltigeZweitstimmenVorlaeufig) : that.gueltigeZweitstimmenVorlaeufig != null)
            return false;
        if (gueltigeZweitstimmenVorperiode != null ? !gueltigeZweitstimmenVorperiode.equals(that.gueltigeZweitstimmenVorperiode) : that.gueltigeZweitstimmenVorperiode != null)
            return false;
        if (cduErststimmenVorlaeufig != null ? !cduErststimmenVorlaeufig.equals(that.cduErststimmenVorlaeufig) : that.cduErststimmenVorlaeufig != null)
            return false;
        if (cduErststimmenVorperiode != null ? !cduErststimmenVorperiode.equals(that.cduErststimmenVorperiode) : that.cduErststimmenVorperiode != null)
            return false;
        if (cduZweitstimmenVorlaeufig != null ? !cduZweitstimmenVorlaeufig.equals(that.cduZweitstimmenVorlaeufig) : that.cduZweitstimmenVorlaeufig != null)
            return false;
        if (cduZweitstimmenVorperiode != null ? !cduZweitstimmenVorperiode.equals(that.cduZweitstimmenVorperiode) : that.cduZweitstimmenVorperiode != null)
            return false;
        if (spdErststimmenVorlaeufig != null ? !spdErststimmenVorlaeufig.equals(that.spdErststimmenVorlaeufig) : that.spdErststimmenVorlaeufig != null)
            return false;
        if (spdErststimmenVorperiode != null ? !spdErststimmenVorperiode.equals(that.spdErststimmenVorperiode) : that.spdErststimmenVorperiode != null)
            return false;
        if (spdZweitstimmenVorlaeufig != null ? !spdZweitstimmenVorlaeufig.equals(that.spdZweitstimmenVorlaeufig) : that.spdZweitstimmenVorlaeufig != null)
            return false;
        if (spdZweitstimmenVorperiode != null ? !spdZweitstimmenVorperiode.equals(that.spdZweitstimmenVorperiode) : that.spdZweitstimmenVorperiode != null)
            return false;
        if (dielinkeErststimmenVorlaeufig != null ? !dielinkeErststimmenVorlaeufig.equals(that.dielinkeErststimmenVorlaeufig) : that.dielinkeErststimmenVorlaeufig != null)
            return false;
        if (dielinkeErststimmenVorperiode != null ? !dielinkeErststimmenVorperiode.equals(that.dielinkeErststimmenVorperiode) : that.dielinkeErststimmenVorperiode != null)
            return false;
        if (dielinkeZweitstimmenVorlaeufig != null ? !dielinkeZweitstimmenVorlaeufig.equals(that.dielinkeZweitstimmenVorlaeufig) : that.dielinkeZweitstimmenVorlaeufig != null)
            return false;
        if (dielinkeZweitstimmenVorperiode != null ? !dielinkeZweitstimmenVorperiode.equals(that.dielinkeZweitstimmenVorperiode) : that.dielinkeZweitstimmenVorperiode != null)
            return false;
        if (diegruenenErststimmenVorlaeufig != null ? !diegruenenErststimmenVorlaeufig.equals(that.diegruenenErststimmenVorlaeufig) : that.diegruenenErststimmenVorlaeufig != null)
            return false;
        if (diegruenenErststimmenVorperiode != null ? !diegruenenErststimmenVorperiode.equals(that.diegruenenErststimmenVorperiode) : that.diegruenenErststimmenVorperiode != null)
            return false;
        if (diegruenenZweitstimmenVorlaeufig != null ? !diegruenenZweitstimmenVorlaeufig.equals(that.diegruenenZweitstimmenVorlaeufig) : that.diegruenenZweitstimmenVorlaeufig != null)
            return false;
        if (diegruenenZweitstimmenVorperiode != null ? !diegruenenZweitstimmenVorperiode.equals(that.diegruenenZweitstimmenVorperiode) : that.diegruenenZweitstimmenVorperiode != null)
            return false;
        if (csuErststimmenVorlaeufig != null ? !csuErststimmenVorlaeufig.equals(that.csuErststimmenVorlaeufig) : that.csuErststimmenVorlaeufig != null)
            return false;
        if (csuErststimmenVorperiode != null ? !csuErststimmenVorperiode.equals(that.csuErststimmenVorperiode) : that.csuErststimmenVorperiode != null)
            return false;
        if (csuZweitstimmenVorlaeufig != null ? !csuZweitstimmenVorlaeufig.equals(that.csuZweitstimmenVorlaeufig) : that.csuZweitstimmenVorlaeufig != null)
            return false;
        if (csuZweitstimmenVorperiode != null ? !csuZweitstimmenVorperiode.equals(that.csuZweitstimmenVorperiode) : that.csuZweitstimmenVorperiode != null)
            return false;
        if (fdpErststimmenVorlaeufig != null ? !fdpErststimmenVorlaeufig.equals(that.fdpErststimmenVorlaeufig) : that.fdpErststimmenVorlaeufig != null)
            return false;
        if (fdpErststimmenVorperiode != null ? !fdpErststimmenVorperiode.equals(that.fdpErststimmenVorperiode) : that.fdpErststimmenVorperiode != null)
            return false;
        if (fdpZweitstimmenVorlaeufig != null ? !fdpZweitstimmenVorlaeufig.equals(that.fdpZweitstimmenVorlaeufig) : that.fdpZweitstimmenVorlaeufig != null)
            return false;
        if (fdpZweitstimmenVorperiode != null ? !fdpZweitstimmenVorperiode.equals(that.fdpZweitstimmenVorperiode) : that.fdpZweitstimmenVorperiode != null)
            return false;
        if (afdErststimmenVorlaeufig != null ? !afdErststimmenVorlaeufig.equals(that.afdErststimmenVorlaeufig) : that.afdErststimmenVorlaeufig != null)
            return false;
        if (afdErststimmenVorperiode != null ? !afdErststimmenVorperiode.equals(that.afdErststimmenVorperiode) : that.afdErststimmenVorperiode != null)
            return false;
        if (afdZweitstimmenVorlaeufig != null ? !afdZweitstimmenVorlaeufig.equals(that.afdZweitstimmenVorlaeufig) : that.afdZweitstimmenVorlaeufig != null)
            return false;
        if (afdZweitstimmenVorperiode != null ? !afdZweitstimmenVorperiode.equals(that.afdZweitstimmenVorperiode) : that.afdZweitstimmenVorperiode != null)
            return false;
        if (piratenparteiErststimmenVorlaeufig != null ? !piratenparteiErststimmenVorlaeufig.equals(that.piratenparteiErststimmenVorlaeufig) : that.piratenparteiErststimmenVorlaeufig != null)
            return false;
        if (piratenparteiErststimmenVorperiode != null ? !piratenparteiErststimmenVorperiode.equals(that.piratenparteiErststimmenVorperiode) : that.piratenparteiErststimmenVorperiode != null)
            return false;
        if (piratenparteiZweitstimmenVorlaeufig != null ? !piratenparteiZweitstimmenVorlaeufig.equals(that.piratenparteiZweitstimmenVorlaeufig) : that.piratenparteiZweitstimmenVorlaeufig != null)
            return false;
        if (piratenparteiZweitstimmenVorperiode != null ? !piratenparteiZweitstimmenVorperiode.equals(that.piratenparteiZweitstimmenVorperiode) : that.piratenparteiZweitstimmenVorperiode != null)
            return false;
        if (npdErststimmenVorlaeufig != null ? !npdErststimmenVorlaeufig.equals(that.npdErststimmenVorlaeufig) : that.npdErststimmenVorlaeufig != null)
            return false;
        if (npdErststimmenVorperiode != null ? !npdErststimmenVorperiode.equals(that.npdErststimmenVorperiode) : that.npdErststimmenVorperiode != null)
            return false;
        if (npdZweitstimmenVorlaeufig != null ? !npdZweitstimmenVorlaeufig.equals(that.npdZweitstimmenVorlaeufig) : that.npdZweitstimmenVorlaeufig != null)
            return false;
        if (npdZweitstimmenVorperiode != null ? !npdZweitstimmenVorperiode.equals(that.npdZweitstimmenVorperiode) : that.npdZweitstimmenVorperiode != null)
            return false;
        if (freieWaehlerErststimmenVorlaeufig != null ? !freieWaehlerErststimmenVorlaeufig.equals(that.freieWaehlerErststimmenVorlaeufig) : that.freieWaehlerErststimmenVorlaeufig != null)
            return false;
        if (freieWaehlerErststimmenVorperiode != null ? !freieWaehlerErststimmenVorperiode.equals(that.freieWaehlerErststimmenVorperiode) : that.freieWaehlerErststimmenVorperiode != null)
            return false;
        if (freieWaehlerZweitstimmenVorlaeufig != null ? !freieWaehlerZweitstimmenVorlaeufig.equals(that.freieWaehlerZweitstimmenVorlaeufig) : that.freieWaehlerZweitstimmenVorlaeufig != null)
            return false;
        if (freieWaehlerZweitstimmenVorperiode != null ? !freieWaehlerZweitstimmenVorperiode.equals(that.freieWaehlerZweitstimmenVorperiode) : that.freieWaehlerZweitstimmenVorperiode != null)
            return false;
        if (tierschutzparteiErststimmenVorlaeufig != null ? !tierschutzparteiErststimmenVorlaeufig.equals(that.tierschutzparteiErststimmenVorlaeufig) : that.tierschutzparteiErststimmenVorlaeufig != null)
            return false;
        if (tierschutzparteiErststimmenVorperiode != null ? !tierschutzparteiErststimmenVorperiode.equals(that.tierschutzparteiErststimmenVorperiode) : that.tierschutzparteiErststimmenVorperiode != null)
            return false;
        if (tierschutzparteiZweitstimmenVorlaeufig != null ? !tierschutzparteiZweitstimmenVorlaeufig.equals(that.tierschutzparteiZweitstimmenVorlaeufig) : that.tierschutzparteiZweitstimmenVorlaeufig != null)
            return false;
        if (tierschutzparteiZweitstimmenVorperiode != null ? !tierschutzparteiZweitstimmenVorperiode.equals(that.tierschutzparteiZweitstimmenVorperiode) : that.tierschutzparteiZweitstimmenVorperiode != null)
            return false;
        if (oedpErststimmenVorlaeufig != null ? !oedpErststimmenVorlaeufig.equals(that.oedpErststimmenVorlaeufig) : that.oedpErststimmenVorlaeufig != null)
            return false;
        if (oedpErststimmenVorperiode != null ? !oedpErststimmenVorperiode.equals(that.oedpErststimmenVorperiode) : that.oedpErststimmenVorperiode != null)
            return false;
        if (oedpZweitstimmenVorlaeufig != null ? !oedpZweitstimmenVorlaeufig.equals(that.oedpZweitstimmenVorlaeufig) : that.oedpZweitstimmenVorlaeufig != null)
            return false;
        if (oedpZweitstimmenVorperiode != null ? !oedpZweitstimmenVorperiode.equals(that.oedpZweitstimmenVorperiode) : that.oedpZweitstimmenVorperiode != null)
            return false;
        if (dieparteiErststimmenVorlaeufig != null ? !dieparteiErststimmenVorlaeufig.equals(that.dieparteiErststimmenVorlaeufig) : that.dieparteiErststimmenVorlaeufig != null)
            return false;
        if (dieparteiErststimmenVorperiode != null ? !dieparteiErststimmenVorperiode.equals(that.dieparteiErststimmenVorperiode) : that.dieparteiErststimmenVorperiode != null)
            return false;
        if (dieparteiZweitstimmenVorlaeufig != null ? !dieparteiZweitstimmenVorlaeufig.equals(that.dieparteiZweitstimmenVorlaeufig) : that.dieparteiZweitstimmenVorlaeufig != null)
            return false;
        if (dieparteiZweitstimmenVorperiode != null ? !dieparteiZweitstimmenVorperiode.equals(that.dieparteiZweitstimmenVorperiode) : that.dieparteiZweitstimmenVorperiode != null)
            return false;
        if (bayernparteiErststimmenVorlaeufig != null ? !bayernparteiErststimmenVorlaeufig.equals(that.bayernparteiErststimmenVorlaeufig) : that.bayernparteiErststimmenVorlaeufig != null)
            return false;
        if (bayernparteiErststimmenVorperiode != null ? !bayernparteiErststimmenVorperiode.equals(that.bayernparteiErststimmenVorperiode) : that.bayernparteiErststimmenVorperiode != null)
            return false;
        if (bayernparteiZweitstimmenVorlaeufig != null ? !bayernparteiZweitstimmenVorlaeufig.equals(that.bayernparteiZweitstimmenVorlaeufig) : that.bayernparteiZweitstimmenVorlaeufig != null)
            return false;
        if (bayernparteiZweitstimmenVorperiode != null ? !bayernparteiZweitstimmenVorperiode.equals(that.bayernparteiZweitstimmenVorperiode) : that.bayernparteiZweitstimmenVorperiode != null)
            return false;
        if (volksabstimmungErststimmenVorlaeufig != null ? !volksabstimmungErststimmenVorlaeufig.equals(that.volksabstimmungErststimmenVorlaeufig) : that.volksabstimmungErststimmenVorlaeufig != null)
            return false;
        if (volksabstimmungErststimmenVorperiode != null ? !volksabstimmungErststimmenVorperiode.equals(that.volksabstimmungErststimmenVorperiode) : that.volksabstimmungErststimmenVorperiode != null)
            return false;
        if (volksabstimmungZweitstimmenVorlaeufig != null ? !volksabstimmungZweitstimmenVorlaeufig.equals(that.volksabstimmungZweitstimmenVorlaeufig) : that.volksabstimmungZweitstimmenVorlaeufig != null)
            return false;
        if (volksabstimmungZweitstimmenVorperiode != null ? !volksabstimmungZweitstimmenVorperiode.equals(that.volksabstimmungZweitstimmenVorperiode) : that.volksabstimmungZweitstimmenVorperiode != null)
            return false;
        if (pdvErststimmenVorlaeufig != null ? !pdvErststimmenVorlaeufig.equals(that.pdvErststimmenVorlaeufig) : that.pdvErststimmenVorlaeufig != null)
            return false;
        if (pdvErststimmenVorperiode != null ? !pdvErststimmenVorperiode.equals(that.pdvErststimmenVorperiode) : that.pdvErststimmenVorperiode != null)
            return false;
        if (pdvZweitstimmenVorlaeufig != null ? !pdvZweitstimmenVorlaeufig.equals(that.pdvZweitstimmenVorlaeufig) : that.pdvZweitstimmenVorlaeufig != null)
            return false;
        if (pdvZweitstimmenVorperiode != null ? !pdvZweitstimmenVorperiode.equals(that.pdvZweitstimmenVorperiode) : that.pdvZweitstimmenVorperiode != null)
            return false;
        if (mlpdErststimmenVorlaeufig != null ? !mlpdErststimmenVorlaeufig.equals(that.mlpdErststimmenVorlaeufig) : that.mlpdErststimmenVorlaeufig != null)
            return false;
        if (mlpdErststimmenVorperiode != null ? !mlpdErststimmenVorperiode.equals(that.mlpdErststimmenVorperiode) : that.mlpdErststimmenVorperiode != null)
            return false;
        if (mlpdZweitstimmenVorlaeufig != null ? !mlpdZweitstimmenVorlaeufig.equals(that.mlpdZweitstimmenVorlaeufig) : that.mlpdZweitstimmenVorlaeufig != null)
            return false;
        if (mlpdZweitstimmenVorperiode != null ? !mlpdZweitstimmenVorperiode.equals(that.mlpdZweitstimmenVorperiode) : that.mlpdZweitstimmenVorperiode != null)
            return false;
        if (buesoErststimmenVorlaeufig != null ? !buesoErststimmenVorlaeufig.equals(that.buesoErststimmenVorlaeufig) : that.buesoErststimmenVorlaeufig != null)
            return false;
        if (buesoErststimmenVorperiode != null ? !buesoErststimmenVorperiode.equals(that.buesoErststimmenVorperiode) : that.buesoErststimmenVorperiode != null)
            return false;
        if (buesoZweitstimmenVorlaeufig != null ? !buesoZweitstimmenVorlaeufig.equals(that.buesoZweitstimmenVorlaeufig) : that.buesoZweitstimmenVorlaeufig != null)
            return false;
        if (buesoZweitstimmenVorperiode != null ? !buesoZweitstimmenVorperiode.equals(that.buesoZweitstimmenVorperiode) : that.buesoZweitstimmenVorperiode != null)
            return false;
        if (sgpErststimmenVorlaeufig != null ? !sgpErststimmenVorlaeufig.equals(that.sgpErststimmenVorlaeufig) : that.sgpErststimmenVorlaeufig != null)
            return false;
        if (sgpErststimmenVorperiode != null ? !sgpErststimmenVorperiode.equals(that.sgpErststimmenVorperiode) : that.sgpErststimmenVorperiode != null)
            return false;
        if (sgpZweitstimmenVorlaeufig != null ? !sgpZweitstimmenVorlaeufig.equals(that.sgpZweitstimmenVorlaeufig) : that.sgpZweitstimmenVorlaeufig != null)
            return false;
        if (sgpZweitstimmenVorperiode != null ? !sgpZweitstimmenVorperiode.equals(that.sgpZweitstimmenVorperiode) : that.sgpZweitstimmenVorperiode != null)
            return false;
        if (dierechteErststimmenVorlaeufig != null ? !dierechteErststimmenVorlaeufig.equals(that.dierechteErststimmenVorlaeufig) : that.dierechteErststimmenVorlaeufig != null)
            return false;
        if (dierechteErststimmenVorperiode != null ? !dierechteErststimmenVorperiode.equals(that.dierechteErststimmenVorperiode) : that.dierechteErststimmenVorperiode != null)
            return false;
        if (dierechteZweitstimmenVorlaeufig != null ? !dierechteZweitstimmenVorlaeufig.equals(that.dierechteZweitstimmenVorlaeufig) : that.dierechteZweitstimmenVorlaeufig != null)
            return false;
        if (dierechteZweitstimmenVorperiode != null ? !dierechteZweitstimmenVorperiode.equals(that.dierechteZweitstimmenVorperiode) : that.dierechteZweitstimmenVorperiode != null)
            return false;
        if (addErststimmenVorlaeufig != null ? !addErststimmenVorlaeufig.equals(that.addErststimmenVorlaeufig) : that.addErststimmenVorlaeufig != null)
            return false;
        if (addErststimmenVorperiode != null ? !addErststimmenVorperiode.equals(that.addErststimmenVorperiode) : that.addErststimmenVorperiode != null)
            return false;
        if (addZweitstimmenVorlaeufig != null ? !addZweitstimmenVorlaeufig.equals(that.addZweitstimmenVorlaeufig) : that.addZweitstimmenVorlaeufig != null)
            return false;
        if (addZweitstimmenVorperiode != null ? !addZweitstimmenVorperiode.equals(that.addZweitstimmenVorperiode) : that.addZweitstimmenVorperiode != null)
            return false;
        if (tierschutzallianzErststimmenVorlaeufig != null ? !tierschutzallianzErststimmenVorlaeufig.equals(that.tierschutzallianzErststimmenVorlaeufig) : that.tierschutzallianzErststimmenVorlaeufig != null)
            return false;
        if (tierschutzallianzErststimmenVorperiode != null ? !tierschutzallianzErststimmenVorperiode.equals(that.tierschutzallianzErststimmenVorperiode) : that.tierschutzallianzErststimmenVorperiode != null)
            return false;
        if (tierschutzallianzZweitstimmenVorlaeufig != null ? !tierschutzallianzZweitstimmenVorlaeufig.equals(that.tierschutzallianzZweitstimmenVorlaeufig) : that.tierschutzallianzZweitstimmenVorlaeufig != null)
            return false;
        if (tierschutzallianzZweitstimmenVorperiode != null ? !tierschutzallianzZweitstimmenVorperiode.equals(that.tierschutzallianzZweitstimmenVorperiode) : that.tierschutzallianzZweitstimmenVorperiode != null)
            return false;
        if (bergparteiErststimmenVorlaeufig != null ? !bergparteiErststimmenVorlaeufig.equals(that.bergparteiErststimmenVorlaeufig) : that.bergparteiErststimmenVorlaeufig != null)
            return false;
        if (bergparteiErststimmenVorperiode != null ? !bergparteiErststimmenVorperiode.equals(that.bergparteiErststimmenVorperiode) : that.bergparteiErststimmenVorperiode != null)
            return false;
        if (bergparteiZweitstimmenVorlaeufig != null ? !bergparteiZweitstimmenVorlaeufig.equals(that.bergparteiZweitstimmenVorlaeufig) : that.bergparteiZweitstimmenVorlaeufig != null)
            return false;
        if (bergparteiZweitstimmenVorperiode != null ? !bergparteiZweitstimmenVorperiode.equals(that.bergparteiZweitstimmenVorperiode) : that.bergparteiZweitstimmenVorperiode != null)
            return false;
        if (bgeErststimmenVorlaeufig != null ? !bgeErststimmenVorlaeufig.equals(that.bgeErststimmenVorlaeufig) : that.bgeErststimmenVorlaeufig != null)
            return false;
        if (bgeErststimmenVorperiode != null ? !bgeErststimmenVorperiode.equals(that.bgeErststimmenVorperiode) : that.bgeErststimmenVorperiode != null)
            return false;
        if (bgeZweitstimmenVorlaeufig != null ? !bgeZweitstimmenVorlaeufig.equals(that.bgeZweitstimmenVorlaeufig) : that.bgeZweitstimmenVorlaeufig != null)
            return false;
        if (bgeZweitstimmenVorperiode != null ? !bgeZweitstimmenVorperiode.equals(that.bgeZweitstimmenVorperiode) : that.bgeZweitstimmenVorperiode != null)
            return false;
        if (dibErststimmenVorlaeufig != null ? !dibErststimmenVorlaeufig.equals(that.dibErststimmenVorlaeufig) : that.dibErststimmenVorlaeufig != null)
            return false;
        if (dibErststimmenVorperiode != null ? !dibErststimmenVorperiode.equals(that.dibErststimmenVorperiode) : that.dibErststimmenVorperiode != null)
            return false;
        if (dibZweitstimmenVorlaeufig != null ? !dibZweitstimmenVorlaeufig.equals(that.dibZweitstimmenVorlaeufig) : that.dibZweitstimmenVorlaeufig != null)
            return false;
        if (dibZweitstimmenVorperiode != null ? !dibZweitstimmenVorperiode.equals(that.dibZweitstimmenVorperiode) : that.dibZweitstimmenVorperiode != null)
            return false;
        if (dkpErststimmenVorlaeufig != null ? !dkpErststimmenVorlaeufig.equals(that.dkpErststimmenVorlaeufig) : that.dkpErststimmenVorlaeufig != null)
            return false;
        if (dkpErststimmenVorperiode != null ? !dkpErststimmenVorperiode.equals(that.dkpErststimmenVorperiode) : that.dkpErststimmenVorperiode != null)
            return false;
        if (dkpZweitstimmenVorlaeufig != null ? !dkpZweitstimmenVorlaeufig.equals(that.dkpZweitstimmenVorlaeufig) : that.dkpZweitstimmenVorlaeufig != null)
            return false;
        if (dkpZweitstimmenVorperiode != null ? !dkpZweitstimmenVorperiode.equals(that.dkpZweitstimmenVorperiode) : that.dkpZweitstimmenVorperiode != null)
            return false;
        if (dmErststimmenVorlaeufig != null ? !dmErststimmenVorlaeufig.equals(that.dmErststimmenVorlaeufig) : that.dmErststimmenVorlaeufig != null)
            return false;
        if (dmErststimmenVorperiode != null ? !dmErststimmenVorperiode.equals(that.dmErststimmenVorperiode) : that.dmErststimmenVorperiode != null)
            return false;
        if (dmZweitstimmenVorlaeufig != null ? !dmZweitstimmenVorlaeufig.equals(that.dmZweitstimmenVorlaeufig) : that.dmZweitstimmenVorlaeufig != null)
            return false;
        if (dmZweitstimmenVorperiode != null ? !dmZweitstimmenVorperiode.equals(that.dmZweitstimmenVorperiode) : that.dmZweitstimmenVorperiode != null)
            return false;
        if (diegrauenErststimmenVorlaeufig != null ? !diegrauenErststimmenVorlaeufig.equals(that.diegrauenErststimmenVorlaeufig) : that.diegrauenErststimmenVorlaeufig != null)
            return false;
        if (diegrauenErststimmenVorperiode != null ? !diegrauenErststimmenVorperiode.equals(that.diegrauenErststimmenVorperiode) : that.diegrauenErststimmenVorperiode != null)
            return false;
        if (diegrauenZweitstimmenVorlaeufig != null ? !diegrauenZweitstimmenVorlaeufig.equals(that.diegrauenZweitstimmenVorlaeufig) : that.diegrauenZweitstimmenVorlaeufig != null)
            return false;
        if (diegrauenZweitstimmenVorperiode != null ? !diegrauenZweitstimmenVorperiode.equals(that.diegrauenZweitstimmenVorperiode) : that.diegrauenZweitstimmenVorperiode != null)
            return false;
        if (duErststimmenVorlaeufig != null ? !duErststimmenVorlaeufig.equals(that.duErststimmenVorlaeufig) : that.duErststimmenVorlaeufig != null)
            return false;
        if (duErststimmenVorperiode != null ? !duErststimmenVorperiode.equals(that.duErststimmenVorperiode) : that.duErststimmenVorperiode != null)
            return false;
        if (duZweitstimmenVorlaeufig != null ? !duZweitstimmenVorlaeufig.equals(that.duZweitstimmenVorlaeufig) : that.duZweitstimmenVorlaeufig != null)
            return false;
        if (duZweitstimmenVorperiode != null ? !duZweitstimmenVorperiode.equals(that.duZweitstimmenVorperiode) : that.duZweitstimmenVorperiode != null)
            return false;
        if (mgErststimmenVorlaeufig != null ? !mgErststimmenVorlaeufig.equals(that.mgErststimmenVorlaeufig) : that.mgErststimmenVorlaeufig != null)
            return false;
        if (mgErststimmenVorperiode != null ? !mgErststimmenVorperiode.equals(that.mgErststimmenVorperiode) : that.mgErststimmenVorperiode != null)
            return false;
        if (mgZweitstimmenVorlaeufig != null ? !mgZweitstimmenVorlaeufig.equals(that.mgZweitstimmenVorlaeufig) : that.mgZweitstimmenVorlaeufig != null)
            return false;
        if (mgZweitstimmenVorperiode != null ? !mgZweitstimmenVorperiode.equals(that.mgZweitstimmenVorperiode) : that.mgZweitstimmenVorperiode != null)
            return false;
        if (menschlicheweltErststimmenVorlaeufig != null ? !menschlicheweltErststimmenVorlaeufig.equals(that.menschlicheweltErststimmenVorlaeufig) : that.menschlicheweltErststimmenVorlaeufig != null)
            return false;
        if (menschlicheweltErststimmenVorperiode != null ? !menschlicheweltErststimmenVorperiode.equals(that.menschlicheweltErststimmenVorperiode) : that.menschlicheweltErststimmenVorperiode != null)
            return false;
        if (menschlicheweltZweitstimmenVorlaeufig != null ? !menschlicheweltZweitstimmenVorlaeufig.equals(that.menschlicheweltZweitstimmenVorlaeufig) : that.menschlicheweltZweitstimmenVorlaeufig != null)
            return false;
        if (menschlicheweltZweitstimmenVorperiode != null ? !menschlicheweltZweitstimmenVorperiode.equals(that.menschlicheweltZweitstimmenVorperiode) : that.menschlicheweltZweitstimmenVorperiode != null)
            return false;
        if (diehumanistenErststimmenVorlaeufig != null ? !diehumanistenErststimmenVorlaeufig.equals(that.diehumanistenErststimmenVorlaeufig) : that.diehumanistenErststimmenVorlaeufig != null)
            return false;
        if (diehumanistenErststimmenVorperiode != null ? !diehumanistenErststimmenVorperiode.equals(that.diehumanistenErststimmenVorperiode) : that.diehumanistenErststimmenVorperiode != null)
            return false;
        if (diehumanistenZweitstimmenVorlaeufig != null ? !diehumanistenZweitstimmenVorlaeufig.equals(that.diehumanistenZweitstimmenVorlaeufig) : that.diehumanistenZweitstimmenVorlaeufig != null)
            return false;
        if (diehumanistenZweitstimmenVorperiode != null ? !diehumanistenZweitstimmenVorperiode.equals(that.diehumanistenZweitstimmenVorperiode) : that.diehumanistenZweitstimmenVorperiode != null)
            return false;
        if (gesundheitsforschungErststimmenVorlaeufig != null ? !gesundheitsforschungErststimmenVorlaeufig.equals(that.gesundheitsforschungErststimmenVorlaeufig) : that.gesundheitsforschungErststimmenVorlaeufig != null)
            return false;
        if (gesundheitsforschungErststimmenVorperiode != null ? !gesundheitsforschungErststimmenVorperiode.equals(that.gesundheitsforschungErststimmenVorperiode) : that.gesundheitsforschungErststimmenVorperiode != null)
            return false;
        if (gesundheitsforschungZweitstimmenVorlaeufig != null ? !gesundheitsforschungZweitstimmenVorlaeufig.equals(that.gesundheitsforschungZweitstimmenVorlaeufig) : that.gesundheitsforschungZweitstimmenVorlaeufig != null)
            return false;
        if (gesundheitsforschungZweitstimmenVorperiode != null ? !gesundheitsforschungZweitstimmenVorperiode.equals(that.gesundheitsforschungZweitstimmenVorperiode) : that.gesundheitsforschungZweitstimmenVorperiode != null)
            return false;
        if (vparteiErststimmenVorlaeufig != null ? !vparteiErststimmenVorlaeufig.equals(that.vparteiErststimmenVorlaeufig) : that.vparteiErststimmenVorlaeufig != null)
            return false;
        if (vparteiErststimmenVorperiode != null ? !vparteiErststimmenVorperiode.equals(that.vparteiErststimmenVorperiode) : that.vparteiErststimmenVorperiode != null)
            return false;
        if (vparteiZweitstimmenVorlaeufig != null ? !vparteiZweitstimmenVorlaeufig.equals(that.vparteiZweitstimmenVorlaeufig) : that.vparteiZweitstimmenVorlaeufig != null)
            return false;
        if (vparteiZweitstimmenVorperiode != null ? !vparteiZweitstimmenVorperiode.equals(that.vparteiZweitstimmenVorperiode) : that.vparteiZweitstimmenVorperiode != null)
            return false;
        if (buendniscErststimmenVorlaeufig != null ? !buendniscErststimmenVorlaeufig.equals(that.buendniscErststimmenVorlaeufig) : that.buendniscErststimmenVorlaeufig != null)
            return false;
        if (buendniscErststimmenVorperiode != null ? !buendniscErststimmenVorperiode.equals(that.buendniscErststimmenVorperiode) : that.buendniscErststimmenVorperiode != null)
            return false;
        if (buendniscZweitstimmenVorlaeufig != null ? !buendniscZweitstimmenVorlaeufig.equals(that.buendniscZweitstimmenVorlaeufig) : that.buendniscZweitstimmenVorlaeufig != null)
            return false;
        if (buendniscZweitstimmenVorperiode != null ? !buendniscZweitstimmenVorperiode.equals(that.buendniscZweitstimmenVorperiode) : that.buendniscZweitstimmenVorperiode != null)
            return false;
        if (dieeinheitErststimmenVorlaeufig != null ? !dieeinheitErststimmenVorlaeufig.equals(that.dieeinheitErststimmenVorlaeufig) : that.dieeinheitErststimmenVorlaeufig != null)
            return false;
        if (dieeinheitErststimmenVorperiode != null ? !dieeinheitErststimmenVorperiode.equals(that.dieeinheitErststimmenVorperiode) : that.dieeinheitErststimmenVorperiode != null)
            return false;
        if (dieeinheitZweitstimmenVorlaeufig != null ? !dieeinheitZweitstimmenVorlaeufig.equals(that.dieeinheitZweitstimmenVorlaeufig) : that.dieeinheitZweitstimmenVorlaeufig != null)
            return false;
        if (dieeinheitZweitstimmenVorperiode != null ? !dieeinheitZweitstimmenVorperiode.equals(that.dieeinheitZweitstimmenVorperiode) : that.dieeinheitZweitstimmenVorperiode != null)
            return false;
        if (dieviolettenErststimmenVorlaeufig != null ? !dieviolettenErststimmenVorlaeufig.equals(that.dieviolettenErststimmenVorlaeufig) : that.dieviolettenErststimmenVorlaeufig != null)
            return false;
        if (dieviolettenErststimmenVorperiode != null ? !dieviolettenErststimmenVorperiode.equals(that.dieviolettenErststimmenVorperiode) : that.dieviolettenErststimmenVorperiode != null)
            return false;
        if (dieviolettenZweitstimmenVorlaeufig != null ? !dieviolettenZweitstimmenVorlaeufig.equals(that.dieviolettenZweitstimmenVorlaeufig) : that.dieviolettenZweitstimmenVorlaeufig != null)
            return false;
        if (dieviolettenZweitstimmenVorperiode != null ? !dieviolettenZweitstimmenVorperiode.equals(that.dieviolettenZweitstimmenVorperiode) : that.dieviolettenZweitstimmenVorperiode != null)
            return false;
        if (familieErststimmenVorlaeufig != null ? !familieErststimmenVorlaeufig.equals(that.familieErststimmenVorlaeufig) : that.familieErststimmenVorlaeufig != null)
            return false;
        if (familieErststimmenVorperiode != null ? !familieErststimmenVorperiode.equals(that.familieErststimmenVorperiode) : that.familieErststimmenVorperiode != null)
            return false;
        if (familieZweitstimmenVorlaeufig != null ? !familieZweitstimmenVorlaeufig.equals(that.familieZweitstimmenVorlaeufig) : that.familieZweitstimmenVorlaeufig != null)
            return false;
        if (familieZweitstimmenVorperiode != null ? !familieZweitstimmenVorperiode.equals(that.familieZweitstimmenVorperiode) : that.familieZweitstimmenVorperiode != null)
            return false;
        if (diefrauenErststimmenVorlaeufig != null ? !diefrauenErststimmenVorlaeufig.equals(that.diefrauenErststimmenVorlaeufig) : that.diefrauenErststimmenVorlaeufig != null)
            return false;
        if (diefrauenErststimmenVorperiode != null ? !diefrauenErststimmenVorperiode.equals(that.diefrauenErststimmenVorperiode) : that.diefrauenErststimmenVorperiode != null)
            return false;
        if (diefrauenZweitstimmenVorlaeufig != null ? !diefrauenZweitstimmenVorlaeufig.equals(that.diefrauenZweitstimmenVorlaeufig) : that.diefrauenZweitstimmenVorlaeufig != null)
            return false;
        if (diefrauenZweitstimmenVorperiode != null ? !diefrauenZweitstimmenVorperiode.equals(that.diefrauenZweitstimmenVorperiode) : that.diefrauenZweitstimmenVorperiode != null)
            return false;
        if (mieterparteiErststimmenVorlaeufig != null ? !mieterparteiErststimmenVorlaeufig.equals(that.mieterparteiErststimmenVorlaeufig) : that.mieterparteiErststimmenVorlaeufig != null)
            return false;
        if (mieterparteiErststimmenVorperiode != null ? !mieterparteiErststimmenVorperiode.equals(that.mieterparteiErststimmenVorperiode) : that.mieterparteiErststimmenVorperiode != null)
            return false;
        if (mieterparteiZweitstimmenVorlaeufig != null ? !mieterparteiZweitstimmenVorlaeufig.equals(that.mieterparteiZweitstimmenVorlaeufig) : that.mieterparteiZweitstimmenVorlaeufig != null)
            return false;
        if (mieterparteiZweitstimmenVorperiode != null ? !mieterparteiZweitstimmenVorperiode.equals(that.mieterparteiZweitstimmenVorperiode) : that.mieterparteiZweitstimmenVorperiode != null)
            return false;
        if (neueliberaleErststimmenVorlaeufig != null ? !neueliberaleErststimmenVorlaeufig.equals(that.neueliberaleErststimmenVorlaeufig) : that.neueliberaleErststimmenVorlaeufig != null)
            return false;
        if (neueliberaleErststimmenVorperiode != null ? !neueliberaleErststimmenVorperiode.equals(that.neueliberaleErststimmenVorperiode) : that.neueliberaleErststimmenVorperiode != null)
            return false;
        if (neueliberaleZweitstimmenVorlaeufig != null ? !neueliberaleZweitstimmenVorlaeufig.equals(that.neueliberaleZweitstimmenVorlaeufig) : that.neueliberaleZweitstimmenVorlaeufig != null)
            return false;
        if (neueliberaleZweitstimmenVorperiode != null ? !neueliberaleZweitstimmenVorperiode.equals(that.neueliberaleZweitstimmenVorperiode) : that.neueliberaleZweitstimmenVorperiode != null)
            return false;
        if (unabhaengigeErststimmenVorlaeufig != null ? !unabhaengigeErststimmenVorlaeufig.equals(that.unabhaengigeErststimmenVorlaeufig) : that.unabhaengigeErststimmenVorlaeufig != null)
            return false;
        if (unabhaengigeErststimmenVorperiode != null ? !unabhaengigeErststimmenVorperiode.equals(that.unabhaengigeErststimmenVorperiode) : that.unabhaengigeErststimmenVorperiode != null)
            return false;
        if (unabhaengigeZweitstimmenVorlaeufig != null ? !unabhaengigeZweitstimmenVorlaeufig.equals(that.unabhaengigeZweitstimmenVorlaeufig) : that.unabhaengigeZweitstimmenVorlaeufig != null)
            return false;
        if (unabhaengigeZweitstimmenVorperiode != null ? !unabhaengigeZweitstimmenVorperiode.equals(that.unabhaengigeZweitstimmenVorperiode) : that.unabhaengigeZweitstimmenVorperiode != null)
            return false;
        if (uebrigeErststimmenVorlaeufig != null ? !uebrigeErststimmenVorlaeufig.equals(that.uebrigeErststimmenVorlaeufig) : that.uebrigeErststimmenVorlaeufig != null)
            return false;
        if (uebrigeErststimmenVorperiode != null ? !uebrigeErststimmenVorperiode.equals(that.uebrigeErststimmenVorperiode) : that.uebrigeErststimmenVorperiode != null)
            return false;
        if (uebrigeZweitstimmenVorlaeufig != null ? !uebrigeZweitstimmenVorlaeufig.equals(that.uebrigeZweitstimmenVorlaeufig) : that.uebrigeZweitstimmenVorlaeufig != null)
            return false;
        return uebrigeZweitstimmenVorperiode != null ? uebrigeZweitstimmenVorperiode.equals(that.uebrigeZweitstimmenVorperiode) : that.uebrigeZweitstimmenVorperiode == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wahlkreisNummer != null ? wahlkreisNummer.hashCode() : 0);
        result = 31 * result + (wahlkreisName != null ? wahlkreisName.hashCode() : 0);
        result = 31 * result + (bundeslandNummer != null ? bundeslandNummer.hashCode() : 0);
        result = 31 * result + (wahlberechtigteErststimmenVorlaeufig != null ? wahlberechtigteErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (wahlberechtigteErststimmenVorperiode != null ? wahlberechtigteErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (wahlberechtigteZweitstimmenVorlaeufig != null ? wahlberechtigteZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (wahlberechtigteZweitstimmenVorperiode != null ? wahlberechtigteZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (waehlerErststimmenVorlaeufig != null ? waehlerErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (waehlerErststimmenVorperiode != null ? waehlerErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (waehlerZweitstimmenVorlaeufig != null ? waehlerZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (waehlerZweitstimmenVorperiode != null ? waehlerZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (ungueltigeErststimmenVorlaeufig != null ? ungueltigeErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (ungueltigeErststimmenVorperiode != null ? ungueltigeErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (ungueltigeZweitstimmenVorlaeufig != null ? ungueltigeZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (ungueltigeZweitstimmenVorperiode != null ? ungueltigeZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (gueltigeErststimmenVorlaeufig != null ? gueltigeErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (gueltigeErststimmenVorperiode != null ? gueltigeErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (gueltigeZweitstimmenVorlaeufig != null ? gueltigeZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (gueltigeZweitstimmenVorperiode != null ? gueltigeZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (cduErststimmenVorlaeufig != null ? cduErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (cduErststimmenVorperiode != null ? cduErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (cduZweitstimmenVorlaeufig != null ? cduZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (cduZweitstimmenVorperiode != null ? cduZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (spdErststimmenVorlaeufig != null ? spdErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (spdErststimmenVorperiode != null ? spdErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (spdZweitstimmenVorlaeufig != null ? spdZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (spdZweitstimmenVorperiode != null ? spdZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dielinkeErststimmenVorlaeufig != null ? dielinkeErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dielinkeErststimmenVorperiode != null ? dielinkeErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dielinkeZweitstimmenVorlaeufig != null ? dielinkeZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dielinkeZweitstimmenVorperiode != null ? dielinkeZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diegruenenErststimmenVorlaeufig != null ? diegruenenErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diegruenenErststimmenVorperiode != null ? diegruenenErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diegruenenZweitstimmenVorlaeufig != null ? diegruenenZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diegruenenZweitstimmenVorperiode != null ? diegruenenZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (csuErststimmenVorlaeufig != null ? csuErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (csuErststimmenVorperiode != null ? csuErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (csuZweitstimmenVorlaeufig != null ? csuZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (csuZweitstimmenVorperiode != null ? csuZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (fdpErststimmenVorlaeufig != null ? fdpErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (fdpErststimmenVorperiode != null ? fdpErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (fdpZweitstimmenVorlaeufig != null ? fdpZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (fdpZweitstimmenVorperiode != null ? fdpZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (afdErststimmenVorlaeufig != null ? afdErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (afdErststimmenVorperiode != null ? afdErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (afdZweitstimmenVorlaeufig != null ? afdZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (afdZweitstimmenVorperiode != null ? afdZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (piratenparteiErststimmenVorlaeufig != null ? piratenparteiErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (piratenparteiErststimmenVorperiode != null ? piratenparteiErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (piratenparteiZweitstimmenVorlaeufig != null ? piratenparteiZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (piratenparteiZweitstimmenVorperiode != null ? piratenparteiZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (npdErststimmenVorlaeufig != null ? npdErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (npdErststimmenVorperiode != null ? npdErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (npdZweitstimmenVorlaeufig != null ? npdZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (npdZweitstimmenVorperiode != null ? npdZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (freieWaehlerErststimmenVorlaeufig != null ? freieWaehlerErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (freieWaehlerErststimmenVorperiode != null ? freieWaehlerErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (freieWaehlerZweitstimmenVorlaeufig != null ? freieWaehlerZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (freieWaehlerZweitstimmenVorperiode != null ? freieWaehlerZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (tierschutzparteiErststimmenVorlaeufig != null ? tierschutzparteiErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (tierschutzparteiErststimmenVorperiode != null ? tierschutzparteiErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (tierschutzparteiZweitstimmenVorlaeufig != null ? tierschutzparteiZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (tierschutzparteiZweitstimmenVorperiode != null ? tierschutzparteiZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (oedpErststimmenVorlaeufig != null ? oedpErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (oedpErststimmenVorperiode != null ? oedpErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (oedpZweitstimmenVorlaeufig != null ? oedpZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (oedpZweitstimmenVorperiode != null ? oedpZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dieparteiErststimmenVorlaeufig != null ? dieparteiErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dieparteiErststimmenVorperiode != null ? dieparteiErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dieparteiZweitstimmenVorlaeufig != null ? dieparteiZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dieparteiZweitstimmenVorperiode != null ? dieparteiZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (bayernparteiErststimmenVorlaeufig != null ? bayernparteiErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (bayernparteiErststimmenVorperiode != null ? bayernparteiErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (bayernparteiZweitstimmenVorlaeufig != null ? bayernparteiZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (bayernparteiZweitstimmenVorperiode != null ? bayernparteiZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (volksabstimmungErststimmenVorlaeufig != null ? volksabstimmungErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (volksabstimmungErststimmenVorperiode != null ? volksabstimmungErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (volksabstimmungZweitstimmenVorlaeufig != null ? volksabstimmungZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (volksabstimmungZweitstimmenVorperiode != null ? volksabstimmungZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (pdvErststimmenVorlaeufig != null ? pdvErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (pdvErststimmenVorperiode != null ? pdvErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (pdvZweitstimmenVorlaeufig != null ? pdvZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (pdvZweitstimmenVorperiode != null ? pdvZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (mlpdErststimmenVorlaeufig != null ? mlpdErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (mlpdErststimmenVorperiode != null ? mlpdErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (mlpdZweitstimmenVorlaeufig != null ? mlpdZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (mlpdZweitstimmenVorperiode != null ? mlpdZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (buesoErststimmenVorlaeufig != null ? buesoErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (buesoErststimmenVorperiode != null ? buesoErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (buesoZweitstimmenVorlaeufig != null ? buesoZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (buesoZweitstimmenVorperiode != null ? buesoZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (sgpErststimmenVorlaeufig != null ? sgpErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (sgpErststimmenVorperiode != null ? sgpErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (sgpZweitstimmenVorlaeufig != null ? sgpZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (sgpZweitstimmenVorperiode != null ? sgpZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dierechteErststimmenVorlaeufig != null ? dierechteErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dierechteErststimmenVorperiode != null ? dierechteErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dierechteZweitstimmenVorlaeufig != null ? dierechteZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dierechteZweitstimmenVorperiode != null ? dierechteZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (addErststimmenVorlaeufig != null ? addErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (addErststimmenVorperiode != null ? addErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (addZweitstimmenVorlaeufig != null ? addZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (addZweitstimmenVorperiode != null ? addZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (tierschutzallianzErststimmenVorlaeufig != null ? tierschutzallianzErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (tierschutzallianzErststimmenVorperiode != null ? tierschutzallianzErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (tierschutzallianzZweitstimmenVorlaeufig != null ? tierschutzallianzZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (tierschutzallianzZweitstimmenVorperiode != null ? tierschutzallianzZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (bergparteiErststimmenVorlaeufig != null ? bergparteiErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (bergparteiErststimmenVorperiode != null ? bergparteiErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (bergparteiZweitstimmenVorlaeufig != null ? bergparteiZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (bergparteiZweitstimmenVorperiode != null ? bergparteiZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (bgeErststimmenVorlaeufig != null ? bgeErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (bgeErststimmenVorperiode != null ? bgeErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (bgeZweitstimmenVorlaeufig != null ? bgeZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (bgeZweitstimmenVorperiode != null ? bgeZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dibErststimmenVorlaeufig != null ? dibErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dibErststimmenVorperiode != null ? dibErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dibZweitstimmenVorlaeufig != null ? dibZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dibZweitstimmenVorperiode != null ? dibZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dkpErststimmenVorlaeufig != null ? dkpErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dkpErststimmenVorperiode != null ? dkpErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dkpZweitstimmenVorlaeufig != null ? dkpZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dkpZweitstimmenVorperiode != null ? dkpZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dmErststimmenVorlaeufig != null ? dmErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dmErststimmenVorperiode != null ? dmErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dmZweitstimmenVorlaeufig != null ? dmZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dmZweitstimmenVorperiode != null ? dmZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diegrauenErststimmenVorlaeufig != null ? diegrauenErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diegrauenErststimmenVorperiode != null ? diegrauenErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diegrauenZweitstimmenVorlaeufig != null ? diegrauenZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diegrauenZweitstimmenVorperiode != null ? diegrauenZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (duErststimmenVorlaeufig != null ? duErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (duErststimmenVorperiode != null ? duErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (duZweitstimmenVorlaeufig != null ? duZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (duZweitstimmenVorperiode != null ? duZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (mgErststimmenVorlaeufig != null ? mgErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (mgErststimmenVorperiode != null ? mgErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (mgZweitstimmenVorlaeufig != null ? mgZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (mgZweitstimmenVorperiode != null ? mgZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (menschlicheweltErststimmenVorlaeufig != null ? menschlicheweltErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (menschlicheweltErststimmenVorperiode != null ? menschlicheweltErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (menschlicheweltZweitstimmenVorlaeufig != null ? menschlicheweltZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (menschlicheweltZweitstimmenVorperiode != null ? menschlicheweltZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diehumanistenErststimmenVorlaeufig != null ? diehumanistenErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diehumanistenErststimmenVorperiode != null ? diehumanistenErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diehumanistenZweitstimmenVorlaeufig != null ? diehumanistenZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diehumanistenZweitstimmenVorperiode != null ? diehumanistenZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (gesundheitsforschungErststimmenVorlaeufig != null ? gesundheitsforschungErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (gesundheitsforschungErststimmenVorperiode != null ? gesundheitsforschungErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (gesundheitsforschungZweitstimmenVorlaeufig != null ? gesundheitsforschungZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (gesundheitsforschungZweitstimmenVorperiode != null ? gesundheitsforschungZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (vparteiErststimmenVorlaeufig != null ? vparteiErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (vparteiErststimmenVorperiode != null ? vparteiErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (vparteiZweitstimmenVorlaeufig != null ? vparteiZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (vparteiZweitstimmenVorperiode != null ? vparteiZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (buendniscErststimmenVorlaeufig != null ? buendniscErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (buendniscErststimmenVorperiode != null ? buendniscErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (buendniscZweitstimmenVorlaeufig != null ? buendniscZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (buendniscZweitstimmenVorperiode != null ? buendniscZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dieeinheitErststimmenVorlaeufig != null ? dieeinheitErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dieeinheitErststimmenVorperiode != null ? dieeinheitErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dieeinheitZweitstimmenVorlaeufig != null ? dieeinheitZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dieeinheitZweitstimmenVorperiode != null ? dieeinheitZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dieviolettenErststimmenVorlaeufig != null ? dieviolettenErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dieviolettenErststimmenVorperiode != null ? dieviolettenErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (dieviolettenZweitstimmenVorlaeufig != null ? dieviolettenZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (dieviolettenZweitstimmenVorperiode != null ? dieviolettenZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (familieErststimmenVorlaeufig != null ? familieErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (familieErststimmenVorperiode != null ? familieErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (familieZweitstimmenVorlaeufig != null ? familieZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (familieZweitstimmenVorperiode != null ? familieZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diefrauenErststimmenVorlaeufig != null ? diefrauenErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diefrauenErststimmenVorperiode != null ? diefrauenErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (diefrauenZweitstimmenVorlaeufig != null ? diefrauenZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (diefrauenZweitstimmenVorperiode != null ? diefrauenZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (mieterparteiErststimmenVorlaeufig != null ? mieterparteiErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (mieterparteiErststimmenVorperiode != null ? mieterparteiErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (mieterparteiZweitstimmenVorlaeufig != null ? mieterparteiZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (mieterparteiZweitstimmenVorperiode != null ? mieterparteiZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (neueliberaleErststimmenVorlaeufig != null ? neueliberaleErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (neueliberaleErststimmenVorperiode != null ? neueliberaleErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (neueliberaleZweitstimmenVorlaeufig != null ? neueliberaleZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (neueliberaleZweitstimmenVorperiode != null ? neueliberaleZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (unabhaengigeErststimmenVorlaeufig != null ? unabhaengigeErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (unabhaengigeErststimmenVorperiode != null ? unabhaengigeErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (unabhaengigeZweitstimmenVorlaeufig != null ? unabhaengigeZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (unabhaengigeZweitstimmenVorperiode != null ? unabhaengigeZweitstimmenVorperiode.hashCode() : 0);
        result = 31 * result + (uebrigeErststimmenVorlaeufig != null ? uebrigeErststimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (uebrigeErststimmenVorperiode != null ? uebrigeErststimmenVorperiode.hashCode() : 0);
        result = 31 * result + (uebrigeZweitstimmenVorlaeufig != null ? uebrigeZweitstimmenVorlaeufig.hashCode() : 0);
        result = 31 * result + (uebrigeZweitstimmenVorperiode != null ? uebrigeZweitstimmenVorperiode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Btw17Ergebnis{" +
                "id=" + id +
                ", wahlkreisNummer=" + wahlkreisNummer +
                ", wahlkreisName='" + wahlkreisName + '\'' +
                ", bundeslandNummer=" + bundeslandNummer +
                ", wahlberechtigteErststimmenVorlaeufig=" + wahlberechtigteErststimmenVorlaeufig +
                ", wahlberechtigteErststimmenVorperiode=" + wahlberechtigteErststimmenVorperiode +
                ", wahlberechtigteZweitstimmenVorlaeufig=" + wahlberechtigteZweitstimmenVorlaeufig +
                ", wahlberechtigteZweitstimmenVorperiode=" + wahlberechtigteZweitstimmenVorperiode +
                ", waehlerErststimmenVorlaeufig=" + waehlerErststimmenVorlaeufig +
                ", waehlerErststimmenVorperiode=" + waehlerErststimmenVorperiode +
                ", waehlerZweitstimmenVorlaeufig=" + waehlerZweitstimmenVorlaeufig +
                ", waehlerZweitstimmenVorperiode=" + waehlerZweitstimmenVorperiode +
                ", ungueltigeErststimmenVorlaeufig=" + ungueltigeErststimmenVorlaeufig +
                ", ungueltigeErststimmenVorperiode=" + ungueltigeErststimmenVorperiode +
                ", ungueltigeZweitstimmenVorlaeufig=" + ungueltigeZweitstimmenVorlaeufig +
                ", ungueltigeZweitstimmenVorperiode=" + ungueltigeZweitstimmenVorperiode +
                ", gueltigeErststimmenVorlaeufig=" + gueltigeErststimmenVorlaeufig +
                ", gueltigeErststimmenVorperiode=" + gueltigeErststimmenVorperiode +
                ", gueltigeZweitstimmenVorlaeufig=" + gueltigeZweitstimmenVorlaeufig +
                ", gueltigeZweitstimmenVorperiode=" + gueltigeZweitstimmenVorperiode +
                ", cduErststimmenVorlaeufig=" + cduErststimmenVorlaeufig +
                ", cduErststimmenVorperiode=" + cduErststimmenVorperiode +
                ", cduZweitstimmenVorlaeufig=" + cduZweitstimmenVorlaeufig +
                ", cduZweitstimmenVorperiode=" + cduZweitstimmenVorperiode +
                ", spdErststimmenVorlaeufig=" + spdErststimmenVorlaeufig +
                ", spdErststimmenVorperiode=" + spdErststimmenVorperiode +
                ", spdZweitstimmenVorlaeufig=" + spdZweitstimmenVorlaeufig +
                ", spdZweitstimmenVorperiode=" + spdZweitstimmenVorperiode +
                ", dielinkeErststimmenVorlaeufig=" + dielinkeErststimmenVorlaeufig +
                ", dielinkeErststimmenVorperiode=" + dielinkeErststimmenVorperiode +
                ", dielinkeZweitstimmenVorlaeufig=" + dielinkeZweitstimmenVorlaeufig +
                ", dielinkeZweitstimmenVorperiode=" + dielinkeZweitstimmenVorperiode +
                ", diegruenenErststimmenVorlaeufig=" + diegruenenErststimmenVorlaeufig +
                ", diegruenenErststimmenVorperiode=" + diegruenenErststimmenVorperiode +
                ", diegruenenZweitstimmenVorlaeufig=" + diegruenenZweitstimmenVorlaeufig +
                ", diegruenenZweitstimmenVorperiode=" + diegruenenZweitstimmenVorperiode +
                ", csuErststimmenVorlaeufig=" + csuErststimmenVorlaeufig +
                ", csuErststimmenVorperiode=" + csuErststimmenVorperiode +
                ", csuZweitstimmenVorlaeufig=" + csuZweitstimmenVorlaeufig +
                ", csuZweitstimmenVorperiode=" + csuZweitstimmenVorperiode +
                ", fdpErststimmenVorlaeufig=" + fdpErststimmenVorlaeufig +
                ", fdpErststimmenVorperiode=" + fdpErststimmenVorperiode +
                ", fdpZweitstimmenVorlaeufig=" + fdpZweitstimmenVorlaeufig +
                ", fdpZweitstimmenVorperiode=" + fdpZweitstimmenVorperiode +
                ", afdErststimmenVorlaeufig=" + afdErststimmenVorlaeufig +
                ", afdErststimmenVorperiode=" + afdErststimmenVorperiode +
                ", afdZweitstimmenVorlaeufig=" + afdZweitstimmenVorlaeufig +
                ", afdZweitstimmenVorperiode=" + afdZweitstimmenVorperiode +
                ", piratenparteiErststimmenVorlaeufig=" + piratenparteiErststimmenVorlaeufig +
                ", piratenparteiErststimmenVorperiode=" + piratenparteiErststimmenVorperiode +
                ", piratenparteiZweitstimmenVorlaeufig=" + piratenparteiZweitstimmenVorlaeufig +
                ", piratenparteiZweitstimmenVorperiode=" + piratenparteiZweitstimmenVorperiode +
                ", npdErststimmenVorlaeufig=" + npdErststimmenVorlaeufig +
                ", npdErststimmenVorperiode=" + npdErststimmenVorperiode +
                ", npdZweitstimmenVorlaeufig=" + npdZweitstimmenVorlaeufig +
                ", npdZweitstimmenVorperiode=" + npdZweitstimmenVorperiode +
                ", freieWaehlerErststimmenVorlaeufig=" + freieWaehlerErststimmenVorlaeufig +
                ", freieWaehlerErststimmenVorperiode=" + freieWaehlerErststimmenVorperiode +
                ", freieWaehlerZweitstimmenVorlaeufig=" + freieWaehlerZweitstimmenVorlaeufig +
                ", freieWaehlerZweitstimmenVorperiode=" + freieWaehlerZweitstimmenVorperiode +
                ", tierschutzparteiErststimmenVorlaeufig=" + tierschutzparteiErststimmenVorlaeufig +
                ", tierschutzparteiErststimmenVorperiode=" + tierschutzparteiErststimmenVorperiode +
                ", tierschutzparteiZweitstimmenVorlaeufig=" + tierschutzparteiZweitstimmenVorlaeufig +
                ", tierschutzparteiZweitstimmenVorperiode=" + tierschutzparteiZweitstimmenVorperiode +
                ", oedpErststimmenVorlaeufig=" + oedpErststimmenVorlaeufig +
                ", oedpErststimmenVorperiode=" + oedpErststimmenVorperiode +
                ", oedpZweitstimmenVorlaeufig=" + oedpZweitstimmenVorlaeufig +
                ", oedpZweitstimmenVorperiode=" + oedpZweitstimmenVorperiode +
                ", dieparteiErststimmenVorlaeufig=" + dieparteiErststimmenVorlaeufig +
                ", dieparteiErststimmenVorperiode=" + dieparteiErststimmenVorperiode +
                ", dieparteiZweitstimmenVorlaeufig=" + dieparteiZweitstimmenVorlaeufig +
                ", dieparteiZweitstimmenVorperiode=" + dieparteiZweitstimmenVorperiode +
                ", bayernparteiErststimmenVorlaeufig=" + bayernparteiErststimmenVorlaeufig +
                ", bayernparteiErststimmenVorperiode=" + bayernparteiErststimmenVorperiode +
                ", bayernparteiZweitstimmenVorlaeufig=" + bayernparteiZweitstimmenVorlaeufig +
                ", bayernparteiZweitstimmenVorperiode=" + bayernparteiZweitstimmenVorperiode +
                ", volksabstimmungErststimmenVorlaeufig=" + volksabstimmungErststimmenVorlaeufig +
                ", volksabstimmungErststimmenVorperiode=" + volksabstimmungErststimmenVorperiode +
                ", volksabstimmungZweitstimmenVorlaeufig=" + volksabstimmungZweitstimmenVorlaeufig +
                ", volksabstimmungZweitstimmenVorperiode=" + volksabstimmungZweitstimmenVorperiode +
                ", pdvErststimmenVorlaeufig=" + pdvErststimmenVorlaeufig +
                ", pdvErststimmenVorperiode=" + pdvErststimmenVorperiode +
                ", pdvZweitstimmenVorlaeufig=" + pdvZweitstimmenVorlaeufig +
                ", pdvZweitstimmenVorperiode=" + pdvZweitstimmenVorperiode +
                ", mlpdErststimmenVorlaeufig=" + mlpdErststimmenVorlaeufig +
                ", mlpdErststimmenVorperiode=" + mlpdErststimmenVorperiode +
                ", mlpdZweitstimmenVorlaeufig=" + mlpdZweitstimmenVorlaeufig +
                ", mlpdZweitstimmenVorperiode=" + mlpdZweitstimmenVorperiode +
                ", buesoErststimmenVorlaeufig=" + buesoErststimmenVorlaeufig +
                ", buesoErststimmenVorperiode=" + buesoErststimmenVorperiode +
                ", buesoZweitstimmenVorlaeufig=" + buesoZweitstimmenVorlaeufig +
                ", buesoZweitstimmenVorperiode=" + buesoZweitstimmenVorperiode +
                ", sgpErststimmenVorlaeufig=" + sgpErststimmenVorlaeufig +
                ", sgpErststimmenVorperiode=" + sgpErststimmenVorperiode +
                ", sgpZweitstimmenVorlaeufig=" + sgpZweitstimmenVorlaeufig +
                ", sgpZweitstimmenVorperiode=" + sgpZweitstimmenVorperiode +
                ", dierechteErststimmenVorlaeufig=" + dierechteErststimmenVorlaeufig +
                ", dierechteErststimmenVorperiode=" + dierechteErststimmenVorperiode +
                ", dierechteZweitstimmenVorlaeufig=" + dierechteZweitstimmenVorlaeufig +
                ", dierechteZweitstimmenVorperiode=" + dierechteZweitstimmenVorperiode +
                ", addErststimmenVorlaeufig=" + addErststimmenVorlaeufig +
                ", addErststimmenVorperiode=" + addErststimmenVorperiode +
                ", addZweitstimmenVorlaeufig=" + addZweitstimmenVorlaeufig +
                ", addZweitstimmenVorperiode=" + addZweitstimmenVorperiode +
                ", tierschutzallianzErststimmenVorlaeufig=" + tierschutzallianzErststimmenVorlaeufig +
                ", tierschutzallianzErststimmenVorperiode=" + tierschutzallianzErststimmenVorperiode +
                ", tierschutzallianzZweitstimmenVorlaeufig=" + tierschutzallianzZweitstimmenVorlaeufig +
                ", tierschutzallianzZweitstimmenVorperiode=" + tierschutzallianzZweitstimmenVorperiode +
                ", bergparteiErststimmenVorlaeufig=" + bergparteiErststimmenVorlaeufig +
                ", bergparteiErststimmenVorperiode=" + bergparteiErststimmenVorperiode +
                ", bergparteiZweitstimmenVorlaeufig=" + bergparteiZweitstimmenVorlaeufig +
                ", bergparteiZweitstimmenVorperiode=" + bergparteiZweitstimmenVorperiode +
                ", bgeErststimmenVorlaeufig=" + bgeErststimmenVorlaeufig +
                ", bgeErststimmenVorperiode=" + bgeErststimmenVorperiode +
                ", bgeZweitstimmenVorlaeufig=" + bgeZweitstimmenVorlaeufig +
                ", bgeZweitstimmenVorperiode=" + bgeZweitstimmenVorperiode +
                ", dibErststimmenVorlaeufig=" + dibErststimmenVorlaeufig +
                ", dibErststimmenVorperiode=" + dibErststimmenVorperiode +
                ", dibZweitstimmenVorlaeufig=" + dibZweitstimmenVorlaeufig +
                ", dibZweitstimmenVorperiode=" + dibZweitstimmenVorperiode +
                ", dkpErststimmenVorlaeufig=" + dkpErststimmenVorlaeufig +
                ", dkpErststimmenVorperiode=" + dkpErststimmenVorperiode +
                ", dkpZweitstimmenVorlaeufig=" + dkpZweitstimmenVorlaeufig +
                ", dkpZweitstimmenVorperiode=" + dkpZweitstimmenVorperiode +
                ", dmErststimmenVorlaeufig=" + dmErststimmenVorlaeufig +
                ", dmErststimmenVorperiode=" + dmErststimmenVorperiode +
                ", dmZweitstimmenVorlaeufig=" + dmZweitstimmenVorlaeufig +
                ", dmZweitstimmenVorperiode=" + dmZweitstimmenVorperiode +
                ", diegrauenErststimmenVorlaeufig=" + diegrauenErststimmenVorlaeufig +
                ", diegrauenErststimmenVorperiode=" + diegrauenErststimmenVorperiode +
                ", diegrauenZweitstimmenVorlaeufig=" + diegrauenZweitstimmenVorlaeufig +
                ", diegrauenZweitstimmenVorperiode=" + diegrauenZweitstimmenVorperiode +
                ", duErststimmenVorlaeufig=" + duErststimmenVorlaeufig +
                ", duErststimmenVorperiode=" + duErststimmenVorperiode +
                ", duZweitstimmenVorlaeufig=" + duZweitstimmenVorlaeufig +
                ", duZweitstimmenVorperiode=" + duZweitstimmenVorperiode +
                ", mgErststimmenVorlaeufig=" + mgErststimmenVorlaeufig +
                ", mgErststimmenVorperiode=" + mgErststimmenVorperiode +
                ", mgZweitstimmenVorlaeufig=" + mgZweitstimmenVorlaeufig +
                ", mgZweitstimmenVorperiode=" + mgZweitstimmenVorperiode +
                ", menschlicheweltErststimmenVorlaeufig=" + menschlicheweltErststimmenVorlaeufig +
                ", menschlicheweltErststimmenVorperiode=" + menschlicheweltErststimmenVorperiode +
                ", menschlicheweltZweitstimmenVorlaeufig=" + menschlicheweltZweitstimmenVorlaeufig +
                ", menschlicheweltZweitstimmenVorperiode=" + menschlicheweltZweitstimmenVorperiode +
                ", diehumanistenErststimmenVorlaeufig=" + diehumanistenErststimmenVorlaeufig +
                ", diehumanistenErststimmenVorperiode=" + diehumanistenErststimmenVorperiode +
                ", diehumanistenZweitstimmenVorlaeufig=" + diehumanistenZweitstimmenVorlaeufig +
                ", diehumanistenZweitstimmenVorperiode=" + diehumanistenZweitstimmenVorperiode +
                ", gesundheitsforschungErststimmenVorlaeufig=" + gesundheitsforschungErststimmenVorlaeufig +
                ", gesundheitsforschungErststimmenVorperiode=" + gesundheitsforschungErststimmenVorperiode +
                ", gesundheitsforschungZweitstimmenVorlaeufig=" + gesundheitsforschungZweitstimmenVorlaeufig +
                ", gesundheitsforschungZweitstimmenVorperiode=" + gesundheitsforschungZweitstimmenVorperiode +
                ", vparteiErststimmenVorlaeufig=" + vparteiErststimmenVorlaeufig +
                ", vparteiErststimmenVorperiode=" + vparteiErststimmenVorperiode +
                ", vparteiZweitstimmenVorlaeufig=" + vparteiZweitstimmenVorlaeufig +
                ", vparteiZweitstimmenVorperiode=" + vparteiZweitstimmenVorperiode +
                ", buendniscErststimmenVorlaeufig=" + buendniscErststimmenVorlaeufig +
                ", buendniscErststimmenVorperiode=" + buendniscErststimmenVorperiode +
                ", buendniscZweitstimmenVorlaeufig=" + buendniscZweitstimmenVorlaeufig +
                ", buendniscZweitstimmenVorperiode=" + buendniscZweitstimmenVorperiode +
                ", dieeinheitErststimmenVorlaeufig=" + dieeinheitErststimmenVorlaeufig +
                ", dieeinheitErststimmenVorperiode=" + dieeinheitErststimmenVorperiode +
                ", dieeinheitZweitstimmenVorlaeufig=" + dieeinheitZweitstimmenVorlaeufig +
                ", dieeinheitZweitstimmenVorperiode=" + dieeinheitZweitstimmenVorperiode +
                ", dieviolettenErststimmenVorlaeufig=" + dieviolettenErststimmenVorlaeufig +
                ", dieviolettenErststimmenVorperiode=" + dieviolettenErststimmenVorperiode +
                ", dieviolettenZweitstimmenVorlaeufig=" + dieviolettenZweitstimmenVorlaeufig +
                ", dieviolettenZweitstimmenVorperiode=" + dieviolettenZweitstimmenVorperiode +
                ", familieErststimmenVorlaeufig=" + familieErststimmenVorlaeufig +
                ", familieErststimmenVorperiode=" + familieErststimmenVorperiode +
                ", familieZweitstimmenVorlaeufig=" + familieZweitstimmenVorlaeufig +
                ", familieZweitstimmenVorperiode=" + familieZweitstimmenVorperiode +
                ", diefrauenErststimmenVorlaeufig=" + diefrauenErststimmenVorlaeufig +
                ", diefrauenErststimmenVorperiode=" + diefrauenErststimmenVorperiode +
                ", diefrauenZweitstimmenVorlaeufig=" + diefrauenZweitstimmenVorlaeufig +
                ", diefrauenZweitstimmenVorperiode=" + diefrauenZweitstimmenVorperiode +
                ", mieterparteiErststimmenVorlaeufig=" + mieterparteiErststimmenVorlaeufig +
                ", mieterparteiErststimmenVorperiode=" + mieterparteiErststimmenVorperiode +
                ", mieterparteiZweitstimmenVorlaeufig=" + mieterparteiZweitstimmenVorlaeufig +
                ", mieterparteiZweitstimmenVorperiode=" + mieterparteiZweitstimmenVorperiode +
                ", neueliberaleErststimmenVorlaeufig=" + neueliberaleErststimmenVorlaeufig +
                ", neueliberaleErststimmenVorperiode=" + neueliberaleErststimmenVorperiode +
                ", neueliberaleZweitstimmenVorlaeufig=" + neueliberaleZweitstimmenVorlaeufig +
                ", neueliberaleZweitstimmenVorperiode=" + neueliberaleZweitstimmenVorperiode +
                ", unabhaengigeErststimmenVorlaeufig=" + unabhaengigeErststimmenVorlaeufig +
                ", unabhaengigeErststimmenVorperiode=" + unabhaengigeErststimmenVorperiode +
                ", unabhaengigeZweitstimmenVorlaeufig=" + unabhaengigeZweitstimmenVorlaeufig +
                ", unabhaengigeZweitstimmenVorperiode=" + unabhaengigeZweitstimmenVorperiode +
                ", uebrigeErststimmenVorlaeufig=" + uebrigeErststimmenVorlaeufig +
                ", uebrigeErststimmenVorperiode=" + uebrigeErststimmenVorperiode +
                ", uebrigeZweitstimmenVorlaeufig=" + uebrigeZweitstimmenVorlaeufig +
                ", uebrigeZweitstimmenVorperiode=" + uebrigeZweitstimmenVorperiode +
                '}';
    }

    public String[] getSpaltenName() {
        return spaltenName;
    }

    @Transient
    private final String spaltenName[] = {
            "Nr;",
            "Gebiet;",
            "gehört zu;",
            "Bundesland",
            "Wahlberechtigte;;;;Erststimmen;;;Vorläufig",
            "Wahlberechtigte;;;;Erststimmen;;;Vorperiode",
            "Wahlberechtigte;;;;Zweitstimmen;;;Vorläufig",
            "Wahlberechtigte;;;;Zweitstimmen;;;Vorperiode",
            "Wähler;;;;Erststimmen;;;Vorläufig",
            "Wähler;;;;Erststimmen;;;Vorperiode",
            "Wähler;;;;Zweitstimmen;;;Vorläufig",
            "Wähler;;;;Zweitstimmen;;;Vorperiode",
            "Ungültige;;;;Erststimmen;;;Vorläufig",
            "Ungültige;;;;Erststimmen;;;Vorperiode",
            "Ungültige;;;;Zweitstimmen;;;Vorläufig",
            "Ungültige;;;;Zweitstimmen;;;Vorperiode",
            "Gültige;;;;Erststimmen;;;Vorläufig",
            "Gültige;;;;Erststimmen;;;Vorperiode",
            "Gültige;;;;Zweitstimmen;;;Vorläufig",
            "Gültige;;;;Zweitstimmen;;;Vorperiode",
            "Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorläufig",
            "Christlich Demokratische Union Deutschlands;;;;Erststimmen;;;Vorperiode",
            "Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorläufig",
            "Christlich Demokratische Union Deutschlands;;;;Zweitstimmen;;;Vorperiode",
            "Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig",
            "Sozialdemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode",
            "Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig",
            "Sozialdemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode",
            "DIE LINKE;;;;Erststimmen;;;Vorläufig",
            "DIE LINKE;;;;Erststimmen;;;Vorperiode",
            "DIE LINKE;;;;Zweitstimmen;;;Vorläufig",
            "DIE LINKE;;;;Zweitstimmen;;;Vorperiode",
            "BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorläufig",
            "BÜNDNIS 90/DIE GRÜNEN;;;;Erststimmen;;;Vorperiode",
            "BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorläufig",
            "BÜNDNIS 90/DIE GRÜNEN;;;;Zweitstimmen;;;Vorperiode",
            "Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorläufig",
            "Christlich-Soziale Union in Bayern e.V.;;;;Erststimmen;;;Vorperiode",
            "Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorläufig",
            "Christlich-Soziale Union in Bayern e.V.;;;;Zweitstimmen;;;Vorperiode",
            "Freie Demokratische Partei;;;;Erststimmen;;;Vorläufig",
            "Freie Demokratische Partei;;;;Erststimmen;;;Vorperiode",
            "Freie Demokratische Partei;;;;Zweitstimmen;;;Vorläufig",
            "Freie Demokratische Partei;;;;Zweitstimmen;;;Vorperiode",
            "Alternative für Deutschland;;;;Erststimmen;;;Vorläufig",
            "Alternative für Deutschland;;;;Erststimmen;;;Vorperiode",
            "Alternative für Deutschland;;;;Zweitstimmen;;;Vorläufig",
            "Alternative für Deutschland;;;;Zweitstimmen;;;Vorperiode",
            "Piratenpartei Deutschland;;;;Erststimmen;;;Vorläufig",
            "Piratenpartei Deutschland;;;;Erststimmen;;;Vorperiode",
            "Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorläufig",
            "Piratenpartei Deutschland;;;;Zweitstimmen;;;Vorperiode",
            "Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorläufig",
            "Nationaldemokratische Partei Deutschlands;;;;Erststimmen;;;Vorperiode",
            "Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorläufig",
            "Nationaldemokratische Partei Deutschlands;;;;Zweitstimmen;;;Vorperiode",
            "FREIE WÄHLER;;;;Erststimmen;;;Vorläufig",
            "FREIE WÄHLER;;;;Erststimmen;;;Vorperiode",
            "FREIE WÄHLER;;;;Zweitstimmen;;;Vorläufig",
            "FREIE WÄHLER;;;;Zweitstimmen;;;Vorperiode",
            "PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorläufig",
            "PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Erststimmen;;;Vorperiode",
            "PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorläufig",
            "PARTEI MENSCH UMWELT TIERSCHUTZ;;;;Zweitstimmen;;;Vorperiode",
            "Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorläufig",
            "Ökologisch-Demokratische Partei;;;;Erststimmen;;;Vorperiode",
            "Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorläufig",
            "Ökologisch-Demokratische Partei;;;;Zweitstimmen;;;Vorperiode",
            "Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorläufig",
            "Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Erststimmen;;;Vorperiode",
            "Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorläufig",
            "Partei für Arbeit, Rechtsstaat, Tierschutz, Elitenförderung und basisdemokratische Initiative;;;;Zweitstimmen;;;Vorperiode",
            "Bayernpartei;;;;Erststimmen;;;Vorläufig",
            "Bayernpartei;;;;Erststimmen;;;Vorperiode",
            "Bayernpartei;;;;Zweitstimmen;;;Vorläufig",
            "Bayernpartei;;;;Zweitstimmen;;;Vorperiode",
            "Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig",
            "Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode",
            "Ab jetzt...Demokratie durch Volksabstimmung;;;Vorläufig",
            "Ab jetzt...Demokratie durch Volksabstimmung;;;Vorperiode",
            "Partei der Vernunft;;;Vorläufig",
            "Partei der Vernunft;;;Vorperiode",
            "Partei der Vernunft;;;Vorläufig",
            "Partei der Vernunft;;;Vorperiode",
            "Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig",
            "Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode",
            "Marxistisch-Leninistische Partei Deutschlands;;;Vorläufig",
            "Marxistisch-Leninistische Partei Deutschlands;;;Vorperiode",
            "Bürgerrechtsbewegung Solidarität;;;Vorläufig",
            "Bürgerrechtsbewegung Solidarität;;;Vorperiode",
            "Bürgerrechtsbewegung Solidarität;;;Vorläufig",
            "Bürgerrechtsbewegung Solidarität;;;Vorperiode",
            "Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig",
            "Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode",
            "Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorläufig",
            "Sozialistische Gleichheitspartei, Vierte Internationale;;;Vorperiode",
            "DIE RECHTE;;;Vorläufig",
            "DIE RECHTE;;;Vorperiode",
            "DIE RECHTE;;;Vorläufig",
            "DIE RECHTE;;;Vorperiode",
            "Allianz Deutscher Demokraten;;;Vorläufig",
            "Allianz Deutscher Demokraten;;;Vorperiode",
            "Allianz Deutscher Demokraten;;;Vorläufig",
            "Allianz Deutscher Demokraten;;;Vorperiode",
            "Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig",
            "Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode",
            "Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorläufig",
            "Allianz für Menschenrechte, Tier- und Naturschutz;;;Vorperiode",
            "bergpartei, die überpartei;;;Vorläufig",
            "bergpartei, die überpartei;;;Vorperiode",
            "bergpartei, die überpartei;;;Vorläufig",
            "bergpartei, die überpartei;;;Vorperiode",
            "Bündnis Grundeinkommen;;;Vorläufig",
            "Bündnis Grundeinkommen;;;Vorperiode",
            "Bündnis Grundeinkommen;;;Vorläufig",
            "Bündnis Grundeinkommen;;;Vorperiode",
            "DEMOKRATIE IN BEWEGUNG;;;Vorläufig",
            "DEMOKRATIE IN BEWEGUNG;;;Vorperiode",
            "DEMOKRATIE IN BEWEGUNG;;;Vorläufig",
            "DEMOKRATIE IN BEWEGUNG;;;Vorperiode",
            "Deutsche Kommunistische Partei;;;Vorläufig",
            "Deutsche Kommunistische Partei;;;Vorperiode",
            "Deutsche Kommunistische Partei;;;Vorläufig",
            "Deutsche Kommunistische Partei;;;Vorperiode",
            "Deutsche Mitte;;;Vorläufig",
            "Deutsche Mitte;;;Vorperiode",
            "Deutsche Mitte;;;Vorläufig",
            "Deutsche Mitte;;;Vorperiode",
            "Die Grauen – Für alle Generationen;;;Vorläufig",
            "Die Grauen – Für alle Generationen;;;Vorperiode",
            "Die Grauen – Für alle Generationen;;;Vorläufig",
            "Die Grauen – Für alle Generationen;;;Vorperiode",
            "Die Urbane. Eine HipHop Partei;;;Vorläufig",
            "Die Urbane. Eine HipHop Partei;;;Vorperiode",
            "Die Urbane. Eine HipHop Partei;;;Vorläufig",
            "Die Urbane. Eine HipHop Partei;;;Vorperiode",
            "Madgeburger Gartenpartei;;;Vorläufig",
            "Madgeburger Gartenpartei;;;Vorperiode",
            "Madgeburger Gartenpartei;;;Vorläufig",
            "Madgeburger Gartenpartei;;;Vorperiode",
            "Menschliche Welt;;;Vorläufig",
            "Menschliche Welt;;;Vorperiode",
            "Menschliche Welt;;;Vorläufig",
            "Menschliche Welt;;;Vorperiode",
            "Partei der Humanisten;;;Vorläufig",
            "Partei der Humanisten;;;Vorperiode",
            "Partei der Humanisten;;;Vorläufig",
            "Partei der Humanisten;;;Vorperiode",
            "Partei für Gesundheitsforschung;;;Vorläufig",
            "Partei für Gesundheitsforschung;;;Vorperiode",
            "Partei für Gesundheitsforschung;;;Vorläufig",
            "Partei für Gesundheitsforschung;;;Vorperiode",
            "V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig",
            "V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode",
            "V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorläufig",
            "V-Partei³ - Partei für Veränderung, Vegetarier und Veganer;;;Vorperiode",
            "Bündnis C - Christen für Deutschland;;;Vorläufig",
            "Bündnis C - Christen für Deutschland;;;Vorperiode",
            "Bündnis C - Christen für Deutschland;;;Vorläufig",
            "Bündnis C - Christen für Deutschland;;;Vorperiode",
            "DIE EINHEIT;;;Vorläufig",
            "DIE EINHEIT;;;Vorperiode",
            "DIE EINHEIT;;;Vorläufig",
            "DIE EINHEIT;;;Vorperiode",
            "Die Violetten;;;Vorläufig",
            "Die Violetten;;;Vorperiode",
            "Die Violetten;;;Vorläufig",
            "Die Violetten;;;Vorperiode",
            "Familien-Partei Deutschlands;;;Vorläufig",
            "Familien-Partei Deutschlands;;;Vorperiode",
            "Familien-Partei Deutschlands;;;Vorläufig",
            "Familien-Partei Deutschlands;;;Vorperiode",
            "Feministische Partei DIE FRAUEN;;;Vorläufig",
            "Feministische Partei DIE FRAUEN;;;Vorperiode",
            "Feministische Partei DIE FRAUEN;;;Vorläufig",
            "Feministische Partei DIE FRAUEN;;;Vorperiode",
            "Mieterpartei;;;Vorläufig",
            "Mieterpartei;;;Vorperiode",
            "Mieterpartei;;;Vorläufig",
            "Mieterpartei;;;Vorperiode",
            "Neue Liberale – Die Sozialliberalen;;;Vorläufig",
            "Neue Liberale – Die Sozialliberalen;;;Vorperiode",
            "Neue Liberale – Die Sozialliberalen;;;Vorläufig",
            "Neue Liberale – Die Sozialliberalen;;;Vorperiode",
            "UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig",
            "UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode",
            "UNABHÄNGIGE für bürgernahe Demokratie;;;Vorläufig",
            "UNABHÄNGIGE für bürgernahe Demokratie;;;Vorperiode",
            "Übrige;;;Vorläufig",
            "Übrige;;;Vorperiode",
            "Übrige;;;Vorläufig",
            "Übrige;;;Vorperiode"
    };

    public List<String> logFieldsList(){
        String fieldnames[] = {
                "wahlkreisNummer",
                "wahlkreisName",
                "bundeslandNummer",
                "bundesland",
                "wahlberechtigteErststimmenVorlaeufig",
                "wahlberechtigteErststimmenVorperiode",
                "wahlberechtigteZweitstimmenVorlaeufig",
                "wahlberechtigteZweitstimmenVorperiode",
                "waehlerErststimmenVorlaeufig",
                "waehlerErststimmenVorperiode",
                "waehlerZweitstimmenVorlaeufig",
                "waehlerZweitstimmenVorperiode",
                "ungueltigeErststimmenVorlaeufig",
                "ungueltigeErststimmenVorperiode",
                "ungueltigeZweitstimmenVorlaeufig",
                "ungueltigeZweitstimmenVorperiode",
                "gueltigeErststimmenVorlaeufig",
                "gueltigeErststimmenVorperiode",
                "gueltigeZweitstimmenVorlaeufig",
                "gueltigeZweitstimmenVorperiode",
                "cduErststimmenVorlaeufig",
                "cduErststimmenVorperiode",
                "cduZweitstimmenVorlaeufig",
                "cduZweitstimmenVorperiode",
                "spdErststimmenVorlaeufig",
                "spdErststimmenVorperiode",
                "spdZweitstimmenVorlaeufig",
                "spdZweitstimmenVorperiode",
                "dielinkeErststimmenVorlaeufig",
                "dielinkeErststimmenVorperiode",
                "dielinkeZweitstimmenVorlaeufig",
                "dielinkeZweitstimmenVorperiode",
                "diegruenenErststimmenVorlaeufig",
                "diegruenenErststimmenVorperiode",
                "diegruenenZweitstimmenVorlaeufig",
                "diegruenenZweitstimmenVorperiode",
                "csuErststimmenVorlaeufig",
                "csuErststimmenVorperiode",
                "csuZweitstimmenVorlaeufig",
                "csuZweitstimmenVorperiode",
                "fdpErststimmenVorlaeufig",
                "fdpErststimmenVorperiode",
                "fdpZweitstimmenVorlaeufig",
                "fdpZweitstimmenVorperiode",
                "afdErststimmenVorlaeufig",
                "afdErststimmenVorperiode",
                "afdZweitstimmenVorlaeufig",
                "afdZweitstimmenVorperiode",
                "piratenparteiErststimmenVorlaeufig",
                "piratenparteiErststimmenVorperiode",
                "piratenparteiZweitstimmenVorlaeufig",
                "piratenparteiZweitstimmenVorperiode",
                "npdErststimmenVorlaeufig",
                "npdErststimmenVorperiode",
                "npdZweitstimmenVorlaeufig",
                "npdZweitstimmenVorperiode",
                "freieWaehlerErststimmenVorlaeufig",
                "freieWaehlerErststimmenVorperiode",
                "freieWaehlerZweitstimmenVorlaeufig",
                "freieWaehlerZweitstimmenVorperiode",
                "tierschutzparteiErststimmenVorlaeufig",
                "tierschutzparteiErststimmenVorperiode",
                "tierschutzparteiZweitstimmenVorlaeufig",
                "tierschutzparteiZweitstimmenVorperiode",
                "oedpErststimmenVorlaeufig",
                "oedpErststimmenVorperiode",
                "oedpZweitstimmenVorlaeufig",
                "oedpZweitstimmenVorperiode",
                "dieparteiErststimmenVorlaeufig",
                "dieparteiErststimmenVorperiode",
                "dieparteiZweitstimmenVorlaeufig",
                "dieparteiZweitstimmenVorperiode",
                "bayernparteiErststimmenVorlaeufig",
                "bayernparteiErststimmenVorperiode",
                "bayernparteiZweitstimmenVorlaeufig",
                "bayernparteiZweitstimmenVorperiode",
                "volksabstimmungErststimmenVorlaeufig",
                "volksabstimmungErststimmenVorperiode",
                "volksabstimmungZweitstimmenVorlaeufig",
                "volksabstimmungZweitstimmenVorperiode",
                "pdvErststimmenVorlaeufig",
                "pdvErststimmenVorperiode",
                "pdvZweitstimmenVorlaeufig",
                "pdvZweitstimmenVorperiode",
                "mlpdErststimmenVorlaeufig",
                "mlpdErststimmenVorperiode",
                "mlpdZweitstimmenVorlaeufig",
                "mlpdZweitstimmenVorperiode",
                "buesoErststimmenVorlaeufig",
                "buesoErststimmenVorperiode",
                "buesoZweitstimmenVorlaeufig",
                "buesoZweitstimmenVorperiode",
                "sgpErststimmenVorlaeufig",
                "sgpErststimmenVorperiode",
                "sgpZweitstimmenVorlaeufig",
                "sgpZweitstimmenVorperiode",
                "dierechteErststimmenVorlaeufig",
                "dierechteErststimmenVorperiode",
                "dierechteZweitstimmenVorlaeufig",
                "dierechteZweitstimmenVorperiode",
                "addErststimmenVorlaeufig",
                "addErststimmenVorperiode",
                "addZweitstimmenVorlaeufig",
                "addZweitstimmenVorperiode",
                "tierschutzallianzErststimmenVorlaeufig",
                "tierschutzallianzErststimmenVorperiode",
                "tierschutzallianzZweitstimmenVorlaeufig",
                "tierschutzallianzZweitstimmenVorperiode",
                "bergparteiErststimmenVorlaeufig",
                "bergparteiErststimmenVorperiode",
                "bergparteiZweitstimmenVorlaeufig",
                "bergparteiZweitstimmenVorperiode",
                "bgeErststimmenVorlaeufig",
                "bgeErststimmenVorperiode",
                "bgeZweitstimmenVorlaeufig",
                "bgeZweitstimmenVorperiode",
                "dibErststimmenVorlaeufig",
                "dibErststimmenVorperiode",
                "dibZweitstimmenVorlaeufig",
                "dibZweitstimmenVorperiode",
                "dkpErststimmenVorlaeufig",
                "dkpErststimmenVorperiode",
                "dkpZweitstimmenVorlaeufig",
                "dkpZweitstimmenVorperiode",
                "dmErststimmenVorlaeufig",
                "dmErststimmenVorperiode",
                "dmZweitstimmenVorlaeufig",
                "dmZweitstimmenVorperiode",
                "diegrauenErststimmenVorlaeufig",
                "diegrauenErststimmenVorperiode",
                "diegrauenZweitstimmenVorlaeufig",
                "diegrauenZweitstimmenVorperiode",
                "duErststimmenVorlaeufig",
                "duErststimmenVorperiode",
                "duZweitstimmenVorlaeufig",
                "duZweitstimmenVorperiode",
                "mgErststimmenVorlaeufig",
                "mgErststimmenVorperiode",
                "mgZweitstimmenVorlaeufig",
                "mgZweitstimmenVorperiode",
                "menschlicheweltErststimmenVorlaeufig",
                "menschlicheweltErststimmenVorperiode",
                "menschlicheweltZweitstimmenVorlaeufig",
                "menschlicheweltZweitstimmenVorperiode",
                "diehumanistenErststimmenVorlaeufig",
                "diehumanistenErststimmenVorperiode",
                "diehumanistenZweitstimmenVorlaeufig",
                "diehumanistenZweitstimmenVorperiode",
                "gesundheitsforschungErststimmenVorlaeufig",
                "gesundheitsforschungErststimmenVorperiode",
                "gesundheitsforschungZweitstimmenVorlaeufig",
                "gesundheitsforschungZweitstimmenVorperiode",
                "vparteiErststimmenVorlaeufig",
                "vparteiErststimmenVorperiode",
                "vparteiZweitstimmenVorlaeufig",
                "vparteiZweitstimmenVorperiode",
                "buendniscErststimmenVorlaeufig",
                "buendniscErststimmenVorperiode",
                "buendniscZweitstimmenVorlaeufig",
                "buendniscZweitstimmenVorperiode",
                "dieeinheitErststimmenVorlaeufig",
                "dieeinheitErststimmenVorperiode",
                "dieeinheitZweitstimmenVorlaeufig",
                "dieeinheitZweitstimmenVorperiode",
                "dieviolettenErststimmenVorlaeufig",
                "dieviolettenErststimmenVorperiode",
                "dieviolettenZweitstimmenVorlaeufig",
                "dieviolettenZweitstimmenVorperiode",
                "familieErststimmenVorlaeufig",
                "familieErststimmenVorperiode",
                "familieZweitstimmenVorlaeufig",
                "familieZweitstimmenVorperiode",
                "diefrauenErststimmenVorlaeufig",
                "diefrauenErststimmenVorperiode",
                "diefrauenZweitstimmenVorlaeufig",
                "diefrauenZweitstimmenVorperiode",
                "mieterparteiErststimmenVorlaeufig",
                "mieterparteiErststimmenVorperiode",
                "mieterparteiZweitstimmenVorlaeufig",
                "mieterparteiZweitstimmenVorperiode",
                "neueliberaleErststimmenVorlaeufig",
                "neueliberaleErststimmenVorperiode",
                "neueliberaleZweitstimmenVorlaeufig",
                "neueliberaleZweitstimmenVorperiode",
                "unabhaengigeErststimmenVorlaeufig",
                "unabhaengigeErststimmenVorperiode",
                "unabhaengigeZweitstimmenVorlaeufig",
                "unabhaengigeZweitstimmenVorperiode",
                "uebrigeErststimmenVorlaeufig",
                "uebrigeErststimmenVorperiode",
                "uebrigeZweitstimmenVorlaeufig",
                "uebrigeZweitstimmenVorperiode"
        };
        Object fields[] = {
                wahlkreisNummer,
                wahlkreisName,
                bundeslandNummer,
                bundesland,
                wahlberechtigteErststimmenVorlaeufig,
                wahlberechtigteErststimmenVorperiode,
                wahlberechtigteZweitstimmenVorlaeufig,
                wahlberechtigteZweitstimmenVorperiode,
                waehlerErststimmenVorlaeufig,
                waehlerErststimmenVorperiode,
                waehlerZweitstimmenVorlaeufig,
                waehlerZweitstimmenVorperiode,
                ungueltigeErststimmenVorlaeufig,
                ungueltigeErststimmenVorperiode,
                ungueltigeZweitstimmenVorlaeufig,
                ungueltigeZweitstimmenVorperiode,
                gueltigeErststimmenVorlaeufig,
                gueltigeErststimmenVorperiode,
                gueltigeZweitstimmenVorlaeufig,
                gueltigeZweitstimmenVorperiode,
                cduErststimmenVorlaeufig,
                cduErststimmenVorperiode,
                cduZweitstimmenVorlaeufig,
                cduZweitstimmenVorperiode,
                spdErststimmenVorlaeufig,
                spdErststimmenVorperiode,
                spdZweitstimmenVorlaeufig,
                spdZweitstimmenVorperiode,
                dielinkeErststimmenVorlaeufig,
                dielinkeErststimmenVorperiode,
                dielinkeZweitstimmenVorlaeufig,
                dielinkeZweitstimmenVorperiode,
                diegruenenErststimmenVorlaeufig,
                diegruenenErststimmenVorperiode,
                diegruenenZweitstimmenVorlaeufig,
                diegruenenZweitstimmenVorperiode,
                csuErststimmenVorlaeufig,
                csuErststimmenVorperiode,
                csuZweitstimmenVorlaeufig,
                csuZweitstimmenVorperiode,
                fdpErststimmenVorlaeufig,
                fdpErststimmenVorperiode,
                fdpZweitstimmenVorlaeufig,
                fdpZweitstimmenVorperiode,
                afdErststimmenVorlaeufig,
                afdErststimmenVorperiode,
                afdZweitstimmenVorlaeufig,
                afdZweitstimmenVorperiode,
                piratenparteiErststimmenVorlaeufig,
                piratenparteiErststimmenVorperiode,
                piratenparteiZweitstimmenVorlaeufig,
                piratenparteiZweitstimmenVorperiode,
                npdErststimmenVorlaeufig,
                npdErststimmenVorperiode,
                npdZweitstimmenVorlaeufig,
                npdZweitstimmenVorperiode,
                freieWaehlerErststimmenVorlaeufig,
                freieWaehlerErststimmenVorperiode,
                freieWaehlerZweitstimmenVorlaeufig,
                freieWaehlerZweitstimmenVorperiode,
                tierschutzparteiErststimmenVorlaeufig,
                tierschutzparteiErststimmenVorperiode,
                tierschutzparteiZweitstimmenVorlaeufig,
                tierschutzparteiZweitstimmenVorperiode,
                oedpErststimmenVorlaeufig,
                oedpErststimmenVorperiode,
                oedpZweitstimmenVorlaeufig,
                oedpZweitstimmenVorperiode,
                dieparteiErststimmenVorlaeufig,
                dieparteiErststimmenVorperiode,
                dieparteiZweitstimmenVorlaeufig,
                dieparteiZweitstimmenVorperiode,
                bayernparteiErststimmenVorlaeufig,
                bayernparteiErststimmenVorperiode,
                bayernparteiZweitstimmenVorlaeufig,
                bayernparteiZweitstimmenVorperiode,
                volksabstimmungErststimmenVorlaeufig,
                volksabstimmungErststimmenVorperiode,
                volksabstimmungZweitstimmenVorlaeufig,
                volksabstimmungZweitstimmenVorperiode,
                pdvErststimmenVorlaeufig,
                pdvErststimmenVorperiode,
                pdvZweitstimmenVorlaeufig,
                pdvZweitstimmenVorperiode,
                mlpdErststimmenVorlaeufig,
                mlpdErststimmenVorperiode,
                mlpdZweitstimmenVorlaeufig,
                mlpdZweitstimmenVorperiode,
                buesoErststimmenVorlaeufig,
                buesoErststimmenVorperiode,
                buesoZweitstimmenVorlaeufig,
                buesoZweitstimmenVorperiode,
                sgpErststimmenVorlaeufig,
                sgpErststimmenVorperiode,
                sgpZweitstimmenVorlaeufig,
                sgpZweitstimmenVorperiode,
                dierechteErststimmenVorlaeufig,
                dierechteErststimmenVorperiode,
                dierechteZweitstimmenVorlaeufig,
                dierechteZweitstimmenVorperiode,
                addErststimmenVorlaeufig,
                addErststimmenVorperiode,
                addZweitstimmenVorlaeufig,
                addZweitstimmenVorperiode,
                tierschutzallianzErststimmenVorlaeufig,
                tierschutzallianzErststimmenVorperiode,
                tierschutzallianzZweitstimmenVorlaeufig,
                tierschutzallianzZweitstimmenVorperiode,
                bergparteiErststimmenVorlaeufig,
                bergparteiErststimmenVorperiode,
                bergparteiZweitstimmenVorlaeufig,
                bergparteiZweitstimmenVorperiode,
                bgeErststimmenVorlaeufig,
                bgeErststimmenVorperiode,
                bgeZweitstimmenVorlaeufig,
                bgeZweitstimmenVorperiode,
                dibErststimmenVorlaeufig,
                dibErststimmenVorperiode,
                dibZweitstimmenVorlaeufig,
                dibZweitstimmenVorperiode,
                dkpErststimmenVorlaeufig,
                dkpErststimmenVorperiode,
                dkpZweitstimmenVorlaeufig,
                dkpZweitstimmenVorperiode,
                dmErststimmenVorlaeufig,
                dmErststimmenVorperiode,
                dmZweitstimmenVorlaeufig,
                dmZweitstimmenVorperiode,
                diegrauenErststimmenVorlaeufig,
                diegrauenErststimmenVorperiode,
                diegrauenZweitstimmenVorlaeufig,
                diegrauenZweitstimmenVorperiode,
                duErststimmenVorlaeufig,
                duErststimmenVorperiode,
                duZweitstimmenVorlaeufig,
                duZweitstimmenVorperiode,
                mgErststimmenVorlaeufig,
                mgErststimmenVorperiode,
                mgZweitstimmenVorlaeufig,
                mgZweitstimmenVorperiode,
                menschlicheweltErststimmenVorlaeufig,
                menschlicheweltErststimmenVorperiode,
                menschlicheweltZweitstimmenVorlaeufig,
                menschlicheweltZweitstimmenVorperiode,
                diehumanistenErststimmenVorlaeufig,
                diehumanistenErststimmenVorperiode,
                diehumanistenZweitstimmenVorlaeufig,
                diehumanistenZweitstimmenVorperiode,
                gesundheitsforschungErststimmenVorlaeufig,
                gesundheitsforschungErststimmenVorperiode,
                gesundheitsforschungZweitstimmenVorlaeufig,
                gesundheitsforschungZweitstimmenVorperiode,
                vparteiErststimmenVorlaeufig,
                vparteiErststimmenVorperiode,
                vparteiZweitstimmenVorlaeufig,
                vparteiZweitstimmenVorperiode,
                buendniscErststimmenVorlaeufig,
                buendniscErststimmenVorperiode,
                buendniscZweitstimmenVorlaeufig,
                buendniscZweitstimmenVorperiode,
                dieeinheitErststimmenVorlaeufig,
                dieeinheitErststimmenVorperiode,
                dieeinheitZweitstimmenVorlaeufig,
                dieeinheitZweitstimmenVorperiode,
                dieviolettenErststimmenVorlaeufig,
                dieviolettenErststimmenVorperiode,
                dieviolettenZweitstimmenVorlaeufig,
                dieviolettenZweitstimmenVorperiode,
                familieErststimmenVorlaeufig,
                familieErststimmenVorperiode,
                familieZweitstimmenVorlaeufig,
                familieZweitstimmenVorperiode,
                diefrauenErststimmenVorlaeufig,
                diefrauenErststimmenVorperiode,
                diefrauenZweitstimmenVorlaeufig,
                diefrauenZweitstimmenVorperiode,
                mieterparteiErststimmenVorlaeufig,
                mieterparteiErststimmenVorperiode,
                mieterparteiZweitstimmenVorlaeufig,
                mieterparteiZweitstimmenVorperiode,
                neueliberaleErststimmenVorlaeufig,
                neueliberaleErststimmenVorperiode,
                neueliberaleZweitstimmenVorlaeufig,
                neueliberaleZweitstimmenVorperiode,
                unabhaengigeErststimmenVorlaeufig,
                unabhaengigeErststimmenVorperiode,
                unabhaengigeZweitstimmenVorlaeufig,
                unabhaengigeZweitstimmenVorperiode,
                uebrigeErststimmenVorlaeufig,
                uebrigeErststimmenVorperiode,
                uebrigeZweitstimmenVorlaeufig,
                uebrigeZweitstimmenVorperiode,
        };
        List<String> outputLines = new ArrayList<>();
        String spaltenName[] = this.getSpaltenName();
        for(int i=0; i<fieldnames.length; i++){
            String e;
            if (fields[i] != null) {
                e = "[" + i + "] " + spaltenName[i] + " : " + fields[i] + "   (" + fieldnames[i] + "  "+ fields[i].getClass().getName() + ")";
            } else {
                e = "[" + i + "] " + spaltenName[i] + " : " + fields[i] + "   (" + fieldnames[i] + "  "+ fields[i] + ")";
            }
            outputLines.add(e);
        }
        return outputLines;
    }
}
