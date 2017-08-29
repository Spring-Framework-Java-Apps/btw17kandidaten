package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.repositories.GeburtsortRepository;
import org.woehlke.btw17.kandidaten.oodm.service.GeburtsortService;

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
    public Geburtsort findByGeburtsort(String geburtsort) {
        return geburtsortRepository.findByGeburtsort(geburtsort);
    }

    @Override
    public long count() {
        return geburtsortRepository.count();
    }
}
