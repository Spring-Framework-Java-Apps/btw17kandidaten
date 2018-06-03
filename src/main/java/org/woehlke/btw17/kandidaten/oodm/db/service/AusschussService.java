package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.Ausschuss;

public interface AusschussService extends Btw17Service<Ausschuss> {

    Ausschuss findByAusschuss(String ausschuss);

}
