package org.woehlke.btw17.kandidaten.oodm.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.db.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.db.repositories.BerufsgruppeRepository;
import org.woehlke.btw17.kandidaten.oodm.db.service.BerufsgruppeService;

import java.util.List;

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
    public Iterable<Berufsgruppe> getAll() {
        return berufsgruppeRepository.findAll();
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

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Berufsgruppe update(Berufsgruppe berufsgruppe) {
        return berufsgruppeRepository.save(berufsgruppe);
    }

    @Override
    public List<Long> getAllIds() {
        return berufsgruppeRepository.getAllIds();
    }

    @Override
    public Berufsgruppe findById(long id) {
        return berufsgruppeRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return berufsgruppeRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Berufsgruppe create(Berufsgruppe berufsgruppe) {
        return berufsgruppeRepository.save(berufsgruppe);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Berufsgruppe berufsgruppe) {
        berufsgruppeRepository.delete(berufsgruppe);
    }
}
