package org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Dienstleister;

@Repository("graph.DienstleisterRepository")
public interface DienstleisterRepository extends GraphDomainRepository<Dienstleister> {
}
