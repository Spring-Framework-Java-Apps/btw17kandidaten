package org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Dienstleister;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite.DienstleisterRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.DienstleisterService;

@Service
@Transactional
public class DienstleisterServiceImpl extends GraphDomainServiceImpl<Dienstleister> implements DienstleisterService {

    @Autowired
    public DienstleisterServiceImpl(final DienstleisterRepository repository){
        super(repository);
    }

    protected DienstleisterRepository getRepository(){
        return (DienstleisterRepository) super.getRepository();
    }

}
