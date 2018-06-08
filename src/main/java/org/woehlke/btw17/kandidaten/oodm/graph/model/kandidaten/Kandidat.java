package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
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
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

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

    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

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

    @Override
    public String getUniqueId() {
        return id + ":" + key + ":" + this.getName();
    }

    public Long getId() {
        return id;
    }

    public Kandidat() {
    }
}
