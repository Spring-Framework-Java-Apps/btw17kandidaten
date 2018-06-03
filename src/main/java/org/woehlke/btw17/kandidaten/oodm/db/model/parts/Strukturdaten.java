package org.woehlke.btw17.kandidaten.oodm.db.model.parts;


import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

@Validated
@Embeddable
public class Strukturdaten implements Serializable {

    /**
     * Gemeinden am 31.12.2015 (Anzahl)
     */
    @Column(name = "anzahl_gemeinden")
    private Long anzahlGemeinden;

    /**
     * Fläche am 31.12.2015 (km²)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "flaeche", precision=10, scale=1)
    private BigDecimal flaeche;


    /**
     * Bevölkerung am 31.12.2015 - Insgesamt (in 1000)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_insgesamt", precision=10, scale=1)
    private BigDecimal bevoelkerungInsgesamt;

    /**
     * Bevölkerung am 31.12.2015 - Deutsche (in 1000)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_deutsche", precision=10, scale=1)
    private BigDecimal bevoelkerungDeutsche;

    /**
     * Bevölkerung am 31.12.2015 - Ausländer (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_auslaender", precision=10, scale=1)
    private BigDecimal bevoelkerungAuslaender;

    /**
     * Bevölkerungsdichte am 31.12.2015 (Einwohner je km²)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_dichte", precision=10, scale=1)
    private BigDecimal bevoelkerungsDichte;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Geburtensaldo (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_geburtensaldo", precision=10, scale=1)
    private BigDecimal bevoelkerungsGeburtensaldo;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Wanderungssaldo (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_wanderungssaldo", precision=10, scale=1)
    private BigDecimal bevoelkerungWanderungssaldo;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - unter 18 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_unter18", precision=10, scale=1)
    private BigDecimal alterUnter18;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 18-24 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_18bis24", precision=10, scale=1)
    private BigDecimal alter18bis24;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 25-34 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_25bis34", precision=10, scale=1)
    private BigDecimal alter25bis34;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 35-59 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_35bis59", precision=10, scale=1)
    private BigDecimal alter35bis59;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 60-74 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_60bis74", precision=10, scale=1)
    private BigDecimal alter60bis74;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 75 und mehr (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_75plus", precision=10, scale=1)
    private BigDecimal alter75plus;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - ohne Migrationshintergrund (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "migrationshintergrund_ohne", precision=10, scale=1)
    private BigDecimal migrationshintergrundOhne;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - mit Migrationshintergrund (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "migrationshintergrund_mit", precision=10, scale=1)
    private BigDecimal migrationshintergrundMit;


    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Römisch-katholische Kirche (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "religion_katholisch", precision=10, scale=1)
    private BigDecimal religionKatholischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Evangelische Kirche (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "religion_evangelisch", precision=10, scale=1)
    private BigDecimal religionEvangelischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Sonstige, keine, ohne Angabe (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "religion_sonstige", precision=10, scale=1)
    private BigDecimal religionSonstige;

    /**
     * Zensus 2011, Wohnungen in Wohngebäuden am 09.05.2011 - Eigentümerquote
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "wohnungen_eigentuemerquote", precision=10, scale=1)
    private BigDecimal wohnungenEigentuemerquote;

    /**
     * Bautätigkeit und Wohnungswesen - Fertiggestellte Wohnungen 2014 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "wohnungen_fertiggestellte", precision=10, scale=1)
    private BigDecimal wohnungenFertiggestellte;

    /**
     * Bautätigkeit und Wohnungswesen - Bestand an Wohnungen am 31.12.2015 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "wohnungen_bestand", precision=10, scale=1)
    private BigDecimal wohnungenBestand;

    /**
     * Verfügbares Einkommen der privaten Haushalte 2014 (€ je Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "einwohner_einkommen", precision=10, scale=1)
    private BigDecimal einwohnerEinkommen;

    /**
     * Bruttoinlandsprodukt 2014 (€ je Einwohner)
     */
    @Column(name = "einwohner_bruttoinlandsprodukt")
    private Long einwohnerBruttoinlandsprodukt;

