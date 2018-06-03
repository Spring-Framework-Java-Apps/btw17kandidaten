package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;

public interface LandesListeService extends Btw17Service<LandesListe> {

    LandesListe findByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei);

    LandesListe fetchOrCreateByBundeslandAndListePartei(Bundesland bundesland,ListePartei listePartei);

    Page<LandesListe> findByBundesland(Bundesland bundesland, Pageable pageable);

    Page<LandesListe> findByListePartei(ListePartei listePartei, Pageable pageable);

    Page<Bundesland> getAllBundesland(Pageable pageable);

    Page<ListePartei> getAllListePartei(Pageable pageable);
}
