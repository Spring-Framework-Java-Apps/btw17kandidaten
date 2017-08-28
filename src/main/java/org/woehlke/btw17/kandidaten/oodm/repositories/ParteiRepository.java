package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Partei;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.ParteiRepositoryCustom;

@Repository
public interface ParteiRepository extends PagingAndSortingRepository<Partei,Long>,ParteiRepositoryCustom {

    Partei findByParteiAndParteiLang(String partei, String parteiLang);
}
