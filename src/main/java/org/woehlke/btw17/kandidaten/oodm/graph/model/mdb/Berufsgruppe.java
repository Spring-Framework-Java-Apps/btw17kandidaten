package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.EditStatus;
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
    @Property(name="berufsgruppe")
    private String berufsgruppe;

    @Property(name="edit_status")
    private EditStatus editStatus = EditStatus.UNTOUCHED;

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return berufsgruppe;
    }

    public String getUniqueId() {
        return id + ":"+this.getName();
    }
}
