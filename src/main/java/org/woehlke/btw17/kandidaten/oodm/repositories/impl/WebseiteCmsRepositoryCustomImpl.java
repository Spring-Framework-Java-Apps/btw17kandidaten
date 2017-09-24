package org.woehlke.btw17.kandidaten.oodm.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WebseiteCmsRepositoryCustom;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Repository
public class WebseiteCmsRepositoryCustomImpl implements WebseiteCmsRepositoryCustom {

    private final EntityManager entityManager;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WebseiteCmsRepositoryCustomImpl(EntityManager entityManager, DataSource dataSource) {
        this.entityManager = entityManager;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
