package org.woehlke.btw17.kandidaten.oodm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import java.util.List;

public interface Btw17Service<T extends DomainObject> {

    Page<T> getAll(Pageable pageRequest);

    Iterable<T> getAll();

    long count();

    void deleteAll();

    void delete(T domainObject);

    T create(T domainObject);

    T update(T domainObject);

    List<Long> getAllIds();

    T findById(long id);

    long getMaxId();
}
