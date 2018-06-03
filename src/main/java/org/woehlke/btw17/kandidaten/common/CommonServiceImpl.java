package org.woehlke.btw17.kandidaten.common;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

public abstract class CommonServiceImpl<T extends CommonDomainObject, ID extends Serializable> implements CommonService<T, ID>  {

    private Repository<T, ID> repository;

    protected CommonServiceImpl(Repository<T, ID> repository){
        this.repository=repository;
    }

    protected Repository<T, ID> getRepository(){
        return this.repository;
    }
}
