package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;

public interface GeburtsortService {

    Page<Geburtsort> getAll(Pageable pageRequest);

    Geburtsort findByGeburtsort(String geburtsort);
}
