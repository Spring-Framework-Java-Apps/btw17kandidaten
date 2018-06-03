package org.woehlke.btw17.kandidaten.oodm.service;


import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;


public interface MinisteriumService extends Btw17Service<Ministerium> {

    Ministerium findByMinisterium(String ministerium);

}
