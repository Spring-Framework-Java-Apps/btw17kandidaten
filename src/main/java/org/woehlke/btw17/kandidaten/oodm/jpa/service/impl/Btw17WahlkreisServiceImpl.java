package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.Btw17WahlkreisRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17WahlkreisService;


@Service("jpa.Btw17WahlkreisService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17WahlkreisServiceImpl extends JpaDomainServiceImpl<Btw17Wahlkreis> implements Btw17WahlkreisService {

    @Autowired
    public Btw17WahlkreisServiceImpl(Btw17WahlkreisRepository btw17WahlkreisRepository) {
        super(btw17WahlkreisRepository);
    }

    @Override
    protected Btw17WahlkreisRepository getRepository(){
        return (Btw17WahlkreisRepository) super.getRepository();
    }


    @Override
    public Btw17Wahlkreis findByWahlkreisNummer(long wahlkreisNummer) {
        return this.getRepository().findByWahlkreisNummer(wahlkreisNummer);
    }

    @Override
    public BundeslandEnum findByBundeslandNummer(long bundeslandNummer) {
        return this.getRepository().findByBundeslandNummer(bundeslandNummer);
    }
}
