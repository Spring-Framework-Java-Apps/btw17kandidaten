package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17Wahlkreis;


public interface Btw17WahlkreisService extends Btw17Service<Btw17Wahlkreis> {

    Btw17Wahlkreis findByWahlkreisNummer(long wahlkreisNummer);

    BundeslandEnum findByBundeslandNummer(long bundeslandNummer);
}
