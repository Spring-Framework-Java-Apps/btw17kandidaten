package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.LandesListeRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.LandesListeService;

@Service("jpa.LandesListeService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LandesListeServiceImpl extends JpaDomainServiceImpl<LandesListe> implements LandesListeService {

    @Autowired
    public LandesListeServiceImpl(@Qualifier("jpa.LandesListeRepository") LandesListeRepository landesListeRepository) {
        super(landesListeRepository);
    }

    @Override
    protected LandesListeRepository getRepository(){
        return (LandesListeRepository) super.getRepository();
    }

    @Override
    public LandesListe findByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei) {
        return getRepository().findByBundeslandAndListePartei(bundesland,listePartei);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public LandesListe fetchOrCreateByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei) {
        LandesListe found = getRepository().findByBundeslandAndListePartei(bundesland,listePartei);
        if(found!=null){
            return found;
        } else {
            LandesListe landesListe = new LandesListe();
            landesListe.setBundesland(bundesland);
            landesListe.setListePartei(listePartei);
            return getRepository().save(landesListe);
        }
    }

    @Override
    public Page<LandesListe> findByBundesland(Bundesland bundesland, Pageable pageable) {
        return getRepository().findByBundesland(bundesland,pageable);
    }

    @Override
    public Page<LandesListe> findByListePartei(ListePartei listePartei, Pageable pageable) {
        return getRepository().findByListePartei(listePartei,pageable);
    }

    @Override
    public Page<Bundesland> getAllBundesland(Pageable pageable) {
        return getRepository().getAllBundesland(pageable);
    }

    @Override
    public Page<ListePartei> getAllListePartei(Pageable pageable) {
        return getRepository().getAllListePartei(pageable);
    }
}
