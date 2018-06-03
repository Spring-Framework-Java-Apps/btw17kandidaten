package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Locale;


@Setter
@Getter
@NodeEntity
public class Btw17KandidatFlat implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;



    @Column(name="kandidat_key")
    private String key;

    @Column(name="titel")
    private String titel;

    @Column(name="namenszusatz")
    private String namenszusatz;

    @Column(name="nachname_ohne")
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

    @Column
    private String wohnort;

    @Column
    private String geburtsort;

    @Column
    private String beruf;

    @Column
    private String berufsgruppe;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "bundesland", nullable=false)
    private BundeslandEnum bundesland;

    @Column(name="wahlkreis_id")
    private Integer wahlkreisId;

    @Column(name="wahlkreis_name")
    private String wahlkreisName;

    @Column
    private String partei;

    @Column(name="partei_lang")
    private String parteiLang;

    @Column(name="liste_bundesland_land")
    private String listeBundeslandLand;

    @Column(name="liste_partei")
    private String listePartei;

    @Column(name="liste_partei_lang")
    private String listeParteiLang;

    @Column(name="liste_platz")
    private Integer listePlatz;

    @Column
    private String mdb;

    @Column
    private Double lat;

    @Column
    private Double lng;

    @Column(name="id_eigen")
    private String idEigen;

    @Column
    private String foto;

    @Column(name="scatter_x")
    private Double scatterX;

    @Column(name="scatter_y")
    private Double scatterY;

    @Column
    private String color;

    @Transient
    public String getName() {
        return getTransientKey();
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getTransientKey()+":"+this.getVorname()+" "+this.getNachname();
    }

    @Transient
    public String getTransientKey(){
        Locale locale = Locale.GERMANY;
        String titel = this.getTitel();
        String vorname = this.getVorname();
        String nachname = this.getNachname();
        String namenszusatz = this.getNamenszusatz();
        String geschlecht = this.getGeschlecht();
        String geburtsort = this.getGeburtsort();
        Integer geburtsjahr = this.getGeburtsjahr();
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

    public Long getId() {
        return id;
    }

}
