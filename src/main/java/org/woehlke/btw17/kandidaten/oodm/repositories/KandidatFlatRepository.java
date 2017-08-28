package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat;

public interface KandidatFlatRepository  extends PagingAndSortingRepository<KandidatFlat,Long> {
}
