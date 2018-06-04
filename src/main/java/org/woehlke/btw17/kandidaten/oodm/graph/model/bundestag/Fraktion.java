package org.woehlke.btw17.kandidaten.oodm.graph.model.bundestag;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

 //import javax.persistence.*;
import javax.validation.Valid;


@Setter
@Getter
@NodeEntity
public class Fraktion implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="fraktion")
    private String fraktion;

    @Property(name="fraktion_lang")
    private String fraktionLang;

    @Valid
    //@Embedded
    @Relationship
    private CommonFields commonFields = new CommonFields();

    @Valid
    //@Embedded
    @Relationship
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
    @Relationship
    private Webseite webseite = new Webseite();

    //@Transient
    //@Override
    public String getName() {
        return fraktionLang;
    }

    //@Transient
    //@Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    //@Override
    public Long getId() {
        return id;
    }
}
