package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;

import java.util.List;

public interface MinisteriumService {

    List<Ministerium> getAll();

    Page<Ministerium> getAll(Pageable pageRequest);

    Ministerium findByMinisterium(String ministerium);

    long count();

    void deleteAll();

}
