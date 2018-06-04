package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteCms;


public interface WebseiteCmsService extends JpaDomainService<WebseiteCms> {

    WebseiteCms findByCms(String cms);

}
