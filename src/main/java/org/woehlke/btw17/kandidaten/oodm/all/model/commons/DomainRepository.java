package org.woehlke.btw17.kandidaten.oodm.all.model.commons;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DomainRepository<T extends DomainObject> {
}
