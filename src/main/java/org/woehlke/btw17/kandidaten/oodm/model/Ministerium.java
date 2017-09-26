package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.listener.MinisteriumListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "ministerium",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_ministerium",columnNames = {"ministerium"})
    },
    indexes = {
        @Index(name = "idx_ministerium_ministerium_lang", columnList = "ministerium_lang"),
        @Index(name = "idx_ministerium_bundesminister", columnList = "bundesminister"),
        //
        @Index(name = "idx_ministerium_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_ministerium_webseite", columnList = "webseite"),
        //
        @Index(name = "idx_ministerium_geo_position", columnList = "google_maps_url,geo_longitude,geo_lattitude,geo_lattitude,geo_zoom"),
        //
        @Index(name = "idx_ministerium_twitter", columnList = "twitter"),
        @Index(name = "idx_ministerium_facebook", columnList = "facebook"),
        @Index(name = "idx_ministerium_youtube", columnList = "youtube"),
        @Index(name = "idx_ministerium_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_ministerium_bundestag_abgeordnete", columnList = "bundestag"),
        @Index(name = "idx_ministerium_abgeordnetenwatch", columnList = "abgeordnetenwatch"),
        @Index(name = "idx_ministerium_google_plus_url", columnList = "google_plus"),
        @Index(name = "idx_ministerium_instagram_url", columnList = "instagram"),
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Ministerium.getAll",
        query = "select o from Ministerium as o order by ministerium"
    ),
    @NamedQuery(
        name = "Ministerium.getAllCount",
        query = "select count(o) from Ministerium as o"
    )
})
@EntityListeners(MinisteriumListener.class)
public class Ministerium implements DomainObject,WebseiteEmbedded,AdresseEmbedded,OnlineStrategieEmbedded,GeoPositionEmbedded,CommonFieldsEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="ministerium")
    private String ministerium;

    @Column(name="ministerium_lang")
    private String ministeriumLang;

    @Column(name="bundesminister")
    private String bundesministerName;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name="fk_bundesminister")
    private Kandidat bundesminister;

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Embedded
    private Adresse adresse = new Adresse();

    @Valid
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "ministerium_agentur"
            )
        )
    })
    private Webseite webseite = new Webseite();

    @Override
    public Long getId() {
        return id;
    }

    @Transient
    @Override
    public String getName() {
        return ministerium +"  "+ministeriumLang;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Transient
    public String getMarkerTitle(){
        return ""+ministerium+" "+ministeriumLang+" Bundesminister: "+bundesministerName+"";
    }

    @Transient
    public String getMarkerLabel(){
        return ""+ministerium+"";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMinisterium() {
        return ministerium;
    }

    public void setMinisterium(String ministerium) {
        this.ministerium = ministerium;
    }

    public String getMinisteriumLang() {
        return ministeriumLang;
    }

    public void setMinisteriumLang(String ministeriumLang) {
        this.ministeriumLang = ministeriumLang;
    }

    public String getBundesministerName() {
        return bundesministerName;
    }

    public void setBundesministerName(String bundesministerName) {
        this.bundesministerName = bundesministerName;
    }

    public Kandidat getBundesminister() {
        return bundesminister;
    }

    public void setBundesminister(Kandidat bundesminister) {
        this.bundesminister = bundesminister;
    }

    @Override
    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    @Override
    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie != null){
            this.onlineStrategie = onlineStrategie;
        }
    }

    @Override
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    @Override
    public void setGeoPosition(GeoPosition geoPosition) {
        if(geoPosition != null){
            this.geoPosition = geoPosition;
        }
    }

    @Override
    public Adresse getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(Adresse adresse) {
        if(adresse != null){
            this.adresse = adresse;
        }
    }

    @Override
    public CommonFields getCommonFields() {
        return commonFields;
    }

    @Override
    public void setCommonFields(CommonFields commonFields) {
        if(commonFields != null){
            this.commonFields = commonFields;
        }
    }

    @Override
    public Webseite getWebseite() {
        return webseite;
    }

    @Override
    public void setWebseite(Webseite webseite) {
        if(webseite != null){
            this.webseite = webseite;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ministerium)) return false;

        Ministerium that = (Ministerium) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ministerium != null ? !ministerium.equals(that.ministerium) : that.ministerium != null) return false;
        if (ministeriumLang != null ? !ministeriumLang.equals(that.ministeriumLang) : that.ministeriumLang != null)
            return false;
        if (bundesministerName != null ? !bundesministerName.equals(that.bundesministerName) : that.bundesministerName != null)
            return false;
        if (commonFields != null ? !commonFields.equals(that.commonFields) : that.commonFields != null) return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        if (geoPosition != null ? !geoPosition.equals(that.geoPosition) : that.geoPosition != null) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        return webseite != null ? webseite.equals(that.webseite) : that.webseite == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ministerium != null ? ministerium.hashCode() : 0);
        result = 31 * result + (ministeriumLang != null ? ministeriumLang.hashCode() : 0);
        result = 31 * result + (bundesministerName != null ? bundesministerName.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ministerium{" +
                "id=" + id +
                ", ministerium='" + ministerium + '\'' +
                ", ministeriumLang='" + ministeriumLang + '\'' +
                ", bundesministerName='" + bundesministerName + '\'' +
                ", commonFields=" + commonFields +
                ", onlineStrategie=" + onlineStrategie +
                ", geoPosition=" + geoPosition +
                ", adresse=" + adresse +
                ", webseite=" + webseite +
                '}';
    }
}
