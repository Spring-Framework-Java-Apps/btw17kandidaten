package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.BerufRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.BerufService;

import java.util.List;

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
    public Iterable<Beruf> getAll() {
        return berufRepository.findAll();
    }

    @Override
    public Beruf findByBeruf(String beruf) {
        return berufRepository.findByBeruf(beruf);
    }

    @Override
    public long count() {
        return berufRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        berufRepository.deleteAll();;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Beruf update(Beruf beruf) {
        return berufRepository.save(beruf);
    }

    @Override
    public List<Long> getAllIds() {
        return berufRepository.getAllIds();
    }

    @Override
    public Beruf findById(long id) {
        return berufRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return berufRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Beruf create(Beruf beruf) {
        return berufRepository.save(beruf);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Beruf beruf) {
        berufRepository.delete(beruf);
    }
}
