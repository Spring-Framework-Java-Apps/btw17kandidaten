package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.PUBLISH_ONLINE;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.REDAKTION;


@Setter
@Getter
@NodeEntity
public class Dienstleister implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @SafeHtml
    @Property(name="name_marketing")
    private String agentur;

    @SafeHtml
    @Property(name="name_registereintrag")
    private String firma;

    @Relationship(type = LOCATION)
    private Adresse adresse = new Adresse();

    @Relationship(type = LOCATION)
    private GeoPosition geoPosition = new GeoPosition();

    @Relationship(type = PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

    @Override
    public String getName() {
        return agentur;
    }

    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }
}
