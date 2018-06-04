package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.ListePartei;

import java.util.List;

@Repository
public interface LandesListeRepository extends JpaRepository<LandesListe,Long> {


    LandesListe findByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei);

    @Query(name="ListeParteiBundesland.findByBundesland")
    Page<LandesListe> findByBundesland(@Param("bundesland") Bundesland bundesland, Pageable pageable);

    @Query(name="ListeParteiBundesland.findByListePartei")
    Page<LandesListe> findByListePartei(@Param("listePartei") ListePartei listePartei, Pageable pageable);

    @Query(name="ListeParteiBundesland.getAllBundesland")
    Page<Bundesland> getAllBundesland(Pageable pageable);

    @Query(name="ListeParteiBundesland.getAllListePartei")
    Page<ListePartei> getAllListePartei(Pageable pageable);

    @Query(name="ListeParteiBundesland.getAllOrOrderById")
    List<LandesListe> getAll();

    @Query(name="ListeParteiBundesland.getAllIds")
    List<Long> getAllIds();

    @Query(name="ListeParteiBundesland.getMaxId")
    Long getMaxId();

}
