package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.Btw17WahlperiodeRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17WahlperiodeService;

@Service("jpa.Btw17WahlperiodeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17WahlperiodeServiceImpl extends JpaDomainServiceImpl<Btw17Wahlperiode> implements Btw17WahlperiodeService {

    @Autowired
    public Btw17WahlperiodeServiceImpl(@Qualifier("jpa.Btw17WahlperiodeRepository") final Btw17WahlperiodeRepository btw17WahlperiodeRepository) {
        super(btw17WahlperiodeRepository);
    }

    @Override
    protected Btw17WahlperiodeRepository getRepository(){
        return (Btw17WahlperiodeRepository) super.getRepository();
    }

    @Override
    public Btw17Wahlperiode findbyWahlperiodeNrAndWkrnummer(String wp, String wkrnummer) {
        return getRepository().findByWpAndWkrnummer(wp, wkrnummer);
    }
}
