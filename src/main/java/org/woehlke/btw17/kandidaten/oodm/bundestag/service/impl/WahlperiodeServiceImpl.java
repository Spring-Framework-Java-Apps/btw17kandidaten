package org.woehlke.btw17.kandidaten.oodm.bundestag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.bundestag.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.bundestag.repositories.WahlperiodeRepository;
import org.woehlke.btw17.kandidaten.oodm.bundestag.service.WahlperiodeService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WahlperiodeServiceImpl implements WahlperiodeService {

    private final WahlperiodeRepository wahlperiodeRepository;

    @Autowired
    public WahlperiodeServiceImpl(WahlperiodeRepository wahlperiodeRepository) {
        this.wahlperiodeRepository = wahlperiodeRepository;
    }

    @Override
    public Page<Wahlperiode> getAll(Pageable pageRequest) {
        return wahlperiodeRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Wahlperiode> getAll() {
        return wahlperiodeRepository.findAll();
    }

    @Override
    public long count() {
        return wahlperiodeRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        wahlperiodeRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Wahlperiode domainObject) {
        wahlperiodeRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Wahlperiode create(Wahlperiode domainObject) {
        return wahlperiodeRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Wahlperiode update(Wahlperiode domainObject) {
        return wahlperiodeRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return wahlperiodeRepository.getAllIds();
    }

    @Override
    public Wahlperiode findById(long id) {
        return wahlperiodeRepository.findOne(id);
    }
}
