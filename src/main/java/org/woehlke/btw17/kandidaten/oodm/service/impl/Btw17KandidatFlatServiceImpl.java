package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.repositories.Btw17KandidatFlatRepository;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17KandidatFlatService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17KandidatFlatServiceImpl implements Btw17KandidatFlatService {

    private final Btw17KandidatFlatRepository btw17KandidatFlatRepository;

    @Autowired
    public Btw17KandidatFlatServiceImpl(Btw17KandidatFlatRepository btw17KandidatFlatRepository) {
        this.btw17KandidatFlatRepository = btw17KandidatFlatRepository;
    }

    @Override
    public Page<Btw17KandidatFlat> getAll(Pageable pageRequest) {
        return btw17KandidatFlatRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17KandidatFlat> getAll() {
        return this.btw17KandidatFlatRepository.findAll();
    }

    @Override
    public Page<Btw17KandidatFlat> getAllOrderByNachname(Pageable pageRequest) {
        return btw17KandidatFlatRepository.getAllOrderByNachname(pageRequest);
    }

    @Override
    public long count() {
        return btw17KandidatFlatRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        this.btw17KandidatFlatRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17KandidatFlat domainObject) {
        this.btw17KandidatFlatRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17KandidatFlat create(Btw17KandidatFlat domainObject) {
        return this.btw17KandidatFlatRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17KandidatFlat update(Btw17KandidatFlat domainObject) {
        return this.btw17KandidatFlatRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return this.btw17KandidatFlatRepository.getAllIds();
    }

    @Override
    public Btw17KandidatFlat findById(long id) {
        return this.btw17KandidatFlatRepository.findOne(id);
    }

    @Override
    public long getMaxId() {
        return this.btw17KandidatFlatRepository.getMaxId();
    }

    @Override
    public List<Long> getAllIdsWhereMdbIsNotNull() {
        return btw17KandidatFlatRepository.getAllIdsWhereMdbIsNotNull();
    }
}
