package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.parts.Adresse;
import org.woehlke.btw17.kandidaten.oodm.model.parts.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.model.parts.KandidatDimension;
import org.woehlke.btw17.kandidaten.oodm.model.parts.OnlineStrategie;

import javax.persistence.*;
import javax.validation.Valid;


@Entity
@Table(
    name = "ministerium",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_ministerium",columnNames = {"ministerium"})
    },
    indexes = {
        @Index(name = "idx_ministerium_ministerium_lang", columnList = "ministerium_lang"),
        @Index(name = "idx_ministerium_webseite", columnList = "webseite"),
        @Index(name = "idx_ministerium_twitter", columnList = "twitter"),
        @Index(name = "idx_ministerium_facebook", columnList = "facebook"),
        @Index(name = "idx_ministerium_youtube", columnList = "youtube"),
        @Index(name = "idx_ministerium_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_ministerium_bundestag_abgeordnete", columnList = "bundestag"),
        @Index(name = "idx_ministerium_abgeordnetenwatch", columnList = "abgeordnetenwatch"),
        @Index(name = "idx_ministerium_google_plus_url", columnList = "google_plus"),
        @Index(name = "idx_ministerium_instagram_url", columnList = "instagram"),
        @Index(name = "idx_ministerium_google_maps_url", columnList = "google_maps_url")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Ministerium.getAll",
        query = "select o from Ministerium as o order by id"
    ),
    @NamedQuery(
        name = "Ministerium.getAllCount",
        query = "select count(o) from Ministerium as o"
    )
})
public class Ministerium implements KandidatDimension {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String ministerium;

    @Column(name="ministerium_lang")
    private String ministeriumLang;

    @Column(name="bundesminister")
    private String bundesministerName;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="fk_bundesminister")
    private Kandidat bundesminister;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Embedded
    private Adresse adresse = new Adresse();

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
    public String getMarkerTitle(){
        return ""+ministerium+"<br/>"+ministeriumLang+"<br/>Bundesminister: <b>"+bundesministerName+"</b>";
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        if (geoPosition != null ? !geoPosition.equals(that.geoPosition) : that.geoPosition != null) return false;
        return adresse != null ? adresse.equals(that.adresse) : that.adresse == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ministerium != null ? ministerium.hashCode() : 0);
        result = 31 * result + (ministeriumLang != null ? ministeriumLang.hashCode() : 0);
        result = 31 * result + (bundesministerName != null ? bundesministerName.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ministerium{" +
                "id=" + id +
                ", ministerium='" + ministerium + '\'' +
                ", ministeriumLang='" + ministeriumLang + '\'' +
                ", bundesministerName='" + bundesministerName + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", geoPosition=" + geoPosition +
                ", adresse=" + adresse +
                '}';
    }
}
