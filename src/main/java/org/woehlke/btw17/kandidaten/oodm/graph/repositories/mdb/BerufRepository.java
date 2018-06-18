package org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Beruf;

@Repository("graph.BerufRepository")
public interface BerufRepository extends GraphDomainRepository<Beruf> {
}
