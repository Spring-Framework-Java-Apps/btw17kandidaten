package org.woehlke.btw17.kandidaten.oodm.model;


import org.woehlke.btw17.kandidaten.oodm.model.parts.KandidatDimension;
import org.woehlke.btw17.kandidaten.oodm.model.parts.OnlineStrategie;

import javax.persistence.*;
import javax.validation.Valid;

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

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Transient
    @Override
    public String getName() {
        return fraktionLang;
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

    public String getFraktionLang() {
        return fraktionLang;
    }

    public void setFraktionLang(String fraktionLang) {
        this.fraktionLang = fraktionLang;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
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
        return onlineStrategie != null ? onlineStrategie.equals(fraktion1.onlineStrategie) : fraktion1.onlineStrategie == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fraktion != null ? fraktion.hashCode() : 0);
        result = 31 * result + (fraktionLang != null ? fraktionLang.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fraktion{" +
                "id=" + id +
                ", fraktion='" + fraktion + '\'' +
                ", fraktionLang='" + fraktionLang + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                '}';
    }
}
