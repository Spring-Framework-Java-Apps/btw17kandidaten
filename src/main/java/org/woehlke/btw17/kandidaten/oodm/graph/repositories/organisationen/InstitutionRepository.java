package org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen;

import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Institution;

@Repository
public interface InstitutionRepository extends GraphDomainRepository<Institution> {
}
