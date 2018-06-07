package org.woehlke.btw17.kandidaten.oodm.graph.services.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons.GraphDomainRepository;

import java.util.List;
import java.util.Optional;

@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public abstract class GraphDomainServiceImpl<T extends GraphDomainObject> implements GraphDomainService<T> {

    private final GraphDomainRepository<T> graphDomainRepository;

    protected GraphDomainServiceImpl(final GraphDomainRepository<T> graphDomainRepository){
        this.graphDomainRepository = graphDomainRepository;
    }

    protected GraphDomainRepository<T> getRepository(){
        return graphDomainRepository;
    }

    @Override
    public Page<T> getAll(Pageable pageRequest) {
        return graphDomainRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<T> getAll() {
        return graphDomainRepository.findAll();
    }

    @Override
    public long count() {
        return graphDomainRepository.count();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public void deleteAll() {
        graphDomainRepository.deleteAll();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public void delete(T domainObject) {
        graphDomainRepository.deleteAll();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public T create(T domainObject) {
        return graphDomainRepository.save(domainObject);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public T update(T domainObject) {
        return graphDomainRepository.save(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return graphDomainRepository.getAllIds();
    }

    @Override
    public Optional<T> findById(long id) {
        return graphDomainRepository.findById(id);
    }

    @Override
    public Long getMaxId() {
        return graphDomainRepository.getMaxId();
    }
}
