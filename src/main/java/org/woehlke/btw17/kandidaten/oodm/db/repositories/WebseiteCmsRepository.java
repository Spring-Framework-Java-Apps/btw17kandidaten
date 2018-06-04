package org.woehlke.btw17.kandidaten.oodm.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.db.model.WebseiteCms;

import java.util.List;

@Repository
public interface WebseiteCmsRepository extends JpaRepository<WebseiteCms,Long> {

    WebseiteCms findByCms(String cms);

    @Query(name="Cms.getAllIds")
    List<Long> getAllIds();

    @Query(name="Cms.getMaxId")
    Long getMaxId();
}
