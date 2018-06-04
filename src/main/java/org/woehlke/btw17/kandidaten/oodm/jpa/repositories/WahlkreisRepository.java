package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;

import java.util.List;

@Repository
public interface WahlkreisRepository extends JpaDomainRepository<Wahlkreis> {

    Wahlkreis findByWahlkreisId(Long wahlkreisId);

    @Query(name="Wahlkreis.getAllIds")
    List<Long> getAllIds();

    @Query(name="Wahlkreis.getMaxId")
    Long getMaxId();

}
