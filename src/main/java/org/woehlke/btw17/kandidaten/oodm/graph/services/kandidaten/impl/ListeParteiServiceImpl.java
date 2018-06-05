package org.woehlke.btw17.kandidaten.oodm.graph.services.kandidaten.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten.ListeParteiRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.kandidaten.ListeParteiService;

@Service("graph.ListeParteiService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ListeParteiServiceImpl extends GraphDomainServiceImpl<ListePartei> implements ListeParteiService {

    @Autowired
    public ListeParteiServiceImpl(final ListeParteiRepository repository){
        super(repository);
    }

    protected ListeParteiRepository getRepository(){
        return (ListeParteiRepository) super.getRepository();
    }
}
