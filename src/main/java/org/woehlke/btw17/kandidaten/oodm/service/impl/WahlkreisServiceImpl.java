package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.repositories.WahlkreisRepository;
import org.woehlke.btw17.kandidaten.oodm.service.WahlkreisService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WahlkreisServiceImpl implements WahlkreisService {

    private final WahlkreisRepository wahlkreisRepository;

    @Autowired
    public WahlkreisServiceImpl(WahlkreisRepository wahlkreisRepository) {
        this.wahlkreisRepository = wahlkreisRepository;
    }

    @Override
    public Page<Wahlkreis> getAll(Pageable pageRequest) {
        return wahlkreisRepository.findAll(pageRequest);
    }
}
