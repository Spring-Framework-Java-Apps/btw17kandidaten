package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainService;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17KandidatFlat;

import java.util.List;

public interface Btw17KandidatFlatService extends JpaDomainService<Btw17KandidatFlat> {

    Page<Btw17KandidatFlat> getAllOrderByNachname(Pageable pageRequest);

    List<Long> getAllIdsWhereMdbIsNotNull();
}
