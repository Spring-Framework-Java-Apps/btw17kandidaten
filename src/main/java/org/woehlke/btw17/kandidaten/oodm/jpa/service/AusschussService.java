package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ausschuss;

public interface AusschussService extends Btw17Service<Ausschuss> {

    Ausschuss findByAusschuss(String ausschuss);

}
