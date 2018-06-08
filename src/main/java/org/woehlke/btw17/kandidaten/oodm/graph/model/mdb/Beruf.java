package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;


@NodeEntity
public class Beruf extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="beruf")
    private String beruf;

    public Beruf() {
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

}
