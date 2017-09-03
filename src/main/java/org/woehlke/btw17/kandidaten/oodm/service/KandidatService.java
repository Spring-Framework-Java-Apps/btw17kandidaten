package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.woehlke.btw17.kandidaten.oodm.model.*;

import java.util.List;

public interface KandidatService {

    int FIRST_PAGE_NUMBER = 0;

    int PAGE_SIZE = 20;

    String PAGE_DEFAULT_SORT ="nachname";

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
}
