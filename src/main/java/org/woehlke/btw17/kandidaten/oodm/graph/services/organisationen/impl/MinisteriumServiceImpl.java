package org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen.MinisteriumRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.MinisteriumService;

@Service("graph.MinisteriumService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class MinisteriumServiceImpl extends GraphDomainServiceImpl<Ministerium> implements MinisteriumService {

    @Autowired
    public MinisteriumServiceImpl(final MinisteriumRepository repository){
        super(repository);
    }

    protected MinisteriumRepository getRepository(){
        return (MinisteriumRepository) super.getRepository();
    }

}
