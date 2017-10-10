package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundestag.Btw17Mdb;

import java.util.List;

@Repository
public interface Btw17Btw17MdbRepository extends JpaRepository<Btw17Mdb,Long> {

    @Query(name = "Btw17Mdb.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Btw17Mdb.getMaxId")
    long getMaxId();

    @Query(name="Btw17Mdb.countBtw17Mdb2Wahlperiode",nativeQuery=true)
    long countBtw17Mdb2Wahlperiode();

}
