package org.woehlke.btw17.kandidaten.oodm.model;


import org.hibernate.validator.constraints.URL;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(
    name = "partei",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_partei",columnNames = {"partei","partei_lang"})
    },
    indexes = {
        @Index(name = "idx_partei_webseite", columnList = "webseite"),
        @Index(name = "idx_partei_twitter", columnList = "twitter"),
        @Index(name = "idx_partei_facebook", columnList = "facebook"),
        @Index(name = "idx_partei_youtube", columnList = "youtube"),
        @Index(name = "idx_partei_logo_url", columnList = "logo_url"),
        @Index(name = "idx_partei_bundeszentrale_politische_bildung", columnList = "bundeszentrale_politische_bildung"),
        @Index(name = "idx_partei_lobbypedia_url", columnList = "lobbypedia_url"),
        @Index(name = "idx_partei_wikipedia_article", columnList = "wikipedia_article")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Partei.getAll",
        query = "select o from Partei as o order by o.id"
    )
})
public class Partei implements KandidatFacette,OnlineStrategieEmbedded,CommonFieldsEmbedded,GeoPositionEmbedded,AdresseEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String partei;

    @Column(name="partei_lang")
    private String parteiLang;

    @URL
    @Column(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @Column(name="wahlprogramm")
    private String wahlprogramm;

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
    private CommonFields dimensionFacetten = new CommonFields();

    @Transient
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(partei);
        if(partei.compareTo(parteiLang)!=0){
            sb.append(" - ");
            sb.append(parteiLang);
        }
        return sb.toString();
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
        this.onlineStrategie = onlineStrategie;
    }

    public CommonFields getDimensionFacetten() {
        return dimensionFacetten;
    }

    public void setDimensionFacetten(CommonFields dimensionFacetten) {
        this.dimensionFacetten = dimensionFacetten;
    }

    public String getWahlprogramm() {
        return wahlprogramm;
    }

    public void setWahlprogramm(String wahlprogramm) {
        this.wahlprogramm = wahlprogramm;
    }

    @Override
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    @Override
    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    @Override
    public Adresse getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
        if (onlineStrategie != null ? !onlineStrategie.equals(partei1.onlineStrategie) : partei1.onlineStrategie != null)
            return false;
        if (geoPosition != null ? !geoPosition.equals(partei1.geoPosition) : partei1.geoPosition != null) return false;
        return dimensionFacetten != null ? dimensionFacetten.equals(partei1.dimensionFacetten) : partei1.dimensionFacetten == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (partei != null ? partei.hashCode() : 0);
        result = 31 * result + (parteiLang != null ? parteiLang.hashCode() : 0);
        result = 31 * result + (bundeszentralePolitischeBildung != null ? bundeszentralePolitischeBildung.hashCode() : 0);
        result = 31 * result + (wahlprogramm != null ? wahlprogramm.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (dimensionFacetten != null ? dimensionFacetten.hashCode() : 0);
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
                ", onlineStrategie=" + onlineStrategie +
                ", geoPosition=" + geoPosition +
                ", dimensionFacetten=" + dimensionFacetten +
                '}';
    }
}
