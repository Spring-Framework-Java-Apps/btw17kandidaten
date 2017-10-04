package org.woehlke.btw17.kandidaten.oodm.bundestag.model;



import org.woehlke.btw17.kandidaten.oodm.bundestag.model.listener.WahlperiodeListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;

@Entity
@Table(
        name = "btw17_mdb_wahlperiode"
)
@NamedQueries({
        @NamedQuery(
                name = "Wahlperiode.getAllIds",
                query = "select o.id from Wahlperiode as o order by o.wp"
        )
})
@EntityListeners(WahlperiodeListener.class)
public class Wahlperiode implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected String wp;
    @Column
    protected String mdbwpvon;
    @Column
    protected String mdbwpbis;
    @Column
    protected String wkrnummer;
    @Column
    protected String wkrname;
    @Column
    protected String wkrland;
    @Column
    protected String liste;
    @Column
    protected String mandatsart;

    @Column
    protected String insartlang;
    @Column
    protected String inslang;
    @Column
    protected String mdbinsvon;
    @Column
    protected String mdbinsbis;
    @Column
    protected String fktlang;
    @Column
    protected String fktinsvon;
    @Column
    protected String fktinsbis;

    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wkrname;
    }

    @Override
    public String getUniqueId() {
        return wp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public String getMdbwpvon() {
        return mdbwpvon;
    }

    public void setMdbwpvon(String mdbwpvon) {
        this.mdbwpvon = mdbwpvon;
    }

    public String getMdbwpbis() {
        return mdbwpbis;
    }

    public void setMdbwpbis(String mdbwpbis) {
        this.mdbwpbis = mdbwpbis;
    }

    public String getWkrnummer() {
        return wkrnummer;
    }

    public void setWkrnummer(String wkrnummer) {
        this.wkrnummer = wkrnummer;
    }

    public String getWkrname() {
        return wkrname;
    }

    public void setWkrname(String wkrname) {
        this.wkrname = wkrname;
    }

    public String getWkrland() {
        return wkrland;
    }

    public void setWkrland(String wkrland) {
        this.wkrland = wkrland;
    }

    public String getListe() {
        return liste;
    }

    public void setListe(String liste) {
        this.liste = liste;
    }

    public String getMandatsart() {
        return mandatsart;
    }

    public void setMandatsart(String mandatsart) {
        this.mandatsart = mandatsart;
    }

    public String getInsartlang() {
        return insartlang;
    }

    public void setInsartlang(String insartlang) {
        this.insartlang = insartlang;
    }

    public String getInslang() {
        return inslang;
    }

    public void setInslang(String inslang) {
        this.inslang = inslang;
    }

    public String getMdbinsvon() {
        return mdbinsvon;
    }

    public void setMdbinsvon(String mdbinsvon) {
        this.mdbinsvon = mdbinsvon;
    }

    public String getMdbinsbis() {
        return mdbinsbis;
    }

    public void setMdbinsbis(String mdbinsbis) {
        this.mdbinsbis = mdbinsbis;
    }

    public String getFktlang() {
        return fktlang;
    }

    public void setFktlang(String fktlang) {
        this.fktlang = fktlang;
    }

    public String getFktinsvon() {
        return fktinsvon;
    }

    public void setFktinsvon(String fktinsvon) {
        this.fktinsvon = fktinsvon;
    }

    public String getFktinsbis() {
        return fktinsbis;
    }

    public void setFktinsbis(String fktinsbis) {
        this.fktinsbis = fktinsbis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wahlperiode)) return false;

        Wahlperiode that = (Wahlperiode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (wp != null ? !wp.equals(that.wp) : that.wp != null) return false;
        if (mdbwpvon != null ? !mdbwpvon.equals(that.mdbwpvon) : that.mdbwpvon != null) return false;
        if (mdbwpbis != null ? !mdbwpbis.equals(that.mdbwpbis) : that.mdbwpbis != null) return false;
        if (wkrnummer != null ? !wkrnummer.equals(that.wkrnummer) : that.wkrnummer != null) return false;
        if (wkrname != null ? !wkrname.equals(that.wkrname) : that.wkrname != null) return false;
        if (wkrland != null ? !wkrland.equals(that.wkrland) : that.wkrland != null) return false;
        if (liste != null ? !liste.equals(that.liste) : that.liste != null) return false;
        if (mandatsart != null ? !mandatsart.equals(that.mandatsart) : that.mandatsart != null) return false;
        if (insartlang != null ? !insartlang.equals(that.insartlang) : that.insartlang != null) return false;
        if (inslang != null ? !inslang.equals(that.inslang) : that.inslang != null) return false;
        if (mdbinsvon != null ? !mdbinsvon.equals(that.mdbinsvon) : that.mdbinsvon != null) return false;
        if (mdbinsbis != null ? !mdbinsbis.equals(that.mdbinsbis) : that.mdbinsbis != null) return false;
        if (fktlang != null ? !fktlang.equals(that.fktlang) : that.fktlang != null) return false;
        if (fktinsvon != null ? !fktinsvon.equals(that.fktinsvon) : that.fktinsvon != null) return false;
        return fktinsbis != null ? fktinsbis.equals(that.fktinsbis) : that.fktinsbis == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wp != null ? wp.hashCode() : 0);
        result = 31 * result + (mdbwpvon != null ? mdbwpvon.hashCode() : 0);
        result = 31 * result + (mdbwpbis != null ? mdbwpbis.hashCode() : 0);
        result = 31 * result + (wkrnummer != null ? wkrnummer.hashCode() : 0);
        result = 31 * result + (wkrname != null ? wkrname.hashCode() : 0);
        result = 31 * result + (wkrland != null ? wkrland.hashCode() : 0);
        result = 31 * result + (liste != null ? liste.hashCode() : 0);
        result = 31 * result + (mandatsart != null ? mandatsart.hashCode() : 0);
        result = 31 * result + (insartlang != null ? insartlang.hashCode() : 0);
        result = 31 * result + (inslang != null ? inslang.hashCode() : 0);
        result = 31 * result + (mdbinsvon != null ? mdbinsvon.hashCode() : 0);
        result = 31 * result + (mdbinsbis != null ? mdbinsbis.hashCode() : 0);
        result = 31 * result + (fktlang != null ? fktlang.hashCode() : 0);
        result = 31 * result + (fktinsvon != null ? fktinsvon.hashCode() : 0);
        result = 31 * result + (fktinsbis != null ? fktinsbis.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wahlperiode{" +
                "id=" + id +
                ", wp='" + wp + '\'' +
                ", mdbwpvon='" + mdbwpvon + '\'' +
                ", mdbwpbis='" + mdbwpbis + '\'' +
                ", wkrnummer='" + wkrnummer + '\'' +
                ", wkrname='" + wkrname + '\'' +
                ", wkrland='" + wkrland + '\'' +
                ", liste='" + liste + '\'' +
                ", mandatsart='" + mandatsart + '\'' +
                ", insartlang='" + insartlang + '\'' +
                ", inslang='" + inslang + '\'' +
                ", mdbinsvon='" + mdbinsvon + '\'' +
                ", mdbinsbis='" + mdbinsbis + '\'' +
                ", fktlang='" + fktlang + '\'' +
                ", fktinsvon='" + fktinsvon + '\'' +
                ", fktinsbis='" + fktinsbis + '\'' +
                '}';
    }
}
