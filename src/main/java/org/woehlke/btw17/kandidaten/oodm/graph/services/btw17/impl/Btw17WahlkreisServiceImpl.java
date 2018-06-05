package org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17.Btw17WahlkreisRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.Btw17WahlkreisService;

@Service("graph.Btw17WahlkreisService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class Btw17WahlkreisServiceImpl extends GraphDomainServiceImpl<Btw17Wahlkreis> implements Btw17WahlkreisService {

    @Autowired
    public Btw17WahlkreisServiceImpl(final Btw17WahlkreisRepository repository){
        super(repository);
    }

    protected Btw17WahlkreisRepository getRepository(){
        return (Btw17WahlkreisRepository) super.getRepository();
    }
}
