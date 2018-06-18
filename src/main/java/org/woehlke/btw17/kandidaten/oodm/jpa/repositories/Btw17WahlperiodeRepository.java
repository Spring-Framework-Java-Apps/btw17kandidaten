package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlperiode;

import java.util.List;

@Repository("jpa.Btw17WahlperiodeRepository")
public interface Btw17WahlperiodeRepository extends JpaDomainRepository<Btw17Wahlperiode> {

    Btw17Wahlperiode findByWpAndWkrnummer(String wp, String wkrnummer);

    @Query(
        name = "Btw17Wahlperiode.getAllIds",
        countQuery="Btw17Wahlperiode.countAllIds"
    )
    List<Long> getAllIds();

    @Query(name = "Btw17Wahlperiode.getMaxId")
    Long getMaxId();
}
