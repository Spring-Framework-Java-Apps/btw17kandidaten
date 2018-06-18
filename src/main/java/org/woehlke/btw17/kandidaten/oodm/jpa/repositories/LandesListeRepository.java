package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.ListePartei;

import java.util.List;

@Repository
public interface LandesListeRepository extends JpaDomainRepository<LandesListe> {


    LandesListe findByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei);

    @Query(name="LandesListe.findByBundesland")
    Page<LandesListe> findByBundesland(@Param("bundesland") Bundesland bundesland, Pageable pageable);

    @Query(name="LandesListe.findByListePartei")
    Page<LandesListe> findByListePartei(@Param("listePartei") ListePartei listePartei, Pageable pageable);

    @Query(name="LandesListe.getAllBundesland")
    Page<Bundesland> getAllBundesland(Pageable pageable);

    @Query(name="LandesListe.getAllListePartei")
    Page<ListePartei> getAllListePartei(Pageable pageable);

    @Query(name="LandesListe.getAllOrOrderById")
    List<LandesListe> getAll();

    @Override
    @Query(name="LandesListe.getAllIds")
    List<Long> getAllIds();

    @Override
    @Query(name="LandesListe.getMaxId")
    Long getMaxId();

}
