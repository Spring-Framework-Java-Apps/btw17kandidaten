package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;

public interface BerufsgruppeService {

    Page<Berufsgruppe> getAll(Pageable pageRequest);

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

    long count();

    void deleteAll();

}
