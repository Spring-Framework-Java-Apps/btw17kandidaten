package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;


//TODO: Abgrenzung zu den Objekten in btw17
@Setter
@Getter
@NodeEntity
public class Strukturdaten implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Gemeinden am 31.12.2015 (Anzahl)
     */
    @Property(name = "anzahl_gemeinden")
    private Long anzahlGemeinden;

    /**
     * Fläche am 31.12.2015 (km²)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "flaeche"/*, precision=10, scale=1*/)
    private BigDecimal flaeche;


    /**
     * Bevölkerung am 31.12.2015 - Insgesamt (in 1000)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_insgesamt"/*, precision=10, scale=1*/)
    private BigDecimal bevoelkerungInsgesamt;

    /**
     * Bevölkerung am 31.12.2015 - Deutsche (in 1000)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_deutsche"/*, precision=10, scale=1*/)
    private BigDecimal bevoelkerungDeutsche;

    /**
     * Bevölkerung am 31.12.2015 - Ausländer (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_auslaender"/*, precision=10, scale=1*/)
    private BigDecimal bevoelkerungAuslaender;

    /**
     * Bevölkerungsdichte am 31.12.2015 (Einwohner je km²)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_dichte"/*, precision=10, scale=1*/)
    private BigDecimal bevoelkerungsDichte;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Geburtensaldo (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_geburtensaldo"/*, precision=10, scale=1*/)
    private BigDecimal bevoelkerungsGeburtensaldo;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Wanderungssaldo (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "bevoelkerung_wanderungssaldo"/*, precision=10, scale=1*/)
    private BigDecimal bevoelkerungWanderungssaldo;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - unter 18 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_unter18"/*, precision=10, scale=1*/)
    private BigDecimal alterUnter18;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 18-24 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_18bis24"/*, precision=10, scale=1*/)
    private BigDecimal alter18bis24;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 25-34 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_25bis34"/*, precision=10, scale=1*/)
    private BigDecimal alter25bis34;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 35-59 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_35bis59"/*, precision=10, scale=1*/)
    private BigDecimal alter35bis59;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 60-74 (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_60bis74"/*, precision=10, scale=1*/)
    private BigDecimal alter60bis74;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 75 und mehr (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "alter_75plus"/*, precision=10, scale=1*/)
    private BigDecimal alter75plus;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - ohne Migrationshintergrund (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "migrationshintergrund_ohne"/*, precision=10, scale=1*/)
    private BigDecimal migrationshintergrundOhne;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - mit Migrationshintergrund (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "migrationshintergrund_mit"/*, precision=10, scale=1*/)
    private BigDecimal migrationshintergrundMit;


    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Römisch-katholische Kirche (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "religion_katholisch"/*, precision=10, scale=1*/)
    private BigDecimal religionKatholischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Evangelische Kirche (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "religion_evangelisch"/*, precision=10, scale=1*/)
    private BigDecimal religionEvangelischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Sonstige, keine, ohne Angabe (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "religion_sonstige"/*, precision=10, scale=1*/)
    private BigDecimal religionSonstige;

    /**
     * Zensus 2011, Wohnungen in Wohngebäuden am 09.05.2011 - Eigentümerquote
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "wohnungen_eigentuemerquote"/*, precision=10, scale=1*/)
    private BigDecimal wohnungenEigentuemerquote;

    /**
     * Bautätigkeit und Wohnungswesen - Fertiggestellte Wohnungen 2014 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "wohnungen_fertiggestellte"/*, precision=10, scale=1*/)
    private BigDecimal wohnungenFertiggestellte;

    /**
     * Bautätigkeit und Wohnungswesen - Bestand an Wohnungen am 31.12.2015 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "wohnungen_bestand"/*, precision=10, scale=1*/)
    private BigDecimal wohnungenBestand;

    /**
     * Verfügbares Einkommen der privaten Haushalte 2014 (€ je Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "einwohner_einkommen"/*, precision=10, scale=1*/)
    private BigDecimal einwohnerEinkommen;

    /**
     * Bruttoinlandsprodukt 2014 (€ je Einwohner)
     */
    @Property(name = "einwohner_bruttoinlandsprodukt")
    private Long einwohnerBruttoinlandsprodukt;

    /**
     * Kraftfahrzeugbestand am 01.01.2016 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "einwohner_kraftfahrzeugbestand"/*, precision=10, scale=1*/)
    private BigDecimal einwohnerKraftfahrzeugbestand;

    /**
     * Absolventen/Abgänger beruflicher Schulen 2015;
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_berufliche_schulen"/*, precision=10, scale=1*/)
    private BigDecimal absolventenBeruflicheSchulen;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - insgesamt ohne Externe (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_allgemeinbildende_schulen_insgesamt"/*, precision=10, scale=1*/)
    private BigDecimal absolventenAllgemeinbildendeSchulenInsgesamt;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - ohne Hauptschulabschluss (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_hauptschulabschluss_ohne"/*, precision=10, scale=1*/)
    private BigDecimal absolventenHauptschulabschlussOhne;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit Hauptschulabschluss (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_hauptschulabschluss_mit"/*, precision=10, scale=1*/)
    private BigDecimal absolventenHauptschulabschlussMit;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit mittlerem Schulabschluss (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_realschule"/*, precision=10, scale=1*/)
    private BigDecimal absolventenRealschule;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit allgemeiner und Fachhochschulreife (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "absolventen_abitur"/*, precision=10, scale=1*/)
    private BigDecimal absolventenAbitur;

    /**
     * Kindertagesbetreuung: Betreute Kinder am 01.03.2016 (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "kitas_betreute_kinder"/*, precision=10, scale=1*/)
    private BigDecimal kitasBetreuteKinder;

    /**
     * Unternehmensregister 2014 - Unternehmen insgesamt (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "unternehmen_insgesamt"/*, precision=10, scale=1*/)
    private BigDecimal unternehmenInsgesamt;

    /**
     * Unternehmensregister 2014 - Handwerksunternehmen (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "unternehmen_handwerk"/*, precision=10, scale=1*/)
    private BigDecimal unternehmenHandwerk;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - insgesamt (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_insgesamt"/*, precision=10, scale=1*/)
    private BigDecimal sozialversicherungBeschaeftigteInsgesamt;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Land- und Forstwirtschaft, Fischerei (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_landwirtschaft"/*, precision=10, scale=1*/)
    private BigDecimal sozialversicherungBeschaeftigteLandwirtschaft;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Produzierendes Gewerbe (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_produzierendes_gewerbe"/*, precision=10, scale=1*/)
    private BigDecimal sozialversicherungBeschaeftigteProduzierendesGewerbe;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Handel, Gastgewerbe, Verkehr (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_handel"/*, precision=10, scale=1*/)
    private BigDecimal sozialversicherungBeschaeftigteHandel;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Öffentliche und private Dienstleister (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_dienstleister"/*, precision=10, scale=1*/)
    private BigDecimal sozialversicherungBeschaeftigteDienstleister;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Übrige Dienstleister und 'ohne Angabe' (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sozialversicherung_beschaeftigte_sonstige"/*, precision=10, scale=1*/)
    private BigDecimal sozialversicherungBeschaeftigteSonstige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 -  insgesamt (je 1000 Einwohner)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sgb2_insgesamt"/*, precision=10, scale=1*/)
    private BigDecimal sgb2insgesamt;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - nicht erwerbsfähige Hilfebedürftige (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sgb2_erwerbsunfaehige"/*, precision=10, scale=1*/)
    private BigDecimal sgb2erwerbsunfaehige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - Ausländer (%)
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "sgb2_auslaender"/*, precision=10, scale=1*/)
    private BigDecimal sgb2auslaender;

    /**
     * Arbeitslosenquote März 2017 - insgesamt
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_insgesamt"/*, precision=10, scale=1*/)
    private BigDecimal arbeitslosenquoteInsgesamt;

    /**
     * Arbeitslosenquote März 2017 - Männer
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_maenner"/*, precision=10, scale=1*/)
    private BigDecimal arbeitslosenquoteMaenner;

    /**
     * Arbeitslosenquote März 2017 - Frauen
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_frauen"/*, precision=10, scale=1*/)
    private BigDecimal arbeitslosenquoteFrauen;

    /**
     * Arbeitslosenquote März 2017 - 15 bis unter 20 Jahre
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_12bis20"/*, precision=10, scale=1*/)
    private BigDecimal arbeitslosenquote12bis20;

    /**
     * Arbeitslosenquote März 2017 - 55 bis unter 65 Jahre
     */
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Property(name = "arbeitslosenquote_55bis65"/*, precision=10, scale=1*/)
    private BigDecimal arbeitslosenquote55bis65;

    /**
     * Fußnoten
     */
    @Property(name = "fussnoten")
    private String fussnoten;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return "name"+id;
    }

    @Override
    public String getUniqueId() {
        return  "UniqueId"+id;
    }
}