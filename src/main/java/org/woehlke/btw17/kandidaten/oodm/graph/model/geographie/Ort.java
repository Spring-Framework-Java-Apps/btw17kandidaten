package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.Valid;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@Setter
@Getter
@NodeEntity
public class Ort implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="ort")
    private String ort;

    //@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_bundesland", nullable = true, updatable = false)
    @Relationship(type=LOCATION)
    private Bundesland bundesland;

    @Relationship(type=LOCATION)
    private Nation nation;

    //@Embedded
    //@Valid
    @Relationship(type=ONLINE_STRATEGIE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    //@Embedded
    //@Valid
    @Relationship(type=COMMON_FIELDS)
    private CommonFields commonFields = new CommonFields();

    //@Embedded
    //@Valid
    @Relationship(type=GEO_POSITION)
    private GeoPosition geoPosition = new GeoPosition();

    /*
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "wohnort_agentur"
            )
        )
    })*/
    //@Valid
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

}
