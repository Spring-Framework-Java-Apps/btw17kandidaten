package org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Institution;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen.InstitutionRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.InstitutionService;

@Service("graph.InstitutionService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class InstitutionServiceImpl extends GraphDomainServiceImpl<Institution> implements InstitutionService {

    @Autowired
    public InstitutionServiceImpl(@Qualifier("graph.InstitutionRepository") final InstitutionRepository repository){
        super(repository);
    }

    protected InstitutionRepository getRepository(){
        return (InstitutionRepository) super.getRepository();
    }
}
