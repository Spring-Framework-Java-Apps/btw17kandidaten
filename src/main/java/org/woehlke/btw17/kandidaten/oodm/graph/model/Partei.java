package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.WahlergebnisseBtw17;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

//import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NodeEntity
public class Partei implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Property(name="wahlkreis_id")
    private Long wahlkreisId;

    @Property(name="wahlkreis_name")
    private String wahlkreisName;

    //@Embedded
    //@Valid
    @Relationship
    private GeoPosition geoPosition = new GeoPosition();

    //@Embedded
    //@Valid
    @Relationship
    private CommonFields commonFields = new CommonFields();

    //@Embedded
    //@Valid
    @Relationship
    private Strukturdaten strukturdaten = new Strukturdaten();

    //@Embedded
    //@Valid
    @Relationship
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @Relationship(type="Partei_Gliederung_nach_Bundesland", direction=Relationship.OUTGOING)
    //@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_bundesland", nullable = true, updatable = true)
    private Bundesland bundesland;

    @Override
    public String getName() {
        return wahlkreisName + " ( " +wahlkreisId+" )";
    }

    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }
}
