package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.model.parts.Strukturdaten;


public interface Btw17StrukturdatenService extends Btw17Service<Btw17Strukturdaten> {

    Page<Btw17Strukturdaten> findByWahlkreisNummer(Long wahlkreisNummer,Pageable pageRequest);

    Page<Btw17Strukturdaten> findByBundeslandName(String bundeslandName, Pageable pageRequest);

    Strukturdaten getStrukturdatenFromBtw17Strukturdaten(Btw17Strukturdaten btw17Strukturdaten);
}
