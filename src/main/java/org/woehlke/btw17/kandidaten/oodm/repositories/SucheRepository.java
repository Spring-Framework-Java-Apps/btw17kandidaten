package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;

public interface SucheRepository {

    Page<Kandidat> findByJpaQueryStatement(String query, long total, Pageable pageable);

    long countByJpaQueryStatement(String countQuery);

}
