package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
//import org.hibernate.validator.constraints.SafeHtml;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

//import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.MADE_WITH;

@Setter
@Getter
@NodeEntity
public class TechnologieStack implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    //@SafeHtml
    //@NotNull
    @Property(name="technologie")
    private String technologie;

    @Relationship(type = MADE_WITH)
    private List<Technologie> technologien = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return technologie;
    }

    @Override
    public String getUniqueId() {
        return technologie+" "+id;
    }
}
