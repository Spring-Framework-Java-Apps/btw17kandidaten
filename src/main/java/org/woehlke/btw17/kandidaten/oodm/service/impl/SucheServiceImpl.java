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
        if((formular.getGeburtsjahrMin()!=null)&&(!formular.getGeburtsjahrMin().isEmpty())&&(formular.getGeburtsjahrMin().compareTo("0")!=0)){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.geburtsjahr >= "+ formular.getGeburtsjahrMin() +" ";
        }
        if((formular.getGeburtsjahrMax()!=null)&&(!formular.getGeburtsjahrMax().isEmpty())&&(formular.getGeburtsjahrMax().compareTo("0")!=0)){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.geburtsjahr <= "+ formular.getGeburtsjahrMax() +" ";
        }
        if((formular.getWohnort()!=null)&&(!formular.getWohnort().isEmpty())&&(formular.getGeburtsjahrMax().compareTo("0")!=0)){
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
        if((formular.getBerufsgruppe()!=null)&&(!formular.getBerufsgruppe().isEmpty())&&(formular.getBerufsgruppe().compareTo("0")!=0)){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.berufsgruppe.id = "+ formular.getBerufsgruppe() +" ";
        }
        if((formular.getBundesland()!=null)&&(!formular.getBundesland().isEmpty())&&(formular.getBundesland().compareTo("0")!=0)){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.bundesland.id = "+ formular.getBundesland() +" ";
        }
        if((formular.getLandesListe()!=null)&&(!formular.getLandesListe().isEmpty())&&(formular.getLandesListe().compareTo("0")!=0)){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.landesListe.id = "+ formular.getLandesListe() +" ";
        }
        if((formular.getPartei()!=null)&&(!formular.getPartei().isEmpty())&&(formular.getPartei().compareTo("0")!=0)){
            if(!isFirst){
                criteria += " AND ";
            } else {
                isFirst = false;
            }
            criteria += " o.partei.id = "+ formular.getPartei() +" ";
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
