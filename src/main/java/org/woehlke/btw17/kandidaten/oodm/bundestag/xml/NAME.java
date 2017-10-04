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
    "nachname",
    "vorname",
    "ortszusatz",
    "adel",
    "praefix",
    "anredetitel",
    "akadtitel",
    "historievon",
    "historiebis"
})
@XmlRootElement(name = "NAME")
public class NAME {

    @XmlElement(name = "NACHNAME", required = true)
    protected String nachname;
    @XmlElement(name = "VORNAME", required = true)
    protected String vorname;
    @XmlElement(name = "ORTSZUSATZ", required = true)
    protected String ortszusatz;
    @XmlElement(name = "ADEL", required = true)
    protected String adel;
    @XmlElement(name = "PRAEFIX", required = true)
    protected String praefix;
    @XmlElement(name = "ANREDE_TITEL", required = true)
    protected String anredetitel;
    @XmlElement(name = "AKAD_TITEL", required = true)
    protected String akadtitel;
    @XmlElement(name = "HISTORIE_VON", required = true)
    protected String historievon;
    @XmlElement(name = "HISTORIE_BIS", required = true)
    protected String historiebis;

    /**
     * Ruft den Wert der nachname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNACHNAME() {
        return nachname;
    }

    /**
     * Legt den Wert der nachname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNACHNAME(String value) {
        this.nachname = value;
    }

    /**
     * Ruft den Wert der vorname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVORNAME() {
        return vorname;
    }

    /**
     * Legt den Wert der vorname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVORNAME(String value) {
        this.vorname = value;
    }

    /**
     * Ruft den Wert der ortszusatz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORTSZUSATZ() {
        return ortszusatz;
    }

    /**
     * Legt den Wert der ortszusatz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORTSZUSATZ(String value) {
        this.ortszusatz = value;
    }

    /**
     * Ruft den Wert der adel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADEL() {
        return adel;
    }

    /**
     * Legt den Wert der adel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADEL(String value) {
        this.adel = value;
    }

    /**
     * Ruft den Wert der praefix-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRAEFIX() {
        return praefix;
    }

    /**
     * Legt den Wert der praefix-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRAEFIX(String value) {
        this.praefix = value;
    }

    /**
     * Ruft den Wert der anredetitel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getANREDETITEL() {
        return anredetitel;
    }

    /**
     * Legt den Wert der anredetitel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setANREDETITEL(String value) {
        this.anredetitel = value;
    }

    /**
     * Ruft den Wert der akadtitel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAKADTITEL() {
        return akadtitel;
    }

    /**
     * Legt den Wert der akadtitel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAKADTITEL(String value) {
        this.akadtitel = value;
    }

    /**
     * Ruft den Wert der historievon-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHISTORIEVON() {
        return historievon;
    }

    /**
     * Legt den Wert der historievon-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHISTORIEVON(String value) {
        this.historievon = value;
    }

    /**
     * Ruft den Wert der historiebis-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHISTORIEBIS() {
        return historiebis;
    }

    /**
     * Legt den Wert der historiebis-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHISTORIEBIS(String value) {
        this.historiebis = value;
    }

}
