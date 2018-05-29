package org.woehlke.btw17.kandidaten.oodm.model;


import org.woehlke.btw17.kandidaten.oodm.model.listener.GeburtsortListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "geburtsort"//,
    //schema = "public",
    //catalog = "information_//schema",
    /*
    uniqueConstraints = {
        @UniqueConstraint(name="unique_geburtsort",columnNames = {"geburtsort"})
    },
    indexes = {
        @Index(name = "idx_geburtsort_geburtsland", columnList = "geburtsland"),
        //
        @Index(name = "idx_geburtsort_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_geburtsort_geo_position", columnList = "google_maps_url,geo_longitude,geo_lattitude,geo_lattitude,geo_zoom"),
        //
    }*/
)
@NamedQueries({
    @NamedQuery(
        name = "Geburtsort.getAllIds",
        query = "select o.id from Geburtsort as o order by o.geburtsort"
    ),
    @NamedQuery(
        name = "Geburtsort.getMaxId",
        query = "select max(o.id) from Geburtsort as o"
    )
})
@EntityListeners(GeburtsortListener.class)
public class Geburtsort implements DomainObject,GeoPositionEmbedded,OnlineStrategieEmbedded,CommonFieldsEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull
    @Column(name = "geburtsort", nullable = false, unique = true)
    private String geburtsort;

    @Column(name = "geburtsland")
    private String geburtsland;

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

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
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

    public String getGeburtsland() {
        return geburtsland;
    }

    public void setGeburtsland(String geburtsland) {
        this.geburtsland = geburtsland;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        if(geoPosition != null){
            this.geoPosition = geoPosition;
        }
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie != null){
            this.onlineStrategie = onlineStrategie;
        }
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        if(commonFields != null){
            this.commonFields = commonFields;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geburtsort)) return false;

        Geburtsort that = (Geburtsort) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (geburtsort != null ? !geburtsort.equals(that.geburtsort) : that.geburtsort != null) return false;
        if (geburtsland != null ? !geburtsland.equals(that.geburtsland) : that.geburtsland != null) return false;
        if (geoPosition != null ? !geoPosition.equals(that.geoPosition) : that.geoPosition != null) return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        return commonFields != null ? commonFields.equals(that.commonFields) : that.commonFields == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (geburtsland != null ? geburtsland.hashCode() : 0);
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
                ", geburtsland='" + geburtsland + '\'' +
                ", geoPosition=" + geoPosition +
                ", onlineStrategie=" + onlineStrategie +
                ", commonFields=" + commonFields +
                '}';
    }
}
