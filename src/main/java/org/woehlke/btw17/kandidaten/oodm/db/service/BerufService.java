package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.Beruf;

public interface BerufService extends Btw17Service<Beruf> {

    Beruf findByBeruf(String beruf);

}
