package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.repositories.Btw17ErgebnisRepository;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17ErgebnisService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17ErgebnisServiceImpl implements Btw17ErgebnisService {

    private final Btw17ErgebnisRepository btw17ErgebnisRepository;

    @Autowired
    public Btw17ErgebnisServiceImpl(Btw17ErgebnisRepository btw17ErgebnisRepository) {
        this.btw17ErgebnisRepository = btw17ErgebnisRepository;
    }

    @Override
    public Page<Btw17Ergebnis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest) {
        return btw17ErgebnisRepository.findByWahlkreisNummer(wahlkreisNummer,pageRequest);
    }

    @Override
    public Page<Btw17Ergebnis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest) {
        return btw17ErgebnisRepository.findByBundeslandNummer(bundeslandNummer, pageRequest);
    }

    @Override
    public Page<Btw17Ergebnis> getAll(Pageable pageRequest) {
        return btw17ErgebnisRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Ergebnis> getAll() {
        return btw17ErgebnisRepository.findAll();
    }

    @Override
    public long count() {
        return btw17ErgebnisRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        btw17ErgebnisRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17Ergebnis domainObject) {
        btw17ErgebnisRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Ergebnis create(Btw17Ergebnis domainObject) {
        return btw17ErgebnisRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Ergebnis update(Btw17Ergebnis domainObject) {
        return btw17ErgebnisRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return btw17ErgebnisRepository.getAllIds();
    }


    @Override
    public Btw17Ergebnis findById(long id) {
        return btw17ErgebnisRepository.findOne(id);
    }

}
