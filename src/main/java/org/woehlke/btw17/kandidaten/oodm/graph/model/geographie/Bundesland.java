package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@NodeEntity
public class Bundesland extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique=true)
    @Property(name="bundesland")
    private BundeslandEnum bundesland;

    @Index(unique=true)
    @Property(name="bundesland_lang")
    private String bundeslandLang;

    @Relationship(type=PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

    @Relationship(type=LOCATION)
    private Strukturdaten strukturdaten = new Strukturdaten();

    @Relationship(type=WAHL)
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @Override
    public String getName(){
        return bundesland+" "+bundeslandLang+" ";
    }

    public Bundesland() {
    }

    public BundeslandEnum getBundesland() {
        return bundesland;
    }

    public void setBundesland(BundeslandEnum bundesland) {
        this.bundesland = bundesland;
    }

    public String getBundeslandLang() {
        return bundeslandLang;
    }

    public void setBundeslandLang(String bundeslandLang) {
        this.bundeslandLang = bundeslandLang;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    public Webseite getWebseite() {
        return webseite;
    }

    public void setWebseite(Webseite webseite) {
        this.webseite = webseite;
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
