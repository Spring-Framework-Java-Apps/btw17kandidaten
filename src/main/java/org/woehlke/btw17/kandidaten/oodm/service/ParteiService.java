package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.Partei;


public interface ParteiService extends Btw17Service<Partei> {

    Partei findByPartei(String partei, String parteiLang);

}
