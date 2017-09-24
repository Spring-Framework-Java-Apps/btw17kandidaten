package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WebseiteAgenturRepositoryCustom;

@Repository
public interface WebseiteAgenturRepository extends PagingAndSortingRepository<WebseiteAgentur,Long>, WebseiteAgenturRepositoryCustom {
}
