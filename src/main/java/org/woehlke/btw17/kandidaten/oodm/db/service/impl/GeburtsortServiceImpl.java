package org.woehlke.btw17.kandidaten.oodm.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.db.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.db.repositories.GeburtsortRepository;
import org.woehlke.btw17.kandidaten.oodm.db.service.GeburtsortService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class GeburtsortServiceImpl implements GeburtsortService {

    private final GeburtsortRepository geburtsortRepository;

    @Autowired
    public GeburtsortServiceImpl(GeburtsortRepository geburtsortRepository) {
        this.geburtsortRepository = geburtsortRepository;
    }

    @Override
    public Page<Geburtsort> getAll(Pageable pageRequest) {
        return geburtsortRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Geburtsort> getAll() {
        return geburtsortRepository.findAll();
    }

    @Override
    public Geburtsort findByGeburtsort(String geburtsort) {
        return geburtsortRepository.findByGeburtsort(geburtsort);
    }

    @Override
    public long count() {
        return geburtsortRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        geburtsortRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Geburtsort update(Geburtsort o) {
        return geburtsortRepository.save(o);
    }

    @Override
    public List<Long> getAllIds() {
        return geburtsortRepository.getAllIds();
    }

    @Override
    public Geburtsort findById(long id) {
        return geburtsortRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return geburtsortRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Geburtsort create(Geburtsort geburtsort) {
        return geburtsortRepository.save(geburtsort);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Geburtsort geburtsort) {
        geburtsortRepository.delete(geburtsort);
    }
}
