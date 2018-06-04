package org.woehlke.btw17.kandidaten.oodm.graph.model.parts;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.EditStatus;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

@Setter
@Getter
@NodeEntity
public class CommonFields implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @URL
    @Column(name="logo_url")
    private String logoUrl;

    @URL
    @Column(name="symbol_bild")
    private String symbolBild;

    @Lob
    @Column(name="beschreibungs_text")
    private String beschreibungsText;

    @Enumerated(EnumType.STRING)
    @Column(name = "edit_status")
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
}
