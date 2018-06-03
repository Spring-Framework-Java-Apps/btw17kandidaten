package org.woehlke.btw17.kandidaten.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @see Sort
 * @see Pageable
 * @see Page
 *
 * @param <T>
 * @param <ID>
 */
public interface PagingAndSortingService<T extends CommonDomainObject, ID extends Serializable> extends CrudService<T, ID> {

    /**
     * Returns all entities sorted by the given options.
     *
     * @param sort
     * @return all entities sorted by the given options
     */
    Iterable<T> findAll(Sort sort);

    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable
     * @return a page of entities
     */
    Page<T> findAll(Pageable pageable);
}
