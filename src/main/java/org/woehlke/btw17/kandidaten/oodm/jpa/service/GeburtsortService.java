package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.service.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Geburtsort;

public interface GeburtsortService extends JpaDomainService<Geburtsort> {

    Geburtsort findByGeburtsort(String geburtsort);

}
