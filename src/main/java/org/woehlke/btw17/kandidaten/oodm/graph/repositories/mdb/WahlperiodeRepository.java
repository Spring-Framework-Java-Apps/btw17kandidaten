package org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Wahlperiode;

@Repository
public interface WahlperiodeRepository extends GraphDomainRepository<Wahlperiode> {
}
