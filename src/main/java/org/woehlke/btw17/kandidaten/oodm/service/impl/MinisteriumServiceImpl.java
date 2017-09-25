package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.repositories.MinisteriumRepository;
import org.woehlke.btw17.kandidaten.oodm.service.MinisteriumService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class MinisteriumServiceImpl implements MinisteriumService {

    private final MinisteriumRepository ministeriumRepository;

    @Autowired
    public MinisteriumServiceImpl(MinisteriumRepository ministeriumRepository) {
        this.ministeriumRepository = ministeriumRepository;
    }

    @Override
    public List<Ministerium> getAll() {
        return ministeriumRepository.getAll();
    }

    @Override
    public Page<Ministerium> getAll(Pageable pageRequest) {
        return ministeriumRepository.getAll(pageRequest);
    }

    @Override
    public Ministerium findByMinisterium(String ministerium) {
        return ministeriumRepository.findByMinisterium(ministerium);
    }

    @Override
    public long count() {
        return ministeriumRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        ministeriumRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Ministerium update(Ministerium ministerium) {
        return ministeriumRepository.save(ministerium);
    }
}
