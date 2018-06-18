package org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Mdb;

@Repository("graph.Btw17MdbRepository")
public interface Btw17MdbRepository extends GraphDomainRepository<Btw17Mdb> {
}
