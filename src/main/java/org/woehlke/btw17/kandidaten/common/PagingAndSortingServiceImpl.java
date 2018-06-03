package org.woehlke.btw17.kandidaten.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public abstract class PagingAndSortingServiceImpl<T extends CommonDomainObject, ID extends Serializable> extends CrudServiceImpl<T, ID> implements PagingAndSortingService<T, ID> {

    protected PagingAndSortingServiceImpl(PagingAndSortingRepository<T, ID> repository){
        super(repository);
    }

    protected PagingAndSortingRepository<T, ID> getRepository(){
        return (PagingAndSortingRepository<T, ID>) super.getRepository();
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }
}
