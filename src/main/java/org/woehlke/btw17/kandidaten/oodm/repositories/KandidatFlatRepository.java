package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat;

import java.util.List;

@Repository
public interface KandidatFlatRepository  extends PagingAndSortingRepository<KandidatFlat,Long> {

    @Query(name="KandidatFlat.getAllIdsWhereMdbIsNotNull")
    List<Long> getAllIdsWhereMdbIsNotNull();
}
