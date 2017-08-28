package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.repositories.WohnortRepository;
import org.woehlke.btw17.kandidaten.oodm.service.WohnortService;

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
    public Wohnort findByWohnort(String wohnort) {
        return wohnortRepository.findByWohnort(wohnort);
    }
}
