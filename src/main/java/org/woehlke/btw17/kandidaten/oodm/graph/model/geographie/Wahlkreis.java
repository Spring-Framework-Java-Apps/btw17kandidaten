package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.WahlergebnisseBtw17;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.WAHLKREIS_ORT;


@Setter
@Getter
@NodeEntity
public class Wahlkreis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Property(name="wahlkreis_id")
    private Long wahlkreisId;

    @Property(name="wahlkreis_name")
    private String wahlkreisName;

    @Relationship(type = WAHLKREIS_ORT)
    private Ort ort;

    @Relationship(type = LOCATION)
    private Bundesland bundesland = new Bundesland();

    @Valid
    @Relationship
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Relationship
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Relationship
    private Strukturdaten strukturdaten = new Strukturdaten();

    @Valid
    @Relationship
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @Override
    public String getName() {
        return wahlkreisName + " ( " +wahlkreisId+" )";
    }

    @Override
    public String getUniqueId() {
        return this.getName()+" "+id;
    }

    public Long getId() {
        return id;
    }
}
