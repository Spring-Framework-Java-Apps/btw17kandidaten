package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;


import lombok.Getter;
import lombok.Setter;
//import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.PUBLISH_ONLINE;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.REDAKTION;

@Setter
@Getter
@NodeEntity
public class ListePartei implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="listepartei")
    private String listePartei;

    @Property(name="listepartei_lang")
    private String listeParteiLang;

    //@URL
    @Property(name="wahlprogramm")
    private String wahlprogramm;

    //@URL
    @Property(name="parteiprogramm")
    private String parteiprogramm;

    //@URL
    @Property(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    @Relationship(type = PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

    @Relationship(type = PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();


    @Override
    public String getName() {
        return listePartei + " - " + listeParteiLang;
    }

    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }

}
