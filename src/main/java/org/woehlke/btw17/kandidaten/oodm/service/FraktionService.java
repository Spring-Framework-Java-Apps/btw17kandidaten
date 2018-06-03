package org.woehlke.btw17.kandidaten.oodm.service;


import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.Fraktion;


public interface FraktionService extends Btw17Service<Fraktion> {

    Fraktion findByFraktion(String fraktion);

}
