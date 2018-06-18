package org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.ListePartei;

@Repository("graph.ListeParteiRepository")
public interface ListeParteiRepository extends GraphDomainRepository<ListePartei> {
}
