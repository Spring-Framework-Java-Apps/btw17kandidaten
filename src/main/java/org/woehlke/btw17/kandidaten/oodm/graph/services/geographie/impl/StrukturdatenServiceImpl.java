package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.StrukturdatenRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.StrukturdatenService;

@Service
@Transactional
public class StrukturdatenServiceImpl extends GraphDomainServiceImpl<Strukturdaten> implements StrukturdatenService {

    @Autowired
    public StrukturdatenServiceImpl(final StrukturdatenRepository repository){
        super(repository);
    }

    protected StrukturdatenRepository getRepository(){
        return (StrukturdatenRepository) super.getRepository();
    }

}
