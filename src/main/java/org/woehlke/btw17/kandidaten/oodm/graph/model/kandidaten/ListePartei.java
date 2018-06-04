package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.*;
//import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
//import org.woehlke.btw17.kandidaten.oodm.db.model.parts.OnlineStrategie;
//import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.PUBLISH_ONLINE;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.REDAKTION;

//import javax.persistence.*;
//import javax.validation.Valid;

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

    @URL
    @Property(name="wahlprogramm")
    private String wahlprogramm;

    @URL
    @Property(name="parteiprogramm")
    private String parteiprogramm;

    @URL
    @Property(name="bundeszentrale_politische_bildung")
    private String bundeszentralePolitischeBildung;

    //@Valid
    //@Embedded
    @Relationship(type = PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    //@Valid
    //@Embedded
    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

    //@Valid
    /*
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "listepartei_agentur"
            )
        )
    })
    */
    private Webseite webseite = new Webseite();


    //@Transient
    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(listePartei);
        sb.append(" - ");
        sb.append(listeParteiLang);
        return sb.toString();
    }

    //@Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }

}
