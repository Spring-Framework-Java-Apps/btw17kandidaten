//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2017.10.04 um 03:06:03 PM CEST
//


package org.woehlke.btw17.kandidaten.oodm.model.bundestag.xml;

import java.util.ArrayList;
import java.util.List;
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
    "version",
    "mdb"
})
@XmlRootElement(name = "DOCUMENT")
public class DOCUMENT {

    @XmlElement(name = "VERSION", required = true)
    protected String version;
    @XmlElement(name = "MDB", required = true)
    protected List<MDB> mdb;

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVERSION() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVERSION(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the mdb property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mdb property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMDB().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MDB }
     *
     *
     */
    public List<MDB> getMDB() {
        if (mdb == null) {
            mdb = new ArrayList<MDB>();
        }
        return this.mdb;
    }

}
