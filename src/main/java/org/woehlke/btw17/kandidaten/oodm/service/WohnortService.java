package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;

import java.util.List;

public interface WohnortService {

    Page<Wohnort> getAll(Pageable pageRequest);

    Wohnort findByWohnort(String wohnort);

    long count();

    void deleteAll();

    List<Wohnort> getAllOrderById();

    void update(Wohnort wohnort);

    Wohnort create(Wohnort wohnort);
}
