package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;

public interface WahlkreisService extends Btw17Service<Wahlkreis> {

    Wahlkreis findByWahlkreisId(long wahlkreisId);

}
