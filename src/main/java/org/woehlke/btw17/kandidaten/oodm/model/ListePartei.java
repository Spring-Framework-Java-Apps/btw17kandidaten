package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.URL;
import org.woehlke.btw17.kandidaten.common.JpaDomainObject;
import org.woehlke.btw17.kandidaten.oodm.model.listener.ListeParteiListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;



/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "listepartei",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_listepartei",columnNames = {"listepartei","listepartei_lang"})
    },
    indexes = {
        @Index(name = "idx_listepartei_bundeszentrale_politische_bildung", columnList = "bundeszentrale_politische_bildung"),
        @Index(name = "idx_listepartei_wahlprogramm", columnList = "wahlprogramm"),
        @Index(name = "idx_listepartei_parteiprogramm", columnList = "parteiprogramm"),
        //
        @Index(name = "idx_listepartei_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_listepartei_webseite", columnList = "webseite"),
        //
        @Index(name = "idx_listepartei_twitter", columnList = "twitter"),
        @Index(name = "idx_listepartei_facebook", columnList = "facebook"),
        @Index(name = "idx_listepartei_youtube", columnList = "youtube"),
        @Index(name = "idx_listepartei_lobbypedia_url", columnList = "lobbypedia_url"),
        @Index(name = "idx_listepartei_wikipedia_article", columnList = "wikipedia_article")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "ListePartei.getAllIds",
        query = "select o.id from ListePartei as o order by o.listePartei"
    ),
    @NamedQuery(
        name = "ListePartei.getMaxId",
        query = "select max(o.id) from ListePartei as o"
    )
})
@EntityListeners(ListeParteiListener.class)
public class ListePartei implements JpaDomainObject,WebseiteEmbedded,CommonFieldsEmbedded,OnlineStrategieEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name="listepartei")
    private String listePartei;

    @Column(name="listepartei_lang")
    private String listeParteiLang;

    @URL
    @Column(name="wahlprogramm")
    private String wahlprogramm;

    @URL
    @Column(name="parteiprogramm")
    private String parteiprogramm;

    @URL
    @Column(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "listepartei_agentur"
            )
        )
    })
    private Webseite webseite = new Webseite();


    @Transient
    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(listePartei);
        sb.append(" - ");
        sb.append(listeParteiLang);
        return sb.toString();
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

    public String getParteiprogramm() {
        return parteiprogramm;
    }

    public void setParteiprogramm(String parteiprogramm) {
        this.parteiprogramm = parteiprogramm;
    }

    @Override
    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    @Override
    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie != null){
            this.onlineStrategie = onlineStrategie;
        }
    }

    @Override
    public CommonFields getCommonFields() {
        return commonFields;
    }

    @Override
    public void setCommonFields(CommonFields commonFields) {
        if(commonFields != null){
            this.commonFields = commonFields;
        }
    }

    @Override
    public Webseite getWebseite() {
        return webseite;
    }

    @Override
    public void setWebseite(Webseite webseite) {
        if(webseite != null){
            this.webseite = webseite;
        }
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
        if (parteiprogramm != null ? !parteiprogramm.equals(that.parteiprogramm) : that.parteiprogramm != null)
            return false;
        if (bundeszentralePolitischeBildung != null ? !bundeszentralePolitischeBildung.equals(that.bundeszentralePolitischeBildung) : that.bundeszentralePolitischeBildung != null)
            return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        if (commonFields != null ? !commonFields.equals(that.commonFields) : that.commonFields != null) return false;
        return webseite != null ? webseite.equals(that.webseite) : that.webseite == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listePartei != null ? listePartei.hashCode() : 0);
        result = 31 * result + (listeParteiLang != null ? listeParteiLang.hashCode() : 0);
        result = 31 * result + (wahlprogramm != null ? wahlprogramm.hashCode() : 0);
        result = 31 * result + (parteiprogramm != null ? parteiprogramm.hashCode() : 0);
        result = 31 * result + (bundeszentralePolitischeBildung != null ? bundeszentralePolitischeBildung.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListePartei{" +
                "id=" + id +
                ", listePartei='" + listePartei + '\'' +
                ", listeParteiLang='" + listeParteiLang + '\'' +
                ", wahlprogramm='" + wahlprogramm + '\'' +
                ", parteiprogramm='" + parteiprogramm + '\'' +
                ", bundeszentralePolitischeBildung='" + bundeszentralePolitischeBildung + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", commonFields=" + commonFields +
                ", webseite=" + webseite +
                '}';
    }
}
