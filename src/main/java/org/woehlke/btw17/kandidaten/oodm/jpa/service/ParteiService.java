package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.model.Partei;


public interface ParteiService extends Btw17Service<Partei> {

    Partei findByPartei(String partei, String parteiLang);

}
