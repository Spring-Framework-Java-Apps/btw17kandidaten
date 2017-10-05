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
    "wahlperiode"
})
@XmlRootElement(name = "WAHLPERIODEN")
public class WAHLPERIODEN {

    @XmlElement(name = "WAHLPERIODE", required = true)
    protected List<WAHLPERIODE> wahlperiode;

    /**
     * Gets the value of the wahlperiode property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wahlperiode property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWAHLPERIODE().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WAHLPERIODE }
     *
     *
     */
    public List<WAHLPERIODE> getWAHLPERIODE() {
        if (wahlperiode == null) {
            wahlperiode = new ArrayList<WAHLPERIODE>();
        }
        return this.wahlperiode;
    }

}
