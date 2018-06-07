package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Nation;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.NationRespository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.NationService;

@Service("graph.NationService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class NationServiceImpl extends GraphDomainServiceImpl<Nation> implements NationService {

    @Autowired
    public NationServiceImpl(final NationRespository repository){
        super(repository);
    }

    protected NationRespository getRepository(){
        return (NationRespository) super.getRepository();
    }
}
