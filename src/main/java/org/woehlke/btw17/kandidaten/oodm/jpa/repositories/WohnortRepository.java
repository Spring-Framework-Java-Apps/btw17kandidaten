package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wohnort;

import java.util.List;

@Repository("jpa.WohnortRepository")
public interface WohnortRepository extends JpaDomainRepository<Wohnort> {

    Wohnort findByWohnort(String wohnort);

    @Override
    @Query(
        name = "Wohnort.getAllIds",
        countQuery=""
    )
    List<Long> getAllIds();

    @Override
    @Query(name = "Wohnort.getMaxId")
    Long getMaxId();

}
