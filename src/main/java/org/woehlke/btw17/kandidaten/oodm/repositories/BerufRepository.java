package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.BerufRepositoryCustom;

import java.util.List;

@Repository
public interface BerufRepository extends PagingAndSortingRepository<Beruf,Long>,BerufRepositoryCustom {

    Beruf findByBeruf(String beruf);


    List<Long> getAllIds();


    long getMaxId();

}
