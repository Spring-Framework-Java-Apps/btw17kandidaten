package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.PUBLISH_ONLINE;


@NodeEntity
public class Dienstleister extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index
    @Property(name="name_marketing")
    private String dienstleister;

    @Index(unique=true)
    @Property(name="name_registereintrag")
    private String firma;

    @Relationship(type = LOCATION)
    private Adresse adresse = new Adresse();

    @Relationship(type = LOCATION)
    private GeoPosition geoPosition = new GeoPosition();

    @Relationship(type = PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    public Dienstleister() {
    }

    public String getDienstleister() {
        return dienstleister;
    }

    public void setDienstleister(String dienstleister) {
        this.dienstleister = dienstleister;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
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

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }
}
