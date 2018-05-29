package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.listener.Btw17MdbListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(
        name = "btw17_mdb_stammdaten"//,
        //schema = "public"//,
        //catalog = "information_//schema"
)
@NamedQueries({
    @NamedQuery(
        name = "Btw17Mdb.getAllIds",
        query = "select o.id from Btw17Mdb as o order by o.parteikurz,o.nachname"
    ),
    @NamedQuery(
        name = "Btw17Mdb.getMaxId",
        query = "select max(o.id) from Btw17Mdb as o"
    )
})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Btw17Mdb.countBtw17Mdb2Wahlperiode",
        query = "select count(*) from btw17_mdb_stammdaten_wahlperiode LEFT JOIN btw17_mdb_wahlperiode on btw17_mdb_stammdaten_wahlperiode.wahlperioden_id = btw17_mdb_wahlperiode.id where btw17_mdb_wahlperiode.wp in ('17', '18')"
    )
})
@EntityListeners(Btw17MdbListener.class)
public class Btw17Mdb implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String xmlId;

    @Column
    private String nachname;
    @Column
    private String vorname;
    @Column
    private String ortszusatz;
    @Column
    private String adel;
    @Column
    private String praefix;
    @Column
    private String anredetitel;
    @Column
    private String akadtitel;
    @Column
    private String historievon;
    @Column
    private String historiebis;

    @Column
    private String geburtsdatum;
    @Column
    private String geburtsort;
    @Column
    private String geburtsland;
    @Column
    private String sterbedatum;
    @Column
    private String geschlecht;
    @Column
    private String familienstand;
    @Column
    private String religion;
    @Column
    private String beruf;
    @Column
    private String parteikurz;

    @Lob
    @Column(name="vitakurz")
    private String vitakurz;

    @Lob
    @Column(name="veroeffentlichungspflichtiges")
    private String veroeffentlichungspflichtiges;

    @ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinTable(name="btw17_mdb_stammdaten_wahlperiode")
    private Set<Btw17Wahlperiode> wahlperioden = new LinkedHashSet<>();

    @Transient
    public String getTransientKey(){
        Locale locale = Locale.GERMANY;
        String titel = this.getAnredetitel();
        String vorname = this.getVorname();
        String nachname = this.getNachname();
        String namenszusatz = this.getAdel();
        String geschlecht = this.getGeschlecht();
        String geburtsort = this.getGeburtsort();
        String geburtsdatumStr = this.getGeburtsdatum();
        Integer geburtsjahr = Integer.parseInt(geburtsdatumStr.split("\\.")[2]);
        vorname = vorname.replaceAll("\\W","").toLowerCase(locale);
        nachname = nachname.replaceAll("\\W","").toLowerCase(locale);
        String newKandidatKey = vorname +"-"+nachname;
        if(namenszusatz!=null){
            namenszusatz = namenszusatz.replaceAll("\\W","").toLowerCase(locale);
            newKandidatKey =  namenszusatz +"-"+ newKandidatKey;
        }
        if(titel!=null){
            titel = titel.replaceAll("\\W","").toLowerCase(locale);
            newKandidatKey =  titel+"-"+ newKandidatKey;
        }
        if(geschlecht!=null){
            if(geschlecht.compareTo("männlich")==0){
                newKandidatKey = "herr-"+ newKandidatKey;
            }
            if(geschlecht.compareTo("weiblich")==0){
                newKandidatKey = "frau-"+ newKandidatKey;
            }
        }
        if(geburtsjahr != null){
            newKandidatKey = newKandidatKey +"-geboren-"+geburtsjahr;
        }
        if(geburtsort != null){
            geburtsort = geburtsort.replaceAll("\\W","").toLowerCase(locale);
            newKandidatKey = newKandidatKey +"-in-"+geburtsort;
        }
        return newKandidatKey;
    }

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

    public Set<Btw17Wahlperiode> getWahlperioden() {
        return wahlperioden;
    }


    public void addWahlperiode(Btw17Wahlperiode wahlperiode) {
        if(wahlperiode != null)
        this.wahlperioden.add(wahlperiode);
    }

    public void setWahlperioden(Set<Btw17Wahlperiode> wahlperioden) {
        this.wahlperioden = wahlperioden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Btw17Mdb)) return false;

        Btw17Mdb btw17Mdb = (Btw17Mdb) o;

        if (id != null ? !id.equals(btw17Mdb.id) : btw17Mdb.id != null) return false;
        if (xmlId != null ? !xmlId.equals(btw17Mdb.xmlId) : btw17Mdb.xmlId != null) return false;
        if (nachname != null ? !nachname.equals(btw17Mdb.nachname) : btw17Mdb.nachname != null) return false;
        if (vorname != null ? !vorname.equals(btw17Mdb.vorname) : btw17Mdb.vorname != null) return false;
        if (ortszusatz != null ? !ortszusatz.equals(btw17Mdb.ortszusatz) : btw17Mdb.ortszusatz != null) return false;
        if (adel != null ? !adel.equals(btw17Mdb.adel) : btw17Mdb.adel != null) return false;
        if (praefix != null ? !praefix.equals(btw17Mdb.praefix) : btw17Mdb.praefix != null) return false;
        if (anredetitel != null ? !anredetitel.equals(btw17Mdb.anredetitel) : btw17Mdb.anredetitel != null)
            return false;
        if (akadtitel != null ? !akadtitel.equals(btw17Mdb.akadtitel) : btw17Mdb.akadtitel != null) return false;
        if (historievon != null ? !historievon.equals(btw17Mdb.historievon) : btw17Mdb.historievon != null)
            return false;
        if (historiebis != null ? !historiebis.equals(btw17Mdb.historiebis) : btw17Mdb.historiebis != null)
            return false;
        if (geburtsdatum != null ? !geburtsdatum.equals(btw17Mdb.geburtsdatum) : btw17Mdb.geburtsdatum != null)
            return false;
        if (geburtsort != null ? !geburtsort.equals(btw17Mdb.geburtsort) : btw17Mdb.geburtsort != null) return false;
        if (geburtsland != null ? !geburtsland.equals(btw17Mdb.geburtsland) : btw17Mdb.geburtsland != null)
            return false;
        if (sterbedatum != null ? !sterbedatum.equals(btw17Mdb.sterbedatum) : btw17Mdb.sterbedatum != null)
            return false;
        if (geschlecht != null ? !geschlecht.equals(btw17Mdb.geschlecht) : btw17Mdb.geschlecht != null) return false;
        if (familienstand != null ? !familienstand.equals(btw17Mdb.familienstand) : btw17Mdb.familienstand != null)
            return false;
        if (religion != null ? !religion.equals(btw17Mdb.religion) : btw17Mdb.religion != null) return false;
        if (beruf != null ? !beruf.equals(btw17Mdb.beruf) : btw17Mdb.beruf != null) return false;
        if (parteikurz != null ? !parteikurz.equals(btw17Mdb.parteikurz) : btw17Mdb.parteikurz != null) return false;
        if (vitakurz != null ? !vitakurz.equals(btw17Mdb.vitakurz) : btw17Mdb.vitakurz != null) return false;
        if (veroeffentlichungspflichtiges != null ? !veroeffentlichungspflichtiges.equals(btw17Mdb.veroeffentlichungspflichtiges) : btw17Mdb.veroeffentlichungspflichtiges != null)
            return false;
        return wahlperioden != null ? wahlperioden.equals(btw17Mdb.wahlperioden) : btw17Mdb.wahlperioden == null;
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
        return "Btw17Mdb{" +
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
