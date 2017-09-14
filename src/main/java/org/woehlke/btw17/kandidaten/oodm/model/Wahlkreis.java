package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(
    name = "wahlkreis",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_wahlkreis",columnNames = {"wahlkreis_id"})
    },
    indexes = {
        @Index(name = "idx_wahlkreis_wahlkreis_name", columnList = "wahlkreis_name"),
        @Index(name = "idx_wahlkreis_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_wahlkreis_google_maps_url", columnList = "google_maps_url")
    }
)
public class Wahlkreis implements KandidatFacette,OnlineStrategieEmbedded,GeoPositionEmbedded,CommonFieldsEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="wahlkreis_id",unique = true)
    private Integer wahlkreisId;

    @Column(name="wahlkreis_name")
    private String wahlkreisName;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Embedded
    private CommonFields dimensionFacetten = new CommonFields();

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = true, updatable = false)
    private Bundesland bundesland;

    @Transient
    public String getName() {
        return wahlkreisName + " ( " +wahlkreisId+" )";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWahlkreisId() {
        return wahlkreisId;
    }

    public void setWahlkreisId(Integer wahlkreisId) {
        this.wahlkreisId = wahlkreisId;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public CommonFields getDimensionFacetten() {
        return dimensionFacetten;
    }

    public void setDimensionFacetten(CommonFields dimensionFacetten) {
        this.dimensionFacetten = dimensionFacetten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wahlkreis)) return false;

        Wahlkreis wahlkreis = (Wahlkreis) o;

        if (id != null ? !id.equals(wahlkreis.id) : wahlkreis.id != null) return false;
        if (wahlkreisId != null ? !wahlkreisId.equals(wahlkreis.wahlkreisId) : wahlkreis.wahlkreisId != null)
            return false;
        if (wahlkreisName != null ? !wahlkreisName.equals(wahlkreis.wahlkreisName) : wahlkreis.wahlkreisName != null)
            return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(wahlkreis.onlineStrategie) : wahlkreis.onlineStrategie != null)
            return false;
        if (geoPosition != null ? !geoPosition.equals(wahlkreis.geoPosition) : wahlkreis.geoPosition != null)
            return false;
        if (dimensionFacetten != null ? !dimensionFacetten.equals(wahlkreis.dimensionFacetten) : wahlkreis.dimensionFacetten != null)
            return false;
        return bundesland != null ? bundesland.equals(wahlkreis.bundesland) : wahlkreis.bundesland == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wahlkreisId != null ? wahlkreisId.hashCode() : 0);
        result = 31 * result + (wahlkreisName != null ? wahlkreisName.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (dimensionFacetten != null ? dimensionFacetten.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wahlkreis{" +
                "id=" + id +
                ", wahlkreisId=" + wahlkreisId +
                ", wahlkreisName='" + wahlkreisName + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", geoPosition=" + geoPosition +
                ", dimensionFacetten=" + dimensionFacetten +
                ", bundesland=" + bundesland +
                '}';
    }
}
