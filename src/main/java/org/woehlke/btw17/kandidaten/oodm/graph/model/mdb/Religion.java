package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

@Setter
@Getter
@NodeEntity
public class Religion implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    @Property(name="religion")
    private String religion;

    @Index(unique = true)
    @Property(name="bezeichnung")
    private String bezeichnung;

    @Property(name="beschreibung")
    private String beschreibung;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return religion;
    }

    @Override
    public String getUniqueId() {
        return religion+" "+id;
    }

    public Religion() {
    }
}
