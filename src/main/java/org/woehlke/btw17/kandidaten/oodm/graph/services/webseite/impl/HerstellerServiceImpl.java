package org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Hersteller;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite.HerstellerRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.HerstellerService;

@Service("graph.HerstellerService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class HerstellerServiceImpl extends GraphDomainServiceImpl<Hersteller> implements HerstellerService {

    @Autowired
    public HerstellerServiceImpl(final HerstellerRepository repository){
        super(repository);
    }

    protected HerstellerRepository getRepository(){
        return (HerstellerRepository) super.getRepository();
    }

}
