package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Beruf;

public interface BerufService extends JpaDomainService<Beruf> {

    Beruf findByBeruf(String beruf);

}
