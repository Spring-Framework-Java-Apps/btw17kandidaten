package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@Setter
@Getter
@NodeEntity
public class Ort implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    @Property(name="ort")
    private String ort;

    @Property(name="bundesland")
    private String bundesland;

    @Property(name="nation")
    private String nation;

    //@Relationship(type=LOCATION)
    //private Bundesland bundesland = new Bundesland();

    //@Relationship(type=LOCATION)
    //private Nation nation = new Nation();

    @Relationship(type=ONLINE_STRATEGIE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type=COMMON_FIELDS)
    private CommonFields commonFields = new CommonFields();

    @Relationship(type=LOCATION)
    private GeoPosition geoPosition = new GeoPosition();

    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

    @Override
    public String getName() {
        return ort;
    }

    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }

    public Ort() {
    }
}
