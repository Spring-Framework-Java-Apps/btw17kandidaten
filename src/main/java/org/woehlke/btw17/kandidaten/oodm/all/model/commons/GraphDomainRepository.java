package org.woehlke.btw17.kandidaten.oodm.all.model.commons;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface GraphDomainRepository<T extends GraphDomainObject> extends Neo4jRepository<T,Long>, DomainRepository<T> {

    List<Long> getAllIds();

    Long getMaxId();

}
