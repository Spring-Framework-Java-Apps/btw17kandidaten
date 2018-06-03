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


@Setter
@Getter
@NodeEntity
public class Btw17Wahlbewerber implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "titel", nullable=false)
    private String titel;

    @NotNull
    @Column(name = "namenszusatz", nullable=false)
    private String namenszusatz;

    @NotNull
    @Column(name = "name", nullable=false)
    private String name;

    @NotNull
    @Column(name = "vorname", nullable=false)
    private String vorname;

    @NotNull
    @Column(name = "geschlecht", nullable=false)
    private String geschlecht;

    @NotNull
    @Column(name = "geburtsjahr", nullable=false)
    private Integer geburtsjahr;

    @NotNull
    @Column(name = "wohnort", nullable=false)
    private String wohnort;

    @NotNull
    @Column(name = "geburtsort", nullable=false)
    private String geburtsort;

    @NotNull
    @Column(name = "beruf", nullable=false)
    private String beruf;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "wahlkreis_land", nullable=false)
    private BundeslandEnum wahlkreisLand;

    @NotNull
    @Column(name = "wahlkreis_nr", nullable=false)
    private Long wahlkreisNr;

    @NotNull
    @Column(name = "wahlkreis_bez", nullable=false)
    private String wahlkreisBez;

    @NotNull
    @Column(name = "wahlkreis_partei_kurz", nullable=false)
    private String wahlkreisParteiKurzBez;

    @NotNull
    @Column(name = "wahlkreis_partei", nullable=false)
    private String wahlkreisParteiBez;

    @NotNull
    @Column(name = "liste_land", nullable=false)
    private String listeLand;

    @NotNull
    @Column(name = "liste_partei_kurz", nullable=false)
    private String listeParteiKurzBez;

    @NotNull
    @Column(name = "liste_partei", nullable=false)
    private String listeParteiBez;

    @NotNull
    @Column(name = "liste_platz", nullable=false)
    private Integer listePlatz;

    @NotNull
    @Column(name = "wiederkandidatur", nullable=false)
    private Boolean wiederkandidatur;

    @Transient
    @Override
    public String getUniqueId() {
        return wahlkreisNr+":"+wahlkreisBez+":"+vorname+":"+name+":"+geburtsjahr+":"+geburtsort;
    }

    public Long getId() {
        return id;
    }

}
