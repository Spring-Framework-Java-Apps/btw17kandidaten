package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

@Setter
@Getter
@NodeEntity
public class Nation implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="nation")
    private String nation;

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
