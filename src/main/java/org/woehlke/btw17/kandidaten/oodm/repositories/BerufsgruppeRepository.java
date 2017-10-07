package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.BerufsgruppeRepositoryCustom;

import java.util.List;

@Repository
public interface BerufsgruppeRepository extends PagingAndSortingRepository<Berufsgruppe,Long>,BerufsgruppeRepositoryCustom {

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

    List<Long> getAllIds();

    long getMaxId();

}
