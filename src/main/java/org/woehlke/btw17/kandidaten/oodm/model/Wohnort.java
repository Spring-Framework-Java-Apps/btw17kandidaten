package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.commons.JpaDomainObject;
import org.woehlke.btw17.kandidaten.oodm.model.listener.WohnortListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;


@Entity
@Table(
    name = "wohnort",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_wohnort",columnNames = {"wohnort"})
    },
    indexes = {
        @Index(name = "idx_wohnort_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_wohnort_webseite", columnList = "webseite"),
        //
        @Index(name = "idx_wohnort_geo_position", columnList = "google_maps_url,geo_longitude,geo_lattitude,geo_lattitude,geo_zoom"),
        //
        @Index(name = "idx_wohnort_facebook", columnList = "facebook"),
        @Index(name = "idx_wohnort_wikipedia_article", columnList = "wikipedia_article")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Wohnort.getAllIds",
        query = "select o.id from Wohnort as o order by o.wohnort"
    ),
    @NamedQuery(
        name = "Wohnort.getMaxId",
        query = "select max(o.id) from Wohnort as o"
    )
})
@EntityListeners(WohnortListener.class)
public class Wohnort implements JpaDomainObject,WebseiteEmbedded,OnlineStrategieEmbedded,CommonFieldsEmbedded,GeoPositionEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column
    private String wohnort;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = true, updatable = false)
    private Bundesland bundesland;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "wohnort_agentur"
            )
        )
    })
    private Webseite webseite = new Webseite();

    @Transient
    @Override
    public String getName() {
        return wohnort;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Wohnort() {
        onlineStrategie = new OnlineStrategie();
        commonFields = new CommonFields();
        geoPosition = new GeoPosition();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie!=null){
            this.onlineStrategie = onlineStrategie;
        }
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        if(commonFields!=null){
            this.commonFields = commonFields;
        }
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        if(geoPosition!=null) {
            this.geoPosition = geoPosition;
        }
    }

    @Override
    public Webseite getWebseite() {
        return webseite;
    }

    @Override
    public void setWebseite(Webseite webseite) {
        if(webseite!=null){
            this.webseite = webseite;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wohnort)) return false;

        Wohnort wohnort1 = (Wohnort) o;

        if (id != null ? !id.equals(wohnort1.id) : wohnort1.id != null) return false;
        if (wohnort != null ? !wohnort.equals(wohnort1.wohnort) : wohnort1.wohnort != null) return false;
        if (bundesland != null ? !bundesland.equals(wohnort1.bundesland) : wohnort1.bundesland != null) return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(wohnort1.onlineStrategie) : wohnort1.onlineStrategie != null)
            return false;
        if (commonFields != null ? !commonFields.equals(wohnort1.commonFields) : wohnort1.commonFields != null)
            return false;
        if (geoPosition != null ? !geoPosition.equals(wohnort1.geoPosition) : wohnort1.geoPosition != null)
            return false;
        return webseite != null ? webseite.equals(wohnort1.webseite) : wohnort1.webseite == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wohnort{" +
                "id=" + id +
                ", wohnort='" + wohnort + '\'' +
                ", bundesland=" + bundesland +
                ", onlineStrategie=" + onlineStrategie +
                ", commonFields=" + commonFields +
                ", geoPosition=" + geoPosition +
                ", webseite=" + webseite +
                '}';
    }
}
