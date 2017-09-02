package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Partei;


public interface ParteiService {

    Page<Partei> getAll(Pageable pageRequest);

    Iterable<Partei> getAll();

    Partei findByPartei(String partei, String parteiLang);

    long count();

    void deleteAll();

}
