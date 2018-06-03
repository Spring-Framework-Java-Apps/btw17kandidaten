package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.Geburtsort;

public interface GeburtsortService extends Btw17Service<Geburtsort> {

    Geburtsort findByGeburtsort(String geburtsort);

}
