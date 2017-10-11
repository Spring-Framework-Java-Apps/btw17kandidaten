package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.model.Btw17Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.repositories.Btw17StrukturdatenRepository;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17StrukturdatenService;
import org.woehlke.btw17.kandidaten.oodm.model.parts.Strukturdaten;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class Btw17StrukturdatenServiceImpl implements Btw17StrukturdatenService {

    private final Btw17StrukturdatenRepository btw17StrukturdatenRepository;

    @Autowired
    public Btw17StrukturdatenServiceImpl(Btw17StrukturdatenRepository btw17StrukturdatenRepository) {
        this.btw17StrukturdatenRepository = btw17StrukturdatenRepository;
    }

    @Override
    public Page<Btw17Strukturdaten> findByWahlkreisNummer(Long wahlkreisNummer, Pageable pageRequest) {
        return btw17StrukturdatenRepository.findByWahlkreisNummer(wahlkreisNummer,pageRequest);
    }

    @Override
    public Page<Btw17Strukturdaten> findByBundeslandName(String bundeslandName, Pageable pageRequest) {
        return btw17StrukturdatenRepository.findByBundeslandName(bundeslandName, pageRequest);
    }

    @Override
    public Strukturdaten getStrukturdatenFromBtw17Strukturdaten(Btw17Strukturdaten btw17Strukturdaten) {
        Strukturdaten o = new Strukturdaten();
        o.setAnzahlGemeinden(btw17Strukturdaten.getAnzahlGemeinden());
        o.setFlaeche(btw17Strukturdaten.getFlaeche());
        o.setBevoelkerungInsgesamt(btw17Strukturdaten.getBevoelkerungInsgesamt());
        o.setBevoelkerungDeutsche(btw17Strukturdaten.getBevoelkerungDeutsche());
        o.setBevoelkerungAuslaender(btw17Strukturdaten.getBevoelkerungAuslaender());
        o.setBevoelkerungsDichte(btw17Strukturdaten.getBevoelkerungsDichte());
        o.setBevoelkerungsGeburtensaldo(btw17Strukturdaten.getBevoelkerungsGeburtensaldo());
        o.setBevoelkerungWanderungssaldo(btw17Strukturdaten.getBevoelkerungWanderungssaldo());
        o.setAlterUnter18(btw17Strukturdaten.getAlterUnter18());
        o.setAlter18bis24(btw17Strukturdaten.getAlter18bis24());
        o.setAlter25bis34(btw17Strukturdaten.getAlter25bis34());
        o.setAlter35bis59(btw17Strukturdaten.getAlter35bis59());
        o.setAlter60bis74(btw17Strukturdaten.getAlter60bis74());
        o.setAlter75plus(btw17Strukturdaten.getAlter75plus());
        o.setMigrationshintergrundOhne(btw17Strukturdaten.getMigrationshintergrundOhne());
        o.setMigrationshintergrundMit(btw17Strukturdaten.getMigrationshintergrundMit());
        o.setReligionKatholischeKirche(btw17Strukturdaten.getReligionKatholischeKirche());
        o.setReligionEvangelischeKirche(btw17Strukturdaten.getReligionEvangelischeKirche());
        o.setReligionSonstige(btw17Strukturdaten.getReligionSonstige());
        o.setWohnungenEigentuemerquote(btw17Strukturdaten.getWohnungenEigentuemerquote());
        o.setWohnungenFertiggestellte(btw17Strukturdaten.getWohnungenFertiggestellte());
        o.setWohnungenBestand(btw17Strukturdaten.getWohnungenBestand());
        o.setEinwohnerEinkommen(btw17Strukturdaten.getEinwohnerEinkommen());
        o.setEinwohnerBruttoinlandsprodukt(btw17Strukturdaten.getEinwohnerBruttoinlandsprodukt());
        o.setEinwohnerKraftfahrzeugbestand(btw17Strukturdaten.getEinwohnerKraftfahrzeugbestand());
        o.setAbsolventenBeruflicheSchulen(btw17Strukturdaten.getAbsolventenBeruflicheSchulen());
        o.setAbsolventenAllgemeinbildendeSchulenInsgesamt(btw17Strukturdaten.getAbsolventenAllgemeinbildendeSchulenInsgesamt());
        o.setAbsolventenHauptschulabschlussOhne(btw17Strukturdaten.getAbsolventenHauptschulabschlussOhne());
        o.setAbsolventenHauptschulabschlussMit(btw17Strukturdaten.getAbsolventenHauptschulabschlussMit());
        o.setAbsolventenRealschule(btw17Strukturdaten.getAbsolventenRealschule());
        o.setAbsolventenAbitur(btw17Strukturdaten.getAbsolventenAbitur());
        o.setKitasBetreuteKinder(btw17Strukturdaten.getKitasBetreuteKinder());
        o.setUnternehmenInsgesamt(btw17Strukturdaten.getUnternehmenInsgesamt());
        o.setUnternehmenHandwerk(btw17Strukturdaten.getUnternehmenHandwerk());
        o.setSozialversicherungBeschaeftigteInsgesamt(btw17Strukturdaten.getSozialversicherungBeschaeftigteInsgesamt());
        o.setSozialversicherungBeschaeftigteLandwirtschaft(btw17Strukturdaten.getSozialversicherungBeschaeftigteLandwirtschaft());
        o.setSozialversicherungBeschaeftigteProduzierendesGewerbe(btw17Strukturdaten.getSozialversicherungBeschaeftigteProduzierendesGewerbe());
        o.setSozialversicherungBeschaeftigteHandel(btw17Strukturdaten.getSozialversicherungBeschaeftigteHandel());
        o.setSozialversicherungBeschaeftigteDienstleister(btw17Strukturdaten.getSozialversicherungBeschaeftigteDienstleister());
        o.setSozialversicherungBeschaeftigteSonstige(btw17Strukturdaten.getSozialversicherungBeschaeftigteSonstige());
        o.setSgb2insgesamt(btw17Strukturdaten.getSgb2insgesamt());
        o.setSgb2erwerbsunfaehige(btw17Strukturdaten.getSgb2erwerbsunfaehige());
        o.setSgb2auslaender(btw17Strukturdaten.getSgb2auslaender());
        o.setArbeitslosenquoteInsgesamt(btw17Strukturdaten.getArbeitslosenquoteInsgesamt());
        o.setArbeitslosenquoteMaenner(btw17Strukturdaten.getArbeitslosenquoteMaenner());
        o.setArbeitslosenquoteFrauen(btw17Strukturdaten.getArbeitslosenquoteFrauen());
        o.setArbeitslosenquote12bis20(btw17Strukturdaten.getArbeitslosenquote12bis20());
        o.setArbeitslosenquote55bis65(btw17Strukturdaten.getArbeitslosenquote55bis65());
        o.setFussnoten(btw17Strukturdaten.getFussnoten());
        return o;
    }

    @Override
    public List<Btw17Strukturdaten> getStrukturdatenOfBundeslaender() {
        return btw17StrukturdatenRepository.getStrukturdatenOfBundeslaender();
    }

    @Override
    public Page<Btw17Strukturdaten> getAll(Pageable pageRequest) {
        return btw17StrukturdatenRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<Btw17Strukturdaten> getAll() {
        return btw17StrukturdatenRepository.findAll();
    }

    @Override
    public long count() {
        return btw17StrukturdatenRepository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteAll() {
        btw17StrukturdatenRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void delete(Btw17Strukturdaten domainObject) {
        btw17StrukturdatenRepository.delete(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Strukturdaten create(Btw17Strukturdaten domainObject) {
        return btw17StrukturdatenRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Btw17Strukturdaten update(Btw17Strukturdaten domainObject) {
        return btw17StrukturdatenRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return btw17StrukturdatenRepository.getAllIds();
    }

    @Override
    public Btw17Strukturdaten findById(long id) {
        return btw17StrukturdatenRepository.findOne(id);
    }

    @Override
    public Long getMaxId() {
        return btw17StrukturdatenRepository.getMaxId();
    }
}
