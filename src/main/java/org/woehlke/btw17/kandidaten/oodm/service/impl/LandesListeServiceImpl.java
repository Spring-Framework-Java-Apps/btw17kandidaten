package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.repositories.LandesListeRepository;
import org.woehlke.btw17.kandidaten.oodm.service.LandesListeService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class LandesListeServiceImpl implements LandesListeService {

    private final LandesListeRepository landesListeRepository;

    @Autowired
    public LandesListeServiceImpl(LandesListeRepository landesListeRepository) {
        this.landesListeRepository = landesListeRepository;
    }

    @Override
    public Page<LandesListe> getAll(Pageable pageRequest) {
        return landesListeRepository.findAll(pageRequest);
    }

    @Override
    public List<LandesListe> getAll() {
        return this.landesListeRepository.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public LandesListe create(LandesListe out) {
        return landesListeRepository.save(out);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        landesListeRepository.deleteAll();
    }

    @Override
    public long count() {
        return landesListeRepository.count();
    }

    @Override
    public LandesListe findByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei) {
        return landesListeRepository.findByBundeslandAndListePartei(bundesland,listePartei);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public LandesListe fetchOrCreateByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei) {
        LandesListe found = landesListeRepository.findByBundeslandAndListePartei(bundesland,listePartei);
        if(found!=null){
            return found;
        } else {
            LandesListe landesListe = new LandesListe();
            landesListe.setBundesland(bundesland);
            landesListe.setListePartei(listePartei);
            return landesListeRepository.save(landesListe);
        }
    }

    @Override
    public Page<LandesListe> findByBundesland(Bundesland bundesland, Pageable pageable) {
        return landesListeRepository.findByBundesland(bundesland,pageable);
    }

    @Override
    public Page<LandesListe> findByListePartei(ListePartei listePartei, Pageable pageable) {
        return landesListeRepository.findByListePartei(listePartei,pageable);
    }

    @Override
    public Page<Bundesland> getAllBundesland(Pageable pageable) {
        return landesListeRepository.getAllBundesland(pageable);
    }

    @Override
    public Page<ListePartei> getAllListePartei(Pageable pageable) {
        return landesListeRepository.getAllListePartei(pageable);
    }
}
