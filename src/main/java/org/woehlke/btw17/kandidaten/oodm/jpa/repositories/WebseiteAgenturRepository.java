package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.WebseiteAgentur;

import java.util.List;

@Repository("jpa.WebseiteAgenturRepository")
public interface WebseiteAgenturRepository extends JpaDomainRepository<WebseiteAgentur> {

    WebseiteAgentur findByAgentur(String agentur);

    @Query(
        name="WebseiteAgentur.getAllIds",
        countQuery="WebseiteAgentur.countAllIds"
    )
    List<Long> getAllIds();

    @Query(name="WebseiteAgentur.getMaxId")
    Long getMaxId();

}
