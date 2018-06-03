package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.EditStatus;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NodeEntity
public class Beruf implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String beruf;

    private EditStatus editStatus = EditStatus.UNTOUCHED;

    @Transient
    public String getName() {
        return beruf;
    }

    @Transient
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

}
