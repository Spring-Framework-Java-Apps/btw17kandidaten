package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.repositories.WahlperiodeRepository;
import org.woehlke.btw17.kandidaten.oodm.service.WahlperiodeService;

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
        return this.wahlperiodeRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Wahlperiode> getAll() {
        return this.wahlperiodeRepository.findAll();
    }

    @Override
    public long count() {
        return this.wahlperiodeRepository.count();
    }

    @Override
    public void deleteAll() {
        this.wahlperiodeRepository.deleteAll();
    }

    @Override
    public void delete(Wahlperiode domainObject) {
        this.wahlperiodeRepository.delete(domainObject);
    }

    @Override
    public Wahlperiode create(Wahlperiode domainObject) {
        return this.wahlperiodeRepository.save(domainObject);
    }

    @Override
    public Wahlperiode update(Wahlperiode domainObject) {
        return this.wahlperiodeRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return this.wahlperiodeRepository.getAllIds();
    }

    @Override
    public Wahlperiode findById(long id) {
        return this.wahlperiodeRepository.findOne(id);
    }
}
