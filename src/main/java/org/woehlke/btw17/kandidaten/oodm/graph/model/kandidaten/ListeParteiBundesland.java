package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.REDAKTION;


@Setter
@Getter
@RelationshipEntity(type="LANDESLISTE")
public class ListeParteiBundesland implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Bundesland bundesland = new Bundesland();

    @EndNode
    private ListePartei listePartei = new ListePartei();

    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

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

    @Override
    public String getUniqueId() {
        return this.getName()+" "+id;
    }

    public Long getId() {
        return id;
    }
}