    /**
     * Kraftfahrzeugbestand am 01.01.2016 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "einwohner_kraftfahrzeugbestand", precision=10, scale=1)
    private BigDecimal einwohnerKraftfahrzeugbestand;

    /**
     * Absolventen/Abgänger beruflicher Schulen 2015;
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_berufliche_schulen", precision=10, scale=1)
    private BigDecimal absolventenBeruflicheSchulen;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - insgesamt ohne Externe (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_allgemeinbildende_schulen_insgesamt", precision=10, scale=1)
    private BigDecimal absolventenAllgemeinbildendeSchulenInsgesamt;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - ohne Hauptschulabschluss (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_hauptschulabschluss_ohne", precision=10, scale=1)
    private BigDecimal absolventenHauptschulabschlussOhne;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit Hauptschulabschluss (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_hauptschulabschluss_mit", precision=10, scale=1)
    private BigDecimal absolventenHauptschulabschlussMit;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit mittlerem Schulabschluss (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_realschule", precision=10, scale=1)
    private BigDecimal absolventenRealschule;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit allgemeiner und Fachhochschulreife (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_abitur", precision=10, scale=1)
    private BigDecimal absolventenAbitur;

    /**
     * Kindertagesbetreuung: Betreute Kinder am 01.03.2016 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "kitas_betreute_kinder", precision=10, scale=1)
    private BigDecimal kitasBetreuteKinder;

    /**
     * Unternehmensregister 2014 - Unternehmen insgesamt (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "unternehmen_insgesamt", precision=10, scale=1)
    private BigDecimal unternehmenInsgesamt;

    /**
     * Unternehmensregister 2014 - Handwerksunternehmen (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "unternehmen_handwerk", precision=10, scale=1)
    private BigDecimal unternehmenHandwerk;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - insgesamt (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_insgesamt", precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteInsgesamt;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Land- und Forstwirtschaft, Fischerei (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_landwirtschaft", precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteLandwirtschaft;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Produzierendes Gewerbe (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_produzierendes_gewerbe", precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteProduzierendesGewerbe;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Handel, Gastgewerbe, Verkehr (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_handel", precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteHandel;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Öffentliche und private Dienstleister (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_dienstleister", precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteDienstleister;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Übrige Dienstleister und 'ohne Angabe' (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_sonstige", precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteSonstige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 -  insgesamt (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sgb2_insgesamt", precision=10, scale=1)
    private BigDecimal sgb2insgesamt;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - nicht erwerbsfähige Hilfebedürftige (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sgb2_erwerbsunfaehige", precision=10, scale=1)
    private BigDecimal sgb2erwerbsunfaehige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - Ausländer (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sgb2_auslaender", precision=10, scale=1)
    private BigDecimal sgb2auslaender;

    /**
     * Arbeitslosenquote März 2017 - insgesamt
     */

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_insgesamt", precision=10, scale=1)
    private BigDecimal arbeitslosenquoteInsgesamt;

    /**
     * Arbeitslosenquote März 2017 - Männer
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_maenner", precision=10, scale=1)
    private BigDecimal arbeitslosenquoteMaenner;

    /**
     * Arbeitslosenquote März 2017 - Frauen
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_frauen", precision=10, scale=1)
    private BigDecimal arbeitslosenquoteFrauen;

    /**
     * Arbeitslosenquote März 2017 - 15 bis unter 20 Jahre
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_12bis20", precision=10, scale=1)
    private BigDecimal arbeitslosenquote12bis20;

    /**
     * Arbeitslosenquote März 2017 - 55 bis unter 65 Jahre
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_55bis65", precision=10, scale=1)
    private BigDecimal arbeitslosenquote55bis65;

    /**
     * Fußnoten
     */
    @Column(name = "fussnoten")
    private String fussnoten;

    public Long getAnzahlGemeinden() {
        return anzahlGemeinden;
    }

    public void setAnzahlGemeinden(Long anzahlGemeinden) {
        this.anzahlGemeinden = anzahlGemeinden;
    }

    public BigDecimal getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(BigDecimal flaeche) {
        this.flaeche = flaeche;
    }

    public BigDecimal getBevoelkerungInsgesamt() {
        return bevoelkerungInsgesamt;
    }

    public void setBevoelkerungInsgesamt(BigDecimal bevoelkerungInsgesamt) {
        this.bevoelkerungInsgesamt = bevoelkerungInsgesamt;
    }

    public BigDecimal getBevoelkerungDeutsche() {
        return bevoelkerungDeutsche;
    }

    public void setBevoelkerungDeutsche(BigDecimal bevoelkerungDeutsche) {
        this.bevoelkerungDeutsche = bevoelkerungDeutsche;
    }

    public BigDecimal getBevoelkerungAuslaender() {
        return bevoelkerungAuslaender;
    }

