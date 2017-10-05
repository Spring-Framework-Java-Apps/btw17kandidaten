package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter.Btw17KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.Btw17KandidatFlatRepositoryCustom;

import java.util.List;

@Repository
public interface Btw17KandidatFlatRepository extends PagingAndSortingRepository<Btw17KandidatFlat,Long>,Btw17KandidatFlatRepositoryCustom {

    @Query(name="Btw17KandidatFlat.getAllIdsWhereMdbIsNotNull")
    List<Long> getAllIdsWhereMdbIsNotNull();

    @Query(name="Btw17KandidatFlat.getAllOrderByNachname")
    Page<Btw17KandidatFlat> getAllOrderByNachname(Pageable pageRequest);

    @Query(name="Btw17KandidatFlat.getAllIds")
    List<Long> getAllIds();

}
