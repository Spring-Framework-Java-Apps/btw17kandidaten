package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.StrukturdatenRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.StrukturdatenService;

@Service("graph.StrukturdatenService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class StrukturdatenServiceImpl extends GraphDomainServiceImpl<Strukturdaten> implements StrukturdatenService {

    @Autowired
    public StrukturdatenServiceImpl(@Qualifier("graph.StrukturdatenRepository") final StrukturdatenRepository repository){
        super(repository);
    }

    protected StrukturdatenRepository getRepository(){
        return (StrukturdatenRepository) super.getRepository();
    }

}
