package org.woehlke.btw17.kandidaten.oodm.service;


import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;

public interface ListeParteiService extends Btw17Service<ListePartei> {

    ListePartei findByListePartei(String listePartei, String listeParteiLang);

    ListePartei findByPartei(String partei);

}
