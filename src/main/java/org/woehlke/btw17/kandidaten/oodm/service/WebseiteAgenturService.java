package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;


public interface WebseiteAgenturService {

    Iterable<WebseiteAgentur> getAll();

    Page<WebseiteAgentur> getAll(Pageable pageable);

    WebseiteAgentur findByAgentur(String agentur);

    long count();

    void deleteAll();

    WebseiteAgentur update(WebseiteAgentur webseiteAgentur);

    WebseiteAgentur create(WebseiteAgentur webseiteAgentur);

    void delete(WebseiteAgentur webseiteAgentur);

}
