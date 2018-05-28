package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.Btw17Wahlbewerber;
import org.woehlke.btw17.kandidaten.oodm.repositories.Btw17WahlbewerberRepository;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17WahlbewerberService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17WahlbewerberServiceImpl implements Btw17WahlbewerberService {

    private final Btw17WahlbewerberRepository btw17WahlbewerberRepository;

    @Autowired
    public Btw17WahlbewerberServiceImpl(Btw17WahlbewerberRepository btw17WahlbewerberRepository) {
        this.btw17WahlbewerberRepository = btw17WahlbewerberRepository;
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisNr(long wahlkreisNr, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByWahlkreisNr(wahlkreisNr,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWiederkandidatur(boolean wiederkandidatur, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByWiederkandidatur(wiederkandidatur, pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWohnort(String wohnort, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByWohnort(wohnort, pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByGeburtsort(String geburtsort, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByGeburtsort(geburtsort,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByBeruf(String beruf, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByBeruf(beruf, pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisLand(BundeslandEnum wahlkreisLand, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByWahlkreisLand(wahlkreisLand,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByListeLand(String listeLand, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByListeLand(listeLand,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisParteiBez(String wahlkreisParteiBez, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByWahlkreisParteiBez(wahlkreisParteiBez,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisParteiKurzBez(String wahlkreisParteiKurzBez, Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findByWahlkreisParteiKurzBez(wahlkreisParteiKurzBez,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> getAll(Pageable pageRequest) {
        return this.btw17WahlbewerberRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Wahlbewerber> getAll() {
        return this.btw17WahlbewerberRepository.findAll();
    }

    @Override
    public long count() {
        return this.btw17WahlbewerberRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        this.btw17WahlbewerberRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17Wahlbewerber domainObject) {
        this.btw17WahlbewerberRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Wahlbewerber create(Btw17Wahlbewerber domainObject) {
        return this.btw17WahlbewerberRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Wahlbewerber update(Btw17Wahlbewerber domainObject) {
        return this.btw17WahlbewerberRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return this.btw17WahlbewerberRepository.getAllIds();
    }

    @Override
    public Btw17Wahlbewerber findById(long id) {
        return this.btw17WahlbewerberRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return this.btw17WahlbewerberRepository.getMaxId();
    }

}
