package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;

@Setter
@Getter
@NodeEntity
public class GeoPosition implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @URL
    @Column(name = "google_maps_url")
    private String googleMapsUrl;

    @Column(name = "geo_longitude")
    private String geoLongitude;

    @Column(name = "geo_lattitude")
    private String geoLattitude;

    @Column(name = "geo_zoom")
    private String geoZoom;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return " name ";
    }

    @Override
    public String getUniqueId() {
        return ""+id;
    }
}
