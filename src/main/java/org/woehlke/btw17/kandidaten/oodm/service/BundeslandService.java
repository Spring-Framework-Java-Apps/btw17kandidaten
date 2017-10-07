package org.woehlke.btw17.kandidaten.oodm.service;


import org.woehlke.btw17.kandidaten.configuration.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;



public interface BundeslandService extends Btw17Service<Bundesland> {

    Bundesland findByBundesland(BundeslandEnum bundesland);

    long countBundeslandAgentur();

}
