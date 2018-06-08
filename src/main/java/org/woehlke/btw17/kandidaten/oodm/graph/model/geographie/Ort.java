package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;

@NodeEntity
public class Ort extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="ort")
    private String ort;

    @Property(name="bundesland")
    private String bundesland;

    @Property(name="nation")
    private String nation;

    //@Relationship(type=LOCATION)
    //private Bundesland bundesland = new Bundesland();

    //@Relationship(type=LOCATION)
    //private Nation nation = new Nation();

    @Relationship(type=ONLINE_STRATEGIE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type=LOCATION)
    private GeoPosition geoPosition = new GeoPosition();

    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

    @Override
    public String getName() {
        return ort;
    }

    public Ort() {
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public Webseite getWebseite() {
        return webseite;
    }

    public void setWebseite(Webseite webseite) {
        this.webseite = webseite;
    }
}
