package org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;

@Repository
public interface BundeslandRepository extends GraphDomainRepository<Bundesland> {
}
