package org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Adresse;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie.AdresseRepository;
import org.woehlke.btw17.kandidaten.oodm.graph.services.geographie.AdresseService;

@Service
@Transactional
public class AdresseServiceImpl extends GraphDomainServiceImpl<Adresse> implements AdresseService {

    @Autowired
    public AdresseServiceImpl(final AdresseRepository adresseRepository){
        super(adresseRepository);
    }

    protected AdresseRepository getRepository(){
        return (AdresseRepository) super.getRepository();
    }

}
