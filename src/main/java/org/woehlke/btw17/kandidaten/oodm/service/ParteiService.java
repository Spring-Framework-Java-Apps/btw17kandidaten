package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Partei;

import java.util.List;


public interface ParteiService {

    Page<Partei> getAll(Pageable pageRequest);

    List<Partei> getAll();

    Partei findByPartei(String partei, String parteiLang);

    long count();

    void deleteAll();

    Partei update(Partei partei);

    Partei create(Partei partei);
}
