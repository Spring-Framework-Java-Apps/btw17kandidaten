package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.ListePartei;

public interface ListeParteiService extends JpaDomainService<ListePartei> {

    ListePartei findByListePartei(String listePartei, String listeParteiLang);

    ListePartei findByPartei(String partei);

}
