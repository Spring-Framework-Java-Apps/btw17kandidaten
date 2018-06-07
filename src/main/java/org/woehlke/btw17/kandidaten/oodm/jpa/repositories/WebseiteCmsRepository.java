package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteCms;

import java.util.List;

@Repository
public interface WebseiteCmsRepository extends JpaDomainRepository<WebseiteCms> {

    WebseiteCms findByCms(String cms);

    @Query(name="Cms.getAllIds")
    List<Long> getAllIds();

    @Query(name="Cms.getMaxId")
    Long getMaxId();
}
