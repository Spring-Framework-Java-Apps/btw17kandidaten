package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.ListeParteiRepositoryCustom;

@Repository
public interface ListeParteiRepository extends PagingAndSortingRepository<ListePartei,Long>,ListeParteiRepositoryCustom {

    ListePartei findByListeParteiAndListeParteiLang(String listePartei, String listeParteiLang);


    @Query(name="ListePartei.findByListePartei")
    ListePartei findByListePartei(@Param("listePartei") String listePartei);
}
