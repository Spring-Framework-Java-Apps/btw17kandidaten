package org.woehlke.btw17.kandidaten.oodm.service;


import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;


public interface AusschussService extends Btw17Service<Ausschuss> {

    Ausschuss findByAusschuss(String ausschuss);

}
