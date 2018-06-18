package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Beruf;

import java.util.List;

@Repository
public interface BerufRepository extends JpaDomainRepository<Beruf> {

    Beruf findByBeruf(String beruf);

    @Query(
        name="Beruf.getAllIds",
        countQuery="Beruf.countAllIds"
    )
    List<Long> getAllIds();

    @Query(name="Beruf.getMaxId")
    Long getMaxId();

}
