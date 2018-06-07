package org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.btw17.Btw17Wahlbewerber;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17.Btw17WahlbewerberRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.btw17.Btw17WahlbewerberService;

@Service("graph.Btw17WahlbewerberService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class Btw17WahlbewerberServiceImpl extends GraphDomainServiceImpl<Btw17Wahlbewerber> implements Btw17WahlbewerberService {

    @Autowired
    public Btw17WahlbewerberServiceImpl(final Btw17WahlbewerberRepository repository){
        super(repository);
    }

    protected Btw17WahlbewerberRepository getRepository(){
        return (Btw17WahlbewerberRepository) super.getRepository();
    }

}
