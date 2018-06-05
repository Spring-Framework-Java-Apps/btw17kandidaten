package org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Technologie;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite.TechnologieRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.TechnologieService;

@Service
@Transactional
public class TechnologieServiceImpl extends GraphDomainServiceImpl<Technologie> implements TechnologieService {

    @Autowired
    public TechnologieServiceImpl(final TechnologieRepository repository){
        super(repository);
    }

    protected TechnologieRepository getRepository(){
        return (TechnologieRepository) super.getRepository();
    }

}
