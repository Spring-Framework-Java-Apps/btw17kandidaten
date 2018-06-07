package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Fraktion;

import java.util.List;

@Repository
public interface FraktionRepository extends JpaDomainRepository<Fraktion> {

    Fraktion findByFraktion(String fraktion);

    @Query(name="Fraktion.getAllIds")
    List<Long> getAllIds();

    @Query(name="Fraktion.getMaxId")
    Long getMaxId();

}
