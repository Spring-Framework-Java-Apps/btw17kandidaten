package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.model.Geburtsort;

public interface GeburtsortService extends Btw17Service<Geburtsort> {

    Geburtsort findByGeburtsort(String geburtsort);

}
