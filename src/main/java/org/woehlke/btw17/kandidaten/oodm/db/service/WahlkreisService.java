package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis;

public interface WahlkreisService extends Btw17Service<Wahlkreis> {

    Wahlkreis findByWahlkreisId(long wahlkreisId);

}
