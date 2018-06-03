package org.woehlke.btw17.kandidaten.oodm.service;

import org.woehlke.btw17.kandidaten.common.Btw17Service;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;


public interface WebseiteAgenturService extends Btw17Service<WebseiteAgentur> {

    WebseiteAgentur findByAgentur(String agentur);

}
