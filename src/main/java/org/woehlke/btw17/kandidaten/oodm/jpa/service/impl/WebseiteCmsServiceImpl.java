package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteCms;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.WebseiteCmsRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.WebseiteCmsService;

@Service("jpa.WebseiteCmsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WebseiteCmsServiceImpl extends JpaDomainServiceImpl<WebseiteCms> implements WebseiteCmsService {

    @Autowired
    public WebseiteCmsServiceImpl(WebseiteCmsRepository webseiteCmsRepository) {
        super(webseiteCmsRepository);
    }

    @Override
    protected WebseiteCmsRepository getRepository(){
        return (WebseiteCmsRepository) super.getRepository();
    }

    @Override
    public WebseiteCms findByCms(String cms) {
        return getRepository().findByCms(cms);
    }

}
