package org.woehlke.btw17.kandidaten.common;

import java.io.Serializable;

public interface JpaService<T extends JpaDomainObject, ID extends Serializable> extends PagingAndSortingService<T, ID> {

}
