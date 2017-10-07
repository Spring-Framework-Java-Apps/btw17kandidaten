package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WebseiteAgenturRepositoryCustom;

import java.util.List;

@Repository
public interface WebseiteAgenturRepository extends PagingAndSortingRepository<WebseiteAgentur,Long>, WebseiteAgenturRepositoryCustom {

    @Query(
        name = "WebseiteAgentur.findByAgentur",
        countName = "WebseiteAgentur.countByAgentur"
    )
    WebseiteAgentur findByAgentur(@Param("agentur") String agentur);

    List<Long> getAllIds();

    long getMaxId();

}
