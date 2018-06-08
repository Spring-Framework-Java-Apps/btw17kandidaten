package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;


import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;


@NodeEntity
public class Berufsgruppe extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="berufsgruppe")
    private String berufsgruppe;


    public Berufsgruppe() {
    }

    public String getBerufsgruppe() {
        return berufsgruppe;
    }

    public void setBerufsgruppe(String berufsgruppe) {
        this.berufsgruppe = berufsgruppe;
    }
}
