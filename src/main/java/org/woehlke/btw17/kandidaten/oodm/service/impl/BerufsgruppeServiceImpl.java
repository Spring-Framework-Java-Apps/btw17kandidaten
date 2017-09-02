package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.repositories.BerufsgruppeRepository;
import org.woehlke.btw17.kandidaten.oodm.service.BerufsgruppeService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BerufsgruppeServiceImpl implements BerufsgruppeService {

    private final BerufsgruppeRepository berufsgruppeRepository;

    @Autowired
    public BerufsgruppeServiceImpl(BerufsgruppeRepository berufsgruppeRepository) {
        this.berufsgruppeRepository = berufsgruppeRepository;
    }

    @Override
    public Page<Berufsgruppe> getAll(Pageable pageRequest) {
        return berufsgruppeRepository.findAll(pageRequest);
    }

    @Override
    public Berufsgruppe findByBerufsgruppe(String berufsgruppe) {
        return berufsgruppeRepository.findByBerufsgruppe(berufsgruppe);
    }

    @Override
    public long count() {
        return berufsgruppeRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        berufsgruppeRepository.deleteAll();
    }
}
