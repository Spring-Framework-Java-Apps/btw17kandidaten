package org.woehlke.btw17.kandidaten.oodm.db.service;


import org.woehlke.btw17.kandidaten.oodm.db.model.WebseiteCms;


public interface WebseiteCmsService extends Btw17Service<WebseiteCms> {

    WebseiteCms findByCms(String cms);

}
