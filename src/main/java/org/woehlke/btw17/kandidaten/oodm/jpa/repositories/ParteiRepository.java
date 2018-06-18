package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Partei;

import java.util.List;

@Repository("jpa.ParteiRepository")
public interface ParteiRepository extends JpaDomainRepository<Partei> {

    Partei findByParteiAndParteiLang(String partei, String parteiLang);

    @Query(
        name="Partei.getAllIds",
        countQuery="Partei.countAllIds"
    )
    List<Long> getAllIds();

    @Query(
        name="Partei.getMaxId"
    )
    Long getMaxId();

}
