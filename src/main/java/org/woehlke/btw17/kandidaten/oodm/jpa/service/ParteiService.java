package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Partei;


public interface ParteiService extends JpaDomainService<Partei> {

    Partei findByPartei(String partei, String parteiLang);

}
