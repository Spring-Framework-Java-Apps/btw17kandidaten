package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;


@NodeEntity
public class Ministerium extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="ministerium")
    private String ministerium;

    @Index(unique = true)
    @Property(name="ministerium_lang")
    private String ministeriumLang;

    @Property(name="bundesminister")
    private String bundesministerName;

    @Relationship(type=JOB)
    private Kandidat bundesminister;

    @Relationship(type=LOCATION)
    private OnlineStrategie onlineStrategie;// = new OnlineStrategie();

    @Relationship(type=LOCATION)
    private GeoPosition geoPosition;// = new GeoPosition();

    @Relationship(type=LOCATION)
    private Adresse adresse;// = new Adresse();

    @Relationship(type=ONLINE_STRATEGIE)
    private Webseite webseite;// = new Webseite();


    public Ministerium() {
    }

    public String getMinisterium() {
        return ministerium;
    }

    public void setMinisterium(String ministerium) {
        this.ministerium = ministerium;
    }

    public String getMinisteriumLang() {
        return ministeriumLang;
    }

    public void setMinisteriumLang(String ministeriumLang) {
        this.ministeriumLang = ministeriumLang;
    }

    public String getBundesministerName() {
        return bundesministerName;
    }

    public void setBundesministerName(String bundesministerName) {
        this.bundesministerName = bundesministerName;
    }

    public Kandidat getBundesminister() {
        return bundesminister;
    }

    public void setBundesminister(Kandidat bundesminister) {
        this.bundesminister = bundesminister;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Webseite getWebseite() {
        return webseite;
    }

    public void setWebseite(Webseite webseite) {
        this.webseite = webseite;
    }
}
