package org.woehlke.btw17.kandidaten.common;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public abstract class CrudServiceImpl<T extends CommonDomainObject, ID extends Serializable> extends CommonServiceImpl<T, ID> implements CrudService<T, ID> {

    protected CrudServiceImpl(CrudRepository<T, ID> repository){
        super(repository);
    }

    protected CrudRepository<T, ID> getRepository(){
        return (CrudRepository<T, ID>) super.getRepository();
    }

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }
}
