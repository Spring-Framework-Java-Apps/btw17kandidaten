package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlperiode;

public interface Btw17WahlperiodeService extends JpaDomainService<Btw17Wahlperiode> {

    Btw17Wahlperiode findbyWahlperiodeNrAndWkrnummer(String wp, String wkrnummer);
}
