package org.woehlke.btw17.kandidaten.oodm.graph.model.regierung;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.Valid;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.PUBLISH_ONLINE;


@Setter
@Getter
@NodeEntity
public class Ministerium implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="ministerium")
    private String ministerium;

    @Property(name="ministerium_lang")
    private String ministeriumLang;

    @Property(name="bundesminister")
    private String bundesministerName;


    //@OneToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    //@JoinColumn(name="fk_bundesminister")
    @Relationship(type=LOCATION)
    private Kandidat bundesminister;

    //@Valid
    //@Embedded
    @Relationship(type=LOCATION)
    private CommonFields commonFields = new CommonFields();

    //@Valid
    //@Embedded
    @Relationship(type=LOCATION)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    //@Valid
    //@Embedded
    @Relationship(type=LOCATION)
    private GeoPosition geoPosition = new GeoPosition();

    //@Valid
    //@Embedded
    @Relationship(type=LOCATION)
    private Adresse adresse = new Adresse();

    //@Valid
    /*
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "ministerium_agentur"
            )
        )
    })
    */
    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

    @Override
    public Long getId() {
        return id;
    }

    //@Transient
    @Override
    public String getName() {
        return ministerium +"  "+ministeriumLang;
    }

    //@Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

}
