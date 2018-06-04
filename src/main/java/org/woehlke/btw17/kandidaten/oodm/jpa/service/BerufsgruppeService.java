package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.model.Berufsgruppe;


public interface BerufsgruppeService extends Btw17Service<Berufsgruppe> {

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

}
