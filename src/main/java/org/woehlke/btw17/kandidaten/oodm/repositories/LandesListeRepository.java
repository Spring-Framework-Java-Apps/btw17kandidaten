package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;

@Repository
public interface LandesListeRepository extends PagingAndSortingRepository<LandesListe,Long> {

    LandesListe findByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei);

    Page<LandesListe> findByBundesland(Bundesland bundesland, Pageable pageable);

    Page<LandesListe> findByListePartei(ListePartei listePartei, Pageable pageable);

    @Query(name="LandesListe.getAllBundesland")
    Page<Bundesland> getAllBundesland(Pageable pageable);

    @Query(name="LandesListe.getAllListePartei")
    Page<ListePartei> getAllListePartei(Pageable pageable);
}
