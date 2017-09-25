package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WebseiteCmsRepositoryCustom;

@Repository
public interface WebseiteCmsRepository extends PagingAndSortingRepository<WebseiteCms,Long>, WebseiteCmsRepositoryCustom {

    @Query(
        name = "WebseiteCms.findByCms",
        countName = "WebseiteCms.countByCms"
    )
    WebseiteCms findByCms(@Param("cms") String cms);
}
