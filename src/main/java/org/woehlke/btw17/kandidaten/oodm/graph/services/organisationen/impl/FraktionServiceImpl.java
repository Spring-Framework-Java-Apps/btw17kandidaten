package org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen.FraktionRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.FraktionService;

@Service("graph.FraktionService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class FraktionServiceImpl extends GraphDomainServiceImpl<Fraktion> implements FraktionService {

    @Autowired
    public FraktionServiceImpl(final FraktionRepository repository){
        super(repository);
    }

    protected FraktionRepository getRepository(){
        return (FraktionRepository) super.getRepository();
    }
}
