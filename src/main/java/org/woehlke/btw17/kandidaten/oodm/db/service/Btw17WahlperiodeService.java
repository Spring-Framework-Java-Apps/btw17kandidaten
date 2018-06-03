package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlperiode;

public interface Btw17WahlperiodeService extends Btw17Service<Btw17Wahlperiode> {

    Btw17Wahlperiode findbyWahlperiodeNrAndWkrnummer(String wp, String wkrnummer);
}
