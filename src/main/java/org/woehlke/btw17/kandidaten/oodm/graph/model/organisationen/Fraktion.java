package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
//import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
//import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

@NodeEntity
public class Fraktion extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="fraktion")
    private String fraktion;

    @Index(unique = true)
    @Property(name="fraktion_lang")
    private String fraktionLang;

    //@Relationship(type = ONLINE_STRATEGIE)
    //private OnlineStrategie onlineStrategie;// = new OnlineStrategie();

    //@Relationship(type = ONLINE_STRATEGIE)
    //private Webseite webseite;// = new Webseite();

    @Override
    public String getName() {
        return fraktionLang;
    }

    public Fraktion() {
    }

    public String getFraktion() {
        return fraktion;
    }

    public void setFraktion(String fraktion) {
        this.fraktion = fraktion;
    }

    public String getFraktionLang() {
        return fraktionLang;
    }

    public void setFraktionLang(String fraktionLang) {
        this.fraktionLang = fraktionLang;
    }
/*
    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }
*/
/*
    public Webseite getWebseite() {
        return webseite;
    }

    public void setWebseite(Webseite webseite) {
        this.webseite = webseite;
    }
    */
}
