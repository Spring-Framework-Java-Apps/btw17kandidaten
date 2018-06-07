package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;

public interface WahlkreisService extends JpaDomainService<Wahlkreis> {

    Wahlkreis findByWahlkreisId(long wahlkreisId);

}
