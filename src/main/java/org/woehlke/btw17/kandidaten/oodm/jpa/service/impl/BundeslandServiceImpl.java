package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.BundeslandRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.BundeslandService;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BundeslandServiceImpl extends JpaDomainServiceImpl<Bundesland> implements BundeslandService {

    @Autowired
    public BundeslandServiceImpl(BundeslandRepository bundeslandRepository) {
        super(bundeslandRepository);
    }

    @Override
    protected BundeslandRepository getRepository(){
        return (BundeslandRepository) super.getRepository();
    }

    @Override
    public Bundesland findByBundesland(BundeslandEnum bundesland) {
        return getRepository().findByBundesland(bundesland);
    }

    @Override
    public long countBundeslandAgentur() {
        return getRepository().countBundeslandAgentur();
    }
}
