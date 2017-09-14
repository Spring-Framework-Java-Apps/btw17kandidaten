package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.*;

import java.util.List;

public interface KandidatService {

    int FIRST_PAGE_NUMBER = 0;

    int PAGE_SIZE = 20;

    String PAGE_DEFAULT_SORT ="nachname";

    List<Kandidat> getAll();

    Page<Kandidat> getAll(Pageable pageRequest);

    Kandidat create(Kandidat out);

    void deleteAll();

    long count();

    Page<Kandidat> findByBeruf(Beruf beruf, Pageable pageable);

    Page<Kandidat> findByBerufsgruppe(Berufsgruppe berufsgruppe, Pageable pageable);

    Page<Kandidat> findByBundesland(Bundesland bundesland, Pageable pageable);

    Page<Kandidat> findByGeburtsort(Geburtsort geburtsort, Pageable pageable);

    Page<Kandidat> findByPartei(Partei partei, Pageable pageable);

    Page<Kandidat> findByWahlkreis(Wahlkreis wahlkreis, Pageable pageable);

    Page<Kandidat> findByWohnort(Wohnort wohnort, Pageable pageable);

    Page<Kandidat> findByMdB(Pageable pageable);

    Page<Integer> findByGeburtsjahrAll(Pageable pageable);

    Page<Kandidat> findByGeburtsjahr(Integer geburtsjahr, Pageable pageable);

    Page<Kandidat> findByLandesListe(LandesListe landesListe, Pageable pageable);

    Page<Kandidat> findByListePartei(ListePartei listePartei, Pageable pageable);

    List<Integer> getAllGeburtsjahre();

    Kandidat findByKandidatFlatId(long kandidatFlatId);

    Page<Kandidat> getMdbWithoutBundestagProfile(Pageable pageable);

    Page<Kandidat> getMdbWithoutAbgeordnetenwatch(Pageable pageable);

    Page<Kandidat> getMdbWithoutWikipediaArticle(Pageable pageable);

    Page<Kandidat> getMdbWithoutWebseite(Pageable pageable);

    Page<Kandidat> getMdbWithoutFacebook(Pageable pageable);

    Page<Kandidat> getMdbWithoutTwitter(Pageable pageable);

    Page<Kandidat> getKandidatWithoutWebseite(Pageable pageable);

    Page<Kandidat> getKandidatWithoutFacebook(Pageable pageable);

    Page<Kandidat> getKandidatWithoutTwitter(Pageable pageable);

    Page<Kandidat> getKandidatWithoutFotoUrl(Pageable pageable);

    Page<Kandidat> getKandidatWithoutLobbypediaUrl(Pageable pageable);

    Page<Kandidat> getKandidatWithoutSoundcloud(Pageable pageable);

    Page<Kandidat> getKandidatWithoutYoutube(Pageable pageable);

    Page<Kandidat> getKandidatWithoutAbgeordnetenwatch(Pageable pageable);

    Page<Kandidat> getMdbWithoutFotoUrl(Pageable pageable);

    Kandidat update(Kandidat kandidat);

    Page<Kandidat> findByFraktion(Fraktion fraktion, Pageable pageable);

    Page<Kandidat> findByAusschuss(Ausschuss ausschuss, Pageable pageable);

    Page<Kandidat> findByMinisterium(Ministerium ministerium, Pageable pageable);
}
