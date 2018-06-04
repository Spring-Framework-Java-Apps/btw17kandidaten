package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NodeEntity
public class TechnologieStack implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @SafeHtml
    @NotNull
    @Property(name="name")
    private String name;

    @Relationship
    private List<Technologie> technologien = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUniqueId() {
        return name+" "+id;
    }
}
