package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;

@Setter
@Getter
@NodeEntity
public class Nation implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="nation")
    private String nation;

    @Relationship(type=LOCATION)
    private Kontinent kontinent = new Kontinent();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return nation;
    }

    @Override
    public String getUniqueId() {
        return nation+" "+id.toString();
    }
}
