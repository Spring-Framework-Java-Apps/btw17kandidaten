package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;

public interface ListeParteiService {

    Page<ListePartei> getAll(Pageable pageRequest);

    ListePartei findByListePartei(String listePartei, String listeParteiLang);

    long count();

    void deleteAll();

    void update(ListePartei out);

    ListePartei findByPartei(String partei);

}
