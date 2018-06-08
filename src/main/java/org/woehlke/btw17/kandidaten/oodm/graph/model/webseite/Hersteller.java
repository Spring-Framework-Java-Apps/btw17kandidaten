package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;


@NodeEntity
public class Hersteller extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index
    @Property(name="hersteller")
    private String hersteller;

    @Index
    @Property(name="hersteller")
    private String firmierung;

    @Relationship(type = LOCATION)
    private Adresse adresse;// = new Adresse();

    @Relationship(type = GEO_POSITION)
    private GeoPosition geoPosition;// = new GeoPosition();

    @Override
    public String getName() {
        return hersteller;
    }

    @Override
    public String getUniqueId() {
        return hersteller+" "+getId();
    }


    public Hersteller() {
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getFirmierung() {
        return firmierung;
    }

    public void setFirmierung(String firmierung) {
        this.firmierung = firmierung;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }
}
