package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.repositories.ListeParteiRepository;
import org.woehlke.btw17.kandidaten.oodm.service.ListeParteiService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ListeParteiServiceImpl implements ListeParteiService {

    private final ListeParteiRepository listeParteiRepository;

    @Autowired
    public ListeParteiServiceImpl(ListeParteiRepository listeParteiRepository) {
        this.listeParteiRepository = listeParteiRepository;
    }

    @Override
    public Page<ListePartei> getAll(Pageable pageRequest) {
        return listeParteiRepository.findAll(pageRequest);
    }

    @Override
    public ListePartei findByListePartei(String listePartei, String listeParteiLang) {
        return listeParteiRepository.findByListeParteiAndListeParteiLang(listePartei,listeParteiLang);
    }

    @Override
    public long count() {
        return listeParteiRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        listeParteiRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void update(ListePartei out) {
        listeParteiRepository.save(out);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public ListePartei create(ListePartei listePartei) {
        return listeParteiRepository.save(listePartei);
    }

    @Override
    public ListePartei findByPartei(String partei) {
        return listeParteiRepository.findByListePartei(partei);
    }
}
