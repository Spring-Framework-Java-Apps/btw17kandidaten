package org.woehlke.btw17.kandidaten.oodm.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.db.repositories.WahlkreisRepository;
import org.woehlke.btw17.kandidaten.oodm.db.service.WahlkreisService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WahlkreisServiceImpl implements WahlkreisService {

    private final WahlkreisRepository wahlkreisRepository;

    @Autowired
    public WahlkreisServiceImpl(WahlkreisRepository wahlkreisRepository) {
        this.wahlkreisRepository = wahlkreisRepository;
    }

    @Override
    public Page<Wahlkreis> getAll(Pageable pageRequest) {
        return wahlkreisRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Wahlkreis> getAll() {
        return wahlkreisRepository.findAll();
    }

    @Override
    public Wahlkreis findByWahlkreisId(long wahlkreisId) {
        return wahlkreisRepository.findByWahlkreisId(wahlkreisId);
    }

    @Override
    public long count() {
        return wahlkreisRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        wahlkreisRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Wahlkreis update(Wahlkreis wahlkreis) {
        return wahlkreisRepository.save(wahlkreis);
    }

    @Override
    public List<Long> getAllIds() {
        return wahlkreisRepository.getAllIds();
    }

    @Override
    public Wahlkreis findById(long id) {
        return wahlkreisRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return wahlkreisRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Wahlkreis create(Wahlkreis wahlkreis) {
        return wahlkreisRepository.save(wahlkreis);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Wahlkreis wahlkreis) {
        wahlkreisRepository.delete(wahlkreis);
    }
}
