package org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Cms;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite.CmsRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.CmsService;

@Service("graph.CmsService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class CmsServiceImpl extends GraphDomainServiceImpl<Cms> implements CmsService {

    @Autowired
    public CmsServiceImpl(final CmsRepository repository){
        super(repository);
    }

    protected CmsRepository getRepository(){
        return (CmsRepository) super.getRepository();
    }

}
