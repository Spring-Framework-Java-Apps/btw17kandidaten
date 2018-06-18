package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.BerufsgruppeRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.BerufsgruppeService;

@Service("jpa.BerufsgruppeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BerufsgruppeServiceImpl extends JpaDomainServiceImpl<Berufsgruppe> implements BerufsgruppeService {

    @Autowired
    public BerufsgruppeServiceImpl(@Qualifier("jpa.BerufsgruppeRepository") BerufsgruppeRepository berufsgruppeRepository) {
        super(berufsgruppeRepository);
    }

    @Override
    protected BerufsgruppeRepository getRepository(){
        return (BerufsgruppeRepository) super.getRepository();
    }

    @Override
    public Berufsgruppe findByBerufsgruppe(String berufsgruppe) {
        return getRepository().findByBerufsgruppe(berufsgruppe);
    }

}
