package org.woehlke.btw17.kandidaten.oodm.jpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17KandidatFlat;

import java.util.List;

@Repository
public interface Btw17KandidatFlatRepository extends JpaDomainRepository<Btw17KandidatFlat> {

    @Query(name="Btw17KandidatFlat.getAllIdsWhereMdbIsNotNull")
    List<Long> getAllIdsWhereMdbIsNotNull();

    @Query(name="Btw17KandidatFlat.getAllOrderByNachname")
    Page<Btw17KandidatFlat> getAllOrderByNachname(Pageable pageRequest);

    @Query(name="Btw17KandidatFlat.getAllIds")
    List<Long> getAllIds();

    @Query(name="Btw17KandidatFlat.getMaxId")
    Long getMaxId();
}
