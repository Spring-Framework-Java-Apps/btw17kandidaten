package org.woehlke.btw17.kandidaten.common;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.io.Serializable;

public abstract class GraphNodeServiceImpl<T extends Neo4jNode, ID extends Serializable> extends PagingAndSortingServiceImpl<T, ID> implements GraphNodeService<T, ID> {

    protected GraphNodeServiceImpl(Neo4jRepository<T,ID> repository){
        super(repository);
    }

    protected Neo4jRepository<T, ID> getRepository(){
        return (Neo4jRepository<T, ID>) super.getRepository();
    }
}
