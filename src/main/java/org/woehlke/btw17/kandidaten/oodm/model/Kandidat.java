package org.woehlke.btw17.kandidaten.oodm.model;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.woehlke.btw17.kandidaten.oodm.model.enums.Religion;
import org.woehlke.btw17.kandidaten.oodm.model.listener.KandidatListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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
        @Index(name = "idx_kandidat_vorname", columnList = "vorname"),
        @Index(name = "idx_kandidat_geschlecht", columnList = "geschlecht"),
        @Index(name = "idx_kandidat_geburtsjahr", columnList = "geburtsjahr"),
        @Index(name = "idx_kandidat_alter", columnList = "alter"),
        @Index(name = "idx_kandidat_liste_platz", columnList = "liste_platz"),
        @Index(name = "idx_kandidat_mdb", columnList = "mdb"),
        @Index(name = "idx_kandidat_mdb_neu", columnList = "mdb_neu"),
        @Index(name = "idx_kandidat_id_eigen", columnList = "id_eigen"),
        @Index(name = "idx_kandidat_foto", columnList = "foto"),
        @Index(name = "idx_kandidat_funktion", columnList = "funktion"),
        //
        @Index(name = "idx_kandidat_common_fields", columnList = "logo_url,symbol_bild"),
        //
        @Index(name = "idx_kandidat_webseite", columnList = "webseite"),
        //
        @Index(name = "idx_kandidat_twitter", columnList = "twitter"),
        @Index(name = "idx_kandidat_facebook", columnList = "facebook"),
        @Index(name = "idx_kandidat_youtube", columnList = "youtube"),
        @Index(name = "idx_kandidat_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_kandidat_bundestag", columnList = "bundestag"),
        @Index(name = "idx_kandidat_abgeordnetenwatch", columnList = "abgeordnetenwatch"),
        @Index(name = "idx_kandidat_google_maps_url", columnList = "google_maps_url"),
        @Index(name = "idx_kandidat_google_plus_url", columnList = "google_plus"),
        @Index(name = "idx_kandidat_instagram_url", columnList = "instagram"),
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Kandidat.findByMdB",
        query = "select o from Kandidat as o where o.mdb is not null and o.mdb='1' order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdB",
        query = "select count(o) from Kandidat as o where o.mdb is not null and o.mdb='1'"
    ),
    @NamedQuery(
        name = "Kandidat.findByNotMdB",
        query = "select o from Kandidat as o where o.mdb is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidat",
        query = "select count(o) from Kandidat as o where o.mdb is null"
    ),
    @NamedQuery(
        name = "Kandidat.findByGeburtsjahrAll",
        query = "select DISTINCT o.geburtsjahr from Kandidat as o where o.geburtsjahr is not null order by o.geburtsjahr"
    ),
    @NamedQuery(
        name = "Kandidat.findByListePartei",
        query = "select o from Kandidat as o where o.landesListe.listePartei=:listePartei order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countByListePartei",
        query = "select count(o) from Kandidat as o where o.landesListe.listePartei=:listePartei"
    ),
    @NamedQuery(
        name = "Kandidat.findByKandidatFlatId",
        query = "select o from Kandidat as o where o.btw17KandidatFlatId=:kandidatFlatId order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.getAll",
        query = "select o from Kandidat as o order by id"
    ),
    @NamedQuery(
        name = "Kandidat.getAllCount",
        query = "select count(o) from Kandidat as o"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutBundestagProfile",
        query = "select o from Kandidat as o where o.onlineStrategie.bundestagAbgeordnete is null and o.mdb is not null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdbWithoutBundestagProfile",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.bundestagAbgeordnete is null and o.mdb is not null"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutAbgeordnetenwatch",
        query = "select o from Kandidat as o where o.onlineStrategie.abgeordnetenwatch is null and o.mdb is not null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdbWithoutAbgeordnetenwatch",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.abgeordnetenwatch is null and o.mdb is not null"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutWikipediaArticle",
        query = "select o from Kandidat as o where o.onlineStrategie.wikipediaArticle is null and o.mdb is not null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdbWithoutWikipediaArticle",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.wikipediaArticle is null and o.mdb is not null"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutWebseite",
        query = "select o from Kandidat as o where o.webseite.webseite is null and o.mdb is not null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdbWithoutWebseite",
        query = "select count(o) from Kandidat as o where o.webseite.webseite is null and o.mdb is not null"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutFacebook",
        query = "select o from Kandidat as o where o.onlineStrategie.facebook is null and o.mdb is not null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdbWithoutFacebook",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.facebook is null and o.mdb is not null"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutTwitter",
        query = "select o from Kandidat as o where o.onlineStrategie.twitter is null and o.mdb is not null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdbWithoutTwitter",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.twitter is null and o.mdb is not null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutWebseite",
        query = "select o from Kandidat as o where o.webseite.webseite is null and o.mdb is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutWebseite",
        query = "select count(o) from Kandidat as o where o.webseite.webseite is null and o.mdb is null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutFacebook",
        query = "select o from Kandidat as o where o.onlineStrategie.facebook is null and o.mdb is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutFacebook",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.facebook is null and o.mdb is null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutTwitter",
        query = "select o from Kandidat as o where o.onlineStrategie.twitter is null and o.mdb is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutTwitter",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.twitter is null and o.mdb is null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutFotoUrl",
        query = "select o from Kandidat as o where o.fotoUrl is null and o.mdb is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutFotoUrl",
        query = "select count(o) from Kandidat as o where o.fotoUrl is null and o.mdb is null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutLobbypediaUrl",
        query = "select o from Kandidat as o where o.onlineStrategie.lobbypediaUrl is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutLobbypediaUrl",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.lobbypediaUrl is null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutSoundcloud",
        query = "select o from Kandidat as o where o.onlineStrategie.soundcloud is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutSoundcloud",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.soundcloud is null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutYoutube",
        query = "select o from Kandidat as o where o.onlineStrategie.youtube is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutYoutube",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.youtube is null"
    ),
    @NamedQuery(
        name = "Kandidat.getKandidatWithoutAbgeordnetenwatch",
        query = "select o from Kandidat as o where o.onlineStrategie.abgeordnetenwatch is null and o.mdb is null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countKandidatWithoutAbgeordnetenwatch",
        query = "select count(o) from Kandidat as o where o.onlineStrategie.abgeordnetenwatch is null and o.mdb is null"
    ),
    @NamedQuery(
        name = "Kandidat.getMdbWithoutFotoUrl",
        query = "select o from Kandidat as o where o.fotoUrl is null and o.mdb is not null order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countMdbWithoutFotoUrl",
        query = "select count(o) from Kandidat as o where o.fotoUrl is null and o.mdb is not null"
    ),
    @NamedQuery(
        name = "Kandidat.findByFraktion",
        query = "select o from Kandidat as o where o.fraktion=:fraktion order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.findByFraktionCount",
        query = "select count(o) from Kandidat as o where o.fraktion=:fraktion"
    ),
    @NamedQuery(
        name = "Kandidat.findByAusschuss",
        query = "select o from Kandidat as o join o.ausschuesse ausschuss where ausschuss=:ausschuss order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.findByAusschussCount",
        query = "select count(o) from Kandidat as o join o.ausschuesse ausschuss where ausschuss=:ausschuss"
    ),
    @NamedQuery(
        name = "Kandidat.findByMinisterium",
            query = "select o from Kandidat as o join o.ministerien ministerium where ministerium=:ministerium order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countByMinisterium",
        query = "select count(o) from Kandidat as o join o.ministerien ministerium where ministerium=:ministerium"
    ),
    @NamedQuery(
        name = "Kandidat.findByWebseiteAgentur",
        query = "select o from Kandidat as o join o.webseite.agenturen webseiteAgentur where webseiteAgentur=:webseiteAgentur order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countByWebseiteAgentur",
        query = "select count(o) from Kandidat as o join o.webseite.agenturen webseiteAgentur where webseiteAgentur=:webseiteAgentur"
    ),
    @NamedQuery(
        name = "Kandidat.findByWebseiteCms",
        query = "select o from Kandidat as o join o.webseite.cms webseiteCms where webseiteCms=:webseiteCms order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.contByWebseiteCms",
        query = "select count(o) from Kandidat as o join o.webseite.cms webseiteCms where webseiteCms=:webseiteCms"
    ),
    @NamedQuery(
        name = "Kandidat.findByBundesland",
        query = "select o from Kandidat as o where o.adresse.bundesland=:bundesland order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countByBundesland",
        query = "select count(o) from Kandidat as o where o.adresse.bundesland=:bundesland"
    ),
    @NamedQuery(
        name = "Kandidat.findByWahlperiode",
        query = "select o from Kandidat as o join o.wahlperioden wahlperiode where wahlperiode=:wahlperiode order by o.nachname"
    ),
    @NamedQuery(
        name = "Kandidat.countByWahlperiode",
        query = "select count(o) from Kandidat as o join o.wahlperioden wahlperiode where wahlperiode=:wahlperiode"
    ),
    @NamedQuery(
        name = "Kandidat.getMaxId",
        query = "select max(o.id) from Kandidat as o"
    ),
    @NamedQuery(
        name = "Kandidat.findByBtw17Mdb",
        query = "select o from Kandidat as o where o.vorname=:vorname and o.nachname=:nachname and o.geburtsjahr=:geburtsjahr and o.geburtsort=:geburtsort and o.geschlecht=:geschlecht"
    )
})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Kandidat.countKandidatMinisterium",
        query = "SELECT count(*) AS z FROM kandidat_ministerium"
    ),
    @NamedNativeQuery(
        name = "Kandidat.countKandidatAusschuss",
        query = "SELECT count(*) AS z FROM kandidat_ausschuss"
    ),
    @NamedNativeQuery(
        name = "Kandidat.countKandidatAgentur",
        query = "SELECT count(*) AS z FROM kandidat_agentur"
    )
})
@EntityListeners(KandidatListener.class)
public class Kandidat implements DomainObject,WebseiteEmbedded,OnlineStrategieEmbedded {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @NotNull
    //@Pattern(regexp="herr|frau-[a-z]*[-]?[a-z]+-[a-z]+-geboren-[0-9]{4}-in-[a-z]+")
    @Column(name = "kandidat_key", nullable = false, unique = true)
    private String key;

