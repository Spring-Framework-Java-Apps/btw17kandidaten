package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.repositories.KandidatRepository;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class KandidatServiceImpl implements KandidatService {

    private final KandidatRepository kandidatRepository;

    @Autowired
    public KandidatServiceImpl(KandidatRepository kandidatRepository) {
        this.kandidatRepository = kandidatRepository;
    }

    @Override
    public List<Kandidat> getAll() {
        return kandidatRepository.getAll();
    }

    @Override
    public Page<Kandidat> getAll(Pageable pageRequest) {
        return kandidatRepository.findAll(pageRequest);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Kandidat create(Kandidat out) {
        return kandidatRepository.save(out);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        kandidatRepository.deleteAll();
    }

    @Override
    public long count() {
        return kandidatRepository.count();
    }

    @Override
    public Page<Kandidat> findByBeruf(Beruf beruf, Pageable pageable) {
        return kandidatRepository.findByBeruf(beruf, pageable);
    }

    @Override
    public Page<Kandidat> findByBerufsgruppe(Berufsgruppe berufsgruppe, Pageable pageable) {
        return kandidatRepository.findByBerufsgruppe(berufsgruppe,pageable);
    }

    @Override
    public Page<Kandidat> findByBundesland(Bundesland bundesland, Pageable pageable) {
        return kandidatRepository.findByBundesland(bundesland, pageable);
    }

    @Override
    public Page<Kandidat> findByGeburtsort(Geburtsort geburtsort, Pageable pageable) {
        return kandidatRepository.findByGeburtsort(geburtsort,pageable);
    }

    @Override
    public Page<Kandidat> findByPartei(Partei partei, Pageable pageable) {
        return kandidatRepository.findByPartei(partei, pageable);
    }

    @Override
    public Page<Kandidat> findByWahlkreis(Wahlkreis wahlkreis, Pageable pageable) {
        return kandidatRepository.findByWahlkreis(wahlkreis, pageable);
    }

    @Override
    public Page<Kandidat> findByWohnort(Wohnort wohnort, Pageable pageable) {
        return kandidatRepository.findByWohnort(wohnort, pageable);
    }

    @Override
    public Page<Kandidat> findByMdB(Pageable pageable) {
        return kandidatRepository.findByMdB(pageable);
    }

    @Override
    public Page<Integer> findByGeburtsjahrAll(Pageable pageable) {
        return kandidatRepository.findByGeburtsjahrAll(pageable);
    }

    @Override
    public Page<Kandidat> findByGeburtsjahr(Integer geburtsjahr, Pageable pageable) {
        return kandidatRepository.findByGeburtsjahrOrderByGeburtsjahr(geburtsjahr,pageable);
    }

    @Override
    public Page<Kandidat> findByLandesListe(LandesListe landesListe, Pageable pageable) {
        return kandidatRepository.findByLandesListe(landesListe,pageable);
    }

    @Override
    public Page<Kandidat> findByListePartei(ListePartei listePartei, Pageable pageable) {
        return kandidatRepository.findByListePartei(listePartei,pageable);
    }

    @Override
    public List<Integer> getAllGeburtsjahre() {
        return kandidatRepository.getAllGeburtsjahre();
    }

    @Override
    public Kandidat findByKandidatFlatId(long kandidatFlatId) {
        return kandidatRepository.findByKandidatFlatId(kandidatFlatId);
    }

    @Override
    public Page<Kandidat> getMdbWithoutBundestagProfile(Pageable pageable) {
        return kandidatRepository.getMdbWithoutBundestagProfile(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutAbgeordnetenwatch(Pageable pageable) {
        return kandidatRepository.getMdbWithoutAbgeordnetenwatch(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutWikipediaArticle(Pageable pageable) {
        return kandidatRepository.getMdbWithoutWikipediaArticle(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutWebseite(Pageable pageable) {
        return kandidatRepository.getMdbWithoutWebseite(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutFacebook(Pageable pageable) {
        return kandidatRepository.getMdbWithoutFacebook(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutTwitter(Pageable pageable) {
        return kandidatRepository.getMdbWithoutTwitter(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutWebseite(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutWebseite(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutFacebook(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutFacebook(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutTwitter(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutTwitter(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutFotoUrl(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutFotoUrl(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutLobbypediaUrl(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutLobbypediaUrl(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutSoundcloud(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutSoundcloud(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutYoutube(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutYoutube(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutAbgeordnetenwatch(Pageable pageable) {
        return kandidatRepository.getKandidatWithoutAbgeordnetenwatch(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutFotoUrl(Pageable pageable) {
        return kandidatRepository.getMdbWithoutFotoUrl(pageable);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Kandidat update(Kandidat kandidat) {
        return kandidatRepository.save(kandidat);
    }

    @Override
    public Page<Kandidat> findByFraktion(Fraktion fraktion, Pageable pageable) {
        return kandidatRepository.findByFraktion(fraktion,pageable);
    }

    @Override
    public Page<Kandidat> findByAusschuss(Ausschuss ausschuss, Pageable pageable) {
        return kandidatRepository.findByAusschuss(ausschuss,pageable);
    }

    @Override
    public Page<Kandidat> findByMinisterium(Ministerium ministerium, Pageable pageable) {
        return kandidatRepository.findByMinisterium(ministerium,pageable);
    }

}
