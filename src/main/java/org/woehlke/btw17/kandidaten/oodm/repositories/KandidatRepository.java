package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.KandidatRepositoryCustom;

@Repository
public interface KandidatRepository extends PagingAndSortingRepository<Kandidat,Long>,KandidatRepositoryCustom {
}
