package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

import java.util.HashSet;
import java.util.Set;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.MADE_WITH;

@NodeEntity
public class TechnologieStack extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="technologie_stack")
    private String technologieStack;

    @Relationship(type = MADE_WITH)
    private Set<Technologie> technologien = new HashSet<>();


    public TechnologieStack() {
    }

    public String getTechnologieStack() {
        return technologieStack;
    }

    public void setTechnologieStack(String technologieStack) {
        this.technologieStack = technologieStack;
    }

    public Set<Technologie> getTechnologien() {
        return technologien;
    }

    public void setTechnologien(Set<Technologie> technologien) {
        this.technologien = technologien;
    }
}
