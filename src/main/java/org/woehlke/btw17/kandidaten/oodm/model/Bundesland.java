package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;


@Entity
@Table(
    name = "bundesland",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_bundesland",columnNames = {"bundesland"})
    },
    indexes = {
        @Index(name = "idx_bundesland_bundesland_lang", columnList = "bundesland_lang")
    }
)
public class Bundesland implements KandidatFacette,OnlineStrategieEmbedded,CommonFieldsEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String bundesland;

    @Column(name="bundesland_lang",nullable = false)
    private String bundeslandLang;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields dimensionFacetten = new CommonFields();

    @Transient
    public String getName(){
        StringBuffer name = new StringBuffer();
        name.append(bundeslandLang);
        name.append(" (");
        name.append(bundesland);
        name.append(")");
        return name.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
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
        this.onlineStrategie = onlineStrategie;
    }

    public CommonFields getDimensionFacetten() {
        return dimensionFacetten;
    }

    public void setDimensionFacetten(CommonFields dimensionFacetten) {
        this.dimensionFacetten = dimensionFacetten;
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
        return dimensionFacetten != null ? dimensionFacetten.equals(that.dimensionFacetten) : that.dimensionFacetten == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (bundeslandLang != null ? bundeslandLang.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (dimensionFacetten != null ? dimensionFacetten.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bundesland{" +
                "id=" + id +
                ", bundesland='" + bundesland + '\'' +
                ", bundeslandLang='" + bundeslandLang + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", dimensionFacetten=" + dimensionFacetten +
                '}';
    }
}
