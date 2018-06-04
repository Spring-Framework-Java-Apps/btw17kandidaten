package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteAgentur;


public interface WebseiteAgenturService extends JpaDomainService<WebseiteAgentur> {

    WebseiteAgentur findByAgentur(String agentur);

}
