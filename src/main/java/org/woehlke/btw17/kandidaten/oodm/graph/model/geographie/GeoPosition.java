package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;


@Setter
@Getter
@NodeEntity
public class GeoPosition implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique=true)
    @Property(name = "google_maps_url")
    private String googleMapsUrl;

    @Property(name = "geo_longitude")
    private String geoLongitude;

    @Property(name = "geo_lattitude")
    private String geoLattitude;

    @Property(name = "geo_zoom")
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
        return getName()+" "+id;
    }
}
