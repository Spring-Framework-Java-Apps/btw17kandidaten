package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import javax.validation.Valid;


@Setter
@Getter
@NodeEntity
public class Fraktion implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(name="fraktion")
    private String fraktion;

    //@Column(name="fraktion_lang")
    private String fraktionLang;

    @Valid
    //@Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    //@Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    /*
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "fraktion_agentur"
            )
        )
    })
    */
    private Webseite webseite = new Webseite();

    @Transient
    //@Override
    public String getName() {
        return fraktionLang;
    }

    @Transient
    //@Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    //@Override
    public Long getId() {
        return id;
    }
}
