package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.configuration.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.BundeslandRepositoryCustom;

@Repository
public interface BundeslandRepository extends PagingAndSortingRepository<Bundesland,Long>,BundeslandRepositoryCustom {

    Bundesland findByBundesland(BundeslandEnum bundesland);

    @Query(name="Bundesland.countBundeslandAgentur",nativeQuery=true)
    long countBundeslandAgentur();
}
