package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.ListeParteiRepositoryCustom;

@Repository
public interface ListeParteiRepository extends PagingAndSortingRepository<ListePartei,Long>,ListeParteiRepositoryCustom {

    ListePartei findByListeParteiAndListeParteiLang(String listePartei, String listeParteiLang);
}
