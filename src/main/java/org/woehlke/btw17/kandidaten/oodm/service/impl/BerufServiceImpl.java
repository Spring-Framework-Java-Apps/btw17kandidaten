package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.repositories.BerufRepository;
import org.woehlke.btw17.kandidaten.oodm.service.BerufService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BerufServiceImpl implements BerufService {

    private final BerufRepository berufRepository;

    @Autowired
    public BerufServiceImpl(BerufRepository berufRepository) {
        this.berufRepository = berufRepository;
    }

    @Override
    public Page<Beruf> getAll(Pageable pageRequest) {
        return berufRepository.findAll(pageRequest);
    }

    @Override
    public Beruf findByBeruf(String beruf) {
        return berufRepository.findByBeruf(beruf);
    }

    @Override
    public long count() {
        return berufRepository.count();
    }
}
