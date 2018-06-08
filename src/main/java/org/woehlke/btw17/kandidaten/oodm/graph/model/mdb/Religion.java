package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

@NodeEntity
public class Religion extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="religion")
    private String religion;

    @Index(unique = true)
    @Property(name="bezeichnung")
    private String bezeichnung;

    @Property(name="beschreibung")
    private String beschreibung;

    public Religion() {
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
