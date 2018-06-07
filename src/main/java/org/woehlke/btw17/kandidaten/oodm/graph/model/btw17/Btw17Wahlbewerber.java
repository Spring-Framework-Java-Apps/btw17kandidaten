package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Ort;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.ListeParteiBundesland;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;

//import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class Btw17Wahlbewerber implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

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

    @Relationship(type = LANDESLISTE)
    private ListeParteiBundesland listeParteiBundesland;

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

    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return null;
    }

}