    public void setBevoelkerungAuslaender(BigDecimal bevoelkerungAuslaender) {
        this.bevoelkerungAuslaender = bevoelkerungAuslaender;
    }

    public BigDecimal getBevoelkerungsDichte() {
        return bevoelkerungsDichte;
    }

    public void setBevoelkerungsDichte(BigDecimal bevoelkerungsDichte) {
        this.bevoelkerungsDichte = bevoelkerungsDichte;
    }

    public BigDecimal getBevoelkerungsGeburtensaldo() {
        return bevoelkerungsGeburtensaldo;
    }

    public void setBevoelkerungsGeburtensaldo(BigDecimal bevoelkerungsGeburtensaldo) {
        this.bevoelkerungsGeburtensaldo = bevoelkerungsGeburtensaldo;
    }

    public BigDecimal getBevoelkerungWanderungssaldo() {
        return bevoelkerungWanderungssaldo;
    }

    public void setBevoelkerungWanderungssaldo(BigDecimal bevoelkerungWanderungssaldo) {
        this.bevoelkerungWanderungssaldo = bevoelkerungWanderungssaldo;
    }

    public BigDecimal getAlterUnter18() {
        return alterUnter18;
    }

    public void setAlterUnter18(BigDecimal alterUnter18) {
        this.alterUnter18 = alterUnter18;
    }

    public BigDecimal getAlter18bis24() {
        return alter18bis24;
    }

    public void setAlter18bis24(BigDecimal alter18bis24) {
        this.alter18bis24 = alter18bis24;
    }

    public BigDecimal getAlter25bis34() {
        return alter25bis34;
    }

    public void setAlter25bis34(BigDecimal alter25bis34) {
        this.alter25bis34 = alter25bis34;
    }

    public BigDecimal getAlter35bis59() {
        return alter35bis59;
    }

    public void setAlter35bis59(BigDecimal alter35bis59) {
        this.alter35bis59 = alter35bis59;
    }

    public BigDecimal getAlter60bis74() {
        return alter60bis74;
    }

    public void setAlter60bis74(BigDecimal alter60bis74) {
        this.alter60bis74 = alter60bis74;
    }

    public BigDecimal getAlter75plus() {
        return alter75plus;
    }

    public void setAlter75plus(BigDecimal alter75plus) {
        this.alter75plus = alter75plus;
    }

    public BigDecimal getMigrationshintergrundOhne() {
        return migrationshintergrundOhne;
    }

    public void setMigrationshintergrundOhne(BigDecimal migrationshintergrundOhne) {
        this.migrationshintergrundOhne = migrationshintergrundOhne;
    }

    public BigDecimal getMigrationshintergrundMit() {
        return migrationshintergrundMit;
    }

    public void setMigrationshintergrundMit(BigDecimal migrationshintergrundMit) {
        this.migrationshintergrundMit = migrationshintergrundMit;
    }

    public BigDecimal getReligionKatholischeKirche() {
        return religionKatholischeKirche;
    }

    public void setReligionKatholischeKirche(BigDecimal religionKatholischeKirche) {
        this.religionKatholischeKirche = religionKatholischeKirche;
    }

    public BigDecimal getReligionEvangelischeKirche() {
        return religionEvangelischeKirche;
    }

    public void setReligionEvangelischeKirche(BigDecimal religionEvangelischeKirche) {
        this.religionEvangelischeKirche = religionEvangelischeKirche;
    }

    public BigDecimal getReligionSonstige() {
        return religionSonstige;
    }

    public void setReligionSonstige(BigDecimal religionSonstige) {
        this.religionSonstige = religionSonstige;
    }

    public BigDecimal getWohnungenEigentuemerquote() {
        return wohnungenEigentuemerquote;
    }

    public void setWohnungenEigentuemerquote(BigDecimal wohnungenEigentuemerquote) {
        this.wohnungenEigentuemerquote = wohnungenEigentuemerquote;
    }

    public BigDecimal getWohnungenFertiggestellte() {
        return wohnungenFertiggestellte;
    }

    public void setWohnungenFertiggestellte(BigDecimal wohnungenFertiggestellte) {
        this.wohnungenFertiggestellte = wohnungenFertiggestellte;
    }

    public BigDecimal getWohnungenBestand() {
        return wohnungenBestand;
    }

    public void setWohnungenBestand(BigDecimal wohnungenBestand) {
        this.wohnungenBestand = wohnungenBestand;
    }

    public BigDecimal getEinwohnerEinkommen() {
        return einwohnerEinkommen;
    }

