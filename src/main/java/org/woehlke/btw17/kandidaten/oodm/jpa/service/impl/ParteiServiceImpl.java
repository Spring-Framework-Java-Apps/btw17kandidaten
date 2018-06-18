package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Partei;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.ParteiRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.ParteiService;


@Service("jpa.ParteiService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ParteiServiceImpl extends JpaDomainServiceImpl<Partei> implements ParteiService {

    @Autowired
    public ParteiServiceImpl(@Qualifier("jpa.ParteiRepository") ParteiRepository parteiRepository) {
        super(parteiRepository);
    }

    @Override
    protected ParteiRepository getRepository(){
        return (ParteiRepository) super.getRepository();
    }

    @Override
    public Partei findByPartei(String partei, String parteiLang) {
        return getRepository().findByParteiAndParteiLang(partei,parteiLang);
    }
}
