package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.Partei;


public interface ParteiService extends Btw17Service<Partei> {

    Partei findByPartei(String partei, String parteiLang);

}
