package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import java.util.HashSet;
import java.util.Set;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.MADE_WITH;

@Setter
@Getter
@NodeEntity
public class TechnologieStack implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique=true)
    @Property(name="technologie_stack")
    private String technologieStack;

    @Relationship(type = MADE_WITH)
    private Set<Technologie> technologien = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return technologieStack;
    }

    @Override
    public String getUniqueId() {
        return technologieStack+" "+id;
    }

    public TechnologieStack() {
    }
}
