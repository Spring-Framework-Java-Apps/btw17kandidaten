package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import lombok.Getter;
import lombok.Setter;
//import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;

@Setter
@Getter
@NodeEntity
public class Partei implements GraphDomainObject {

    @Id
    @GeneratedValue
    protected Long id;

    @Property(name="partei")
    private String partei;

    @Property(name="partei_lang")
    private String parteiLang;

    //@URL
    @Property(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    //@URL
    @Property(name="wahlprogramm")
    private String wahlprogramm;

    //@URL
    @Property(name="parteiprogramm")
    private String parteiprogramm;

    @Relationship(type=PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type=LOCATION)
    private GeoPosition geoPosition = new GeoPosition();

    @Relationship(type=REDAKTION)
    private Adresse adresse = new Adresse();

    @Relationship(type=REDAKTION)
    private CommonFields commonFields = new CommonFields();

    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

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

    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }
}
