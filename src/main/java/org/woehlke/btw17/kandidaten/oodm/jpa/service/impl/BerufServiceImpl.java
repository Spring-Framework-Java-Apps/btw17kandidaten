package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.BerufRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.BerufService;


@Service("jpa.BerufService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BerufServiceImpl extends JpaDomainServiceImpl<Beruf> implements BerufService {

    @Autowired
    public BerufServiceImpl(BerufRepository berufRepository) {
        super(berufRepository);
    }

    @Override
    protected BerufRepository getRepository(){
        return (BerufRepository) super.getRepository();
    }

    @Override
    public Beruf findByBeruf(String beruf) {
        return getRepository().findByBeruf(beruf);
    }

}
