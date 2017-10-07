package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.GeburtsortRepositoryCustom;

import java.util.List;

@Repository
public interface GeburtsortRepository extends PagingAndSortingRepository<Geburtsort,Long>,GeburtsortRepositoryCustom {

    Geburtsort findByGeburtsort(String geburtsort);

    List<Long> getAllIds();

    long getMaxId();
}
