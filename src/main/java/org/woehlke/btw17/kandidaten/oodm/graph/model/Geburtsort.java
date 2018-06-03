package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class Geburtsort implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    //@Column(name = "geburtsort", nullable = false, unique = true)
    private String geburtsort;

    //@Column(name = "geburtsland")
    private String geburtsland;

    @Valid
    //@Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    //@Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    //@Embedded
    private CommonFields commonFields = new CommonFields();

    //@Transient
    public String getName() {
        return geburtsort;
    }

    //@Transient
    //@Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }
}
