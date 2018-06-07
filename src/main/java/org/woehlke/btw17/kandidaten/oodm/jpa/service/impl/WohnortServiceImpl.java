package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.WohnortRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.WohnortService;

import java.util.List;

@Service("jpa.WohnortService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WohnortServiceImpl extends JpaDomainServiceImpl<Wohnort> implements WohnortService {

    @Autowired
    public WohnortServiceImpl(WohnortRepository wohnortRepository) {
        super(wohnortRepository);
    }

    @Override
    protected WohnortRepository getRepository(){
        return (WohnortRepository) super.getRepository();
    }

    @Override
    public Wohnort findByWohnort(String wohnort) {
        return getRepository().findByWohnort(wohnort);
    }

    @Override
    public List<Wohnort> getAllOrderById() {
        return getRepository().findAll();
    }

}
