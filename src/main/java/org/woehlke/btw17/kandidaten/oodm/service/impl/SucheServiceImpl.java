package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.woehlke.btw17.kandidaten.frontend.content.SearchForKandidat;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.repositories.SucheRepository;
import org.woehlke.btw17.kandidaten.oodm.service.SucheService;

@Service
public class SucheServiceImpl implements SucheService {

    @Override
    public Page<Kandidat> suchePerFormular(SearchForKandidat formular, Pageable pageable) {

        String queryStart = "select o from Kandidat as o ";

        String countQueryStart = "select count(o) from Kandidat as o ";

        String criteria = " WHERE ";

        boolean isFirst = true;

        if((formular.getVorname()!=null)&&(!formular.getVorname().isEmpty())){
            isFirst = false;
            criteria += " o.vorname LIKE '%"+formular.getVorname()+"%' ";
        }
        if((formular.getNachname()!=null)&&(!formular.getNachname().isEmpty())){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.nachname LIKE '%"+formular.getNachname()+"%' ";
        }
        if((formular.getGeschlecht()!=null)&&(!formular.getGeschlecht().isEmpty())){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            if(formular.getGeschlecht().compareTo("M")==0) {
                criteria += " o.geschlecht = 'M' ";
            }
            if(formular.getGeschlecht().compareTo("W")==0) {
                criteria += " o.geschlecht = 'W' ";
            }
        }
        if((formular.getMinGeburtsjahr()!=null)&&(!formular.getMinGeburtsjahr().isEmpty())){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.geburtsjahr >= "+formular.getMinGeburtsjahr()+" ";
        }
        if((formular.getMaxGeburtsjahr()!=null)&&(!formular.getMaxGeburtsjahr().isEmpty())){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.geburtsjahr <= "+formular.getMaxGeburtsjahr()+" ";
        }
        if((formular.getWohnort()!=null)&&(!formular.getWohnort().isEmpty())){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.wohnort.wohnort LIKE '%"+formular.getWohnort() +"%' ";
        }
        if((formular.getGeburtsort()!=null)&&(!formular.getGeburtsort().isEmpty())){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.geburtsort.geburtsort LIKE '%"+ formular.getGeburtsort() +"%' ";
        }
        if((formular.getBeruf()!=null)&&(!formular.getBeruf().isEmpty())){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.beruf.beruf LIKE '%"+formular.getBeruf() +"%' ";
        }
        if(formular.getBerufsgruppe()!=null){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.berufsgruppe.id = "+ formular.getBerufsgruppe().getId() +" ";
        }
        if(formular.getBundesland()!=null){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.bundesland.id = "+ formular.getBundesland().getId() +" ";
        }
        if(formular.getLandesListe()!=null){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.landesListe.id = "+ formular.getLandesListe().getId() +" ";
        }
        if(formular.getPartei()!=null){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.partei.id = "+ formular.getPartei().getId() +" ";
        }

        String query;
        String countQuery;
        if(isFirst) {
            query = queryStart;
            countQuery = countQueryStart;
        } else {
            query = queryStart + criteria;
            countQuery = countQueryStart + criteria;
        }

        log.info("query:      "+query);
        log.info("countQuery: "+countQuery);

        long counted = sucheRepository.countByJpaQueryStatement(countQuery);

        log.info("counted:    "+counted);

        return sucheRepository.findByJpaQueryStatement(query,counted,pageable);
    }

    private final SucheRepository sucheRepository;

    @Autowired
    public SucheServiceImpl(SucheRepository sucheRepository) {
        this.sucheRepository = sucheRepository;
    }

    private static final Logger log = LoggerFactory.getLogger(SucheServiceImpl.class);

}
