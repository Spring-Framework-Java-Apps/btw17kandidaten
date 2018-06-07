package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.parts.WahlergebnisseBtw17;

import java.util.List;


public interface Btw17ErgebnisService extends JpaDomainService<Btw17Ergebnis> {

    Page<Btw17Ergebnis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Ergebnis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);

    WahlergebnisseBtw17 getWahlergebnisseFromBtw17Ergebnis(Btw17Ergebnis btw17Ergebnis);

    List<Btw17Ergebnis> getErgebnisOfBundeslaender();

}
