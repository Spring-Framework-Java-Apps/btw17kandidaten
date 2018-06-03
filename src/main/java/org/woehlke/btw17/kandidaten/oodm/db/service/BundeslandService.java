package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland;



public interface BundeslandService extends Btw17Service<Bundesland> {

    Bundesland findByBundesland(BundeslandEnum bundesland);

    long countBundeslandAgentur();

}
