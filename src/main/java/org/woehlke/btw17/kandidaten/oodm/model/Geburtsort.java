package org.woehlke.btw17.kandidaten.oodm.model;


import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "geburtsort",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_geburtsort",columnNames = {"geburtsort"})
    }
)
public class Geburtsort implements KandidatFacette,GeoPositionEmbedded,OnlineStrategieEmbedded,CommonFieldsEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Column
    private String geburtsort;

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Transient
    public String getName() {
        return geburtsort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        this.commonFields = commonFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geburtsort)) return false;

        Geburtsort that = (Geburtsort) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (geburtsort != null ? !geburtsort.equals(that.geburtsort) : that.geburtsort != null) return false;
        if (geoPosition != null ? !geoPosition.equals(that.geoPosition) : that.geoPosition != null) return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        return commonFields != null ? commonFields.equals(that.commonFields) : that.commonFields == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Geburtsort{" +
                "id=" + id +
                ", geburtsort='" + geburtsort + '\'' +
                ", geoPosition=" + geoPosition +
                ", onlineStrategie=" + onlineStrategie +
                ", commonFields=" + commonFields +
                '}';
    }
}
