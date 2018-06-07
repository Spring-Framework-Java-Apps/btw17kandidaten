package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;



public interface BundeslandService extends JpaDomainService<Bundesland> {

    Bundesland findByBundesland(BundeslandEnum bundesland);

    long countBundeslandAgentur();

}
