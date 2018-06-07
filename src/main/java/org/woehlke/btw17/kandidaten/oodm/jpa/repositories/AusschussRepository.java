package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ausschuss;

import java.util.List;

@Repository
public interface AusschussRepository extends JpaDomainRepository<Ausschuss> {

    Ausschuss findByAusschuss(String ausschuss);

    @Query(name="Ausschuss.getAllIds")
    List<Long> getAllIds();

    @Query(name="Ausschuss.getMaxId")
    Long getMaxId();
}
