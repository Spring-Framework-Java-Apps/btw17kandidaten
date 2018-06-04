package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import lombok.Getter;
import lombok.Setter;
//import org.hibernate.validator.constraints.SafeHtml;
//import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

//import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.MADE_BY;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.MADE_WITH;

@Setter
@Getter
@NodeEntity
public class Webseite implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    //@URL
    @Property(name="webseite_url")
    private String webseite;

    //@SafeHtml
    //@NotNull
    @Property(name="webseite_name")
    private String name;

    @Property(name="domain_registry_info")
    private String domainRegistryInfo;

    @Relationship(type = MADE_WITH)
    private Cms cms = new Cms();

    @Relationship(type = MADE_BY)
    private Set<Dienstleister> agenturen = new LinkedHashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUniqueId() {
        return name+" "+id;
    }
}
