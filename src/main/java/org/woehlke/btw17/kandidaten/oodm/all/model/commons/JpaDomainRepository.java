package org.woehlke.btw17.kandidaten.oodm.all.model.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface JpaDomainRepository<T extends JpaDomainObject> extends JpaRepository<T,Long>, DomainRepository<T> {

    List<Long> getAllIds();

    Long getMaxId();

}
