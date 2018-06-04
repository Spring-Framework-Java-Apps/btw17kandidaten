package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Mdb;

public interface Btw17MdbService extends JpaDomainService<Btw17Mdb> {
    long countBtw17Mdb2Wahlperiode();
}
