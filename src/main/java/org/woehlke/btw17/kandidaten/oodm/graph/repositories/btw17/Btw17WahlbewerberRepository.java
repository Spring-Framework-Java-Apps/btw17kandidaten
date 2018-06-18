package org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Wahlbewerber;

@Repository("graph.Btw17WahlbewerberRepository")
public interface Btw17WahlbewerberRepository extends GraphDomainRepository<Btw17Wahlbewerber> {
}
