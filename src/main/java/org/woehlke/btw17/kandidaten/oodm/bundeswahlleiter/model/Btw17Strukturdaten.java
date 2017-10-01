package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model;

import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.listener.Btw17StrukturdatenListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;

@Entity
@Table(
    name = "btw17_strukturdaten",
    uniqueConstraints = {
        @UniqueConstraint(name="uk_btw17_strukturdaten", columnNames = {"bundesland_name","wahlkreis_nummer","wahlkreis_name"}),
        @UniqueConstraint(name="uk_btw17_strukturdaten_wahlkreis_nummer",columnNames = {"wahlkreis_nummer"})
    },
    indexes = {
        @Index(name = "idx_btw17_strukturdaten_anzahl_gemeinden", columnList = "anzahl_gemeinden"),
        @Index(name = "idx_btw17_strukturdaten_flaeche", columnList = "flaeche"),
        @Index(name = "idx_btw17_strukturdaten_bevoelkerung_deutsche", columnList = "bevoelkerung_deutsche"),
        @Index(name = "idx_btw17_strukturdaten_bevoelkerung_auslaender", columnList = "bevoelkerung_auslaender"),
        @Index(name = "idx_btw17_strukturdaten_bevoelkerung_dichte", columnList = "bevoelkerung_dichte"),
        @Index(name = "idx_btw17_strukturdaten_bevoelkerung_geburtensaldo", columnList = "bevoelkerung_geburtensaldo"),
        @Index(name = "idx_btw17_strukturdaten_bevoelkerung_wanderungssaldo", columnList = "bevoelkerung_wanderungssaldo"),
        @Index(name = "idx_btw17_strukturdaten_alter_unter18", columnList = "alter_unter18"),
        @Index(name = "idx_btw17_strukturdaten_alter_18bis24", columnList = "alter_18bis24"),
        @Index(name = "idx_btw17_strukturdaten_alter_25bis34", columnList = "alter_25bis34"),

        @Index(name = "idx_btw17_strukturdaten_alter_35bis59", columnList = "alter_35bis59"),
        @Index(name = "idx_btw17_strukturdaten_alter_60bis74", columnList = "alter_60bis74"),
        @Index(name = "idx_btw17_strukturdaten_alter_75plus", columnList = "alter_75plus"),
        @Index(name = "idx_btw17_strukturdaten_migrationshintergrund_ohne", columnList = "migrationshintergrund_ohne"),
        @Index(name = "idx_btw17_strukturdaten_migrationshintergrund_mit", columnList = "migrationshintergrund_mit"),
        @Index(name = "idx_btw17_strukturdaten_religion_katholisch", columnList = "religion_katholisch"),
        @Index(name = "idx_btw17_strukturdaten_religion_evangelisch", columnList = "religion_evangelisch"),
        @Index(name = "idx_btw17_strukturdaten_religion_sonstige", columnList = "religion_sonstige"),
        @Index(name = "idx_btw17_strukturdaten_wohnungen_eigentuemerquote", columnList = "wohnungen_eigentuemerquote"),
        @Index(name = "idx_btw17_strukturdaten_wohnungen_fertiggestellte", columnList = "wohnungen_fertiggestellte"),

        @Index(name = "idx_btw17_strukturdaten_wohnungen_bestand", columnList = "wohnungen_bestand"),
        @Index(name = "idx_btw17_strukturdaten_einwohner_einkommen", columnList = "einwohner_einkommen"),
        @Index(name = "idx_btw17_strukturdaten_einwohner_bruttoinlandsprodukt", columnList = "einwohner_bruttoinlandsprodukt"),
        @Index(name = "idx_btw17_strukturdaten_einwohner_kraftfahrzeugbestand", columnList = "einwohner_kraftfahrzeugbestand"),
        @Index(name = "idx_btw17_strukturdaten_absv_berufliche_schulen", columnList = "absolventen_berufliche_schulen"),
        @Index(name = "idx_btw17_strukturdaten_absv_allgemeinbildende_schulen_insg", columnList = "absolventen_allgemeinbildende_schulen_insgesamt"),
        @Index(name = "idx_btw17_strukturdaten_absv_hauptschulabschluss_ohne", columnList = "absolventen_hauptschulabschluss_ohne"),
        @Index(name = "idx_btw17_strukturdaten_absv_hauptschulabschluss_mit", columnList = "absolventen_hauptschulabschluss_mit"),
        @Index(name = "idx_btw17_strukturdaten_absv_realschule", columnList = "absolventen_realschule"),
        @Index(name = "idx_btw17_strukturdaten_absv_abitur", columnList = "absolventen_abitur"),

        @Index(name = "idx_btw17_strukturdaten_kitas_betreute_kinder", columnList = "kitas_betreute_kinder"),
        @Index(name = "idx_btw17_strukturdaten_unternehmen_insgesamt", columnList = "unternehmen_insgesamt"),
        @Index(name = "idx_btw17_strukturdaten_unternehmen_handwerk", columnList = "unternehmen_handwerk"),
        @Index(name = "idx_btw17_strukturdaten_sv_beschaeftigte_insgesamt", columnList = "sozialversicherung_beschaeftigte_insgesamt"),
        @Index(name = "idx_btw17_strukturdaten_sv_beschaeftigte_landwirtschaft", columnList = "sozialversicherung_beschaeftigte_landwirtschaft"),
        @Index(name = "idx_btw17_strukturdaten_sv_beschaeftigte_produzierendes_gewerbe", columnList = "sozialversicherung_beschaeftigte_produzierendes_gewerbe"),
        @Index(name = "idx_btw17_strukturdaten_sv_beschaeftigte_handel", columnList = "sozialversicherung_beschaeftigte_handel"),
        @Index(name = "idx_btw17_strukturdaten_sv_beschaeftigte_dienstleister", columnList = "sozialversicherung_beschaeftigte_dienstleister"),
        @Index(name = "idx_btw17_strukturdaten_sv_beschaeftigte_sonstige", columnList = "sozialversicherung_beschaeftigte_sonstige"),
        @Index(name = "idx_btw17_strukturdaten_sgb2_insgesamt", columnList = "sgb2_insgesamt"),
        @Index(name = "idx_btw17_strukturdaten_sgb2_erwerbsunfaehige", columnList = "sgb2_erwerbsunfaehige"),

        @Index(name = "idx_btw17_strukturdaten_sgb2_auslaender", columnList = "sgb2_auslaender"),
        @Index(name = "idx_btw17_strukturdaten_arbeitslosenquote_insgesamt", columnList = "arbeitslosenquote_insgesamt"),
        @Index(name = "idx_btw17_strukturdaten_arbeitslosenquote_maenner", columnList = "arbeitslosenquote_maenner"),
        @Index(name = "idx_btw17_strukturdaten_arbeitslosenquote_frauen", columnList = "arbeitslosenquote_frauen"),
        @Index(name = "idx_btw17_strukturdaten_arbeitslosenquote_12bis20", columnList = "arbeitslosenquote_12bis20"),
        @Index(name = "idx_btw17_strukturdaten_arbeitslosenquote_55bis65", columnList = "arbeitslosenquote_55bis65"),
        @Index(name = "idx_btw17_strukturdaten_fussnoten", columnList = "fussnoten"),
    }
)
@NamedQueries({
        @NamedQuery(
                name = "Btw17Strukturdaten.getAllIds",
                query = "select o.id from Btw17Ergebnis as o order by o.id"
        )
})
@EntityListeners(Btw17StrukturdatenListener.class)
public class Btw17Strukturdaten implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * Land
     */
    @Column(name = "bundesland_name", nullable=false)
    private String bundeslandName;

    /**
     * Wahlkreis-Nr.
     */
    @Column(name = "wahlkreis_nummer", nullable=false, unique = true)
    private Long wahlkreisNummer;

    /**
     * Wahlkreis-Name
     */
    @Column(name = "wahlkreis_name", nullable=false)
    private String wahlkreisName;

    /**
     * Gemeinden am 31.12.2015 (Anzahl)
     */
    @Column(name = "anzahl_gemeinden", nullable=false)
    private Long anzahlGemeinden;

    /**
     * Fläche am 31.12.2015 (km²)
     */
    @Column(name = "flaeche", nullable=false)
    private String flaeche;

    /**
     * Bevölkerung am 31.12.2015 - Insgesamt (in 1000)
     */
    @Column(name = "bevoelkerung_deutsche", nullable=false)
    private String bevoelkerungDeutsche;

    /**
     * Bevölkerung am 31.12.2015 - Ausländer (%)
     */
    @Column(name = "bevoelkerung_auslaender", nullable=false)
    private String bevoelkerungAuslaender;

    /**
     * Bevölkerungsdichte am 31.12.2015 (Einwohner je km²)
     */
    @Column(name = "bevoelkerung_dichte", nullable=false)
    private String bevoelkerungsDichte;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Geburtensaldo (je 1000 Einwohner)
     */
    @Column(name = "bevoelkerung_geburtensaldo", nullable=false)
    private String bevoelkerungsGeburtensaldo;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Wanderungssaldo (je 1000 Einwohner)
     */
    @Column(name = "bevoelkerung_wanderungssaldo", nullable=false)
    private String bevoelkerungWanderungssaldo;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - unter 18 (%)
     */
    @Column(name = "alter_unter18", nullable=false)
    private String alterUnter18;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 18-24 (%)
     */
    @Column(name = "alter_18bis24", nullable=false)
    private String alter18bis24;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 25-34 (%)
     */
    @Column(name = "alter_25bis34", nullable=false)
    private String alter25bis34;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 35-59 (%)
     */
    @Column(name = "alter_35bis59", nullable=false)
    private String alter35bis59;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 60-74 (%)
     */
    @Column(name = "alter_60bis74", nullable=false)
    private String alter60bis74;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 75 und mehr (%)
     */
    @Column(name = "alter_75plus", nullable=false)
    private String alter75plus;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - ohne Migrationshintergrund (%)
     */
    @Column(name = "migrationshintergrund_ohne", nullable=false)
    private String migrationshintergrundOhne;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - mit Migrationshintergrund (%)
     */
    @Column(name = "migrationshintergrund_mit", nullable=false)
    private String migrationshintergrundMit;


    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Römisch-katholische Kirche (%)
     */
    @Column(name = "religion_katholisch", nullable=false)
    private String religionKatholischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Evangelische Kirche (%)
     */
    @Column(name = "religion_evangelisch", nullable=false)
    private String religionEvangelischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Sonstige, keine, ohne Angabe (%)
     */
    @Column(name = "religion_sonstige", nullable=false)
    private String religionSonstige;

    /**
     * Zensus 2011, Wohnungen in Wohngebäuden am 09.05.2011 - Eigentümerquote
     */
    @Column(name = "wohnungen_eigentuemerquote", nullable=false)
    private String wohnungenEigentuemerquote;

    /**
     * Bautätigkeit und Wohnungswesen - Fertiggestellte Wohnungen 2014 (je 1000 Einwohner)
     */
    @Column(name = "wohnungen_fertiggestellte", nullable=false)
    private String wohnungenFertiggestellte;

    /**
     * Bautätigkeit und Wohnungswesen - Bestand an Wohnungen am 31.12.2015 (je 1000 Einwohner)
     */
    @Column(name = "wohnungen_bestand", nullable=false)
    private String wohnungenBestand;

    /**
     * Verfügbares Einkommen der privaten Haushalte 2014 (€ je Einwohner)
     */
    @Column(name = "einwohner_einkommen", nullable=false)
    private String  einwohnerEinkommen;

    /**
     * Bruttoinlandsprodukt 2014 (€ je Einwohner)
     */
    @Column(name = "einwohner_bruttoinlandsprodukt", nullable=false)
    private String  einwohnerBruttoinlandsprodukt;

    /**
     * Kraftfahrzeugbestand am 01.01.2016 (je 1000 Einwohner)
     */
    @Column(name = "einwohner_kraftfahrzeugbestand", nullable=false)
    private String  einwohnerKraftfahrzeugbestand;

    /**
     * Absolventen/Abgänger beruflicher Schulen 2015;
     */
    @Column(name = "absolventen_berufliche_schulen", nullable=false)
    private String absolventenBeruflicheSchulen;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - insgesamt ohne Externe (je 1000 Einwohner)
     */
    @Column(name = "absolventen_allgemeinbildende_schulen_insgesamt", nullable=false)
    private String absolventenAllgemeinbildendeSchulenInsgesamt;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - ohne Hauptschulabschluss (%)
     */
    @Column(name = "absolventen_hauptschulabschluss_ohne", nullable=false)
    private String absolventenHauptschulabschlussOhne;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit Hauptschulabschluss (%)
     */
    @Column(name = "absolventen_hauptschulabschluss_mit", nullable=false)
    private String absolventenHauptschulabschlussMit;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit mittlerem Schulabschluss (%)
     */
    @Column(name = "absolventen_realschule", nullable=false)
    private String absolventenRealschule;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit allgemeiner und Fachhochschulreife (%)
     */
    @Column(name = "absolventen_abitur", nullable=false)
    private String absolventenAbitur;

    /**
     * Kindertagesbetreuung: Betreute Kinder am 01.03.2016 (je 1000 Einwohner)
     */
    @Column(name = "kitas_betreute_kinder", nullable=false)
    private String kitasBetreuteKinder;

    /**
     * Unternehmensregister 2014 - Unternehmen insgesamt (je 1000 Einwohner)
     */
    @Column(name = "unternehmen_insgesamt", nullable=false)
    private String unternehmenInsgesamt;

    /**
     * Unternehmensregister 2014 - Handwerksunternehmen (je 1000 Einwohner)
     */
    @Column(name = "unternehmen_handwerk", nullable=false)
    private String unternehmenHandwerk;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - insgesamt (je 1000 Einwohner)
     */
    @Column(name = "sozialversicherung_beschaeftigte_insgesamt", nullable=false)
    private String sozialversicherungBeschaeftigteInsgesamt;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Land- und Forstwirtschaft, Fischerei (%)
     */
    @Column(name = "sozialversicherung_beschaeftigte_landwirtschaft", nullable=false)
    private String sozialversicherungBeschaeftigteLandwirtschaft;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Produzierendes Gewerbe (%)
     */
    @Column(name = "sozialversicherung_beschaeftigte_produzierendes_gewerbe", nullable=false)
    private String sozialversicherungBeschaeftigteProduzierendesGewerbe;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Handel, Gastgewerbe, Verkehr (%)
     */
    @Column(name = "sozialversicherung_beschaeftigte_handel", nullable=false)
    private String sozialversicherungBeschaeftigteHandel;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Öffentliche und private Dienstleister (%)
     */
    @Column(name = "sozialversicherung_beschaeftigte_dienstleister", nullable=false)
    private String sozialversicherungBeschaeftigteDienstleister;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Übrige Dienstleister und 'ohne Angabe' (%)
     */
    @Column(name = "sozialversicherung_beschaeftigte_sonstige", nullable=false)
    private String sozialversicherungBeschaeftigteSonstige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 -  insgesamt (je 1000 Einwohner)
     */
    @Column(name = "sgb2_insgesamt", nullable=false)
    private String sgb2insgesamt;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - nicht erwerbsfähige Hilfebedürftige (%)
     */
    @Column(name = "sgb2_erwerbsunfaehige", nullable=false)
    private String sgb2erwerbsunfaehige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - Ausländer (%)
     */
    @Column(name = "sgb2_auslaender", nullable=false)
    private String sgb2auslaender;

    /**
     * Arbeitslosenquote März 2017 - insgesamt
     */
    @Column(name = "arbeitslosenquote_insgesamt", nullable=false)
    private String arbeitslosenquoteInsgesamt;

    /**
     * Arbeitslosenquote März 2017 - Männer
     */
    @Column(name = "arbeitslosenquote_maenner", nullable=false)
    private String arbeitslosenquoteMaenner;

    /**
     * Arbeitslosenquote März 2017 - Frauen
     */
    @Column(name = "arbeitslosenquote_frauen", nullable=false)
    private String arbeitslosenquoteFrauen;

    /**
     * Arbeitslosenquote März 2017 - 15 bis unter 20 Jahre
     */
    @Column(name = "arbeitslosenquote_12bis20", nullable=false)
    private String arbeitslosenquote12bis20;

    /**
     * Arbeitslosenquote März 2017 - 55 bis unter 65 Jahre
     */
    @Column(name = "arbeitslosenquote_55bis65", nullable=false)
    private String arbeitslosenquote55bis65;

    /**
     * Fußnoten
     */
    @Column(name = "fussnoten", nullable=false)
    private String fussnoten;

    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlkreisName+" in "+bundeslandName;
    }

    @Override
    public String getUniqueId() {
        return id+":"+bundeslandName+":"+wahlkreisNummer+":"+wahlkreisName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBundeslandName() {
        return bundeslandName;
    }

    public void setBundeslandName(String bundeslandName) {
        this.bundeslandName = bundeslandName;
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

    public Long getAnzahlGemeinden() {
        return anzahlGemeinden;
    }

    public void setAnzahlGemeinden(Long anzahlGemeinden) {
        this.anzahlGemeinden = anzahlGemeinden;
    }

    public String getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(String flaeche) {
        this.flaeche = flaeche;
    }

    public String getBevoelkerungDeutsche() {
        return bevoelkerungDeutsche;
    }

    public void setBevoelkerungDeutsche(String bevoelkerungDeutsche) {
        this.bevoelkerungDeutsche = bevoelkerungDeutsche;
    }

    public String getBevoelkerungAuslaender() {
        return bevoelkerungAuslaender;
    }

    public void setBevoelkerungAuslaender(String bevoelkerungAuslaender) {
        this.bevoelkerungAuslaender = bevoelkerungAuslaender;
    }

    public String getBevoelkerungsDichte() {
        return bevoelkerungsDichte;
    }

    public void setBevoelkerungsDichte(String bevoelkerungsDichte) {
        this.bevoelkerungsDichte = bevoelkerungsDichte;
    }

    public String getBevoelkerungsGeburtensaldo() {
        return bevoelkerungsGeburtensaldo;
    }

    public void setBevoelkerungsGeburtensaldo(String bevoelkerungsGeburtensaldo) {
        this.bevoelkerungsGeburtensaldo = bevoelkerungsGeburtensaldo;
    }

    public String getBevoelkerungWanderungssaldo() {
        return bevoelkerungWanderungssaldo;
    }

    public void setBevoelkerungWanderungssaldo(String bevoelkerungWanderungssaldo) {
        this.bevoelkerungWanderungssaldo = bevoelkerungWanderungssaldo;
    }

    public String getAlterUnter18() {
        return alterUnter18;
    }

    public void setAlterUnter18(String alterUnter18) {
        this.alterUnter18 = alterUnter18;
    }

    public String getAlter18bis24() {
        return alter18bis24;
    }

    public void setAlter18bis24(String alter18bis24) {
        this.alter18bis24 = alter18bis24;
    }

    public String getAlter25bis34() {
        return alter25bis34;
    }

    public void setAlter25bis34(String alter25bis34) {
        this.alter25bis34 = alter25bis34;
    }

    public String getAlter35bis59() {
        return alter35bis59;
    }

    public void setAlter35bis59(String alter35bis59) {
        this.alter35bis59 = alter35bis59;
    }

    public String getAlter60bis74() {
        return alter60bis74;
    }

    public void setAlter60bis74(String alter60bis74) {
        this.alter60bis74 = alter60bis74;
    }

    public String getAlter75plus() {
        return alter75plus;
    }

    public void setAlter75plus(String alter75plus) {
        this.alter75plus = alter75plus;
    }

    public String getMigrationshintergrundOhne() {
        return migrationshintergrundOhne;
    }

    public void setMigrationshintergrundOhne(String migrationshintergrundOhne) {
        this.migrationshintergrundOhne = migrationshintergrundOhne;
    }

    public String getMigrationshintergrundMit() {
        return migrationshintergrundMit;
    }

    public void setMigrationshintergrundMit(String migrationshintergrundMit) {
        this.migrationshintergrundMit = migrationshintergrundMit;
    }

    public String getReligionKatholischeKirche() {
        return religionKatholischeKirche;
    }

    public void setReligionKatholischeKirche(String religionKatholischeKirche) {
        this.religionKatholischeKirche = religionKatholischeKirche;
    }

    public String getReligionEvangelischeKirche() {
        return religionEvangelischeKirche;
    }

    public void setReligionEvangelischeKirche(String religionEvangelischeKirche) {
        this.religionEvangelischeKirche = religionEvangelischeKirche;
    }

    public String getReligionSonstige() {
        return religionSonstige;
    }

    public void setReligionSonstige(String religionSonstige) {
        this.religionSonstige = religionSonstige;
    }

    public String getWohnungenEigentuemerquote() {
        return wohnungenEigentuemerquote;
    }

    public void setWohnungenEigentuemerquote(String wohnungenEigentuemerquote) {
        this.wohnungenEigentuemerquote = wohnungenEigentuemerquote;
    }

    public String getWohnungenFertiggestellte() {
        return wohnungenFertiggestellte;
    }

    public void setWohnungenFertiggestellte(String wohnungenFertiggestellte) {
        this.wohnungenFertiggestellte = wohnungenFertiggestellte;
    }

    public String getWohnungenBestand() {
        return wohnungenBestand;
    }

    public void setWohnungenBestand(String wohnungenBestand) {
        this.wohnungenBestand = wohnungenBestand;
    }

    public String getEinwohnerEinkommen() {
        return einwohnerEinkommen;
    }

    public void setEinwohnerEinkommen(String einwohnerEinkommen) {
        this.einwohnerEinkommen = einwohnerEinkommen;
    }

    public String getEinwohnerBruttoinlandsprodukt() {
        return einwohnerBruttoinlandsprodukt;
    }

    public void setEinwohnerBruttoinlandsprodukt(String einwohnerBruttoinlandsprodukt) {
        this.einwohnerBruttoinlandsprodukt = einwohnerBruttoinlandsprodukt;
    }

    public String getEinwohnerKraftfahrzeugbestand() {
        return einwohnerKraftfahrzeugbestand;
    }

    public void setEinwohnerKraftfahrzeugbestand(String einwohnerKraftfahrzeugbestand) {
        this.einwohnerKraftfahrzeugbestand = einwohnerKraftfahrzeugbestand;
    }

    public String getAbsolventenBeruflicheSchulen() {
        return absolventenBeruflicheSchulen;
    }

    public void setAbsolventenBeruflicheSchulen(String absolventenBeruflicheSchulen) {
        this.absolventenBeruflicheSchulen = absolventenBeruflicheSchulen;
    }

    public String getAbsolventenAllgemeinbildendeSchulenInsgesamt() {
        return absolventenAllgemeinbildendeSchulenInsgesamt;
    }

    public void setAbsolventenAllgemeinbildendeSchulenInsgesamt(String absolventenAllgemeinbildendeSchulenInsgesamt) {
        this.absolventenAllgemeinbildendeSchulenInsgesamt = absolventenAllgemeinbildendeSchulenInsgesamt;
    }

    public String getAbsolventenHauptschulabschlussOhne() {
        return absolventenHauptschulabschlussOhne;
    }

    public void setAbsolventenHauptschulabschlussOhne(String absolventenHauptschulabschlussOhne) {
        this.absolventenHauptschulabschlussOhne = absolventenHauptschulabschlussOhne;
    }

    public String getAbsolventenHauptschulabschlussMit() {
        return absolventenHauptschulabschlussMit;
    }

    public void setAbsolventenHauptschulabschlussMit(String absolventenHauptschulabschlussMit) {
        this.absolventenHauptschulabschlussMit = absolventenHauptschulabschlussMit;
    }

    public String getAbsolventenRealschule() {
        return absolventenRealschule;
    }

    public void setAbsolventenRealschule(String absolventenRealschule) {
        this.absolventenRealschule = absolventenRealschule;
    }

    public String getAbsolventenAbitur() {
        return absolventenAbitur;
    }

    public void setAbsolventenAbitur(String absolventenAbitur) {
        this.absolventenAbitur = absolventenAbitur;
    }

    public String getKitasBetreuteKinder() {
        return kitasBetreuteKinder;
    }

    public void setKitasBetreuteKinder(String kitasBetreuteKinder) {
        this.kitasBetreuteKinder = kitasBetreuteKinder;
    }

    public String getUnternehmenInsgesamt() {
        return unternehmenInsgesamt;
    }

    public void setUnternehmenInsgesamt(String unternehmenInsgesamt) {
        this.unternehmenInsgesamt = unternehmenInsgesamt;
    }

    public String getUnternehmenHandwerk() {
        return unternehmenHandwerk;
    }

    public void setUnternehmenHandwerk(String unternehmenHandwerk) {
        this.unternehmenHandwerk = unternehmenHandwerk;
    }

    public String getSozialversicherungBeschaeftigteInsgesamt() {
        return sozialversicherungBeschaeftigteInsgesamt;
    }

    public void setSozialversicherungBeschaeftigteInsgesamt(String sozialversicherungBeschaeftigteInsgesamt) {
        this.sozialversicherungBeschaeftigteInsgesamt = sozialversicherungBeschaeftigteInsgesamt;
    }

    public String getSozialversicherungBeschaeftigteLandwirtschaft() {
        return sozialversicherungBeschaeftigteLandwirtschaft;
    }

    public void setSozialversicherungBeschaeftigteLandwirtschaft(String sozialversicherungBeschaeftigteLandwirtschaft) {
        this.sozialversicherungBeschaeftigteLandwirtschaft = sozialversicherungBeschaeftigteLandwirtschaft;
    }

    public String getSozialversicherungBeschaeftigteProduzierendesGewerbe() {
        return sozialversicherungBeschaeftigteProduzierendesGewerbe;
    }

    public void setSozialversicherungBeschaeftigteProduzierendesGewerbe(String sozialversicherungBeschaeftigteProduzierendesGewerbe) {
        this.sozialversicherungBeschaeftigteProduzierendesGewerbe = sozialversicherungBeschaeftigteProduzierendesGewerbe;
    }

    public String getSozialversicherungBeschaeftigteHandel() {
        return sozialversicherungBeschaeftigteHandel;
    }

    public void setSozialversicherungBeschaeftigteHandel(String sozialversicherungBeschaeftigteHandel) {
        this.sozialversicherungBeschaeftigteHandel = sozialversicherungBeschaeftigteHandel;
    }

    public String getSozialversicherungBeschaeftigteDienstleister() {
        return sozialversicherungBeschaeftigteDienstleister;
    }

    public void setSozialversicherungBeschaeftigteDienstleister(String sozialversicherungBeschaeftigteDienstleister) {
        this.sozialversicherungBeschaeftigteDienstleister = sozialversicherungBeschaeftigteDienstleister;
    }

    public String getSozialversicherungBeschaeftigteSonstige() {
        return sozialversicherungBeschaeftigteSonstige;
    }

    public void setSozialversicherungBeschaeftigteSonstige(String sozialversicherungBeschaeftigteSonstige) {
        this.sozialversicherungBeschaeftigteSonstige = sozialversicherungBeschaeftigteSonstige;
    }

    public String getSgb2insgesamt() {
        return sgb2insgesamt;
    }

    public void setSgb2insgesamt(String sgb2insgesamt) {
        this.sgb2insgesamt = sgb2insgesamt;
    }

    public String getSgb2erwerbsunfaehige() {
        return sgb2erwerbsunfaehige;
    }

    public void setSgb2erwerbsunfaehige(String sgb2erwerbsunfaehige) {
        this.sgb2erwerbsunfaehige = sgb2erwerbsunfaehige;
    }

    public String getSgb2auslaender() {
        return sgb2auslaender;
    }

    public void setSgb2auslaender(String sgb2auslaender) {
        this.sgb2auslaender = sgb2auslaender;
    }

    public String getArbeitslosenquoteInsgesamt() {
        return arbeitslosenquoteInsgesamt;
    }

    public void setArbeitslosenquoteInsgesamt(String arbeitslosenquoteInsgesamt) {
        this.arbeitslosenquoteInsgesamt = arbeitslosenquoteInsgesamt;
    }

    public String getArbeitslosenquoteMaenner() {
        return arbeitslosenquoteMaenner;
    }

    public void setArbeitslosenquoteMaenner(String arbeitslosenquoteMaenner) {
        this.arbeitslosenquoteMaenner = arbeitslosenquoteMaenner;
    }

    public String getArbeitslosenquoteFrauen() {
        return arbeitslosenquoteFrauen;
    }

    public void setArbeitslosenquoteFrauen(String arbeitslosenquoteFrauen) {
        this.arbeitslosenquoteFrauen = arbeitslosenquoteFrauen;
    }

    public String getArbeitslosenquote12bis20() {
        return arbeitslosenquote12bis20;
    }

    public void setArbeitslosenquote12bis20(String arbeitslosenquote12bis20) {
        this.arbeitslosenquote12bis20 = arbeitslosenquote12bis20;
    }

    public String getArbeitslosenquote55bis65() {
        return arbeitslosenquote55bis65;
    }

    public void setArbeitslosenquote55bis65(String arbeitslosenquote55bis65) {
        this.arbeitslosenquote55bis65 = arbeitslosenquote55bis65;
    }

    public String getFussnoten() {
        return fussnoten;
    }

    public void setFussnoten(String fussnoten) {
        this.fussnoten = fussnoten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Btw17Strukturdaten)) return false;

        Btw17Strukturdaten that = (Btw17Strukturdaten) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bundeslandName != null ? !bundeslandName.equals(that.bundeslandName) : that.bundeslandName != null)
            return false;
        if (wahlkreisNummer != null ? !wahlkreisNummer.equals(that.wahlkreisNummer) : that.wahlkreisNummer != null)
            return false;
        if (wahlkreisName != null ? !wahlkreisName.equals(that.wahlkreisName) : that.wahlkreisName != null)
            return false;
        if (anzahlGemeinden != null ? !anzahlGemeinden.equals(that.anzahlGemeinden) : that.anzahlGemeinden != null)
            return false;
        if (flaeche != null ? !flaeche.equals(that.flaeche) : that.flaeche != null) return false;
        if (bevoelkerungDeutsche != null ? !bevoelkerungDeutsche.equals(that.bevoelkerungDeutsche) : that.bevoelkerungDeutsche != null)
            return false;
        if (bevoelkerungAuslaender != null ? !bevoelkerungAuslaender.equals(that.bevoelkerungAuslaender) : that.bevoelkerungAuslaender != null)
            return false;
        if (bevoelkerungsDichte != null ? !bevoelkerungsDichte.equals(that.bevoelkerungsDichte) : that.bevoelkerungsDichte != null)
            return false;
        if (bevoelkerungsGeburtensaldo != null ? !bevoelkerungsGeburtensaldo.equals(that.bevoelkerungsGeburtensaldo) : that.bevoelkerungsGeburtensaldo != null)
            return false;
        if (bevoelkerungWanderungssaldo != null ? !bevoelkerungWanderungssaldo.equals(that.bevoelkerungWanderungssaldo) : that.bevoelkerungWanderungssaldo != null)
            return false;
        if (alterUnter18 != null ? !alterUnter18.equals(that.alterUnter18) : that.alterUnter18 != null) return false;
        if (alter18bis24 != null ? !alter18bis24.equals(that.alter18bis24) : that.alter18bis24 != null) return false;
        if (alter25bis34 != null ? !alter25bis34.equals(that.alter25bis34) : that.alter25bis34 != null) return false;
        if (alter35bis59 != null ? !alter35bis59.equals(that.alter35bis59) : that.alter35bis59 != null) return false;
        if (alter60bis74 != null ? !alter60bis74.equals(that.alter60bis74) : that.alter60bis74 != null) return false;
        if (alter75plus != null ? !alter75plus.equals(that.alter75plus) : that.alter75plus != null) return false;
        if (migrationshintergrundOhne != null ? !migrationshintergrundOhne.equals(that.migrationshintergrundOhne) : that.migrationshintergrundOhne != null)
            return false;
        if (migrationshintergrundMit != null ? !migrationshintergrundMit.equals(that.migrationshintergrundMit) : that.migrationshintergrundMit != null)
            return false;
        if (religionKatholischeKirche != null ? !religionKatholischeKirche.equals(that.religionKatholischeKirche) : that.religionKatholischeKirche != null)
            return false;
        if (religionEvangelischeKirche != null ? !religionEvangelischeKirche.equals(that.religionEvangelischeKirche) : that.religionEvangelischeKirche != null)
            return false;
        if (religionSonstige != null ? !religionSonstige.equals(that.religionSonstige) : that.religionSonstige != null)
            return false;
        if (wohnungenEigentuemerquote != null ? !wohnungenEigentuemerquote.equals(that.wohnungenEigentuemerquote) : that.wohnungenEigentuemerquote != null)
            return false;
        if (wohnungenFertiggestellte != null ? !wohnungenFertiggestellte.equals(that.wohnungenFertiggestellte) : that.wohnungenFertiggestellte != null)
            return false;
        if (wohnungenBestand != null ? !wohnungenBestand.equals(that.wohnungenBestand) : that.wohnungenBestand != null)
            return false;
        if (einwohnerEinkommen != null ? !einwohnerEinkommen.equals(that.einwohnerEinkommen) : that.einwohnerEinkommen != null)
            return false;
        if (einwohnerBruttoinlandsprodukt != null ? !einwohnerBruttoinlandsprodukt.equals(that.einwohnerBruttoinlandsprodukt) : that.einwohnerBruttoinlandsprodukt != null)
            return false;
        if (einwohnerKraftfahrzeugbestand != null ? !einwohnerKraftfahrzeugbestand.equals(that.einwohnerKraftfahrzeugbestand) : that.einwohnerKraftfahrzeugbestand != null)
            return false;
        if (absolventenBeruflicheSchulen != null ? !absolventenBeruflicheSchulen.equals(that.absolventenBeruflicheSchulen) : that.absolventenBeruflicheSchulen != null)
            return false;
        if (absolventenAllgemeinbildendeSchulenInsgesamt != null ? !absolventenAllgemeinbildendeSchulenInsgesamt.equals(that.absolventenAllgemeinbildendeSchulenInsgesamt) : that.absolventenAllgemeinbildendeSchulenInsgesamt != null)
            return false;
        if (absolventenHauptschulabschlussOhne != null ? !absolventenHauptschulabschlussOhne.equals(that.absolventenHauptschulabschlussOhne) : that.absolventenHauptschulabschlussOhne != null)
            return false;
        if (absolventenHauptschulabschlussMit != null ? !absolventenHauptschulabschlussMit.equals(that.absolventenHauptschulabschlussMit) : that.absolventenHauptschulabschlussMit != null)
            return false;
        if (absolventenRealschule != null ? !absolventenRealschule.equals(that.absolventenRealschule) : that.absolventenRealschule != null)
            return false;
        if (absolventenAbitur != null ? !absolventenAbitur.equals(that.absolventenAbitur) : that.absolventenAbitur != null)
            return false;
        if (kitasBetreuteKinder != null ? !kitasBetreuteKinder.equals(that.kitasBetreuteKinder) : that.kitasBetreuteKinder != null)
            return false;
        if (unternehmenInsgesamt != null ? !unternehmenInsgesamt.equals(that.unternehmenInsgesamt) : that.unternehmenInsgesamt != null)
            return false;
        if (unternehmenHandwerk != null ? !unternehmenHandwerk.equals(that.unternehmenHandwerk) : that.unternehmenHandwerk != null)
            return false;
        if (sozialversicherungBeschaeftigteInsgesamt != null ? !sozialversicherungBeschaeftigteInsgesamt.equals(that.sozialversicherungBeschaeftigteInsgesamt) : that.sozialversicherungBeschaeftigteInsgesamt != null)
            return false;
        if (sozialversicherungBeschaeftigteLandwirtschaft != null ? !sozialversicherungBeschaeftigteLandwirtschaft.equals(that.sozialversicherungBeschaeftigteLandwirtschaft) : that.sozialversicherungBeschaeftigteLandwirtschaft != null)
            return false;
        if (sozialversicherungBeschaeftigteProduzierendesGewerbe != null ? !sozialversicherungBeschaeftigteProduzierendesGewerbe.equals(that.sozialversicherungBeschaeftigteProduzierendesGewerbe) : that.sozialversicherungBeschaeftigteProduzierendesGewerbe != null)
            return false;
        if (sozialversicherungBeschaeftigteHandel != null ? !sozialversicherungBeschaeftigteHandel.equals(that.sozialversicherungBeschaeftigteHandel) : that.sozialversicherungBeschaeftigteHandel != null)
            return false;
        if (sozialversicherungBeschaeftigteDienstleister != null ? !sozialversicherungBeschaeftigteDienstleister.equals(that.sozialversicherungBeschaeftigteDienstleister) : that.sozialversicherungBeschaeftigteDienstleister != null)
            return false;
        if (sozialversicherungBeschaeftigteSonstige != null ? !sozialversicherungBeschaeftigteSonstige.equals(that.sozialversicherungBeschaeftigteSonstige) : that.sozialversicherungBeschaeftigteSonstige != null)
            return false;
        if (sgb2insgesamt != null ? !sgb2insgesamt.equals(that.sgb2insgesamt) : that.sgb2insgesamt != null)
            return false;
        if (sgb2erwerbsunfaehige != null ? !sgb2erwerbsunfaehige.equals(that.sgb2erwerbsunfaehige) : that.sgb2erwerbsunfaehige != null)
            return false;
        if (sgb2auslaender != null ? !sgb2auslaender.equals(that.sgb2auslaender) : that.sgb2auslaender != null)
            return false;
        if (arbeitslosenquoteInsgesamt != null ? !arbeitslosenquoteInsgesamt.equals(that.arbeitslosenquoteInsgesamt) : that.arbeitslosenquoteInsgesamt != null)
            return false;
        if (arbeitslosenquoteMaenner != null ? !arbeitslosenquoteMaenner.equals(that.arbeitslosenquoteMaenner) : that.arbeitslosenquoteMaenner != null)
            return false;
        if (arbeitslosenquoteFrauen != null ? !arbeitslosenquoteFrauen.equals(that.arbeitslosenquoteFrauen) : that.arbeitslosenquoteFrauen != null)
            return false;
        if (arbeitslosenquote12bis20 != null ? !arbeitslosenquote12bis20.equals(that.arbeitslosenquote12bis20) : that.arbeitslosenquote12bis20 != null)
            return false;
        if (arbeitslosenquote55bis65 != null ? !arbeitslosenquote55bis65.equals(that.arbeitslosenquote55bis65) : that.arbeitslosenquote55bis65 != null)
            return false;
        return fussnoten != null ? fussnoten.equals(that.fussnoten) : that.fussnoten == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bundeslandName != null ? bundeslandName.hashCode() : 0);
        result = 31 * result + (wahlkreisNummer != null ? wahlkreisNummer.hashCode() : 0);
        result = 31 * result + (wahlkreisName != null ? wahlkreisName.hashCode() : 0);
        result = 31 * result + (anzahlGemeinden != null ? anzahlGemeinden.hashCode() : 0);
        result = 31 * result + (flaeche != null ? flaeche.hashCode() : 0);
        result = 31 * result + (bevoelkerungDeutsche != null ? bevoelkerungDeutsche.hashCode() : 0);
        result = 31 * result + (bevoelkerungAuslaender != null ? bevoelkerungAuslaender.hashCode() : 0);
        result = 31 * result + (bevoelkerungsDichte != null ? bevoelkerungsDichte.hashCode() : 0);
        result = 31 * result + (bevoelkerungsGeburtensaldo != null ? bevoelkerungsGeburtensaldo.hashCode() : 0);
        result = 31 * result + (bevoelkerungWanderungssaldo != null ? bevoelkerungWanderungssaldo.hashCode() : 0);
        result = 31 * result + (alterUnter18 != null ? alterUnter18.hashCode() : 0);
        result = 31 * result + (alter18bis24 != null ? alter18bis24.hashCode() : 0);
        result = 31 * result + (alter25bis34 != null ? alter25bis34.hashCode() : 0);
        result = 31 * result + (alter35bis59 != null ? alter35bis59.hashCode() : 0);
        result = 31 * result + (alter60bis74 != null ? alter60bis74.hashCode() : 0);
        result = 31 * result + (alter75plus != null ? alter75plus.hashCode() : 0);
        result = 31 * result + (migrationshintergrundOhne != null ? migrationshintergrundOhne.hashCode() : 0);
        result = 31 * result + (migrationshintergrundMit != null ? migrationshintergrundMit.hashCode() : 0);
        result = 31 * result + (religionKatholischeKirche != null ? religionKatholischeKirche.hashCode() : 0);
        result = 31 * result + (religionEvangelischeKirche != null ? religionEvangelischeKirche.hashCode() : 0);
        result = 31 * result + (religionSonstige != null ? religionSonstige.hashCode() : 0);
        result = 31 * result + (wohnungenEigentuemerquote != null ? wohnungenEigentuemerquote.hashCode() : 0);
        result = 31 * result + (wohnungenFertiggestellte != null ? wohnungenFertiggestellte.hashCode() : 0);
        result = 31 * result + (wohnungenBestand != null ? wohnungenBestand.hashCode() : 0);
        result = 31 * result + (einwohnerEinkommen != null ? einwohnerEinkommen.hashCode() : 0);
        result = 31 * result + (einwohnerBruttoinlandsprodukt != null ? einwohnerBruttoinlandsprodukt.hashCode() : 0);
        result = 31 * result + (einwohnerKraftfahrzeugbestand != null ? einwohnerKraftfahrzeugbestand.hashCode() : 0);
        result = 31 * result + (absolventenBeruflicheSchulen != null ? absolventenBeruflicheSchulen.hashCode() : 0);
        result = 31 * result + (absolventenAllgemeinbildendeSchulenInsgesamt != null ? absolventenAllgemeinbildendeSchulenInsgesamt.hashCode() : 0);
        result = 31 * result + (absolventenHauptschulabschlussOhne != null ? absolventenHauptschulabschlussOhne.hashCode() : 0);
        result = 31 * result + (absolventenHauptschulabschlussMit != null ? absolventenHauptschulabschlussMit.hashCode() : 0);
        result = 31 * result + (absolventenRealschule != null ? absolventenRealschule.hashCode() : 0);
        result = 31 * result + (absolventenAbitur != null ? absolventenAbitur.hashCode() : 0);
        result = 31 * result + (kitasBetreuteKinder != null ? kitasBetreuteKinder.hashCode() : 0);
        result = 31 * result + (unternehmenInsgesamt != null ? unternehmenInsgesamt.hashCode() : 0);
        result = 31 * result + (unternehmenHandwerk != null ? unternehmenHandwerk.hashCode() : 0);
        result = 31 * result + (sozialversicherungBeschaeftigteInsgesamt != null ? sozialversicherungBeschaeftigteInsgesamt.hashCode() : 0);
        result = 31 * result + (sozialversicherungBeschaeftigteLandwirtschaft != null ? sozialversicherungBeschaeftigteLandwirtschaft.hashCode() : 0);
        result = 31 * result + (sozialversicherungBeschaeftigteProduzierendesGewerbe != null ? sozialversicherungBeschaeftigteProduzierendesGewerbe.hashCode() : 0);
        result = 31 * result + (sozialversicherungBeschaeftigteHandel != null ? sozialversicherungBeschaeftigteHandel.hashCode() : 0);
        result = 31 * result + (sozialversicherungBeschaeftigteDienstleister != null ? sozialversicherungBeschaeftigteDienstleister.hashCode() : 0);
        result = 31 * result + (sozialversicherungBeschaeftigteSonstige != null ? sozialversicherungBeschaeftigteSonstige.hashCode() : 0);
        result = 31 * result + (sgb2insgesamt != null ? sgb2insgesamt.hashCode() : 0);
        result = 31 * result + (sgb2erwerbsunfaehige != null ? sgb2erwerbsunfaehige.hashCode() : 0);
        result = 31 * result + (sgb2auslaender != null ? sgb2auslaender.hashCode() : 0);
        result = 31 * result + (arbeitslosenquoteInsgesamt != null ? arbeitslosenquoteInsgesamt.hashCode() : 0);
        result = 31 * result + (arbeitslosenquoteMaenner != null ? arbeitslosenquoteMaenner.hashCode() : 0);
        result = 31 * result + (arbeitslosenquoteFrauen != null ? arbeitslosenquoteFrauen.hashCode() : 0);
        result = 31 * result + (arbeitslosenquote12bis20 != null ? arbeitslosenquote12bis20.hashCode() : 0);
        result = 31 * result + (arbeitslosenquote55bis65 != null ? arbeitslosenquote55bis65.hashCode() : 0);
        result = 31 * result + (fussnoten != null ? fussnoten.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Btw17Strukturdaten{" +
                "id=" + id +
                ", bundeslandName='" + bundeslandName + '\'' +
                ", wahlkreisNummer=" + wahlkreisNummer +
                ", wahlkreisName='" + wahlkreisName + '\'' +
                ", anzahlGemeinden=" + anzahlGemeinden +
                ", flaeche='" + flaeche + '\'' +
                ", bevoelkerungDeutsche='" + bevoelkerungDeutsche + '\'' +
                ", bevoelkerungAuslaender='" + bevoelkerungAuslaender + '\'' +
                ", bevoelkerungsDichte='" + bevoelkerungsDichte + '\'' +
                ", bevoelkerungsGeburtensaldo='" + bevoelkerungsGeburtensaldo + '\'' +
                ", bevoelkerungWanderungssaldo='" + bevoelkerungWanderungssaldo + '\'' +
                ", alterUnter18='" + alterUnter18 + '\'' +
                ", alter18bis24='" + alter18bis24 + '\'' +
                ", alter25bis34='" + alter25bis34 + '\'' +
                ", alter35bis59='" + alter35bis59 + '\'' +
                ", alter60bis74='" + alter60bis74 + '\'' +
                ", alter75plus='" + alter75plus + '\'' +
                ", migrationshintergrundOhne='" + migrationshintergrundOhne + '\'' +
                ", migrationshintergrundMit='" + migrationshintergrundMit + '\'' +
                ", religionKatholischeKirche='" + religionKatholischeKirche + '\'' +
                ", religionEvangelischeKirche='" + religionEvangelischeKirche + '\'' +
                ", religionSonstige='" + religionSonstige + '\'' +
                ", wohnungenEigentuemerquote='" + wohnungenEigentuemerquote + '\'' +
                ", wohnungenFertiggestellte='" + wohnungenFertiggestellte + '\'' +
                ", wohnungenBestand='" + wohnungenBestand + '\'' +
                ", einwohnerEinkommen='" + einwohnerEinkommen + '\'' +
                ", einwohnerBruttoinlandsprodukt='" + einwohnerBruttoinlandsprodukt + '\'' +
                ", einwohnerKraftfahrzeugbestand='" + einwohnerKraftfahrzeugbestand + '\'' +
                ", absolventenBeruflicheSchulen='" + absolventenBeruflicheSchulen + '\'' +
                ", absolventenAllgemeinbildendeSchulenInsgesamt='" + absolventenAllgemeinbildendeSchulenInsgesamt + '\'' +
                ", absolventenHauptschulabschlussOhne='" + absolventenHauptschulabschlussOhne + '\'' +
                ", absolventenHauptschulabschlussMit='" + absolventenHauptschulabschlussMit + '\'' +
                ", absolventenRealschule='" + absolventenRealschule + '\'' +
                ", absolventenAbitur='" + absolventenAbitur + '\'' +
                ", kitasBetreuteKinder='" + kitasBetreuteKinder + '\'' +
                ", unternehmenInsgesamt='" + unternehmenInsgesamt + '\'' +
                ", unternehmenHandwerk='" + unternehmenHandwerk + '\'' +
                ", sozialversicherungBeschaeftigteInsgesamt='" + sozialversicherungBeschaeftigteInsgesamt + '\'' +
                ", sozialversicherungBeschaeftigteLandwirtschaft='" + sozialversicherungBeschaeftigteLandwirtschaft + '\'' +
                ", sozialversicherungBeschaeftigteProduzierendesGewerbe='" + sozialversicherungBeschaeftigteProduzierendesGewerbe + '\'' +
                ", sozialversicherungBeschaeftigteHandel='" + sozialversicherungBeschaeftigteHandel + '\'' +
                ", sozialversicherungBeschaeftigteDienstleister='" + sozialversicherungBeschaeftigteDienstleister + '\'' +
                ", sozialversicherungBeschaeftigteSonstige='" + sozialversicherungBeschaeftigteSonstige + '\'' +
                ", sgb2insgesamt='" + sgb2insgesamt + '\'' +
                ", sgb2erwerbsunfaehige='" + sgb2erwerbsunfaehige + '\'' +
                ", sgb2auslaender='" + sgb2auslaender + '\'' +
                ", arbeitslosenquoteInsgesamt='" + arbeitslosenquoteInsgesamt + '\'' +
                ", arbeitslosenquoteMaenner='" + arbeitslosenquoteMaenner + '\'' +
                ", arbeitslosenquoteFrauen='" + arbeitslosenquoteFrauen + '\'' +
                ", arbeitslosenquote12bis20='" + arbeitslosenquote12bis20 + '\'' +
                ", arbeitslosenquote55bis65='" + arbeitslosenquote55bis65 + '\'' +
                ", fussnoten='" + fussnoten + '\'' +
                '}';
    }
}
