package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;

import java.util.List;

@Repository
public interface BundeslandRepository extends JpaDomainRepository<Bundesland> {

    Bundesland findByBundesland(BundeslandEnum bundesland);

    @Query(name="Bundesland.countBundeslandAgentur")
    long countBundeslandAgentur();

    @Query(name="Bundesland.getAllIds")
    List<Long> getAllIds();

    @Query(name="Bundesland.getMaxId")
    Long getMaxId();

}
