package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.URL;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(
    name = "liste_partei",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_liste_partei",columnNames = {"liste_partei","liste_partei_lang"})
    },
    indexes = {
        @Index(name = "idx_liste_partei_liste_partei_lang", columnList = "liste_partei_lang"),
        @Index(name = "idx_liste_partei_webseite", columnList = "webseite"),
        @Index(name = "idx_liste_partei_twitter", columnList = "twitter"),
        @Index(name = "idx_liste_partei_facebook", columnList = "facebook"),
        @Index(name = "idx_liste_partei_youtube", columnList = "youtube"),
        @Index(name = "idx_liste_partei_logo_url", columnList = "logo_url"),
        @Index(name = "idx_liste_partei_bundeszentrale_politische_bildung", columnList = "bundeszentrale_politische_bildung"),
        @Index(name = "idx_liste_partei_lobbypedia_url", columnList = "lobbypedia_url"),
        @Index(name = "idx_liste_partei_wikipedia_article", columnList = "wikipedia_article")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "ListePartei.findByPartei",
        query = "select o from ListePartei as o where o.listePartei=:listePartei"
    )
})
public class ListePartei implements KandidatFacette,CommonFieldsEmbedded,OnlineStrategieEmbedded {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="liste_partei")
    private String listePartei;

    @Column(name="liste_partei_lang")
    private String listeParteiLang;

    @URL
    @Column(name="wahlprogramm")
    private String wahlprogramm;

    @URL
    @Column(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields dimensionFacetten = new CommonFields();


    @Transient
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(listePartei);
        sb.append(" - ");
        sb.append(listeParteiLang);
        return sb.toString();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListePartei() {
        return listePartei;
    }

    public void setListePartei(String listePartei) {
        this.listePartei = listePartei;
    }

    public String getListeParteiLang() {
        return listeParteiLang;
    }

    public void setListeParteiLang(String listeParteiLang) {
        this.listeParteiLang = listeParteiLang;
    }

    public String getWahlprogramm() {
        return wahlprogramm;
    }

    public void setWahlprogramm(String wahlprogramm) {
        this.wahlprogramm = wahlprogramm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListePartei)) return false;

        ListePartei that = (ListePartei) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (listePartei != null ? !listePartei.equals(that.listePartei) : that.listePartei != null) return false;
        if (listeParteiLang != null ? !listeParteiLang.equals(that.listeParteiLang) : that.listeParteiLang != null)
            return false;
        if (wahlprogramm != null ? !wahlprogramm.equals(that.wahlprogramm) : that.wahlprogramm != null) return false;
        if (bundeszentralePolitischeBildung != null ? !bundeszentralePolitischeBildung.equals(that.bundeszentralePolitischeBildung) : that.bundeszentralePolitischeBildung != null)
            return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        return dimensionFacetten != null ? dimensionFacetten.equals(that.dimensionFacetten) : that.dimensionFacetten == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listePartei != null ? listePartei.hashCode() : 0);
        result = 31 * result + (listeParteiLang != null ? listeParteiLang.hashCode() : 0);
        result = 31 * result + (wahlprogramm != null ? wahlprogramm.hashCode() : 0);
        result = 31 * result + (bundeszentralePolitischeBildung != null ? bundeszentralePolitischeBildung.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (dimensionFacetten != null ? dimensionFacetten.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListePartei{" +
                "id=" + id +
                ", listePartei='" + listePartei + '\'' +
                ", listeParteiLang='" + listeParteiLang + '\'' +
                ", wahlprogramm='" + wahlprogramm + '\'' +
                ", bundeszentralePolitischeBildung='" + bundeszentralePolitischeBildung + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", dimensionFacetten=" + dimensionFacetten +
                '}';
    }
}
