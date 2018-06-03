package org.woehlke.btw17.kandidaten.oodm.service;


import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;

public interface GeburtsortService extends Btw17Service<Geburtsort> {

    Geburtsort findByGeburtsort(String geburtsort);

}
