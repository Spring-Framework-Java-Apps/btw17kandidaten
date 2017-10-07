package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WahlperiodeRepositoryCustom;

import java.util.List;

@Repository
public interface WahlperiodeRepository extends PagingAndSortingRepository<Wahlperiode,Long>,WahlperiodeRepositoryCustom {

    @Query(name = "Wahlperiode.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Wahlperiode.getMaxId",nativeQuery = false)
    long getMaxId();

}
