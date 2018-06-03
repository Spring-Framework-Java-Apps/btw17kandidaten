package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;


@Setter
@Getter
@NodeEntity
public class Wahlkreis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

}
