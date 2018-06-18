package org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.TechnologieStack;

@Repository("graph.TechnologieStackRepository")
public interface TechnologieStackRepository extends GraphDomainRepository<TechnologieStack> {
}
