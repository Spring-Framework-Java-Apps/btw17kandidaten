package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;

public interface BundeslandService {

    Page<Bundesland> getAll(Pageable pageRequest);
}
