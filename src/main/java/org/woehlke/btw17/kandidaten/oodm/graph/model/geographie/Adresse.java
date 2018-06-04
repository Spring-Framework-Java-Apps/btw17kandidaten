package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;

@Setter
@Getter
@NodeEntity
public class Adresse implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="strasse")
    private String strasse;

    @Column(name="hausnummer")
    private String hausnummer;

    @Column(name="plz")
    private String plz;

    @Column(name="ort")
    private String ort;

    @Relationship(type = LOCATION)
    private Bundesland bundesland = new Bundesland();

    @Relationship(type = LOCATION)
    private Nation nation = new Nation();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return plz+" "+ort;
    }

    @Override
    public String getUniqueId() {
        return plz+" "+ort+" "+id;
    }
}
