package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ministerium;


public interface MinisteriumService extends Btw17Service<Ministerium> {

    Ministerium findByMinisterium(String ministerium);

}
