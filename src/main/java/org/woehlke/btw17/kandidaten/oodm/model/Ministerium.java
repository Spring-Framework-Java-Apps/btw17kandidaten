package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;


@Entity
@Table(
    name = "ministerium",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_ministerium",columnNames = {"ministerium"})
    },
    indexes = {
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
        query = "select count(o) from Ministerium as o order by id"
    )
})
public class Ministerium implements KandidatDimension {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    private String ministerium;

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
    private String bundestagAbgeordnete;

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

    @URL
    @Column(name = "google_maps_url")
    private String googleMapsUrl;

    @Column(name = "geo_longitude")
    private String geoLongitude;

    @Column(name = "geo_lattitude")
    private String geoLattitude;

    @Column(name = "geo_zoom")
    private String geoZoom;

    @Override
    public Long getId() {
        return id;
    }

    @Transient
    @Override
    public String getName() {
        return ministerium;
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

    public String getBundestagAbgeordnete() {
        return bundestagAbgeordnete;
    }

    public void setBundestagAbgeordnete(String bundestagAbgeordnete) {
        this.bundestagAbgeordnete = bundestagAbgeordnete;
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

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ministerium)) return false;

        Ministerium that = (Ministerium) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ministerium != null ? !ministerium.equals(that.ministerium) : that.ministerium != null) return false;
        if (webseite != null ? !webseite.equals(that.webseite) : that.webseite != null) return false;
        if (twitter != null ? !twitter.equals(that.twitter) : that.twitter != null) return false;
        if (facebook != null ? !facebook.equals(that.facebook) : that.facebook != null) return false;
        if (youtube != null ? !youtube.equals(that.youtube) : that.youtube != null) return false;
        if (soundcloud != null ? !soundcloud.equals(that.soundcloud) : that.soundcloud != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(that.wikipediaArticle) : that.wikipediaArticle != null)
            return false;
        if (bundestagAbgeordnete != null ? !bundestagAbgeordnete.equals(that.bundestagAbgeordnete) : that.bundestagAbgeordnete != null)
            return false;
        if (abgeordnetenwatch != null ? !abgeordnetenwatch.equals(that.abgeordnetenwatch) : that.abgeordnetenwatch != null)
            return false;
        if (lobbypediaUrl != null ? !lobbypediaUrl.equals(that.lobbypediaUrl) : that.lobbypediaUrl != null)
            return false;
        if (googlePlus != null ? !googlePlus.equals(that.googlePlus) : that.googlePlus != null) return false;
        if (instagram != null ? !instagram.equals(that.instagram) : that.instagram != null) return false;
        return googleMapsUrl != null ? googleMapsUrl.equals(that.googleMapsUrl) : that.googleMapsUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ministerium != null ? ministerium.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (soundcloud != null ? soundcloud.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (bundestagAbgeordnete != null ? bundestagAbgeordnete.hashCode() : 0);
        result = 31 * result + (abgeordnetenwatch != null ? abgeordnetenwatch.hashCode() : 0);
        result = 31 * result + (lobbypediaUrl != null ? lobbypediaUrl.hashCode() : 0);
        result = 31 * result + (googlePlus != null ? googlePlus.hashCode() : 0);
        result = 31 * result + (instagram != null ? instagram.hashCode() : 0);
        result = 31 * result + (googleMapsUrl != null ? googleMapsUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ministerium{" +
                "id=" + id +
                ", ministerium='" + ministerium + '\'' +
                ", webseite='" + webseite + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", youtube='" + youtube + '\'' +
                ", soundcloud='" + soundcloud + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", bundestagAbgeordnete='" + bundestagAbgeordnete + '\'' +
                ", abgeordnetenwatch='" + abgeordnetenwatch + '\'' +
                ", lobbypediaUrl='" + lobbypediaUrl + '\'' +
                ", googlePlus='" + googlePlus + '\'' +
                ", instagram='" + instagram + '\'' +
                ", googleMapsUrl='" + googleMapsUrl + '\'' +
                '}';
    }
}
