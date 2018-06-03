package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.btw17.kandidaten.oodm.db.model.commons.JpaDomainObject;

import java.util.List;


public interface Btw17Service<T extends JpaDomainObject> {

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
