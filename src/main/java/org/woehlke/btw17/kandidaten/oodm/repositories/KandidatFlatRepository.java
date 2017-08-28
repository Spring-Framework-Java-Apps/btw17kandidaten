package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat;

@Repository
public interface KandidatFlatRepository  extends PagingAndSortingRepository<KandidatFlat,Long> {
}
