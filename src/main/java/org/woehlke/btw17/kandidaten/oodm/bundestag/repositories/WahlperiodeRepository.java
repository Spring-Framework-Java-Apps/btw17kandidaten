package org.woehlke.btw17.kandidaten.oodm.bundestag.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.bundestag.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.bundestag.repositories.custom.WahlperiodeRepositoryCustom;

import java.util.List;

@Repository
public interface WahlperiodeRepository extends PagingAndSortingRepository<Wahlperiode,Long>,WahlperiodeRepositoryCustom {

    @Query(name = "Wahlperiode.getAllIds")
    List<Long> getAllIds();
}
