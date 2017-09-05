package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

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
public class ListePartei implements KandidatDimension {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="liste_partei")
    private String listePartei;

    @Column(name="liste_partei_lang")
    private String listeParteiLang;

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
    @Column(name="wikipedia_article")
    private String wikipediaArticle;

    @URL
    @Column(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @URL
    @Column(name="lobbypedia_url")
    private String lobbypediaUrl;


    @Transient
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(listePartei);
        sb.append(" - ");
        sb.append(listeParteiLang);
        return sb.toString();
    }

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

    public String getLobbypediaUrl() {
        return lobbypediaUrl;
    }

    public void setLobbypediaUrl(String lobbypediaUrl) {
        this.lobbypediaUrl = lobbypediaUrl;
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
        if (webseite != null ? !webseite.equals(that.webseite) : that.webseite != null) return false;
        if (twitter != null ? !twitter.equals(that.twitter) : that.twitter != null) return false;
        if (facebook != null ? !facebook.equals(that.facebook) : that.facebook != null) return false;
        if (youtube != null ? !youtube.equals(that.youtube) : that.youtube != null) return false;
        if (logoUrl != null ? !logoUrl.equals(that.logoUrl) : that.logoUrl != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(that.wikipediaArticle) : that.wikipediaArticle != null)
            return false;
        if (bundeszentralePolitischeBildung != null ? !bundeszentralePolitischeBildung.equals(that.bundeszentralePolitischeBildung) : that.bundeszentralePolitischeBildung != null)
            return false;
        return lobbypediaUrl != null ? lobbypediaUrl.equals(that.lobbypediaUrl) : that.lobbypediaUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listePartei != null ? listePartei.hashCode() : 0);
        result = 31 * result + (listeParteiLang != null ? listeParteiLang.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (bundeszentralePolitischeBildung != null ? bundeszentralePolitischeBildung.hashCode() : 0);
        result = 31 * result + (lobbypediaUrl != null ? lobbypediaUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListePartei{" +
                "id=" + id +
                ", listePartei='" + listePartei + '\'' +
                ", listeParteiLang='" + listeParteiLang + '\'' +
                ", webseite='" + webseite + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", youtube='" + youtube + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", bundeszentralePolitischeBildung='" + bundeszentralePolitischeBildung + '\'' +
                ", lobbypediaUrl='" + lobbypediaUrl + '\'' +
                '}';
    }
}
