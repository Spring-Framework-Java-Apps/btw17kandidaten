package org.woehlke.btw17.kandidaten.oodm.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.JpaDomainServiceImpl;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Btw17Wahlbewerber;
import org.woehlke.btw17.kandidaten.oodm.jpa.repositories.Btw17WahlbewerberRepository;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17WahlbewerberService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17WahlbewerberServiceImpl extends JpaDomainServiceImpl<Btw17Wahlbewerber> implements Btw17WahlbewerberService {

    @Autowired
    public Btw17WahlbewerberServiceImpl(Btw17WahlbewerberRepository btw17WahlbewerberRepository) {
        super(btw17WahlbewerberRepository);
    }

    @Override
    protected Btw17WahlbewerberRepository getRepository(){
        return (Btw17WahlbewerberRepository) super.getRepository();
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisNr(long wahlkreisNr, Pageable pageRequest) {
        return this.getRepository().findByWahlkreisNr(wahlkreisNr,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWiederkandidatur(boolean wiederkandidatur, Pageable pageRequest) {
        return this.getRepository().findByWiederkandidatur(wiederkandidatur, pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWohnort(String wohnort, Pageable pageRequest) {
        return this.getRepository().findByWohnort(wohnort, pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByGeburtsort(String geburtsort, Pageable pageRequest) {
        return this.getRepository().findByGeburtsort(geburtsort,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByBeruf(String beruf, Pageable pageRequest) {
        return this.getRepository().findByBeruf(beruf, pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisLand(BundeslandEnum wahlkreisLand, Pageable pageRequest) {
        return this.getRepository().findByWahlkreisLand(wahlkreisLand,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByListeLand(String listeLand, Pageable pageRequest) {
        return this.getRepository().findByListeLand(listeLand,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisParteiBez(String wahlkreisParteiBez, Pageable pageRequest) {
        return this.getRepository().findByWahlkreisParteiBez(wahlkreisParteiBez,pageRequest);
    }

    @Override
    public Page<Btw17Wahlbewerber> findByWahlkreisParteiKurzBez(String wahlkreisParteiKurzBez, Pageable pageRequest) {
        return this.getRepository().findByWahlkreisParteiKurzBez(wahlkreisParteiKurzBez,pageRequest);
    }
}
