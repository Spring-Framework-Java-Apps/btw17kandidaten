package org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen.AusschussRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.AusschussService;

@Service("graph.AusschussService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class AusschussServiceImpl extends GraphDomainServiceImpl<Ausschuss> implements AusschussService {

    @Autowired
    public AusschussServiceImpl(final AusschussRepository repository){
        super(repository);
    }

    protected AusschussRepository getRepository(){
        return (AusschussRepository) super.getRepository();
    }
}
