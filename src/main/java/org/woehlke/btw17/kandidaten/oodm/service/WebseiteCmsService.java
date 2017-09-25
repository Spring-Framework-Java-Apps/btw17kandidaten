package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms;

public interface WebseiteCmsService {

    Page<WebseiteCms> getAll(Pageable pageable);

    WebseiteCms findByCms(String cms);

    long count();

    void deleteAll();

    WebseiteCms update(WebseiteCms webseiteCms);

    WebseiteCms create(WebseiteCms webseiteCms);
}
