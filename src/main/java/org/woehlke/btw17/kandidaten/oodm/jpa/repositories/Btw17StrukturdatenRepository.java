package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Strukturdaten;

import java.util.List;

@Repository
public interface Btw17StrukturdatenRepository extends JpaRepository<Btw17Strukturdaten,Long> {

    Page<Btw17Strukturdaten> findByWahlkreisNummer(Long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Strukturdaten> findByBundeslandName(String bundeslandName, Pageable pageRequest);

    @Query(name="Btw17Strukturdaten.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Strukturdaten.getStrukturdatenOfBundeslaender")
    List<Btw17Strukturdaten> getStrukturdatenOfBundeslaender();

    @Query(name="Btw17Strukturdaten.getMaxId")
    Long getMaxId();
}
