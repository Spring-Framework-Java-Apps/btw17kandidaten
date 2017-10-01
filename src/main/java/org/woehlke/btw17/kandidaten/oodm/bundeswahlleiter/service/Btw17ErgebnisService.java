package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Ergebnis;


public interface Btw17ErgebnisService extends Btw17Service<Btw17Ergebnis> {

    Page<Btw17Ergebnis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Ergebnis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);
}
