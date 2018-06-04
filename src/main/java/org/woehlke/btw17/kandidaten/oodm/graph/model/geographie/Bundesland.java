package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;

//import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;


@Setter
@Getter
@NodeEntity
public class Bundesland implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    //@Enumerated(EnumType.STRING)
    @NotNull
    @Property(name="bundesland")
    private BundeslandEnum bundesland;

    @NotNull
    @Property(name="bundesland_lang")
    private String bundeslandLang;

    //@Embedded
    //@Valid
    @Relationship(type=PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    //@Embedded
    //@Valid
    @Relationship(type=REDAKTION)
    private CommonFields commonFields = new CommonFields();

    /*
    @Embedded
    @AssociationOverrides({
        @AssociationOverride(
            name = "agenturen",
            joinTable = @JoinTable(
                name = "bundesland_agentur"
            )
        )
    })
    */
    //@Valid
    @Relationship(type=PUBLISH_ONLINE)
    private Webseite webseite = new Webseite();

    //@Embedded
    //@Valid
    @Relationship(type=LOCATION)
    private Strukturdaten strukturdaten = new Strukturdaten();

    //@Embedded
    //@Valid
    @Relationship(type=WAHL)
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @Override
    public String getName(){
        return bundesland+" "+bundeslandLang+" ";
    }

    @Override
    public String getUniqueId() {
        return this.getName()+" "+id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
