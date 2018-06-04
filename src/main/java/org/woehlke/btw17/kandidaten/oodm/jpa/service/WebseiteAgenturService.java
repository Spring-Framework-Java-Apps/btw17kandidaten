package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteAgentur;


public interface WebseiteAgenturService extends Btw17Service<WebseiteAgentur> {

    WebseiteAgentur findByAgentur(String agentur);

}
