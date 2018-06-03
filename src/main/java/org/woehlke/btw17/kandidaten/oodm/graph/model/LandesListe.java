package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class LandesListe implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;


    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = false, updatable = false)
    private Bundesland bundesland;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_listepartei", nullable = false, updatable = false)
    private ListePartei listePartei;

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Transient
    @Override
    public String getName(){
        StringBuffer name = new StringBuffer();
        name.append(listePartei.getListePartei());
        name.append(" in ");
        name.append(bundesland.getBundeslandLang());
        name.append(" (");
        name.append(bundesland.getBundesland());
        name.append(")");
        return name.toString();
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }
}
