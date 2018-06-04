package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.Partei;
import org.woehlke.btw17.kandidaten.oodm.graph.model.bundestag.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.graph.model.bundestag.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.Religion;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Ort;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Beruf;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.regierung.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@Setter
@Getter
@NodeEntity
public class Kandidat implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    //@Pattern(regexp="herr|frau-[a-z]*[-]?[a-z]+-[a-z]+-geboren-[0-9]{4}-in-[a-z]+")
    @Property(name = "kandidat_key"/*, nullable = false, unique = true*/)
    private String key;

    @Property(name = "remote_kandidat_key")
    private String remoteKey;

    @Property(name = "xml_id_bundestag")
    private String xmlIdBundestag;

    @SafeHtml
    @Property(name = "titel")
    private String titel;

    @SafeHtml
    @Property(name = "namenszusatz")
    private String namenszusatz;

    @SafeHtml
    @Property(name = "nachname_ohne")
    private String nachnameOhne;

    @NotNull
    @SafeHtml
    @Property(name = "nachname")
    private String nachname;

    @NotNull
    @SafeHtml
    @Property(name = "vorname")
    private String vorname;

    @NotNull
    @Pattern(regexp = "[MW]{1}")
    @Property(name = "geschlecht")
    private String geschlecht;

    @NotNull
    @Digits(integer = 4, fraction = 0)
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

    @NotNull
    @Digits(integer = 2, fraction = 0)
    @Property(name = "alter")
    private Integer alter;

    @Past
    @Property(name = "geburtsdatum")
    private LocalDate geburtsdatum;

    @Property(name = "sterbedatum")
    private LocalDate sterbedatum;

    @Property(name = "familienstand")
    private String familienstand;

    //@Enumerated(EnumType.STRING)
    @Property(name = "religion")
    private Religion religion;

    @Property(name = "parteikurz")
    private String parteikurz;

    //@Lob
    @Property(name = "vitakurz")
    private String vitakurz;

    //@Lob
    @Property(name = "veroeffentlichungspflichtiges")
    private String veroeffentlichungspflichtiges;

    @SafeHtml
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

    @URL
    @Property(name = "foto_url")
    private String fotoUrl;

    @Property(name = "scatter_x")
    private Double scatterX;

    @Property(name = "scatter_y")
    private Double scatterY;

    @Property(name = "color")
    private String color;

    @URL
    @Property(name = "google_maps_url")
    private String googleMapsUrl;

    @Property(name = "liste_platz")
    private Integer listePlatz;

    @Relationship(type = WOHN_ORT)
    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_wohnort", nullable = false, updatable = false)
    private Ort wohnort;

    @Relationship(type = GEBURTS_ORT)
    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_geburtsort", nullable = true, updatable = false)
    private Ort geburtsort;

    @Relationship(type = JOB)
    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_beruf", nullable = false, updatable = false)
    private Beruf beruf;


    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_berufsgruppe", nullable = true, updatable = false)
    @Relationship(type = JOB)
    private Berufsgruppe berufsgruppe;


    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_wahlkreis", nullable = false, updatable = false)
    @Relationship(type = JOB)
    private Wahlkreis wahlkreis;


    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_partei", nullable = false, updatable = false)^
    @Relationship(type = JOB)
    private Partei partei;


    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_landes_liste", nullable = true, updatable = true)
    @Relationship(type = JOB)
    private LandesListe landesListe;


    //@ManyToOne(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_fraktion", nullable = true, updatable = true)
    @Relationship(type = JOB)
    private Fraktion fraktion;


    //@ManyToMany(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinTable(name = "kandidat_ministerium")
    @Relationship(type = JOB)
    private Set<Ministerium> ministerien = new LinkedHashSet<>();

    //@ManyToMany(fetch = LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinTable(name = "kandidat_ausschuss")
    @Relationship(type = JOB)
    private Set<Ausschuss> ausschuesse = new LinkedHashSet<>();

    //@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinTable(name = "kandidat_wahlperiode")
    @Relationship(type = ZEIT)
    private Set<Wahlperiode> wahlperioden = new LinkedHashSet<>();

    //@Embedded
    //@Valid
    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();


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
    //@Valid
    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

    //@Embedded
    //@Valid
    @Relationship(type=PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    //@Embedded
    //@Valid
    @Relationship(type=LOCATION)
    private Adresse adresse = new Adresse();

    @Property(name = "btw17_kandidat_flat_id"/*, nullable = false, updatable = false, unique = true*/)
    private Long btw17KandidatFlatId;

    @Property(name = "btw17_mdb_stammdaten_id"/*, nullable = true, updatable = false, unique = true*/)
    private Long btw17MdbId;

    @Property(name = "btw17wahlbewerber_id"/*, nullable = true, updatable = false, unique = true*/)
    private Long btw17WahlbewerberId;

    //@Transient
    //@Override
    public String getName() {
        return vorname + " " + nachname;
    }

    //@Transient
    //@Override
    public String getUniqueId() {
        return id + ":" + key + ":" + this.getName();
    }

    public Long getId() {
        return id;
    }

}
