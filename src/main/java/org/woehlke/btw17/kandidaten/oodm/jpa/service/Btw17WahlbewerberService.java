package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlbewerber;


public interface Btw17WahlbewerberService extends Btw17Service<Btw17Wahlbewerber> {

    Page<Btw17Wahlbewerber> findByWahlkreisNr(long wahlkreisNr, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWiederkandidatur(boolean wiederkandidatur, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWohnort(String wohnort, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByGeburtsort(String geburtsort, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByBeruf(String beruf, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisLand(BundeslandEnum wahlkreisLand, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByListeLand(String listeLand, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisParteiBez(String wahlkreisParteiBez, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisParteiKurzBez(String wahlkreisParteiKurzBez, Pageable pageRequest);

}
