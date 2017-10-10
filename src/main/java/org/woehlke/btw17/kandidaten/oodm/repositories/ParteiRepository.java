package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Partei;

import java.util.List;

@Repository
public interface ParteiRepository extends JpaRepository<Partei,Long> {

    Partei findByParteiAndParteiLang(String partei, String parteiLang);

    @Query(name="Partei.getMaxId")
    Long getMaxId();

    @Query(name="Partei.getAllIds")
    List<Long> getAllIds();

}
