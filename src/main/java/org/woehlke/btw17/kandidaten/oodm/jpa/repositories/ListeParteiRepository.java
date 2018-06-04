package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.ListePartei;

import java.util.List;

@Repository
public interface ListeParteiRepository extends JpaDomainRepository<ListePartei> {

    ListePartei findByListeParteiAndListeParteiLang(String listePartei, String listeParteiLang);

    ListePartei findByListePartei(String listePartei);

    @Query(name="ListePartei.getAllIds")
    List<Long> getAllIds();

    @Query(name="ListePartei.getMaxId")
    Long getMaxId();

}
