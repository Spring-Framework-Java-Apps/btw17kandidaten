package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;

import java.util.List;

@Repository
public interface WohnortRepository extends JpaRepository<Wohnort,Long> {

    Wohnort findByWohnort(String wohnort);

    @Query(name = "Wohnort.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Wohnort.getMaxId")
    long getMaxId();

}
