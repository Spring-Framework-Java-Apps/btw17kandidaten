package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;


@NodeEntity
public class Cms extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="cms")
    private String cms;

    @Index
    @Property(name="product_info_page")
    private String productInfoPage;

    @Index
    @Property(name="product_demo_page")
    private String productDemoPage;

    @Property(name="technology_stack")
    private TechnologieStack technologyStack;// = new TechnologieStack();

    @Relationship(type = MADE_BY)
    private Hersteller hersteller;

    @Relationship(type = ONLINE_STRATEGIE)
    private OnlineStrategie onlineStrategie;// = new OnlineStrategie();

    public Cms() {
    }

    public String getCms() {
        return cms;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public String getProductInfoPage() {
        return productInfoPage;
    }

    public void setProductInfoPage(String productInfoPage) {
        this.productInfoPage = productInfoPage;
    }

    public String getProductDemoPage() {
        return productDemoPage;
    }

    public void setProductDemoPage(String productDemoPage) {
        this.productDemoPage = productDemoPage;
    }

    public TechnologieStack getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(TechnologieStack technologyStack) {
        this.technologyStack = technologyStack;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }
}
