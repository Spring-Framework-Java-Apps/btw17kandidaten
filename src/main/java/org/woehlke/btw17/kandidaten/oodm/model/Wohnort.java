package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

@Entity
@Table(
    name = "wohnort",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_wohnort",columnNames = {"wohnort"})
    },
    indexes = {
        @Index(name = "idx_wohnort_webseite", columnList = "webseite"),
        @Index(name = "idx_wohnort_facebook", columnList = "facebook"),
        @Index(name = "idx_wohnort_logo_url", columnList = "logo_url"),
        @Index(name = "idx_wohnort_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_wohnort_google_maps_url", columnList = "google_maps_url")
    }
)
public class Wohnort implements KandidatDimension {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String wohnort;

    @URL
    @Column
    private String webseite;

    @URL
    @Column(name = "wikipedia_article")
    private String wikipediaArticle;

    @URL
    @Column
    private String facebook;

    @URL
    @Column(name="logo_url")
    private String logoUrl;

    @URL
    @Column(name = "google_maps_url")
    private String googleMapsUrl;

    @Transient
    public String getName() {
        return wohnort;
    }

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }

    public String getWikipediaArticle() {
        return wikipediaArticle;
    }

    public void setWikipediaArticle(String wikipediaArticle) {
        this.wikipediaArticle = wikipediaArticle;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wohnort)) return false;

        Wohnort wohnort1 = (Wohnort) o;

        if (id != null ? !id.equals(wohnort1.id) : wohnort1.id != null) return false;
        if (wohnort != null ? !wohnort.equals(wohnort1.wohnort) : wohnort1.wohnort != null) return false;
        if (webseite != null ? !webseite.equals(wohnort1.webseite) : wohnort1.webseite != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(wohnort1.wikipediaArticle) : wohnort1.wikipediaArticle != null)
            return false;
        if (facebook != null ? !facebook.equals(wohnort1.facebook) : wohnort1.facebook != null) return false;
        if (logoUrl != null ? !logoUrl.equals(wohnort1.logoUrl) : wohnort1.logoUrl != null) return false;
        return googleMapsUrl != null ? googleMapsUrl.equals(wohnort1.googleMapsUrl) : wohnort1.googleMapsUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (googleMapsUrl != null ? googleMapsUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wohnort{" +
                "id=" + id +
                ", wohnort='" + wohnort + '\'' +
                ", webseite='" + webseite + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", facebook='" + facebook + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", googleMapsUrl='" + googleMapsUrl + '\'' +
                '}';
    }
}
