package org.woehlke.btw17.kandidaten.oodm.bundestag.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.bundestag.repositories.custom.MdbRepositoryCustom;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Repository
public class MdbRepositoryCustomImpl implements MdbRepositoryCustom {

    private final EntityManager entityManager;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MdbRepositoryCustomImpl(EntityManager entityManager, DataSource dataSource) {
        this.entityManager = entityManager;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
