package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.WAHLPERIODEN;

/**
 * Information ueber einen MDB
 */
@Setter
@Getter
@NodeEntity
public class Btw17Mdb implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

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

    //@Lob
    @Property(name="vitakurz")
    private String vitakurz;

    //@Lob
    @Property(name="veroeffentlichungspflichtiges")
    private String veroeffentlichungspflichtiges;

    @Relationship(type = WAHLPERIODEN)
    //@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    //@JoinTable(name="btw17_mdb_stammdaten_wahlperiode")
    private Set<Btw17Wahlperiode> wahlperioden = new LinkedHashSet<>();

    //@Transient
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

    @Override
    public Long getId() {
        return id;
    }

    public Btw17Mdb() {
    }
}
