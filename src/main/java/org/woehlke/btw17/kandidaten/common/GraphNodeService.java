package org.woehlke.btw17.kandidaten.common;

import java.io.Serializable;

/**
 * Neo4j OGM specific extension of {@link org.springframework.data.repository.Repository}.
 */
public interface GraphNodeService<T extends JpaDomainObject, ID extends Serializable> extends PagingAndSortingService<T, ID> {
}
