package org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17.Btw17ErgebnisRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.Btw17ErgebnisService;

@Service("graph.Btw17ErgebnisService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class Btw17ErgebnisServiceImpl extends GraphDomainServiceImpl<Btw17Ergebnis> implements Btw17ErgebnisService {

    @Autowired
    public Btw17ErgebnisServiceImpl(final Btw17ErgebnisRepository repository){
        super(repository);
    }

    protected Btw17ErgebnisRepository getRepository(){
        return (Btw17ErgebnisRepository) super.getRepository();
    }


}
