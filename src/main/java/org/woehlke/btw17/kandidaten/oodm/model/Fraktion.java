package org.woehlke.btw17.kandidaten.oodm.model;


import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Table(
    name = "fraktion",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_fraktion",columnNames = {"fraktion"})
    },
    indexes = {
        @Index(name = "idx_fraktion_fraktion_lang", columnList = "fraktion_lang"),
        @Index(name = "idx_fraktion_webseite", columnList = "webseite"),
        @Index(name = "idx_fraktion_twitter", columnList = "twitter"),
        @Index(name = "idx_fraktion_facebook", columnList = "facebook"),
        @Index(name = "idx_fraktion_youtube", columnList = "youtube"),
        @Index(name = "idx_fraktion_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_fraktion_bundestag_abgeordnete", columnList = "bundestag"),
        @Index(name = "idx_fraktion_abgeordnetenwatch", columnList = "abgeordnetenwatch"),
        @Index(name = "idx_fraktion_google_plus_url", columnList = "google_plus"),
        @Index(name = "idx_fraktion_instagram_url", columnList = "instagram")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Fraktion.getAll",
        query = "select o from Fraktion as o order by id"
    ),
    @NamedQuery(
        name = "Fraktion.getAllCount",
        query = "select count(o) from Fraktion as o"
    )
})
public class Fraktion implements KandidatDimension {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String fraktion;

    @Column(name="fraktion_lang")
    private String fraktionLang;

    @Column(name="logo_url")
    private String logoUrl;

    @URL
    @Column
    private String webseite;

    @URL
    @Column
    private String twitter;

    @URL
    @Column(name="facebook")
    private String facebook;

    @URL
    @Column
    private String youtube;

    @URL
    @Column
    private String soundcloud;

    @URL
    @Column(name="wikipedia_article")
    private String wikipediaArticle;

    @URL
    @Column(name="bundestag")
    private String bundestag;

    @URL
    @Column
    private String abgeordnetenwatch;

    @URL
    @Column(name="lobbypedia_url")
    private String lobbypediaUrl;

    @URL
    @Column(name = "google_plus")
    private String googlePlus;

    @URL
    @Column(name = "instagram")
    private String instagram;


    @Transient
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFraktion() {
        return fraktion;
    }

    public void setFraktion(String fraktion) {
        this.fraktion = fraktion;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public String getSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    public String getWikipediaArticle() {
        return wikipediaArticle;
    }

    public void setWikipediaArticle(String wikipediaArticle) {
        this.wikipediaArticle = wikipediaArticle;
    }

    public String getBundestag() {
        return bundestag;
    }

    public void setBundestag(String bundestag) {
        this.bundestag = bundestag;
    }

    public String getAbgeordnetenwatch() {
        return abgeordnetenwatch;
    }

    public void setAbgeordnetenwatch(String abgeordnetenwatch) {
        this.abgeordnetenwatch = abgeordnetenwatch;
    }

    public String getLobbypediaUrl() {
        return lobbypediaUrl;
    }

    public void setLobbypediaUrl(String lobbypediaUrl) {
        this.lobbypediaUrl = lobbypediaUrl;
    }

    public String getGooglePlus() {
        return googlePlus;
    }

    public void setGooglePlus(String googlePlus) {
        this.googlePlus = googlePlus;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFraktionLang() {
        return fraktionLang;
    }

    public void setFraktionLang(String fraktionLang) {
        this.fraktionLang = fraktionLang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraktion)) return false;

        Fraktion fraktion1 = (Fraktion) o;

        if (id != null ? !id.equals(fraktion1.id) : fraktion1.id != null) return false;
        if (fraktion != null ? !fraktion.equals(fraktion1.fraktion) : fraktion1.fraktion != null) return false;
        if (fraktionLang != null ? !fraktionLang.equals(fraktion1.fraktionLang) : fraktion1.fraktionLang != null)
            return false;
        if (logoUrl != null ? !logoUrl.equals(fraktion1.logoUrl) : fraktion1.logoUrl != null) return false;
        if (webseite != null ? !webseite.equals(fraktion1.webseite) : fraktion1.webseite != null) return false;
        if (twitter != null ? !twitter.equals(fraktion1.twitter) : fraktion1.twitter != null) return false;
        if (facebook != null ? !facebook.equals(fraktion1.facebook) : fraktion1.facebook != null) return false;
        if (youtube != null ? !youtube.equals(fraktion1.youtube) : fraktion1.youtube != null) return false;
        if (soundcloud != null ? !soundcloud.equals(fraktion1.soundcloud) : fraktion1.soundcloud != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(fraktion1.wikipediaArticle) : fraktion1.wikipediaArticle != null)
            return false;
        if (bundestag != null ? !bundestag.equals(fraktion1.bundestag) : fraktion1.bundestag != null) return false;
        if (abgeordnetenwatch != null ? !abgeordnetenwatch.equals(fraktion1.abgeordnetenwatch) : fraktion1.abgeordnetenwatch != null)
            return false;
        if (lobbypediaUrl != null ? !lobbypediaUrl.equals(fraktion1.lobbypediaUrl) : fraktion1.lobbypediaUrl != null)
            return false;
        if (googlePlus != null ? !googlePlus.equals(fraktion1.googlePlus) : fraktion1.googlePlus != null) return false;
        return instagram != null ? instagram.equals(fraktion1.instagram) : fraktion1.instagram == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fraktion != null ? fraktion.hashCode() : 0);
        result = 31 * result + (fraktionLang != null ? fraktionLang.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (soundcloud != null ? soundcloud.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (bundestag != null ? bundestag.hashCode() : 0);
        result = 31 * result + (abgeordnetenwatch != null ? abgeordnetenwatch.hashCode() : 0);
        result = 31 * result + (lobbypediaUrl != null ? lobbypediaUrl.hashCode() : 0);
        result = 31 * result + (googlePlus != null ? googlePlus.hashCode() : 0);
        result = 31 * result + (instagram != null ? instagram.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fraktion{" +
                "id=" + id +
                ", fraktion='" + fraktion + '\'' +
                ", fraktionLang='" + fraktionLang + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", webseite='" + webseite + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", youtube='" + youtube + '\'' +
                ", soundcloud='" + soundcloud + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", bundestag='" + bundestag + '\'' +
                ", abgeordnetenwatch='" + abgeordnetenwatch + '\'' +
                ", lobbypediaUrl='" + lobbypediaUrl + '\'' +
                ", googlePlus='" + googlePlus + '\'' +
                ", instagram='" + instagram + '\'' +
                '}';
    }
}
