package org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Dienstleister;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite.DienstleisterRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.DienstleisterService;

@Service("graph.DienstleisterService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class DienstleisterServiceImpl extends GraphDomainServiceImpl<Dienstleister> implements DienstleisterService {

    @Autowired
    public DienstleisterServiceImpl(@Qualifier("graph.DienstleisterRepository") final DienstleisterRepository repository){
        super(repository);
    }

    protected DienstleisterRepository getRepository(){
        return (DienstleisterRepository) super.getRepository();
    }

}
