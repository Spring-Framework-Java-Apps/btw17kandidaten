package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.WebseiteAgentur;


public interface WebseiteAgenturService extends Btw17Service<WebseiteAgentur> {

    WebseiteAgentur findByAgentur(String agentur);

}
