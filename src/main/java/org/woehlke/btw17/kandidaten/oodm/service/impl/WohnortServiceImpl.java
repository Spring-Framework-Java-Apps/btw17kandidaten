package org.woehlke.btw17.kandidaten.oodm.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.repositories.WohnortRepository;
import org.woehlke.btw17.kandidaten.oodm.service.WohnortService;

import java.util.List;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WohnortServiceImpl implements WohnortService {

    private final WohnortRepository wohnortRepository;

    @Autowired
    public WohnortServiceImpl(WohnortRepository wohnortRepository) {
        this.wohnortRepository = wohnortRepository;
    }

    @Override
    public Page<Wohnort> getAll(Pageable pageRequest) {
        return wohnortRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Wohnort> getAll() {
        return wohnortRepository.findAll();
    }

    @Override
    public Wohnort findByWohnort(String wohnort) {
        return wohnortRepository.findByWohnort(wohnort);
    }

    @Override
    public long count() {
        return wohnortRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        wohnortRepository.deleteAll();
    }

    @Override
    public List<Wohnort> getAllOrderById() {
        return wohnortRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Wohnort update(Wohnort wohnort) {
        return wohnortRepository.save(wohnort);
    }

    @Override
    public List<Long> getAllIds() {
        return wohnortRepository.getAllIds();
    }

    @Override
    public Wohnort findById(long id) {
        return wohnortRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return wohnortRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Wohnort create(Wohnort wohnort) {
        return wohnortRepository.save(wohnort);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Wohnort wohnort) {
        wohnortRepository.delete(wohnort);
    }
}
