package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;


public interface BerufsgruppeService extends Btw17Service<Berufsgruppe> {

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

}
