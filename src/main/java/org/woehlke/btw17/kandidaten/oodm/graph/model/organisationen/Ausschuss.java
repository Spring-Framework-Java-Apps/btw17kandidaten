package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.parts.OnlineStrategie;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.ONLINE_STRATEGIE;

@NodeEntity
public class Ausschuss extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name="ausschuss")
    private String ausschuss;

    //@Valid
    @Relationship(type= ONLINE_STRATEGIE)
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Override
    public String getName() {
        return ausschuss;
    }

    public Ausschuss() {
    }

    public String getAusschuss() {
        return ausschuss;
    }

    public void setAusschuss(String ausschuss) {
        this.ausschuss = ausschuss;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }
}
