package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.frontend.model.ReportOverview;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.repositories.KandidatRepository;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatReportService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class KandidatReportServiceImpl implements KandidatReportService {


    private final KandidatRepository kandidatRepository;

    @Autowired
    public KandidatReportServiceImpl(KandidatRepository kandidatRepository) {
        this.kandidatRepository = kandidatRepository;
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
    public ReportOverview getOverview() {
        ReportOverview reportOverview = new ReportOverview();

        Long countMdb = kandidatRepository.countMdb();

        Long countKandidat = kandidatRepository.countKandidat();

        Long countMdbWithoutAbgeordnetenwatch = kandidatRepository.countMdbWithoutAbgeordnetenwatch();

        Long countMdbWithoutBundestagProfile = kandidatRepository.countMdbWithoutBundestagProfile();

        Long countMdbWithoutFotoUrl = kandidatRepository.countMdbWithoutFotoUrl();

        Long countMdbWithoutFacebook = kandidatRepository.countMdbWithoutFacebook();

        Long countMdbWithoutTwitter = kandidatRepository.countMdbWithoutTwitter();

        Long countMdbWithoutWebseite = kandidatRepository.countMdbWithoutWebseite();

        Long countMdbWithoutWikipediaArticle = kandidatRepository.countMdbWithoutWikipediaArticle();

        Long countKandidatWithoutAbgeordnetenwatch = kandidatRepository.countKandidatWithoutAbgeordnetenwatch();

        Long countKandidatWithoutFacebook = kandidatRepository.countKandidatWithoutFacebook();

        Long countKandidatWithoutWebseite = kandidatRepository.countKandidatWithoutWebseite();

        Long countKandidatWithoutFotoUrl = kandidatRepository.countKandidatWithoutFotoUrl();

        Long countKandidatWithoutLobbypediaUrl = kandidatRepository.countKandidatWithoutLobbypediaUrl();

        Long countKandidatWithoutSoundcloud = kandidatRepository.countKandidatWithoutSoundcloud();

        Long countKandidatWithoutYoutube = kandidatRepository.countKandidatWithoutYoutube();

        Long countKandidatWithoutTwitter = kandidatRepository.countKandidatWithoutTwitter();

        reportOverview.setCountMdb(countMdb);
        reportOverview.setCountKandidat(countKandidat);
        reportOverview.setCountMdbWithoutAbgeordnetenwatch(countMdbWithoutAbgeordnetenwatch);
        reportOverview.setCountMdbWithoutBundestagProfile(countMdbWithoutBundestagProfile);
        reportOverview.setCountMdbWithoutFotoUrl(countMdbWithoutFotoUrl);
        reportOverview.setCountMdbWithoutFacebook(countMdbWithoutFacebook);
        reportOverview.setCountMdbWithoutTwitter(countMdbWithoutTwitter);
        reportOverview.setCountMdbWithoutWebseite(countMdbWithoutWebseite);
        reportOverview.setCountMdbWithoutWikipediaArticle(countMdbWithoutWikipediaArticle);
        reportOverview.setCountKandidatWithoutAbgeordnetenwatch(countKandidatWithoutAbgeordnetenwatch);
        reportOverview.setCountKandidatWithoutFacebook(countKandidatWithoutFacebook);
        reportOverview.setCountKandidatWithoutWebseite(countKandidatWithoutWebseite);
        reportOverview.setCountKandidatWithoutFotoUrl(countKandidatWithoutFotoUrl);
        reportOverview.setCountKandidatWithoutLobbypediaUrl(countKandidatWithoutLobbypediaUrl);
        reportOverview.setCountKandidatWithoutSoundcloud(countKandidatWithoutSoundcloud);
        reportOverview.setCountKandidatWithoutYoutube(countKandidatWithoutYoutube);
        reportOverview.setCountKandidatWithoutTwitter(countKandidatWithoutTwitter);

        return reportOverview;
    }
}
