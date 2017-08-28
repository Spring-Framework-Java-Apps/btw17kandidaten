package org.woehlke.btw17.kandidaten.oodm.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.repositories.custom.WahlkreisRepositoryCustom;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Repository
public class WahlkreisRepositoryCustomImpl implements WahlkreisRepositoryCustom {

    private final EntityManager entityManager;

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public WahlkreisRepositoryCustomImpl(EntityManager entityManager, DataSource dataSource) {
        this.entityManager = entityManager;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
