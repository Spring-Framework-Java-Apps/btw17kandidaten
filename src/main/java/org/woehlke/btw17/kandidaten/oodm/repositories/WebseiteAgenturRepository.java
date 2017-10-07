package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;

import java.util.List;

@Repository
public interface WebseiteAgenturRepository extends JpaRepository<WebseiteAgentur,Long> {

    WebseiteAgentur findByAgentur(String agentur);

    @Query(name="WebseiteAgentur.getAllIds")
    List<Long> getAllIds();

    @Query(name="WebseiteAgentur.getMaxId")
    long getMaxId();

}
