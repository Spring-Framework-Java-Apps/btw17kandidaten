package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.FraktionRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.FraktionService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class FraktionServiceImpl implements FraktionService {

    private final FraktionRepository fraktionRepository;

    @Autowired
    public FraktionServiceImpl(FraktionRepository fraktionRepository) {
        this.fraktionRepository = fraktionRepository;
    }

    @Override
    public Iterable<Fraktion> getAll() {
        return fraktionRepository.findAll();
    }

    @Override
    public Page<Fraktion> getAll(Pageable pageRequest) {
        return fraktionRepository.findAll(pageRequest);
    }

    @Override
    public Fraktion findByFraktion(String fraktion) {
        return fraktionRepository.findByFraktion(fraktion);
    }

    @Override
    public long count() {
        return fraktionRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        fraktionRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Fraktion update(Fraktion fraktion) {
        return fraktionRepository.save(fraktion);
    }

    @Override
    public List<Long> getAllIds() {
        return fraktionRepository.getAllIds();
    }

    @Override
    public Fraktion findById(long id) {
        return fraktionRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return fraktionRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Fraktion create(Fraktion fraktion) {
        return fraktionRepository.save(fraktion);
    }

    @Override
    public void delete(Fraktion fraktion) {
        fraktionRepository.delete(fraktion);
    }
}
