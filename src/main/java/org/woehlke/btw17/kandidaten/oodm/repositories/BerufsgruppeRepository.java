package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;

import java.util.List;

@Repository
public interface BerufsgruppeRepository extends JpaRepository<Berufsgruppe,Long> {

    Berufsgruppe findByBerufsgruppe(String berufsgruppe);

    @Query(name="Berufsgruppe.getAllIds")
    List<Long> getAllIds();

    @Query(name="Berufsgruppe.getMaxId")
    long getMaxId();

}
