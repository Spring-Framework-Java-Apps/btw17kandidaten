package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

 //import javax.persistence.Column;
 //import javax.persistence.Embedded;
 //import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class Cms implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @SafeHtml
    @NotNull
    @Property(name="cms")
    private String cms;

    //TODO: Node und Relationship
    @SafeHtml
    @Property(name="technology_stack")
    private String technologyStack;

    @SafeHtml
    @Property(name="hersteller")
    private String hersteller;

    @URL
    @Property(name="product_info_page")
    private String productInfoPage;

    @URL
    @Property(name="product_demo_page")
    private String productDemoPage;

    @Valid
    //@Embedded
    @Relationship
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    //@Embedded
    @Relationship
    private CommonFields commonFields = new CommonFields();

    @Valid
    //@Embedded
    @Relationship
    private Adresse adresse = new Adresse();

    @Valid
    //@Embedded
    @Relationship
    private GeoPosition geoPosition = new GeoPosition();

    //@Transient
    @Override
    public String getName() {
        return cms;
    }

    //@Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }
}
