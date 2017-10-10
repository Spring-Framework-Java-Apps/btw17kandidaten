package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.frontend.model.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.model.SearchForKandidat;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;

public interface SucheService {

    Page<Kandidat> suchePerFormular(SearchForKandidat formular, Pageable pageable);

    Page<Kandidat> suchePerFreitextFormular(FreitextSucheFormular suchformular, Pageable pageable);
}
