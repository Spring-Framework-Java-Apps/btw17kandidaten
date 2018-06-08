package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

@NodeEntity
public class GeoPosition extends GraphDomainObjectImpl implements GraphDomainObject {

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
    public String getName() {
        return " name ";
    }

    public GeoPosition() {
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public String getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(String geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public String getGeoLattitude() {
        return geoLattitude;
    }

    public void setGeoLattitude(String geoLattitude) {
        this.geoLattitude = geoLattitude;
    }

    public String getGeoZoom() {
        return geoZoom;
    }

    public void setGeoZoom(String geoZoom) {
        this.geoZoom = geoZoom;
    }
}
