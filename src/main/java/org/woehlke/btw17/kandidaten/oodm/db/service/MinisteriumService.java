package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.Ministerium;


public interface MinisteriumService extends Btw17Service<Ministerium> {

    Ministerium findByMinisterium(String ministerium);

}
