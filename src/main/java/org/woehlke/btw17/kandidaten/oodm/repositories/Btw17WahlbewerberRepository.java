package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.configuration.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Wahlbewerber;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17WahlbewerberRepositoryCustom;

import java.util.List;

@Repository
public interface Btw17WahlbewerberRepository extends PagingAndSortingRepository<Btw17Wahlbewerber,Long>,Btw17WahlbewerberRepositoryCustom {

    Page<Btw17Wahlbewerber> findByWahlkreisNr(long wahlkreisNr, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWiederkandidatur(boolean wiederkandidatur, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWohnort(String wohnort, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByGeburtsort(String geburtsort, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByBeruf(String beruf, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisLand(BundeslandEnum wahlkreisLand, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByListeLand(String listeLand, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisParteiBez(String wahlkreisParteiBez, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisParteiKurzBez(String wahlkreisParteiKurzBez, Pageable pageRequest);

    @Query(name="Btw17Wahlbewerber.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Wahlbewerber.getMaxId",nativeQuery = true)
    long getMaxId();

}
