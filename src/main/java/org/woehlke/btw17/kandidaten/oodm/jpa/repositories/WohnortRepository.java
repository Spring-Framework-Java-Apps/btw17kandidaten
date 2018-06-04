package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wohnort;

import java.util.List;

@Repository
public interface WohnortRepository extends JpaDomainRepository<Wohnort> {

    Wohnort findByWohnort(String wohnort);

    @Query(name = "Ort.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Ort.getMaxId")
    Long getMaxId();

}
