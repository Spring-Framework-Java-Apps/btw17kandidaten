package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteAgentur;

import java.util.List;

@Repository
public interface WebseiteAgenturRepository extends JpaDomainRepository<WebseiteAgentur> {

    WebseiteAgentur findByAgentur(String agentur);

    @Query(name="Dienstleister.getAllIds")
    List<Long> getAllIds();

    @Query(name="Dienstleister.getMaxId")
    Long getMaxId();

}
