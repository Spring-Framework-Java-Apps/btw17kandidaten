package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Fraktion;


public interface FraktionService extends JpaDomainService<Fraktion> {

    Fraktion findByFraktion(String fraktion);

}
