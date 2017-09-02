package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.woehlke.btw17.kandidaten.frontend.content.SearchForKandidat;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.repositories.SucheRepository;
import org.woehlke.btw17.kandidaten.oodm.service.SucheService;

@Service
public class SucheServiceImpl implements SucheService {

    @Override
    public Page<Kandidat> suchePerFormular(SearchForKandidat formular, Pageable pageable) {

        String query = "select o from Kandidat as o ";

        String countQuery = "select count(o) from Kandidat as o ";

        long counted = sucheRepository.countByJpaQueryStatement(countQuery);

        return sucheRepository.findByJpaQueryStatement(query,counted,pageable);
    }

    private final SucheRepository sucheRepository;

    @Autowired
    public SucheServiceImpl(SucheRepository sucheRepository) {
        this.sucheRepository = sucheRepository;
    }
}
