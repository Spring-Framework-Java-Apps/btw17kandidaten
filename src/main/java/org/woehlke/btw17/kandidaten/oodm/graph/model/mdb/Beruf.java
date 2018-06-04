package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.EditStatus;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NodeEntity
public class Beruf implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Property(name="beruf")
    private String beruf;

    @Property(name="edit_status")
    private EditStatus editStatus = EditStatus.UNTOUCHED;

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return beruf;
    }

    public String getUniqueId() {
        return id + ":"+this.getName();
    }

}
