package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Ort;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.OrtRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.OrtService;

@Service("graph.OrtService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class OrtServiceImpl extends GraphDomainServiceImpl<Ort> implements OrtService {

    @Autowired
    public OrtServiceImpl(@Qualifier("graph.OrtRepository") final OrtRepository repository){
        super(repository);
    }

    protected OrtRepository getRepository(){
        return (OrtRepository) super.getRepository();
    }

}
