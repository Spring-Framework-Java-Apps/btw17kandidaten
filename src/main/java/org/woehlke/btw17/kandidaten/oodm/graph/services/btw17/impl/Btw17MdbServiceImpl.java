package org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Mdb;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17.Btw17MdbRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.Btw17MdbService;

@Service("graph.Btw17MdbService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class Btw17MdbServiceImpl extends GraphDomainServiceImpl<Btw17Mdb> implements Btw17MdbService {

    @Autowired
    public Btw17MdbServiceImpl(@Qualifier("graph.Btw17MdbRepository") final Btw17MdbRepository repository){
        super(repository);
    }

    protected Btw17MdbRepository getRepository(){
        return (Btw17MdbRepository) super.getRepository();
    }

}
