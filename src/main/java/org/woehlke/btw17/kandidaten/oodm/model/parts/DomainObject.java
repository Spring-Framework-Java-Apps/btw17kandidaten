package org.woehlke.btw17.kandidaten.oodm.model.parts;


import java.io.Serializable;

public interface DomainObject extends Serializable {

    Long getId();

    String getName();

    String getUniqueId();
}
