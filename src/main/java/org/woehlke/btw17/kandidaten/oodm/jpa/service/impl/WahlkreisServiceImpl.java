package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.WahlkreisRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.WahlkreisService;

@Service("jpa.WahlkreisService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WahlkreisServiceImpl extends JpaDomainServiceImpl<Wahlkreis> implements WahlkreisService {

    @Autowired
    public WahlkreisServiceImpl(WahlkreisRepository wahlkreisRepository) {
        super(wahlkreisRepository);
    }

    @Override
    protected WahlkreisRepository getRepository(){
        return (WahlkreisRepository) super.getRepository();
    }

    @Override
    public Wahlkreis findByWahlkreisId(long wahlkreisId) {
        return getRepository().findByWahlkreisId(wahlkreisId);
    }

}
