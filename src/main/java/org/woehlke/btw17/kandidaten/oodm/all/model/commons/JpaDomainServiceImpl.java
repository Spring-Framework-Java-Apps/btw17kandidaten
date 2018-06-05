package org.woehlke.btw17.kandidaten.oodm.all.model.commons;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public abstract class JpaDomainServiceImpl<T extends JpaDomainObject> implements JpaDomainService<T> {

    private final JpaDomainRepository<T> jpaDomainRepository;

    protected JpaDomainServiceImpl(final JpaDomainRepository<T> jpaDomainRepository){
        this.jpaDomainRepository = jpaDomainRepository;
    }

    protected JpaDomainRepository<T> getRepository(){
        return jpaDomainRepository;
    }

    @Override
    public Page<T> getAll(Pageable pageRequest) {
        return jpaDomainRepository.findAll(pageRequest);
    }

    @Override
    public Iterable<T> getAll() {
        return jpaDomainRepository.findAll();
    }

    @Override
    public long count() {
        return jpaDomainRepository.count();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public void deleteAll() {
        jpaDomainRepository.deleteAll();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public void delete(T domainObject) {
        jpaDomainRepository.deleteAll();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public T create(T domainObject) {
        return jpaDomainRepository.saveAndFlush(domainObject);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
    public T update(T domainObject) {
        return jpaDomainRepository.saveAndFlush(domainObject);
    }

    @Override
    public List<Long> getAllIds() {
        return jpaDomainRepository.getAllIds();
    }

    @Override
    public Optional<T> findById(long id) {
        return jpaDomainRepository.findById(id);
    }

    @Override
    public Long getMaxId() {
        return jpaDomainRepository.getMaxId();
    }
}
