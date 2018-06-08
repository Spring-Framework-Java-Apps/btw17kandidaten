package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.WahlergebnisseBtw17;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;


@NodeEntity
public class Wahlkreis extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="wahlkreis_id")
    private Long wahlkreisId;

    @Index
    @Property(name="wahlkreis_name")
    private String wahlkreisName;

    @Relationship(type = WAHLKREIS_ORT)
    private Ort ort;

    @Relationship(type = LOCATION)
    private Bundesland bundesland;// = new Bundesland();

    @Relationship(type = GEO_POSITION)
    private GeoPosition geoPosition;// = new GeoPosition();

    @Relationship(type = LOCATION)
    private Strukturdaten strukturdaten;// = new Strukturdaten();

    @Relationship(type = WAHL)
    private WahlergebnisseBtw17 wahlergebnisseBtw17;// = new WahlergebnisseBtw17();

    @Override
    public String getName() {
        return wahlkreisName + " ( " +wahlkreisId+" )";
    }

    public Wahlkreis() {
    }

    public Long getWahlkreisId() {
        return wahlkreisId;
    }

    public void setWahlkreisId(Long wahlkreisId) {
        this.wahlkreisId = wahlkreisId;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public Strukturdaten getStrukturdaten() {
        return strukturdaten;
    }

    public void setStrukturdaten(Strukturdaten strukturdaten) {
        this.strukturdaten = strukturdaten;
    }

    public WahlergebnisseBtw17 getWahlergebnisseBtw17() {
        return wahlergebnisseBtw17;
    }

    public void setWahlergebnisseBtw17(WahlergebnisseBtw17 wahlergebnisseBtw17) {
        this.wahlergebnisseBtw17 = wahlergebnisseBtw17;
    }
}
