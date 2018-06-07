package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.constraints.NotNull;
import java.util.Locale;


@Setter
@Getter
@NodeEntity
public class Btw17KandidatFlat implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

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
        return id + ":"+this.getTransientKey()+":"+this.vorname+" "+this.nachname;
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

    public Long getId() {
        return id;
    }

}
