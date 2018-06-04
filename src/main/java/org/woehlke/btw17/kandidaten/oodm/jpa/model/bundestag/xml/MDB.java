//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quell//schemas verloren.
// Generiert: 2017.10.04 um 03:06:03 PM CEST
//


package org.woehlke.btw17.kandidaten.oodm.jpa.model.bundestag.xml;

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
    "id",
    "namen",
    "biografischeangaben",
    "wahlperioden"
})
@XmlRootElement(name = "MDB")
public class MDB {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "NAMEN", required = true)
    protected NAMEN namen;
    @XmlElement(name = "BIOGRAFISCHE_ANGABEN", required = true)
    protected BIOGRAFISCHEANGABEN biografischeangaben;
    @XmlElement(name = "WAHLPERIODEN", required = true)
    protected WAHLPERIODEN wahlperioden;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der namen-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link NAMEN }
     *
     */
    public NAMEN getNAMEN() {
        return namen;
    }

    /**
     * Legt den Wert der namen-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link NAMEN }
     *
     */
    public void setNAMEN(NAMEN value) {
        this.namen = value;
    }

    /**
     * Ruft den Wert der biografischeangaben-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link BIOGRAFISCHEANGABEN }
     *
     */
    public BIOGRAFISCHEANGABEN getBIOGRAFISCHEANGABEN() {
        return biografischeangaben;
    }

    /**
     * Legt den Wert der biografischeangaben-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link BIOGRAFISCHEANGABEN }
     *
     */
    public void setBIOGRAFISCHEANGABEN(BIOGRAFISCHEANGABEN value) {
        this.biografischeangaben = value;
    }

    /**
     * Ruft den Wert der wahlperioden-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link WAHLPERIODEN }
     *
     */
    public WAHLPERIODEN getWAHLPERIODEN() {
        return wahlperioden;
    }

    /**
     * Legt den Wert der wahlperioden-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link WAHLPERIODEN }
     *
     */
    public void setWAHLPERIODEN(WAHLPERIODEN value) {
        this.wahlperioden = value;
    }

}
