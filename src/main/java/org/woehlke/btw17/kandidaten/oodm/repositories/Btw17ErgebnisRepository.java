package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17ErgebnisRepositoryCustom;

import java.util.List;

public interface Btw17ErgebnisRepository extends PagingAndSortingRepository<Btw17Ergebnis,Long>,Btw17ErgebnisRepositoryCustom {


    Page<Btw17Ergebnis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Ergebnis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);

    @Query(name="Btw17Ergebnis.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Ergebnis.getErgebnisOfBundeslaender")
    List<Btw17Ergebnis> getErgebnisOfBundeslaender();
}
