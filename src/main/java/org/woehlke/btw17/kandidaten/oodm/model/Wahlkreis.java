package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.listener.WahlkreisListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;



/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "wahlkreis",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_wahlkreis",columnNames = {"wahlkreis_id"})
    },
    indexes = {
        @Index(name = "idx_wahlkreis_wahlkreis_name", columnList = "wahlkreis_name"),
        //
        @Index(name = "idx_wahlkreis_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_wahlkreis_geo_position", columnList = "google_maps_url,geo_longitude,geo_lattitude,geo_lattitude,geo_zoom"),
        //
    }
)
@EntityListeners(WahlkreisListener.class)
public class Wahlkreis implements DomainObject,GeoPositionEmbedded,CommonFieldsEmbedded,StrukturdatenEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="wahlkreis_id",unique = true)
    private Long wahlkreisId;

    @Column(name="wahlkreis_name")
    private String wahlkreisName;

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private Strukturdaten strukturdaten = new Strukturdaten();

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = true, updatable = false)
    private Bundesland bundesland;

    @Transient
    @Override
    public String getName() {
        return wahlkreisName + " ( " +wahlkreisId+" )";
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

    public Long getWahlkreisId() {
        return wahlkreisId;
    }

    public void setWahlkreisId(Long wahlkreisId) {
        this.wahlkreisId = wahlkreisId;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        if(geoPosition != null){
            this.geoPosition = geoPosition;
        }
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        if(commonFields != null){
            this.commonFields = commonFields;
        }
    }

    public Strukturdaten getStrukturdaten() {
        return strukturdaten;
    }

    public void setStrukturdaten(Strukturdaten strukturdaten) {
        if(strukturdaten != null){
            this.strukturdaten = strukturdaten;
        }
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
        if (geoPosition != null ? !geoPosition.equals(wahlkreis.geoPosition) : wahlkreis.geoPosition != null)
            return false;
        if (commonFields != null ? !commonFields.equals(wahlkreis.commonFields) : wahlkreis.commonFields != null)
            return false;
        return bundesland != null ? bundesland.equals(wahlkreis.bundesland) : wahlkreis.bundesland == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wahlkreisId != null ? wahlkreisId.hashCode() : 0);
        result = 31 * result + (wahlkreisName != null ? wahlkreisName.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wahlkreis{" +
                "id=" + id +
                ", wahlkreisId=" + wahlkreisId +
                ", wahlkreisName='" + wahlkreisName + '\'' +
                ", geoPosition=" + geoPosition +
                ", commonFields=" + commonFields +
                ", bundesland=" + bundesland +
                '}';
    }
}
