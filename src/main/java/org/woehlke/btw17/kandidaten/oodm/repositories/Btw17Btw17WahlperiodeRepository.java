package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundestag.BtwWahlperiode;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17WahlperiodeRepositoryCustom;

import java.util.List;

@Repository
public interface Btw17Btw17WahlperiodeRepository extends PagingAndSortingRepository<BtwWahlperiode,Long>,Btw17WahlperiodeRepositoryCustom {

    @Query(name = "BtwWahlperiode.getAllIds")
    List<Long> getAllIds();
}
