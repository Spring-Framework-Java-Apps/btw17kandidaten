package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Berufsgruppe;

import java.util.List;

@Repository
public interface BerufsgruppeRepository extends JpaDomainRepository<Berufsgruppe> {

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

    @Query(name="Berufsgruppe.getAllIds")
    List<Long> getAllIds();

    @Query(name="Berufsgruppe.getMaxId")
    Long getMaxId();

}
