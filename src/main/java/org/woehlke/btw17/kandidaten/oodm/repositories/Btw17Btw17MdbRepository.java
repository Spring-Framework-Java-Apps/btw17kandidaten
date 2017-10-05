package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundestag.Btw17Mdb;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17MdbRepositoryCustom;

import java.util.List;

@Repository
public interface Btw17Btw17MdbRepository extends PagingAndSortingRepository<Btw17Mdb,Long>,Btw17MdbRepositoryCustom {

    @Query(name = "Btw17Mdb.getAllIds")
    List<Long> getAllIds();
}
