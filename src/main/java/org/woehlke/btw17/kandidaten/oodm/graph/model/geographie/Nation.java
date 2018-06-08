package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;


import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

@NodeEntity
public class Nation extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="nation")
    private String nation;

    @Relationship(type=LOCATION)
    private Kontinent kontinent;

    @Override
    public String getName() {
        return nation;
    }

    public Nation() {
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Kontinent getKontinent() {
        return kontinent;
    }

    public void setKontinent(Kontinent kontinent) {
        this.kontinent = kontinent;
    }
}
