package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.oodm.model.Beruf;

public interface BerufService extends Btw17Service<Beruf> {

    Beruf findByBeruf(String beruf);

}
