package org.woehlke.btw17.kandidaten.oodm.model.parts;

import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.configuration.MySerializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.GeoPositionEmbedded
 */
@Validated
@Embeddable
public class GeoPosition implements MySerializable {

    @URL
    @Column(name = "google_maps_url")
    private String googleMapsUrl;

    @Column(name = "geo_longitude")
    private String geoLongitude;

    @Column(name = "geo_lattitude")
    private String geoLattitude;

    @Column(name = "geo_zoom")
    private String geoZoom;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoPosition)) return false;

        GeoPosition that = (GeoPosition) o;

        if (googleMapsUrl != null ? !googleMapsUrl.equals(that.googleMapsUrl) : that.googleMapsUrl != null)
            return false;
        if (geoLongitude != null ? !geoLongitude.equals(that.geoLongitude) : that.geoLongitude != null) return false;
        if (geoLattitude != null ? !geoLattitude.equals(that.geoLattitude) : that.geoLattitude != null) return false;
        return geoZoom != null ? geoZoom.equals(that.geoZoom) : that.geoZoom == null;
    }

    @Override
    public int hashCode() {
        int result = googleMapsUrl != null ? googleMapsUrl.hashCode() : 0;
        result = 31 * result + (geoLongitude != null ? geoLongitude.hashCode() : 0);
        result = 31 * result + (geoLattitude != null ? geoLattitude.hashCode() : 0);
        result = 31 * result + (geoZoom != null ? geoZoom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeoPosition{" +
                "googleMapsUrl='" + googleMapsUrl + '\'' +
                ", geoLongitude='" + geoLongitude + '\'' +
                ", geoLattitude='" + geoLattitude + '\'' +
                ", geoZoom='" + geoZoom + '\'' +
                '}';
    }
}
