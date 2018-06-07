package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.LandesListe;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.ListePartei;

public interface LandesListeService extends JpaDomainService<LandesListe> {

    LandesListe findByBundeslandAndListePartei(Bundesland bundesland, ListePartei listePartei);

    LandesListe fetchOrCreateByBundeslandAndListePartei(Bundesland bundesland,ListePartei listePartei);

    Page<LandesListe> findByBundesland(Bundesland bundesland, Pageable pageable);

    Page<LandesListe> findByListePartei(ListePartei listePartei, Pageable pageable);

    Page<Bundesland> getAllBundesland(Pageable pageable);

    Page<ListePartei> getAllListePartei(Pageable pageable);
}
