package org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Religion;

@Repository
public interface ReligionRepository extends GraphDomainRepository<Religion> {
}
