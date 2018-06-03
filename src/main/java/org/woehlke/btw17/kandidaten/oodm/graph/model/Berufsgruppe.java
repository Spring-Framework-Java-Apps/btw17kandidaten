package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.EditStatus;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NodeEntity
public class Berufsgruppe implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;


    @NotNull
    //@Column(name = "berufsgruppe",unique = true, nullable = false)
    private String berufsgruppe;

    private EditStatus editStatus = EditStatus.UNTOUCHED;

    public String getName() {
        return berufsgruppe;
    }

    public String getUniqueId() {
        return id + ":"+this.getName();
    }
}
