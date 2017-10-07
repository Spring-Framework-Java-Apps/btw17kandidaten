package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundestag.Btw17Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17WahlperiodeRepositoryCustom;

import java.util.List;

@Repository
public interface Btw17WahlperiodeRepository extends PagingAndSortingRepository<Btw17Wahlperiode,Long>,Btw17WahlperiodeRepositoryCustom {

    @Query(name = "Btw17Wahlperiode.getAllIds")
    List<Long> getAllIds();
}
