package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlperiode;

import java.util.List;

@Repository
public interface Btw17WahlperiodeRepository extends JpaDomainRepository<Btw17Wahlperiode> {

    @Query(name = "Btw17Wahlperiode.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Btw17Wahlperiode.getMaxId")
    Long getMaxId();

    Btw17Wahlperiode findByWpAndWkrnummer(String wp, String wkrnummer);
}
