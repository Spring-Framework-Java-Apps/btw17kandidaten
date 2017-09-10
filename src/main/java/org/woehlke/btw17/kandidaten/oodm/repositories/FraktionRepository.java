package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.FraktionRepositoryCustom;

import java.util.List;

@Repository
public interface FraktionRepository extends PagingAndSortingRepository<Fraktion,Long>,FraktionRepositoryCustom {

    @Query(name="Fraktion.getAll")
    List<Fraktion> getAll();

    @Query(name="Fraktion.getAll",countName = "Fraktion.getAllCount")
    Page<Fraktion> getAll(Pageable pageRequest);

    Fraktion findByFraktion(String fraktion);
}
