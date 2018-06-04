package org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.Kandidat;

@Repository
public interface KandidatRepository extends GraphDomainRepository<Kandidat> {
}
