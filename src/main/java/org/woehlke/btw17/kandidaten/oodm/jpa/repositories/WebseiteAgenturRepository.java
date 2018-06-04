package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteAgentur;

import java.util.List;

@Repository
public interface WebseiteAgenturRepository extends JpaRepository<WebseiteAgentur,Long> {

    WebseiteAgentur findByAgentur(String agentur);

    @Query(name="Dienstleister.getAllIds")
    List<Long> getAllIds();

    @Query(name="Dienstleister.getMaxId")
    Long getMaxId();

}
