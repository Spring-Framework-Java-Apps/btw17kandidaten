package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

//import javax.validation.Valid;

@Setter
@Getter
@NodeEntity
public class Ausschuss implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="ausschuss")
    private String ausschuss;

    //@Valid
    @Relationship
    private CommonFields commonFields = new CommonFields();

    //@Valid
    @Relationship
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return ausschuss;
    }

    @Override
    public String getUniqueId() {
        return ausschuss+" "+id;
    }

}
