package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Partei;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.Religion;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Ort;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Beruf;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@NodeEntity
public class Kandidat extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    //@Pattern(regexp="herr|frau-[a-z]*[-]?[a-z]+-[a-z]+-geboren-[0-9]{4}-in-[a-z]+")
    @Property(name = "kandidat_key")
    private String key;

    @Property(name = "remote_kandidat_key")
    private String remoteKey;

    @Index(unique=true)
    @Property(name = "xml_id_bundestag")
    private String xmlIdBundestag;

    @Property(name = "titel")
    private String titel;

    @Property(name = "namenszusatz")
    private String namenszusatz;

    //@SafeHtml
    @Property(name = "nachname_ohne")
    private String nachnameOhne;

    //@NotNull
    //@SafeHtml
    @Property(name = "nachname")
    private String nachname;

    //@NotNull
    //@SafeHtml
    @Property(name = "vorname")
    private String vorname;

    //@NotNull
    //@Pattern(regexp = "[MW]{1}")
    @Property(name = "geschlecht")
    private String geschlecht;

    @Property(name = "geburtsjahr")
    private Integer geburtsjahr;

    @Property(name = "ortszusatz")
    private String ortszusatz;

    @Property(name = "adel")
    private String adel;

    @Property(name = "praefix")
    private String praefix;

    @Property(name = "anredetitel")
    private String anredeTitel;

    @Property(name = "akadtitel")
    private String akademischeTitel;

    @Property(name = "historievon")
    private LocalDate historieVon;

    @Property(name = "historiebis")
    private LocalDate historieBis;

    @Property(name = "alter")
    private Integer alter;

    @Property(name = "geburtsdatum")
    private LocalDate geburtsdatum;

    @Property(name = "sterbedatum")
    private LocalDate sterbedatum;

    @Property(name = "familienstand")
    private String familienstand;

    @Property(name = "religion")
    private Religion religion;

    @Property(name = "parteikurz")
    private String parteikurz;

    @Property(name = "vitakurz")
    private String vitakurz;

    @Property(name = "veroeffentlichungspflichtiges")
    private String veroeffentlichungspflichtiges;

    @Property(name = "funktion")
    private String funktion;

    @Property(name = "mdb")
    private String mdb;

    @Property(name = "mdb_neu")
    private Boolean mdbNeu;

    @Property(name = "mdb17")
    private Boolean mdb17;

    @Property(name = "mdb18")
    private Boolean mdb18;

    @Property(name = "lat")
    private Double lat;

    @Property(name = "lng")
    private Double lng;

    @Property(name = "id_eigen")
    private String idEigen;

    @Property(name = "foto")
    private String foto;

    //@URL
    @Property(name = "foto_url")
    private String fotoUrl;

    @Property(name = "scatter_x")
    private Double scatterX;

    @Property(name = "scatter_y")
    private Double scatterY;

    @Property(name = "color")
    private String color;

    //@URL
    @Property(name = "google_maps_url")
    private String googleMapsUrl;

    @Property(name = "liste_platz")
    private Integer listePlatz;

    @Relationship(type = WOHN_ORT)
    private Ort wohnort = new Ort();

    @Relationship(type = GEBURTS_ORT)
    private Ort geburtsort = new Ort();

    @Relationship(type = JOB)
    private Beruf beruf = new Beruf();

    @Relationship(type = JOB)
    private Berufsgruppe berufsgruppe = new Berufsgruppe();

    @Relationship(type = JOB)
    private Wahlkreis wahlkreis = new Wahlkreis();

    @Relationship(type = JOB)
    private Partei partei = new Partei();

    //@Relationship(type = JOB)
    //private ListeParteiBundesland listeParteiBundesland = new ListeParteiBundesland();

    @Relationship(type = JOB)
    private Fraktion fraktion = new Fraktion();

    @Relationship(type = JOB)
    private Set<Ministerium> ministerien = new LinkedHashSet<>();

    @Relationship(type = JOB)
    private Set<Ausschuss> ausschuesse = new LinkedHashSet<>();

    @Relationship(type = ZEIT)
    private Set<Wahlperiode> wahlperioden = new LinkedHashSet<>();

    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

    @Relationship(type=PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type=LOCATION)
    private Adresse adresse = new Adresse();

    @Property(name = "btw17_kandidat_flat_id")
    private Long btw17KandidatFlatId;

    @Property(name = "btw17_mdb_stammdaten_id")
    private Long btw17MdbId;

    @Property(name = "btw17wahlbewerber_id")
    private Long btw17WahlbewerberId;

    @Override
    public String getName() {
        return vorname + " " + nachname;
    }

    public Kandidat() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRemoteKey() {
        return remoteKey;
    }

    public void setRemoteKey(String remoteKey) {
        this.remoteKey = remoteKey;
    }

    public String getXmlIdBundestag() {
        return xmlIdBundestag;
    }

    public void setXmlIdBundestag(String xmlIdBundestag) {
        this.xmlIdBundestag = xmlIdBundestag;
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

    public String getAnredeTitel() {
        return anredeTitel;
    }

    public void setAnredeTitel(String anredeTitel) {
        this.anredeTitel = anredeTitel;
    }

    public String getAkademischeTitel() {
        return akademischeTitel;
    }

    public void setAkademischeTitel(String akademischeTitel) {
        this.akademischeTitel = akademischeTitel;
    }

    public LocalDate getHistorieVon() {
        return historieVon;
    }

    public void setHistorieVon(LocalDate historieVon) {
        this.historieVon = historieVon;
    }

    public LocalDate getHistorieBis() {
        return historieBis;
    }

    public void setHistorieBis(LocalDate historieBis) {
        this.historieBis = historieBis;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public LocalDate getSterbedatum() {
        return sterbedatum;
    }

    public void setSterbedatum(LocalDate sterbedatum) {
        this.sterbedatum = sterbedatum;
    }

    public String getFamilienstand() {
        return familienstand;
    }

    public void setFamilienstand(String familienstand) {
        this.familienstand = familienstand;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
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

    public String getFunktion() {
        return funktion;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    public String getMdb() {
        return mdb;
    }

    public void setMdb(String mdb) {
        this.mdb = mdb;
    }

    public Boolean getMdbNeu() {
        return mdbNeu;
    }

    public void setMdbNeu(Boolean mdbNeu) {
        this.mdbNeu = mdbNeu;
    }

    public Boolean getMdb17() {
        return mdb17;
    }

    public void setMdb17(Boolean mdb17) {
        this.mdb17 = mdb17;
    }

    public Boolean getMdb18() {
        return mdb18;
    }

    public void setMdb18(Boolean mdb18) {
        this.mdb18 = mdb18;
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

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
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

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public Integer getListePlatz() {
        return listePlatz;
    }

    public void setListePlatz(Integer listePlatz) {
        this.listePlatz = listePlatz;
    }

    public Ort getWohnort() {
        return wohnort;
    }

    public void setWohnort(Ort wohnort) {
        this.wohnort = wohnort;
    }

    public Ort getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(Ort geburtsort) {
        this.geburtsort = geburtsort;
    }

    public Beruf getBeruf() {
        return beruf;
    }

    public void setBeruf(Beruf beruf) {
        this.beruf = beruf;
    }

    public Berufsgruppe getBerufsgruppe() {
        return berufsgruppe;
    }

    public void setBerufsgruppe(Berufsgruppe berufsgruppe) {
        this.berufsgruppe = berufsgruppe;
    }

    public Wahlkreis getWahlkreis() {
        return wahlkreis;
    }

    public void setWahlkreis(Wahlkreis wahlkreis) {
        this.wahlkreis = wahlkreis;
    }

    public Partei getPartei() {
        return partei;
    }

    public void setPartei(Partei partei) {
        this.partei = partei;
    }

    public Fraktion getFraktion() {
        return fraktion;
    }

    public void setFraktion(Fraktion fraktion) {
        this.fraktion = fraktion;
    }

    public Set<Ministerium> getMinisterien() {
        return ministerien;
    }

    public void setMinisterien(Set<Ministerium> ministerien) {
        this.ministerien = ministerien;
    }

    public Set<Ausschuss> getAusschuesse() {
        return ausschuesse;
    }

    public void setAusschuesse(Set<Ausschuss> ausschuesse) {
        this.ausschuesse = ausschuesse;
    }

    public Set<Wahlperiode> getWahlperioden() {
        return wahlperioden;
    }

    public void setWahlperioden(Set<Wahlperiode> wahlperioden) {
        this.wahlperioden = wahlperioden;
    }

    public Webseite getWebseite() {
        return webseite;
    }

    public void setWebseite(Webseite webseite) {
        this.webseite = webseite;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Long getBtw17KandidatFlatId() {
        return btw17KandidatFlatId;
    }

    public void setBtw17KandidatFlatId(Long btw17KandidatFlatId) {
        this.btw17KandidatFlatId = btw17KandidatFlatId;
    }

    public Long getBtw17MdbId() {
        return btw17MdbId;
    }

    public void setBtw17MdbId(Long btw17MdbId) {
        this.btw17MdbId = btw17MdbId;
    }

    public Long getBtw17WahlbewerberId() {
        return btw17WahlbewerberId;
    }

    public void setBtw17WahlbewerberId(Long btw17WahlbewerberId) {
        this.btw17WahlbewerberId = btw17WahlbewerberId;
    }
}
