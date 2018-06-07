package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.GeburtsortRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.GeburtsortService;

@Service("jpa.GeburtsortService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class GeburtsortServiceImpl extends JpaDomainServiceImpl<Geburtsort> implements GeburtsortService {

    @Autowired
    public GeburtsortServiceImpl(GeburtsortRepository geburtsortRepository) {
        super(geburtsortRepository);
    }

    @Override
    protected GeburtsortRepository getRepository(){
        return (GeburtsortRepository) super.getRepository();
    }

    @Override
    public Geburtsort findByGeburtsort(String geburtsort) {
        return getRepository().findByGeburtsort(geburtsort);
    }

}
