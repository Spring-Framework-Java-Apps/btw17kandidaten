package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@RelationshipEntity(type="LANDESLISTE")
public class LandesListe implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;


    @NotNull
    @StartNode
    //@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_bundesland", nullable = false, updatable = false)
    private Bundesland bundesland;

    @NotNull
    @EndNode
    //@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name = "fk_listepartei", nullable = false, updatable = false)
    private ListePartei listePartei;

    //@Embedded
    @Valid
    @Relationship
    private CommonFields commonFields = new CommonFields();

    //@Transient
    @Override
    public String getName(){
        StringBuffer name = new StringBuffer();
        name.append(listePartei.getName());
        name.append(" in ");
        name.append(bundesland.getName());
        name.append(" (");
        name.append(bundesland.getName());
        name.append(")");
        return name.toString();
    }

    //@Transient
    @Override
    public String getUniqueId() {
        return this.getName()+" "+id;
    }

    public Long getId() {
        return id;
    }
}
