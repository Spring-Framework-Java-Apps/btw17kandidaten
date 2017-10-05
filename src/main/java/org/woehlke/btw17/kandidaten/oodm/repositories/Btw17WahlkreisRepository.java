package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17WahlkreisRepositoryCustom;

import java.util.List;

@Repository
public interface Btw17WahlkreisRepository extends PagingAndSortingRepository<Btw17Wahlkreis,Long>,Btw17WahlkreisRepositoryCustom {

    Page<Btw17Wahlkreis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Wahlkreis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);

    @Query(name="Btw17Wahlkreis.getAllIds")
    List<Long> getAllIds();

}
