package org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17.Btw17KandidatFlatRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.Btw17KandidatFlatService;

@Service("graph.Btw17KandidatFlatService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class Btw17KandidatFlatServiceImpl extends GraphDomainServiceImpl<Btw17KandidatFlat> implements Btw17KandidatFlatService {

    @Autowired
    public Btw17KandidatFlatServiceImpl(final Btw17KandidatFlatRepository repository){
        super(repository);
    }

    protected Btw17KandidatFlatRepository getRepository(){
        return (Btw17KandidatFlatRepository) super.getRepository();
    }

}
