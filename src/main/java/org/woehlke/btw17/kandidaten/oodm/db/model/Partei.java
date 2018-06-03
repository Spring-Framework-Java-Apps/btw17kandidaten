package org.woehlke.btw17.kandidaten.oodm.db.model;


import org.hibernate.validator.constraints.URL;
import org.woehlke.btw17.kandidaten.oodm.db.model.commons.JpaDomainObject;
import org.woehlke.btw17.kandidaten.oodm.db.model.listener.ParteiListener;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;



/**
 * @see org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat
 */
@Entity
@Table(
    name = "partei",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_partei", columnNames = {"partei","partei_lang"})
    },
    indexes = {
        @Index(name = "idx_partei_bundeszentrale_politische_bildung", columnList = "bundeszentrale_politische_bildung"),
        @Index(name = "idx_partei_wahlprogramm", columnList = "wahlprogramm"),
        @Index(name = "idx_partei_parteiprogramm", columnList = "parteiprogramm"),
        //
        @Index(name = "idx_partei_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_partei_webseite", columnList = "webseite"),
        //
        @Index(name = "idx_partei_geo_position", columnList = "google_maps_url,geo_longitude,geo_lattitude,geo_lattitude,geo_zoom"),
        //
        @Index(name = "idx_partei_adresse", columnList = "strasse,hausnummer,plz,ort,nation"),
        //
        @Index(name = "idx_partei_twitter", columnList = "twitter"),
        @Index(name = "idx_partei_facebook", columnList = "facebook"),
        @Index(name = "idx_partei_youtube", columnList = "youtube"),
        @Index(name = "idx_partei_logo_url", columnList = "logo_url"),
        @Index(name = "idx_partei_lobbypedia_url", columnList = "lobbypedia_url"),
        @Index(name = "idx_partei_wikipedia_article", columnList = "wikipedia_article")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Partei.getAllIds",
        query = "select o.id from Partei as o order by o.partei"
    ),
    @NamedQuery(
        name = "Partei.getMaxId",
        query = "select max(o.id) from Partei as o"
    )
})
@EntityListeners(ParteiListener.class)
public class Partei implements JpaDomainObject,WebseiteEmbedded,OnlineStrategieEmbedded,CommonFieldsEmbedded,GeoPositionEmbedded,AdresseEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name="partei")
    private String partei;

    @Column(name="partei_lang")
    private String parteiLang;

    @URL
    @Column(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @URL
    @Column(name="wahlprogramm")
    private String wahlprogramm;

    @URL
    @Column(name="parteiprogramm")
    private String parteiprogramm;

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
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "partei_agentur"
            )
        )
    })
    private Webseite webseite = new Webseite();

    @Transient
    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(partei);
        if(partei.compareTo(parteiLang)!=0){
            sb.append(" - ");
            sb.append(parteiLang);
        }
        return sb.toString();
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

    public String getPartei() {
        return partei;
    }

    public void setPartei(String partei) {
        this.partei = partei;
    }

    public String getParteiLang() {
        return parteiLang;
    }

    public void setParteiLang(String parteiLang) {
        this.parteiLang = parteiLang;
    }

    public String getBundeszentralePolitischeBildung() {
        return bundeszentralePolitischeBildung;
    }

    public void setBundeszentralePolitischeBildung(String bundeszentralePolitischeBildung) {
        this.bundeszentralePolitischeBildung = bundeszentralePolitischeBildung;
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

    public String getWahlprogramm() {
        return wahlprogramm;
    }

    public void setWahlprogramm(String wahlprogramm) {
        this.wahlprogramm = wahlprogramm;
    }

    public String getParteiprogramm() {
        return parteiprogramm;
    }

    public void setParteiprogramm(String parteiprogramm) {
        this.parteiprogramm = parteiprogramm;
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
        if (!(o instanceof Partei)) return false;

        Partei partei1 = (Partei) o;

        if (id != null ? !id.equals(partei1.id) : partei1.id != null) return false;
        if (partei != null ? !partei.equals(partei1.partei) : partei1.partei != null) return false;
        if (parteiLang != null ? !parteiLang.equals(partei1.parteiLang) : partei1.parteiLang != null) return false;
        if (bundeszentralePolitischeBildung != null ? !bundeszentralePolitischeBildung.equals(partei1.bundeszentralePolitischeBildung) : partei1.bundeszentralePolitischeBildung != null)
            return false;
        if (wahlprogramm != null ? !wahlprogramm.equals(partei1.wahlprogramm) : partei1.wahlprogramm != null)
            return false;
        if (parteiprogramm != null ? !parteiprogramm.equals(partei1.parteiprogramm) : partei1.parteiprogramm != null)
            return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(partei1.onlineStrategie) : partei1.onlineStrategie != null)
            return false;
        if (geoPosition != null ? !geoPosition.equals(partei1.geoPosition) : partei1.geoPosition != null) return false;
        if (adresse != null ? !adresse.equals(partei1.adresse) : partei1.adresse != null) return false;
        if (commonFields != null ? !commonFields.equals(partei1.commonFields) : partei1.commonFields != null)
            return false;
        return webseite != null ? webseite.equals(partei1.webseite) : partei1.webseite == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (partei != null ? partei.hashCode() : 0);
        result = 31 * result + (parteiLang != null ? parteiLang.hashCode() : 0);
        result = 31 * result + (bundeszentralePolitischeBildung != null ? bundeszentralePolitischeBildung.hashCode() : 0);
        result = 31 * result + (wahlprogramm != null ? wahlprogramm.hashCode() : 0);
        result = 31 * result + (parteiprogramm != null ? parteiprogramm.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Partei{" +
                "id=" + id +
                ", partei='" + partei + '\'' +
                ", parteiLang='" + parteiLang + '\'' +
                ", bundeszentralePolitischeBildung='" + bundeszentralePolitischeBildung + '\'' +
                ", wahlprogramm='" + wahlprogramm + '\'' +
                ", parteiprogramm='" + parteiprogramm + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", geoPosition=" + geoPosition +
                ", adresse=" + adresse +
                ", commonFields=" + commonFields +
                ", webseite=" + webseite +
                '}';
    }
}
