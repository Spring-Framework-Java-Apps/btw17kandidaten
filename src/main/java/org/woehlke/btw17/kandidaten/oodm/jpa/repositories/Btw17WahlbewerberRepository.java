package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlbewerber;

import java.util.List;

@Repository
public interface Btw17WahlbewerberRepository extends JpaDomainRepository<Btw17Wahlbewerber> {

    Page<Btw17Wahlbewerber> findByWahlkreisNr(long wahlkreisNr, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWiederkandidatur(boolean wiederkandidatur, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWohnort(String wohnort, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByGeburtsort(String geburtsort, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByBeruf(String beruf, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisLand(BundeslandEnum wahlkreisLand, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByListeLand(String listeLand, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisParteiBez(String wahlkreisParteiBez, Pageable pageRequest);

    Page<Btw17Wahlbewerber> findByWahlkreisParteiKurzBez(String wahlkreisParteiKurzBez, Pageable pageRequest);

    @Query(
        name="Btw17Wahlbewerber.getAllIds",
        countQuery="Btw17Wahlbewerber.countAllIds"
    )
    List<Long> getAllIds();

    @Query(name="Btw17Wahlbewerber.getMaxId")
    Long getMaxId();

}
