package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;

import java.util.List;

@Repository
public interface BerufRepository extends JpaRepository<Beruf,Long> {

    Beruf findByBeruf(String beruf);

    @Query(name="Beruf.getAllIds")
    List<Long> getAllIds();

    @Query(name="Beruf.getMaxId")
    long getMaxId();

}
