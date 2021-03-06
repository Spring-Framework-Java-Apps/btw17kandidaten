package org.woehlke.btw17.kandidaten.oodm.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.listener.BundeslandListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(
    name = "bundesland",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_bundesland",columnNames = {"bundesland"})
    },
    indexes = {
        @Index(name = "idx_bundesland_bundesland_lang", columnList = "bundesland_lang"),
        //
        @Index(name = "idx_bundesland_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_bundesland_webseite", columnList = "webseite"),
        //
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Bundesland.getAllIds",
        query = "select o.id from Bundesland as o order by o.bundeslandLang"
    ),
    @NamedQuery(
        name = "Bundesland.getMaxId",
        query = "select max(o.id) from Bundesland as o"
    )
})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Bundesland.countBundeslandAgentur",
        query = "SELECT count(*) AS z FROM bundesland_agentur"
    )
})
@EntityListeners(BundeslandListener.class)
public class Bundesland implements DomainObject,WebseiteEmbedded,OnlineStrategieEmbedded,CommonFieldsEmbedded,StrukturdatenEmbedded,WahlergebnisseBtw17Embedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "bundesland", nullable=false)
    private BundeslandEnum bundesland;

    @Column(name="bundesland_lang",nullable = false)
    private String bundeslandLang;

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
                name = "bundesland_agentur"
            )
        )
    })
    private Webseite webseite = new Webseite();

    @Valid
    @Embedded
    private Strukturdaten strukturdaten = new Strukturdaten();


    @Valid
    @Embedded
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @Transient
    public String getName(){
        StringBuffer name = new StringBuffer();
        name.append(bundeslandLang);
        name.append(" (");
        name.append(bundesland);
        name.append(")");
        return name.toString();
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BundeslandEnum getBundesland() {
        return bundesland;
    }

    public void setBundesland(BundeslandEnum bundesland) {
        this.bundesland = bundesland;
    }

    public String getBundeslandLang() {
        return bundeslandLang;
    }

    public void setBundeslandLang(String bundeslandLang) {
        this.bundeslandLang = bundeslandLang;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie != null){
            this.onlineStrategie = onlineStrategie;
        }
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

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

    public Strukturdaten getStrukturdaten() {
        return strukturdaten;
    }

    public void setStrukturdaten(Strukturdaten strukturdaten) {
        if(strukturdaten != null){
            this.strukturdaten = strukturdaten;
        }
    }

    public WahlergebnisseBtw17 getWahlergebnisseBtw17() {
        return wahlergebnisseBtw17;
    }

    public void setWahlergebnisseBtw17(WahlergebnisseBtw17 wahlergebnisseBtw17) {
        if(wahlergebnisseBtw17!=null){
            this.wahlergebnisseBtw17 = wahlergebnisseBtw17;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bundesland)) return false;

        Bundesland that = (Bundesland) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bundesland != null ? !bundesland.equals(that.bundesland) : that.bundesland != null) return false;
        if (bundeslandLang != null ? !bundeslandLang.equals(that.bundeslandLang) : that.bundeslandLang != null)
            return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        if (commonFields != null ? !commonFields.equals(that.commonFields) : that.commonFields != null) return false;
        return webseite != null ? webseite.equals(that.webseite) : that.webseite == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (bundeslandLang != null ? bundeslandLang.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BundeslandEnum{" +
                "id=" + id +
                ", bundesland='" + bundesland + '\'' +
                ", bundeslandLang='" + bundeslandLang + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", commonFields=" + commonFields +
                ", webseite=" + webseite +
                '}';
    }
}
