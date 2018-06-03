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
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class Btw17Wahlkreis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "wahlkreis_nummer", nullable=false, unique = true)
    private Long wahlkreisNummer;

    @Column(name = "wahlkreis_name", nullable=false)
    private String wahlkreisName;

    @Column(name = "bundesland_nummer", nullable=false)
    private Long bundeslandNummer;

    @Column(name = "bundesland_name", nullable=false)
    private String bundeslandName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "bundesland_kurz", nullable=false)
    private BundeslandEnum bundeslandEnumKurz;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlkreisName+" ( "+wahlkreisNummer+" ) in "+bundeslandName;
    }

    @Override
    public String getUniqueId() {
        return this.wahlkreisNummer + ":"+wahlkreisName+":"+ bundeslandEnumKurz;
    }

}
