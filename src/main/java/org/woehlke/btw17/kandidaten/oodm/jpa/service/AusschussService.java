package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ausschuss;

public interface AusschussService extends JpaDomainService<Ausschuss> {

    Ausschuss findByAusschuss(String ausschuss);

}
