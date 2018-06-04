package org.woehlke.btw17.kandidaten.oodm.all.model.commons;

import java.io.Serializable;

public interface DomainObject extends Serializable {

    Long getId();

    String getName();

    String getUniqueId();
}
