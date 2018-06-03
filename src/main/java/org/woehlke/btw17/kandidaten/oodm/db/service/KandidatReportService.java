package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.frontend.model.ReportOverview;
import org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat;

public interface KandidatReportService {

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

    ReportOverview getOverview();

}
