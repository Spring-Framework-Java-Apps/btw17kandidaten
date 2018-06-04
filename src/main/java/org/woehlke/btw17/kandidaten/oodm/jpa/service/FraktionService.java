package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.model.Fraktion;


public interface FraktionService extends Btw17Service<Fraktion> {

    Fraktion findByFraktion(String fraktion);

}
