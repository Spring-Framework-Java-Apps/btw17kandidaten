package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;


@Setter
@Getter
@NodeEntity
public class Btw17Mdb implements GraphDomainObject {

    @Id
    @GeneratedValue
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
}
