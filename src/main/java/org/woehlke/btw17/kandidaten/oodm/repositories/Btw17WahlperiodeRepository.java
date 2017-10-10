package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundestag.Btw17Wahlperiode;

import java.util.List;

@Repository
public interface Btw17WahlperiodeRepository extends JpaRepository<Btw17Wahlperiode,Long> {

    @Query(name = "Btw17Wahlperiode.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Btw17Wahlperiode.getMaxId")
    long getMaxId();

    Btw17Wahlperiode findByWpAndWkrnummer(String wp, String wkrnummer);
}
