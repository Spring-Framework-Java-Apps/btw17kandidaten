package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.GeburtsortRepositoryCustom;

public interface GeburtsortRepository extends PagingAndSortingRepository<Geburtsort,Long>,GeburtsortRepositoryCustom {
}
