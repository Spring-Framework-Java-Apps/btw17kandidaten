package org.woehlke.btw17.kandidaten.oodm.jpa.model.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Bundesland;

import javax.persistence.*;

public class BundeslandListener {

    private static final Logger log = LoggerFactory.getLogger(BundeslandListener.class);



    @PrePersist
    public void onPrePersist(Bundesland domainObject) {
        log.debug("try to Persist: "+domainObject.getUniqueId());
        log.trace("try to Persist: "+domainObject.toString());
    }

    @PreUpdate
    public void onPreUpdate(Bundesland domainObject) {
        log.debug("try to Update: "+domainObject.getUniqueId());
        log.trace("try to Update: "+domainObject.toString());
    }

    @PreRemove
    public void onPreRemove(Bundesland domainObject) {
        log.debug("try to Remove: "+domainObject.getUniqueId());
        log.trace("try to Remove: "+domainObject.toString());
    }

    @PostPersist
    public void onPostPersist(Bundesland domainObject) {
        log.debug("Persisted: "+domainObject.getUniqueId());
        log.trace("Persisted: "+domainObject.toString());
    }

    @PostUpdate
    public void onPostUpdate(Bundesland domainObject) {
        log.debug("Updated: "+domainObject.getUniqueId());
        log.trace("Updated: "+domainObject.toString());
    }

    @PostRemove
    public void onPostRemove(Bundesland domainObject) {
        log.debug("Removed: "+domainObject.getUniqueId());
        log.trace("Removed: "+domainObject.toString());
    }

    @PostLoad
    public void onPostLoad(Bundesland domainObject) {
        log.debug("loaded: "+domainObject.getUniqueId());
        log.trace("loaded: "+domainObject.toString());
    }
}
