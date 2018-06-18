package org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Strukturdaten;

@Repository("graph.StrukturdatenRepository")
public interface StrukturdatenRepository extends GraphDomainRepository<Strukturdaten> {
}
