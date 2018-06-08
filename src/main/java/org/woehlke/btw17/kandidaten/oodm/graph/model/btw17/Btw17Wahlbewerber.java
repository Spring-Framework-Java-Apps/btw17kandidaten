package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Ort;
//import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.ListeParteiBundesland;

//import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@NodeEntity
public class Btw17Wahlbewerber extends GraphDomainObjectImpl implements GraphDomainObject {

    ////@NotNull
    @Property(name = "titel"/*, nullable=false*/)
    private String titel;

    //@NotNull
    @Property(name = "namenszusatz"/*, nullable=false*/)
    private String namenszusatz;

    //@NotNull
    @Property(name = "name"/*, nullable=false*/)
    private String name;

    //@NotNull
    @Property(name = "vorname"/*, nullable=false*/)
    private String vorname;

    //@NotNull
    @Property(name = "geschlecht"/*, nullable=false*/)
    private String geschlecht;

    //@NotNull
    @Property(name = "geburtsjahr"/*, nullable=false*/)
    private Integer geburtsjahr;

    //@NotNull
    @Property(name = "wohnort"/*, nullable=false*/)
    private String wohnortName;

    @Relationship(type=WOHN_ORT)
    private Ort wohnort;

    //@NotNull
    @Property(name = "geburtsort"/*, nullable=false*/)
    private String geburtsortName;

    @Relationship(type=GEBURTS_ORT)
    private Ort geburtsort;

    //@NotNull
    @Property(name = "beruf"/*, nullable=false*/)
    private String beruf;

    //@NotNull
    //@Enumerated(EnumType.STRING)
    @Property(name = "wahlkreis_land"/*, nullable=false*/)
    private BundeslandEnum wahlkreisLand;

    //@NotNull
    @Property(name = "wahlkreis_nr"/*, nullable=false*/)
    private Long wahlkreisNr;

    //@NotNull
    @Property(name = "wahlkreis_bez"/*, nullable=false*/)
    private String wahlkreisBez;

    //@NotNull
    @Property(name = "wahlkreis_partei_kurz"/*, nullable=false*/)
    private String wahlkreisParteiKurzBez;

    //@NotNull
    @Property(name = "wahlkreis_partei"/*, nullable=false*/)
    private String wahlkreisParteiBez;

    @Relationship(type = LOCATION)
    private Btw17Wahlkreis btw17Wahlkreis;

    //@NotNull
    @Property(name = "liste_land"/*, nullable=false*/)
    private String listeLand;

    //@Relationship(type = LANDESLISTE)
    //private ListeParteiBundesland listeParteiBundesland;

    //@NotNull
    @Property(name = "liste_partei_kurz"/*, nullable=false*/)
    private String listeParteiKurzBez;

    //@NotNull
    @Property(name = "liste_partei"/*, nullable=false*/)
    private String listeParteiBez;

    //@NotNull
    @Property(name = "liste_platz"/*, nullable=false*/)
    private Integer listePlatz;

    //@NotNull
    @Property(name = "wiederkandidatur"/*, nullable=false*/)
    private Boolean wiederkandidatur;

    //@Transient
    @Override
    public String getUniqueId() {
        return wahlkreisNr+":"+wahlkreisBez+":"+vorname+":"+name+":"+geburtsjahr+":"+geburtsort;
    }

    @Override
    public String getName() {
        return name+ ""+ vorname;
    }

    public Btw17Wahlbewerber() {
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

    @Override
    public void setName(String name) {
        this.name = name;
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

    public String getWohnortName() {
        return wohnortName;
    }

    public void setWohnortName(String wohnortName) {
        this.wohnortName = wohnortName;
    }

    public Ort getWohnort() {
        return wohnort;
    }

    public void setWohnort(Ort wohnort) {
        this.wohnort = wohnort;
    }

    public String getGeburtsortName() {
        return geburtsortName;
    }

    public void setGeburtsortName(String geburtsortName) {
        this.geburtsortName = geburtsortName;
    }

    public Ort getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(Ort geburtsort) {
        this.geburtsort = geburtsort;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public BundeslandEnum getWahlkreisLand() {
        return wahlkreisLand;
    }

    public void setWahlkreisLand(BundeslandEnum wahlkreisLand) {
        this.wahlkreisLand = wahlkreisLand;
    }

    public Long getWahlkreisNr() {
        return wahlkreisNr;
    }

    public void setWahlkreisNr(Long wahlkreisNr) {
        this.wahlkreisNr = wahlkreisNr;
    }

    public String getWahlkreisBez() {
        return wahlkreisBez;
    }

    public void setWahlkreisBez(String wahlkreisBez) {
        this.wahlkreisBez = wahlkreisBez;
    }

    public String getWahlkreisParteiKurzBez() {
        return wahlkreisParteiKurzBez;
    }

    public void setWahlkreisParteiKurzBez(String wahlkreisParteiKurzBez) {
        this.wahlkreisParteiKurzBez = wahlkreisParteiKurzBez;
    }

    public String getWahlkreisParteiBez() {
        return wahlkreisParteiBez;
    }

    public void setWahlkreisParteiBez(String wahlkreisParteiBez) {
        this.wahlkreisParteiBez = wahlkreisParteiBez;
    }

    public Btw17Wahlkreis getBtw17Wahlkreis() {
        return btw17Wahlkreis;
    }

    public void setBtw17Wahlkreis(Btw17Wahlkreis btw17Wahlkreis) {
        this.btw17Wahlkreis = btw17Wahlkreis;
    }

    public String getListeLand() {
        return listeLand;
    }

    public void setListeLand(String listeLand) {
        this.listeLand = listeLand;
    }
/*
    public ListeParteiBundesland getListeParteiBundesland() {
        return listeParteiBundesland;
    }

    public void setListeParteiBundesland(ListeParteiBundesland listeParteiBundesland) {
        this.listeParteiBundesland = listeParteiBundesland;
    }
*/
    public String getListeParteiKurzBez() {
        return listeParteiKurzBez;
    }

    public void setListeParteiKurzBez(String listeParteiKurzBez) {
        this.listeParteiKurzBez = listeParteiKurzBez;
    }

    public String getListeParteiBez() {
        return listeParteiBez;
    }

    public void setListeParteiBez(String listeParteiBez) {
        this.listeParteiBez = listeParteiBez;
    }

    public Integer getListePlatz() {
        return listePlatz;
    }

    public void setListePlatz(Integer listePlatz) {
        this.listePlatz = listePlatz;
    }

    public Boolean getWiederkandidatur() {
        return wiederkandidatur;
    }

    public void setWiederkandidatur(Boolean wiederkandidatur) {
        this.wiederkandidatur = wiederkandidatur;
    }
}
