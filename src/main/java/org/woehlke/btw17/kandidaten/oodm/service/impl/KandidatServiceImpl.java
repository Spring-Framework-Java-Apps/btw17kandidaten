package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.repositories.KandidatRepository;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class KandidatServiceImpl implements KandidatService {

    private final KandidatRepository kandidatRepository;

    @Autowired
    public KandidatServiceImpl(KandidatRepository kandidatRepository) {
        this.kandidatRepository = kandidatRepository;
    }

    @Override
    public Page<Kandidat> getAll(Pageable pageRequest) {
        return kandidatRepository.findAll(pageRequest);
    }
}
