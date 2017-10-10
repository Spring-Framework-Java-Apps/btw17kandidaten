package org.woehlke.btw17.kandidaten.oodm.model;


import org.woehlke.btw17.kandidaten.oodm.model.listener.WahlperiodeListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;
import org.woehlke.btw17.kandidaten.oodm.model.parts.Institution;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(
    name = "wahlperiode"
)
@NamedQueries({
    @NamedQuery(
        name = "Wahlperiode.getAllIds",
        query = "select o.id from Wahlperiode as o order by o.wahlperiode"
    ),
    @NamedQuery(
        name = "Wahlperiode.getMaxId",
        query = "select max(o.id) from Wahlperiode as o"
    )
})
@EntityListeners(WahlperiodeListener.class)
public class Wahlperiode implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "wp")
    private Long wahlperiode;

    @Column(name = "mdbwpvon")
    private String mdbWahlperiodeVon;

    @Column(name = "mdbwpbis")
    private String mdbWahlperiodeBis;

    @Column(name = "liste")
    private String liste;

    @Column(name = "mandatsart")
    private String mandatsArt;

    @Deprecated
    @Column(name = "wkrnummer")
    private String wkrummer;

    @Deprecated
    @Column(name = "wkrname")
    private String wkrname;

    @Deprecated
    @Column(name = "wkrland")
    private String wkrland;

    @ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fk_wahlkreis")
    private Wahlkreis wahlkreis;

    @Valid
    @Embedded
    private Institution institution = new Institution();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wkrname;
    }

    @Override
    public String getUniqueId() {
        return wahlperiode.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWahlperiode() {
        return wahlperiode;
    }

    public void setWahlperiode(Long wahlperiode) {
        this.wahlperiode = wahlperiode;
    }

    public String getMdbWahlperiodeVon() {
        return mdbWahlperiodeVon;
    }

    public void setMdbWahlperiodeVon(String mdbWahlperiodeVon) {
        this.mdbWahlperiodeVon = mdbWahlperiodeVon;
    }

    public String getMdbWahlperiodeBis() {
        return mdbWahlperiodeBis;
    }

    public void setMdbWahlperiodeBis(String mdbWahlperiodeBis) {
        this.mdbWahlperiodeBis = mdbWahlperiodeBis;
    }

    public String getListe() {
        return liste;
    }

    public void setListe(String liste) {
        this.liste = liste;
    }

    public String getMandatsArt() {
        return mandatsArt;
    }

    public void setMandatsArt(String mandatsArt) {
        this.mandatsArt = mandatsArt;
    }

    public String getWkrummer() {
        return wkrummer;
    }

    public void setWkrummer(String wkrummer) {
        this.wkrummer = wkrummer;
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

    public Wahlkreis getWahlkreis() {
        return wahlkreis;
    }

    public void setWahlkreis(Wahlkreis wahlkreis) {
        this.wahlkreis = wahlkreis;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wahlperiode)) return false;

        Wahlperiode that = (Wahlperiode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (wahlperiode != null ? !wahlperiode.equals(that.wahlperiode) : that.wahlperiode != null) return false;
        if (mdbWahlperiodeVon != null ? !mdbWahlperiodeVon.equals(that.mdbWahlperiodeVon) : that.mdbWahlperiodeVon != null)
            return false;
        if (mdbWahlperiodeBis != null ? !mdbWahlperiodeBis.equals(that.mdbWahlperiodeBis) : that.mdbWahlperiodeBis != null)
            return false;
        if (liste != null ? !liste.equals(that.liste) : that.liste != null) return false;
        if (mandatsArt != null ? !mandatsArt.equals(that.mandatsArt) : that.mandatsArt != null) return false;
        if (wkrummer != null ? !wkrummer.equals(that.wkrummer) : that.wkrummer != null) return false;
        if (wkrname != null ? !wkrname.equals(that.wkrname) : that.wkrname != null) return false;
        if (wkrland != null ? !wkrland.equals(that.wkrland) : that.wkrland != null) return false;
        if (wahlkreis != null ? !wahlkreis.equals(that.wahlkreis) : that.wahlkreis != null) return false;
        return institution != null ? institution.equals(that.institution) : that.institution == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wahlperiode != null ? wahlperiode.hashCode() : 0);
        result = 31 * result + (mdbWahlperiodeVon != null ? mdbWahlperiodeVon.hashCode() : 0);
        result = 31 * result + (mdbWahlperiodeBis != null ? mdbWahlperiodeBis.hashCode() : 0);
        result = 31 * result + (liste != null ? liste.hashCode() : 0);
        result = 31 * result + (mandatsArt != null ? mandatsArt.hashCode() : 0);
        result = 31 * result + (wkrummer != null ? wkrummer.hashCode() : 0);
        result = 31 * result + (wkrname != null ? wkrname.hashCode() : 0);
        result = 31 * result + (wkrland != null ? wkrland.hashCode() : 0);
        result = 31 * result + (wahlkreis != null ? wahlkreis.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wahlperiode{" +
                "id=" + id +
                ", wahlperiode='" + wahlperiode + '\'' +
                ", mdbWahlperiodeVon='" + mdbWahlperiodeVon + '\'' +
                ", mdbWahlperiodeBis='" + mdbWahlperiodeBis + '\'' +
                ", liste='" + liste + '\'' +
                ", mandatsArt='" + mandatsArt + '\'' +
                ", wkrummer='" + wkrummer + '\'' +
                ", wkrname='" + wkrname + '\'' +
                ", wkrland='" + wkrland + '\'' +
                ", wahlkreis=" + wahlkreis +
                ", institution=" + institution +
                '}';
    }
}
