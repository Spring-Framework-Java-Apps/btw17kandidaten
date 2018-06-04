package org.woehlke.btw17.kandidaten.oodm.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.db.model.WebseiteAgentur;

import java.util.List;

@Repository
public interface WebseiteAgenturRepository extends JpaRepository<WebseiteAgentur,Long> {

    WebseiteAgentur findByAgentur(String agentur);

    @Query(name="Agentur.getAllIds")
    List<Long> getAllIds();

    @Query(name="Agentur.getMaxId")
    Long getMaxId();

}
