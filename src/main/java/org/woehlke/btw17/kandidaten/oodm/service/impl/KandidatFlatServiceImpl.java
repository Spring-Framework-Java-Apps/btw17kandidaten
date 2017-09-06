package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.repositories.KandidatFlatRepository;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatFlatService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class KandidatFlatServiceImpl implements KandidatFlatService {

    private final KandidatFlatRepository kandidatFlatRepository;

    @Autowired
    public KandidatFlatServiceImpl(KandidatFlatRepository kandidatFlatRepository) {
        this.kandidatFlatRepository = kandidatFlatRepository;
    }

    @Override
    public Page<KandidatFlat> getAll(Pageable pageRequest) {
        return kandidatFlatRepository.findAll(pageRequest);
    }

    @Override
    public Page<KandidatFlat> getAllOrderByNachname(Pageable pageRequest) {
        return kandidatFlatRepository.getAllOrderByNachname(pageRequest);
    }

    @Override
    public long count() {
        return kandidatFlatRepository.count();
    }

    @Override
    public List<Long> getAllIdsWhereMdbIsNotNull() {
        return kandidatFlatRepository.getAllIdsWhereMdbIsNotNull();
    }
}