    public void setEinwohnerEinkommen(BigDecimal einwohnerEinkommen) {
        this.einwohnerEinkommen = einwohnerEinkommen;
    }

    public Long getEinwohnerBruttoinlandsprodukt() {
        return einwohnerBruttoinlandsprodukt;
    }

    public void setEinwohnerBruttoinlandsprodukt(Long einwohnerBruttoinlandsprodukt) {
        this.einwohnerBruttoinlandsprodukt = einwohnerBruttoinlandsprodukt;
    }

    public BigDecimal getEinwohnerKraftfahrzeugbestand() {
        return einwohnerKraftfahrzeugbestand;
    }

    public void setEinwohnerKraftfahrzeugbestand(BigDecimal einwohnerKraftfahrzeugbestand) {
        this.einwohnerKraftfahrzeugbestand = einwohnerKraftfahrzeugbestand;
    }

    public BigDecimal getAbsolventenBeruflicheSchulen() {
        return absolventenBeruflicheSchulen;
    }

    public void setAbsolventenBeruflicheSchulen(BigDecimal absolventenBeruflicheSchulen) {
        this.absolventenBeruflicheSchulen = absolventenBeruflicheSchulen;
    }

    public BigDecimal getAbsolventenAllgemeinbildendeSchulenInsgesamt() {
        return absolventenAllgemeinbildendeSchulenInsgesamt;
    }

    public void setAbsolventenAllgemeinbildendeSchulenInsgesamt(BigDecimal absolventenAllgemeinbildendeSchulenInsgesamt) {
        this.absolventenAllgemeinbildendeSchulenInsgesamt = absolventenAllgemeinbildendeSchulenInsgesamt;
    }

    public BigDecimal getAbsolventenHauptschulabschlussOhne() {
        return absolventenHauptschulabschlussOhne;
    }

    public void setAbsolventenHauptschulabschlussOhne(BigDecimal absolventenHauptschulabschlussOhne) {
        this.absolventenHauptschulabschlussOhne = absolventenHauptschulabschlussOhne;
    }

    public BigDecimal getAbsolventenHauptschulabschlussMit() {
        return absolventenHauptschulabschlussMit;
    }

    public void setAbsolventenHauptschulabschlussMit(BigDecimal absolventenHauptschulabschlussMit) {
        this.absolventenHauptschulabschlussMit = absolventenHauptschulabschlussMit;
    }

    public BigDecimal getAbsolventenRealschule() {
        return absolventenRealschule;
    }

    public void setAbsolventenRealschule(BigDecimal absolventenRealschule) {
        this.absolventenRealschule = absolventenRealschule;
    }

    public BigDecimal getAbsolventenAbitur() {
        return absolventenAbitur;
    }

    public void setAbsolventenAbitur(BigDecimal absolventenAbitur) {
        this.absolventenAbitur = absolventenAbitur;
    }

    public BigDecimal getKitasBetreuteKinder() {
        return kitasBetreuteKinder;
    }

    public void setKitasBetreuteKinder(BigDecimal kitasBetreuteKinder) {
        this.kitasBetreuteKinder = kitasBetreuteKinder;
    }

    public BigDecimal getUnternehmenInsgesamt() {
        return unternehmenInsgesamt;
    }

    public void setUnternehmenInsgesamt(BigDecimal unternehmenInsgesamt) {
        this.unternehmenInsgesamt = unternehmenInsgesamt;
    }

    public BigDecimal getUnternehmenHandwerk() {
        return unternehmenHandwerk;
    }

    public void setUnternehmenHandwerk(BigDecimal unternehmenHandwerk) {
        this.unternehmenHandwerk = unternehmenHandwerk;
    }

    public BigDecimal getSozialversicherungBeschaeftigteInsgesamt() {
        return sozialversicherungBeschaeftigteInsgesamt;
    }

    public void setSozialversicherungBeschaeftigteInsgesamt(BigDecimal sozialversicherungBeschaeftigteInsgesamt) {
        this.sozialversicherungBeschaeftigteInsgesamt = sozialversicherungBeschaeftigteInsgesamt;
    }

    public BigDecimal getSozialversicherungBeschaeftigteLandwirtschaft() {
        return sozialversicherungBeschaeftigteLandwirtschaft;
    }

    public void setSozialversicherungBeschaeftigteLandwirtschaft(BigDecimal sozialversicherungBeschaeftigteLandwirtschaft) {
        this.sozialversicherungBeschaeftigteLandwirtschaft = sozialversicherungBeschaeftigteLandwirtschaft;
    }

