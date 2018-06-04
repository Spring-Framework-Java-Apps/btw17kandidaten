package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class Hersteller implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @SafeHtml
    @NotNull
    @Property(name="hersteller")
    private String hersteller;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return hersteller;
    }

    @Override
    public String getUniqueId() {
        return hersteller+" "+id;
    }
}
