package org.woehlke.btw17.kandidaten.oodm.graph.model;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Setter
@Getter
@NodeEntity
public class WebseiteAgentur {

    @Id
    @GeneratedValue
    private Long id;

}
