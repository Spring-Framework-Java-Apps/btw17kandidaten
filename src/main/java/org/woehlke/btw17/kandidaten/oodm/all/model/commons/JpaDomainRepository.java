package org.woehlke.btw17.kandidaten.oodm.all.model.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaDomainRepository<T extends JpaDomainObject> extends JpaRepository<T,Long>, DomainRepository<T> {
}
