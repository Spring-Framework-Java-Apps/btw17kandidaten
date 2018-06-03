package org.woehlke.btw17.kandidaten.oodm.db.model.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woehlke.btw17.kandidaten.oodm.db.model.Wahlperiode;

import javax.persistence.*;

public class WahlperiodeListener {

    private static final Logger log = LoggerFactory.getLogger(WahlperiodeListener.class);

    @PrePersist
    public void onPrePersist(Wahlperiode domainObject) {
        log.debug("try to Persist: "+domainObject.getUniqueId());
        log.trace("try to Persist: "+domainObject.toString());
    }

    @PreUpdate
    public void onPreUpdate(Wahlperiode domainObject) {
        log.debug("try to Update: "+domainObject.getUniqueId());
        log.trace("try to Update: "+domainObject.toString());
    }

    @PreRemove
    public void onPreRemove(Wahlperiode domainObject) {
        log.debug("try to Remove: "+domainObject.getUniqueId());
        log.trace("try to Remove: "+domainObject.toString());
    }

    @PostPersist
    public void onPostPersist(Wahlperiode domainObject) {
        log.debug("Persisted: "+domainObject.getUniqueId());
        log.trace("Persisted: "+domainObject.toString());
    }

    @PostUpdate
    public void onPostUpdate(Wahlperiode domainObject) {
        log.debug("Updated: "+domainObject.getUniqueId());
        log.trace("Updated: "+domainObject.toString());
    }

    @PostRemove
    public void onPostRemove(Wahlperiode domainObject) {
        log.debug("Removed: "+domainObject.getUniqueId());
        log.trace("Removed: "+domainObject.toString());
    }

    @PostLoad
    public void onPostLoad(Wahlperiode domainObject) {
        log.debug("loaded: "+domainObject.getUniqueId());
        log.trace("loaded: "+domainObject.toString());
    }
}
