package org.woehlke.btw17.kandidaten.common;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Extension of {@link CrudRepository} to provide additional methods to retrieve entities using the pagination and
 * sorting abstraction.
 *
 * @param <T>
 * @param <ID>
 */
public interface CrudService<T extends CommonDomainObject, ID extends Serializable> extends CommonService<T, ID> {

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    Iterable<T> findAll();
}
