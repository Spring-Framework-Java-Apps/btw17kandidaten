package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Wahlkreis;

import java.util.List;

@Repository
public interface Btw17WahlkreisRepository extends JpaRepository<Btw17Wahlkreis,Long> {

    Page<Btw17Wahlkreis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Wahlkreis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest);

    @Query(name="Btw17Wahlkreis.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Wahlkreis.getMaxId")
    long getMaxId();

}
