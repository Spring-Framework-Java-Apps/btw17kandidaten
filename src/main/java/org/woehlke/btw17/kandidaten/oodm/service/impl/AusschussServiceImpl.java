package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.repositories.AusschussRepository;
import org.woehlke.btw17.kandidaten.oodm.service.AusschussService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class AusschussServiceImpl implements AusschussService {

    private final AusschussRepository ausschussRepository;

    @Autowired
    public AusschussServiceImpl(AusschussRepository ausschussRepository) {
        this.ausschussRepository = ausschussRepository;
    }

    @Override
    public List<Ausschuss> getAll() {
        return ausschussRepository.getAll();
    }

    @Override
    public Page<Ausschuss> getAll(Pageable pageRequest) {
        return ausschussRepository.getAll(pageRequest);
    }

    @Override
    public Ausschuss findByAusschuss(String ausschuss) {
        return ausschussRepository.findByAusschuss(ausschuss);
    }

    @Override
    public long count() {
        return ausschussRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        ausschussRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Ausschuss update(Ausschuss ausschuss) {
        return ausschussRepository.save(ausschuss);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Ausschuss create(Ausschuss ausschuss) {
        return ausschussRepository.save(ausschuss);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Ausschuss ausschuss) {
        ausschussRepository.delete(ausschuss);
    }
}
