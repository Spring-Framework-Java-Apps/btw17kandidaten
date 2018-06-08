package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.constraints.NotNull;
import java.util.Locale;


@NodeEntity
public class Btw17KandidatFlat extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="kandidat_key")
    private String key;

    @Property(name="titel")
    private String titel;

    @Property(name="namenszusatz")
    private String namenszusatz;

    @Property(name="nachname_ohne")
    private String nachnameOhne;

    @Property(name="nachname")
    private String nachname;

    @Property(name="vorname")
    private String vorname;

    @Property(name="geschlecht")
    private String geschlecht;

    @Property(name="geburtsjahr")
    private Integer geburtsjahr;

    @Property(name="alter")
    private Integer alter;

    @Property(name="wohnort")
    private String wohnort;

    @Property(name="geburtsort")
    private String geburtsort;

    @Property(name="beruf")
    private String beruf;

    @Property(name="berufsgruppe")
    private String berufsgruppe;

    @NotNull
    //@Enumerated(EnumType.STRING)
    @Property(name = "bundesland")
    private BundeslandEnum bundesland;

    @Property(name="wahlkreis_id")
    private Integer wahlkreisId;

    @Property(name="wahlkreis_name")
    private String wahlkreisName;

    @Property(name="partei")
    private String partei;

    @Property(name="partei_lang")
    private String parteiLang;

    @Property(name="liste_bundesland_land")
    private String listeBundeslandLand;

    @Property(name="liste_partei")
    private String listePartei;

    @Property(name="liste_partei_lang")
    private String listeParteiLang;

    @Property(name="liste_platz")
    private Integer listePlatz;

    @Property(name="mdb")
    private String mdb;

    @Property(name="lat")
    private Double lat;

    @Property(name="lng")
    private Double lng;

    @Property(name="id_eigen")
    private String idEigen;

    @Property(name="foto")
    private String foto;

    @Property(name="scatter_x")
    private Double scatterX;

    @Property(name="scatter_y")
    private Double scatterY;

    @Property(name="color")
    private String color;

    //@Transient
    public String getName() {
        return getTransientKey();
    }

    //@Transient
    @Override
    public String getUniqueId() {
        return this.getTransientKey()+":"+this.vorname+" "+this.nachname+ ":"+getId();
    }

    //@Transient
    public String getTransientKey(){
        Locale locale = Locale.GERMANY;
        String titel = this.titel;
        String vorname = this.vorname;
        String nachname = this.nachname;
        String namenszusatz = this.namenszusatz;
        String geschlecht = this.geschlecht;
        String geburtsort = this.geburtsort;
        Integer geburtsjahr = this.geburtsjahr;
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
            if(geschlecht.compareTo("M")==0){
                newKandidatKey = "herr-"+ newKandidatKey;
            }
            if(geschlecht.compareTo("W")==0){
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

    public Btw17KandidatFlat() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getNamenszusatz() {
        return namenszusatz;
    }

    public void setNamenszusatz(String namenszusatz) {
        this.namenszusatz = namenszusatz;
    }

    public String getNachnameOhne() {
        return nachnameOhne;
    }

    public void setNachnameOhne(String nachnameOhne) {
        this.nachnameOhne = nachnameOhne;
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

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public Integer getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(Integer geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public String getBerufsgruppe() {
        return berufsgruppe;
    }

    public void setBerufsgruppe(String berufsgruppe) {
        this.berufsgruppe = berufsgruppe;
    }

    public BundeslandEnum getBundesland() {
        return bundesland;
    }

    public void setBundesland(BundeslandEnum bundesland) {
        this.bundesland = bundesland;
    }

    public Integer getWahlkreisId() {
        return wahlkreisId;
    }

    public void setWahlkreisId(Integer wahlkreisId) {
        this.wahlkreisId = wahlkreisId;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
    }

    public String getPartei() {
        return partei;
    }

    public void setPartei(String partei) {
        this.partei = partei;
    }

    public String getParteiLang() {
        return parteiLang;
    }

    public void setParteiLang(String parteiLang) {
        this.parteiLang = parteiLang;
    }

    public String getListeBundeslandLand() {
        return listeBundeslandLand;
    }

    public void setListeBundeslandLand(String listeBundeslandLand) {
        this.listeBundeslandLand = listeBundeslandLand;
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

    public Integer getListePlatz() {
        return listePlatz;
    }

    public void setListePlatz(Integer listePlatz) {
        this.listePlatz = listePlatz;
    }

    public String getMdb() {
        return mdb;
    }

    public void setMdb(String mdb) {
        this.mdb = mdb;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getIdEigen() {
        return idEigen;
    }

    public void setIdEigen(String idEigen) {
        this.idEigen = idEigen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getScatterX() {
        return scatterX;
    }

    public void setScatterX(Double scatterX) {
        this.scatterX = scatterX;
    }

    public Double getScatterY() {
        return scatterY;
    }

    public void setScatterY(Double scatterY) {
        this.scatterY = scatterY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
