package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "wahlkreis",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_wahlkreis",columnNames = {"wahlkreis_id"})
    },
    indexes = {
        @Index(name = "idx_wahlkreis_wahlkreis_name", columnList = "wahlkreis_name")
    }
)
public class Wahlkreis implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="wahlkreis_id",unique = true)
    private Integer wahlkreisId;

    @Column(name="wahlkreis_name")
    private String wahlkreisName;

    @URL
    @Column
    private String webseite;

    @URL
    @Column
    private String wikipediaArticle;

    @URL
    @Column
    private String googleMapsUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWahlkreisId() {
        return wahlkreisId;
    }

    public void setWahlkreisId(Integer wahlkreisId) {
        this.wahlkreisId = wahlkreisId;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
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

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wahlkreis)) return false;

        Wahlkreis wahlkreis = (Wahlkreis) o;

        if (id != null ? !id.equals(wahlkreis.id) : wahlkreis.id != null) return false;
        if (wahlkreisId != null ? !wahlkreisId.equals(wahlkreis.wahlkreisId) : wahlkreis.wahlkreisId != null)
            return false;
        if (wahlkreisName != null ? !wahlkreisName.equals(wahlkreis.wahlkreisName) : wahlkreis.wahlkreisName != null)
            return false;
        if (webseite != null ? !webseite.equals(wahlkreis.webseite) : wahlkreis.webseite != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(wahlkreis.wikipediaArticle) : wahlkreis.wikipediaArticle != null)
            return false;
        return googleMapsUrl != null ? googleMapsUrl.equals(wahlkreis.googleMapsUrl) : wahlkreis.googleMapsUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wahlkreisId != null ? wahlkreisId.hashCode() : 0);
        result = 31 * result + (wahlkreisName != null ? wahlkreisName.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (googleMapsUrl != null ? googleMapsUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wahlkreis{" +
                "id=" + id +
                ", wahlkreisId=" + wahlkreisId +
                ", wahlkreisName='" + wahlkreisName + '\'' +
                ", webseite='" + webseite + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", googleMapsUrl='" + googleMapsUrl + '\'' +
                '}';
    }
}
