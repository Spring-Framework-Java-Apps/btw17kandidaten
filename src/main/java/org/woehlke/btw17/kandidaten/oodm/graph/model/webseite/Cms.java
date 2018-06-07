package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.*;

@Setter
@Getter
@NodeEntity
public class Cms implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index
    @Property(name="cms")
    private String cms;

    @Index
    @Property(name="product_info_page")
    private String productInfoPage;

    @Index
    @Property(name="product_demo_page")
    private String productDemoPage;

    @Property(name="technology_stack")
    private TechnologieStack technologyStack = new TechnologieStack();

    @Relationship(type = MADE_BY)
    private Hersteller hersteller;

    @Relationship(type = PUBLISH_ONLINE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Relationship(type = REDAKTION)
    private CommonFields commonFields = new CommonFields();

    @Override
    public String getName() {
        return cms;
    }

    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }
}
