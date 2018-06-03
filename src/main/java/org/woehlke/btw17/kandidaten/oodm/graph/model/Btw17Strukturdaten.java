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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Setter
@Getter
@NodeEntity
public class Btw17Strukturdaten implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;



    /**
     * Land
     */
    @NotNull
    @Column(name = "bundesland_name", nullable=false)
    private String bundeslandName;

    /**
     * Land
     */
    @Column(name = "bundesland_id")
    private Long bundeslandId;

    /**
     * Land
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "bundesland_kurz")
    private BundeslandEnum bundesland;

    /**
     * Wahlkreis-Nr.
     */
    @NotNull
    @Column(name = "wahlkreis_nummer", nullable=false, unique = true)
    private Long wahlkreisNummer;

    /**
     * Wahlkreis-Name
     */
    @NotNull
    @Column(name = "wahlkreis_name", nullable=false)
    private String wahlkreisName;

    /**
     * Gemeinden am 31.12.2015 (Anzahl)
     */
    @NotNull
    @Column(name = "anzahl_gemeinden", nullable=false)
    private Long anzahlGemeinden;

    /**
     * Fläche am 31.12.2015 (km²)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "flaeche", nullable=false, precision=10, scale=1)
    private BigDecimal flaeche;


    /**
     * Bevölkerung am 31.12.2015 - Insgesamt (in 1000)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_insgesamt", nullable=false, precision=10, scale=1)
    private BigDecimal bevoelkerungInsgesamt;

    /**
     * Bevölkerung am 31.12.2015 - Deutsche (in 1000)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_deutsche", nullable=false, precision=10, scale=1)
    private BigDecimal bevoelkerungDeutsche;

    /**
     * Bevölkerung am 31.12.2015 - Ausländer (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_auslaender", nullable=false, precision=10, scale=1)
    private BigDecimal bevoelkerungAuslaender;

    /**
     * Bevölkerungsdichte am 31.12.2015 (Einwohner je km²)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_dichte", nullable=false, precision=10, scale=1)
    private BigDecimal bevoelkerungsDichte;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Geburtensaldo (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_geburtensaldo", nullable=false, precision=10, scale=1)
    private BigDecimal bevoelkerungsGeburtensaldo;

    /**
     * Zu- (+) bzw. Abnahme (-) der Bevölkerung 2015 - Wanderungssaldo (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bevoelkerung_wanderungssaldo", nullable=false, precision=10, scale=1)
    private BigDecimal bevoelkerungWanderungssaldo;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - unter 18 (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_unter18", nullable=false, precision=10, scale=1)
    private BigDecimal alterUnter18;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 18-24 (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_18bis24", nullable=false, precision=10, scale=1)
    private BigDecimal alter18bis24;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 25-34 (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_25bis34", nullable=false, precision=10, scale=1)
    private BigDecimal alter25bis34;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 35-59 (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_35bis59", nullable=false, precision=10, scale=1)
    private BigDecimal alter35bis59;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 60-74 (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_60bis74", nullable=false, precision=10, scale=1)
    private BigDecimal alter60bis74;

    /**
     * Alter von ... bis ... Jahren am 31.12.2015 - 75 und mehr (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "alter_75plus", nullable=false, precision=10, scale=1)
    private BigDecimal alter75plus;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - ohne Migrationshintergrund (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "migrationshintergrund_ohne", nullable=false, precision=10, scale=1)
    private BigDecimal migrationshintergrundOhne;

    /**
     * Zensus 2011, Bevölkerung nach Migrationshintergrund am 09.05.2011 - mit Migrationshintergrund (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "migrationshintergrund_mit", nullable=false, precision=10, scale=1)
    private BigDecimal migrationshintergrundMit;


    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Römisch-katholische Kirche (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "religion_katholisch", nullable=false, precision=10, scale=1)
    private BigDecimal religionKatholischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Evangelische Kirche (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "religion_evangelisch", nullable=false, precision=10, scale=1)
    private BigDecimal religionEvangelischeKirche;

    /**
     * Zensus 2011, Bevölkerung nach Religionszugehörigkeit am 09.05.2011 - Sonstige, keine, ohne Angabe (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "religion_sonstige", nullable=false, precision=10, scale=1)
    private BigDecimal religionSonstige;

    /**
     * Zensus 2011, Wohnungen in Wohngebäuden am 09.05.2011 - Eigentümerquote
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "wohnungen_eigentuemerquote", nullable=false, precision=10, scale=1)
    private BigDecimal wohnungenEigentuemerquote;

    /**
     * Bautätigkeit und Wohnungswesen - Fertiggestellte Wohnungen 2014 (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "wohnungen_fertiggestellte", nullable=false, precision=10, scale=1)
    private BigDecimal wohnungenFertiggestellte;

    /**
     * Bautätigkeit und Wohnungswesen - Bestand an Wohnungen am 31.12.2015 (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "wohnungen_bestand", nullable=false, precision=10, scale=1)
    private BigDecimal wohnungenBestand;

    /**
     * Verfügbares Einkommen der privaten Haushalte 2014 (€ je Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "einwohner_einkommen", nullable=false, precision=10, scale=1)
    private BigDecimal einwohnerEinkommen;

    /**
     * Bruttoinlandsprodukt 2014 (€ je Einwohner)
     */
    @NotNull
    @Column(name = "einwohner_bruttoinlandsprodukt", nullable=false)
    private Long einwohnerBruttoinlandsprodukt;

    /**
     * Kraftfahrzeugbestand am 01.01.2016 (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "einwohner_kraftfahrzeugbestand", nullable=false, precision=10, scale=1)
    private BigDecimal einwohnerKraftfahrzeugbestand;

    /**
     * Absolventen/Abgänger beruflicher Schulen 2015;
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_berufliche_schulen", nullable=false, precision=10, scale=1)
    private BigDecimal absolventenBeruflicheSchulen;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - insgesamt ohne Externe (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_allgemeinbildende_schulen_insgesamt", nullable=false, precision=10, scale=1)
    private BigDecimal absolventenAllgemeinbildendeSchulenInsgesamt;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - ohne Hauptschulabschluss (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_hauptschulabschluss_ohne", nullable=false, precision=10, scale=1)
    private BigDecimal absolventenHauptschulabschlussOhne;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit Hauptschulabschluss (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_hauptschulabschluss_mit", nullable=false, precision=10, scale=1)
    private BigDecimal absolventenHauptschulabschlussMit;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit mittlerem Schulabschluss (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_realschule", nullable=false, precision=10, scale=1)
    private BigDecimal absolventenRealschule;

    /**
     * Absolventen/Abgänger allgemeinbildender Schulen 2015 - mit allgemeiner und Fachhochschulreife (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "absolventen_abitur", nullable=false, precision=10, scale=1)
    private BigDecimal absolventenAbitur;

    /**
     * Kindertagesbetreuung: Betreute Kinder am 01.03.2016 (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "kitas_betreute_kinder", nullable=false, precision=10, scale=1)
    private BigDecimal kitasBetreuteKinder;

    /**
     * Unternehmensregister 2014 - Unternehmen insgesamt (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "unternehmen_insgesamt", nullable=false, precision=10, scale=1)
    private BigDecimal unternehmenInsgesamt;

    /**
     * Unternehmensregister 2014 - Handwerksunternehmen (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "unternehmen_handwerk", nullable=false, precision=10, scale=1)
    private BigDecimal unternehmenHandwerk;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - insgesamt (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_insgesamt", nullable=false, precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteInsgesamt;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Land- und Forstwirtschaft, Fischerei (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_landwirtschaft", nullable=false, precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteLandwirtschaft;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Produzierendes Gewerbe (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_produzierendes_gewerbe", nullable=false, precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteProduzierendesGewerbe;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Handel, Gastgewerbe, Verkehr (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_handel", nullable=false, precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteHandel;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Öffentliche und private Dienstleister (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_dienstleister", nullable=false, precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteDienstleister;

    /**
     * Sozialversicherungspflichtig Beschäftigte am 30.06.2016 - Übrige Dienstleister und 'ohne Angabe' (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sozialversicherung_beschaeftigte_sonstige", nullable=false, precision=10, scale=1)
    private BigDecimal sozialversicherungBeschaeftigteSonstige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 -  insgesamt (je 1000 Einwohner)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sgb2_insgesamt", nullable=false, precision=10, scale=1)
    private BigDecimal sgb2insgesamt;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - nicht erwerbsfähige Hilfebedürftige (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sgb2_erwerbsunfaehige", nullable=false, precision=10, scale=1)
    private BigDecimal sgb2erwerbsunfaehige;

    /**
     * Empfänger(innen) von Leistungen nach SGB II am 31.12.2016 - Ausländer (%)
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "sgb2_auslaender", nullable=false, precision=10, scale=1)
    private BigDecimal sgb2auslaender;

    /**
     * Arbeitslosenquote März 2017 - insgesamt
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_insgesamt", nullable=false, precision=10, scale=1)
    private BigDecimal arbeitslosenquoteInsgesamt;

    /**
     * Arbeitslosenquote März 2017 - Männer
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_maenner", nullable=false, precision=10, scale=1)
    private BigDecimal arbeitslosenquoteMaenner;

    /**
     * Arbeitslosenquote März 2017 - Frauen
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_frauen", nullable=false, precision=10, scale=1)
    private BigDecimal arbeitslosenquoteFrauen;

    /**
     * Arbeitslosenquote März 2017 - 15 bis unter 20 Jahre
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_12bis20", nullable=false, precision=10, scale=1)
    private BigDecimal arbeitslosenquote12bis20;

    /**
     * Arbeitslosenquote März 2017 - 55 bis unter 65 Jahre
     */
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "arbeitslosenquote_55bis65", nullable=false, precision=10, scale=1)
    private BigDecimal arbeitslosenquote55bis65;

    /**
     * Fußnoten
     */
    @NotNull
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
        return id+":"+bundeslandName+":"+wahlkreisNummer+":"+wahlkreisName+"+bundeslandId";
    }

}
