package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteCms;

import java.util.List;

@Repository("jpa.WebseiteCmsRepository")
public interface WebseiteCmsRepository extends JpaDomainRepository<WebseiteCms> {

    WebseiteCms findByCms(String cms);

    @Override
    @Query(
        name="WebseiteCms.getAllIds",
        countQuery="WebseiteCms.countAllIds"
    )
    List<Long> getAllIds();

    @Override
    @Query(name="WebseiteCms.getMaxId")
    Long getMaxId();
}
