package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;


import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.PUBLISH_ONLINE;

@NodeEntity
public class ListePartei extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="listepartei")
    private String listePartei;

    @Index(unique = true)
    @Property(name="listepartei_lang")
    private String listeParteiLang;

    //@URL
    @Index
    @Property(name="wahlprogramm")
    private String wahlprogramm;

    //@URL
    @Index
    @Property(name="parteiprogramm")
    private String parteiprogramm;

    //@URL
    @Index
    @Property(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @Relationship(type = PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type = PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();


    @Override
    public String getName() {
        return listePartei + " - " + listeParteiLang;
    }

    public ListePartei() {
    }
}
