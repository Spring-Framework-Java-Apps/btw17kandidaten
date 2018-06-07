package org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.services.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.webseite.Webseite;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite.WebseiteRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.webseite.WebseiteService;

@Service("graph.WebseiteService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class WebseiteServiceImpl extends GraphDomainServiceImpl<Webseite> implements WebseiteService {

    @Autowired
    public WebseiteServiceImpl(final WebseiteRepository repository){
        super(repository);
    }

    protected WebseiteRepository getRepository(){
        return (WebseiteRepository) super.getRepository();
    }

}
