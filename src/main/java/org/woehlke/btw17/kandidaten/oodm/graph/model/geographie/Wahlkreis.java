package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.WahlergebnisseBtw17;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@Setter
@Getter
@NodeEntity
public class Wahlkreis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index
    @Property(name="wahlkreis_id")
    private Long wahlkreisId;

    @Index
    @Property(name="wahlkreis_name")
    private String wahlkreisName;

    @Relationship(type = WAHLKREIS_ORT)
    private Ort ort;

    @Relationship(type = LOCATION)
    private Bundesland bundesland = new Bundesland();

    @Relationship(type = GEO_POSITION)
    private GeoPosition geoPosition = new GeoPosition();

    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

    @Relationship(type = LOCATION)
    private Strukturdaten strukturdaten = new Strukturdaten();

    @Relationship(type = WAHL)
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @Override
    public String getName() {
        return wahlkreisName + " ( " +wahlkreisId+" )";
    }

    @Override
    public String getUniqueId() {
        return this.getName()+" "+id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Wahlkreis() {
    }
}
