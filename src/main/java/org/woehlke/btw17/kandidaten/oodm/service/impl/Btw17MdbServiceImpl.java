package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Btw17Mdb;
import org.woehlke.btw17.kandidaten.oodm.repositories.Btw17Btw17MdbRepository;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17MdbService;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17MdbServiceImpl implements Btw17MdbService {

    private final Btw17Btw17MdbRepository btw17MdbRepository;

    @Autowired
    public Btw17MdbServiceImpl(Btw17Btw17MdbRepository btw17MdbRepository) {
        this.btw17MdbRepository = btw17MdbRepository;
    }

    @Override
    public Page<Btw17Mdb> getAll(Pageable pageRequest) {
        return btw17MdbRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Mdb> getAll() {
        return btw17MdbRepository.findAll();
    }

    @Override
    public long count() {
        return btw17MdbRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        btw17MdbRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17Mdb domainObject) {
        btw17MdbRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Mdb create(Btw17Mdb domainObject) {
        return btw17MdbRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Mdb update(Btw17Mdb domainObject) {
        return btw17MdbRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return btw17MdbRepository.getAllIds();
    }

    @Override
    public Btw17Mdb findById(long id) {
        return btw17MdbRepository.findOne(id);
    }

    @Override
    public Long getMaxId() {
        return btw17MdbRepository.getMaxId();
    }

    @Override
    public long countBtw17Mdb2Wahlperiode() {
        return btw17MdbRepository.countBtw17Mdb2Wahlperiode();
    }
}