    public BigDecimal getSozialversicherungBeschaeftigteProduzierendesGewerbe() {
        return sozialversicherungBeschaeftigteProduzierendesGewerbe;
    }

    public void setSozialversicherungBeschaeftigteProduzierendesGewerbe(BigDecimal sozialversicherungBeschaeftigteProduzierendesGewerbe) {
        this.sozialversicherungBeschaeftigteProduzierendesGewerbe = sozialversicherungBeschaeftigteProduzierendesGewerbe;
    }

    public BigDecimal getSozialversicherungBeschaeftigteHandel() {
        return sozialversicherungBeschaeftigteHandel;
    }

    public void setSozialversicherungBeschaeftigteHandel(BigDecimal sozialversicherungBeschaeftigteHandel) {
        this.sozialversicherungBeschaeftigteHandel = sozialversicherungBeschaeftigteHandel;
    }

    public BigDecimal getSozialversicherungBeschaeftigteDienstleister() {
        return sozialversicherungBeschaeftigteDienstleister;
    }

    public void setSozialversicherungBeschaeftigteDienstleister(BigDecimal sozialversicherungBeschaeftigteDienstleister) {
        this.sozialversicherungBeschaeftigteDienstleister = sozialversicherungBeschaeftigteDienstleister;
    }

    public BigDecimal getSozialversicherungBeschaeftigteSonstige() {
        return sozialversicherungBeschaeftigteSonstige;
    }

    public void setSozialversicherungBeschaeftigteSonstige(BigDecimal sozialversicherungBeschaeftigteSonstige) {
        this.sozialversicherungBeschaeftigteSonstige = sozialversicherungBeschaeftigteSonstige;
    }

    public BigDecimal getSgb2insgesamt() {
        return sgb2insgesamt;
    }

    public void setSgb2insgesamt(BigDecimal sgb2insgesamt) {
        this.sgb2insgesamt = sgb2insgesamt;
    }

    public BigDecimal getSgb2erwerbsunfaehige() {
        return sgb2erwerbsunfaehige;
    }

    public void setSgb2erwerbsunfaehige(BigDecimal sgb2erwerbsunfaehige) {
        this.sgb2erwerbsunfaehige = sgb2erwerbsunfaehige;
    }

    public BigDecimal getSgb2auslaender() {
        return sgb2auslaender;
    }

    public void setSgb2auslaender(BigDecimal sgb2auslaender) {
        this.sgb2auslaender = sgb2auslaender;
    }

    public BigDecimal getArbeitslosenquoteInsgesamt() {
        return arbeitslosenquoteInsgesamt;
    }

    public void setArbeitslosenquoteInsgesamt(BigDecimal arbeitslosenquoteInsgesamt) {
        this.arbeitslosenquoteInsgesamt = arbeitslosenquoteInsgesamt;
    }

    public BigDecimal getArbeitslosenquoteMaenner() {
        return arbeitslosenquoteMaenner;
    }

    public void setArbeitslosenquoteMaenner(BigDecimal arbeitslosenquoteMaenner) {
        this.arbeitslosenquoteMaenner = arbeitslosenquoteMaenner;
    }

    public BigDecimal getArbeitslosenquoteFrauen() {
        return arbeitslosenquoteFrauen;
    }

    public void setArbeitslosenquoteFrauen(BigDecimal arbeitslosenquoteFrauen) {
        this.arbeitslosenquoteFrauen = arbeitslosenquoteFrauen;
    }

    public BigDecimal getArbeitslosenquote12bis20() {
        return arbeitslosenquote12bis20;
    }

    public void setArbeitslosenquote12bis20(BigDecimal arbeitslosenquote12bis20) {
        this.arbeitslosenquote12bis20 = arbeitslosenquote12bis20;
    }

    public BigDecimal getArbeitslosenquote55bis65() {
        return arbeitslosenquote55bis65;
    }

