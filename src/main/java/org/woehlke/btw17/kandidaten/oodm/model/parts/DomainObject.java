package org.woehlke.btw17.kandidaten.oodm.model.parts;

import org.woehlke.btw17.kandidaten.configuration.MySerializable;

public interface DomainObject extends MySerializable {

    Long getId();

    String getName();

    String getUniqueId();
}
