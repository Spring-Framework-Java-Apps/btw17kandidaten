package org.woehlke.btw17.kandidaten.oodm.bundestag.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.bundestag.model.Mdb;
import org.woehlke.btw17.kandidaten.oodm.bundestag.repositories.custom.MdbRepositoryCustom;

import java.util.List;

@Repository
public interface MdbRepository extends PagingAndSortingRepository<Mdb,Long>,MdbRepositoryCustom {

    @Query(name = "Mdb.getAllIds")
    List<Long> getAllIds();
}
