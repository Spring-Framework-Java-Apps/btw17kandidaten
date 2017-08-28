package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WohnortRepositoryCustom;

@Repository
public interface WohnortRepository extends PagingAndSortingRepository<Wohnort,Long>,WohnortRepositoryCustom {

    Wohnort findByWohnort(String wohnort);
}
