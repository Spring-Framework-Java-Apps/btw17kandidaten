package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.WebseiteAgenturRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.WebseiteAgenturService;

@Service("jpa.WebseiteAgenturService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WebseiteAgenturServiceImpl extends JpaDomainServiceImpl<WebseiteAgentur> implements WebseiteAgenturService {

    @Autowired
    public WebseiteAgenturServiceImpl(@Qualifier("jpa.WebseiteAgenturRepository") WebseiteAgenturRepository webseiteAgenturRepository) {
        super(webseiteAgenturRepository);
    }

    @Override
    protected WebseiteAgenturRepository getRepository(){
        return (WebseiteAgenturRepository) super.getRepository();
    }

    @Override
    public WebseiteAgentur findByAgentur(String agentur) {
        return getRepository().findByAgentur(agentur);
    }

}
