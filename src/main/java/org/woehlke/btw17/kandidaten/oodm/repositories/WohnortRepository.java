package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WohnortRepositoryCustom;

import java.util.List;

@Repository
public interface WohnortRepository extends PagingAndSortingRepository<Wohnort,Long>,WohnortRepositoryCustom {

    Wohnort findByWohnort(String wohnort);

    @Query(name = "Wohnort.getAllOrderById")
    List<Wohnort> getAllOrderById();

    @Query(name = "Wohnort.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Wohnort.getMaxId",nativeQuery = true)
    long getMaxId();

}
