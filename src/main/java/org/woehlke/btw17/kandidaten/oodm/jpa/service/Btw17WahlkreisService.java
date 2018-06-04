package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlkreis;


public interface Btw17WahlkreisService extends JpaDomainService<Btw17Wahlkreis> {

    Btw17Wahlkreis findByWahlkreisNummer(long wahlkreisNummer);

    BundeslandEnum findByBundeslandNummer(long bundeslandNummer);
}
