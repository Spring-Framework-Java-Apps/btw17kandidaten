package org.woehlke.btw17.kandidaten.oodm.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.repositories.SucheRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class SucheRepositoryImpl implements SucheRepository {


    private final EntityManager entityManager;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SucheRepositoryImpl(EntityManager entityManager, DataSource dataSource) {
        this.entityManager = entityManager;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Page<Kandidat> findByJpaQueryStatement(String query, long total, Pageable pageable) {
        TypedQuery<Kandidat> searchQuery = entityManager.createQuery(query,Kandidat.class);
        int firstResult = (int) pageable.getOffset();
        searchQuery.setFirstResult(firstResult);
        searchQuery.setMaxResults(pageable.getPageSize());
        List<Kandidat> content = searchQuery.getResultList();
        Page<Kandidat> pageKandidat = new PageImpl<>(content, pageable, total);
        return pageKandidat;
    }

    @Override
    public long countByJpaQueryStatement(String query) {
        TypedQuery<Long> countQuery = entityManager.createQuery(query,Long.class);
        return countQuery.getSingleResult();
    }
}
