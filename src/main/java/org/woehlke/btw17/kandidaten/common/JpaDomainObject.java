package org.woehlke.btw17.kandidaten.common;


public interface JpaDomainObject extends CommonDomainObject {

    Long getId();

    String getName();

    String getUniqueId();
}
