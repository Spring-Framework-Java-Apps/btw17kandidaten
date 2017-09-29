package org.woehlke.btw17.kandidaten.oodm.model.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;

import javax.persistence.*;

public class KandidatListener {

    private static final Logger log = LoggerFactory.getLogger(KandidatListener.class);


    @PrePersist
    public void onPrePersist(Kandidat domainObject) {
        log.debug("try to Persist: "+domainObject.getUniqueId());
        log.trace("try to Persist: "+domainObject.toString());
        logInfos("try to Persist: ",domainObject);
    }

    @PostPersist
    public void onPostPersist(Kandidat domainObject) {
        log.debug("Persisted: "+domainObject.getUniqueId());
        log.trace("Persisted: "+domainObject.toString());
        logInfos("Persisted: ",domainObject);
    }

    @PreUpdate
    public void onPreUpdate(Kandidat domainObject) {
        log.debug("try to Update: "+domainObject.getUniqueId());
        log.trace("try to Update: "+domainObject.toString());
        logInfos("try to Update: ",domainObject);
    }

    @PostUpdate
    public void onPostUpdate(Kandidat domainObject) {
        log.debug("Updated: "+domainObject.getUniqueId());
        log.trace("Updated: "+domainObject.toString());
        logInfos("Updated: ",domainObject);
    }

    @PreRemove
    public void onPreRemove(Kandidat domainObject) {
        log.debug("try to Remove: "+domainObject.getUniqueId());
        log.trace("try to Remove: "+domainObject.toString());
        logInfos("try to Remove: ",domainObject);
    }

    @PostRemove
    public void onPostRemove(Kandidat domainObject) {
        log.debug("Removed: "+domainObject.getUniqueId());
        log.trace("Removed: "+domainObject.toString());
        logInfos("Removed: ",domainObject);
    }

    @PostLoad
    public void onPostLoad(Kandidat domainObject) {
        log.debug("loaded: "+domainObject.getUniqueId());
        log.trace("loaded: "+domainObject.toString());
        logInfos("loaded: ",domainObject);
    }

    private void logInfos(String msg, Kandidat kandidat){
        log.debug(msg+"*****************************************");
        log.debug(msg+"Kandidat: ");
        log.debug(msg+kandidat.getName());
        log.debug(msg+kandidat.getUniqueId());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Berufsgruppe:");
        if(kandidat.getBerufsgruppe() != null){
            log.debug(msg+kandidat.getBerufsgruppe().getName());
        } else {
            log.debug(msg+"kandidat.getBerufsgruppe() == null");
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Beruf:");
        log.debug(msg+kandidat.getBeruf().getName());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"CommonFields:");
        if(kandidat.getCommonFields() != null) {
            log.debug(msg+kandidat.getCommonFields().toString());
        } else {
            log.debug(msg+"kandidat.getCommonFields() == null");
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Geburtsort:");
        log.debug(msg+kandidat.getGeburtsort().getName());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Wohnort:");
        log.debug(msg+kandidat.getWohnort().getName());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Wahlkreis:");
        log.debug(msg+kandidat.getWahlkreis().getName());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Fraktion:");
        if(kandidat.getFraktion() != null){
            log.debug(msg+kandidat.getFraktion().getName());
        } else {
            log.debug(msg+"kandidat.getFraktion() == null");
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Webseite:");
        log.debug(msg+kandidat.getWebseite().getWebseite());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Adresse.Bundesland:");
        log.debug(msg+kandidat.getAdresse().getBundesland().getName());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Adresse:");
        log.debug(msg+kandidat.getAdresse().toString());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Ministerien:");
        for(Ministerium ministerium:kandidat.getMinisterien()){
            log.debug(msg+ministerium.getName());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Ausschuesse:");
        for(Ausschuss ausschuss:kandidat.getAusschuesse()){
            log.debug(msg+ausschuss.getName());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"kandidat.toString():");
        log.debug(msg+kandidat.toString());
        log.debug(msg+"*****************************************");
    }
}
