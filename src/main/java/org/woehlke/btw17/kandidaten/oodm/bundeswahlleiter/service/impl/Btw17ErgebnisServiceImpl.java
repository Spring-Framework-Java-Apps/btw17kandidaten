package org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.Btw17Ergebnis;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.repositories.Btw17ErgebnisRepository;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.Btw17ErgebnisService;
import org.woehlke.btw17.kandidaten.oodm.model.parts.WahlergebnisseBtw17;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17ErgebnisServiceImpl implements Btw17ErgebnisService {

    private final Btw17ErgebnisRepository btw17ErgebnisRepository;

    @Autowired
    public Btw17ErgebnisServiceImpl(Btw17ErgebnisRepository btw17ErgebnisRepository) {
        this.btw17ErgebnisRepository = btw17ErgebnisRepository;
    }

    @Override
    public Page<Btw17Ergebnis> findByWahlkreisNummer(long wahlkreisNummer, Pageable pageRequest) {
        return btw17ErgebnisRepository.findByWahlkreisNummer(wahlkreisNummer,pageRequest);
    }

    @Override
    public Page<Btw17Ergebnis> findByBundeslandNummer(long bundeslandNummer, Pageable pageRequest) {
        return btw17ErgebnisRepository.findByBundeslandNummer(bundeslandNummer, pageRequest);
    }

    @Override
    public Page<Btw17Ergebnis> getAll(Pageable pageRequest) {
        return btw17ErgebnisRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Ergebnis> getAll() {
        return btw17ErgebnisRepository.findAll();
    }

    @Override
    public long count() {
        return btw17ErgebnisRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        btw17ErgebnisRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17Ergebnis domainObject) {
        btw17ErgebnisRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Ergebnis create(Btw17Ergebnis domainObject) {
        return btw17ErgebnisRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Ergebnis update(Btw17Ergebnis domainObject) {
        return btw17ErgebnisRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return btw17ErgebnisRepository.getAllIds();
    }


    @Override
    public Btw17Ergebnis findById(long id) {
        return btw17ErgebnisRepository.findOne(id);
    }

    @Override
    public List<Btw17Ergebnis> getErgebnisOfBundeslaender() {
        return btw17ErgebnisRepository.getErgebnisOfBundeslaender();
    }

    @Override
    public WahlergebnisseBtw17 getWahlergebnisseFromBtw17Ergebnis(Btw17Ergebnis btw17Ergebnis) {
        WahlergebnisseBtw17 o = new WahlergebnisseBtw17();

        o.setWahlberechtigteErststimmenVorlaeufig(btw17Ergebnis.getWahlberechtigteErststimmenVorlaeufig());
        o.setWahlberechtigteErststimmenVorperiode(btw17Ergebnis.getWahlberechtigteErststimmenVorperiode());
        o.setWahlberechtigteZweitstimmenVorlaeufig(btw17Ergebnis.getWahlberechtigteZweitstimmenVorlaeufig());
        o.setWahlberechtigteZweitstimmenVorperiode(btw17Ergebnis.getWahlberechtigteZweitstimmenVorperiode());
        o.setWaehlerErststimmenVorlaeufig(btw17Ergebnis.getWaehlerErststimmenVorlaeufig());
        o.setWaehlerErststimmenVorperiode(btw17Ergebnis.getWaehlerErststimmenVorperiode());
        o.setWaehlerZweitstimmenVorlaeufig(btw17Ergebnis.getWaehlerZweitstimmenVorlaeufig());
        o.setWaehlerZweitstimmenVorperiode(btw17Ergebnis.getWaehlerZweitstimmenVorperiode());
        o.setUngueltigeErststimmenVorlaeufig(btw17Ergebnis.getUngueltigeErststimmenVorlaeufig());
        o.setUngueltigeErststimmenVorperiode(btw17Ergebnis.getUngueltigeErststimmenVorperiode());
        o.setUngueltigeZweitstimmenVorlaeufig(btw17Ergebnis.getUngueltigeZweitstimmenVorlaeufig());
        o.setUngueltigeZweitstimmenVorperiode(btw17Ergebnis.getUngueltigeZweitstimmenVorperiode());
        o.setGueltigeErststimmenVorlaeufig(btw17Ergebnis.getGueltigeErststimmenVorlaeufig());
        o.setGueltigeErststimmenVorperiode(btw17Ergebnis.getGueltigeErststimmenVorperiode());
        o.setGueltigeZweitstimmenVorlaeufig(btw17Ergebnis.getGueltigeZweitstimmenVorlaeufig());
        o.setGueltigeZweitstimmenVorperiode(btw17Ergebnis.getGueltigeZweitstimmenVorperiode());
        o.setCduErststimmenVorlaeufig(btw17Ergebnis.getCduErststimmenVorlaeufig());
        o.setCduErststimmenVorperiode(btw17Ergebnis.getCduErststimmenVorperiode());
        o.setCduZweitstimmenVorlaeufig(btw17Ergebnis.getCduZweitstimmenVorlaeufig());
        o.setCduZweitstimmenVorperiode(btw17Ergebnis.getCduZweitstimmenVorperiode());
        o.setSpdErststimmenVorlaeufig(btw17Ergebnis.getSpdErststimmenVorlaeufig());
        o.setSpdErststimmenVorperiode(btw17Ergebnis.getSpdErststimmenVorperiode());
        o.setSpdZweitstimmenVorlaeufig(btw17Ergebnis.getSpdZweitstimmenVorlaeufig());
        o.setSpdZweitstimmenVorperiode(btw17Ergebnis.getSpdZweitstimmenVorperiode());
        o.setDielinkeErststimmenVorlaeufig(btw17Ergebnis.getDielinkeErststimmenVorlaeufig());
        o.setDielinkeErststimmenVorperiode(btw17Ergebnis.getDielinkeErststimmenVorperiode());
        o.setDielinkeZweitstimmenVorlaeufig(btw17Ergebnis.getDielinkeZweitstimmenVorlaeufig());
        o.setDielinkeZweitstimmenVorperiode(btw17Ergebnis.getDielinkeZweitstimmenVorperiode());
        o.setDiegruenenErststimmenVorlaeufig(btw17Ergebnis.getDiegruenenErststimmenVorlaeufig());
        o.setDiegruenenErststimmenVorperiode(btw17Ergebnis.getDiegruenenErststimmenVorperiode());
        o.setDiegruenenZweitstimmenVorlaeufig(btw17Ergebnis.getDiegruenenZweitstimmenVorlaeufig());
        o.setDiegruenenZweitstimmenVorperiode(btw17Ergebnis.getDiegruenenZweitstimmenVorperiode());
        o.setCsuErststimmenVorlaeufig(btw17Ergebnis.getCsuErststimmenVorlaeufig());
        o.setCsuErststimmenVorperiode(btw17Ergebnis.getCsuErststimmenVorperiode());
        o.setCsuZweitstimmenVorlaeufig(btw17Ergebnis.getCsuZweitstimmenVorlaeufig());
        o.setCsuZweitstimmenVorperiode(btw17Ergebnis.getCsuZweitstimmenVorperiode());
        o.setFdpErststimmenVorlaeufig(btw17Ergebnis.getFdpErststimmenVorlaeufig());
        o.setFdpErststimmenVorperiode(btw17Ergebnis.getFdpErststimmenVorperiode());
        o.setFdpZweitstimmenVorlaeufig(btw17Ergebnis.getFdpZweitstimmenVorlaeufig());
        o.setFdpZweitstimmenVorperiode(btw17Ergebnis.getFdpZweitstimmenVorperiode());
        o.setAfdErststimmenVorlaeufig(btw17Ergebnis.getAfdErststimmenVorlaeufig());
        o.setAfdErststimmenVorperiode(btw17Ergebnis.getAfdErststimmenVorperiode());
        o.setAfdZweitstimmenVorlaeufig(btw17Ergebnis.getAfdZweitstimmenVorlaeufig());
        o.setAfdZweitstimmenVorperiode(btw17Ergebnis.getAfdZweitstimmenVorperiode());
        o.setPiratenparteiErststimmenVorlaeufig(btw17Ergebnis.getPiratenparteiErststimmenVorlaeufig());
        o.setPiratenparteiErststimmenVorperiode(btw17Ergebnis.getPiratenparteiErststimmenVorperiode());
        o.setPiratenparteiZweitstimmenVorlaeufig(btw17Ergebnis.getPiratenparteiZweitstimmenVorlaeufig());
        o.setPiratenparteiZweitstimmenVorperiode(btw17Ergebnis.getPiratenparteiZweitstimmenVorperiode());
        o.setNpdErststimmenVorlaeufig(btw17Ergebnis.getNpdErststimmenVorlaeufig());
        o.setNpdErststimmenVorperiode(btw17Ergebnis.getNpdErststimmenVorperiode());
        o.setNpdZweitstimmenVorlaeufig(btw17Ergebnis.getNpdZweitstimmenVorlaeufig());
        o.setNpdZweitstimmenVorperiode(btw17Ergebnis.getNpdZweitstimmenVorperiode());
        o.setFreieWaehlerErststimmenVorlaeufig(btw17Ergebnis.getFreieWaehlerErststimmenVorlaeufig());
        o.setFreieWaehlerErststimmenVorperiode(btw17Ergebnis.getFreieWaehlerErststimmenVorperiode());
        o.setFreieWaehlerZweitstimmenVorlaeufig(btw17Ergebnis.getFreieWaehlerZweitstimmenVorlaeufig());
        o.setFreieWaehlerZweitstimmenVorperiode(btw17Ergebnis.getFreieWaehlerZweitstimmenVorperiode());
        o.setTierschutzparteiErststimmenVorlaeufig(btw17Ergebnis.getTierschutzparteiErststimmenVorlaeufig());
        o.setTierschutzparteiErststimmenVorperiode(btw17Ergebnis.getTierschutzparteiErststimmenVorperiode());
        o.setTierschutzparteiZweitstimmenVorlaeufig(btw17Ergebnis.getTierschutzparteiZweitstimmenVorlaeufig());
        o.setTierschutzparteiZweitstimmenVorperiode(btw17Ergebnis.getTierschutzparteiZweitstimmenVorperiode());
        o.setOedpErststimmenVorlaeufig(btw17Ergebnis.getOedpErststimmenVorlaeufig());
        o.setOedpErststimmenVorperiode(btw17Ergebnis.getOedpErststimmenVorperiode());
        o.setOedpZweitstimmenVorlaeufig(btw17Ergebnis.getOedpZweitstimmenVorlaeufig());
        o.setOedpZweitstimmenVorperiode(btw17Ergebnis.getOedpZweitstimmenVorperiode());
        o.setDieparteiErststimmenVorlaeufig(btw17Ergebnis.getDieparteiErststimmenVorlaeufig());
        o.setDieparteiErststimmenVorperiode(btw17Ergebnis.getDieparteiErststimmenVorperiode());
        o.setDieparteiZweitstimmenVorlaeufig(btw17Ergebnis.getDieparteiZweitstimmenVorlaeufig());
        o.setDieparteiZweitstimmenVorperiode(btw17Ergebnis.getDieparteiZweitstimmenVorperiode());
        o.setBayernparteiErststimmenVorlaeufig(btw17Ergebnis.getBayernparteiErststimmenVorlaeufig());
        o.setBayernparteiErststimmenVorperiode(btw17Ergebnis.getBayernparteiErststimmenVorperiode());
        o.setBayernparteiZweitstimmenVorlaeufig(btw17Ergebnis.getBayernparteiZweitstimmenVorlaeufig());
        o.setBayernparteiZweitstimmenVorperiode(btw17Ergebnis.getBayernparteiZweitstimmenVorperiode());
        o.setVolksabstimmungErststimmenVorlaeufig(btw17Ergebnis.getVolksabstimmungErststimmenVorlaeufig());
        o.setVolksabstimmungErststimmenVorperiode(btw17Ergebnis.getVolksabstimmungErststimmenVorperiode());
        o.setVolksabstimmungZweitstimmenVorlaeufig(btw17Ergebnis.getVolksabstimmungZweitstimmenVorlaeufig());
        o.setVolksabstimmungZweitstimmenVorperiode(btw17Ergebnis.getVolksabstimmungZweitstimmenVorperiode());
        o.setPdvErststimmenVorlaeufig(btw17Ergebnis.getPdvErststimmenVorlaeufig());
        o.setPdvErststimmenVorperiode(btw17Ergebnis.getPdvErststimmenVorperiode());
        o.setPdvZweitstimmenVorlaeufig(btw17Ergebnis.getPdvZweitstimmenVorlaeufig());
        o.setPdvZweitstimmenVorperiode(btw17Ergebnis.getPdvZweitstimmenVorperiode());
        o.setMlpdErststimmenVorlaeufig(btw17Ergebnis.getMlpdErststimmenVorlaeufig());
        o.setMlpdErststimmenVorperiode(btw17Ergebnis.getMlpdErststimmenVorperiode());
        o.setMlpdZweitstimmenVorlaeufig(btw17Ergebnis.getMlpdZweitstimmenVorlaeufig());
        o.setMlpdZweitstimmenVorperiode(btw17Ergebnis.getMlpdZweitstimmenVorperiode());
        o.setBuesoErststimmenVorlaeufig(btw17Ergebnis.getBuesoErststimmenVorlaeufig());
        o.setBuesoErststimmenVorperiode(btw17Ergebnis.getBuesoErststimmenVorperiode());
        o.setBuesoZweitstimmenVorlaeufig(btw17Ergebnis.getBuesoZweitstimmenVorlaeufig());
        o.setBuesoZweitstimmenVorperiode(btw17Ergebnis.getBuesoZweitstimmenVorperiode());
        o.setSgpErststimmenVorlaeufig(btw17Ergebnis.getSgpErststimmenVorlaeufig());
        o.setSgpErststimmenVorperiode(btw17Ergebnis.getSgpErststimmenVorperiode());
        o.setSgpZweitstimmenVorlaeufig(btw17Ergebnis.getSgpZweitstimmenVorlaeufig());
        o.setSgpZweitstimmenVorperiode(btw17Ergebnis.getSgpZweitstimmenVorperiode());
        o.setDierechteErststimmenVorlaeufig(btw17Ergebnis.getDierechteErststimmenVorlaeufig());
        o.setDierechteErststimmenVorperiode(btw17Ergebnis.getDierechteErststimmenVorperiode());
        o.setDierechteZweitstimmenVorlaeufig(btw17Ergebnis.getDierechteZweitstimmenVorlaeufig());
        o.setDierechteZweitstimmenVorperiode(btw17Ergebnis.getDierechteZweitstimmenVorperiode());
        o.setAddErststimmenVorlaeufig(btw17Ergebnis.getAddErststimmenVorlaeufig());
        o.setAddErststimmenVorperiode(btw17Ergebnis.getAddErststimmenVorperiode());
        o.setAddZweitstimmenVorlaeufig(btw17Ergebnis.getAddZweitstimmenVorlaeufig());
        o.setAddZweitstimmenVorperiode(btw17Ergebnis.getAddZweitstimmenVorperiode());
        o.setTierschutzallianzErststimmenVorlaeufig(btw17Ergebnis.getTierschutzallianzErststimmenVorlaeufig());
        o.setTierschutzallianzErststimmenVorperiode(btw17Ergebnis.getTierschutzallianzErststimmenVorperiode());
        o.setTierschutzallianzZweitstimmenVorlaeufig(btw17Ergebnis.getTierschutzallianzZweitstimmenVorlaeufig());
        o.setTierschutzallianzZweitstimmenVorperiode(btw17Ergebnis.getTierschutzallianzZweitstimmenVorperiode());
        o.setBergparteiErststimmenVorlaeufig(btw17Ergebnis.getBergparteiErststimmenVorlaeufig());
        o.setBergparteiErststimmenVorperiode(btw17Ergebnis.getBergparteiErststimmenVorperiode());
        o.setBergparteiZweitstimmenVorlaeufig(btw17Ergebnis.getBergparteiZweitstimmenVorlaeufig());
        o.setBergparteiZweitstimmenVorperiode(btw17Ergebnis.getBergparteiZweitstimmenVorperiode());
        o.setBgeErststimmenVorlaeufig(btw17Ergebnis.getBgeErststimmenVorlaeufig());
        o.setBgeErststimmenVorperiode(btw17Ergebnis.getBgeErststimmenVorperiode());
        o.setBgeZweitstimmenVorlaeufig(btw17Ergebnis.getBgeZweitstimmenVorlaeufig());
        o.setBgeZweitstimmenVorperiode(btw17Ergebnis.getBgeZweitstimmenVorperiode());
        o.setDibErststimmenVorlaeufig(btw17Ergebnis.getDibErststimmenVorlaeufig());
        o.setDibErststimmenVorperiode(btw17Ergebnis.getDibErststimmenVorperiode());
        o.setDibZweitstimmenVorlaeufig(btw17Ergebnis.getDibZweitstimmenVorlaeufig());
        o.setDibZweitstimmenVorperiode(btw17Ergebnis.getDibZweitstimmenVorperiode());
        o.setDkpErststimmenVorlaeufig(btw17Ergebnis.getDkpErststimmenVorlaeufig());
        o.setDkpErststimmenVorperiode(btw17Ergebnis.getDkpErststimmenVorperiode());
        o.setDkpZweitstimmenVorlaeufig(btw17Ergebnis.getDkpZweitstimmenVorlaeufig());
        o.setDkpZweitstimmenVorperiode(btw17Ergebnis.getDkpZweitstimmenVorperiode());
        o.setDmErststimmenVorlaeufig(btw17Ergebnis.getDmErststimmenVorlaeufig());
        o.setDmErststimmenVorperiode(btw17Ergebnis.getDmErststimmenVorperiode());
        o.setDmZweitstimmenVorlaeufig(btw17Ergebnis.getDmZweitstimmenVorlaeufig());
        o.setDmZweitstimmenVorperiode(btw17Ergebnis.getDmZweitstimmenVorperiode());
        o.setDiegrauenErststimmenVorlaeufig(btw17Ergebnis.getDiegrauenErststimmenVorlaeufig());
        o.setDiegrauenErststimmenVorperiode(btw17Ergebnis.getDiegrauenErststimmenVorperiode());
        o.setDiegrauenZweitstimmenVorlaeufig(btw17Ergebnis.getDiegrauenZweitstimmenVorlaeufig());
        o.setDiegrauenZweitstimmenVorperiode(btw17Ergebnis.getDiegrauenZweitstimmenVorperiode());
        o.setDuErststimmenVorlaeufig(btw17Ergebnis.getDuErststimmenVorlaeufig());
        o.setDuErststimmenVorperiode(btw17Ergebnis.getDuErststimmenVorperiode());
        o.setDuZweitstimmenVorlaeufig(btw17Ergebnis.getDuZweitstimmenVorlaeufig());
        o.setDuZweitstimmenVorperiode(btw17Ergebnis.getDuZweitstimmenVorperiode());
        o.setMgErststimmenVorlaeufig(btw17Ergebnis.getMgErststimmenVorlaeufig());
        o.setMgErststimmenVorperiode(btw17Ergebnis.getMgErststimmenVorperiode());
        o.setMgZweitstimmenVorlaeufig(btw17Ergebnis.getMgZweitstimmenVorlaeufig());
        o.setMgZweitstimmenVorperiode(btw17Ergebnis.getMgZweitstimmenVorperiode());
        o.setMenschlicheweltErststimmenVorlaeufig(btw17Ergebnis.getMenschlicheweltErststimmenVorlaeufig());
        o.setMenschlicheweltErststimmenVorperiode(btw17Ergebnis.getMenschlicheweltErststimmenVorperiode());
        o.setMenschlicheweltZweitstimmenVorlaeufig(btw17Ergebnis.getMenschlicheweltZweitstimmenVorlaeufig());
        o.setMenschlicheweltZweitstimmenVorperiode(btw17Ergebnis.getMenschlicheweltZweitstimmenVorperiode());
        o.setDiehumanistenErststimmenVorlaeufig(btw17Ergebnis.getDiehumanistenErststimmenVorlaeufig());
        o.setDiehumanistenErststimmenVorperiode(btw17Ergebnis.getDiehumanistenErststimmenVorperiode());
        o.setDiehumanistenZweitstimmenVorlaeufig(btw17Ergebnis.getDiehumanistenZweitstimmenVorlaeufig());
        o.setDiehumanistenZweitstimmenVorperiode(btw17Ergebnis.getDiehumanistenZweitstimmenVorperiode());
        o.setGesundheitsforschungErststimmenVorlaeufig(btw17Ergebnis.getGesundheitsforschungErststimmenVorlaeufig());
        o.setGesundheitsforschungErststimmenVorperiode(btw17Ergebnis.getGesundheitsforschungErststimmenVorperiode());
        o.setGesundheitsforschungZweitstimmenVorlaeufig(btw17Ergebnis.getGesundheitsforschungZweitstimmenVorlaeufig());
        o.setGesundheitsforschungZweitstimmenVorperiode(btw17Ergebnis.getGesundheitsforschungZweitstimmenVorperiode());
        o.setVparteiErststimmenVorlaeufig(btw17Ergebnis.getVparteiErststimmenVorlaeufig());
        o.setVparteiErststimmenVorperiode(btw17Ergebnis.getVparteiErststimmenVorperiode());
        o.setVparteiZweitstimmenVorlaeufig(btw17Ergebnis.getVparteiZweitstimmenVorlaeufig());
        o.setVparteiZweitstimmenVorperiode(btw17Ergebnis.getVparteiZweitstimmenVorperiode());
        o.setBuendniscErststimmenVorlaeufig(btw17Ergebnis.getBuendniscErststimmenVorlaeufig());
        o.setBuendniscErststimmenVorperiode(btw17Ergebnis.getBuendniscErststimmenVorperiode());
        o.setBuendniscZweitstimmenVorlaeufig(btw17Ergebnis.getBuendniscZweitstimmenVorlaeufig());
        o.setBuendniscZweitstimmenVorperiode(btw17Ergebnis.getBuendniscZweitstimmenVorperiode());
        o.setDieeinheitErststimmenVorlaeufig(btw17Ergebnis.getDieeinheitErststimmenVorlaeufig());
        o.setDieeinheitErststimmenVorperiode(btw17Ergebnis.getDieeinheitErststimmenVorperiode());
        o.setDieeinheitZweitstimmenVorlaeufig(btw17Ergebnis.getDieeinheitZweitstimmenVorlaeufig());
        o.setDieeinheitZweitstimmenVorperiode(btw17Ergebnis.getDieeinheitZweitstimmenVorperiode());
        o.setDieviolettenErststimmenVorlaeufig(btw17Ergebnis.getDieviolettenErststimmenVorlaeufig());
        o.setDieviolettenErststimmenVorperiode(btw17Ergebnis.getDieviolettenErststimmenVorperiode());
        o.setDieviolettenZweitstimmenVorlaeufig(btw17Ergebnis.getDieviolettenZweitstimmenVorlaeufig());
        o.setDieviolettenZweitstimmenVorperiode(btw17Ergebnis.getDieviolettenZweitstimmenVorperiode());
        o.setFamilieErststimmenVorlaeufig(btw17Ergebnis.getFamilieErststimmenVorlaeufig());
        o.setFamilieErststimmenVorperiode(btw17Ergebnis.getFamilieErststimmenVorperiode());
        o.setFamilieZweitstimmenVorlaeufig(btw17Ergebnis.getFamilieZweitstimmenVorlaeufig());
        o.setFamilieZweitstimmenVorperiode(btw17Ergebnis.getFamilieZweitstimmenVorperiode());
        o.setDiefrauenErststimmenVorlaeufig(btw17Ergebnis.getDiefrauenErststimmenVorlaeufig());
        o.setDiefrauenErststimmenVorperiode(btw17Ergebnis.getDiefrauenErststimmenVorperiode());
        o.setDiefrauenZweitstimmenVorlaeufig(btw17Ergebnis.getDiefrauenZweitstimmenVorlaeufig());
        o.setDiefrauenZweitstimmenVorperiode(btw17Ergebnis.getDiefrauenZweitstimmenVorperiode());
        o.setMieterparteiErststimmenVorlaeufig(btw17Ergebnis.getMieterparteiErststimmenVorlaeufig());
        o.setMieterparteiErststimmenVorperiode(btw17Ergebnis.getMieterparteiErststimmenVorperiode());
        o.setMieterparteiZweitstimmenVorlaeufig(btw17Ergebnis.getMieterparteiZweitstimmenVorlaeufig());
        o.setMieterparteiZweitstimmenVorperiode(btw17Ergebnis.getMieterparteiZweitstimmenVorperiode());
        o.setNeueliberaleErststimmenVorlaeufig(btw17Ergebnis.getNeueliberaleErststimmenVorlaeufig());
        o.setNeueliberaleErststimmenVorperiode(btw17Ergebnis.getNeueliberaleErststimmenVorperiode());
        o.setNeueliberaleZweitstimmenVorlaeufig(btw17Ergebnis.getNeueliberaleZweitstimmenVorlaeufig());
        o.setNeueliberaleZweitstimmenVorperiode(btw17Ergebnis.getNeueliberaleZweitstimmenVorperiode());
        o.setUnabhaengigeErststimmenVorlaeufig(btw17Ergebnis.getUnabhaengigeErststimmenVorlaeufig());
        o.setUnabhaengigeErststimmenVorperiode(btw17Ergebnis.getUnabhaengigeErststimmenVorperiode());
        o.setUnabhaengigeZweitstimmenVorlaeufig(btw17Ergebnis.getUnabhaengigeZweitstimmenVorlaeufig());
        o.setUnabhaengigeZweitstimmenVorperiode(btw17Ergebnis.getUnabhaengigeZweitstimmenVorperiode());
        o.setUebrigeErststimmenVorlaeufig(btw17Ergebnis.getUebrigeErststimmenVorlaeufig());
        o.setUebrigeErststimmenVorperiode(btw17Ergebnis.getUebrigeErststimmenVorperiode());
        o.setUebrigeZweitstimmenVorlaeufig(btw17Ergebnis.getUebrigeZweitstimmenVorlaeufig());
        o.setUebrigeZweitstimmenVorperiode(btw17Ergebnis.getUebrigeZweitstimmenVorperiode());

        return o;
    }
}
