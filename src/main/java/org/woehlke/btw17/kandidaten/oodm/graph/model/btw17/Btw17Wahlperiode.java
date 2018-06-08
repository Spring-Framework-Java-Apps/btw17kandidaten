package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;


//TODO: Node contains Information about Wahlperiode of: one MDB?
/**
 * Node contains Information about Wahlperiode of: one MDB?
 */
@NodeEntity
public class Btw17Wahlperiode extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="wahlperiode")
    private String wp;

    @Property(name="mdb_wahlperiode_von")
    private String mdbwpvon;

    @Property(name="mdb_wahlperiode_bis")
    private String mdbwpbis;

    //TODO: is it a relationship to Wahlkreis?
    @Index
    @Property(name="wahlkreis_nummer")
    private String wkrnummer;

    //TODO: is it a relationship to Wahlkreis?
    @Index
    @Property(name="wahlkreis_name")
    private String wkrname;

    //TODO: is it a relationship to Bundesland?
    @Index
    @Property(name="wahlkreis_land")
    private String wkrland;

    @Index
    @Property(name="liste")
    private String liste;

    @Index
    @Property(name="mandats_art")
    private String mandatsart;

    @Index
    @Property(name="insartlang")
    private String insartlang;

    @Property
    private String inslang;

    @Property
    private String mdbinsvon;

    @Property
    private String mdbinsbis;

    @Property
    private String fktlang;

    @Property
    private String fktinsvon;

    @Property
    private String fktinsbis;

    @Override
    public String getName() {
        return wp;
    }

    @Override
    public String getUniqueId() {
        return getName() + " " + wkrnummer + " " + getId();
    }

    public Btw17Wahlperiode() {
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public String getMdbwpvon() {
        return mdbwpvon;
    }

    public void setMdbwpvon(String mdbwpvon) {
        this.mdbwpvon = mdbwpvon;
    }

    public String getMdbwpbis() {
        return mdbwpbis;
    }

    public void setMdbwpbis(String mdbwpbis) {
        this.mdbwpbis = mdbwpbis;
    }

    public String getWkrnummer() {
        return wkrnummer;
    }

    public void setWkrnummer(String wkrnummer) {
        this.wkrnummer = wkrnummer;
    }

    public String getWkrname() {
        return wkrname;
    }

    public void setWkrname(String wkrname) {
        this.wkrname = wkrname;
    }

    public String getWkrland() {
        return wkrland;
    }

    public void setWkrland(String wkrland) {
        this.wkrland = wkrland;
    }

    public String getListe() {
        return liste;
    }

    public void setListe(String liste) {
        this.liste = liste;
    }

    public String getMandatsart() {
        return mandatsart;
    }

    public void setMandatsart(String mandatsart) {
        this.mandatsart = mandatsart;
    }

    public String getInsartlang() {
        return insartlang;
    }

    public void setInsartlang(String insartlang) {
        this.insartlang = insartlang;
    }

    public String getInslang() {
        return inslang;
    }

    public void setInslang(String inslang) {
        this.inslang = inslang;
    }

    public String getMdbinsvon() {
        return mdbinsvon;
    }

    public void setMdbinsvon(String mdbinsvon) {
        this.mdbinsvon = mdbinsvon;
    }

    public String getMdbinsbis() {
        return mdbinsbis;
    }

    public void setMdbinsbis(String mdbinsbis) {
        this.mdbinsbis = mdbinsbis;
    }

    public String getFktlang() {
        return fktlang;
    }

    public void setFktlang(String fktlang) {
        this.fktlang = fktlang;
    }

    public String getFktinsvon() {
        return fktinsvon;
    }

    public void setFktinsvon(String fktinsvon) {
        this.fktinsvon = fktinsvon;
    }

    public String getFktinsbis() {
        return fktinsbis;
    }

    public void setFktinsbis(String fktinsbis) {
        this.fktinsbis = fktinsbis;
    }
}
