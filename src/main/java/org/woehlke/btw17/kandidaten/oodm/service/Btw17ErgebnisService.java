package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.model.parts.WahlergebnisseBtw17;

import java.util.List;


public interface Btw17ErgebnisService extends Btw17Service<Btw17Ergebnis> {

    Page<Btw17Ergebnis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Ergebnis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);

    WahlergebnisseBtw17 getWahlergebnisseFromBtw17Ergebnis(Btw17Ergebnis btw17Ergebnis);

    List<Btw17Ergebnis> getErgebnisOfBundeslaender();

}
