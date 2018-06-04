package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;

import java.util.List;

@Repository
public interface WahlkreisRepository extends JpaRepository<Wahlkreis,Long> {

    Wahlkreis findByWahlkreisId(Long wahlkreisId);

    @Query(name="Wahlkreis.getAllIds")
    List<Long> getAllIds();

    @Query(name="Wahlkreis.getMaxId")
    Long getMaxId();

}
