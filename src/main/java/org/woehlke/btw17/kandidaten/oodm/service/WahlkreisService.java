package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;

public interface WahlkreisService extends Btw17Service<Wahlkreis> {

    Wahlkreis findByWahlkreisId(long wahlkreisId);

}
