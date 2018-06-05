package org.woehlke.btw17.kandidaten.oodm.all.model.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DomainService<T extends DomainObject> {

    Page<T> getAll(Pageable pageRequest);

    Iterable<T> getAll();

    long count();

    void deleteAll();

    void delete(T domainObject);

    T create(T domainObject);

    T update(T domainObject);

    List<Long> getAllIds();

    Optional<T> findById(long id);

    Long getMaxId();
}
