package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Fraktion;

import java.util.List;

@Repository
public interface FraktionRepository extends JpaRepository<Fraktion,Long> {

    Fraktion findByFraktion(String fraktion);

    @Query(name="Fraktion.getAllIds")
    List<Long> getAllIds();

    @Query(name="Fraktion.getMaxId")
    long getMaxId();

}
