package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.WAHLPERIODEN;

/**
 * Information ueber einen MDB
 */
@NodeEntity
public class Btw17Mdb extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="xml_id")
    private String xmlId;

    @Property(name="nachname")
    private String nachname;

    @Property(name="vorname")
    private String vorname;

    @Property(name="ortszusatz")
    private String ortszusatz;

    @Property(name="adel")
    private String adel;

    @Property(name="praefix")
    private String praefix;

    @Property(name="anrede_titel")
    private String anredetitel;

    @Property(name="akademischer_titel")
    private String akadtitel;

    @Property(name="historie_von")
    private String historievon;

    @Property(name="historie_bis")
    private String historiebis;

    @Property(name="geburts_datum")
    private String geburtsdatum;

    @Property(name="geburts_ort")
    private String geburtsort;

    @Property(name="geburts_land")
    private String geburtsland;

    @Property(name="sterbe_datum")
    private String sterbedatum;

    @Property(name="geschlecht")
    private String geschlecht;

    @Property(name="familienstand")
    private String familienstand;

    @Property(name="religion")
    private String religion;

    @Property(name="beruf")
    private String beruf;

    @Property(name="parteikurz")
    private String parteikurz;

    @Property(name="vitakurz")
    private String vitakurz;

    @Property(name="veroeffentlichungspflichtiges")
    private String veroeffentlichungspflichtiges;

    @Relationship(type = WAHLPERIODEN)
    private Set<Btw17Wahlperiode> wahlperioden = new LinkedHashSet<>();

    public String getTransientKey(){
        Locale locale = Locale.GERMANY;
        String titel = this.anredetitel;
        String vorname = this.vorname;
        String nachname = this.nachname;
        String namenszusatz = this.adel;
        String geschlecht = this.geschlecht;
        String geburtsort = this.geburtsort;
        String geburtsdatumStr = this.geburtsdatum;
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

    public Btw17Mdb() {
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

    public void setWahlperioden(Set<Btw17Wahlperiode> wahlperioden) {
        this.wahlperioden = wahlperioden;
    }
}
