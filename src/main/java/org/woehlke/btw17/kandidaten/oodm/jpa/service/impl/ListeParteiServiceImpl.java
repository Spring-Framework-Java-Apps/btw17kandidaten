package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.ListeParteiRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.ListeParteiService;

@Service("jpa.ListeParteiService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ListeParteiServiceImpl extends JpaDomainServiceImpl<ListePartei> implements ListeParteiService {

    @Autowired
    public ListeParteiServiceImpl(ListeParteiRepository listeParteiRepository) {
        super(listeParteiRepository);
    }

    @Override
    protected ListeParteiRepository getRepository(){
        return (ListeParteiRepository) super.getRepository();
    }

    @Override
    public ListePartei findByListePartei(String listePartei, String listeParteiLang) {
        return getRepository().findByListeParteiAndListeParteiLang(listePartei,listeParteiLang);
    }

    @Override
    public ListePartei findByPartei(String partei) {
        return getRepository().findByListePartei(partei);
    }
}
