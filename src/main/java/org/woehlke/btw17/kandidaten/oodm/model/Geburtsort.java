package org.woehlke.btw17.kandidaten.oodm.model;


import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(
    name = "geburtsort",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_geburtsort",columnNames = {"geburtsort"})
    }
)
public class Geburtsort implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Column
    private String geburtsort;

    @URL
    @Column
    private String webseite;

    @URL
    @Column
    private String wikipediaArticle;

    @URL
    @Column
    private String googleMapsUrl;

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

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geburtsort)) return false;

        Geburtsort that = (Geburtsort) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (geburtsort != null ? !geburtsort.equals(that.geburtsort) : that.geburtsort != null) return false;
        if (webseite != null ? !webseite.equals(that.webseite) : that.webseite != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(that.wikipediaArticle) : that.wikipediaArticle != null)
            return false;
        return googleMapsUrl != null ? googleMapsUrl.equals(that.googleMapsUrl) : that.googleMapsUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (googleMapsUrl != null ? googleMapsUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Geburtsort{" +
                "id=" + id +
                ", geburtsort='" + geburtsort + '\'' +
                ", webseite='" + webseite + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", googleMapsUrl='" + googleMapsUrl + '\'' +
                '}';
    }
}
