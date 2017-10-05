package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17StrukturdatenRepositoryCustom;

import java.util.List;

@Repository
public interface Btw17StrukturdatenRepository extends PagingAndSortingRepository<Btw17Strukturdaten,Long>,Btw17StrukturdatenRepositoryCustom  {

    Page<Btw17Strukturdaten> findByWahlkreisNummer(Long wahlkreisNummer, Pageable pageRequest);

    Page<Btw17Strukturdaten> findByBundeslandName(String bundeslandName, Pageable pageRequest);

    @Query(name="Btw17Strukturdaten.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Strukturdaten.getStrukturdatenOfBundeslaender")
    List<Btw17Strukturdaten> getStrukturdatenOfBundeslaender();

}
