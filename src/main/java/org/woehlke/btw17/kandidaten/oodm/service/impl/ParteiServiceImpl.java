package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Partei;
import org.woehlke.btw17.kandidaten.oodm.repositories.ParteiRepository;
import org.woehlke.btw17.kandidaten.oodm.service.ParteiService;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ParteiServiceImpl implements ParteiService {

    private final ParteiRepository parteiRepository;

    @Autowired
    public ParteiServiceImpl(ParteiRepository parteiRepository) {
        this.parteiRepository = parteiRepository;
    }

    @Override
    public Page<Partei> getAll(Pageable pageRequest) {
        return parteiRepository.findAll(pageRequest);
    }

    @Override
    public List<Partei> getAll() {
        return this.parteiRepository.getAll();
    }

    @Override
    public Partei findByPartei(String partei, String parteiLang) {
        return parteiRepository.findByParteiAndParteiLang(partei,parteiLang);
    }

    @Override
    public long count() {
        return parteiRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        parteiRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Partei update(Partei partei) {
        return parteiRepository.save(partei);
    }

    @Override
    public List<Long> getAllIds() {
        return parteiRepository.getAllIds();
    }

    @Override
    public Partei findById(long id) {
        return parteiRepository.findOne(id);
    }

    @Override
    public long getMaxId() {
        return parteiRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Partei create(Partei partei) {
        return parteiRepository.save(partei);
    }

    @Override
    public void delete(Partei partei) {
        parteiRepository.delete(partei);
    }
}
