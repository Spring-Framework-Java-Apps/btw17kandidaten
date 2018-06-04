package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;

//import javax.persistence.Column;
//import javax.persistence.Embedded;
//import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NodeEntity
public class Agentur implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @SafeHtml
    @NotNull
    @Property(name="name_marketing")
    private String agentur;

    @SafeHtml
    @NotNull
    @Property(name="name_registereintrag")
    private String firma;

    @Valid
    //@Embedded
    @Relationship
    private Adresse adresse = new Adresse();

    @Valid
    //@Embedded
    @Relationship
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    //@Embedded
    @Relationship
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    //@Embedded
    @Relationship
    private CommonFields commonFields = new CommonFields();

    //@Transient
    //@Override
    public String getName() {
        return agentur;
    }

    //@Transient
    //@Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }
}