    public void setArbeitslosenquote55bis65(BigDecimal arbeitslosenquote55bis65) {
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
        if (!(o instanceof Strukturdaten)) return false;

        Strukturdaten that = (Strukturdaten) o;

        if (anzahlGemeinden != null ? !anzahlGemeinden.equals(that.anzahlGemeinden) : that.anzahlGemeinden != null)
            return false;
        if (flaeche != null ? !flaeche.equals(that.flaeche) : that.flaeche != null) return false;
        if (bevoelkerungInsgesamt != null ? !bevoelkerungInsgesamt.equals(that.bevoelkerungInsgesamt) : that.bevoelkerungInsgesamt != null)
            return false;
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
        int result = anzahlGemeinden != null ? anzahlGemeinden.hashCode() : 0;
        result = 31 * result + (flaeche != null ? flaeche.hashCode() : 0);
        result = 31 * result + (bevoelkerungInsgesamt != null ? bevoelkerungInsgesamt.hashCode() : 0);
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
        return "Strukturdaten{" +
                "anzahlGemeinden=" + anzahlGemeinden +
                ", flaeche=" + flaeche +
                ", bevoelkerungInsgesamt=" + bevoelkerungInsgesamt +
                ", bevoelkerungDeutsche=" + bevoelkerungDeutsche +
                ", bevoelkerungAuslaender=" + bevoelkerungAuslaender +
                ", bevoelkerungsDichte=" + bevoelkerungsDichte +
                ", bevoelkerungsGeburtensaldo=" + bevoelkerungsGeburtensaldo +
                ", bevoelkerungWanderungssaldo=" + bevoelkerungWanderungssaldo +
                ", alterUnter18=" + alterUnter18 +
                ", alter18bis24=" + alter18bis24 +
                ", alter25bis34=" + alter25bis34 +
                ", alter35bis59=" + alter35bis59 +
                ", alter60bis74=" + alter60bis74 +
                ", alter75plus=" + alter75plus +
                ", migrationshintergrundOhne=" + migrationshintergrundOhne +
                ", migrationshintergrundMit=" + migrationshintergrundMit +
                ", religionKatholischeKirche=" + religionKatholischeKirche +
                ", religionEvangelischeKirche=" + religionEvangelischeKirche +
                ", religionSonstige=" + religionSonstige +
                ", wohnungenEigentuemerquote=" + wohnungenEigentuemerquote +
                ", wohnungenFertiggestellte=" + wohnungenFertiggestellte +
                ", wohnungenBestand=" + wohnungenBestand +
                ", einwohnerEinkommen=" + einwohnerEinkommen +
                ", einwohnerBruttoinlandsprodukt=" + einwohnerBruttoinlandsprodukt +
                ", einwohnerKraftfahrzeugbestand=" + einwohnerKraftfahrzeugbestand +
                ", absolventenBeruflicheSchulen=" + absolventenBeruflicheSchulen +
                ", absolventenAllgemeinbildendeSchulenInsgesamt=" + absolventenAllgemeinbildendeSchulenInsgesamt +
                ", absolventenHauptschulabschlussOhne=" + absolventenHauptschulabschlussOhne +
                ", absolventenHauptschulabschlussMit=" + absolventenHauptschulabschlussMit +
                ", absolventenRealschule=" + absolventenRealschule +
                ", absolventenAbitur=" + absolventenAbitur +
                ", kitasBetreuteKinder=" + kitasBetreuteKinder +
                ", unternehmenInsgesamt=" + unternehmenInsgesamt +
                ", unternehmenHandwerk=" + unternehmenHandwerk +
                ", sozialversicherungBeschaeftigteInsgesamt=" + sozialversicherungBeschaeftigteInsgesamt +
                ", sozialversicherungBeschaeftigteLandwirtschaft=" + sozialversicherungBeschaeftigteLandwirtschaft +
                ", sozialversicherungBeschaeftigteProduzierendesGewerbe=" + sozialversicherungBeschaeftigteProduzierendesGewerbe +
                ", sozialversicherungBeschaeftigteHandel=" + sozialversicherungBeschaeftigteHandel +
                ", sozialversicherungBeschaeftigteDienstleister=" + sozialversicherungBeschaeftigteDienstleister +
                ", sozialversicherungBeschaeftigteSonstige=" + sozialversicherungBeschaeftigteSonstige +
                ", sgb2insgesamt=" + sgb2insgesamt +
                ", sgb2erwerbsunfaehige=" + sgb2erwerbsunfaehige +
                ", sgb2auslaender=" + sgb2auslaender +
                ", arbeitslosenquoteInsgesamt=" + arbeitslosenquoteInsgesamt +
                ", arbeitslosenquoteMaenner=" + arbeitslosenquoteMaenner +
                ", arbeitslosenquoteFrauen=" + arbeitslosenquoteFrauen +
                ", arbeitslosenquote12bis20=" + arbeitslosenquote12bis20 +
                ", arbeitslosenquote55bis65=" + arbeitslosenquote55bis65 +
                ", fussnoten='" + fussnoten + '\'' +
                '}';
    }
}
