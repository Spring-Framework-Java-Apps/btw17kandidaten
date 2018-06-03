package org.woehlke.btw17.kandidaten.oodm.db.model;

import org.hibernate.validator.constraints.SafeHtml;
import org.woehlke.btw17.kandidaten.oodm.db.model.commons.JpaDomainObject;
import org.woehlke.btw17.kandidaten.oodm.db.model.listener.WebseiteAgenturListener;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.db.model.parts.Webseite
 * @see org.woehlke.btw17.kandidaten.oodm.db.model.parts.WebseiteEmbedded
 *
 * @see org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat
 */
@Entity
@Table(
    name = "agentur",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_agentur",columnNames = {"agentur"})
    },
    indexes = {
        @Index(name = "idx_agentur_firma", columnList = "firma"),
        //
        @Index(name = "idx_agentur_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_agentur_geo_position", columnList = "google_maps_url,geo_longitude,geo_lattitude,geo_lattitude,geo_zoom"),
        //
        @Index(name = "idx_agentur_adresse", columnList = "strasse,hausnummer,plz,ort,nation"),
        //
    }
)
@NamedQueries({
    @NamedQuery(
        name = "WebseiteAgentur.getAllIds",
        query = "select o.id from WebseiteAgentur as o order by o.agentur"
    ),
    @NamedQuery(
        name = "WebseiteAgentur.getMaxId",
        query = "select max(o.id) from WebseiteAgentur as o"
    )
})
@EntityListeners(WebseiteAgenturListener.class)
public class WebseiteAgentur implements JpaDomainObject,AdresseEmbedded,OnlineStrategieEmbedded,GeoPositionEmbedded,CommonFieldsEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @SafeHtml
    @NotNull
    @Column
    private String agentur;

    @SafeHtml
    @NotNull
    @Column
    private String firma;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private Adresse adresse = new Adresse();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Transient
    @Override
    public String getName() {
        return agentur;
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

    public String getAgentur() {
        return agentur;
    }

    public void setAgentur(String agentur) {
        this.agentur = agentur;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie != null) {
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        if(adresse != null){
            this.adresse = adresse;
        }
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        if(geoPosition != null){
            this.geoPosition = geoPosition;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebseiteAgentur)) return false;

        WebseiteAgentur that = (WebseiteAgentur) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (agentur != null ? !agentur.equals(that.agentur) : that.agentur != null) return false;
        if (firma != null ? !firma.equals(that.firma) : that.firma != null) return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        if (commonFields != null ? !commonFields.equals(that.commonFields) : that.commonFields != null) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        return geoPosition != null ? geoPosition.equals(that.geoPosition) : that.geoPosition == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (agentur != null ? agentur.hashCode() : 0);
        result = 31 * result + (firma != null ? firma.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WebseiteAgentur{" +
                "id=" + id +
                ", agentur='" + agentur + '\'' +
                ", firma='" + firma + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", commonFields=" + commonFields +
                ", adresse=" + adresse +
                ", geoPosition=" + geoPosition +
                '}';
    }
}
