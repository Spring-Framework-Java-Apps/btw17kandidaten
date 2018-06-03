package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.Fraktion;


public interface FraktionService extends Btw17Service<Fraktion> {

    Fraktion findByFraktion(String fraktion);

}
