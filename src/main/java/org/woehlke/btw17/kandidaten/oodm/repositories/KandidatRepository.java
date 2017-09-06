package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.KandidatRepositoryCustom;

import java.util.List;

@Repository
public interface KandidatRepository extends PagingAndSortingRepository<Kandidat,Long>,KandidatRepositoryCustom {

    Page<Kandidat> findByBeruf(Beruf beruf, Pageable pageable);

    Page<Kandidat> findByBerufsgruppe(Berufsgruppe berufsgruppe, Pageable pageable);

    Page<Kandidat> findByBundesland(Bundesland bundesland, Pageable pageable);

    Page<Kandidat> findByGeburtsort(Geburtsort geburtsort, Pageable pageable);

    Page<Kandidat> findByPartei(Partei partei, Pageable pageable);

    Page<Kandidat> findByWahlkreis(Wahlkreis wahlkreis, Pageable pageable);

    Page<Kandidat> findByWohnort(Wohnort wohnort, Pageable pageable);

    @Query(name="Kandidat.findByMdB")
    Page<Kandidat> findByMdB(Pageable pageable);

    @Query(name="Kandidat.findByGeburtsjahrAll")
    Page<Integer> findByGeburtsjahrAll(Pageable pageable);

    Page<Kandidat> findByGeburtsjahrOrderByGeburtsjahr(Integer geburtsjahr, Pageable pageable);

    Page<Kandidat> findByLandesListe(LandesListe landesListe, Pageable pageable);

    @Query(name="Kandidat.findByListePartei")
    Page<Kandidat> findByListePartei(@Param("listePartei") ListePartei listePartei, Pageable pageable);

    @Query(name="Kandidat.findByGeburtsjahrAll")
    List<Integer> getAllGeburtsjahre();

    @Query(name="Kandidat.findByKandidatFlatId")
    Kandidat findByKandidatFlatId(@Param("kandidatFlatId") long kandidatFlatId);

    @Query(name="Kandidat.getAll")
    List<Kandidat> getAll();

    @Query(name="Kandidat.getMdbWithoutBundestagProfile")
    Page<Kandidat> getMdbWithoutBundestagProfile(Pageable pageable);

    @Query(name="Kandidat.getMdbWithoutAbgeordnetenwatch")
    Page<Kandidat> getMdbWithoutAbgeordnetenwatch(Pageable pageable);

    @Query(name="Kandidat.getMdbWithoutWikipediaArticle")
    Page<Kandidat> getMdbWithoutWikipediaArticle(Pageable pageable);

    @Query(name="Kandidat.getMdbWithoutWebseite")
    Page<Kandidat> getMdbWithoutWebseite(Pageable pageable);

    @Query(name="Kandidat.getMdbWithoutFacebook")
    Page<Kandidat> getMdbWithoutFacebook(Pageable pageable);

    @Query(name="Kandidat.getMdbWithoutTwitter")
    Page<Kandidat> getMdbWithoutTwitter(Pageable pageable);

    @Query(name="Kandidat.getKandidatWithoutWebseite")
    Page<Kandidat> getKandidatWithoutWebseite(Pageable pageable);

    @Query(name="Kandidat.getKandidatWithoutFacebook")
    Page<Kandidat> getKandidatWithoutFacebook(Pageable pageable);

    @Query(name="Kandidat.getKandidatWithoutTwitter")
    Page<Kandidat> getKandidatWithoutTwitter(Pageable pageable);

}
