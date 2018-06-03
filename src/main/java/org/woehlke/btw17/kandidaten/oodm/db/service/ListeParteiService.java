package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei;

public interface ListeParteiService extends Btw17Service<ListePartei> {

    ListePartei findByListePartei(String listePartei, String listeParteiLang);

    ListePartei findByPartei(String partei);

}
