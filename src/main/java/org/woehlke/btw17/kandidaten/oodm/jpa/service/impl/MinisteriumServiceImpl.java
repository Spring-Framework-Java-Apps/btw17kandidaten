package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.MinisteriumRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.MinisteriumService;

@Service("jpa.MinisteriumService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class MinisteriumServiceImpl extends JpaDomainServiceImpl<Ministerium> implements MinisteriumService {

    @Autowired
    public MinisteriumServiceImpl(MinisteriumRepository ministeriumRepository) {
        super(ministeriumRepository);
    }

    @Override
    protected MinisteriumRepository getRepository(){
        return (MinisteriumRepository) super.getRepository();
    }

    @Override
    public Ministerium findByMinisterium(String ministerium) {
        return getRepository().findByMinisterium(ministerium);
    }
}
