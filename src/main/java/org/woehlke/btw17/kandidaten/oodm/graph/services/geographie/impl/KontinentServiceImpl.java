package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Kontinent;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.KontinentRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.KontinentService;

@Service
@Transactional
public class KontinentServiceImpl extends GraphDomainServiceImpl<Kontinent> implements KontinentService {

    @Autowired
    public KontinentServiceImpl(final KontinentRepository repository){
        super(repository);
    }

    protected KontinentRepository getRepository(){
        return (KontinentRepository) super.getRepository();
    }
}
