package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.Btw17KandidatFlatRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17KandidatFlatService;

import java.util.List;

@Service("jpa.Btw17KandidatFlatService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17KandidatFlatServiceImpl extends JpaDomainServiceImpl<Btw17KandidatFlat> implements Btw17KandidatFlatService {

    @Autowired
    public Btw17KandidatFlatServiceImpl(Btw17KandidatFlatRepository btw17KandidatFlatRepository) {
        super(btw17KandidatFlatRepository);
    }

    @Override
    protected Btw17KandidatFlatRepository getRepository(){
        return (Btw17KandidatFlatRepository) super.getRepository();
    }

    @Override
    public Page<Btw17KandidatFlat> getAllOrderByNachname(Pageable pageRequest) {
        return getRepository().getAllOrderByNachname(pageRequest);
    }

    @Override
    public List<Long> getAllIdsWhereMdbIsNotNull() {
        return getRepository().getAllIdsWhereMdbIsNotNull();
    }
}
