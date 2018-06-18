package org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17KandidatFlat;

@Repository("graph.Btw17KandidatFlatRepository")
public interface Btw17KandidatFlatRepository extends GraphDomainRepository<Btw17KandidatFlat> {
}
