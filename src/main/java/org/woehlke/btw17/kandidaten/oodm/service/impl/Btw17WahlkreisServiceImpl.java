package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.repositories.Btw17WahlkreisRepository;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlkreisService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17WahlkreisServiceImpl implements Btw17WahlkreisService {

    private final Btw17WahlkreisRepository btw17WahlkreisRepository;

    @Autowired
    public Btw17WahlkreisServiceImpl(Btw17WahlkreisRepository btw17WahlkreisRepository) {
        this.btw17WahlkreisRepository = btw17WahlkreisRepository;
    }


    @Override
    public Btw17Wahlkreis findByWahlkreisNummer(long wahlkreisNummer) {
        return this.btw17WahlkreisRepository.findByWahlkreisNummer(wahlkreisNummer);
    }

    @Override
    public BundeslandEnum findByBundeslandNummer(long bundeslandNummer) {
        return this.btw17WahlkreisRepository.findByBundeslandNummer(bundeslandNummer);
    }

    @Override
    public Page<Btw17Wahlkreis> getAll(Pageable pageRequest) {
        return this.btw17WahlkreisRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Wahlkreis> getAll() {
        return this.btw17WahlkreisRepository.findAll();
    }

    @Override
    public long count() {
        return this.btw17WahlkreisRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        this.btw17WahlkreisRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17Wahlkreis domainObject) {
        this.btw17WahlkreisRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Wahlkreis create(Btw17Wahlkreis domainObject) {
        return this.btw17WahlkreisRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Wahlkreis update(Btw17Wahlkreis domainObject) {
        return this.btw17WahlkreisRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return this.btw17WahlkreisRepository.getAllIds();
    }

    @Override
    public Btw17Wahlkreis findById(long id) {
        return this.btw17WahlkreisRepository.findOne(id);
    }

    @Override
    public long getMaxId() {
        return this.btw17WahlkreisRepository.getMaxId();
    }
}
