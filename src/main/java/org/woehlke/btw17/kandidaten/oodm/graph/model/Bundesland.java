package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class Bundesland implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;


    @NotNull
    //@Enumerated(EnumType.STRING)
    //@Column(name = "bundesland", nullable=false)
    private BundeslandEnum bundesland;

    @NotNull
    //@Column(name="bundesland_lang",nullable = false)
    private String bundeslandLang;

    @Valid
    //@Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    //@Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
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
    private Webseite webseite = new Webseite();

    @Valid
    //@Embedded
    private Strukturdaten strukturdaten = new Strukturdaten();


    @Valid
    //@Embedded
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @Transient
    public String getName(){
        StringBuffer name = new StringBuffer();
        name.append(bundeslandLang);
        name.append(" (");
        name.append(bundesland);
        name.append(")");
        return name.toString();
    }

    @Transient
    //@Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }
}
