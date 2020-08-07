package org.woehlke.btw17.kandidaten.oodm.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import org.woehlke.btw17.kandidaten.oodm.model.listener.WahlkreisListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
@NamedQueries({
    @NamedQuery(
        name = "Wahlkreis.getAllIds",
        query = "select o.id from Wahlkreis as o order by o.wahlkreisName"
    ),
    @NamedQuery(
        name = "Wahlkreis.getMaxId",
        query = "select max(o.id) from Wahlkreis as o"
    )
})
@EntityListeners(WahlkreisListener.class)
public class Wahlkreis implements DomainObject,GeoPositionEmbedded,CommonFieldsEmbedded,StrukturdatenEmbedded,WahlergebnisseBtw17Embedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @NotNull
    @Column(name="wahlkreis_id",unique = true, nullable = false)
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

    @Valid
    @Embedded
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = true, updatable = true)
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

    public WahlergebnisseBtw17 getWahlergebnisseBtw17() {
        return wahlergebnisseBtw17;
    }

    public void setWahlergebnisseBtw17(WahlergebnisseBtw17 wahlergebnisseBtw17) {
        if(wahlergebnisseBtw17!=null){
            this.wahlergebnisseBtw17 = wahlergebnisseBtw17;
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
