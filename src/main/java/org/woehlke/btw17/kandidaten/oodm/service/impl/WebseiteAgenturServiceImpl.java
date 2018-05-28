package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.repositories.WebseiteAgenturRepository;
import org.woehlke.btw17.kandidaten.oodm.service.WebseiteAgenturService;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WebseiteAgenturServiceImpl implements WebseiteAgenturService {

    private final WebseiteAgenturRepository webseiteAgenturRepository;

    @Autowired
    public WebseiteAgenturServiceImpl(WebseiteAgenturRepository webseiteAgenturRepository) {
        this.webseiteAgenturRepository = webseiteAgenturRepository;
    }

    @Override
    public Iterable<WebseiteAgentur> getAll() {
        return webseiteAgenturRepository.findAll();
    }

    @Override
    public Page<WebseiteAgentur> getAll(Pageable pageable) {
        return webseiteAgenturRepository.findAll(pageable);
    }

    @Override
    public WebseiteAgentur findByAgentur(String agentur) {
        return webseiteAgenturRepository.findByAgentur(agentur);
    }

    @Override
    public long count() {
        return webseiteAgenturRepository.count();
    }

    @Override
    public void deleteAll() {
        webseiteAgenturRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public WebseiteAgentur update(WebseiteAgentur webseiteAgentur) {
        return webseiteAgenturRepository.save(webseiteAgentur);
    }

    @Override
    public List<Long> getAllIds() {
        return webseiteAgenturRepository.getAllIds();
    }

    @Override
    public WebseiteAgentur findById(long id) {
        return webseiteAgenturRepository.getOne(id);
    }

    @Override
    public Long getMaxId() {
        return webseiteAgenturRepository.getMaxId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public WebseiteAgentur create(WebseiteAgentur webseiteAgentur) {
        return webseiteAgenturRepository.save(webseiteAgentur);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(WebseiteAgentur webseiteAgentur) {
        webseiteAgenturRepository.delete(webseiteAgentur);
    }
}
