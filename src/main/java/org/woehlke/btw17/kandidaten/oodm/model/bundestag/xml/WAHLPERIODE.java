//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2017.10.04 um 03:06:03 PM CEST
//


package org.woehlke.btw17.kandidaten.oodm.model.bundestag.xml;

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
    "wp",
    "mdbwpvon",
    "mdbwpbis",
    "wkrnummer",
    "wkrname",
    "wkrland",
    "liste",
    "mandatsart",
    "institutionen"
})
@XmlRootElement(name = "WAHLPERIODE")
public class WAHLPERIODE {

    @XmlElement(name = "WP", required = true)
    protected String wp;
    @XmlElement(name = "MDBWP_VON", required = true)
    protected String mdbwpvon;
    @XmlElement(name = "MDBWP_BIS", required = true)
    protected String mdbwpbis;
    @XmlElement(name = "WKR_NUMMER", required = true)
    protected String wkrnummer;
    @XmlElement(name = "WKR_NAME", required = true)
    protected String wkrname;
    @XmlElement(name = "WKR_LAND", required = true)
    protected String wkrland;
    @XmlElement(name = "LISTE", required = true)
    protected String liste;
    @XmlElement(name = "MANDATSART", required = true)
    protected String mandatsart;
    @XmlElement(name = "INSTITUTIONEN", required = true)
    protected INSTITUTIONEN institutionen;

    /**
     * Ruft den Wert der wp-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWP() {
        return wp;
    }

    /**
     * Legt den Wert der wp-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWP(String value) {
        this.wp = value;
    }

    /**
     * Ruft den Wert der mdbwpvon-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMDBWPVON() {
        return mdbwpvon;
    }

    /**
     * Legt den Wert der mdbwpvon-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMDBWPVON(String value) {
        this.mdbwpvon = value;
    }

    /**
     * Ruft den Wert der mdbwpbis-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMDBWPBIS() {
        return mdbwpbis;
    }

    /**
     * Legt den Wert der mdbwpbis-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMDBWPBIS(String value) {
        this.mdbwpbis = value;
    }

    /**
     * Ruft den Wert der wkrnummer-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWKRNUMMER() {
        return wkrnummer;
    }

    /**
     * Legt den Wert der wkrnummer-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWKRNUMMER(String value) {
        this.wkrnummer = value;
    }

    /**
     * Ruft den Wert der wkrname-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWKRNAME() {
        return wkrname;
    }

    /**
     * Legt den Wert der wkrname-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWKRNAME(String value) {
        this.wkrname = value;
    }

    /**
     * Ruft den Wert der wkrland-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWKRLAND() {
        return wkrland;
    }

    /**
     * Legt den Wert der wkrland-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWKRLAND(String value) {
        this.wkrland = value;
    }

    /**
     * Ruft den Wert der liste-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLISTE() {
        return liste;
    }

    /**
     * Legt den Wert der liste-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLISTE(String value) {
        this.liste = value;
    }

    /**
     * Ruft den Wert der mandatsart-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMANDATSART() {
        return mandatsart;
    }

    /**
     * Legt den Wert der mandatsart-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMANDATSART(String value) {
        this.mandatsart = value;
    }

    /**
     * Ruft den Wert der institutionen-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link INSTITUTIONEN }
     *
     */
    public INSTITUTIONEN getINSTITUTIONEN() {
        return institutionen;
    }

    /**
     * Legt den Wert der institutionen-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link INSTITUTIONEN }
     *
     */
    public void setINSTITUTIONEN(INSTITUTIONEN value) {
        this.institutionen = value;
    }

}
