package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.Religion;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Adresse;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@Setter
@Getter
@NodeEntity
public class Kandidat implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    //@Pattern(regexp="herr|frau-[a-z]*[-]?[a-z]+-[a-z]+-geboren-[0-9]{4}-in-[a-z]+")
    //@Column(name = "kandidat_key", nullable = false, unique = true)
    private String key;

    //@Column(name = "remote_kandidat_key")
    private String remoteKey;

    //@Column(name = "xml_id_bundestag")
    private String xmlIdBundestag;

    @SafeHtml
    //@Column(name = "titel")
    private String titel;

    @SafeHtml
    //@Column(name = "namenszusatz")
    private String namenszusatz;

    @SafeHtml
    //@Column(name = "nachname_ohne")
    private String nachnameOhne;

    @NotNull
    @SafeHtml
    //@Column(name = "nachname")
    private String nachname;

    @NotNull
    @SafeHtml
    //@Column(name = "vorname")
    private String vorname;

    @NotNull
    @Pattern(regexp = "[MW]{1}")
    //@Column(name = "geschlecht")
    private String geschlecht;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    //@Column(name = "geburtsjahr")
    private Integer geburtsjahr;

    //@Column(name = "ortszusatz")
    private String ortszusatz;

    //@Column(name = "adel")
    private String adel;

    //@Column(name = "praefix")
    private String praefix;

    //@Column(name = "anredetitel")
    private String anredeTitel;

    //@Column(name = "akadtitel")
    private String akademischeTitel;

    //@Column(name = "historievon")
    private LocalDate historieVon;

    //@Column(name = "historiebis")
    private LocalDate historieBis;

    @NotNull
    @Digits(integer = 2, fraction = 0)
    //@Column(name = "alter")
    private Integer alter;

    @Past
    //@Column(name = "geburtsdatum")
    private LocalDate geburtsdatum;

    //@Column(name = "sterbedatum")
    private LocalDate sterbedatum;

    //@Column(name = "familienstand")
    private String familienstand;

    //@Enumerated(EnumType.STRING)
    //@Column(name = "religion")
    private Religion religion;

    //@Column(name = "parteikurz")
    private String parteikurz;

    //@Lob
    //@Column(name = "vitakurz")
    private String vitakurz;

    //@Lob
    //@Column(name = "veroeffentlichungspflichtiges")
    private String veroeffentlichungspflichtiges;

    @SafeHtml
    //@Column(name = "funktion")
    private String funktion;

    //@Column(name = "mdb")
    private String mdb;

    //@Column(name = "mdb_neu")
    private Boolean mdbNeu;

    //@Column(name = "mdb17")
    private Boolean mdb17;

    //@Column(name = "mdb18")
    private Boolean mdb18;

    //@Column(name = "lat")
    private Double lat;

    //@Column(name = "lng")
    private Double lng;

    //@Column(name = "id_eigen")
    private String idEigen;

    //@Column(name = "foto")
    private String foto;

    @URL
    //@Column(name = "foto_url")
    private String fotoUrl;

    //@Column(name = "scatter_x")
    private Double scatterX;

    //@Column(name = "scatter_y")
    private Double scatterY;

    //@Column(name = "color")
    private String color;

    @URL
    //@Column(name = "google_maps_url")
    private String googleMapsUrl;

    //@Column(name = "liste_platz")
    private Integer listePlatz;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_wohnort", nullable = false, updatable = false)
    private Wohnort wohnort;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_geburtsort", nullable = true, updatable = false)
    private Geburtsort geburtsort;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_beruf", nullable = false, updatable = false)
    private Beruf beruf;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_berufsgruppe", nullable = true, updatable = false)
    private Berufsgruppe berufsgruppe;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_wahlkreis", nullable = false, updatable = false)
    private Wahlkreis wahlkreis;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_partei", nullable = false, updatable = false)
    private Partei partei;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_landes_liste", nullable = true, updatable = true)
    private LandesListe landesListe;

    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_fraktion", nullable = true, updatable = true)
    private Fraktion fraktion;

    //@ManyToMany(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinTable(name = "kandidat_ministerium")
    private Set<Ministerium> ministerien = new LinkedHashSet<>();

    //@ManyToMany(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinTable(name = "kandidat_ausschuss")
    private Set<Ausschuss> ausschuesse = new LinkedHashSet<>();

    //@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinTable(name = "kandidat_wahlperiode")
    private Set<Wahlperiode> wahlperioden = new LinkedHashSet<>();

    @Valid
    //@Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    /*
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "kandidat_agentur"
            )
        )
    })
    */
    private Webseite webseite = new Webseite();

    @Valid
    //@Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    //@Embedded
    private Adresse adresse = new Adresse();

    //@Column(name = "btw17_kandidat_flat_id", nullable = false, updatable = false, unique = true)
    private Long btw17KandidatFlatId;

    //@Column(name = "btw17_mdb_stammdaten_id", nullable = true, updatable = false, unique = true)
    private Long btw17MdbId;

    //@Column(name = "btw17wahlbewerber_id", nullable = true, updatable = false, unique = true)
    private Long btw17WahlbewerberId;

    @Transient
    //@Override
    public String getName() {
        return vorname + " " + nachname;
    }

    @Transient
    //@Override
    public String getUniqueId() {
        return id + ":" + key + ":" + this.getName();
    }

    public Long getId() {
        return id;
    }

}
