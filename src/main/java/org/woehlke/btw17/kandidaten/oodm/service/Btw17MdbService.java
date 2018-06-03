package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.Btw17Mdb;

public interface Btw17MdbService extends Btw17Service<Btw17Mdb> {
    long countBtw17Mdb2Wahlperiode();
}
