package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;

import java.util.List;

public interface AusschussService {

    List<Ausschuss> getAll();

    Page<Ausschuss> getAll(Pageable pageRequest);

    Ausschuss findByAusschuss(String ausschuss);

    long count();

    void deleteAll();

    Ausschuss update(Ausschuss ausschuss);

    Ausschuss create(Ausschuss ausschuss);

    void delete(Ausschuss ausschuss);
}
