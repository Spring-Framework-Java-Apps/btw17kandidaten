package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;


@NodeEntity
public class Partei extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="partei")
    private String partei;

    @Index(unique=true)
    @Property(name="partei_lang")
    private String parteiLang;

    //@URL
    @Index
    @Property(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    //@URL
    @Index
    @Property(name="wahlprogramm")
    private String wahlprogramm;

    //@URL
    @Index
    @Property(name="parteiprogramm")
    private String parteiprogramm;

    @Relationship(type=ONLINE_STRATEGIE)
    private OnlineStrategie onlineStrategie;// = new OnlineStrategie();

    @Relationship(type=LOCATION)
    private GeoPosition geoPosition;// = new GeoPosition();

    @Relationship(type=REDAKTION)
    private Adresse adresse;// = new Adresse();

    @Relationship(type=ONLINE_STRATEGIE)
    private Webseite webseite;// = new Webseite();

    public Partei() {
    }

    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(partei);
        if(partei.compareTo(parteiLang)!=0){
            sb.append(" - ");
            sb.append(parteiLang);
        }
        return sb.toString();
    }

    public String getPartei() {
        return partei;
    }

    public void setPartei(String partei) {
        this.partei = partei;
    }

    public String getParteiLang() {
        return parteiLang;
    }

    public void setParteiLang(String parteiLang) {
        this.parteiLang = parteiLang;
    }

    public String getBundeszentralePolitischeBildung() {
        return bundeszentralePolitischeBildung;
    }

    public void setBundeszentralePolitischeBildung(String bundeszentralePolitischeBildung) {
        this.bundeszentralePolitischeBildung = bundeszentralePolitischeBildung;
    }

    public String getWahlprogramm() {
        return wahlprogramm;
    }

    public void setWahlprogramm(String wahlprogramm) {
        this.wahlprogramm = wahlprogramm;
    }

    public String getParteiprogramm() {
        return parteiprogramm;
    }

    public void setParteiprogramm(String parteiprogramm) {
        this.parteiprogramm = parteiprogramm;
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
