package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.AusschussRepositoryCustom;

import java.util.List;

@Repository
public interface AusschussRepository extends PagingAndSortingRepository<Ausschuss,Long>,AusschussRepositoryCustom {

    @Query(name="Ausschuss.getAll")
    List<Ausschuss> getAll();

    @Query(
        name="Ausschuss.getAll",
        countName = "Ausschuss.getAllCount"
    )
    Page<Ausschuss> getAll(Pageable pageRequest);

    Ausschuss findByAusschuss(String ausschuss);
}
