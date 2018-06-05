package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Mdb;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.Btw17Btw17MdbRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17MdbService;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17MdbServiceImpl extends JpaDomainServiceImpl<Btw17Mdb> implements Btw17MdbService {

    @Autowired
    public Btw17MdbServiceImpl(Btw17Btw17MdbRepository btw17MdbRepository) {
        super(btw17MdbRepository);
    }

    @Override
    protected Btw17Btw17MdbRepository getRepository(){
        return (Btw17Btw17MdbRepository) super.getRepository();
    }

    @Override
    public long countBtw17Mdb2Wahlperiode() {
        return getRepository().countBtw17Mdb2Wahlperiode();
    }
}
