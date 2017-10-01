package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.repositories.Btw17StrukturdatenRepository;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17StrukturdatenService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17StrukturdatenServiceImpl implements Btw17StrukturdatenService {

    private final Btw17StrukturdatenRepository btw17StrukturdatenRepository;

    @Autowired
    public Btw17StrukturdatenServiceImpl(Btw17StrukturdatenRepository btw17StrukturdatenRepository) {
        this.btw17StrukturdatenRepository = btw17StrukturdatenRepository;
    }

    @Override
    public Page<Btw17Strukturdaten> findByWahlkreisNummer(Long wahlkreisNummer, Pageable pageRequest) {
        return btw17StrukturdatenRepository.findByWahlkreisNummer(wahlkreisNummer,pageRequest);
    }

    @Override
    public Page<Btw17Strukturdaten> findByBundeslandName(String bundeslandName, Pageable pageRequest) {
        return btw17StrukturdatenRepository.findByBundeslandName(bundeslandName, pageRequest);
    }

    @Override
    public Page<Btw17Strukturdaten> getAll(Pageable pageRequest) {
        return btw17StrukturdatenRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Strukturdaten> getAll() {
        return btw17StrukturdatenRepository.findAll();
    }

    @Override
    public long count() {
        return btw17StrukturdatenRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        btw17StrukturdatenRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17Strukturdaten domainObject) {
        btw17StrukturdatenRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Strukturdaten create(Btw17Strukturdaten domainObject) {
        return btw17StrukturdatenRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Strukturdaten update(Btw17Strukturdaten domainObject) {
        return btw17StrukturdatenRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return btw17StrukturdatenRepository.getAllIds();
    }

    @Override
    public Btw17Strukturdaten findById(long id) {
        return btw17StrukturdatenRepository.findOne(id);
    }
}
