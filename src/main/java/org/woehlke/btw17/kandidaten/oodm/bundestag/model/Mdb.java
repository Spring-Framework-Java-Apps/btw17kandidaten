package org.woehlke.btw17.kandidaten.oodm.bundestag.model;

import org.woehlke.btw17.kandidaten.oodm.bundestag.model.listener.MdbListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "btw17_mdb_stammdaten"/*,
        uniqueConstraints = {
                @UniqueConstraint(name="uk_btw17_ergebnis", columnNames = {"wahlkreis_nummer","bundesland_nummer"})
        },
        indexes = {
                @Index(name = "idx_btw17_ergebnis_wahlkreis_name", columnList = "wahlkreis_name")
        }*/
)
@NamedQueries({
        @NamedQuery(
                name = "Mdb.getAllIds",
                query = "select o.id from Mdb as o order by o.parteikurz,o.nachname"
        )
})
@EntityListeners(MdbListener.class)
public class Mdb implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String xmlId;

    @Column
    protected String nachname;
    @Column
    protected String vorname;
    @Column
    protected String ortszusatz;
    @Column
    protected String adel;
    @Column
    protected String praefix;
    @Column
    protected String anredetitel;
    @Column
    protected String akadtitel;
    @Column
    protected String historievon;
    @Column
    protected String historiebis;

    @Column
    protected String geburtsdatum;
    @Column
    protected String geburtsort;
    @Column
    protected String geburtsland;
    @Column
    protected String sterbedatum;
    @Column
    protected String geschlecht;
    @Column
    protected String familienstand;
    @Column
    protected String religion;
    @Column
    protected String beruf;
    @Column
    protected String parteikurz;
    @Column(name="vitakurz",columnDefinition = "TEXT")
    protected String vitakurz;
    @Column(name="veroeffentlichungspflichtiges",columnDefinition = "TEXT")
    protected String veroeffentlichungspflichtiges;

    @OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name="wahlperioden_mdb_id")
    List<Wahlperiode> wahlperioden = new ArrayList<>();

    @Override
    public String getName() {
        return vorname+ " "+nachname+" ("+parteikurz+")";
    }

    @Override
    public String getUniqueId() {
        return xmlId;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getOrtszusatz() {
        return ortszusatz;
    }

    public void setOrtszusatz(String ortszusatz) {
        this.ortszusatz = ortszusatz;
    }

    public String getAdel() {
        return adel;
    }

    public void setAdel(String adel) {
        this.adel = adel;
    }

    public String getPraefix() {
        return praefix;
    }

    public void setPraefix(String praefix) {
        this.praefix = praefix;
    }

    public String getAnredetitel() {
        return anredetitel;
    }

    public void setAnredetitel(String anredetitel) {
        this.anredetitel = anredetitel;
    }

    public String getAkadtitel() {
        return akadtitel;
    }

    public void setAkadtitel(String akadtitel) {
        this.akadtitel = akadtitel;
    }

    public String getHistorievon() {
        return historievon;
    }

    public void setHistorievon(String historievon) {
        this.historievon = historievon;
    }

    public String getHistoriebis() {
        return historiebis;
    }

    public void setHistoriebis(String historiebis) {
        this.historiebis = historiebis;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public String getGeburtsland() {
        return geburtsland;
    }

    public void setGeburtsland(String geburtsland) {
        this.geburtsland = geburtsland;
    }

    public String getSterbedatum() {
        return sterbedatum;
    }

    public void setSterbedatum(String sterbedatum) {
        this.sterbedatum = sterbedatum;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getFamilienstand() {
        return familienstand;
    }

    public void setFamilienstand(String familienstand) {
        this.familienstand = familienstand;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public String getParteikurz() {
        return parteikurz;
    }

    public void setParteikurz(String parteikurz) {
        this.parteikurz = parteikurz;
    }

    public String getVitakurz() {
        return vitakurz;
    }

    public void setVitakurz(String vitakurz) {
        this.vitakurz = vitakurz;
    }

    public String getVeroeffentlichungspflichtiges() {
        return veroeffentlichungspflichtiges;
    }

    public void setVeroeffentlichungspflichtiges(String veroeffentlichungspflichtiges) {
        this.veroeffentlichungspflichtiges = veroeffentlichungspflichtiges;
    }

    public List<Wahlperiode> getWahlperioden() {
        return wahlperioden;
    }

    public void setWahlperioden(List<Wahlperiode> wahlperioden) {
        this.wahlperioden = wahlperioden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mdb)) return false;

        Mdb mdb = (Mdb) o;

        if (id != null ? !id.equals(mdb.id) : mdb.id != null) return false;
        if (xmlId != null ? !xmlId.equals(mdb.xmlId) : mdb.xmlId != null) return false;
        if (nachname != null ? !nachname.equals(mdb.nachname) : mdb.nachname != null) return false;
        if (vorname != null ? !vorname.equals(mdb.vorname) : mdb.vorname != null) return false;
        if (ortszusatz != null ? !ortszusatz.equals(mdb.ortszusatz) : mdb.ortszusatz != null) return false;
        if (adel != null ? !adel.equals(mdb.adel) : mdb.adel != null) return false;
        if (praefix != null ? !praefix.equals(mdb.praefix) : mdb.praefix != null) return false;
        if (anredetitel != null ? !anredetitel.equals(mdb.anredetitel) : mdb.anredetitel != null) return false;
        if (akadtitel != null ? !akadtitel.equals(mdb.akadtitel) : mdb.akadtitel != null) return false;
        if (historievon != null ? !historievon.equals(mdb.historievon) : mdb.historievon != null) return false;
        if (historiebis != null ? !historiebis.equals(mdb.historiebis) : mdb.historiebis != null) return false;
        if (geburtsdatum != null ? !geburtsdatum.equals(mdb.geburtsdatum) : mdb.geburtsdatum != null) return false;
        if (geburtsort != null ? !geburtsort.equals(mdb.geburtsort) : mdb.geburtsort != null) return false;
        if (geburtsland != null ? !geburtsland.equals(mdb.geburtsland) : mdb.geburtsland != null) return false;
        if (sterbedatum != null ? !sterbedatum.equals(mdb.sterbedatum) : mdb.sterbedatum != null) return false;
        if (geschlecht != null ? !geschlecht.equals(mdb.geschlecht) : mdb.geschlecht != null) return false;
        if (familienstand != null ? !familienstand.equals(mdb.familienstand) : mdb.familienstand != null) return false;
        if (religion != null ? !religion.equals(mdb.religion) : mdb.religion != null) return false;
        if (beruf != null ? !beruf.equals(mdb.beruf) : mdb.beruf != null) return false;
        if (parteikurz != null ? !parteikurz.equals(mdb.parteikurz) : mdb.parteikurz != null) return false;
        if (vitakurz != null ? !vitakurz.equals(mdb.vitakurz) : mdb.vitakurz != null) return false;
        if (veroeffentlichungspflichtiges != null ? !veroeffentlichungspflichtiges.equals(mdb.veroeffentlichungspflichtiges) : mdb.veroeffentlichungspflichtiges != null)
            return false;
        return wahlperioden != null ? wahlperioden.equals(mdb.wahlperioden) : mdb.wahlperioden == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (xmlId != null ? xmlId.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (ortszusatz != null ? ortszusatz.hashCode() : 0);
        result = 31 * result + (adel != null ? adel.hashCode() : 0);
        result = 31 * result + (praefix != null ? praefix.hashCode() : 0);
        result = 31 * result + (anredetitel != null ? anredetitel.hashCode() : 0);
        result = 31 * result + (akadtitel != null ? akadtitel.hashCode() : 0);
        result = 31 * result + (historievon != null ? historievon.hashCode() : 0);
        result = 31 * result + (historiebis != null ? historiebis.hashCode() : 0);
        result = 31 * result + (geburtsdatum != null ? geburtsdatum.hashCode() : 0);
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (geburtsland != null ? geburtsland.hashCode() : 0);
        result = 31 * result + (sterbedatum != null ? sterbedatum.hashCode() : 0);
        result = 31 * result + (geschlecht != null ? geschlecht.hashCode() : 0);
        result = 31 * result + (familienstand != null ? familienstand.hashCode() : 0);
        result = 31 * result + (religion != null ? religion.hashCode() : 0);
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        result = 31 * result + (parteikurz != null ? parteikurz.hashCode() : 0);
        result = 31 * result + (vitakurz != null ? vitakurz.hashCode() : 0);
        result = 31 * result + (veroeffentlichungspflichtiges != null ? veroeffentlichungspflichtiges.hashCode() : 0);
        result = 31 * result + (wahlperioden != null ? wahlperioden.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mdb{" +
                "id=" + id +
                ", xmlId='" + xmlId + '\'' +
                ", nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", ortszusatz='" + ortszusatz + '\'' +
                ", adel='" + adel + '\'' +
                ", praefix='" + praefix + '\'' +
                ", anredetitel='" + anredetitel + '\'' +
                ", akadtitel='" + akadtitel + '\'' +
                ", historievon='" + historievon + '\'' +
                ", historiebis='" + historiebis + '\'' +
                ", geburtsdatum='" + geburtsdatum + '\'' +
                ", geburtsort='" + geburtsort + '\'' +
                ", geburtsland='" + geburtsland + '\'' +
                ", sterbedatum='" + sterbedatum + '\'' +
                ", geschlecht='" + geschlecht + '\'' +
                ", familienstand='" + familienstand + '\'' +
                ", religion='" + religion + '\'' +
                ", beruf='" + beruf + '\'' +
                ", parteikurz='" + parteikurz + '\'' +
                ", vitakurz='" + vitakurz + '\'' +
                ", veroeffentlichungspflichtiges='" + veroeffentlichungspflichtiges + '\'' +
                ", wahlperioden=" + wahlperioden +
                '}';
    }
}
