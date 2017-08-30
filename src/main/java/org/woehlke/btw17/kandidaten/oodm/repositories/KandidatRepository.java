package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.KandidatRepositoryCustom;

@Repository
public interface KandidatRepository extends PagingAndSortingRepository<Kandidat,Long>,KandidatRepositoryCustom {

    Page<Kandidat> findByBeruf(Beruf beruf, Pageable pageable);

    Page<Kandidat> findByBerufsgruppe(Berufsgruppe berufsgruppe, Pageable pageable);

    Page<Kandidat> findByBundesland(Bundesland bundesland, Pageable pageable);

    Page<Kandidat> findByGeburtsort(Geburtsort geburtsort, Pageable pageable);

    Page<Kandidat> findByListePartei(ListePartei listePartei, Pageable pageable);

    Page<Kandidat> findByPartei(Partei partei, Pageable pageable);

    Page<Kandidat> findByWahlkreis(Wahlkreis wahlkreis, Pageable pageable);

    Page<Kandidat> findByWohnort(Wohnort wohnort, Pageable pageable);

    @Query(name="Kandidat.findByMdB")
    Page<Kandidat> findByMdB(Pageable pageable);

    @Query(name="Kandidat.findByGeburtsjahrAll")
    Page<Integer> findByGeburtsjahrAll(Pageable pageable);

    @Query(name="Kandidat.findByListeBundeslandLandAll")
    Page<Bundesland> findByListeBundeslandLandAll(Pageable pageable);

    Page<Kandidat> findByGeburtsjahrOrderByGeburtsjahr(Integer geburtsjahr, Pageable pageable);

    Page<Kandidat> findByListeBundeslandLand(Bundesland listeBundeslandLand, Pageable pageable);
}
