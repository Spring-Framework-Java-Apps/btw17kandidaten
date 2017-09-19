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

    @Query(
        name = "Kandidat.findByMdB",
        countQuery = "Kandidat.countMdB"
    )
    Page<Kandidat> findByMdB(Pageable pageable);

    @Query(
        name = "Kandidat.findByNotMdB",
        countQuery = "Kandidat.countKandidat"
    )
    Page<Kandidat> findByNotMdB(Pageable pageable);

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

    @Query(
        name="Kandidat.getAll",
        countName = "Kandidat.getAllCount"
    )
    List<Kandidat> getAll();

    @Query(
        name = "Kandidat.findByFraktion",
        countName = "Kandidat.findByFraktionCount"
    )
    Page<Kandidat> findByFraktion(@Param("fraktion") Fraktion fraktion, Pageable pageable);

    @Query(
        name = "Kandidat.findByAusschuss",
        countName = "Kandidat.findByAusschussCount"
    )
    Page<Kandidat> findByAusschuss(@Param("ausschuss") Ausschuss ausschuss, Pageable pageable);

    @Query(
        name = "Kandidat.findByMinisterium",
        countName = "Kandidat.findByMinisteriumCount"
    )
    Page<Kandidat> findByMinisterium(@Param("ministerium") Ministerium ministerium, Pageable pageable);


    @Query(
        name = "Kandidat.getMdbWithoutBundestagProfile",
        countName = "Kandidat.countMdbWithoutBundestagProfile"
    )
    Page<Kandidat> getMdbWithoutBundestagProfile(Pageable pageable);

    @Query(
        name = "Kandidat.getMdbWithoutAbgeordnetenwatch",
        countName = "Kandidat.countMdbWithoutAbgeordnetenwatch"
    )
    Page<Kandidat> getMdbWithoutAbgeordnetenwatch(Pageable pageable);

    @Query(
        name = "Kandidat.getMdbWithoutWikipediaArticle",
        countName = "Kandidat.countMdbWithoutWikipediaArticle"
    )
    Page<Kandidat> getMdbWithoutWikipediaArticle(Pageable pageable);

    @Query(
        name = "Kandidat.getMdbWithoutWebseite",
        countName = "Kandidat.countMdbWithoutWebseite"
    )
    Page<Kandidat> getMdbWithoutWebseite(Pageable pageable);

    @Query(
        name = "Kandidat.getMdbWithoutFacebook",
        countName = "Kandidat.countMdbWithoutFacebook"
    )
    Page<Kandidat> getMdbWithoutFacebook(Pageable pageable);

    @Query(
        name = "Kandidat.getMdbWithoutTwitter",
        countName = "Kandidat.countMdbWithoutTwitter"
    )
    Page<Kandidat> getMdbWithoutTwitter(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutWebseite",
        countName = "Kandidat.countKandidatWithoutWebseite"
    )
    Page<Kandidat> getKandidatWithoutWebseite(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutFacebook",
        countName = "Kandidat.countKandidatWithoutFacebook"
    )
    Page<Kandidat> getKandidatWithoutFacebook(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutTwitter",
        countName = "Kandidat.countKandidatWithoutTwitter"
    )
    Page<Kandidat> getKandidatWithoutTwitter(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutFotoUrl",
        countName = "Kandidat.countKandidatWithoutFotoUrl"
    )
    Page<Kandidat> getKandidatWithoutFotoUrl(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutLobbypediaUrl",
        countName = "Kandidat.countKandidatWithoutLobbypediaUrl"
    )
    Page<Kandidat> getKandidatWithoutLobbypediaUrl(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutSoundcloud",
        countName = "Kandidat.countKandidatWithoutSoundcloud"
    )
    Page<Kandidat> getKandidatWithoutSoundcloud(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutYoutube",
        countName = "Kandidat.countKandidatWithoutYoutube"
    )
    Page<Kandidat> getKandidatWithoutYoutube(Pageable pageable);

    @Query(
        name = "Kandidat.getKandidatWithoutAbgeordnetenwatch",
        countName = "Kandidat.countKandidatWithoutAbgeordnetenwatch"
    )
    Page<Kandidat> getKandidatWithoutAbgeordnetenwatch(Pageable pageable);

    @Query(
        name = "Kandidat.getMdbWithoutFotoUrl",
        countName = "Kandidat.countMdbWithoutFotoUrl"
    )
    Page<Kandidat> getMdbWithoutFotoUrl(Pageable pageable);



    @Query(name="Kandidat.countMdbWithoutAbgeordnetenwatch")
    Long countMdbWithoutAbgeordnetenwatch();

    @Query(name="Kandidat.countMdbWithoutBundestagProfile")
    Long countMdbWithoutBundestagProfile();

    @Query(name="Kandidat.countMdbWithoutFotoUrl")
    Long countMdbWithoutFotoUrl();

    @Query(name="Kandidat.countMdbWithoutFacebook")
    Long countMdbWithoutFacebook();

    @Query(name="Kandidat.countMdbWithoutTwitter")
    Long countMdbWithoutTwitter();

    @Query(name="Kandidat.countMdbWithoutWebseite")
    Long countMdbWithoutWebseite();

    @Query(name="Kandidat.countMdbWithoutWikipediaArticle")
    Long countMdbWithoutWikipediaArticle();

    @Query(name="Kandidat.countKandidatWithoutAbgeordnetenwatch")
    Long countKandidatWithoutAbgeordnetenwatch();

    @Query(name="Kandidat.countKandidatWithoutFacebook")
    Long countKandidatWithoutFacebook();

    @Query(name="Kandidat.countKandidatWithoutWebseite")
    Long countKandidatWithoutWebseite();

    @Query(name="Kandidat.countKandidatWithoutFotoUrl")
    Long countKandidatWithoutFotoUrl();

    @Query(name="Kandidat.countKandidatWithoutLobbypediaUrl")
    Long countKandidatWithoutLobbypediaUrl();

    @Query(name="Kandidat.countKandidatWithoutSoundcloud")
    Long countKandidatWithoutSoundcloud();

    @Query(name="Kandidat.countKandidatWithoutYoutube")
    Long countKandidatWithoutYoutube();

    @Query(name="Kandidat.countKandidatWithoutTwitter")
    Long countKandidatWithoutTwitter();

    @Query(name="Kandidat.countMdB")
    Long countMdb();

    @Query(name="Kandidat.countKandidat")
    Long countKandidat();
}
