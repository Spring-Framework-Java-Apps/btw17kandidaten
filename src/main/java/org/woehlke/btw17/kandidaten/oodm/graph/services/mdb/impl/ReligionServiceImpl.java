package org.woehlke.btw17.kandidaten.oodm.graph.services.mdb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Religion;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb.ReligionRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.mdb.ReligionService;

@Service("graph.ReligionService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ReligionServiceImpl extends GraphDomainServiceImpl<Religion> implements ReligionService {

    @Autowired
    public ReligionServiceImpl(final ReligionRepository repository){
        super(repository);
    }

    protected ReligionRepository getRepository(){
        return (ReligionRepository) super.getRepository();
    }
}
