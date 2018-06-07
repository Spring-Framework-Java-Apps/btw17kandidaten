package org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Partei;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen.ParteiRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.organisationen.ParteiService;

@Service("graph.ParteiService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ParteiServiceImpl extends GraphDomainServiceImpl<Partei> implements ParteiService {

    @Autowired
    public ParteiServiceImpl(final ParteiRepository repository){
        super(repository);
    }

    protected ParteiRepository getRepository(){
        return (ParteiRepository) super.getRepository();
    }

}
