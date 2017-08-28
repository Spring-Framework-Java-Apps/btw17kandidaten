package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.BerufRepositoryCustom;

public interface BerufRepository extends PagingAndSortingRepository<Beruf,Long>,BerufRepositoryCustom {
}
