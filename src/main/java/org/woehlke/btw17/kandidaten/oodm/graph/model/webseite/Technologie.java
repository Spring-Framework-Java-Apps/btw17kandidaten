package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;


import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

@NodeEntity
public class Technologie extends GraphDomainObjectImpl implements GraphDomainObject {

    //@SafeHtml
    //@NotNull
    @Index(unique = true)
    @Property(name="technologie")
    private String technologie;

    public Technologie() {
    }

    public String getTechnologie() {
        return technologie;
    }

    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }
}
