package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;


@Setter
@Getter
@NodeEntity
public class Btw17Wahlperiode implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;



    @Column
    private String wp;
    @Column
    private String mdbwpvon;
    @Column
    private String mdbwpbis;
    @Column
    private String wkrnummer;
    @Column
    private String wkrname;
    @Column
    private String wkrland;
    @Column
    private String liste;
    @Column
    private String mandatsart;

    @Column
    private String insartlang;
    @Column
    private String inslang;
    @Column
    private String mdbinsvon;
    @Column
    private String mdbinsbis;
    @Column
    private String fktlang;
    @Column
    private String fktinsvon;
    @Column
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

}
