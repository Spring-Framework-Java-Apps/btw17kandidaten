package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms;
import org.woehlke.btw17.kandidaten.oodm.repositories.WebseiteCmsRepository;
import org.woehlke.btw17.kandidaten.oodm.service.WebseiteCmsService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WebseiteCmsServiceImpl implements WebseiteCmsService {

    private final WebseiteCmsRepository webseiteCmsRepository;

    @Autowired
    public WebseiteCmsServiceImpl(WebseiteCmsRepository webseiteCmsRepository) {
        this.webseiteCmsRepository = webseiteCmsRepository;
    }

    @Override
    public Iterable<WebseiteCms> getAll() {
        return webseiteCmsRepository.findAll();
    }

    @Override
    public Page<WebseiteCms> getAll(Pageable pageable) {
        return webseiteCmsRepository.findAll(pageable);
    }

    @Override
    public WebseiteCms findByCms(String cms) {
        return webseiteCmsRepository.findByCms(cms);
    }

    @Override
    public long count() {
        return webseiteCmsRepository.count();
    }

    @Override
    public void deleteAll() {
        webseiteCmsRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public WebseiteCms update(WebseiteCms webseiteCms) {
        return webseiteCmsRepository.save(webseiteCms);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public WebseiteCms create(WebseiteCms webseiteCms) {
        return webseiteCmsRepository.save(webseiteCms);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(WebseiteCms webseiteCms) {
        webseiteCmsRepository.delete(webseiteCms);
    }
}
