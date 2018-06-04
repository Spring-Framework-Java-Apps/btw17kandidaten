package org.woehlke.btw17.kandidaten.oodm.jpa.model.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Berufsgruppe;

import javax.persistence.*;

public class BerufsgruppeListener {

    private static final Logger log = LoggerFactory.getLogger(BerufsgruppeListener.class);


    @PrePersist
    public void onPrePersist(Berufsgruppe domainObject) {
        log.debug("try to Persist: "+domainObject.getUniqueId());
        log.trace("try to Persist: "+domainObject.toString());
    }

    @PreUpdate
    public void onPreUpdate(Berufsgruppe domainObject) {
        log.debug("try to Update: "+domainObject.getUniqueId());
        log.trace("try to Update: "+domainObject.toString());
    }

    @PreRemove
    public void onPreRemove(Berufsgruppe domainObject) {
        log.debug("try to Remove: "+domainObject.getUniqueId());
        log.trace("try to Remove: "+domainObject.toString());
    }

    @PostPersist
    public void onPostPersist(Berufsgruppe domainObject) {
        log.debug("Persisted: "+domainObject.getUniqueId());
        log.trace("Persisted: "+domainObject.toString());
    }

    @PostUpdate
    public void onPostUpdate(Berufsgruppe domainObject) {
        log.debug("Updated: "+domainObject.getUniqueId());
        log.trace("Updated: "+domainObject.toString());
    }

    @PostRemove
    public void onPostRemove(Berufsgruppe domainObject) {
        log.debug("Removed: "+domainObject.getUniqueId());
        log.trace("Removed: "+domainObject.toString());
    }

    @PostLoad
    public void onPostLoad(Berufsgruppe domainObject) {
        log.debug("loaded: "+domainObject.getUniqueId());
        log.trace("loaded: "+domainObject.toString());
    }
}