    @Column(name = "remote_kandidat_key")
    private String remoteKey;

    @Column(name = "xml_id_bundestag")
    private String xmlIdBundestag;

    @SuppressWarnings("deprecation")
    @SafeHtml
    @Column(name = "titel")
    private String titel;

    @SuppressWarnings("deprecation")
    @SafeHtml
    @Column(name = "namenszusatz")
    private String namenszusatz;

    @SuppressWarnings("deprecation")
    @SafeHtml
    @Column(name = "nachname_ohne")
    private String nachnameOhne;

    @SuppressWarnings("deprecation")
    @NotNull
    @SafeHtml
    @Column(name = "nachname")
    private String nachname;

    @SuppressWarnings("deprecation")
    @NotNull
    @SafeHtml
    @Column(name = "vorname")
    private String vorname;

    @NotNull
    @Pattern(regexp = "[MW]{1}")
    @Column(name = "geschlecht")
    private String geschlecht;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    @Column(name = "geburtsjahr")
    private Integer geburtsjahr;

    @Column(name = "ortszusatz")
    private String ortszusatz;

    @Column(name = "adel")
    private String adel;

    @Column(name = "praefix")
    private String praefix;

    @Column(name = "anredetitel")
    private String anredeTitel;

    @Column(name = "akadtitel")
    private String akademischeTitel;

