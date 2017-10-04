//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.10.04 um 03:06:03 PM CEST 
//


package org.woehlke.btw17.kandidaten.oodm.bundestag.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "geburtsdatum",
    "geburtsort",
    "geburtsland",
    "sterbedatum",
    "geschlecht",
    "familienstand",
    "religion",
    "beruf",
    "parteikurz",
    "vitakurz",
    "veroeffentlichungspflichtiges"
})
@XmlRootElement(name = "BIOGRAFISCHE_ANGABEN")
public class BIOGRAFISCHEANGABEN {

    @XmlElement(name = "GEBURTSDATUM")
    protected String geburtsdatum;
    @XmlElement(name = "GEBURTSORT")
    protected String geburtsort;
    @XmlElement(name = "GEBURTSLAND")
    protected String geburtsland;
    @XmlElement(name = "STERBEDATUM")
    protected String sterbedatum;
    @XmlElement(name = "GESCHLECHT")
    protected String geschlecht;
    @XmlElement(name = "FAMILIENSTAND")
    protected String familienstand;
    @XmlElement(name = "RELIGION")
    protected String religion;
    @XmlElement(name = "BERUF")
    protected String beruf;
    @XmlElement(name = "PARTEI_KURZ")
    protected String parteikurz;
    @XmlElement(name = "VITA_KURZ")
    protected String vitakurz;
    @XmlElement(name = "VEROEFFENTLICHUNGSPFLICHTIGES")
    protected String veroeffentlichungspflichtiges;

    /**
     * Ruft den Wert der geburtsdatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEBURTSDATUM() {
        return geburtsdatum;
    }

    /**
     * Legt den Wert der geburtsdatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEBURTSDATUM(String value) {
        this.geburtsdatum = value;
    }

    /**
     * Ruft den Wert der geburtsort-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEBURTSORT() {
        return geburtsort;
    }

    /**
     * Legt den Wert der geburtsort-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEBURTSORT(String value) {
        this.geburtsort = value;
    }

    /**
     * Ruft den Wert der geburtsland-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGEBURTSLAND() {
        return geburtsland;
    }

    /**
     * Legt den Wert der geburtsland-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGEBURTSLAND(String value) {
        this.geburtsland = value;
    }

    /**
     * Ruft den Wert der sterbedatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTERBEDATUM() {
        return sterbedatum;
    }

    /**
     * Legt den Wert der sterbedatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTERBEDATUM(String value) {
        this.sterbedatum = value;
    }

    /**
     * Ruft den Wert der geschlecht-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGESCHLECHT() {
        return geschlecht;
    }

    /**
     * Legt den Wert der geschlecht-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGESCHLECHT(String value) {
        this.geschlecht = value;
    }

    /**
     * Ruft den Wert der familienstand-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAMILIENSTAND() {
        return familienstand;
    }

    /**
     * Legt den Wert der familienstand-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAMILIENSTAND(String value) {
        this.familienstand = value;
    }

    /**
     * Ruft den Wert der religion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELIGION() {
        return religion;
    }

    /**
     * Legt den Wert der religion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELIGION(String value) {
        this.religion = value;
    }

    /**
     * Ruft den Wert der beruf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBERUF() {
        return beruf;
    }

    /**
     * Legt den Wert der beruf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBERUF(String value) {
        this.beruf = value;
    }

    /**
     * Ruft den Wert der parteikurz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTEIKURZ() {
        return parteikurz;
    }

    /**
     * Legt den Wert der parteikurz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTEIKURZ(String value) {
        this.parteikurz = value;
    }

    /**
     * Ruft den Wert der vitakurz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVITAKURZ() {
        return vitakurz;
    }

    /**
     * Legt den Wert der vitakurz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVITAKURZ(String value) {
        this.vitakurz = value;
    }

    /**
     * Ruft den Wert der veroeffentlichungspflichtiges-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVEROEFFENTLICHUNGSPFLICHTIGES() {
        return veroeffentlichungspflichtiges;
    }

    /**
     * Legt den Wert der veroeffentlichungspflichtiges-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVEROEFFENTLICHUNGSPFLICHTIGES(String value) {
        this.veroeffentlichungspflichtiges = value;
    }

}
