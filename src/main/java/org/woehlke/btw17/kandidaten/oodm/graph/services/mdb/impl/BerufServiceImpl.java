package org.woehlke.btw17.kandidaten.oodm.graph.services.mdb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Beruf;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb.BerufRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.mdb.BerufService;

@Service("graph.BerufService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class BerufServiceImpl extends GraphDomainServiceImpl<Beruf> implements BerufService {

    @Autowired
    public BerufServiceImpl(@Qualifier("graph.BerufRepository") final BerufRepository repository){
        super(repository);
    }

    protected BerufRepository getRepository(){
        return (BerufRepository) super.getRepository();
    }
}
