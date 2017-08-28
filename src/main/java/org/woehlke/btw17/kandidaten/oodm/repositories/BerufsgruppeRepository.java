package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.BerufsgruppeRepositoryCustom;

public interface BerufsgruppeRepository extends PagingAndSortingRepository<Berufsgruppe,Long>,BerufsgruppeRepositoryCustom {
}