    @Column(name = "historievon")
    private LocalDate historieVon;

    @Column(name = "historiebis")
    private LocalDate historieBis;

    @NotNull
    @Digits(integer = 2, fraction = 0)
    @Column(name = "alter")
    private Integer alter;

    @Past
    @Column(name = "geburtsdatum")
    private LocalDate geburtsdatum;

    @Column(name = "sterbedatum")
    private LocalDate sterbedatum;

    @Column(name = "familienstand")
    private String familienstand;

    @Enumerated(EnumType.STRING)
    @Column(name = "religion")
    private Religion religion;

    @Column(name = "parteikurz")
    private String parteikurz;

    @Column(name = "vitakurz", columnDefinition = "TEXT")
    private String vitakurz;

    @Column(name = "veroeffentlichungspflichtiges", columnDefinition = "TEXT")
    private String veroeffentlichungspflichtiges;

    @SuppressWarnings("deprecation")
    @SafeHtml
    @Column(name = "funktion")
    private String funktion;

    @Column(name = "mdb")
    private String mdb;

    @Column(name = "mdb_neu")
    private Boolean mdbNeu;

    @Column(name = "mdb17")
    private Boolean mdb17;

    @Column(name = "mdb18")
    private Boolean mdb18;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    @Column(name = "id_eigen")
    private String idEigen;

