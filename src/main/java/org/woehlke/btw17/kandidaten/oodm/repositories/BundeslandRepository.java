package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.BundeslandRepositoryCustom;

public interface BundeslandRepository extends PagingAndSortingRepository<Bundesland,Long>,BundeslandRepositoryCustom {
}
