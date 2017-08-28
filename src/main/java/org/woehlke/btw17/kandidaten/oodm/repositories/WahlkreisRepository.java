package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WahlkreisRepositoryCustom;

@Repository
public interface WahlkreisRepository extends PagingAndSortingRepository<Wahlkreis,Long>,WahlkreisRepositoryCustom {

    Wahlkreis findByWahlkreisId(Integer wahlkreisId);
}