    @Column(name = "foto")
    private String foto;

    @URL
    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(name = "scatter_x")
    private Double scatterX;

    @Column(name = "scatter_y")
    private Double scatterY;

    @Column(name = "color")
    private String color;

    @URL
    @Column(name = "google_maps_url")
    private String googleMapsUrl;

    @Column(name = "liste_platz")
    private Integer listePlatz;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_wohnort", nullable = false, updatable = false)
    private Wohnort wohnort;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_geburtsort", nullable = true, updatable = false)
    private Geburtsort geburtsort;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_beruf", nullable = false, updatable = false)
    private Beruf beruf;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_berufsgruppe", nullable = true, updatable = false)
    private Berufsgruppe berufsgruppe;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_wahlkreis", nullable = false, updatable = false)
    private Wahlkreis wahlkreis;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_partei", nullable = false, updatable = false)
    private Partei partei;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_landes_liste", nullable = true, updatable = true)
    private LandesListe landesListe;

    @ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_fraktion", nullable = true, updatable = true)
    private Fraktion fraktion;

    @ManyToMany(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "kandidat_ministerium")
    private Set<Ministerium> ministerien = new LinkedHashSet<>();

    @ManyToMany(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "kandidat_ausschuss")
    private Set<Ausschuss> ausschuesse = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "kandidat_wahlperiode")
    private Set<Wahlperiode> wahlperioden = new LinkedHashSet<>();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    @AssociationOverrides({
            @AssociationOverride(
                    name = "agenturen",
                    joinTable = @JoinTable(
                            name = "kandidat_agentur"
                    )
            )
    })
    private Webseite webseite = new Webseite();

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private Adresse adresse = new Adresse();

    @Column(name = "btw17_kandidat_flat_id", nullable = false, updatable = false, unique = true)
    private Long btw17KandidatFlatId;

    @Column(name = "btw17_mdb_stammdaten_id", nullable = true, updatable = false, unique = true)
    private Long btw17MdbId;

    @Column(name = "btw17wahlbewerber_id", nullable = true, updatable = false, unique = true)
    private Long btw17WahlbewerberId;

    @Transient
    @Override
    public String getName() {
        return vorname + " " + nachname;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":" + key + ":" + this.getName();
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

    public String getFunktion() {
        return funktion;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
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

    public LandesListe getLandesListe() {
        return landesListe;
    }

    public void setLandesListe(LandesListe landesListe) {
        this.landesListe = landesListe;
    }

    public Integer getListePlatz() {
        return listePlatz;
    }

    public void setListePlatz(Integer listePlatz) {
        this.listePlatz = listePlatz;
    }

    public Fraktion getFraktion() {
        return fraktion;
    }

    public void setFraktion(Fraktion fraktion) {
        this.fraktion = fraktion;
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

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if (onlineStrategie != null) {
            this.onlineStrategie = onlineStrategie;
        }
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public Long getBtw17KandidatFlatId() {
        return btw17KandidatFlatId;
    }

    public void setBtw17KandidatFlatId(Long btw17KandidatFlatId) {
        this.btw17KandidatFlatId = btw17KandidatFlatId;
    }

    public Set<Ministerium> getMinisterien() {
        return ministerien;
    }

    public void setMinisterien(Set<Ministerium> ministerien) {
        if (ministerien != null) {
            this.ministerien = ministerien;
        }
    }

    public Set<Ausschuss> getAusschuesse() {
        return ausschuesse;
    }

    public void setAusschuesse(Set<Ausschuss> ausschuesse) {
        if (ausschuesse != null) {
            this.ausschuesse = ausschuesse;
        }
    }

    public Webseite getWebseite() {
        return webseite;
    }

    public void setWebseite(Webseite webseite) {
        if (webseite != null) {
            this.webseite = webseite;
        }
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        if (commonFields != null) {
            this.commonFields = commonFields;
        }
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        if (adresse != null) {
            this.adresse = adresse;
        }
    }

    public Set<Wahlperiode> getWahlperioden() {
        return wahlperioden;
    }

    public void setWahlperioden(Set<Wahlperiode> wahlperioden) {
        this.wahlperioden = wahlperioden;
    }

    public String getXmlIdBundestag() {
        return xmlIdBundestag;
    }

    public void setXmlIdBundestag(String xmlIdBundestag) {
        this.xmlIdBundestag = xmlIdBundestag;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kandidat)) return false;

        Kandidat kandidat = (Kandidat) o;

        if (id != null ? !id.equals(kandidat.id) : kandidat.id != null) return false;
        if (key != null ? !key.equals(kandidat.key) : kandidat.key != null) return false;
        if (remoteKey != null ? !remoteKey.equals(kandidat.remoteKey) : kandidat.remoteKey != null) return false;
        if (xmlIdBundestag != null ? !xmlIdBundestag.equals(kandidat.xmlIdBundestag) : kandidat.xmlIdBundestag != null)
            return false;
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
        if (ortszusatz != null ? !ortszusatz.equals(kandidat.ortszusatz) : kandidat.ortszusatz != null) return false;
        if (adel != null ? !adel.equals(kandidat.adel) : kandidat.adel != null) return false;
        if (praefix != null ? !praefix.equals(kandidat.praefix) : kandidat.praefix != null) return false;
        if (anredeTitel != null ? !anredeTitel.equals(kandidat.anredeTitel) : kandidat.anredeTitel != null)
            return false;
        if (akademischeTitel != null ? !akademischeTitel.equals(kandidat.akademischeTitel) : kandidat.akademischeTitel != null)
            return false;
        if (historieVon != null ? !historieVon.equals(kandidat.historieVon) : kandidat.historieVon != null)
            return false;
        if (historieBis != null ? !historieBis.equals(kandidat.historieBis) : kandidat.historieBis != null)
            return false;
        if (alter != null ? !alter.equals(kandidat.alter) : kandidat.alter != null) return false;
        if (geburtsdatum != null ? !geburtsdatum.equals(kandidat.geburtsdatum) : kandidat.geburtsdatum != null)
            return false;
        if (sterbedatum != null ? !sterbedatum.equals(kandidat.sterbedatum) : kandidat.sterbedatum != null)
            return false;
        if (familienstand != null ? !familienstand.equals(kandidat.familienstand) : kandidat.familienstand != null)
            return false;
        if (religion != kandidat.religion) return false;
        if (parteikurz != null ? !parteikurz.equals(kandidat.parteikurz) : kandidat.parteikurz != null) return false;
        if (vitakurz != null ? !vitakurz.equals(kandidat.vitakurz) : kandidat.vitakurz != null) return false;
        if (veroeffentlichungspflichtiges != null ? !veroeffentlichungspflichtiges.equals(kandidat.veroeffentlichungspflichtiges) : kandidat.veroeffentlichungspflichtiges != null)
            return false;
        if (funktion != null ? !funktion.equals(kandidat.funktion) : kandidat.funktion != null) return false;
        if (mdb != null ? !mdb.equals(kandidat.mdb) : kandidat.mdb != null) return false;
        if (mdbNeu != null ? !mdbNeu.equals(kandidat.mdbNeu) : kandidat.mdbNeu != null) return false;
        if (mdb17 != null ? !mdb17.equals(kandidat.mdb17) : kandidat.mdb17 != null) return false;
        if (mdb18 != null ? !mdb18.equals(kandidat.mdb18) : kandidat.mdb18 != null) return false;
        if (lat != null ? !lat.equals(kandidat.lat) : kandidat.lat != null) return false;
        if (lng != null ? !lng.equals(kandidat.lng) : kandidat.lng != null) return false;
        if (idEigen != null ? !idEigen.equals(kandidat.idEigen) : kandidat.idEigen != null) return false;
        if (foto != null ? !foto.equals(kandidat.foto) : kandidat.foto != null) return false;
        if (fotoUrl != null ? !fotoUrl.equals(kandidat.fotoUrl) : kandidat.fotoUrl != null) return false;
        if (scatterX != null ? !scatterX.equals(kandidat.scatterX) : kandidat.scatterX != null) return false;
        if (scatterY != null ? !scatterY.equals(kandidat.scatterY) : kandidat.scatterY != null) return false;
        if (color != null ? !color.equals(kandidat.color) : kandidat.color != null) return false;
        if (googleMapsUrl != null ? !googleMapsUrl.equals(kandidat.googleMapsUrl) : kandidat.googleMapsUrl != null)
            return false;
        if (listePlatz != null ? !listePlatz.equals(kandidat.listePlatz) : kandidat.listePlatz != null) return false;
        if (wohnort != null ? !wohnort.equals(kandidat.wohnort) : kandidat.wohnort != null) return false;
        if (geburtsort != null ? !geburtsort.equals(kandidat.geburtsort) : kandidat.geburtsort != null) return false;
        if (beruf != null ? !beruf.equals(kandidat.beruf) : kandidat.beruf != null) return false;
        if (berufsgruppe != null ? !berufsgruppe.equals(kandidat.berufsgruppe) : kandidat.berufsgruppe != null)
            return false;
        if (wahlkreis != null ? !wahlkreis.equals(kandidat.wahlkreis) : kandidat.wahlkreis != null) return false;
        if (partei != null ? !partei.equals(kandidat.partei) : kandidat.partei != null) return false;
        if (landesListe != null ? !landesListe.equals(kandidat.landesListe) : kandidat.landesListe != null)
            return false;
        if (fraktion != null ? !fraktion.equals(kandidat.fraktion) : kandidat.fraktion != null) return false;
        if (ministerien != null ? !ministerien.equals(kandidat.ministerien) : kandidat.ministerien != null)
            return false;
        if (ausschuesse != null ? !ausschuesse.equals(kandidat.ausschuesse) : kandidat.ausschuesse != null)
            return false;
        if (wahlperioden != null ? !wahlperioden.equals(kandidat.wahlperioden) : kandidat.wahlperioden != null)
            return false;
        if (commonFields != null ? !commonFields.equals(kandidat.commonFields) : kandidat.commonFields != null)
            return false;
        if (webseite != null ? !webseite.equals(kandidat.webseite) : kandidat.webseite != null) return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(kandidat.onlineStrategie) : kandidat.onlineStrategie != null)
            return false;
        if (adresse != null ? !adresse.equals(kandidat.adresse) : kandidat.adresse != null) return false;
        if (btw17KandidatFlatId != null ? !btw17KandidatFlatId.equals(kandidat.btw17KandidatFlatId) : kandidat.btw17KandidatFlatId != null)
            return false;
        if (btw17MdbId != null ? !btw17MdbId.equals(kandidat.btw17MdbId) : kandidat.btw17MdbId != null) return false;
        return btw17WahlbewerberId != null ? btw17WahlbewerberId.equals(kandidat.btw17WahlbewerberId) : kandidat.btw17WahlbewerberId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (remoteKey != null ? remoteKey.hashCode() : 0);
        result = 31 * result + (xmlIdBundestag != null ? xmlIdBundestag.hashCode() : 0);
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (namenszusatz != null ? namenszusatz.hashCode() : 0);
        result = 31 * result + (nachnameOhne != null ? nachnameOhne.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (geschlecht != null ? geschlecht.hashCode() : 0);
        result = 31 * result + (geburtsjahr != null ? geburtsjahr.hashCode() : 0);
        result = 31 * result + (ortszusatz != null ? ortszusatz.hashCode() : 0);
        result = 31 * result + (adel != null ? adel.hashCode() : 0);
        result = 31 * result + (praefix != null ? praefix.hashCode() : 0);
        result = 31 * result + (anredeTitel != null ? anredeTitel.hashCode() : 0);
        result = 31 * result + (akademischeTitel != null ? akademischeTitel.hashCode() : 0);
        result = 31 * result + (historieVon != null ? historieVon.hashCode() : 0);
        result = 31 * result + (historieBis != null ? historieBis.hashCode() : 0);
        result = 31 * result + (alter != null ? alter.hashCode() : 0);
        result = 31 * result + (geburtsdatum != null ? geburtsdatum.hashCode() : 0);
        result = 31 * result + (sterbedatum != null ? sterbedatum.hashCode() : 0);
        result = 31 * result + (familienstand != null ? familienstand.hashCode() : 0);
        result = 31 * result + (religion != null ? religion.hashCode() : 0);
        result = 31 * result + (parteikurz != null ? parteikurz.hashCode() : 0);
        result = 31 * result + (vitakurz != null ? vitakurz.hashCode() : 0);
        result = 31 * result + (veroeffentlichungspflichtiges != null ? veroeffentlichungspflichtiges.hashCode() : 0);
        result = 31 * result + (funktion != null ? funktion.hashCode() : 0);
        result = 31 * result + (mdb != null ? mdb.hashCode() : 0);
        result = 31 * result + (mdbNeu != null ? mdbNeu.hashCode() : 0);
        result = 31 * result + (mdb17 != null ? mdb17.hashCode() : 0);
        result = 31 * result + (mdb18 != null ? mdb18.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        result = 31 * result + (idEigen != null ? idEigen.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        result = 31 * result + (fotoUrl != null ? fotoUrl.hashCode() : 0);
        result = 31 * result + (scatterX != null ? scatterX.hashCode() : 0);
        result = 31 * result + (scatterY != null ? scatterY.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (googleMapsUrl != null ? googleMapsUrl.hashCode() : 0);
        result = 31 * result + (listePlatz != null ? listePlatz.hashCode() : 0);
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        result = 31 * result + (berufsgruppe != null ? berufsgruppe.hashCode() : 0);
        result = 31 * result + (wahlkreis != null ? wahlkreis.hashCode() : 0);
        result = 31 * result + (partei != null ? partei.hashCode() : 0);
        result = 31 * result + (landesListe != null ? landesListe.hashCode() : 0);
        result = 31 * result + (fraktion != null ? fraktion.hashCode() : 0);
        result = 31 * result + (ministerien != null ? ministerien.hashCode() : 0);
        result = 31 * result + (ausschuesse != null ? ausschuesse.hashCode() : 0);
        result = 31 * result + (wahlperioden != null ? wahlperioden.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (webseite != null ? webseite.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (btw17KandidatFlatId != null ? btw17KandidatFlatId.hashCode() : 0);
        result = 31 * result + (btw17MdbId != null ? btw17MdbId.hashCode() : 0);
        result = 31 * result + (btw17WahlbewerberId != null ? btw17WahlbewerberId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kandidat{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", remoteKey='" + remoteKey + '\'' +
                ", xmlIdBundestag='" + xmlIdBundestag + '\'' +
                ", titel='" + titel + '\'' +
                ", namenszusatz='" + namenszusatz + '\'' +
                ", nachnameOhne='" + nachnameOhne + '\'' +
                ", nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", geschlecht='" + geschlecht + '\'' +
                ", geburtsjahr=" + geburtsjahr +
                ", ortszusatz='" + ortszusatz + '\'' +
                ", adel='" + adel + '\'' +
                ", praefix='" + praefix + '\'' +
                ", anredeTitel='" + anredeTitel + '\'' +
                ", akademischeTitel='" + akademischeTitel + '\'' +
                ", historieVon=" + historieVon +
                ", historieBis=" + historieBis +
                ", alter=" + alter +
                ", geburtsdatum=" + geburtsdatum +
                ", sterbedatum=" + sterbedatum +
                ", familienstand='" + familienstand + '\'' +
                ", religion=" + religion +
                ", parteikurz='" + parteikurz + '\'' +
                ", vitakurz='" + vitakurz + '\'' +
                ", veroeffentlichungspflichtiges='" + veroeffentlichungspflichtiges + '\'' +
                ", funktion='" + funktion + '\'' +
                ", mdb='" + mdb + '\'' +
                ", mdbNeu=" + mdbNeu +
                ", mdb17=" + mdb17 +
                ", mdb18=" + mdb18 +
                ", lat=" + lat +
                ", lng=" + lng +
                ", idEigen='" + idEigen + '\'' +
                ", foto='" + foto + '\'' +
                ", fotoUrl='" + fotoUrl + '\'' +
                ", scatterX=" + scatterX +
                ", scatterY=" + scatterY +
                ", color='" + color + '\'' +
                ", googleMapsUrl='" + googleMapsUrl + '\'' +
                ", listePlatz=" + listePlatz +
                ", wohnort=" + wohnort +
                ", geburtsort=" + geburtsort +
                ", beruf=" + beruf +
                ", berufsgruppe=" + berufsgruppe +
                ", wahlkreis=" + wahlkreis +
                ", partei=" + partei +
                ", landesListe=" + landesListe +
                ", fraktion=" + fraktion +
                ", ministerien=" + ministerien +
                ", ausschuesse=" + ausschuesse +
                ", wahlperioden=" + wahlperioden +
                ", commonFields=" + commonFields +
                ", webseite=" + webseite +
                ", onlineStrategie=" + onlineStrategie +
                ", adresse=" + adresse +
                ", btw17KandidatFlatId=" + btw17KandidatFlatId +
                ", btw17MdbId=" + btw17MdbId +
                ", btw17WahlbewerberId=" + btw17WahlbewerberId +
                '}';
    }
}


