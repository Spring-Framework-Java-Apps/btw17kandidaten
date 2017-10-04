package org.woehlke.btw17.kandidaten.oodm.bundestag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.bundestag.model.Mdb;
import org.woehlke.btw17.kandidaten.oodm.bundestag.repositories.MdbRepository;
import org.woehlke.btw17.kandidaten.oodm.bundestag.service.MdbService;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class MdbServiceImpl implements MdbService {

    private final MdbRepository mdbRepository;

    @Autowired
    public MdbServiceImpl(MdbRepository mdbRepository) {
        this.mdbRepository = mdbRepository;
    }

    @Override
    public Page<Mdb> getAll(Pageable pageRequest) {
        return mdbRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Mdb> getAll() {
        return mdbRepository.findAll();
    }

    @Override
    public long count() {
        return mdbRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        mdbRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Mdb domainObject) {
        mdbRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Mdb create(Mdb domainObject) {
        return mdbRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Mdb update(Mdb domainObject) {
        return mdbRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return mdbRepository.getAllIds();
    }

    @Override
    public Mdb findById(long id) {
        return mdbRepository.findOne(id);
    }
}
