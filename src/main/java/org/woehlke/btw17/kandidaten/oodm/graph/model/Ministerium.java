package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import javax.validation.Valid;


@Setter
@Getter
@NodeEntity
public class Ministerium implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(name="ministerium")
    private String ministerium;

    //@Column(name="ministerium_lang")
    private String ministeriumLang;

    //@Column(name="bundesminister")
    private String bundesministerName;

    //@OneToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    //@JoinColumn(name="fk_bundesminister")
    private Kandidat bundesminister;

    @Valid
    //@Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    //@Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    //@Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    //@Embedded
    private Adresse adresse = new Adresse();

    @Valid
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
    private Webseite webseite = new Webseite();

    @Override
    public Long getId() {
        return id;
    }

    @Transient
    @Override
    public String getName() {
        return ministerium +"  "+ministeriumLang;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

}
