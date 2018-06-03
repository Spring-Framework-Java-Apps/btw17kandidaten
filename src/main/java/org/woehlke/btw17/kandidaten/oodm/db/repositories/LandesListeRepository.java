package org.woehlke.btw17.kandidaten.oodm.db.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.db.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei;

import java.util.List;

@Repository
public interface LandesListeRepository extends JpaRepository<LandesListe,Long> {


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

    @Query(name="LandesListe.getAllIds")
    List<Long> getAllIds();

    @Query(name="LandesListe.getMaxId")
    Long getMaxId();

}
