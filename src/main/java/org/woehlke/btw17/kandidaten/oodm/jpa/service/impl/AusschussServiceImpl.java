package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.AusschussRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.AusschussService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class AusschussServiceImpl extends JpaDomainServiceImpl<Ausschuss> implements AusschussService {

    @Autowired
    public AusschussServiceImpl(AusschussRepository ausschussRepository) {
        super(ausschussRepository);
    }

    @Override
    protected AusschussRepository getRepository(){
        return (AusschussRepository) super.getRepository();
    }

    @Override
    public Ausschuss findByAusschuss(String ausschuss) {
        return this.getRepository().findByAusschuss(ausschuss);
    }

}
