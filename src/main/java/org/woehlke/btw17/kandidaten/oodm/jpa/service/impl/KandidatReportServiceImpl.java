package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.frontend.model.ReportOverview;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.KandidatRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatReportService;

@Service("jpa.KandidatReportService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class KandidatReportServiceImpl extends JpaDomainServiceImpl<Kandidat> implements KandidatReportService {

    @Autowired
    public KandidatReportServiceImpl(KandidatRepository kandidatRepository) {
        super(kandidatRepository);
    }

    @Override
    protected KandidatRepository getRepository(){
        return (KandidatRepository) super.getRepository();
    }

    @Override
    public Page<Kandidat> getMdbWithoutBundestagProfile(Pageable pageable) {
        return getRepository().getMdbWithoutBundestagProfile(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutAbgeordnetenwatch(Pageable pageable) {
        return getRepository().getMdbWithoutAbgeordnetenwatch(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutWikipediaArticle(Pageable pageable) {
        return getRepository().getMdbWithoutWikipediaArticle(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutWebseite(Pageable pageable) {
        return getRepository().getMdbWithoutWebseite(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutFacebook(Pageable pageable) {
        return getRepository().getMdbWithoutFacebook(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutTwitter(Pageable pageable) {
        return getRepository().getMdbWithoutTwitter(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutWebseite(Pageable pageable) {
        return getRepository().getKandidatWithoutWebseite(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutFacebook(Pageable pageable) {
        return getRepository().getKandidatWithoutFacebook(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutTwitter(Pageable pageable) {
        return getRepository().getKandidatWithoutTwitter(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutFotoUrl(Pageable pageable) {
        return getRepository().getKandidatWithoutFotoUrl(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutLobbypediaUrl(Pageable pageable) {
        return getRepository().getKandidatWithoutLobbypediaUrl(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutSoundcloud(Pageable pageable) {
        return getRepository().getKandidatWithoutSoundcloud(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutYoutube(Pageable pageable) {
        return getRepository().getKandidatWithoutYoutube(pageable);
    }

    @Override
    public Page<Kandidat> getKandidatWithoutAbgeordnetenwatch(Pageable pageable) {
        return getRepository().getKandidatWithoutAbgeordnetenwatch(pageable);
    }

    @Override
    public Page<Kandidat> getMdbWithoutFotoUrl(Pageable pageable) {
        return getRepository().getMdbWithoutFotoUrl(pageable);
    }

    @Override
    public ReportOverview getOverview() {
        ReportOverview reportOverview = new ReportOverview();

        Long countMdb = getRepository().countMdb();

        Long countKandidat = getRepository().countKandidat();

        Long countMdbWithoutAbgeordnetenwatch = getRepository().countMdbWithoutAbgeordnetenwatch();

        Long countMdbWithoutBundestagProfile = getRepository().countMdbWithoutBundestagProfile();

        Long countMdbWithoutFotoUrl = getRepository().countMdbWithoutFotoUrl();

        Long countMdbWithoutFacebook = getRepository().countMdbWithoutFacebook();

        Long countMdbWithoutTwitter = getRepository().countMdbWithoutTwitter();

        Long countMdbWithoutWebseite = getRepository().countMdbWithoutWebseite();

        Long countMdbWithoutWikipediaArticle = getRepository().countMdbWithoutWikipediaArticle();

        Long countKandidatWithoutAbgeordnetenwatch = getRepository().countKandidatWithoutAbgeordnetenwatch();

        Long countKandidatWithoutFacebook = getRepository().countKandidatWithoutFacebook();

        Long countKandidatWithoutWebseite = getRepository().countKandidatWithoutWebseite();

        Long countKandidatWithoutFotoUrl = getRepository().countKandidatWithoutFotoUrl();

        Long countKandidatWithoutLobbypediaUrl = getRepository().countKandidatWithoutLobbypediaUrl();

        Long countKandidatWithoutSoundcloud = getRepository().countKandidatWithoutSoundcloud();

        Long countKandidatWithoutYoutube = getRepository().countKandidatWithoutYoutube();

        Long countKandidatWithoutTwitter = getRepository().countKandidatWithoutTwitter();

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
