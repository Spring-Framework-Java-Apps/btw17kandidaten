package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;


import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

@NodeEntity
public class Kontinent extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="kontinent")
    private String kontinent;

    @Override
    public String getName() {
        return kontinent;
    }

    public Kontinent() {
    }

    public String getKontinent() {
        return kontinent;
    }

    public void setKontinent(String kontinent) {
        this.kontinent = kontinent;
    }
}
