package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.BundeslandRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.BundeslandService;

@Service("graph.BundeslandService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class BundeslandServiceImpl extends GraphDomainServiceImpl<Bundesland> implements BundeslandService {

    @Autowired
    public BundeslandServiceImpl(@Qualifier("graph.BundeslandRepository") final BundeslandRepository bundeslandRepository){
        super(bundeslandRepository);
    }

    protected BundeslandRepository getRepository(){
        return (BundeslandRepository) super.getRepository();
    }

}
