package org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Kontinent;

@Repository("graph.KontinentRepository")
public interface KontinentRepository extends GraphDomainRepository<Kontinent> {
}
