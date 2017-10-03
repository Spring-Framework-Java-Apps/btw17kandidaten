package org.woehlke.btw17.kandidaten.oodm.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;

public interface WahlkreisService {

    Page<Wahlkreis> getAll(Pageable pageRequest);

    Wahlkreis findByWahlkreisId(long wahlkreisId);

    long count();

    void deleteAll();

    Wahlkreis update(Wahlkreis wahlkreis);

    Wahlkreis create(Wahlkreis wahlkreis);

    void delete(Wahlkreis wahlkreis);
}
