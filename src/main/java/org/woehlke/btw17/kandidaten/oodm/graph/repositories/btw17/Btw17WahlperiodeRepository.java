package org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Wahlperiode;

@Repository("graph.Btw17WahlperiodeRepository")
public interface Btw17WahlperiodeRepository extends GraphDomainRepository<Btw17Wahlperiode> {
}
