package org.woehlke.btw17.kandidaten.oodm.jpa.service;


import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteCms;


public interface WebseiteCmsService extends Btw17Service<WebseiteCms> {

    WebseiteCms findByCms(String cms);

}
