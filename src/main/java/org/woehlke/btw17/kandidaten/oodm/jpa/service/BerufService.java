package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.model.Beruf;

public interface BerufService extends Btw17Service<Beruf> {

    Beruf findByBeruf(String beruf);

}
