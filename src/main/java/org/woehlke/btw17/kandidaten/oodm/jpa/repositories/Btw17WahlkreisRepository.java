package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlkreis;

import java.util.List;

@Repository
public interface Btw17WahlkreisRepository extends JpaDomainRepository<Btw17Wahlkreis> {

    Btw17Wahlkreis findByWahlkreisNummer(long wahlkreisNummer);

    @Query(name="Btw17Wahlkreis.findByBundeslandNummer")
    BundeslandEnum findByBundeslandNummer(@Param("bundeslandNummer") long bundeslandNummer);

    @Query(name="Btw17Wahlkreis.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17Wahlkreis.getMaxId")
    Long getMaxId();

}
