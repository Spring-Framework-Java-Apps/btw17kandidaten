package org.woehlke.btw17.kandidaten.oodm.all.model.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface JpaDomainService<T extends JpaDomainObject> extends DomainService<T> {

    Page<T> getAll(Pageable pageRequest);

    Iterable<T> getAll();

    long count();

    void deleteAll();

    void delete(T domainObject);

    T create(T domainObject);

    T update(T domainObject);

    List<Long> getAllIds();

    T findById(long id);

    Long getMaxId();
}
