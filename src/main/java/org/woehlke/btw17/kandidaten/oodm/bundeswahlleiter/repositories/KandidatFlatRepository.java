package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.KandidatFlat;

import java.util.List;

@Repository
public interface KandidatFlatRepository  extends PagingAndSortingRepository<KandidatFlat,Long> {

    @Query(name="KandidatFlat.getAllIdsWhereMdbIsNotNull")
    List<Long> getAllIdsWhereMdbIsNotNull();

    @Query(name="KandidatFlat.getAllOrderByNachname")
    Page<KandidatFlat> getAllOrderByNachname(Pageable pageRequest);
}
