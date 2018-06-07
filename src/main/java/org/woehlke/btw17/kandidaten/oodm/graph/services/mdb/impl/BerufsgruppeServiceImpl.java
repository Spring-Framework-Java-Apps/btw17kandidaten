package org.woehlke.btw17.kandidaten.oodm.graph.services.mdb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.mdb.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb.BerufsgruppeRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.mdb.BerufsgruppeService;

@Service("graph.BerufsgruppeService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class BerufsgruppeServiceImpl extends GraphDomainServiceImpl<Berufsgruppe> implements BerufsgruppeService {

    @Autowired
    public BerufsgruppeServiceImpl(final BerufsgruppeRepository repository){
        super(repository);
    }

    protected BerufsgruppeRepository getRepository(){
        return (BerufsgruppeRepository) super.getRepository();
    }
}
