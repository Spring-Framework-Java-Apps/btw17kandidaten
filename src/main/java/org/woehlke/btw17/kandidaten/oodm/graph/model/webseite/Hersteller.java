package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;


import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.GEO_POSITION;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;


@Setter
@Getter
@NodeEntity
public class Hersteller extends GraphDomainObjectImpl implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index
    @Property(name="hersteller")
    private String hersteller;

    @Index
    @Property(name="hersteller")
    private String firmierung;

    @Relationship(type = LOCATION)
    private Adresse adresse;// = new Adresse();

    @Relationship(type = GEO_POSITION)
    private GeoPosition geoPosition;// = new GeoPosition();

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


    public Hersteller() {
    }
}
