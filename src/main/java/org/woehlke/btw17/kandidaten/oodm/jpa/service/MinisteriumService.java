package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ministerium;


public interface MinisteriumService extends JpaDomainService<Ministerium> {

    Ministerium findByMinisterium(String ministerium);

}
