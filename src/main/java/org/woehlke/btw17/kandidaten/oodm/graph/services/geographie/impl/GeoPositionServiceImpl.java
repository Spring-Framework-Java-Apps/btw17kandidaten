package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.GeoPositionRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.GeoPositionService;

@Service
@Transactional
public class GeoPositionServiceImpl extends GraphDomainServiceImpl<GeoPosition> implements GeoPositionService {

    @Autowired
    public GeoPositionServiceImpl(final GeoPositionRepository repository){
        super(repository);
    }

    protected GeoPositionRepository getRepository(){
        return (GeoPositionRepository) super.getRepository();
    }

}
