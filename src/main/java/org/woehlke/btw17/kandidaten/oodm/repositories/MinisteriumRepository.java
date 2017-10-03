package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.MinisteriumRepositoryCustom;

import java.util.List;


@Repository
public interface MinisteriumRepository extends PagingAndSortingRepository<Ministerium,Long>,MinisteriumRepositoryCustom {

    @Query(name="Ministerium.getAll")
    List<Ministerium> getAll();

    Ministerium findByMinisterium(String ministerium);
}
