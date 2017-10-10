package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlperiode;

import java.util.List;

@Repository
public interface WahlperiodeRepository extends JpaRepository<Wahlperiode,Long> {

    @Query(name = "Wahlperiode.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Wahlperiode.getMaxId")
    Long getMaxId();

}
