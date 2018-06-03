package org.woehlke.btw17.kandidaten.oodm.service;


import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms;


public interface WebseiteCmsService extends Btw17Service<WebseiteCms> {

    WebseiteCms findByCms(String cms);

}
