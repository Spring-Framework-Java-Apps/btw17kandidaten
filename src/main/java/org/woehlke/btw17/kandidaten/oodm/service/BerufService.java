package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;

public interface BerufService {

    Page<Beruf> getAll(Pageable pageRequest);

    Beruf findByBeruf(String beruf);

    long count();

    void deleteAll();

    Beruf update(Beruf beruf);
}
