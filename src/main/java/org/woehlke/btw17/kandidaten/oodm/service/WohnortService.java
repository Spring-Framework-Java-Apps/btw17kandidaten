package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;

import java.util.List;

public interface WohnortService extends Btw17Service<Wohnort> {

    Wohnort findByWohnort(String wohnort);

    List<Wohnort> getAllOrderById();

}
