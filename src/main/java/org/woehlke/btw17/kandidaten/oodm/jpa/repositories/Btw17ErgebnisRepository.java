package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Ergebnis;

import java.util.List;

public interface Btw17ErgebnisRepository extends JpaDomainRepository<Btw17Ergebnis> {


    Page<Btw17Ergebnis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Ergebnis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);

    @Query(name="Btw17Ergebnis.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Ergebnis.getErgebnisOfBundeslaender")
    List<Btw17Ergebnis> getErgebnisOfBundeslaender();

    @Query(name="Btw17Ergebnis.getMaxId")
    Long getMaxId();

}
