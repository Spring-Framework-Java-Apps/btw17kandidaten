package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.repositories.BundeslandRepository;
import org.woehlke.btw17.kandidaten.oodm.service.BundeslandService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BundeslandServiceImpl implements BundeslandService {

    private final BundeslandRepository bundeslandRepository;

    @Autowired
    public BundeslandServiceImpl(BundeslandRepository bundeslandRepository) {
        this.bundeslandRepository = bundeslandRepository;
    }

    @Override
    public Page<Bundesland> getAll(Pageable pageRequest) {
        return bundeslandRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Bundesland> getAll() {
        return this.bundeslandRepository.findAll();
    }

    @Override
    public Bundesland findByBundesland(BundeslandEnum bundesland) {
        return bundeslandRepository.findByBundesland(bundesland);
    }

    @Override
    public long count() {
        return bundeslandRepository.count();
    }

    @Override
    public long countBundeslandAgentur() {
        return bundeslandRepository.countBundeslandAgentur();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        bundeslandRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Bundesland update(Bundesland bundesland) {
        return bundeslandRepository.save(bundesland);
    }

    @Override
    public List<Long> getAllIds() {
        return bundeslandRepository.getAllIds();
    }

    @Override
    public Bundesland findById(long id) {
        return bundeslandRepository.findOne(id);
    }

    @Override
    public Long getMaxId() {
        return bundeslandRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Bundesland create(Bundesland bundesland) {
        return bundeslandRepository.save(bundesland);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Bundesland bundesland) {
        bundeslandRepository.delete(bundesland);
    }
}
