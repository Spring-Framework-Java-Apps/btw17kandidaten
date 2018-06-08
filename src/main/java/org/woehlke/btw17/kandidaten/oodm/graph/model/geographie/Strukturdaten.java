package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;


//TODO: Abgrenzung zu den Objekten in btw17
@NodeEntity
public class Strukturdaten extends GraphDomainObjectImpl implements GraphDomainObject {

    /**
     * Gemeinden am 31.12.2015 (Anzahl)
     */
    @Property(name = "anzahl_gemeinden")
    private Long anzahlGemeinden;

    /**
     * Fläche am 31.12.2015 (km²)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "flaeche"/*, precision=10, scale=1*/)
    private String  flaeche;


    /**
     * Bevölkerung am 31.12.2015 - Insgesamt (in 1000)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_insgesamt"/*, precision=10, scale=1*/)
    private String  bevoelkerungInsgesamt;

    /**
     * Bevölkerung am 31.12.2015 - Deutsche (in 1000)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_deutsche"/*, precision=10, scale=1*/)
    private String  bevoelkerungDeutsche;

    /**
     * Bevölkerung am 31.12.2015 - Ausländer (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_auslaender"/*, precision=10, scale=1*/)
    private String  bevoelkerungAuslaender;

    /**
     * Bevölkerungsdichte am 31.12.2015 (Einwohner je km²)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_dichte"/*, precision=10, scale=1*/)
    private String  bevoelkerungsDichte;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Geburtensaldo (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_geburtensaldo"/*, precision=10, scale=1*/)
    private String  bevoelkerungsGeburtensaldo;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Wanderungssaldo (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_wanderungssaldo"/*, precision=10, scale=1*/)
    private String  bevoelkerungWanderungssaldo;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - unter 18 (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_unter18"/*, precision=10, scale=1*/)
    private String  alterUnter18;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 18-24 (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_18bis24"/*, precision=10, scale=1*/)
    private String  alter18bis24;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 25-34 (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_25bis34"/*, precision=10, scale=1*/)
    private String  alter25bis34;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 35-59 (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_35bis59"/*, precision=10, scale=1*/)
    private String  alter35bis59;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 60-74 (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_60bis74"/*, precision=10, scale=1*/)
    private String  alter60bis74;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 75 und mehr (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_75plus"/*, precision=10, scale=1*/)
    private String  alter75plus;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - ohne Migrationshintergrund (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "migrationshintergrund_ohne"/*, precision=10, scale=1*/)
    private String  migrationshintergrundOhne;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - mit Migrationshintergrund (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "migrationshintergrund_mit"/*, precision=10, scale=1*/)
    private String  migrationshintergrundMit;


    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Römisch-katholische Kirche (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "religion_katholisch"/*, precision=10, scale=1*/)
    private String  religionKatholischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Evangelische Kirche (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "religion_evangelisch"/*, precision=10, scale=1*/)
    private String  religionEvangelischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Sonstige, keine, ohne Angabe (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "religion_sonstige"/*, precision=10, scale=1*/)
    private String  religionSonstige;

    /**
     * Zensus 2011, Wohnungen in Wohngebäuden am 09.05.2011 - Eigentümerquote
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "wohnungen_eigentuemerquote"/*, precision=10, scale=1*/)
    private String  wohnungenEigentuemerquote;

    /**
     * Bautätigkeit und Wohnungswesen - Fertiggestellte Wohnungen 2014 (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "wohnungen_fertiggestellte"/*, precision=10, scale=1*/)
    private String  wohnungenFertiggestellte;

    /**
     * Bautätigkeit und Wohnungswesen - Bestand an Wohnungen am 31.12.2015 (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "wohnungen_bestand"/*, precision=10, scale=1*/)
    private String  wohnungenBestand;

    /**
     * Verfügbares Einkommen der privaten Haushalte 2014 (€ je Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "einwohner_einkommen"/*, precision=10, scale=1*/)
    private String  einwohnerEinkommen;

    /**
     * Bruttoinlandsprodukt 2014 (€ je Einwohner)
     */
    @Property(name = "einwohner_bruttoinlandsprodukt")
    private Long einwohnerBruttoinlandsprodukt;

    /**
     * Kraftfahrzeugbestand am 01.01.2016 (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "einwohner_kraftfahrzeugbestand"/*, precision=10, scale=1*/)
    private String  einwohnerKraftfahrzeugbestand;

    /**
     * Absolventen/Abgänger beruflicher Schulen 2015;
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_berufliche_schulen"/*, precision=10, scale=1*/)
    private String  absolventenBeruflicheSchulen;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - insgesamt ohne Externe (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_allgemeinbildende_schulen_insgesamt"/*, precision=10, scale=1*/)
    private String  absolventenAllgemeinbildendeSchulenInsgesamt;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - ohne Hauptschulabschluss (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_hauptschulabschluss_ohne"/*, precision=10, scale=1*/)
    private String  absolventenHauptschulabschlussOhne;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit Hauptschulabschluss (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_hauptschulabschluss_mit"/*, precision=10, scale=1*/)
    private String  absolventenHauptschulabschlussMit;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit mittlerem Schulabschluss (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_realschule"/*, precision=10, scale=1*/)
    private String  absolventenRealschule;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit allgemeiner und Fachhochschulreife (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_abitur"/*, precision=10, scale=1*/)
    private String  absolventenAbitur;

    /**
     * Kindertagesbetreuung: Betreute Kinder am 01.03.2016 (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "kitas_betreute_kinder"/*, precision=10, scale=1*/)
    private String  kitasBetreuteKinder;

    /**
     * Unternehmensregister 2014 - Unternehmen insgesamt (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "unternehmen_insgesamt"/*, precision=10, scale=1*/)
    private String  unternehmenInsgesamt;

    /**
     * Unternehmensregister 2014 - Handwerksunternehmen (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "unternehmen_handwerk"/*, precision=10, scale=1*/)
    private String  unternehmenHandwerk;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - insgesamt (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_insgesamt"/*, precision=10, scale=1*/)
    private String  sozialversicherungBeschaeftigteInsgesamt;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Land- und Forstwirtschaft, Fischerei (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_landwirtschaft"/*, precision=10, scale=1*/)
    private String  sozialversicherungBeschaeftigteLandwirtschaft;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Produzierendes Gewerbe (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_produzierendes_gewerbe"/*, precision=10, scale=1*/)
    private String  sozialversicherungBeschaeftigteProduzierendesGewerbe;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Handel, Gastgewerbe, Verkehr (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_handel"/*, precision=10, scale=1*/)
    private String  sozialversicherungBeschaeftigteHandel;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Öffentliche und private Dienstleister (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_dienstleister"/*, precision=10, scale=1*/)
    private String  sozialversicherungBeschaeftigteDienstleister;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Übrige Dienstleister und 'ohne Angabe' (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_sonstige"/*, precision=10, scale=1*/)
    private String  sozialversicherungBeschaeftigteSonstige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 -  insgesamt (je 1000 Einwohner)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sgb2_insgesamt"/*, precision=10, scale=1*/)
    private String  sgb2insgesamt;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - nicht erwerbsfähige Hilfebedürftige (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sgb2_erwerbsunfaehige"/*, precision=10, scale=1*/)
    private String  sgb2erwerbsunfaehige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - Ausländer (%)
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sgb2_auslaender"/*, precision=10, scale=1*/)
    private String  sgb2auslaender;

    /**
     * Arbeitslosenquote März 2017 - insgesamt
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_insgesamt"/*, precision=10, scale=1*/)
    private String  arbeitslosenquoteInsgesamt;

    /**
     * Arbeitslosenquote März 2017 - Männer
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_maenner"/*, precision=10, scale=1*/)
    private String  arbeitslosenquoteMaenner;

    /**
     * Arbeitslosenquote März 2017 - Frauen
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_frauen"/*, precision=10, scale=1*/)
    private String  arbeitslosenquoteFrauen;

    /**
     * Arbeitslosenquote März 2017 - 15 bis unter 20 Jahre
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_12bis20"/*, precision=10, scale=1*/)
    private String  arbeitslosenquote12bis20;

    /**
     * Arbeitslosenquote März 2017 - 55 bis unter 65 Jahre
     */
    //@Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_55bis65"/*, precision=10, scale=1*/)
    private String  arbeitslosenquote55bis65;

    /**
     * Fußnoten
     */
    @Property(name = "fussnoten")
    private String fussnoten;

    public Strukturdaten() {
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

    public String getBevoelkerungInsgesamt() {
        return bevoelkerungInsgesamt;
    }

    public void setBevoelkerungInsgesamt(String bevoelkerungInsgesamt) {
        this.bevoelkerungInsgesamt = bevoelkerungInsgesamt;
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

    public Long getEinwohnerBruttoinlandsprodukt() {
        return einwohnerBruttoinlandsprodukt;
    }

    public void setEinwohnerBruttoinlandsprodukt(Long einwohnerBruttoinlandsprodukt) {
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
}
