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
    "insartlang",
    "inslang",
    "mdbinsvon",
    "mdbinsbis",
    "fktlang",
    "fktinsvon",
    "fktinsbis"
})
@XmlRootElement(name = "INSTITUTION")
public class INSTITUTION {

    @XmlElement(name = "INSART_LANG", required = true)
    protected String insartlang;
    @XmlElement(name = "INS_LANG", required = true)
    protected String inslang;
    @XmlElement(name = "MDBINS_VON", required = true)
    protected String mdbinsvon;
    @XmlElement(name = "MDBINS_BIS", required = true)
    protected String mdbinsbis;
    @XmlElement(name = "FKT_LANG", required = true)
    protected String fktlang;
    @XmlElement(name = "FKTINS_VON", required = true)
    protected String fktinsvon;
    @XmlElement(name = "FKTINS_BIS", required = true)
    protected String fktinsbis;

    /**
     * Ruft den Wert der insartlang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSARTLANG() {
        return insartlang;
    }

    /**
     * Legt den Wert der insartlang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSARTLANG(String value) {
        this.insartlang = value;
    }

    /**
     * Ruft den Wert der inslang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSLANG() {
        return inslang;
    }

    /**
     * Legt den Wert der inslang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSLANG(String value) {
        this.inslang = value;
    }

    /**
     * Ruft den Wert der mdbinsvon-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMDBINSVON() {
        return mdbinsvon;
    }

    /**
     * Legt den Wert der mdbinsvon-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMDBINSVON(String value) {
        this.mdbinsvon = value;
    }

    /**
     * Ruft den Wert der mdbinsbis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMDBINSBIS() {
        return mdbinsbis;
    }

    /**
     * Legt den Wert der mdbinsbis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMDBINSBIS(String value) {
        this.mdbinsbis = value;
    }

    /**
     * Ruft den Wert der fktlang-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFKTLANG() {
        return fktlang;
    }

    /**
     * Legt den Wert der fktlang-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFKTLANG(String value) {
        this.fktlang = value;
    }

    /**
     * Ruft den Wert der fktinsvon-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFKTINSVON() {
        return fktinsvon;
    }

    /**
     * Legt den Wert der fktinsvon-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFKTINSVON(String value) {
        this.fktinsvon = value;
    }

    /**
     * Ruft den Wert der fktinsbis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFKTINSBIS() {
        return fktinsbis;
    }

    /**
     * Legt den Wert der fktinsbis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFKTINSBIS(String value) {
        this.fktinsbis = value;
    }

}
