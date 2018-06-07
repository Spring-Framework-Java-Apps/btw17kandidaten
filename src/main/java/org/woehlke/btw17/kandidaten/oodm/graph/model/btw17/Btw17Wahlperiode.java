package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

//import javax.persistence.Column;

//TODO: Node contains Information about Wahlperiode of: one MDB?
/**
 * Node contains Information about Wahlperiode of: one MDB?
 */
@Setter
@Getter
@NodeEntity
public class Btw17Wahlperiode implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;


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

    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wkrname;
    }

    @Override
    public String getUniqueId() {
        return wp;
    }

    public Btw17Wahlperiode() {
    }
}
