package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ministerium;

import java.util.List;


@Repository
public interface MinisteriumRepository extends JpaDomainRepository<Ministerium> {

    Ministerium findByMinisterium(String ministerium);

    @Query(name="Ministerium.getAllIds")
    List<Long> getAllIds();

    @Query(name="Ministerium.getMaxId")
    Long getMaxId();

}
