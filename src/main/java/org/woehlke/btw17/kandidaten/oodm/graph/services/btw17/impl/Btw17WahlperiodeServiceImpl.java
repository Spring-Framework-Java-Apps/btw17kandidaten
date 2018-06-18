package org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17.Btw17WahlperiodeRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.Btw17WahlperiodeService;

@Service("graph.Btw17WahlperiodeService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class Btw17WahlperiodeServiceImpl extends GraphDomainServiceImpl<Btw17Wahlperiode> implements Btw17WahlperiodeService {

    @Autowired
    public Btw17WahlperiodeServiceImpl(@Qualifier("graph.Btw17WahlperiodeRepository") final Btw17WahlperiodeRepository repository){
        super(repository);
    }

    protected Btw17WahlperiodeRepository getRepository(){
        return (Btw17WahlperiodeRepository) super.getRepository();
    }

}
