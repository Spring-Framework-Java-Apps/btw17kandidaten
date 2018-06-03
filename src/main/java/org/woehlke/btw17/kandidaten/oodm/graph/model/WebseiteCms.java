package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Adresse;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class WebseiteCms implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;


    @SafeHtml
    @NotNull
    @Column(name="cms")
    private String cms;

    @SafeHtml
    @Column(name="technology_stack")
    private String technologyStack;

    @SafeHtml
    @Column(name="hersteller")
    private String hersteller;

    @URL
    @Column(name="product_info_page")
    private String productInfoPage;

    @URL
    @Column(name="product_demo_page")
    private String productDemoPage;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private Adresse adresse = new Adresse();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Transient
    @Override
    public String getName() {
        return cms;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    @Override
    public Long getId() {
        return id;
    }
}
