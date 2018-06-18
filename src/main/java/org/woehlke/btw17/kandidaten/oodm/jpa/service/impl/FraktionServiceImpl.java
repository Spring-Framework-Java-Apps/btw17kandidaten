package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.FraktionRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.FraktionService;


@Service("jpa.FraktionService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class FraktionServiceImpl extends JpaDomainServiceImpl<Fraktion> implements FraktionService {

    @Autowired
    public FraktionServiceImpl(@Qualifier("jpa.FraktionRepository") final FraktionRepository fraktionRepository) {
        super(fraktionRepository);
    }

    @Override
    protected FraktionRepository getRepository(){
        return (FraktionRepository) super.getRepository();
    }

    @Override
    public Fraktion findByFraktion(String fraktion) {
        return getRepository().findByFraktion(fraktion);
    }

}
