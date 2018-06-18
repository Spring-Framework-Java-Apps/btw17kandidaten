package org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.Kandidat;

@Repository("graph.KandidatRepository")
public interface KandidatRepository extends GraphDomainRepository<Kandidat> {
}
