package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.AusschussRepositoryCustom;

import java.util.List;

@Repository
public interface AusschussRepository extends PagingAndSortingRepository<Ausschuss,Long>,AusschussRepositoryCustom {

    Ausschuss findByAusschuss(String ausschuss);

    List<Long> getAllIds();

    long getMaxId();
}
