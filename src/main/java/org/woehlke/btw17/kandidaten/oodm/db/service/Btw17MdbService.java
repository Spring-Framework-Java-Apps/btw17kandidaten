package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Mdb;

public interface Btw17MdbService extends Btw17Service<Btw17Mdb> {
    long countBtw17Mdb2Wahlperiode();
}
