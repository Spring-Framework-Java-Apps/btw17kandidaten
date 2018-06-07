package org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17.Btw17StrukturdatenRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.Btw17StrukturdatenService;

@Service("graph.Btw17StrukturdatenService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class Btw17StrukturdatenServiceImpl extends GraphDomainServiceImpl<Btw17Strukturdaten> implements Btw17StrukturdatenService {

    @Autowired
    public Btw17StrukturdatenServiceImpl(final Btw17StrukturdatenRepository repository){
        super(repository);
    }

    protected Btw17StrukturdatenRepository getRepository(){
        return (Btw17StrukturdatenRepository) super.getRepository();
    }

}
