package org.woehlke.btw17.kandidaten.oodm.graph.model.parts;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.EditStatus;



@Setter
@Getter
@NodeEntity
public class CommonFields implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index
    @Property(name="logo_url")
    private String logoUrl;

    @Index
    @Property(name="symbol_bild")
    private String symbolBild;

    @Index
    @Property(name="beschreibungs_text")
    private String beschreibungsText;

    @Property(name = "edit_status")
    private EditStatus editStatus = EditStatus.UNTOUCHED;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return logoUrl;
    }

    @Override
    public String getUniqueId() {
        return id+" "+logoUrl;
    }

    public CommonFields() {
    }
}
