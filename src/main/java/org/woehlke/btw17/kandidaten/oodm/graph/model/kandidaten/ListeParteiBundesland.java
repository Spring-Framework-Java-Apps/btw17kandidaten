package org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LANDESLISTE;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.REDAKTION;

@Setter
@Getter
@RelationshipEntity(type=LANDESLISTE)
public class ListeParteiBundesland implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="liste_partei_bundesland")
    private String listeParteiBundesland;

    @StartNode
    private Bundesland bundesland = new Bundesland();

    @EndNode
    private ListePartei listePartei = new ListePartei();

    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

    @Override
    public String getName(){
        return listeParteiBundesland +": "+ listePartei.getName() + " in " + bundesland.getName();
    }

    @Override
    public String getUniqueId() {
        return this.getName()+" "+id;
    }

    public Long getId() {
        return id;
    }
}
