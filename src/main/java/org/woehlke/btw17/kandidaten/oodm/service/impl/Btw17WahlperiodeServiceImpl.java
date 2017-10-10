package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.bundestag.Btw17Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.repositories.Btw17WahlperiodeRepository;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlperiodeService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17WahlperiodeServiceImpl implements Btw17WahlperiodeService {

    private final Btw17WahlperiodeRepository btw17WahlperiodeRepository;

    @Autowired
    public Btw17WahlperiodeServiceImpl(Btw17WahlperiodeRepository btw17WahlperiodeRepository) {
        this.btw17WahlperiodeRepository = btw17WahlperiodeRepository;
    }

    @Override
    public Page<Btw17Wahlperiode> getAll(Pageable pageRequest) {
        return btw17WahlperiodeRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Wahlperiode> getAll() {
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
    public void delete(Btw17Wahlperiode domainObject) {
        btw17WahlperiodeRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Wahlperiode create(Btw17Wahlperiode domainObject) {
        return btw17WahlperiodeRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Wahlperiode update(Btw17Wahlperiode domainObject) {
        return btw17WahlperiodeRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return btw17WahlperiodeRepository.getAllIds();
    }

    @Override
    public Btw17Wahlperiode findById(long id) {
        return btw17WahlperiodeRepository.findOne(id);
    }

    @Override
    public long getMaxId() {
        return btw17WahlperiodeRepository.getMaxId();
    }

    @Override
    public Btw17Wahlperiode findbyWahlperiodeNrAndWkrnummer(String wp, String wkrnummer) {
        return btw17WahlperiodeRepository.findByWpAndWkrnummer(wp, wkrnummer);
    }
}
