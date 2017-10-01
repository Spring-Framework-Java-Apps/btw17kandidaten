package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17KandidatFlat;

import java.util.List;

public interface Btw17KandidatFlatService extends Btw17Service<Btw17KandidatFlat> {

    Page<Btw17KandidatFlat> getAllOrderByNachname(Pageable pageRequest);

    List<Long> getAllIdsWhereMdbIsNotNull();
}
