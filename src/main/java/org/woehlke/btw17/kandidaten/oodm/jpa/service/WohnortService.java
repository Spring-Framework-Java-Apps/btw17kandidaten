package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wohnort;

import java.util.List;

public interface WohnortService extends JpaDomainService<Wohnort> {

    Wohnort findByWohnort(String wohnort);

    List<Wohnort> getAllOrderById();

}
