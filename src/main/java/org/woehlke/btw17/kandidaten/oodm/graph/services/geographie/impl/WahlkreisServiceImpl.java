package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.WahlkreisRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.WahlkreisService;

@Service("graph.WahlkreisService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class WahlkreisServiceImpl extends GraphDomainServiceImpl<Wahlkreis> implements WahlkreisService {

    @Autowired
    public WahlkreisServiceImpl(final WahlkreisRepository repository){
        super(repository);
    }

    protected WahlkreisRepository getRepository(){
        return (WahlkreisRepository) super.getRepository();
    }

}
