package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

@NodeEntity
public class Adresse extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index
    @Property(name="strasse")
    private String strasse;

    @Index
    @Property(name="hausnummer")
    private String hausnummer;

    @Index
    @Property(name="plz")
    private String plz;

    @Index
    @Property(name="ort")
    private String ort;

    @Property(name="nation")
    private String nation;

    @Property(name="bundesland")
    private String bundesland;

    //@Relationship(type = LOCATION)
    //private Bundesland bundesland = new Bundesland();

    //@Relationship(type = LOCATION)
    //private Nation nation = new Nation();

    @Override
    public String getName() {
        return plz+" "+ort;
    }

    public Adresse() {
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }
}
