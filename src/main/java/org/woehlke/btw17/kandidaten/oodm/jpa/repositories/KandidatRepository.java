package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.*;

import java.util.List;

@Repository
public interface KandidatRepository extends JpaDomainRepository<Kandidat> {

    Page<Kandidat> findByBeruf(Beruf beruf, Pageable pageable);

    Page<Kandidat> findByBerufsgruppe(Berufsgruppe berufsgruppe, Pageable pageable);

    Page<Kandidat> findByGeburtsort(Geburtsort geburtsort, Pageable pageable);

    Page<Kandidat> findByPartei(Partei partei, Pageable pageable);

    Page<Kandidat> findByWahlkreis(Wahlkreis wahlkreis, Pageable pageable);

    Page<Kandidat> findByWohnort(Wohnort wohnort, Pageable pageable);

    Page<Kandidat> findByLandesListe(LandesListe landesListe, Pageable pageable);

    @Query(
        name = "Kandidat.findByBundesland",
        countQuery = "Kandidat.countByBundesland"
    )
    Page<Kandidat> findByBundesland(@Param("bundesland") Bundesland bundesland, Pageable pageable);

    @Query(
        name = "Kandidat.findByMinisterium",
        countQuery = "Kandidat.countByMinisterium"
    )
    Page<Kandidat> findByMinisterium(@Param("ministerium") Ministerium ministerium, Pageable pageable);

    @Query(
        name = "Kandidat.findByFraktion",
        countQuery = "Kandidat.findByFraktionCount"
    )
    Page<Kandidat> findByFraktion(@Param("fraktion") Fraktion fraktion, Pageable pageable);

    @Query(
        name = "Kandidat.findByAusschuss",
        countQuery = "Kandidat.findByAusschussCount"
    )
    Page<Kandidat> findByAusschuss(@Param("ausschuss") Ausschuss ausschuss, Pageable pageable);

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

    Page<Kandidat> findByGeburtsjahr(Integer geburtsjahr, Pageable pageable);

    @Query(
        name = "Kandidat.findByListePartei",
        countName = "Kandidat.countByListePartei"
    )
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
        name="Kandidat.getAll",
        countName = "Kandidat.getAllCount"
    )
    Page<Kandidat> getAll(Pageable pageRequest);

    @Override
    @Query(
        name="Kandidat.getAllIds",
        countName = "Kandidat.getAllIdsCount"
    )
    List<Long> getAllIds();

    @Query(name="Kandidat.countKandidatMinisterium",nativeQuery=true)
    long countKandidatMinisterium();

    @Query(name="Kandidat.countKandidatAusschuss",nativeQuery=true)
    long countKandidatAusschuss();

    @Query(name="Kandidat.countKandidatAgentur",nativeQuery=true)
    long countKandidatAgentur();

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

    @Query(
            name = "Kandidat.findByWebseiteAgentur",
            countName = "Kandidat.countByWebseiteAgentur"
    )
    Page<Kandidat> findByWebseiteAgentur(@Param("webseiteAgentur") WebseiteAgentur webseiteAgentur, Pageable pageable);

    @Query(
            name = "Kandidat.findByWebseiteCms",
            countName = "Kandidat.contByWebseiteCms"
    )
    Page<Kandidat> findByWebseiteCms(@Param("webseiteCms") WebseiteCms webseiteCms, Pageable pageable);

    @Query(
            name = "Kandidat.findByWahlperiode",
            countName = "Kandidat.countByWahlperiode"
    )
    Page<Kandidat> findByWahlperiode(@Param("wahlperiode") Wahlperiode wahlperiode, Pageable pageable);

    @Query(name="Kandidat.getMaxId")
    Long getMaxId();

    @Query(name="Kandidat.findByBtw17Mdb")
    Kandidat findByBtw17Mdb(
            @Param("vorname") String vorname,
            @Param("nachname") String nachname,
            @Param("geburtsjahr") Integer geburtsjahr,
            @Param("geburtsort") Geburtsort geburtsort,
            @Param("geschlecht") String geschlecht
    );

}
