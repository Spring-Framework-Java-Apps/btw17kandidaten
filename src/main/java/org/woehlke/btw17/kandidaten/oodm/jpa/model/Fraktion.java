package org.woehlke.btw17.kandidaten.oodm.jpa.model;


import org.woehlke.btw17.kandidaten.oodm.jpa.model.commons.JpaDomainObject;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.listener.FraktionListener;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.jpa.model.Kandidat
 */
@Entity
@Table(
    name = "fraktion",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_fraktion",columnNames = {"fraktion"})
    },
    indexes = {
        @Index(name = "idx_fraktion_fraktion_lang", columnList = "fraktion_lang"),
        //
        @Index(name = "idx_fraktion_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_fraktion_webseite", columnList = "webseite"),
        //
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
            name = "Fraktion.getAllIds",
            query = "select o.id from Fraktion as o order by o.fraktion"
    ),
    @NamedQuery(
            name = "Fraktion.getMaxId",
            query = "select max(o.id) from Fraktion as o"
    )
})
@EntityListeners(FraktionListener.class)
public class Fraktion implements JpaDomainObject,WebseiteEmbedded,CommonFieldsEmbedded,OnlineStrategieEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name="fraktion")
    private String fraktion;

    @Column(name="fraktion_lang")
    private String fraktionLang;

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "fraktion_agentur"
            )
        )
    })
    private Webseite webseite = new Webseite();

    @Transient
    @Override
    public String getName() {
        return fraktionLang;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
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

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        if(commonFields != null){
            this.commonFields = commonFields;
        }
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie != null){
            this.onlineStrategie = onlineStrategie;
        }
    }

    public Webseite getWebseite() {
        return webseite;
    }

    public void setWebseite(Webseite webseite) {
        if(webseite != null){
            this.webseite = webseite;
        }
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
        if (commonFields != null ? !commonFields.equals(fraktion1.commonFields) : fraktion1.commonFields != null)
            return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(fraktion1.onlineStrategie) : fraktion1.onlineStrategie != null)
            return false;
        return webseite != null ? webseite.equals(fraktion1.webseite) : fraktion1.webseite == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fraktion != null ? fraktion.hashCode() : 0);
        result = 31 * result + (fraktionLang != null ? fraktionLang.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fraktion{" +
                "id=" + id +
                ", fraktion='" + fraktion + '\'' +
                ", fraktionLang='" + fraktionLang + '\'' +
                ", commonFields=" + commonFields +
                ", onlineStrategie=" + onlineStrategie +
                ", webseite=" + webseite +
                '}';
    }
}
