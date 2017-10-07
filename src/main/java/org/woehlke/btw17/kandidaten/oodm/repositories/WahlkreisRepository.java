package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WahlkreisRepositoryCustom;

import java.util.List;

@Repository
public interface WahlkreisRepository extends PagingAndSortingRepository<Wahlkreis,Long>,WahlkreisRepositoryCustom {

    Wahlkreis findByWahlkreisId(Long wahlkreisId);


    List<Long> getAllIds();


    long getMaxId();

}
