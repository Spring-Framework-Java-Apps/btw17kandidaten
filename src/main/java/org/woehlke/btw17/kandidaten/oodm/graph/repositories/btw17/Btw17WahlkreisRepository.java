package org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Wahlkreis;

@Repository("graph.Btw17WahlkreisRepository")
public interface Btw17WahlkreisRepository extends GraphDomainRepository<Btw17Wahlkreis> {
}
