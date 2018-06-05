package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Mdb;

import java.util.List;

@Repository
public interface Btw17Btw17MdbRepository extends JpaDomainRepository<Btw17Mdb> {

    @Query(name = "Btw17Mdb.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Btw17Mdb.getMaxId")
    Long getMaxId();

    @Query(name="Btw17Mdb.countBtw17Mdb2Wahlperiode",nativeQuery=true)
    long countBtw17Mdb2Wahlperiode();

}