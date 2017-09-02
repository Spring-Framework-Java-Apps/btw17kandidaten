package org.woehlke.btw17.kandidaten.oodm.model;


import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.io.Serializable;

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
    }
)
public class Partei implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String partei;

    @Column(name="partei_lang")
    private String parteiLang;

    @URL
    @Column
    private String webseite;

    @URL
    @Column
    private String twitter;

    @URL
    @Column
    private String facebook;

    @URL
    @Column
    private String youtube;

    @URL
    @Column(name="logo_url")
    private String logoUrl;

    @URL
    @Column
    private String wikipediaArticle;

    @URL
    @Column(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @Transient
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(partei);
        sb.append(" - ");
        sb.append(parteiLang);
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

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWikipediaArticle() {
        return wikipediaArticle;
    }

    public void setWikipediaArticle(String wikipediaArticle) {
        this.wikipediaArticle = wikipediaArticle;
    }

    public String getBundeszentralePolitischeBildung() {
        return bundeszentralePolitischeBildung;
    }

    public void setBundeszentralePolitischeBildung(String bundeszentralePolitischeBildung) {
        this.bundeszentralePolitischeBildung = bundeszentralePolitischeBildung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partei)) return false;

        Partei partei1 = (Partei) o;

        if (id != null ? !id.equals(partei1.id) : partei1.id != null) return false;
        if (partei != null ? !partei.equals(partei1.partei) : partei1.partei != null) return false;
        if (parteiLang != null ? !parteiLang.equals(partei1.parteiLang) : partei1.parteiLang != null) return false;
        if (webseite != null ? !webseite.equals(partei1.webseite) : partei1.webseite != null) return false;
        if (twitter != null ? !twitter.equals(partei1.twitter) : partei1.twitter != null) return false;
        if (facebook != null ? !facebook.equals(partei1.facebook) : partei1.facebook != null) return false;
        if (youtube != null ? !youtube.equals(partei1.youtube) : partei1.youtube != null) return false;
        if (logoUrl != null ? !logoUrl.equals(partei1.logoUrl) : partei1.logoUrl != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(partei1.wikipediaArticle) : partei1.wikipediaArticle != null)
            return false;
        return bundeszentralePolitischeBildung != null ? bundeszentralePolitischeBildung.equals(partei1.bundeszentralePolitischeBildung) : partei1.bundeszentralePolitischeBildung == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (partei != null ? partei.hashCode() : 0);
        result = 31 * result + (parteiLang != null ? parteiLang.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (bundeszentralePolitischeBildung != null ? bundeszentralePolitischeBildung.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Partei{" +
                "id=" + id +
                ", partei='" + partei + '\'' +
                ", parteiLang='" + parteiLang + '\'' +
                ", webseite='" + webseite + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", youtube='" + youtube + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", bundeszentralePolitischeBildung='" + bundeszentralePolitischeBildung + '\'' +
                '}';
    }
}
