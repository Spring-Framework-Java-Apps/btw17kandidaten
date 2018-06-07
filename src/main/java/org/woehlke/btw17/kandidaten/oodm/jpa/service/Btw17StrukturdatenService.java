package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.parts.Strukturdaten;

import java.util.List;


public interface Btw17StrukturdatenService extends JpaDomainService<Btw17Strukturdaten> {

    Page<Btw17Strukturdaten> findByWahlkreisNummer(Long wahlkreisNummer,Pageable pageRequest);

    Page<Btw17Strukturdaten> findByBundeslandName(String bundeslandName, Pageable pageRequest);

    Strukturdaten getStrukturdatenFromBtw17Strukturdaten(Btw17Strukturdaten btw17Strukturdaten);

    List<Btw17Strukturdaten> getStrukturdatenOfBundeslaender();

}
