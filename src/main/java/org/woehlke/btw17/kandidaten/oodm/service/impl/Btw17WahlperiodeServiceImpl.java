package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.bundestag.BtwWahlperiode;
import org.woehlke.btw17.kandidaten.oodm.repositories.Btw17Btw17WahlperiodeRepository;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlperiodeService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17WahlperiodeServiceImpl implements Btw17WahlperiodeService {

    private final Btw17Btw17WahlperiodeRepository btw17WahlperiodeRepository;

    @Autowired
    public Btw17WahlperiodeServiceImpl(Btw17Btw17WahlperiodeRepository btw17WahlperiodeRepository) {
        this.btw17WahlperiodeRepository = btw17WahlperiodeRepository;
    }

    @Override
    public Page<BtwWahlperiode> getAll(Pageable pageRequest) {
        return btw17WahlperiodeRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<BtwWahlperiode> getAll() {
        return btw17WahlperiodeRepository.findAll();
    }

    @Override
    public long count() {
        return btw17WahlperiodeRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        btw17WahlperiodeRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(BtwWahlperiode domainObject) {
        btw17WahlperiodeRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public BtwWahlperiode create(BtwWahlperiode domainObject) {
        return btw17WahlperiodeRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public BtwWahlperiode update(BtwWahlperiode domainObject) {
        return btw17WahlperiodeRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return btw17WahlperiodeRepository.getAllIds();
    }

    @Override
    public BtwWahlperiode findById(long id) {
        return btw17WahlperiodeRepository.findOne(id);
    }
}
