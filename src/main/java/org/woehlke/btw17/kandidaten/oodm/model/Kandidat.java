package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "kandidat",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_kandidat",columnNames = {"kandidat_key"})
    },
    indexes = {
        @Index(name = "idx_kandidat_remote_kandidat_key", columnList = "remote_kandidat_key"),
        @Index(name = "idx_kandidat_titel", columnList = "titel"),
        @Index(name = "idx_kandidat_namenszusatz", columnList = "namenszusatz"),
        @Index(name = "idx_kandidat_nachname_ohne", columnList = "nachname_ohne"),
        @Index(name = "idx_kandidat_nachname", columnList = "nachname"),
        @Index(name = "idx_kandidat_geschlecht", columnList = "geschlecht"),
        @Index(name = "idx_kandidat_geburtsjahr", columnList = "geburtsjahr"),
        @Index(name = "idx_kandidat_alter", columnList = "alter"),
        @Index(name = "idx_kandidat_liste_platz", columnList = "liste_platz"),
        @Index(name = "idx_kandidat_mdb", columnList = "mdb"),
        @Index(name = "idx_kandidat_id_eigen", columnList = "id_eigen"),
        @Index(name = "idx_kandidat_foto", columnList = "foto"),
        @Index(name = "idx_kandidat_webseite", columnList = "webseite"),
        @Index(name = "idx_kandidat_twitter", columnList = "twitter"),
        @Index(name = "idx_kandidat_facebook", columnList = "facebook"),
        @Index(name = "idx_kandidat_youtube", columnList = "youtube"),
        @Index(name = "idx_kandidat_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_kandidat_bundestag_abgeordnete", columnList = "bundestag_abgeordnete"),
        @Index(name = "idx_kandidat_abgeordnetenwatch", columnList = "abgeordnetenwatch"),
        @Index(name = "idx_kandidat_google_maps_url", columnList = "google_maps_url")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Kandidat.findByMdB",
        query = "select o from Kandidat as o where o.mdb is not null and o.mdb='1'"
    ),
    @NamedQuery(
        name = "Kandidat.findByGeburtsjahrAll",
        query = "select DISTINCT o.geburtsjahr from Kandidat as o where o.geburtsjahr is not null order by o.geburtsjahr"
    ),
    @NamedQuery(
        name = "Kandidat.findByListePartei",
        query = "select o from Kandidat as o where o.landesListe.listePartei=:listePartei"
    ),
    @NamedQuery(
        name = "Kandidat.findByKandidatFlatId",
        query = "select o from Kandidat as o where o.kandidatFlat.id=:kandidatFlatId"
    ),
    @NamedQuery(
        name = "Kandidat.getAll",
        query = "select o from Kandidat as o order by id"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutBundestagProfile",
        query = "select o from Kandidat as o where o.bundestagAbgeordnete is null and o.mdb is not null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutAbgeordnetenwatch",
        query = "select o from Kandidat as o where o.abgeordnetenwatch is null and o.mdb is not null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutWikipediaArticle",
        query = "select o from Kandidat as o where o.wikipediaArticle is null and o.mdb is not null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutWebseite",
        query = "select o from Kandidat as o where o.webseite is null and o.mdb is not null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutFacebook",
        query = "select o from Kandidat as o where o.facebook is null and o.mdb is not null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutTwitter",
        query = "select o from Kandidat as o where o.twitter is null and o.mdb is not null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutWebseite",
        query = "select o from Kandidat as o where o.webseite is null and o.mdb is null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutFacebook",
        query = "select o from Kandidat as o where o.facebook is null and o.mdb is null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutTwitter",
        query = "select o from Kandidat as o where o.twitter is null and o.mdb is null order by key"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutFotoUrl",
        query = "select o from Kandidat as o where o.fotoUrl is null order by key"
    )
})
public class Kandidat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "kandidat_key",nullable = false, unique = true)
    private String key;

    @Column(name = "remote_kandidat_key")
    private String remoteKey;

    @Column
    private String titel;

    @Column
    private String namenszusatz;

    @Column(name = "nachname_ohne")
    private String nachnameOhne;

    @Column
    private String nachname;

    @Column
    private String vorname;

    @Column
    private String geschlecht;

    @Column
    private Integer geburtsjahr;

    @Column
    private Integer alter;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_wohnort", nullable = true, updatable = false)
    private Wohnort wohnort;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_geburtsort", nullable = true, updatable = false)
    private Geburtsort geburtsort;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_beruf", nullable = true, updatable = false)
    private Beruf beruf;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_berufsgruppe", nullable = true, updatable = false)
    private Berufsgruppe berufsgruppe;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = true, updatable = false)
    private Bundesland bundesland;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_wahlkreis", nullable = true, updatable = false)
    private Wahlkreis wahlkreis;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_partei", nullable = true, updatable = false)
    private Partei partei;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_landes_liste", nullable = true, updatable = false)
    private LandesListe landesListe;

    @Column(name = "liste_platz")
    private Integer listePlatz;

    @Column
    private String mdb;

    @Column
    private Double lat;

    @Column
    private Double lng;

    @Column(name = "id_eigen")
    private String idEigen;

    @Column
    private String foto;

    @URL
    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(name = "scatter_x")
    private Double scatterX;

    @Column(name = "scatter_y")
    private Double scatterY;

    @Column
    private String color;

    @URL
    @Column
    private String webseite;

    @URL
    @Column
    private String twitter;

    @URL
    @Column(name="facebook")
    private String facebook;

    @URL
    @Column
    private String youtube;

    @URL
    @Column
    private String soundcloud;

    @URL
    @Column(name="wikipedia_article")
    private String wikipediaArticle;

    @URL
    @Column(name="bundestag_abgeordnete")
    private String bundestagAbgeordnete;

    @URL
    @Column
    private String abgeordnetenwatch;

    @URL
    @Column(name="lobbypedia_url")
    private String lobbypediaUrl;

    @URL
    @Column(name = "google_maps_url")
    private String googleMapsUrl;

    @URL
    @Column(name = "logo_url")
    private String logoUrl;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_kandidat_flat", nullable = false, updatable = false)
    private KandidatFlat kandidatFlat;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Wohnort getWohnort() {
        return wohnort;
    }

    public void setWohnort(Wohnort wohnort) {
        this.wohnort = wohnort;
    }

    public Geburtsort getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(Geburtsort geburtsort) {
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

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
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

    public LandesListe getLandesListe() {
        return landesListe;
    }

    public void setLandesListe(LandesListe landesListe) {
        this.landesListe = landesListe;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public KandidatFlat getKandidatFlat() {
        return kandidatFlat;
    }

    public void setKandidatFlat(KandidatFlat kandidatFlat) {
        this.kandidatFlat = kandidatFlat;
    }

    public String getWikipediaArticle() {
        return wikipediaArticle;
    }

    public void setWikipediaArticle(String wikipediaArticle) {
        this.wikipediaArticle = wikipediaArticle;
    }

    public String getBundestagAbgeordnete() {
        return bundestagAbgeordnete;
    }

    public void setBundestagAbgeordnete(String bundestagAbgeordnete) {
        this.bundestagAbgeordnete = bundestagAbgeordnete;
    }

    public String getAbgeordnetenwatch() {
        return abgeordnetenwatch;
    }

    public void setAbgeordnetenwatch(String abgeordnetenwatch) {
        this.abgeordnetenwatch = abgeordnetenwatch;
    }

    public String getLobbypediaUrl() {
        return lobbypediaUrl;
    }

    public void setLobbypediaUrl(String lobbypediaUrl) {
        this.lobbypediaUrl = lobbypediaUrl;
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public String getSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kandidat)) return false;

        Kandidat kandidat = (Kandidat) o;

        if (id != null ? !id.equals(kandidat.id) : kandidat.id != null) return false;
        if (key != null ? !key.equals(kandidat.key) : kandidat.key != null) return false;
        if (remoteKey != null ? !remoteKey.equals(kandidat.remoteKey) : kandidat.remoteKey != null) return false;
        if (titel != null ? !titel.equals(kandidat.titel) : kandidat.titel != null) return false;
        if (namenszusatz != null ? !namenszusatz.equals(kandidat.namenszusatz) : kandidat.namenszusatz != null)
            return false;
        if (nachnameOhne != null ? !nachnameOhne.equals(kandidat.nachnameOhne) : kandidat.nachnameOhne != null)
            return false;
        if (nachname != null ? !nachname.equals(kandidat.nachname) : kandidat.nachname != null) return false;
        if (vorname != null ? !vorname.equals(kandidat.vorname) : kandidat.vorname != null) return false;
        if (geschlecht != null ? !geschlecht.equals(kandidat.geschlecht) : kandidat.geschlecht != null) return false;
        if (geburtsjahr != null ? !geburtsjahr.equals(kandidat.geburtsjahr) : kandidat.geburtsjahr != null)
            return false;
        if (alter != null ? !alter.equals(kandidat.alter) : kandidat.alter != null) return false;
        if (wohnort != null ? !wohnort.equals(kandidat.wohnort) : kandidat.wohnort != null) return false;
        if (geburtsort != null ? !geburtsort.equals(kandidat.geburtsort) : kandidat.geburtsort != null) return false;
        if (beruf != null ? !beruf.equals(kandidat.beruf) : kandidat.beruf != null) return false;
        if (berufsgruppe != null ? !berufsgruppe.equals(kandidat.berufsgruppe) : kandidat.berufsgruppe != null)
            return false;
        if (bundesland != null ? !bundesland.equals(kandidat.bundesland) : kandidat.bundesland != null) return false;
        if (wahlkreis != null ? !wahlkreis.equals(kandidat.wahlkreis) : kandidat.wahlkreis != null) return false;
        if (partei != null ? !partei.equals(kandidat.partei) : kandidat.partei != null) return false;
        if (landesListe != null ? !landesListe.equals(kandidat.landesListe) : kandidat.landesListe != null)
            return false;
        if (listePlatz != null ? !listePlatz.equals(kandidat.listePlatz) : kandidat.listePlatz != null) return false;
        if (mdb != null ? !mdb.equals(kandidat.mdb) : kandidat.mdb != null) return false;
        if (lat != null ? !lat.equals(kandidat.lat) : kandidat.lat != null) return false;
        if (lng != null ? !lng.equals(kandidat.lng) : kandidat.lng != null) return false;
        if (idEigen != null ? !idEigen.equals(kandidat.idEigen) : kandidat.idEigen != null) return false;
        if (foto != null ? !foto.equals(kandidat.foto) : kandidat.foto != null) return false;
        if (fotoUrl != null ? !fotoUrl.equals(kandidat.fotoUrl) : kandidat.fotoUrl != null) return false;
        if (scatterX != null ? !scatterX.equals(kandidat.scatterX) : kandidat.scatterX != null) return false;
        if (scatterY != null ? !scatterY.equals(kandidat.scatterY) : kandidat.scatterY != null) return false;
        if (color != null ? !color.equals(kandidat.color) : kandidat.color != null) return false;
        if (webseite != null ? !webseite.equals(kandidat.webseite) : kandidat.webseite != null) return false;
        if (twitter != null ? !twitter.equals(kandidat.twitter) : kandidat.twitter != null) return false;
        if (facebook != null ? !facebook.equals(kandidat.facebook) : kandidat.facebook != null) return false;
        if (youtube != null ? !youtube.equals(kandidat.youtube) : kandidat.youtube != null) return false;
        if (soundcloud != null ? !soundcloud.equals(kandidat.soundcloud) : kandidat.soundcloud != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(kandidat.wikipediaArticle) : kandidat.wikipediaArticle != null)
            return false;
        if (bundestagAbgeordnete != null ? !bundestagAbgeordnete.equals(kandidat.bundestagAbgeordnete) : kandidat.bundestagAbgeordnete != null)
            return false;
        if (abgeordnetenwatch != null ? !abgeordnetenwatch.equals(kandidat.abgeordnetenwatch) : kandidat.abgeordnetenwatch != null)
            return false;
        if (lobbypediaUrl != null ? !lobbypediaUrl.equals(kandidat.lobbypediaUrl) : kandidat.lobbypediaUrl != null)
            return false;
        if (googleMapsUrl != null ? !googleMapsUrl.equals(kandidat.googleMapsUrl) : kandidat.googleMapsUrl != null)
            return false;
        if (logoUrl != null ? !logoUrl.equals(kandidat.logoUrl) : kandidat.logoUrl != null) return false;
        return kandidatFlat != null ? kandidatFlat.equals(kandidat.kandidatFlat) : kandidat.kandidatFlat == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (remoteKey != null ? remoteKey.hashCode() : 0);
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (namenszusatz != null ? namenszusatz.hashCode() : 0);
        result = 31 * result + (nachnameOhne != null ? nachnameOhne.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (geschlecht != null ? geschlecht.hashCode() : 0);
        result = 31 * result + (geburtsjahr != null ? geburtsjahr.hashCode() : 0);
        result = 31 * result + (alter != null ? alter.hashCode() : 0);
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        result = 31 * result + (berufsgruppe != null ? berufsgruppe.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (wahlkreis != null ? wahlkreis.hashCode() : 0);
        result = 31 * result + (partei != null ? partei.hashCode() : 0);
        result = 31 * result + (landesListe != null ? landesListe.hashCode() : 0);
        result = 31 * result + (listePlatz != null ? listePlatz.hashCode() : 0);
        result = 31 * result + (mdb != null ? mdb.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        result = 31 * result + (idEigen != null ? idEigen.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        result = 31 * result + (fotoUrl != null ? fotoUrl.hashCode() : 0);
        result = 31 * result + (scatterX != null ? scatterX.hashCode() : 0);
        result = 31 * result + (scatterY != null ? scatterY.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (soundcloud != null ? soundcloud.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (bundestagAbgeordnete != null ? bundestagAbgeordnete.hashCode() : 0);
        result = 31 * result + (abgeordnetenwatch != null ? abgeordnetenwatch.hashCode() : 0);
        result = 31 * result + (lobbypediaUrl != null ? lobbypediaUrl.hashCode() : 0);
        result = 31 * result + (googleMapsUrl != null ? googleMapsUrl.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (kandidatFlat != null ? kandidatFlat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kandidat{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", remoteKey='" + remoteKey + '\'' +
                ", titel='" + titel + '\'' +
                ", namenszusatz='" + namenszusatz + '\'' +
                ", nachnameOhne='" + nachnameOhne + '\'' +
                ", nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", geschlecht='" + geschlecht + '\'' +
                ", geburtsjahr=" + geburtsjahr +
                ", alter=" + alter +
                ", wohnort=" + wohnort +
                ", geburtsort=" + geburtsort +
                ", beruf=" + beruf +
                ", berufsgruppe=" + berufsgruppe +
                ", bundesland=" + bundesland +
                ", wahlkreis=" + wahlkreis +
                ", partei=" + partei +
                ", landesListe=" + landesListe +
                ", listePlatz=" + listePlatz +
                ", mdb='" + mdb + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", idEigen='" + idEigen + '\'' +
                ", foto='" + foto + '\'' +
                ", fotoUrl='" + fotoUrl + '\'' +
                ", scatterX=" + scatterX +
                ", scatterY=" + scatterY +
                ", color='" + color + '\'' +
                ", webseite='" + webseite + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", youtube='" + youtube + '\'' +
                ", soundcloud='" + soundcloud + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", bundestagAbgeordnete='" + bundestagAbgeordnete + '\'' +
                ", abgeordnetenwatch='" + abgeordnetenwatch + '\'' +
                ", lobbypediaUrl='" + lobbypediaUrl + '\'' +
                ", googleMapsUrl='" + googleMapsUrl + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", kandidatFlat=" + kandidatFlat +
                '}';
    }

    public String getSqlInsert(long id){
        Long idParameter = id;
        String columns[] = {
            "id","alter","color","facebook","foto",
            "foto_url","geburtsjahr","geschlecht","id_eigen","kandidat_key",
            "lat","liste_platz","lng","logo_url","mdb",
            "nachname","nachname_ohne","namenszusatz","remote_kandidat_key","scatter_x",
            "scatter_y","titel","twitter","vorname","webseite",
            "wikipedia_article","youtube","fk_beruf","fk_berufsgruppe","fk_bundesland",
            "fk_geburtsort","fk_kandidat_flat","fk_landes_liste","fk_partei","fk_wahlkreis",
            "fk_wohnort","bundestag_abgeordnete","abgeordnetenwatch","lobbypedia_url","google_maps_url",
            "soundcloud"
        };
        Object fields[] = {
            idParameter,alter,color,facebook,foto,
            fotoUrl,geburtsjahr,geschlecht,idEigen,key,
            lat,listePlatz,lng,logoUrl,mdb,
            nachname,nachnameOhne,namenszusatz,remoteKey,scatterX,
            scatterY,titel,twitter,vorname,webseite,
            wikipediaArticle,youtube,beruf,berufsgruppe,bundesland,
            geburtsort,kandidatFlat,landesListe,partei,wahlkreis,
            wohnort,bundestagAbgeordnete,abgeordnetenwatch,lobbypediaUrl,googleMapsUrl,
            soundcloud
        };
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO kandidat (");
        for(int i=0;i<columns.length; i++){
            sb.append(columns[i]);
            if((i+1)<columns.length){
                sb.append(",");
            }
        }
        sb.append(") VALUES (");
        for(int i=0;i<fields.length; i++){
            Object o = fields[i];
            if(o == null){
                sb.append("NULL");
            } else if(o instanceof Long){
                Long x = (Long) o;
                sb.append(x);
            }else if(o instanceof Integer){
                Integer x = (Integer) o;
                sb.append(x);
            } else if(o instanceof Double){
                Double x = (Double) o;
                sb.append(x);
            } else if(o instanceof String){
                String x = (String) o;
                sb.append("'");
                sb.append(x);
                sb.append("'");
            } else if(o instanceof KandidatDimension){
                KandidatDimension x = (KandidatDimension) o;
                sb.append(x.getId());
            }
            if((i+1)<fields.length){
                sb.append(", ");
            }
        }
        sb.append(");");
        return sb.toString();
    }
}


