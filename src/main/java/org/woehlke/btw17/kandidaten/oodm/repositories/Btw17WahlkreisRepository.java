package org.woehlke.btw17.kandidaten.oodm.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Wahlkreis;

import java.util.List;

@Repository
public interface Btw17WahlkreisRepository extends JpaRepository<Btw17Wahlkreis,Long> {

    Btw17Wahlkreis findByWahlkreisNummer(long wahlkreisNummer);

    @Query(name="Btw17Wahlkreis.findByBundeslandNummer")
    BundeslandEnum findByBundeslandNummer(@Param("bundeslandNummer") long bundeslandNummer);

    @Query(name="Btw17Wahlkreis.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Wahlkreis.getMaxId")
    long getMaxId();

}
