package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.validation.Valid;

@Setter
@Getter
@NodeEntity
public class Ausschuss implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    private String ausschuss;

    @Valid
    private CommonFields commonFields = new CommonFields();

    @Valid
    private OnlineStrategie onlineStrategie = new OnlineStrategie();
}
