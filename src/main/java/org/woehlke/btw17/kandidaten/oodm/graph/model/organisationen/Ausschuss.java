package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

@NodeEntity
public class Ausschuss extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="ausschuss")
    private String ausschuss;

    @Override
    public String getName() {
        return ausschuss;
    }

    public Ausschuss() {
    }

    public String getAusschuss() {
        return ausschuss;
    }

    public void setAusschuss(String ausschuss) {
        this.ausschuss = ausschuss;
    }
}
