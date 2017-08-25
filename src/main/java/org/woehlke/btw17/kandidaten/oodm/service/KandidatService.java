package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;

public interface KandidatService {

    int FIRST_PAGE_NUMBER = 0;

    int PAGE_SIZE = 20;

    String PAGE_DEFAULT_SORT ="nachname";

    Page<Kandidat> getAll(Pageable pageRequest);
}
