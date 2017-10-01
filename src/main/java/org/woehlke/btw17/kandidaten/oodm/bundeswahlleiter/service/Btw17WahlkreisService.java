package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Wahlkreis;


public interface Btw17WahlkreisService extends Btw17Service<Btw17Wahlkreis> {

    Page<Btw17Wahlkreis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Wahlkreis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);

}
