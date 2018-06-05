package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.InstitutionArt;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.WahlperiodeRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.WahlperiodeService;


@Service("jpa.WahlperiodeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WahlperiodeServiceImpl extends JpaDomainServiceImpl<Wahlperiode> implements WahlperiodeService {

    @Autowired
    public WahlperiodeServiceImpl(WahlperiodeRepository wahlperiodeRepository) {
        super(wahlperiodeRepository);
    }

    @Override
    protected WahlperiodeRepository getRepository(){
        return (WahlperiodeRepository) super.getRepository();
    }

    @Override
    public Wahlperiode findByBtw17Wahlperiode(Long wahlperiodeId, Wahlkreis wahlkreis, BundeslandEnum bundeslandLandesListe, Mandatsart mandatsArt, InstitutionArt institutionArtLang, String inslang, String fktlang) {
        return getRepository().findByBtw17Wahlperiode(wahlperiodeId,wahlkreis,bundeslandLandesListe,mandatsArt,institutionArtLang,inslang,fktlang);
    }
}
