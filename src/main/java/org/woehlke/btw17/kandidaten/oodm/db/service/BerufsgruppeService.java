package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.Berufsgruppe;


public interface BerufsgruppeService extends Btw17Service<Berufsgruppe> {

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

}
