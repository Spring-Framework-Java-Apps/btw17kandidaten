package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;

@Setter
@Getter
@NodeEntity
public class Kontinent implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="kontinent")
    private String kontinent;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return kontinent;
    }

    @Override
    public String getUniqueId() {
        return kontinent+" "+id.toString();
    }
}
