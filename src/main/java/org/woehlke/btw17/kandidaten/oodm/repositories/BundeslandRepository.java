package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;

import java.util.List;

@Repository
public interface BundeslandRepository extends JpaRepository<Bundesland,Long> {

    Bundesland findByBundesland(BundeslandEnum bundesland);

    @Query(name="Bundesland.countBundeslandAgentur")
    long countBundeslandAgentur();

    @Query(name="Bundesland.getAllIds")
    List<Long> getAllIds();

    @Query(name="Bundesland.getMaxId")
    long getMaxId();

}
