package org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.TechnologieStack;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite.TechnologieStackRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.TechnologieStackService;

@Service("graph.TechnologieStackService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class TechnologieStackServiceImpl extends GraphDomainServiceImpl<TechnologieStack> implements TechnologieStackService {

    @Autowired
    public TechnologieStackServiceImpl(final TechnologieStackRepository repository){
        super(repository);
    }

    protected TechnologieStackRepository getRepository(){
        return (TechnologieStackRepository) super.getRepository();
    }

}
