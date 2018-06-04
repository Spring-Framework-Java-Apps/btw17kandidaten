package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Geburtsort;

import java.util.List;

@Repository
public interface GeburtsortRepository extends JpaRepository<Geburtsort,Long> {

    Geburtsort findByGeburtsort(String geburtsort);

    @Query(name="Geburtsort.getAllIds")
    List<Long> getAllIds();

    @Query(name="Geburtsort.getMaxId")
    Long getMaxId();
}
