package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WebseiteCmsRepositoryCustom;

@Repository
public interface WebseiteCmsRepository extends PagingAndSortingRepository<WebseiteCms,Long>, WebseiteCmsRepositoryCustom {
}
