package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Berufsgruppe;


public interface BerufsgruppeService extends JpaDomainService<Berufsgruppe> {

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

}
