package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.ListeParteiRepositoryCustom;

public interface ListeParteiRepository extends PagingAndSortingRepository<ListePartei,Long>,ListeParteiRepositoryCustom {
}
