package org.woehlke.btw17.kandidaten.oodm.graph.services.kandidaten.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.ListeParteiBundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten.ListeParteiBundeslandRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.kandidaten.ListeParteiBundeslandService;

@Service("graph.ListeParteiBundeslandService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ListeParteiBundeslandServiceImpl extends GraphDomainServiceImpl<ListeParteiBundesland> implements ListeParteiBundeslandService {

    @Autowired
    public ListeParteiBundeslandServiceImpl(final ListeParteiBundeslandRepository repository){
        super(repository);
    }

    protected ListeParteiBundeslandRepository getRepository(){
        return (ListeParteiBundeslandRepository) super.getRepository();
    }

}
