package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.Wohnort;

import java.util.List;

public interface WohnortService extends Btw17Service<Wohnort> {

    Wohnort findByWohnort(String wohnort);

    List<Wohnort> getAllOrderById();

}
