package org.woehlke.btw17.kandidaten.oodm.graph.services.kandidaten.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten.KandidatRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.kandidaten.KandidatService;

@Service("graph.KandidatService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class KandidatServiceImpl extends GraphDomainServiceImpl<Kandidat> implements KandidatService {

    @Autowired
    public KandidatServiceImpl(@Qualifier("graph.KandidatRepository") final KandidatRepository repository){
        super(repository);
    }

    protected KandidatRepository getRepository(){
        return (KandidatRepository) super.getRepository();
    }

}
