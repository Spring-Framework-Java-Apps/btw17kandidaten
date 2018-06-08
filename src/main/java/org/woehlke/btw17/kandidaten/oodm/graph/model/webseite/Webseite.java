package org.woehlke.btw17.kandidaten.oodm.graph.model.webseite;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;

import java.util.LinkedHashSet;
import java.util.Set;

@NodeEntity
public class Webseite extends GraphDomainObjectImpl implements GraphDomainObject {

    //@URL
    @Index(unique = true)
    @Property(name="webseite_url")
    private String webseite;

    //@SafeHtml
    //@NotNull
    @Index
    @Property(name="webseite_name")
    private String name;

    @Property(name="domain_registry_info")
    private String domainRegistryInfo;

    @Relationship(type = MADE_WITH)
    private Cms cms = new Cms();

    @Relationship(type = MADE_BY)
    private Set<Dienstleister> agenturen = new LinkedHashSet<>();

    public Webseite() {
    }

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDomainRegistryInfo() {
        return domainRegistryInfo;
    }

    public void setDomainRegistryInfo(String domainRegistryInfo) {
        this.domainRegistryInfo = domainRegistryInfo;
    }

    public Cms getCms() {
        return cms;
    }

    public void setCms(Cms cms) {
        this.cms = cms;
    }

    public Set<Dienstleister> getAgenturen() {
        return agenturen;
    }

    public void setAgenturen(Set<Dienstleister> agenturen) {
        this.agenturen = agenturen;
    }
}
