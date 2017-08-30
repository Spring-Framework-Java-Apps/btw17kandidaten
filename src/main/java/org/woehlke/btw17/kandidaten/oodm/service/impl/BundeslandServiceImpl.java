package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.repositories.BundeslandRepository;
import org.woehlke.btw17.kandidaten.oodm.service.BundeslandService;

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
    public Bundesland findByBundesland(String bundesland) {
        return bundeslandRepository.findByBundesland(bundesland);
    }

    @Override
    public long count() {
        return bundeslandRepository.count();
    }

    @Override
    public void deleteAll() {
        bundeslandRepository.deleteAll();
    }
}
