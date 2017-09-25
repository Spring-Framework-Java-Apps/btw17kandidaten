package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;


public interface BerufsgruppeService {

    Page<Berufsgruppe> getAll(Pageable pageRequest);

    Iterable<Berufsgruppe> getAll();

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

    long count();

    void deleteAll();

    Berufsgruppe update(Berufsgruppe berufsgruppe);

    Berufsgruppe create(Berufsgruppe berufsgruppe);

    void delete(Berufsgruppe berufsgruppe);
}
